package com.pixarninja.sprite_renderer;

import android.graphics.RectF;

import java.util.LinkedHashMap;

public class SpriteCharacter extends SpriteEntity {

    protected volatile boolean reacting;
    protected long lastFrameChangeTime;
    protected int delta;
    protected int count;
    protected Sprite center;
    protected Sprite left;
    protected Sprite topLeft;
    protected Sprite top;
    protected Sprite topRight;
    protected Sprite right;
    protected Sprite bottomRight;
    protected Sprite bottom;
    protected Sprite bottomLeft;
    protected Sprite idle;
    protected boolean lock;

    @Override
    public void updateView(Sprite before, Sprite after) {

        if(before != after) {
            if(!this.lock) {
                after.setXDelta(before.getXDelta());
                after.setYDelta(before.getYDelta());
                after.setIsMoving(before.getIsMoving());
                RectF beforePos = before.getWhereToDraw();
                RectF afterPos = after.getWhereToDraw();
                after.setXPos(beforePos.centerX() - (afterPos.centerX() - afterPos.left));
                after.setYPos(beforePos.centerY() - (afterPos.centerY() - afterPos.top));
            }
        }
        after.setXCurrentFrame(0);
        after.setYCurrentFrame(0);
        after.setCurrentFrame(0);
        updateBoundingBox(after);

    }

    @Override
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

    @Override
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteEntity> entry, LinkedHashMap<String, SpriteEntity> entity, LinkedHashMap<String, SpriteEntity> render, boolean touched, float xTouchedPos, float yTouchedPos) {
        if(touched && !reacting) {
            if (render != null) {
                RectF boundingBox = this.render.getBoundingBox();
                if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                    /* center of the sprite */
                    if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                        updateView(this.render, center);
                        this.render = center;
                        reacting = true;
                    }
                    /* top of the sprite */
                    else if (yTouchedPos < boundingBox.top) {
                        updateView(this.render, top);
                        this.render = top;
                        reacting = true;
                    }
                    /* bottom of the sprite */
                    else if (yTouchedPos > boundingBox.bottom) {
                        updateView(this.render, bottom);
                        this.render = bottom;
                        reacting = true;
                    }
                    if(spriteView.getSpriteThread().isAlive()){
                        spriteView.getSpriteThread().interrupt();
                    }
                }
                else if (xTouchedPos < boundingBox.left) {
                    /* left side of the sprite */
                    if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                        updateView(this.render, left);
                        this.render = left;
                        reacting = true;
                    }
                        /* top left side of the sprite */
                    else if (yTouchedPos < boundingBox.top) {
                        updateView(this.render, left);
                        this.render = left;
                        reacting = true;
                    }
                        /* bottom right side of the sprite */
                    else if (yTouchedPos > boundingBox.bottom) {
                        updateView(this.render, left);
                        this.render = left;
                        reacting = true;
                    }
                }
                /* right side of the sprite */
                else if (xTouchedPos > boundingBox.right) {
                    /* right side of the screen */
                    if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                        updateView(this.render, right);
                        this.render = right;
                        reacting = true;
                    }
                        /* top right side of the sprite */
                    else if (yTouchedPos < boundingBox.top) {
                        updateView(this.render, right);
                        this.render = right;
                        reacting = true;
                    }
                        /* bottom right side of the sprite */
                    else if (yTouchedPos > boundingBox.bottom) {
                        updateView(this.render, right);
                        this.render = right;
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

}