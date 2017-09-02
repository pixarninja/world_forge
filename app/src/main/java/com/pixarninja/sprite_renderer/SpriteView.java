package com.pixarninja.sprite_renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.LinkedHashMap;

public class SpriteView extends SurfaceView {

    public LinkedHashMap<String, SpriteController> controllerMap;
    public volatile boolean touched = false;
    public volatile float xTouchedPos;
    public volatile float yTouchedPos;
    private SpriteThread spriteThread;


    public SpriteView(Context context) {
        super(context);

        initView();

    }

    public SpriteView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView();

    }

    public SpriteView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initView();

    }

    public LinkedHashMap<String, SpriteController> getControllerMap() { return this.controllerMap; }
    public void setControllerMap(LinkedHashMap<String, SpriteController> controllerMap) { this.controllerMap = controllerMap; }

    public SpriteThread getSpriteThread() { return this.spriteThread; }
    public void setSpriteThread(SpriteThread spriteThread) { this.spriteThread = spriteThread; }

    public int getFrameRate() {
        if(controllerMap != null) {
            for (LinkedHashMap.Entry<String, SpriteController> entry : controllerMap.entrySet()) {
                return entry.getValue().getFrameRate();
            }
        }
        return 35;
    }

    private void initView(){

        /* start thread */
        spriteThread = new SpriteThread(this);
        setZOrderOnTop(true);
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.setFormat(PixelFormat.TRANSLUCENT);
        surfaceHolder.addCallback(new SurfaceHolder.Callback(){

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                /*if (!spriteThread.isAlive()) {
                    spriteThread.start();
                }
                spriteThread.setRunning(true);*/
            }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                boolean retry = true;
                spriteThread.setRunning(false);
                while (retry) {
                    try {
                        spriteThread.join();
                        retry = false;
                    } catch (InterruptedException e) {
                    }
                }
            }

        });

    }

    public void onResume(){
        spriteThread = new SpriteThread(this);
        spriteThread.setRunning(true);
        spriteThread.start();
    }

    public void onPause(){
        spriteThread.setRunning(false);
        boolean retry = true;
        while(retry){
            try {
                spriteThread.join();
                spriteThread.setRunning(true);
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void drawSprite() {

        Canvas canvas;

        try {
            canvas = getHolder().lockCanvas();
        } catch(IllegalStateException e) {
            return;
        }

        if(canvas != null && spriteThread.getRunning()){
            synchronized (getHolder()) {
                /* refresh scene */
                canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);

                /* render scene */
                if(controllerMap != null) {
                    for (LinkedHashMap.Entry<String, SpriteController> entry : controllerMap.entrySet()) {
                        SpriteController controller = entry.getValue();
                        SpriteEntity entity = controller.getEntity();
                        entity.updateView();
                        if (entity.getMessage() != null) {
                            canvas.drawText(entity.getMessage(), (float) controller.getXPos(), (float) controller.getYPos(), null);
                        } else {
                            Sprite sprite = entity.getSprite();
                            if(sprite.getSpriteSheet() == null || sprite.getFrameToDraw() == null || sprite.getWhereToDraw() == null) {
                                //sprite.printSprite();
                            }
                            else {
                                canvas.drawBitmap(sprite.getSpriteSheet(), sprite.getFrameToDraw(), sprite.getWhereToDraw(), null);
                            }
                        }
                    }
                }
            }
        }
        try {
            getHolder().unlockCanvasAndPost(canvas);
        } catch(IllegalStateException e) {
            return;
        } catch(IllegalArgumentException e) {
            return;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        xTouchedPos = event.getX();
        yTouchedPos = event.getY();

        int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                //System.out.println("DOWN -- X: " + xTouchedPos + ", Y: " + yTouchedPos);
                touched = true;
                break;
            case MotionEvent.ACTION_MOVE:
                //System.out.println("MOVED -- X: " + xTouchedPos + ", Y: " + yTouchedPos);
                //touched = true;
                touched = false;
                break;
            case MotionEvent.ACTION_UP:
                //System.out.println("LIFT -- X: " + xTouchedPos + ", Y: " + yTouchedPos);
                touched = false;
                break;
            case MotionEvent.ACTION_CANCEL:
                touched = false;
                break;
            case MotionEvent.ACTION_OUTSIDE:
                touched = false;
                break;
            default:
        }
        if (controllerMap != null && touched) {
            for (LinkedHashMap.Entry<String, SpriteController> entry : controllerMap.entrySet()) {
                if(entry.getValue().getEntity() != null) {
                    entry.getValue().getEntity().onTouchEvent(this, entry, controllerMap, touched, xTouchedPos, yTouchedPos);
                }
            }
            /* for debugging purposes
            for (LinkedHashMap.Entry<String, SpriteController> entry : controllerMap.entrySet()) {
                if(entry.getValue().getEntity() != null) {
                    entry.getValue().printController();
                }
            }*/
        }

        return true;
    }

}