package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.LinkedHashMap;
import java.util.Random;

public class BoxRed extends SpriteCharacter {

    public BoxRed(Resources res, int xRes, int yRes, int width, int height, SpriteController controller, String ID, String transition) {

        if(controller == null) {
            this.controller = new SpriteController();
            this.controller.setXInit(width / 2);
            this.controller.setYInit(height / 2);
        }
        else {
            this.controller = controller;
        }
        this.controller.setID(ID);
        this.res = res;
        this.xRes = xRes;
        this.yRes = yRes;
        this.width = width;
        this.height = height;
        count = 0;

        refreshEntity(transition);

    }

    @Override
    public void refreshEntity(String transition) {

        int xSpriteRes;
        int ySpriteRes;

        /* setup sprite via parsing */
        transition = parseID(transition);

        switch (transition) {
            case "center":
                controller.setReacting(true);
                render.setTransition(transition);
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
                render.setDirection("forwards");
                xSpriteRes = xRes * render.getXFrameCount();
                ySpriteRes = yRes * render.getYFrameCount();
                spriteScale = 0.3;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_idle_red, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale((width * spriteScale) / (double)render.getFrameWidth()); // scale = goal width / original width
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale())); // width = original width * scale
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale())); // height = original height * scale
                Random random = new Random();
                controller.setXPos(random.nextDouble() * width * 0.5);
                controller.setYPos(random.nextDouble() * height * 0.5);
                render.setWhereToDraw(new RectF((float) controller.getXPos(), (float) controller.getYPos(), (float) controller.getXPos() + render.getSpriteWidth(), (float) controller.getYPos() + render.getSpriteHeight()));
                break;
            case "bottomLeft":
            case "left":
            case "topLeft":
                controller.setReacting(true);
                render.setTransition(transition);
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
                render.setDirection("forwards");
                xSpriteRes = xRes * render.getXFrameCount();
                ySpriteRes = yRes * render.getYFrameCount();
                spriteScale = 0.32;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_rotate_right_red_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale((width * spriteScale) / (double)render.getFrameWidth()); // scale = goal width / original width
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale())); // width = original width * scale
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale())); // height = original height * scale
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
                break;
            case "top":
                controller.setReacting(true);
                render.setTransition(transition);
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
                render.setDirection("forwards");
                xSpriteRes = xRes * render.getXFrameCount();
                ySpriteRes = yRes * render.getYFrameCount();
                spriteScale = 0.287;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_rotate_up_red_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale((width * spriteScale) / (double)render.getFrameWidth()); // scale = goal width / original width
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale())); // width = original width * scale
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale())); // height = original height * scale
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
                break;
            case "bottomRight":
            case "right":
            case "topRight":
                controller.setReacting(true);
                render.setTransition(transition);
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
                render.setDirection("forwards");
                xSpriteRes = xRes * render.getXFrameCount();
                ySpriteRes = yRes * render.getYFrameCount();
                spriteScale = 0.32;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_rotate_left_red_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale((width * spriteScale) / (double)render.getFrameWidth()); // scale = goal width / original width
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale())); // width = original width * scale
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale())); // height = original height * scale
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
                break;
            case "bottom":
                controller.setReacting(true);
                render.setTransition(transition);
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
                render.setDirection("forwards");
                xSpriteRes = xRes * render.getXFrameCount();
                ySpriteRes = yRes * render.getYFrameCount();
                spriteScale = 0.287;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_rotate_down_red_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale((width * spriteScale) / (double)render.getFrameWidth()); // scale = goal width / original width
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale())); // width = original width * scale
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale())); // height = original height * scale
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
                break;
            case "idle":
                controller.setReacting(false);
                render.setTransition(transition);
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
                render.setDirection("forwards");
                xSpriteRes = xRes * render.getXFrameCount();
                ySpriteRes = yRes * render.getYFrameCount();
                spriteScale = 0.3;
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_box_idle_red, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale((width * spriteScale) / (double)render.getFrameWidth()); // scale = goal width / original width
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale())); // width = original width * scale
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale())); // height = original height * scale
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
                break;
            case "skip":
                break;
            case "init":
            default:
                render = new Sprite();
                controller.setXDelta(0);
                controller.setYDelta(0);
                refreshEntity("idle");
                transition = "idle";
                controller.setXPos(controller.getXInit() - render.getSpriteWidth() / 2);
                controller.setYPos(controller.getYInit() - render.getSpriteHeight() / 2 - height / 15);
                render.setXCurrentFrame(0);
                render.setYCurrentFrame(0);
                render.setCurrentFrame(0);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
        }
        controller.setTransition(transition);
        controller.setEntity(this);
        updateBoundingBox();
    }

    @Override
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteController> entry, LinkedHashMap<String, SpriteController> controllerMap, boolean poke, boolean move, boolean jump, float xTouchedPos, float yTouchedPos) {
        if(poke && !controller.getReacting()) {
            if(yTouchedPos >= (7.5 * height / 10)) {
                return;
            }
            super.onTouchEvent(spriteView, entry, controllerMap, poke, move, jump, xTouchedPos, yTouchedPos);
        }
    }

}