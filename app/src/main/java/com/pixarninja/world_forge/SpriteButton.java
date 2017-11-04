package com.pixarninja.world_forge;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SpriteButton extends SpriteEntity {

    private int onID;
    private int pokedID;
    private int offID;

    public SpriteButton(Resources res, double spriteScale, int width, int height, int xRes, int yRes, int onID, int pokedID, int offID,
                        double xDelta, double yDelta, double xInit, double yInit, int xFrameCount, int yFrameCount, int frameCount,
                        double xDimension, double yDimension,
                        double left, double top, double right, double bottom, String method, SpriteController controller, String ID, String transition) {

        if(controller == null) {
            this.controller = new SpriteController();
        }
        else {
            this.controller = controller;
        }
        this.controller.setID(ID);
        this.res = res;
        this.spriteScale = spriteScale;
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
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.method = method;

        refreshEntity(transition);

    }

    @Override
    public void refreshEntity(String transition) {

        int xSpriteRes;
        int ySpriteRes;

        /* setup sprite via parsing */
        transition = parseID(transition);

        switch (transition) {
            case "off":
                render.setTransition(transition);
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
                render.setDirection("forwards");
                xSpriteRes = xRes * render.getXFrameCount();
                ySpriteRes = yRes * render.getYFrameCount();
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, offID, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale((width * spriteScale) / (double)render.getFrameWidth()); // scale = goal width / original width
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale())); // width = original width * scale
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale())); // height = original height * scale
                render.setWhereToDraw(new RectF((float) controller.getXPos(), (float) controller.getYPos(), (float) controller.getXPos() + render.getSpriteWidth(), (float) controller.getYPos() + render.getSpriteHeight()));
                break;
            case "poked":
                render.setTransition(transition);
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
                render.setDirection("forwards");
                xSpriteRes = xRes * render.getXFrameCount();
                ySpriteRes = yRes * render.getYFrameCount();
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, pokedID, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale((width * spriteScale) / (double)render.getFrameWidth()); // scale = goal width / original width
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale())); // width = original width * scale
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale())); // height = original height * scale
                render.setWhereToDraw(new RectF((float) controller.getXPos(), (float) controller.getYPos(), (float) controller.getXPos() + render.getSpriteWidth(), (float) controller.getYPos() + render.getSpriteHeight()));
                break;
            case "on":
                render.setTransition(transition);
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
                render.setDirection("forwards");
                xSpriteRes = xRes * render.getXFrameCount();
                ySpriteRes = yRes * render.getYFrameCount();
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, onID, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
                render.setFrameWidth(render.getSpriteSheet().getWidth() / render.getXFrameCount());
                render.setFrameHeight(render.getSpriteSheet().getHeight() / render.getYFrameCount());
                render.setFrameScale((width * spriteScale) / (double)render.getFrameWidth()); // scale = goal width / original width
                render.setSpriteWidth((int)(render.getFrameWidth() * render.getFrameScale())); // width = original width * scale
                render.setSpriteHeight((int)(render.getFrameHeight() * render.getFrameScale())); // height = original height * scale
                render.setWhereToDraw(new RectF((float) controller.getXPos(), (float) controller.getYPos(), (float) controller.getXPos() + render.getSpriteWidth(), (float) controller.getYPos() + render.getSpriteHeight()));
                break;
            case "skip":
                break;
            case "init":
            default:
                render = new Sprite();
                refreshEntity("off");
                transition = "off";
                controller.setXPos(controller.getXInit() - render.getSpriteWidth() / 2);
                controller.setYPos(controller.getYInit() - render.getSpriteHeight() / 2);
                render.setFrameToDraw(new Rect(0, 0, render.getFrameWidth(), render.getFrameHeight()));
        }
        updateBoundingBox();
        controller.setEntity(this);
        controller.setTransition(transition);
    }

    @Override
    public void onTouchEvent(ArrayList<Integer> pressedButtons, SpriteView spriteView, LinkedHashMap.Entry<String, SpriteController> entry, LinkedHashMap<String, SpriteController> controllerMap, boolean poke, boolean move, boolean jump, float xTouchedPos, float yTouchedPos) {
        if(poke) {
            RectF boundingBox = this.render.getBoundingBox();
            if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                /* center of the sprite */
                if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {

                    String transition;
                    String ID;

                    switch(entry.getKey()) {
                        case "FireButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                decide(pressedButtons, 0, controllerMap);
                                if(pressedButtons == null) {
                                    pressedButtons = new ArrayList<>();
                                }
                                pressedButtons.add(0);
                            }
                            break;
                        case "WaterButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                decide(pressedButtons, 1, controllerMap);
                                if(pressedButtons == null) {
                                    pressedButtons = new ArrayList<>();
                                }
                                pressedButtons.add(1);
                            }
                            break;
                        case "WoodButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                decide(pressedButtons, 2, controllerMap);
                                if(pressedButtons == null) {
                                    pressedButtons = new ArrayList<>();
                                }
                                pressedButtons.add(2);
                            }
                            break;
                        case "EarthButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                decide(pressedButtons, 3, controllerMap);
                                if(pressedButtons == null) {
                                    pressedButtons = new ArrayList<>();
                                }
                                pressedButtons.add(3);
                            }
                            break;
                        case "StoneButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                decide(pressedButtons, 4, controllerMap);
                                if(pressedButtons == null) {
                                    pressedButtons = new ArrayList<>();
                                }
                                pressedButtons.add(4);
                            }
                            break;
                        default:
                            ;
                    }

                }
            }
        }

        spriteView.setPressedButtons(pressedButtons);

    }

     void decide(ArrayList<Integer> pressedButtons, int inputButton, LinkedHashMap<String, SpriteController> controllerMap) {

        /* initial setup */
        if(pressedButtons == null) {

            switch(inputButton) {
                case 0:
                    controllerMap.get("WorldForgeController").getEntity().refreshEntity("star");
                    break;
                case 1:
                    controllerMap.get("WorldForgeController").getEntity().refreshEntity("comet");
                    break;
                case 2:
                    controllerMap.get("WorldForgeController").getEntity().refreshEntity("dust");
                    break;
                case 3:
                    controllerMap.get("WorldForgeController").getEntity().refreshEntity("earth");
                    break;
                case 4:
                    controllerMap.get("WorldForgeController").getEntity().refreshEntity("asteroid");
                    break;
            }
            return;

        }
        switch(pressedButtons.size()) {
            case 1:
                switch(pressedButtons.get(0)) {
                    case 0: //star
                        switch(inputButton) {
                            case 1:
                            case 2:
                            case 3:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("exploded star");
                                break;
                            case 4:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("magma planet");
                                break;
                        }
                        break;
                    case 1: //comet
                        switch(inputButton) {
                            case 0:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("earth");
                                break;
                            case 2:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                break;
                            case 3:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("ice age");
                                break;
                            case 4:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("ocean planet");
                                break;
                        }
                        break;
                    case 2: //dust
                        switch(inputButton) {
                            case 0:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("exploded star");
                                break;
                            case 1:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("comet");
                                break;
                            case 3:
                            case 4:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                break;
                        }
                        break;
                    case 3: //earth
                        switch(inputButton) {
                            case 0:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("desert");
                                break;
                            case 1:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("fertile land");
                                break;
                            case 2:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("forest");
                                break;
                            case 4:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("mountains");
                                break;
                        }
                        break;
                    case 4: //asteroid
                        switch(inputButton) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("exploded star");
                                break;
                        }
                        break;
                }
                break;
            case 2:
                switch(pressedButtons.get(0)) {
                    case 0: //star
                        switch(pressedButtons.get(1)) {
                            case 1:
                            case 2:
                            case 3: //exploded star
                                switch(inputButton) {
                                    case 2:
                                    case 3:
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                }
                                break;
                            case 4: //magma planet
                                switch(inputButton) {
                                    case 1:
                                    case 2:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("exploded star");
                                        break;
                                    case 3:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("volcanoes");
                                        break;
                                }
                                break;
                        }
                        break;
                    case 1: //comet
                        switch(pressedButtons.get(1)) {
                            case 3: //ice age
                                switch(inputButton) {
                                    case 0:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("earth");
                                        break;
                                    case 2:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("primitive");
                                        break;
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                        break;
                                }
                                break;
                            case 0: //earth
                                switch(inputButton) {
                                    case 3:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("earth");
                                        break;
                                    case 2:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("forest");
                                        break;
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("mountains");
                                        break;
                                }
                            case 2: //wasteland
                                switch(inputButton) {
                                    case 0:
                                    case 3:
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                }
                                break;
                            case 4: //ocean planet
                                switch(inputButton) {
                                    case 0:
                                    case 2:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                        break;
                                    case 3:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("earth");
                                        break;
                                }
                                break;
                        }
                        break;
                    case 2: //dust
                        switch(pressedButtons.get(1)) {
                            case 0: //exploded star
                                switch(inputButton) {
                                    case 1:
                                    case 3:
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                }
                                break;
                            case 1: //comet
                                switch(inputButton) {
                                    case 0:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("earth");
                                        break;
                                    case 2:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("primitive");
                                        break;
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                }
                            case 3:
                            case 4: //exploded star
                                switch(inputButton) {
                                    case 0:
                                    case 1:
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                }
                                break;
                        }
                        break;
                    case 3: //earth
                        switch(pressedButtons.get(1)) {
                            case 0: //desert
                                switch(inputButton) {
                                    case 1:
                                    case 2:
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                        break;
                                }
                                break;
                            case 1: //fertile land
                                switch(inputButton) {
                                    case 2:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("primitive");
                                        break;
                                    case 0:
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                        break;
                                }
                                break;
                            case 2: //forest
                                switch(inputButton) {
                                    case 0:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                        break;
                                    case 1:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("fertile land");
                                        break;
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("mountains");
                                        break;
                                }
                                break;
                            case 4: //mountains
                                switch(inputButton) {
                                    case 0:
                                    case 2:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                        break;
                                    case 1:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("earth");
                                        break;
                                }
                                break;
                        }
                        break;
                    case 4: //asteroid
                        switch(pressedButtons.get(1)) {
                            case 0:
                            case 1:
                            case 2:
                            case 3: //exploded star
                                switch(inputButton) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
            case 3:
                switch(pressedButtons.get(0)) {
                    case 0: //star
                        switch(pressedButtons.get(1)) {
                            case 1:
                            case 2: //exploded star
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                }
                                break;
                            case 4: //magma planet
                                switch(pressedButtons.get(2)) {
                                    case 1:
                                    case 2: //exploded star
                                        switch(inputButton) {
                                            case 1:
                                            case 2:
                                            case 3:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                                break;
                                        }
                                        break;
                                    case 3: //volcanoes
                                        switch(inputButton) {
                                            case 1:
                                            case 2:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                    case 1: //comet
                        switch(pressedButtons.get(1)) {
                            case 0: //earth
                                switch(pressedButtons.get(2)) {
                                    case 3: //earth
                                        switch(inputButton) {
                                            case 2:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("forest");
                                                break;
                                            case 4:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("mountains");
                                                break;
                                        }
                                        break;
                                    case 2: //forest
                                        switch(inputButton) {
                                            case 3:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                                break;
                                            case 4:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("mountains");
                                                break;
                                        }
                                    case 4: //mountains
                                        switch(inputButton) {
                                            case 3:
                                            case 2:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 2: //wasteland
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                break;
                            case 3: //ice age
                                switch(pressedButtons.get(2)) {
                                    case 0: //earth
                                        switch(inputButton) {
                                            case 2:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("forest");
                                                break;
                                            case 4:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("mountains");
                                                break;
                                        }
                                    case 2: //primitive
                                        switch(inputButton) {
                                            case 0:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("huts");
                                                break;
                                            case 4:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                                break;
                                        }
                                        break;
                                    case 4: //wasteland
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                }
                                break;
                            case 4: //ocean planet
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                    case 2: //wasteland
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("balck hole");
                                        break;
                                    case 3: //fertile land
                                        switch(inputButton) {
                                            case 2:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("primitive");
                                                break;
                                            case 0:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                    case 2: //dust
                        switch(pressedButtons.get(1)) {
                            case 0: //exploded star
                            case 3:
                            case 4: //black hole
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                break;
                            case 1: //comet
                                switch(pressedButtons.get(2)) {
                                    case 3: //ice age
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("ice age");
                                        break;
                                    case 0: //earth
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("earth");
                                        break;
                                    case 2: //wasteland
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                        break;
                                    case 4: //ocean planet
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("ocean planet");
                                        break;
                                }
                                break;
                        }
                        break;
                    case 3: //earth
                        switch(pressedButtons.get(1)) {
                            case 0: //desert
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                break;
                            case 1: //fertile land
                                switch(pressedButtons.get(2)) {
                                    case 2: //primitive
                                        switch(inputButton) {
                                            case 0:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("huts");
                                                break;
                                            case 4: //wasteland
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                                break;
                                        }
                                        break;
                                    case 0:
                                    case 4: //wasteland
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                }
                                break;
                            case 2: //forest
                                switch(pressedButtons.get(2)) {
                                    case 0: //wasteland
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                    case 1: //fertile land
                                        switch(inputButton) {
                                            case 0:
                                            case 4:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                                break;
                                        }
                                        break;
                                    case 4: //mountains
                                        switch(inputButton) {
                                            case 0:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("wasteland");
                                                break;
                                            case 1:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("earth");
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 4: //mountains
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                    case 2: //wasteland
                                        controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                        break;
                                    case 1: //earth
                                        switch(inputButton) {
                                            case 0:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("desert");
                                                break;
                                            case 2:
                                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("forest");
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                    case 4: //asteroid
                        switch(inputButton) {
                            case 0:
                            case 1:
                            case 2:
                            case 3: //exploded star
                                controllerMap.get("WorldForgeController").getEntity().refreshEntity("black hole");
                                break;
                        }
                        break;
                }
                break;
            case 4:
                switch(pressedButtons.get(0)) {
                    case 0:
                        switch(pressedButtons.get(1)) {
                            case 0:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 1:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 2:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 3:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 4:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                    case 1:
                        switch(pressedButtons.get(1)) {
                            case 0:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 1:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 2:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 3:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 4:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch(pressedButtons.get(1)) {
                            case 0:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 1:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 2:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 3:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 4:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch(pressedButtons.get(1)) {
                            case 0:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 1:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 2:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 3:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 4:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                    case 4:
                        switch(pressedButtons.get(1)) {
                            case 0:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 1:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 2:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 3:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case 4:
                                switch(pressedButtons.get(2)) {
                                    case 0:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 1:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                    case 4:
                                        switch(pressedButtons.get(3)) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }

    }

}
