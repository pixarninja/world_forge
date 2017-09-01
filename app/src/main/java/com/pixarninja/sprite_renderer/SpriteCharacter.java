package com.pixarninja.sprite_renderer;

import android.graphics.RectF;

import java.util.LinkedHashMap;

public class SpriteCharacter extends SpriteEntity {

    int count;
    int delta;

    public int getCount() { return this.count; }
    public void setCount(int count) { this.count = count; }

    public int getDelta() { return this.delta; }
    public void setDelta(int delta) { this.delta = delta; }

    @Override
    public void updateView() {

        controller.setXPos(controller.getXPos() + controller.getXDelta());
        controller.setYPos(controller.getYPos() + controller.getYDelta());
        getCurrentFrame();
        updateBoundingBox();

    }

    @Override
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteController> entry, LinkedHashMap<String, SpriteController> controllerMap, boolean touched, float xTouchedPos, float yTouchedPos) {
        if(touched && !controller.getReacting()) {
            RectF boundingBox = render.getBoundingBox();
            if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                /* center of the sprite */
                if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                    refreshCharacter("center");
                    updateView();
                    controller.setReacting(true);
                }
                /* top of the sprite */
                else if (yTouchedPos < boundingBox.top) {
                    refreshCharacter("top");
                    updateView();
                    controller.setReacting(true);
                }
                /* bottom of the sprite */
                else if (yTouchedPos > boundingBox.bottom) {
                    refreshCharacter("bottom");
                    updateView();
                    controller.setReacting(true);
                }
            }
            else if (xTouchedPos < boundingBox.left) {
                /* left side of the sprite */
                if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                    refreshCharacter("left");
                    updateView();
                    controller.setReacting(true);
                }
                    /* top left side of the sprite */
                else if (yTouchedPos < boundingBox.top) {
                    refreshCharacter("topLeft");
                    updateView();
                    controller.setReacting(true);
                }
                    /* bottom right side of the sprite */
                else if (yTouchedPos > boundingBox.bottom) {
                    refreshCharacter("bottomLeft");
                    updateView();
                    controller.setReacting(true);
                }
            }
            /* right side of the sprite */
            else if (xTouchedPos > boundingBox.right) {
                /* right side of the screen */
                if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                    refreshCharacter("right");
                    updateView();
                    controller.setReacting(true);
                }
                    /* top right side of the sprite */
                else if (yTouchedPos < boundingBox.top) {
                    refreshCharacter("topRight");
                    updateView();
                    controller.setReacting(true);
                }
                    /* bottom right side of the sprite */
                else if (yTouchedPos > boundingBox.bottom) {
                    refreshCharacter("bottomRight");
                    updateView();
                    controller.setReacting(true);
                }
            }
        }
    }

}