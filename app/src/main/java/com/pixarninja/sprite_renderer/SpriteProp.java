package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RectF;

import java.util.LinkedHashMap;

public class SpriteProp extends SpriteEntity {

    private Sprite prop;
    private Sprite render;


    public SpriteProp(Resources res, double percentOfScreen, int width, int height, int xRes, int yRes, int propID,
                        double xDelta, double yDelta, boolean isMoving, double xPos, double yPos,
                        int xFrameCount, int yFrameCount, int frameCount, double xDimension, double yDimension,
                        double left, double top, double right, double bottom, String method) {

        int frameWidth;
        int frameHeight;
        int spriteWidth;
        int spriteHeight;
        double frameScale;

        /* initialize sprites that will be rendered in the scene */
        Bitmap propImage = decodeSampledBitmapFromResource(res, propID, xRes, yRes);
        frameWidth = propImage.getWidth() / xFrameCount;
        frameHeight = propImage.getHeight() / yFrameCount;
        frameScale = height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 2) - (spriteHeight / 2);
        this.prop = new Sprite(xDelta, yDelta, isMoving, propImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        updateView(prop, prop);
        render = prop;

    }

    @Override
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteEntity> entry, LinkedHashMap<String, SpriteEntity> entity, LinkedHashMap<String, SpriteEntity> render, boolean touched, float xTouchedPos, float yTouchedPos) {
        if(touched) {
            if (render != null) {
                RectF boundingBox = this.render.getBoundingBox();
                if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                    /* center of the sprite */
                    if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                        updateView(this.render, prop);
                        this.render = prop;
                    }
                }
            }
        }
    }

}