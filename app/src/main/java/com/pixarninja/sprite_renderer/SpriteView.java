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

    public LinkedHashMap<String, SpriteEntity> entity;
    public LinkedHashMap<String, SpriteEntity> render;
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

    public LinkedHashMap<String, SpriteEntity> getEntity() { return this.entity; }
    public void setEntity(LinkedHashMap<String, SpriteEntity> entity) { this.entity = entity; }

    public LinkedHashMap<String, SpriteEntity> getRender() { return this.render; }
    public void setRender(LinkedHashMap<String, SpriteEntity> render) { this.render = render; }

    public SpriteThread getSpriteThread() { return this.spriteThread; }
    public void setSpriteThread(SpriteThread spriteThread) { this.spriteThread = spriteThread; }

    public int getFrameRate() {
        if(entity != null) {
            for (LinkedHashMap.Entry<String, SpriteEntity> entry : entity.entrySet()) {
                if (entry.getValue() != null) {
                    return entry.getValue().getFrameRate();
                }
            }
        }
        return 1000;
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
                for (LinkedHashMap.Entry<String, SpriteEntity> entry : render.entrySet()) {
                    if (entry != null) {
                        if (entry.getValue().getMessage() != null) {
                            Sprite sprite = entry.getValue().getSprite();
                            canvas.drawText(entry.getValue().getMessage(), (float)sprite.getXPos(), (float)sprite.getYPos(), null);
                        }
                        else {
                            Sprite sprite = entry.getValue().getSprite();
                            RectF rectF = new RectF();
                            rectF.set((int) sprite.getXPos(), (int) sprite.getYPos(), (int) sprite.getXPos() + sprite.getSpriteWidth(), (int) sprite.getYPos() + sprite.getSpriteHeight());
                            sprite.setWhereToDraw(rectF);
                            entry.getValue().getCurrentFrame(sprite);
                            canvas.drawBitmap(sprite.getSpriteSheet(), sprite.getFrameToDraw(), sprite.getWhereToDraw(), null);
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
        if (entity != null && touched) {
            for (LinkedHashMap.Entry<String, SpriteEntity> entry : render.entrySet()) {
                if(entry != null) {
                    System.out.println("Entry Frame Rate: " + entry.getValue().getFrameRate());
                    entry.getValue().onTouchEvent(this, entry, entity, render, touched, xTouchedPos, yTouchedPos);
                }
            }
        }

        return true;
    }

}