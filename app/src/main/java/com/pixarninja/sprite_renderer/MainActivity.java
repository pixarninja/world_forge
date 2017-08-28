package com.pixarninja.sprite_renderer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    SpriteView spriteView;
    LinkedHashMap<String, SpriteEntity> entity;
    LinkedHashMap<String, SpriteEntity> render;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initialize the array of sprite entities */
        entity = new LinkedHashMap<>();
        render = new LinkedHashMap<>();
        Sprite sprite;

        /* set center view */
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int maxRes = height * 2;
        int width = displayMetrics.widthPixels;
        spriteView = (SpriteView) findViewById(R.id.spriteView);

        /* background */
        entity.put("BackgroundHome", new SpriteBackground(getResources(), 1, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_home,
                0, 0, false, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundTimeChallenge", new SpriteBackground(getResources(), 1, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_timechallenge,
                0, 0, false, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundCreativeMode", new SpriteBackground(getResources(), 1, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_creativemode,
                0, 0, false, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundLeaderBoard", new SpriteBackground(getResources(), 1, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_leaderboard,
                0, 0, false, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundRate", new SpriteBackground(getResources(), 1, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_rate,
                0, 0, false, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        render.put("Background", new SpriteBackground(getResources(), 1, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_home,
                0, 0, false, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));

        /* dark flair for background */
        entity.put("BackgroundHomeDarkMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_home_black,
                -3, 3, true, width / -5, height / -5, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundTimeChallengeDarkMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_timechallenge_black,
                -3, 3, true, width / -5, height / -5, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundCreativeModeDarkMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_creativemode_black,
                -3, 3, true, width / -5, height / -5, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundLeaderBoardDarkMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_leaderboard_black,
                -3, 3, true, width / -5, height / -5, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundRateDarkMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_rate_black,
                -3, 3, true, width / -5, height / -5, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        render.put("BackgroundDarkMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_home_black,
                -3, 3, true, width / -5, height / -5, 1, 1, 1, 1, 1, 0, 0, 1, 1, null));

        /* light flair for background */
        entity.put("BackgroundHomeLightMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_home_white,
                3, 3, true, (width / -5) + (width / 20), (height / -5) + (height / 20), 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundTimeChallengeLightMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_timechallenge_white,
                3, 3, true, (width / -5) + (width / 20), (height / -5) + (height / 20), 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundCreativeModeLightMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_creativemode_white,
                3, 3, true, (width / -5) + (width / 20), (height / -5) + (height / 20), 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundLeaderBoardLightMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_leaderboard_white,
                3, 3, true, (width / -5) + (width / 20), (height / -5) + (height / 20), 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        entity.put("BackgroundRateLightMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_rate_white,
                3, 3, true, (width / -5) + (width / 20), (height / -5) + (height / 20), 1, 1, 1, 1, 1, 0, 0, 1, 1, null));
        render.put("BackgroundLightMovingFlair", new SpriteBackground(getResources(), 1.25, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4), R.mipmap.background_home_white,
                3, 3, true, (width / -5) + (width / 20), (height / -5) + (height / 20), 1, 1, 1, 1, 1, 0, 0, 1, 1, null));

        /* initialize baxter controller */
        BaxterController baxterController = new BaxterController(getResources(), 0.65, maxRes / 2, maxRes / 2, width, height);

        /* initialize baxter that is rendered to the screen */
        entity.put("Baxter", baxterController.getEntity());
        sprite = entity.get("Baxter").getSprite();
        sprite.setYPos(sprite.getYPos() - (height / 15));
        entity.get("Baxter").setSprite(sprite);

        /* home button */
        entity.put("ButtonHome", new SpriteStaticButton(getResources(), 0.11, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_home_on, R.mipmap.button_home_off,
            0, 0, false, width, height));
        sprite = entity.get("ButtonHome").getSprite();
        sprite.setXPos((0.5 * width / 5) - ((sprite.getSpriteWidth()) / 2));
        sprite.setYPos((8 * height / 10) - (sprite.getSpriteHeight() / 2));
        entity.get("ButtonHome").setSprite(sprite);

        /* time challenge button */
        entity.put("ButtonTimeChallenge", new SpriteStaticButton(getResources(), 0.11, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_timechallenge_on, R.mipmap.button_timechallenge_off,
                0, 0, false, width, height));
        sprite = entity.get("ButtonTimeChallenge").getSprite();
        sprite.setXPos((1.5 * width / 5) - ((sprite.getSpriteWidth()) / 2));
        sprite.setYPos((8 * height / 10) - (sprite.getSpriteHeight() / 2));
        entity.get("ButtonTimeChallenge").setSprite(sprite);

        /* creative mode button */
        entity.put("ButtonCreativeMode", new SpriteStaticButton(getResources(), 0.11, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_creativemode_on, R.mipmap.button_creativemode_off,
                0, 0, false, width, height));
        sprite = entity.get("ButtonCreativeMode").getSprite();
        sprite.setXPos((2.5 * width / 5) - ((sprite.getSpriteWidth()) / 2));
        sprite.setYPos((8 * height / 10) - (sprite.getSpriteHeight() / 2));
        entity.get("ButtonCreativeMode").setSprite(sprite);

        /* leader board button */
        entity.put("ButtonLeaderBoard", new SpriteStaticButton(getResources(), 0.11, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_leaderboard_on, R.mipmap.button_leaderboard_off,
                0, 0, false, width, height));
        sprite = entity.get("ButtonLeaderBoard").getSprite();
        sprite.setXPos((3.5 * width / 5) - ((sprite.getSpriteWidth()) / 2));
        sprite.setYPos((8 * height / 10) - (sprite.getSpriteHeight() / 2));
        entity.get("ButtonLeaderBoard").setSprite(sprite);

        /* rate button */
        entity.put("ButtonRate", new SpriteStaticButton(getResources(), 0.11, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_rate_on, R.mipmap.button_rate_off,
                0, 0, false, width, height));
        sprite = entity.get("ButtonRate").getSprite();
        sprite.setXPos((4.5 * width / 5) - ((sprite.getSpriteWidth()) / 2));
        sprite.setYPos((8 * height / 10) - (sprite.getSpriteHeight() / 2));
        entity.get("ButtonRate").setSprite(sprite);

        /* set frame rate for all sprite entities */
        for(LinkedHashMap.Entry<String,SpriteEntity> entry : entity.entrySet()) {
            if(entry.getValue() != null) {
                entry.getValue().setFrameRate(35);
            }
        }

        /* initializing sprites */
        render.put("Baxter", entity.get("Baxter"));
        render.put("ButtonHome", entity.get("ButtonHome"));
        render.put("ButtonTimeChallenge", entity.get("ButtonTimeChallenge"));
        render.put("ButtonCreativeMode", entity.get("ButtonCreativeMode"));
        render.put("ButtonLeaderBoard", entity.get("ButtonLeaderBoard"));
        render.put("ButtonRate", entity.get("ButtonRate"));


        /* initialize the entity for the sprite view */
        spriteView.setEntity(entity);
        spriteView.setRender(render);

    }

}
