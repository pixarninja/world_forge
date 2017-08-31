package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.LinkedHashMap;
import java.util.Random;

public class BoxGreen extends SpriteCharacter {

    protected int delta;
    protected int count;

    public BoxGreen(Resources res, double percentOfScreen, int xRes, int yRes, int width, int height, SpriteController controller, String ID) {

        this.res = res;
        this.percentOfScreen = percentOfScreen;
        this.xRes = xRes;
        this.yRes = yRes;
        this.width = width;
        this.height = height;
        this.controller = controller;
        count = 0;

        refreshCharacter(ID);

    }

    @Override
    public void refreshCharacter(String ID) {

        int xSpriteRes;
        int ySpriteRes;

        switch (ID) {
            case "center":
                render.setID(ID);
                render.setXDimension(1.611);
                render.setYDimension(1.611);
                render.setLeft(0);
                render.setTop(0);
                render.setRight(1.611);
                render.setBottom(1.611);
                render.setXFrameCount(1);
                render.setYFrameCount(1);
                render.setFrameCount(1);
                render.setMethod("poked");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                spriteScale = 0.275;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_idle_green, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale(spriteScale * height * percentOfScreen / render.getFrameHeight());
                render.setSpriteWidth((int) (render.getFrameWidth() * render.getFrameScale()));
                render.setSpriteHeight((int) (render.getFrameHeight() * render.getFrameScale()));
                render.setXCurrentFrame(0);
                render.setYCurrentFrame(0);
                render.setCurrentFrame(0);
                Random random = new Random();
                controller.setXPos(random.nextDouble() * width * 0.5);
                controller.setYPos(random.nextDouble() * height * 0.5);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float) controller.getXPos(), (float) controller.getYPos(), (float) controller.getXPos() + render.getSpriteWidth(), (float) controller.getYPos() + render.getSpriteHeight()));
                break;
            case "bottom left":
            case "left":
            case "top left":
                render.setID(ID);
                render.setXDimension(6.944);
                render.setYDimension(2.917);
                render.setLeft(0);
                render.setTop(0);
                render.setRight(6.944);
                render.setBottom(2.917);
                render.setXFrameCount(4);
                render.setYFrameCount(2);
                render.setFrameCount(8);
                render.setMethod("mirror");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                spriteScale = 0.25;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_rotate_right_green_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale(spriteScale * height * percentOfScreen / render.getFrameHeight());
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale()));
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale()));
                render.setXCurrentFrame(0);
                render.setYCurrentFrame(0);
                render.setCurrentFrame(0);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
                break;
            case "top":
                render.setID(ID);
                render.setXDimension(5.944);
                render.setYDimension(3.444);
                render.setLeft(0);
                render.setTop(0);
                render.setRight(5.944);
                render.setBottom(3.444);
                render.setXFrameCount(4);
                render.setYFrameCount(2);
                render.setFrameCount(8);
                render.setMethod("mirror");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                spriteScale = 0.3;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_rotate_up_green_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale(spriteScale * height * percentOfScreen / render.getFrameHeight());
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale()));
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale()));
                render.setXCurrentFrame(0);
                render.setYCurrentFrame(0);
                render.setCurrentFrame(0);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
                break;
            case "bottom right":
            case "right":
            case "top right":
                render.setID(ID);
                render.setXDimension(6.889);
                render.setYDimension(3);
                render.setLeft(0);
                render.setTop(0);
                render.setRight(6.889);
                render.setBottom(3);
                render.setXFrameCount(4);
                render.setYFrameCount(2);
                render.setFrameCount(8);
                render.setMethod("mirror");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                spriteScale = 0.25;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_rotate_left_green_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale(spriteScale * height * percentOfScreen / render.getFrameHeight());
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale()));
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale()));
                render.setXCurrentFrame(0);
                render.setYCurrentFrame(0);
                render.setCurrentFrame(0);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
                break;
            case "bottom":
                render.setID(ID);
                render.setXDimension(6.056);
                render.setYDimension(3.389);
                render.setLeft(0);
                render.setTop(0);
                render.setRight(6.056);
                render.setBottom(3.389);
                render.setXFrameCount(4);
                render.setYFrameCount(2);
                render.setFrameCount(8);
                render.setMethod("mirror");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                spriteScale = 0.29;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_rotate_down_green_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale(spriteScale * height * percentOfScreen / render.getFrameHeight());
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale()));
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale()));
                render.setXCurrentFrame(0);
                render.setYCurrentFrame(0);
                render.setCurrentFrame(0);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
                break;
            case "idle":
                render.setID(ID);
                render.setXDimension(1.611);
                render.setYDimension(1.611);
                render.setLeft(0);
                render.setTop(0);
                render.setRight(1.611);
                render.setBottom(1.611);
                render.setXFrameCount(1);
                render.setYFrameCount(1);
                render.setFrameCount(1);
                render.setMethod("loop");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                spriteScale = 0.275;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_idle_green, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale(spriteScale * height * percentOfScreen / render.getFrameHeight());
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale()));
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale()));
                render.setXCurrentFrame(0);
                render.setYCurrentFrame(0);
                render.setCurrentFrame(0);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
                break;
            case "inherit":
                render = new Sprite();
                refreshCharacter("idle");
            break;
            case "init":
            default:
                render = new Sprite();
                controller.setXDelta(0);
                controller.setYDelta(0);
                refreshCharacter("idle");
                controller.setXPos(width / 2 - render.getSpriteWidth() / 2);
                controller.setYPos(height / 2 - render.getSpriteHeight() / 2);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
        }
        controller.setEntity(this);
        updateBoundingBox();
    }

    @Override
    public void getCurrentFrame(){

        long time  = System.currentTimeMillis();
        if ( time > controller.getLastFrameChangeTime() + controller.getFrameRate()) {

            controller.setLastFrameChangeTime(time);
            if(count == 0) {
                delta = 1;
            }
            else if(count <= 1) {
                if(render.getMethod().equals("poked")) {
                    delta = 0;
                }
            }
            else if(count <= 3) {
                if(render.getMethod().equals("mirror")) {
                    delta = 0;
                }
            }
            else {
                delta = -1;
            }

            if(delta > 0) {
                render.setCurrentFrame(render.getCurrentFrame() + delta);
                render.setXCurrentFrame(render.getXCurrentFrame() + delta);
                if ((render.getXCurrentFrame() >= render.getXFrameCount()) || (render.getCurrentFrame() >= render.getFrameCount())) {
                    render.setYCurrentFrame(render.getYCurrentFrame() + delta);
                    if ((render.getYCurrentFrame() >= render.getYFrameCount()) || (render.getCurrentFrame() >= render.getFrameCount())) {
                        if(render.getMethod().equals("once")) {
                            refreshCharacter("idle");
                            controller.setReacting(false);
                        }
                        else if(render.getMethod().equals("mirror") || render.getMethod().equals("poked")) {
                            render.setCurrentFrame(render.getFrameCount());
                            render.setXCurrentFrame(render.getXFrameCount() - 1);
                            render.setYCurrentFrame(render.getYFrameCount() - 1);
                            count++;
                        }
                        else {
                            render.setYCurrentFrame(0);
                            render.setCurrentFrame(0);
                        }
                    }
                    if (count <= 0) {
                        render.setXCurrentFrame(0);
                    }
                }
            }
            else if (delta == 0) {
                render.setCurrentFrame(render.getFrameCount());
                render.setXCurrentFrame(render.getXFrameCount() - 1);
                render.setYCurrentFrame(render.getYFrameCount() - 1);
                count++;
            }
            else {
                render.setCurrentFrame(render.getCurrentFrame() + delta);
                render.setXCurrentFrame(render.getXCurrentFrame() + delta);
                if ((render.getXCurrentFrame() < 0) || (render.getCurrentFrame() < 0)) {
                    render.setYCurrentFrame(render.getYCurrentFrame() + delta);
                    if ((render.getYCurrentFrame() < 0) || (render.getCurrentFrame() < 0)) {
                        refreshCharacter("idle");
                        controller.setReacting(false);
                        count = 0;
                    }
                    if (count > 0) {
                        render.setXCurrentFrame(render.getXFrameCount() - 1);
                    }
                }
            }

        }

        /* update the next frame from the spritesheet that will be drawn */
        Rect rect = new Rect();
        rect.left = render.getXCurrentFrame() * render.getFrameWidth();
        rect.right = rect.left + render.getFrameWidth();
        rect.top = render.getYCurrentFrame() * render.getFrameHeight();
        rect.bottom = rect.top + render.getFrameHeight();
        render.setFrameToDraw(rect);

    }

    @Override
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteController> entry, LinkedHashMap<String, SpriteController> controllerMap, boolean touched, float xTouchedPos, float yTouchedPos) {
        if(touched && !controller.getReacting()) {
            RectF boundingBox = render.getBoundingBox();
            if(yTouchedPos >= (7.5 * height / 10)) {
                return;
            }
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
                    refreshCharacter("top left");
                    updateView();
                    controller.setReacting(true);
                }
                    /* bottom right side of the sprite */
                else if (yTouchedPos > boundingBox.bottom) {
                    refreshCharacter("bottom right");
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
                    refreshCharacter("top right");
                    updateView();
                    controller.setReacting(true);
                }
                    /* bottom right side of the sprite */
                else if (yTouchedPos > boundingBox.bottom) {
                    refreshCharacter("bottom right");
                    updateView();
                    controller.setReacting(true);
                }
            }
        }
    }

}