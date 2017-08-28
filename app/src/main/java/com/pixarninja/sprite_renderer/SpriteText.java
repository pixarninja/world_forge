package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.LinkedHashMap;

public class SpriteText extends SpriteEntity {

    private long lastFrameChangeTime;
    private Sprite text;
    private Sprite render;


    public SpriteText(Resources res, double percentOfScreen, int width, int height, int xRes, int yRes, int textID,
                      double xDelta, double yDelta, boolean isMoving, double xPos, double yPos,
                      int xFrameCount, int yFrameCount, int frameCount, double xDimension, double yDimension,
                      double left, double top, double right, double bottom, String method) {

        int frameWidth;
        int frameHeight;
        int spriteWidth;
        int spriteHeight;
        double frameScale;

        /* initialize sprites that will be rendered in the scene */
        Bitmap textImage = decodeSampledBitmapFromResource(res, textID, xRes, yRes);
        frameWidth = textImage.getWidth() / xFrameCount;
        frameHeight = textImage.getHeight() / yFrameCount;
        frameScale = height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 2) - (spriteHeight / 2);
        this.text = new Sprite(xDelta, yDelta, isMoving, textImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        updateView(text, text);
        render = text;

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
                    updateView(render, text);
                    render = text;
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
        if(touched) {
            if (render != null) {
                RectF boundingBox = this.render.getBoundingBox();
                if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                    /* center of the sprite */
                    if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                        updateView(this.render, text);
                        this.render = text;
                    }
                }
            }
        }
    }

}