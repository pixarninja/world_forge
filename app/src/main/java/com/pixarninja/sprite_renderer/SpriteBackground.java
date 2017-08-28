package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;

public class SpriteBackground extends SpriteEntity {

    private long lastFrameChangeTime;
    private Sprite prop;
    private int xInit;
    private int yInit;


    public SpriteBackground(Resources res, double percentOfScreen, int width, int height, int xRes, int yRes, int propID,
                      double xDelta, double yDelta, boolean isMoving, int xInit, int yInit,
                      int xFrameCount, int yFrameCount, int frameCount, double xDimension, double yDimension,
                      double left, double top, double right, double bottom, String method) {

        this.xInit = xInit;
        this.yInit = yInit;
        int frameHeight;
        double frameScale;

        /* initialize sprites that will be rendered in the scene */
        Bitmap propImage = decodeSampledBitmapFromResource(res, propID, xRes, yRes);
        frameHeight = propImage.getHeight() / yFrameCount;
        frameScale = height * percentOfScreen / frameHeight;
        this.prop = new Sprite(xDelta, yDelta, isMoving, propImage, xInit, yInit, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        updateView(prop, prop);
        render = prop;

    }

    @Override
    public void setSprite(Sprite sprite) {
        this.render = sprite;
        this.prop = sprite;
    }

    @Override
    public void updateView(Sprite before, Sprite after) {

        if(before != after) {
            after.setXDelta(before.getXDelta());
            after.setYDelta(before.getYDelta());
            after.setIsMoving(before.getIsMoving());
            after.setXPos(before.getXPos());
            after.setYPos(before.getYPos());
        }
        after.setXCurrentFrame(0);
        after.setYCurrentFrame(0);
        after.setCurrentFrame(0);

        if(after.getIsMoving()) {
            after.setXPos(after.getXPos() + after.getXDelta());
            after.setYPos(after.getYPos() + after.getYDelta());
            if(after.getXDelta() < 0) {
                if(after.getYDelta() < 0) {
                    if ((after.getXPos() <= (this.xInit - (after.getSpriteWidth() / 10))) || (after.getYPos() <= (this.yInit - (after.getSpriteHeight() / 10)))) {
                        after.setXPos(this.xInit);
                        after.setYPos(this.yInit);
                    }
                }
                else {
                    if ((after.getXPos() <= (this.xInit - (after.getSpriteWidth() / 10))) || (after.getYPos() >= (this.yInit + (after.getSpriteHeight() / 10)))) {
                        after.setXPos(this.xInit);
                        after.setYPos(this.yInit);
                    }
                }
            }
            else {
                if(after.getYDelta() < 0) {
                    if ((after.getXPos() <= (this.xInit - (after.getSpriteWidth() / 10))) || (after.getYPos() >= (this.yInit + (after.getSpriteHeight() / 10)))) {
                        after.setXPos(this.xInit);
                        after.setYPos(this.yInit);
                    }
                }
                else {
                    if ((after.getXPos() >= (this.xInit + (after.getSpriteWidth() / 10))) || (after.getYPos() >= (this.yInit + (after.getSpriteHeight() / 10)))) {
                        after.setXPos(this.xInit);
                        after.setYPos(this.yInit);
                    }
                }
            }
        }
        updateBoundingBox(after);

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
                    updateView(render, prop);
                    render = prop;
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

}