package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.LinkedHashMap;

public class SpriteButton extends SpriteEntity {

    private int onID;
    private int pokedID;
    private int offID;

    public SpriteButton(SpriteView spriteView, Resources res, double percentOfScreen, int width, int height, int xRes, int yRes, int onID, int pokedID, int offID,
                        double xDelta, double yDelta, double xInit, double yInit, int xFrameCount, int yFrameCount, int frameCount,
                        double xDimension, double yDimension, double spriteScale,
                        double left, double top, double right, double bottom, String method, SpriteController controller, String ID) {

        if(controller == null) {
            this.controller = new SpriteController();
        }
        else {
            this.controller = controller;
        }
        this.spriteView = spriteView;
        this.res = res;
        this.percentOfScreen = percentOfScreen;
        this.width = width;
        this.height = height;
        this.xRes = xRes;
        this.yRes = yRes;
        this.onID = onID;
        this.pokedID = pokedID;
        this.offID = offID;
        this.controller.setXDelta(xDelta);
        this.controller.setYDelta(yDelta);
        this.controller.setXInit(xInit);
        this.controller.setYInit(yInit);
        this.controller.setXPos(xInit);
        this.controller.setYPos(yInit);
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

        refreshCharacter(ID);

    }

    @Override
    public void refreshCharacter(String ID) {

        int xSpriteRes;
        int ySpriteRes;

        /* setup sprite via parsing */
        ID = parseID(ID);

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
                render.setWhereToDraw(new RectF((float) controller.getXPos(), (float) controller.getYPos(), (float) controller.getXPos() + render.getSpriteWidth(), (float) controller.getYPos() + render.getSpriteHeight()));
                break;
            case "skip":
                break;
            case "init":
            default:
                render = new Sprite();
                refreshCharacter("off");
                controller.setXPos(controller.getXInit() - render.getSpriteWidth() / 2);
                controller.setYPos(controller.getYInit() - render.getSpriteHeight() / 2);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
        }
        controller.setEntity(this);
        controller.setTransition(ID);
        updateBoundingBox();
    }

    @Override
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteController> entry, LinkedHashMap<String, SpriteController> controllerMap, boolean touched, float xTouchedPos, float yTouchedPos) {
        if(touched) {
            RectF boundingBox = this.render.getBoundingBox();
            if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                /* center of the sprite */
                if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {

                    String transition;
                    String ID;

                    /* change the sprite if needed */
                    if(entry.getKey().equals("RedButtonController")) {

                        SpriteController controller;

                        /* set background */
                        spriteView.setBackgroundResource(R.drawable.background_red);

                        /* set dark pattern */
                        controller = controllerMap.get("DarkPatternController");
                        if(!controller.getTransition().equals("red")) {
                            controller.makeTransition("red");
                        }
                        controllerMap.put("DarkPatternController", controller);

                        /* set light pattern */
                        controller = controllerMap.get("LightPatternController");
                        if(!controller.getTransition().equals("red")) {
                            controller.makeTransition("red");
                        }
                        controllerMap.put("LightPatternController", controller);

                        /* set red button */
                        controller = controllerMap.get("RedButtonController");
                        if(!controller.getTransition().equals("on")) {
                            controller.makeTransition("on");
                        }
                        controllerMap.put("RedButtonController", controller);

                        /* set green button */
                        controller = controllerMap.get("GreenButtonController");
                        if(!controller.getTransition().equals("off")) {
                            controller.makeTransition("off");
                        }
                        controllerMap.put("GreenButtonController", controller);

                        /* set blue button */
                        controller = controllerMap.get("BlueButtonController");
                        if(!controller.getTransition().equals("off")) {
                            controller.makeTransition("off");
                        }
                        controllerMap.put("BlueButtonController", controller);

                        /* set box */
                        controller = controllerMap.get("BoxController");
                        SpriteCharacter oldBox = (SpriteCharacter) controller.getEntity();
                        transition = controller.getTransition();
                        ID = "inherit " + transition;
                        SpriteCharacter newBox = new BoxRed(spriteView, oldBox.res, oldBox.percentOfScreen, oldBox.xRes, oldBox.yRes, width, height, controller, ID);
                        newBox.setCount(oldBox.getCount());
                        newBox.setDelta(oldBox.getDelta());
                        controller.setEntity(newBox);
                        controllerMap.put("BoxController", controller);

                    }
                    else if(entry.getKey().equals("GreenButtonController")) {

                        SpriteController controller;

                        /* set background */
                        spriteView.setBackgroundResource(R.drawable.background_green);

                        /* set dark pattern */
                        controller = controllerMap.get("DarkPatternController");
                        if(!controller.getTransition().equals("green")) {
                            controller.makeTransition("green");
                        }
                        controllerMap.put("DarkPatternController", controller);

                        /* set light pattern */
                        controller = controllerMap.get("LightPatternController");
                        if(!controller.getTransition().equals("green")) {
                            controller.makeTransition("green");
                        }
                        controllerMap.put("LightPatternController", controller);

                        /* set red button */
                        controller = controllerMap.get("RedButtonController");
                        if(!controller.getTransition().equals("off")) {
                            controller.makeTransition("off");
                        }
                        controllerMap.put("RedButtonController", controller);

                        /* set green button */
                        controller = controllerMap.get("GreenButtonController");
                        if(!controller.getTransition().equals("on")) {
                            controller.makeTransition("on");
                        }
                        controllerMap.put("GreenButtonController", controller);

                        /* set blue button */
                        controller = controllerMap.get("BlueButtonController");
                        if(!controller.getTransition().equals("off")) {
                            controller.makeTransition("off");
                        }
                        controllerMap.put("BlueButtonController", controller);

                        /* set box */
                        controller = controllerMap.get("BoxController");
                        SpriteCharacter oldBox = (SpriteCharacter) controller.getEntity();
                        transition = controller.getTransition();
                        ID = "inherit " + transition;
                        SpriteCharacter newBox = new BoxGreen(spriteView, oldBox.res, oldBox.percentOfScreen, oldBox.xRes, oldBox.yRes, width, height, controller, ID);
                        newBox.setCount(oldBox.getCount());
                        newBox.setDelta(oldBox.getDelta());
                        controller.setEntity(newBox);
                        controllerMap.put("BoxController", controller);

                    }
                    else if(entry.getKey().equals("BlueButtonController")) {

                        SpriteController controller;

                        /* set background */
                        spriteView.setBackgroundResource(R.drawable.background_blue);

                        /* set dark pattern */
                        controller = controllerMap.get("DarkPatternController");
                        if(!controller.getTransition().equals("blue")) {
                            controller.makeTransition("blue");
                        }
                        controllerMap.put("DarkPatternController", controller);

                        /* set light pattern */
                        controller = controllerMap.get("LightPatternController");
                        if(!controller.getTransition().equals("blue")) {
                            controller.makeTransition("blue");
                        }
                        controllerMap.put("LightPatternController", controller);

                        /* set red button */
                        controller = controllerMap.get("RedButtonController");
                        if(!controller.getTransition().equals("off")) {
                            controller.makeTransition("off");
                        }
                        controllerMap.put("RedButtonController", controller);

                        /* set green button */
                        controller = controllerMap.get("GreenButtonController");
                        if(!controller.getTransition().equals("off")) {
                            controller.makeTransition("off");
                        }
                        controllerMap.put("GreenButtonController", controller);

                        /* set blue button */
                        controller = controllerMap.get("BlueButtonController");
                        if(!controller.getTransition().equals("on")) {
                            controller.makeTransition("on");
                        }
                        controllerMap.put("BlueButtonController", controller);

                        /* set box */
                        controller = controllerMap.get("BoxController");
                        SpriteCharacter oldBox = (SpriteCharacter) controller.getEntity();
                        transition = oldBox.getController().getTransition();
                        ID = "inherit " + transition;
                        SpriteCharacter newBox = new BoxBlue(spriteView, oldBox.res, oldBox.percentOfScreen, oldBox.xRes, oldBox.yRes, width, height, controller, ID);
                        newBox.setCount(oldBox.getCount());
                        newBox.setDelta(oldBox.getDelta());
                        controller.setEntity(newBox);
                        controllerMap.put("BoxController", controller);

                    }
                }
            }
        }
    }

}
