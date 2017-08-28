package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.LinkedHashMap;

abstract class SpriteEntity {

    protected long lastFrameChangeTime;
    protected int frameLengthInMilliseconds;
    protected Sprite render;
    protected String message;

    protected SpriteController controller;

    public Sprite getSprite() { return this.render; }
    public void setSprite(Sprite sprite) { this.render = sprite; }

    public int getFrameRate() { return this.frameLengthInMilliseconds; }
    public void setFrameRate(int frameLengthInMilliseconds) { this.frameLengthInMilliseconds = frameLengthInMilliseconds; }

    public String getMessage() { return this.message; }
    public void setMessage(String message) { this.message = message; }

    public SpriteController getController() { return this.controller; }
    public void setController(SpriteController controller) { this.controller = controller; }

    protected static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        /* decode with inJustDecodeBounds=true to check dimensions */
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        /* calculate inSampleSize */
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        /* decode bitmap with inSampleSize set */
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);

    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

        /* raw height and width of image */
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            /* calculate the largest inSampleSize value that is a power of 2 and keeps both
               height and width larger than the requested height and width. */
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;

    }

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
        updateBoundingBox(after);

    }

    public void updateBoundingBox(Sprite sprite) {

        /* find percentage to place from the center outwards */
        float left = (float) (sprite.getXDimension() / 2 - sprite.getLeft()) / (float) sprite.getXDimension();
        float top = (float) (sprite.getYDimension() / 2 - sprite.getTop()) / (float) sprite.getYDimension();
        float right = (float) (sprite.getRight() - sprite.getXDimension() / 2) / (float) sprite.getXDimension();
        float bottom = (float) (sprite.getBottom() - sprite.getYDimension() / 2) / (float) sprite.getYDimension();

        /* centerOfBoundingBox = centerOfSprite - centerOfScreen */
        RectF position = sprite.getWhereToDraw();
        sprite.setBoundingBox(new RectF(
                position.centerX() - (position.width() * left),
                position.centerY() - (position.height() * top),
                position.centerX() + (position.width() * right),
                position.centerY() + (position.height() * bottom)
        ));

    }

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
                    updateView(render, sprite);
                    render = sprite;
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

    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteEntity> entry, LinkedHashMap<String, SpriteEntity> entity, LinkedHashMap<String, SpriteEntity> render, boolean touched, float xTouchedPos, float yTouchedPos) {}

}