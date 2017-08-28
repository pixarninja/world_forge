package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.LinkedHashMap;

public class SpriteAnimatedButton extends SpriteEntity {

    private volatile boolean reacting;
    private String state;
    private long lastFrameChangeTime;
    private Sprite on;
    private Sprite off;
    private Sprite poked;
    private Sprite render;


    public SpriteAnimatedButton(Resources res, double percentOfScreen, int width, int height, int xRes, int yRes, int onID, int offID, int pokedID,
                          double xDelta, double yDelta, boolean isMoving, double xPos, double yPos,
                          int xFrameCount, int yFrameCount, int frameCount, double xDimension, double yDimension,
                          double left, double top, double right, double bottom, String method) {

        int frameHeight;
        double frameScale;

        /* initialize sprites that will be rendered in the scene */
        Bitmap onImage = decodeSampledBitmapFromResource(res, onID, xRes, yRes);
        frameHeight = onImage.getHeight() / yFrameCount;
        frameScale = height * percentOfScreen / frameHeight;
        this.on = new Sprite(xDelta, yDelta, isMoving, onImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        Bitmap offImage = decodeSampledBitmapFromResource(res, offID, xRes, yRes);
        frameHeight = offImage.getHeight() / yFrameCount;
        frameScale = height * percentOfScreen / frameHeight;
        this.off = new Sprite(xDelta, yDelta, isMoving, offImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        Bitmap pokedImage = decodeSampledBitmapFromResource(res, pokedID, xRes, yRes);
        frameHeight = offImage.getHeight() / yFrameCount;
        frameScale = height * percentOfScreen / frameHeight;
        this.poked = new Sprite(xDelta, yDelta, isMoving, pokedImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        updateView(off, off);
        render = off;
    }

    @Override
    public void getCurrentFrame(Sprite sprite){

        long time  = System.currentTimeMillis();
        if ( time > lastFrameChangeTime + frameLengthInMilliseconds) {

            lastFrameChangeTime = time;
            sprite.setCurrentFrame(sprite.getCurrentFrame() + 1);
            sprite.setXCurrentFrame(sprite.getXCurrentFrame() + 1);
            if ((sprite.getXCurrentFrame() >= sprite.getXFrameCount()) || (sprite.getCurrentFrame() >= sprite.getFrameCount())) {
                sprite.setYCurrentFrame(sprite.getYCurrentFrame() + 1);
                if ((sprite.getYCurrentFrame() >= sprite.getYFrameCount()) || (sprite.getCurrentFrame() >= sprite.getFrameCount())) {
                    sprite.setYCurrentFrame(0);
                    sprite.setCurrentFrame(0);
                    if(state == "on") {
                        reacting = false;
                        updateView(render, off);
                        render = off;
                    }
                    else if(state == "poked") {
                        updateView(render, poked);
                        render = poked;
                    }
                    else {
                        reacting = false;
                        updateView(render, on);
                        render = on;
                    }
                }
                sprite.setXCurrentFrame(0);
            }

        }

        /* update the next frame from the spritesheet that will be drawn */
        Rect rect = new Rect();
        rect.left = sprite.getXCurrentFrame() * sprite.getFrameWidth();
        rect.right = rect.left + sprite.getFrameWidth();
        rect.top = sprite.getYCurrentFrame() * sprite.getFrameHeight();
        rect.bottom = rect.top + sprite.getFrameHeight();
        sprite.setFrameToDraw(rect);

    }

    @Override
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteEntity> entry, LinkedHashMap<String, SpriteEntity> entity, LinkedHashMap<String, SpriteEntity> render, boolean touched, float xTouchedPos, float yTouchedPos) {
        if(touched && !reacting) {
            if (render != null) {
                RectF boundingBox = this.render.getBoundingBox();
                if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                    /* center of the sprite */
                    if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                        if(state == "on") {
                            state = "off";
                            updateView(this.render, off);
                            this.render = off;
                        }
                        else {
                            reacting = true;
                            state = "poked";
                            updateView(this.render, poked);
                            this.render = poked;
                        }
                    }
                }
            }
        }
    }

}
