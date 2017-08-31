package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.LinkedHashMap;

public class SpriteButton extends SpriteEntity {

    private int onID;
    private int pokedID;
    private int offID;

    public SpriteButton(Resources res, double percentOfScreen, int width, int height, int xRes, int yRes, int onID, int pokedID, int offID,
                        double xDelta, double yDelta, double xInit, double yInit, int xFrameCount, int yFrameCount, int frameCount,
                        double xDimension, double yDimension, double spriteScale,
                        double left, double top, double right, double bottom, String method) {

        this.res = res;
        this.percentOfScreen = percentOfScreen;
        this.width = width;
        this.height = height;
        this.xRes = xRes;
        this.yRes = yRes;
        this.onID = onID;
        this.pokedID = pokedID;
        this.offID = offID;
        controller = new SpriteController();
        controller.setXDelta(xDelta);
        controller.setYDelta(yDelta);
        controller.setXInit(xInit);
        controller.setYInit(yInit);
        controller.setXPos(xInit);
        controller.setYPos(yInit);
        this.xFrameCount = xFrameCount;
        this.yFrameCount = yFrameCount;
        this.frameCount = frameCount;
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.spriteScale = spriteScale;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.method = method;

        refreshCharacter("init");

    }

    @Override
    public void refreshCharacter(String ID) {

        int xSpriteRes;
        int ySpriteRes;

        switch (ID) {
            case "off":
                render.setID(ID);
                render.setXDimension(xDimension);
                render.setYDimension(yDimension);
                render.setLeft(left);
                render.setTop(top);
                render.setRight(right);
                render.setBottom(bottom);
                render.setXFrameCount(xFrameCount);
                render.setYFrameCount(yFrameCount);
                render.setFrameCount(frameCount);
                render.setMethod("loop");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, offID, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale(spriteScale * height * percentOfScreen / render.getFrameHeight());
                render.setSpriteWidth((int) (render.getFrameWidth() * render.getFrameScale()));
                render.setSpriteHeight((int) (render.getFrameHeight() * render.getFrameScale()));
                render.setXCurrentFrame(0);
                render.setYCurrentFrame(0);
                render.setCurrentFrame(0);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float) controller.getXPos(), (float) controller.getYPos(), (float) controller.getXPos() + render.getSpriteWidth(), (float) controller.getYPos() + render.getSpriteHeight()));
                break;
            case "poked":
                render.setID(ID);
                render.setXDimension(xDimension);
                render.setYDimension(yDimension);
                render.setLeft(left);
                render.setTop(top);
                render.setRight(right);
                render.setBottom(bottom);
                render.setXFrameCount(xFrameCount);
                render.setYFrameCount(yFrameCount);
                render.setFrameCount(frameCount);
                render.setMethod("once");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, pokedID, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale(spriteScale * height * percentOfScreen / render.getFrameHeight());
                render.setSpriteWidth((int) (render.getFrameWidth() * render.getFrameScale()));
                render.setSpriteHeight((int) (render.getFrameHeight() * render.getFrameScale()));
                render.setXCurrentFrame(0);
                render.setYCurrentFrame(0);
                render.setCurrentFrame(0);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float) controller.getXPos(), (float) controller.getYPos(), (float) controller.getXPos() + render.getSpriteWidth(), (float) controller.getYPos() + render.getSpriteHeight()));
                break;
            case "on":
                render.setID(ID);
                render.setXDimension(xDimension);
                render.setYDimension(yDimension);
                render.setLeft(left);
                render.setTop(top);
                render.setRight(right);
                render.setBottom(bottom);
                render.setXFrameCount(xFrameCount);
                render.setYFrameCount(yFrameCount);
                render.setFrameCount(frameCount);
                render.setMethod("loop");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, onID, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale(spriteScale * height * percentOfScreen / render.getFrameHeight());
                render.setSpriteWidth((int) (render.getFrameWidth() * render.getFrameScale()));
                render.setSpriteHeight((int) (render.getFrameHeight() * render.getFrameScale()));
                render.setXCurrentFrame(0);
                render.setYCurrentFrame(0);
                render.setCurrentFrame(0);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float) controller.getXPos(), (float) controller.getYPos(), (float) controller.getXPos() + render.getSpriteWidth(), (float) controller.getYPos() + render.getSpriteHeight()));
                break;
            case "init":
            default:
                render = new Sprite();
                refreshCharacter("off");
                controller.setXPos(controller.getXPos() - render.getSpriteWidth() / 2);
                controller.setYPos(controller.getYPos() - render.getSpriteHeight() / 2);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
                render.setWhereToDraw(new RectF((float)controller.getXPos(), (float)controller.getYPos(), (float)controller.getXPos() + render.getSpriteWidth(), (float)controller.getYPos() + render.getSpriteHeight()));
        }
        controller.setEntity(this);
        updateBoundingBox();
    }

    @Override
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteController> entry, LinkedHashMap<String, SpriteController> controllerMap, boolean touched, float xTouchedPos, float yTouchedPos) {
        if(touched) {
            RectF boundingBox = this.render.getBoundingBox();
            if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                /* center of the sprite */
                if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                    /* change the sprite if needed */
                    if(entry.getKey().equals("RedButtonController")) {

                        SpriteController controller;

                        /* set background */
                        controller = controllerMap.get("BackgroundController");
                        controller.makeTransition("red");
                        controllerMap.put("BackgroundController", controller);

                        /* set box */
                        controller = controllerMap.get("BoxController");
                        SpriteCharacter oldBox = (SpriteCharacter) controller.getEntity();
                        SpriteCharacter newBox = new BoxRed(oldBox.res, oldBox.percentOfScreen, oldBox.xRes, oldBox.yRes, width, height, controller, "inherit");
                        controller.setEntity(newBox);
                        controller.setReacting(false);
                        controllerMap.put("BoxController", controller);

                        /* set red button */
                        controller = controllerMap.get("RedButtonController");
                        controller.makeTransition("on");
                        controllerMap.put("RedButtonController", controller);

                        /* set green button */
                        controller = controllerMap.get("GreenButtonController");
                        controller.makeTransition("off");
                        controllerMap.put("GreenButtonController", controller);

                        /* set blue button */
                        controller = controllerMap.get("BlueButtonController");
                        controller.makeTransition("off");
                        controllerMap.put("BlueButtonController", controller);

                    }
                    else if(entry.getKey().equals("GreenButtonController")) {

                        SpriteController controller;

                        /* set background */
                        controller = controllerMap.get("BackgroundController");
                        controller.makeTransition("green");
                        controllerMap.put("BackgroundController", controller);

                        /* set box */
                        controller = controllerMap.get("BoxController");
                        SpriteCharacter oldBox = (SpriteCharacter) controller.getEntity();
                        SpriteCharacter newBox = new BoxGreen(oldBox.res, oldBox.percentOfScreen, oldBox.xRes, oldBox.yRes, width, height, controller, "inherit");
                        controller.setEntity(newBox);
                        controller.setReacting(false);
                        controllerMap.put("BoxController", controller);

                        /* set red button */
                        controller = controllerMap.get("RedButtonController");
                        controller.makeTransition("off");
                        controllerMap.put("RedButtonController", controller);

                        /* set green button */
                        controller = controllerMap.get("GreenButtonController");
                        controller.makeTransition("on");
                        controllerMap.put("GreenButtonController", controller);

                        /* set blue button */
                        controller = controllerMap.get("BlueButtonController");
                        controller.makeTransition("off");
                        controllerMap.put("BlueButtonController", controller);

                    }
                    else if(entry.getKey().equals("BlueButtonController")) {

                        SpriteController controller;

                        /* set background */
                        controller = controllerMap.get("BackgroundController");
                        controller.makeTransition("blue");
                        controllerMap.put("BackgroundController", controller);

                        /* set box */
                        controller = controllerMap.get("BoxController");
                        SpriteCharacter oldBox = (SpriteCharacter) controller.getEntity();
                        SpriteCharacter newBox = new BoxBlue(oldBox.res, oldBox.percentOfScreen, oldBox.xRes, oldBox.yRes, width, height, controller, "inherit");
                        controller.setEntity(newBox);
                        controller.setReacting(false);
                        controllerMap.put("BoxController", controller);

                        /* set red button */
                        controller = controllerMap.get("RedButtonController");
                        controller.makeTransition("off");
                        controllerMap.put("RedButtonController", controller);

                        /* set green button */
                        controller = controllerMap.get("GreenButtonController");
                        controller.makeTransition("off");
                        controllerMap.put("GreenButtonController", controller);

                        /* set blue button */
                        controller = controllerMap.get("BlueButtonController");
                        controller.makeTransition("on");
                        controllerMap.put("BlueButtonController", controller);

                    }
                }
            }
        }
    }

}
