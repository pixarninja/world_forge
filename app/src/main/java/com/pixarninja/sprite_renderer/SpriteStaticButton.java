package com.pixarninja.sprite_renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.LinkedHashMap;

public class SpriteStaticButton extends SpriteEntity {

    private String state;
    private Sprite on;
    private Sprite off;


    public SpriteStaticButton(Resources res, double percentOfScreen, int width, int height, int xRes, int yRes, int onID, int offID,
                        double xDelta, double yDelta, boolean isMoving, double xPos, double yPos) {

        int frameHeight;
        double frameScale;

        /* initialize sprites that will be rendered in the scene */
        Bitmap onImage = decodeSampledBitmapFromResource(res, onID, xRes, yRes);
        frameHeight = onImage.getHeight();
        frameScale = height * percentOfScreen / frameHeight;
        this.on = new Sprite(xDelta, yDelta, isMoving, onImage, xPos, yPos, frameScale);

        Bitmap offImage = decodeSampledBitmapFromResource(res, offID, xRes, yRes);
        frameHeight = offImage.getHeight();
        frameScale = height * percentOfScreen / frameHeight;
        this.off = new Sprite(xDelta, yDelta, isMoving, offImage, xPos, yPos, frameScale);

        updateView(off, off);
        state = "turn off";
        render = off;

    }

    public void setState(String state) { this.state = state; }
    public String getState() { return this.state; }

