package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;

public class Background extends SpriteProp{


    public Background(Resources res, double percentOfScreen, int width, int height, int xRes, int yRes, int propID,
                            double xDelta, double yDelta, int xInit, int yInit, int xFrameCount, int yFrameCount, int frameCount,
                            double xDimension, double yDimension, double spriteScale,
                            double left, double top, double right, double bottom, String method) {

        super(res, percentOfScreen, width, height, xRes, yRes, propID, xDelta, yDelta, xInit, yInit, xFrameCount, yFrameCount, frameCount, xDimension, yDimension, spriteScale, left, top, right, bottom, method);

        refreshCharacter("red");

    }

    @Override
    public void refreshCharacter(String ID) {

        int xSpriteRes;
        int ySpriteRes;

        if (render == null) {
            render = new Sprite();
        }

        switch (ID) {
            case "red":
                render.setID(ID);
                render.setXDimension(xDimension);
                render.setYDimension(yDimension);
                render.setLeft(left);
                render.setTop(top);
                render.setRight(right);
                render.setBottom(bottom);
                render.setXFrameCount(1);
                render.setYFrameCount(1);
                render.setFrameCount(1);
                render.setMethod("loop");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.background_home, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
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
            case "green":
                render.setID(ID);
                render.setXDimension(xDimension);
                render.setYDimension(yDimension);
                render.setLeft(left);
                render.setTop(top);
                render.setRight(right);
                render.setBottom(bottom);
                render.setXFrameCount(1);
                render.setYFrameCount(1);
                render.setFrameCount(1);
                render.setMethod("loop");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.background_creativemode, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
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
            default:
                render.setID(ID);
                render.setXDimension(xDimension);
                render.setYDimension(yDimension);
                render.setLeft(left);
                render.setTop(top);
                render.setRight(right);
                render.setBottom(bottom);
                render.setXFrameCount(1);
                render.setYFrameCount(1);
                render.setFrameCount(1);
                render.setMethod("loop");
                xSpriteRes = 2 * xRes / render.getXFrameCount();
                ySpriteRes = 2 * yRes / render.getYFrameCount();
                render.setSpriteSheet(decodeSampledBitmapFromResource(res, R.mipmap.background_leaderboard, (int) (xSpriteRes * spriteScale), (int) (ySpriteRes * spriteScale)));
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
        }
        controller.setEntity(this);
        updateBoundingBox();
    }

    @Override
    public void updateView() {

        render.setXCurrentFrame(0);
        render.setYCurrentFrame(0);
        render.setCurrentFrame(0);
        controller.setXPos(controller.getXPos() + controller.getXDelta());
        controller.setYPos(controller.getYPos() + controller.getYDelta());

        if(controller.getXDelta() < 0) {
            if(controller.getYDelta() < 0) {
                if ((controller.getXPos() <= (controller.getXInit() - (render.getSpriteWidth() / 10))) || (controller.getYPos() <= (controller.getYInit() - (render.getSpriteHeight() / 10)))) {
                    controller.setXPos(controller.getXInit());
                    controller.setYPos(controller.getYInit());
                }
            }
            else {
                if ((controller.getXPos() <= (controller.getXInit() - (render.getSpriteWidth() / 10))) || (controller.getYPos() >= (controller.getYInit() - (render.getSpriteHeight() / 10)))) {
                    controller.setXPos(controller.getXInit());
                    controller.setYPos(controller.getYInit());
                }
            }
        }
        else {
            if(controller.getYDelta() < 0) {
                if ((controller.getXPos() <= (controller.getXInit() - (render.getSpriteWidth() / 10))) || (controller.getYPos() >= (controller.getYInit() - (render.getSpriteHeight() / 10)))) {
                    controller.setXPos(controller.getXInit());
                    controller.setYPos(controller.getYInit());
                }
            }
            else {
                if ((controller.getXPos() >= (controller.getXInit() - (render.getSpriteWidth() / 10))) || (controller.getYPos() >= (controller.getYInit() - (render.getSpriteHeight() / 10)))) {
                    controller.setXPos(controller.getXInit());
                    controller.setYPos(controller.getYInit());;
                }
            }
        }

        updateBoundingBox();

    }

}
