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
                spriteThread.setRunning(true);
                spriteThread.start();
            }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {}

        });

    }

    protected void drawSprite() {

        Canvas canvas = getHolder().lockCanvas();

        if(canvas != null){
            synchronized (getHolder()) {
                /* refresh scene */
                canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);

                /* render scene */
                if(controllerMap != null) {
                    for (LinkedHashMap.Entry<String, SpriteController> entry : controllerMap.entrySet()) {
                        SpriteController controller = entry.getValue();
                        SpriteEntity entity = controller.getEntity();
                        if(entity != null) {
                            if (entity.getMessage() != null) {
                                Sprite sprite = entity.getSprite();
                                canvas.drawText(entity.getMessage(), (float) controller.getXPos(), (float) controller.getYPos(), null);
                            } else {
                                Sprite sprite = entity.getSprite();
                                RectF rectF = new RectF();
                                rectF.set((int) controller.getXPos(), (int) controller.getYPos(), (int) controller.getXPos() + sprite.getSpriteWidth(), (int) controller.getYPos() + sprite.getSpriteHeight());
                                sprite.setWhereToDraw(rectF);
                                entity.getCurrentFrame();
                                canvas.drawBitmap(sprite.getSpriteSheet(), sprite.getFrameToDraw(), sprite.getWhereToDraw(), null);
                            }
                        }
                    }
                }
            }
            getHolder().unlockCanvasAndPost(canvas);
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
                    //System.out.println("Entry Frame Rate: " + entry.getValue().getFrameRate());
                    entry.getValue().getEntity().onTouchEvent(this, entry, controllerMap, touched, xTouchedPos, yTouchedPos);
                }
            }
        }

        return true;
    }

}