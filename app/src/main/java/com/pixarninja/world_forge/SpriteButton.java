package com.pixarninja.world_forge;

import android.app.Activity;
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
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteController> entry, LinkedHashMap<String, SpriteController> controllerMap, boolean poke, boolean move, boolean jump, float xTouchedPos, float yTouchedPos) {

        if(poke) {
            RectF boundingBox = this.render.getBoundingBox();
            if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                /* center of the sprite */
                if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {

                    switch(entry.getKey()) {
                        case "FireButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                spriteView = decide(spriteView, 0, controllerMap);
                            }
                            break;
                        case "WaterButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                spriteView = decide(spriteView, 1, controllerMap);
                            }
                            break;
                        case "WoodButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                spriteView = decide(spriteView, 2, controllerMap);
                            }
                            break;
                        case "EarthButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                spriteView = decide(spriteView, 3, controllerMap);
                            }
                            break;
                        case "StoneButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                spriteView = decide(spriteView, 4, controllerMap);
                            }
                            break;
                        case "ElectricityButtonController":
                            if(entry.getValue().getTransition().equals("off")) {
                                entry.getValue().getEntity().refreshEntity("inherit on");
                                /* calculate what happens */
                                spriteView = decide(spriteView, 5, controllerMap);
                            }
                            break;
                        default:
                            ;
                    }

                }
            }
        }

    }

     SpriteView decide(SpriteView spriteView, int inputButton, LinkedHashMap<String, SpriteController> controllerMap) {

         String state = spriteView.getState();
         int percentage = spriteView.getPercentage();
         String description = spriteView.getDescription();

         /* initial setup */
         if(state == null) {

             switch(inputButton) {
                 case 0:
                     state = "star";
                     percentage = 0;
                     description = "A vibrant star has been born! It's heat radiates out into the cosmos...";
                     break;
                 case 1:
                     state = "comet";
                     percentage = 0;
                     description = "A frozen comet has formed! It drifts through space, lifeless and cold...";
                     break;
                 case 2:
                     state = "dust";
                     percentage = 0;
                     description = "A cloud of space particles has collected! It eerily swirls on its own...";
                     break;
                 case 3:
                     state = "earth";
                     percentage = 10;
                     description = "A planet of lively soil has formed! Small organisms squirm in the ground...";
                     break;
                 case 4:
                     state = "asteroid";
                     percentage = 0;
                     description = "An asteroid has formed! It's rocky surface is void of atmosphere...";
                     break;
                 case 5:
                     state = "plasma";
                     percentage = 0;
                     description = "A ball of plasma has appeared! It pops and fizzles in the emptiness of space...";
                     break;
             }

             controllerMap.get("WorldForgeController").getEntity().refreshEntity(state);

             spriteView.setState(state);
             spriteView.setPercentage(percentage);
             spriteView.setDescription(description);

             return spriteView;

         }

         switch(state) {
             case "plasma":
                 switch(inputButton) {
                     case 0:
                         state = "star";
                         break;
                     case 1:
                     case 2:
                         state = "exploded star";
                         break;
                     case 3:
                     case 4:
                         state = "stormy planet";
                         break;
                 }
                 break;
             case "stormy planet":
                 switch(inputButton) {
                     case 0:
                         state = "magma planet";
                         break;
                     case 1:
                     case 2:
                         state = "wasteland";
                         break;
                     case 3:
                         state = "earth";
                         break;
                     case 4:
                         state = "asteroid";
                         break;
                 }
                 break;
             case "star":
                 switch(inputButton) {
                     case 1:
                     case 2:
                     case 3:
                     case 5:
                         state = "exploded star";
                         break;
                     case 4:
                         state = "magma planet";
                         break;
                 }
                 break;
             case "comet":
                 switch(inputButton) {
                     case 0:
                         state = "earth";
                         break;
                     case 2:
                     case 5:
                         state = "wasteland";
                         break;
                     case 3:
                         state = "ice age";
                         break;
                     case 4:
                         state = "ocean planet";
                         break;
                 }
                 break;
             case "dust":
                 switch(inputButton) {
                     case 0:
                     case 5:
                         state = "exploded star";
                         break;
                     case 1:
                         state = "comet";
                         break;
                     case 3:
                     case 4:
                         state = "asteroid";
                         break;
                 }
                 break;
             case "earth":
                 switch(inputButton) {
                     case 0:
                         state = "desert";
                         break;
                     case 1:
                         state = "fertile land";
                         break;
                     case 2:
                         state = "forest";
                         break;
                     case 4:
                         state = "mountains";
                         break;
                     case 5:
                         state = "stormy planet";
                         break;
                 }
                 break;
             case "asteroid":
                 switch(inputButton) {
                     case 0:
                         state = "desert";
                         break;
                     case 2:
                         state = "exploded star";
                         break;
                     case 1:
                     case 3:
                         state = "earth";
                         break;
                     case 5:
                         state = "stormy planet";
                         break;
                 }
                 break;
             case "mountains":
                 switch(inputButton) {
                     case 0:
                     case 2:
                         state = "wasteland";
                         break;
                     case 1:
                     case 3:
                         state = "earth";
                         break;
                     case 5:
                         state = "stormy planet";
                         break;
                 }
                 break;
             case "fertile land":
                 switch(inputButton) {
                     case 0:
                         state = "desert";
                         break;
                     case 2:
                         state = "primitive";
                         break;
                     case 1:
                     case 3:
                         state = "wasteland";
                         break;
                     case 4:
                         state = "mountains";
                         break;
                     case 5:
                         state = "stormy planet";
                         break;
                 }
                 break;
             case "forest":
                 switch(inputButton) {
                     case 0:
                         state = "desert";
                         break;
                     case 1:
                     case 3:
                         state = "fertile land";
                         break;
                     case 4:
                         state = "mountains";
                         break;
                     case 5:
                         state = "stormy planet";
                         break;
                 }
                 break;
             case "ocean planet":
                 switch(inputButton) {
                     case 1:
                         state = "fertile land";
                         break;
                     case 0:
                     case 2:
                     case 5:
                         state = "wasteland";
                         break;
                     case 3:
                         state = "earth";
                         break;
                 }
                 break;
             case "wasteland":
                 state = "exploded star";
                 break;
             case "exploded star":
                 state = "black hole";
                 break;
             case "magma planet":
                 switch(inputButton) {
                     case 1:
                     case 2:
                     case 5:
                         state = "exploded star";
                         break;
                     case 3:
                         state = "volcanoes";
                         break;
                 }
                 break;
             case "black hole":
                 break;
             case "desert":
                 switch(inputButton) {
                     case 0:
                         state = "magma planet";
                         break;
                     case 1:
                         state = "earth";
                         break;
                     case 3:
                     case 4:
                         state = "asteroid";
                         break;
                     case 2:
                         state = "wasteland";
                         break;
                     case 5:
                         state = "stormy planet";
                         break;
                 }
                 break;
             case "volcanoes":
                 switch(inputButton) {
                     case 1:
                         state = "asteroid";
                         break;
                     case 0:
                     case 2:
                     case 4:
                     case 5:
                         state = "wasteland";
                         break;
                 }
                 break;
             case "ice age":
                 switch(inputButton) {
                     case 0:
                         state = "earth";
                         break;
                     case 2:
                         state = "primitive";
                         break;
                     case 4:
                         state = "mountains";
                         break;
                     case 5:
                         state = "stormy planet";
                         break;
                 }
                 break;
             case "primitive":
                 switch(inputButton) {
                     case 0:
                         state = "houses";
                         break;
                     case 1:
                     case 2:
                     case 3:
                         state = "wasteland";
                         break;
                     case 4:
                         state = "mountains";
                         break;
                     case 5:
                         state = "stormy planet";
                         break;
                 }
                 break;
             case "houses":
                 switch(inputButton) {
                     case 4:
                        state = "castles";
                        break;
                     case 5:
                         state = "stormy planet";
                         break;
                 }
                 break;
             case "castles":
                 switch(inputButton) {
                     case 5:
                         state = "modern";
                         break;
                 }
                 break;
             case "modern":
                 break;
         }

         /* decide the percentage and description */
         switch(state) {
             case "modern":
                 percentage = 100;
                 description = "Humanity develops modern civilizations! They use electricity to build new machines and advance society. The world is completely populated. Congratulations, Mighty Creator!";
                 break;
             case "stormy planet":
                 percentage = 5;
                 description = "A planet plagued with storms rages before you! The clouds torment what little life exists there...";
                 break;
             case "plasma":
                 percentage = 0;
                 description = "A ball of plasma has appeared! It pops and fizzles in the emptiness of space...";
                 break;
             case "star":
                 percentage = 0;
                 description = "A vibrant star has been born! It's heat radiates out into the cosmos...";
                 break;
             case "comet":
                 percentage = 5;
                 description = "A frozen comet has formed! It drifts through space, lonely and cold...";
                 break;
             case "dust":
                 percentage = 0;
                 description = "A cloud of space particles has collected! It eerily swirls on its own...";
                 break;
             case "earth":
                 percentage = 10;
                 description = "A planet of lively soil has formed! Small organisms squirm in the ground...";
                 break;
             case "asteroid":
                 percentage = 0;
                 description = "An asteroid has formed! It's rocky surface is void of atmosphere...";
                 break;
             case "magma planet":
                 percentage = 0;
                 description = "A planet of bubbling magma has formed! The atmosphere is hot and devoid of water...";
                 break;
             case "exploded star":
                 percentage = 0;
                 description = "The remains of a catastrophic explosion lie before you! What was once there is never to exist again...";
                 break;
             case "volcanoes":
                 percentage = 0;
                 description = "The peaks of erupting volcanoes crowd the horizon! The atmosphere is plagued with fire and brimstone...";
                 break;
             case "wasteland":
                 percentage = 1;
                 description = "A tortured landscape looms before you. The desolate atmosphere reaks of decay...";
                 break;
             case "ice age":
                 percentage = 10;
                 description = "Oceans hug the planet's surface. The world is shrouded in cold, and primitive organisms have developed...";
                 break;
             case "ocean planet":
                 percentage = 10;
                 description = "A planet of infinite water has formed! Ocean creatures swim in the vast depths...";
                 break;
             case "desert":
                 percentage = 5;
                 description = "The dunes of a windy desert make waves in the landscape. The land is scorched and arid...";
                 break;
             case "fertile land":
                 percentage = 40;
                 description = "The land is rich with vegetation and life. Primitive humans and other creatures coexist in abundance,...";
                 break;
             case "forest":
                 percentage = 30;
                 description = "The planet is covered with a forest of trees! The atmosphere improves, and thick trees sprout amongst the plants and animals...";
                 break;
             case "primitive":
                 percentage = 60;
                 description = "Humans have conquered the planet! They form nomadic societies, thriving off the animals and vegetation...";
                 break;
             case "mountains":
                 percentage = 20;
                 description = "The planet has high mountain peaks and low valleys. Food sources have depleted, replaced by rocky cliffs...";
                 break;
             case "houses":
                 percentage = 75;
                 description = "Humans have formed primitive cities! They build sturdy structures and live peacefully together...";
                 break;
             case "castles":
                 percentage = 90;
                 description = "Humanity develops complex civilizations! They build tall castles and walls around their cities...";
                 break;
             case "black hole":
                 percentage = 0;
                 description = "A dense hole has ripped the fabric of space and time! Nothing can be done, it absorbs all matter in the blink of an eye...";
                 break;
         }

         controllerMap.get("WorldForgeController").getEntity().refreshEntity(state);

         spriteView.setState(state);
         spriteView.setPercentage(percentage);
         spriteView.setDescription(description);

         return spriteView;

    }

}
