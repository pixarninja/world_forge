package com.pixarninja.sprite_renderer;

import android.graphics.RectF;

import java.util.LinkedHashMap;

public class SpriteCharacter extends SpriteEntity {

    protected volatile boolean reacting;

    @Override
    public void updateView() {

        controller.setXPos(controller.getXPos() + controller.getXDelta());
        controller.setYPos(controller.getYPos() + controller.getYDelta());
        updateBoundingBox();

    }

    @Override
    public void updateBoundingBox() {

        /* find percentage to place from the center outwards */
        float left = (float) (render.getXDimension() / 2 - render.getLeft()) / (float) render.getXDimension();
        float top = (float) (render.getYDimension() / 2 - render.getTop()) / (float) render.getYDimension();
        float right = (float) (render.getRight() - render.getXDimension() / 2) / (float) render.getXDimension();
        float bottom = (float) (render.getBottom() - render.getYDimension() / 2) / (float) render.getYDimension();

        /* centerOfBoundingBox = centerOfSprite - centerOfScreen */
        RectF position = render.getWhereToDraw();
        render.setBoundingBox(new RectF(
                position.centerX() - (position.width() * left),
                position.centerY() - (position.height() * top),
                position.centerX() + (position.width() * right),
                position.centerY() + (position.height() * bottom)
        ));

    }

    @Override
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteController> entry, LinkedHashMap<String, SpriteController> controllerMap, boolean touched, float xTouchedPos, float yTouchedPos) {
        if(touched && !reacting) {
            RectF boundingBox = render.getBoundingBox();
            if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                /* center of the sprite */
                if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                    refreshCharacter("center");
                    updateView();
                    reacting = true;
                }
                /* top of the sprite */
                else if (yTouchedPos < boundingBox.top) {
                    refreshCharacter("top");
                    updateView();
                    reacting = true;
                }
                /* bottom of the sprite */
                else if (yTouchedPos > boundingBox.bottom) {
                    refreshCharacter("bottom");
                    updateView();
                    reacting = true;
                }
            }
            else if (xTouchedPos < boundingBox.left) {
                /* left side of the sprite */
                if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                    refreshCharacter("left");
                    updateView();
                    reacting = true;
                }
                    /* top left side of the sprite */
                else if (yTouchedPos < boundingBox.top) {
                    refreshCharacter("top left");
                    updateView();
                    reacting = true;
                }
                    /* bottom right side of the sprite */
                else if (yTouchedPos > boundingBox.bottom) {
                    refreshCharacter("bottom right");
                    updateView();
                    reacting = true;
                }
            }
            /* right side of the sprite */
            else if (xTouchedPos > boundingBox.right) {
                /* right side of the screen */
                if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                    refreshCharacter("right");
                    updateView();
                    reacting = true;
                }
                    /* top right side of the sprite */
                else if (yTouchedPos < boundingBox.top) {
                    refreshCharacter("top right");
                    updateView();
                    reacting = true;
                }
                    /* bottom right side of the sprite */
                else if (yTouchedPos > boundingBox.bottom) {
                    refreshCharacter("bottom right");
                    updateView();
                    reacting = true;
                }
            }
            SpriteThread spriteThread = new SpriteThread(spriteView);
            spriteThread.setRunning(true);
            spriteThread.start();
            spriteView.setSpriteThread(spriteThread);
        }
    }

}