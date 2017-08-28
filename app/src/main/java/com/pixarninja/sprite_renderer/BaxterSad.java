package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;

public class BaxterSad extends SpriteCharacter {

    public BaxterSad(Resources res, double percentOfScreen, int xRes, int yRes, int width, int height) {

        count = 0;

        int xDelta = 0;
        int yDelta = 0;
        boolean isMoving = false;
        int xPos;
        int yPos;
        int xFrameCount;
        int yFrameCount;
        int xSpriteRes;
        int ySpriteRes;
        int frameCount;
        int frameWidth;
        int frameHeight;
        int spriteWidth;
        int spriteHeight;
        double frameScale;
        double xDimension;
        double yDimension;
        double left;
        double top;
        double right;
        double bottom;
        double spriteScale;
        String method;

        /* initialize sprites that will be rendered in the scene */
        xDimension = 6.444;
        yDimension = 6.986;
        left = 1.042;
        top = 1.903;
        right = 5.236;
        bottom = 5.750;

        xFrameCount = 3;
        yFrameCount = 2;
        xSpriteRes = 2 * xRes / xFrameCount;
        ySpriteRes = 2 * yRes / xFrameCount;
        frameCount = 6;
        method = "poked";
        spriteScale = 0.7139;
        Bitmap centerImage = decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_baxter_poked_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale));
        frameWidth = centerImage.getWidth() / xFrameCount;
        frameHeight = centerImage.getHeight() / yFrameCount;
        frameScale = spriteScale * height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 4) - (spriteHeight / 2);
        this.center = new Sprite(xDelta, yDelta, isMoving, centerImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        xFrameCount = 4;
        yFrameCount = 2;
        xSpriteRes = 2 * xRes / xFrameCount;
        ySpriteRes = 2 * yRes / xFrameCount;
        frameCount = 8;
        method = "mirror";
        spriteScale = 0.7111;
        Bitmap leftImage = decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_baxter_look_right_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale));
        frameWidth = leftImage.getWidth() / xFrameCount;
        frameHeight = leftImage.getHeight() / yFrameCount;
        frameScale = spriteScale * height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 4) - (spriteHeight / 2);
        this.left = new Sprite(xDelta, yDelta, isMoving, leftImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        Bitmap topLeftImage = decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_baxter_look_right_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale));
        frameWidth = topLeftImage.getWidth() / xFrameCount;
        frameHeight = topLeftImage.getHeight() / yFrameCount;
        frameScale = spriteScale * height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 4) - (spriteHeight / 2);
        this.topLeft = new Sprite(xDelta, yDelta, isMoving, topLeftImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        spriteScale = 0.7278;
        Bitmap topImage = decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_baxter_look_up_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale));
        frameWidth = topImage.getWidth() / xFrameCount;
        frameHeight = topImage.getHeight() / yFrameCount;
        frameScale = spriteScale * height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 4) - (spriteHeight / 2);
        this.top = new Sprite(xDelta, yDelta, isMoving, topImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        spriteScale = 0.7222;
        Bitmap topRightImage = decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_baxter_look_left_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale));
        frameWidth = topRightImage.getWidth() / xFrameCount;
        frameHeight = topRightImage.getHeight() / yFrameCount;
        frameScale = spriteScale * height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 4) - (spriteHeight / 2);
        this.topRight = new Sprite(xDelta, yDelta, isMoving, topRightImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        Bitmap rightImage = decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_baxter_look_left_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale));
        frameWidth = rightImage.getWidth() / xFrameCount;
        frameHeight = rightImage.getHeight() / yFrameCount;
        frameScale = spriteScale * height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 4) - (spriteHeight / 2);
        this.right = new Sprite(xDelta, yDelta, isMoving, rightImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        Bitmap bottomRightImage = decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_baxter_look_left_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale));
        frameWidth = bottomRightImage.getWidth() / xFrameCount;
        frameHeight = bottomRightImage.getHeight() / yFrameCount;
        frameScale = spriteScale * height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 4) - (spriteHeight / 2);
        this.bottomRight = new Sprite(xDelta, yDelta, isMoving, bottomRightImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        spriteScale = 0.7479;
        Bitmap bottomImage = decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_baxter_look_down_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale));
        frameWidth = bottomImage.getWidth() / xFrameCount;
        frameHeight = bottomImage.getHeight() / yFrameCount;
        frameScale = spriteScale * height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 4) - (spriteHeight / 2);
        this.bottom = new Sprite(xDelta, yDelta, isMoving, bottomImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        spriteScale = 0.7111;
        Bitmap bottomLeftImage = decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_baxter_look_right_mirror, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale));
        frameWidth = bottomLeftImage.getWidth() / xFrameCount;
        frameHeight = bottomLeftImage.getHeight() / yFrameCount;
        frameScale = spriteScale * height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 4) - (spriteHeight / 2);
        this.bottomLeft = new Sprite(xDelta, yDelta, isMoving, bottomLeftImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        method = "idle";
        spriteScale = 0.6986;
        Bitmap idleImage = decodeSampledBitmapFromResource(res, R.mipmap.spritesheet_baxter_idle, (int)(xSpriteRes * spriteScale), (int)(ySpriteRes * spriteScale));
        frameWidth = idleImage.getWidth() / xFrameCount;
        frameHeight = idleImage.getHeight() / yFrameCount;
        frameScale = spriteScale * height * percentOfScreen / frameHeight;
        spriteWidth = (int)(frameWidth * frameScale);
        spriteHeight = (int)(frameHeight * frameScale);
        xPos = (width / 2) - (spriteWidth / 2);
        yPos = (height / 4) - (spriteHeight / 2);
        this.idle = new Sprite(xDelta, yDelta, isMoving, idleImage, xPos, yPos, xFrameCount, yFrameCount, frameCount, frameScale, xDimension, yDimension, left, top, right, bottom, method);

        updateView(idle, idle);
        render = idle;

        /* Correct for offset in spritesheet centering */
        render.setXPos(render.getXPos() + 17);

    }

    @Override
    public void getCurrentFrame(Sprite sprite){

        long time  = System.currentTimeMillis();
        if ( time > lastFrameChangeTime + frameLengthInMilliseconds) {

            lastFrameChangeTime = time;
            if(count == 0) {
                delta = 1;
            }
            else if(count <= 1) {
                if(sprite.getMethod().equals("poked")) {
                    delta = 0;
                }
            }
            else if(count <= 3) {
                if(sprite.getMethod().equals("mirror")) {
                    delta = 0;
                }
            }
            else {
                delta = -1;
            }

            if(delta > 0) {
                sprite.setCurrentFrame(sprite.getCurrentFrame() + delta);
                sprite.setXCurrentFrame(sprite.getXCurrentFrame() + delta);
                if ((sprite.getXCurrentFrame() >= sprite.getXFrameCount()) || (sprite.getCurrentFrame() >= sprite.getFrameCount())) {
                    sprite.setYCurrentFrame(sprite.getYCurrentFrame() + delta);
                    if ((sprite.getYCurrentFrame() >= sprite.getYFrameCount()) || (sprite.getCurrentFrame() >= sprite.getFrameCount())) {
                        if(sprite.getMethod().equals("once")) {
                            sprite.setYCurrentFrame(0);
                            sprite.setCurrentFrame(0);
                            reacting = false;
                            updateView(render, idle);
                            render = idle;
                        }
                        else if(sprite.getMethod().equals("mirror") || sprite.getMethod().equals("poked")) {
                            sprite.setCurrentFrame(sprite.getFrameCount());
                            sprite.setXCurrentFrame(sprite.getXFrameCount() - 1);
                            sprite.setYCurrentFrame(sprite.getYFrameCount() - 1);
                            count++;
                        }
                        else {
                            sprite.setYCurrentFrame(0);
                            sprite.setCurrentFrame(0);
                        }
                    }
                    if (count <= 0) {
                        sprite.setXCurrentFrame(0);
                    }
                }
            }
            else if (delta == 0) {
                sprite.setCurrentFrame(sprite.getFrameCount());
                sprite.setXCurrentFrame(sprite.getXFrameCount() - 1);
                sprite.setYCurrentFrame(sprite.getYFrameCount() - 1);
                count++;
            }
            else {
                sprite.setCurrentFrame(sprite.getCurrentFrame() + delta);
                sprite.setXCurrentFrame(sprite.getXCurrentFrame() + delta);
                if ((sprite.getXCurrentFrame() < 0) || (sprite.getCurrentFrame() < 0)) {
                    sprite.setYCurrentFrame(sprite.getYCurrentFrame() + delta);
                    if ((sprite.getYCurrentFrame() < 0) || (sprite.getCurrentFrame() < 0)) {
                        count = 0;
                        sprite.setXCurrentFrame(0);
                        sprite.setYCurrentFrame(0);
                        sprite.setCurrentFrame(0);
                        reacting = false;
                        updateView(render, idle);
                        render = idle;
                    }
                    if (count > 0) {
                        sprite.setXCurrentFrame(sprite.getXFrameCount() - 1);
                    }
                }
            }

        }

        /* update the next frame from the spritesheet that will be drawn */
        Rect rect = new Rect();
        rect.left = sprite.getXCurrentFrame() * sprite.getFrameWidth();
        rect.right = rect.left + sprite.getFrameWidth();
        rect.top = sprite.getYCurrentFrame() * sprite.getFrameHeight();
        rect.bottom = rect.top + sprite.getFrameHeight();
        sprite.setFrameToDraw(rect);

    }

}