    @Override
    public void getCurrentFrame(Sprite sprite){

        long time  = System.currentTimeMillis();
        if ( time > lastFrameChangeTime + frameLengthInMilliseconds) {

            lastFrameChangeTime = time;
            sprite.setCurrentFrame(sprite.getCurrentFrame() + 1);
            sprite.setXCurrentFrame(sprite.getXCurrentFrame() + 1);
            if ((sprite.getXCurrentFrame() >= sprite.getXFrameCount()) || (sprite.getCurrentFrame() >= sprite.getFrameCount())) {
                sprite.setYCurrentFrame(sprite.getYCurrentFrame() + 1);
                if ((sprite.getYCurrentFrame() >= sprite.getYFrameCount()) || (sprite.getCurrentFrame() >= sprite.getFrameCount())) {
                    sprite.setYCurrentFrame(0);
                    sprite.setCurrentFrame(0);
                    if(state == "turn off") {
                        updateView(render, off);
                        render = off;
                    }
                    else {
                        updateView(render, on);
                        render = on;
                    }
                }
                sprite.setXCurrentFrame(0);
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

    @Override
    public void onTouchEvent(SpriteView spriteView, LinkedHashMap.Entry<String, SpriteEntity> entry, LinkedHashMap<String, SpriteEntity> entity, LinkedHashMap<String, SpriteEntity> render, boolean touched, float xTouchedPos, float yTouchedPos) {
        if(touched) {
            if (render != null) {
                RectF boundingBox = this.render.getBoundingBox();
                if (xTouchedPos >= boundingBox.left && xTouchedPos <= boundingBox.right) {
                    /* center of the sprite */
                    if (yTouchedPos >= boundingBox.top && yTouchedPos <= boundingBox.bottom) {
                        /* change the sprite if needed */
                        if(entry.getKey().equals("ButtonHome")) {
                            /* update button sprites */
                            SpriteStaticButton button;
                            button = (SpriteStaticButton) entity.get("ButtonHome");
                            button.setState("turn on");
                            render.put("ButtonHome", button);
                            button = (SpriteStaticButton) entity.get("ButtonTimeChallenge");
                            button.setState("turn off");
                            render.put("ButtonTimeChallenge", button);
                            button = (SpriteStaticButton) entity.get("ButtonCreativeMode");
                            button.setState("turn off");
                            render.put("ButtonCreativeMode", button);
                            button = (SpriteStaticButton) entity.get("ButtonLeaderBoard");
                            button.setState("turn off");
                            render.put("ButtonLeaderBoard", button);
                            button = (SpriteStaticButton) entity.get("ButtonRate");
                            button.setState("turn off");
                            render.put("ButtonRate", button);
                            /* set background sprites */
                            Sprite sprite;
                            sprite = entity.get("BackgroundHome").getSprite();
                            render.get("Background").setSprite(sprite);
                            sprite = entity.get("BackgroundHomeDarkMovingFlair").getSprite();
                            sprite.setXPos(render.get("BackgroundDarkMovingFlair").getSprite().getXPos());
                            sprite.setYPos(render.get("BackgroundDarkMovingFlair").getSprite().getYPos());
                            render.get("BackgroundDarkMovingFlair").setSprite(sprite);
                            sprite = entity.get("BackgroundHomeLightMovingFlair").getSprite();
                            sprite.setXPos(render.get("BackgroundLightMovingFlair").getSprite().getXPos());
                            sprite.setYPos(render.get("BackgroundLightMovingFlair").getSprite().getYPos());
                            render.get("BackgroundLightMovingFlair").setSprite(sprite);
                        }
                        else if(entry.getKey().equals("ButtonTimeChallenge")) {
                            /* update button sprites */
                            SpriteStaticButton button;
                            button = (SpriteStaticButton) entity.get("ButtonHome");
                            button.setState("turn off");
                            render.put("ButtonHome", button);
                            button = (SpriteStaticButton) entity.get("ButtonTimeChallenge");
                            button.setState("turn on");
                            render.put("ButtonTimeChallenge", button);
                            button = (SpriteStaticButton) entity.get("ButtonCreativeMode");
                            button.setState("turn off");
                            render.put("ButtonCreativeMode", button);
                            button = (SpriteStaticButton) entity.get("ButtonLeaderBoard");
                            button.setState("turn off");
                            render.put("ButtonLeaderBoard", button);
                            button = (SpriteStaticButton) entity.get("ButtonRate");
                            button.setState("turn off");
                            render.put("ButtonRate", button);
                            /* set background sprites */
                            Sprite sprite;
                            sprite = entity.get("BackgroundTimeChallenge").getSprite();
                            render.get("Background").setSprite(sprite);
                            sprite = entity.get("BackgroundTimeChallengeDarkMovingFlair").getSprite();
                            sprite.setXPos(render.get("BackgroundDarkMovingFlair").getSprite().getXPos());
                            sprite.setYPos(render.get("BackgroundDarkMovingFlair").getSprite().getYPos());
                            render.get("BackgroundDarkMovingFlair").setSprite(sprite);
                            sprite = entity.get("BackgroundTimeChallengeLightMovingFlair").getSprite();
                            sprite.setXPos(render.get("BackgroundLightMovingFlair").getSprite().getXPos());
                            sprite.setYPos(render.get("BackgroundLightMovingFlair").getSprite().getYPos());
                            render.get("BackgroundLightMovingFlair").setSprite(sprite);
                        }
                        else if(entry.getKey().equals("ButtonCreativeMode")) {
                            /* update button sprites */
                            SpriteStaticButton button;
                            button = (SpriteStaticButton) entity.get("ButtonHome");
                            button.setState("turn off");
                            render.put("ButtonHome", button);
                            button = (SpriteStaticButton) entity.get("ButtonTimeChallenge");
                            button.setState("turn off");
                            render.put("ButtonTimeChallenge", button);
                            button = (SpriteStaticButton) entity.get("ButtonCreativeMode");
                            button.setState("turn on");
                            render.put("ButtonCreativeMode", button);
                            button = (SpriteStaticButton) entity.get("ButtonLeaderBoard");
                            button.setState("turn off");
                            render.put("ButtonLeaderBoard", button);
                            button = (SpriteStaticButton) entity.get("ButtonRate");
                            button.setState("turn off");
                            render.put("ButtonRate", button);
                            /* set background sprites */
                            Sprite sprite;
                            sprite = entity.get("BackgroundCreativeMode").getSprite();
                            render.get("Background").setSprite(sprite);
                            sprite = entity.get("BackgroundCreativeModeDarkMovingFlair").getSprite();
                            sprite.setXPos(render.get("BackgroundDarkMovingFlair").getSprite().getXPos());
                            sprite.setYPos(render.get("BackgroundDarkMovingFlair").getSprite().getYPos());
                            render.get("BackgroundDarkMovingFlair").setSprite(sprite);
                            sprite = entity.get("BackgroundCreativeModeLightMovingFlair").getSprite();
                            sprite.setXPos(render.get("BackgroundLightMovingFlair").getSprite().getXPos());
                            sprite.setYPos(render.get("BackgroundLightMovingFlair").getSprite().getYPos());
                            render.get("BackgroundLightMovingFlair").setSprite(sprite);

                            /* experimental: transition baxter to happy or sad */
                            SpriteEntity baxter = entity.get("Baxter");
                            entity.put("Baxter", baxter.getController().getTransition("init"));
                            render.put("Baxter", entity.get("Baxter"));
                            sprite = entity.get("Baxter").getSprite();
                            render.get("Baxter").setSprite(sprite);
                        }
                        else if(entry.getKey().equals("ButtonLeaderBoard")) {
                            /* update button sprites */
                            SpriteStaticButton button;
                            button = (SpriteStaticButton) entity.get("ButtonHome");
                            button.setState("turn off");
                            render.put("ButtonHome", button);
                            button = (SpriteStaticButton) entity.get("ButtonTimeChallenge");
                            button.setState("turn off");
                            render.put("ButtonTimeChallenge", button);
                            button = (SpriteStaticButton) entity.get("ButtonCreativeMode");
                            button.setState("turn off");
                            render.put("ButtonCreativeMode", button);
                            button = (SpriteStaticButton) entity.get("ButtonLeaderBoard");
                            button.setState("turn on");
                            render.put("ButtonLeaderBoard", button);
                            button = (SpriteStaticButton) entity.get("ButtonRate");
                            button.setState("turn off");
                            render.put("ButtonRate", button);
                            /* set background sprites */
                            Sprite sprite;
                            sprite = entity.get("BackgroundLeaderBoard").getSprite();
                            render.get("Background").setSprite(sprite);
                            sprite = entity.get("BackgroundLeaderBoardDarkMovingFlair").getSprite();
                            sprite.setXPos(render.get("BackgroundDarkMovingFlair").getSprite().getXPos());
                            sprite.setYPos(render.get("BackgroundDarkMovingFlair").getSprite().getYPos());
                            render.get("BackgroundDarkMovingFlair").setSprite(sprite);
                            sprite = entity.get("BackgroundLeaderBoardLightMovingFlair").getSprite();
                            sprite.setXPos(render.get("BackgroundLightMovingFlair").getSprite().getXPos());
                            sprite.setYPos(render.get("BackgroundLightMovingFlair").getSprite().getYPos());
                            render.get("BackgroundLightMovingFlair").setSprite(sprite);

                            /* experimental: transition baxter to happy or sad */
                            SpriteEntity baxter = entity.get("Baxter");
                            entity.put("Baxter", baxter.getController().getTransition("sad"));
                            render.put("Baxter", entity.get("Baxter"));
                            sprite = entity.get("Baxter").getSprite();
                            render.get("Baxter").setSprite(sprite);

                        }
                        else if(entry.getKey().equals("ButtonRate")) {
                            /* update button sprites */
                            SpriteStaticButton button;
                            button = (SpriteStaticButton) entity.get("ButtonHome");
                            button.setState("turn off");
                            render.put("ButtonHome", button);
                            button = (SpriteStaticButton) entity.get("ButtonTimeChallenge");
                            button.setState("turn off");
                            render.put("ButtonTimeChallenge", button);
                            button = (SpriteStaticButton) entity.get("ButtonCreativeMode");
                            button.setState("turn off");
                            render.put("ButtonCreativeMode", button);
                            button = (SpriteStaticButton) entity.get("ButtonLeaderBoard");
                            button.setState("turn off");
                            render.put("ButtonLeaderBoard", button);
                            button = (SpriteStaticButton) entity.get("ButtonRate");
                            button.setState("turn on");
                            render.put("ButtonRate", button);
                            /* set background sprites */
                            Sprite sprite;
                            sprite = entity.get("BackgroundRate").getSprite();
                            render.get("Background").setSprite(sprite);
                            sprite = entity.get("BackgroundRateDarkMovingFlair").getSprite();
                            sprite.setXPos(render.get("BackgroundDarkMovingFlair").getSprite().getXPos());
                            sprite.setYPos(render.get("BackgroundDarkMovingFlair").getSprite().getYPos());
                            render.get("BackgroundDarkMovingFlair").setSprite(sprite);
                            sprite = entity.get("BackgroundRateLightMovingFlair").getSprite();
                            sprite.setXPos(render.get("BackgroundLightMovingFlair").getSprite().getXPos());
                            sprite.setYPos(render.get("BackgroundLightMovingFlair").getSprite().getYPos());
                            render.get("BackgroundLightMovingFlair").setSprite(sprite);

                            /* experimental: transition baxter to happy or sad */
                            SpriteEntity baxter = entity.get("Baxter");
                            entity.put("Baxter", baxter.getController().getTransition("happy"));
                            render.put("Baxter", entity.get("Baxter"));
                            sprite = entity.get("Baxter").getSprite();
                            render.get("Baxter").setSprite(sprite);

                        }
                    }
                }
            }
        }
    }

}
