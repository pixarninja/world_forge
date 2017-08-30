package com.pixarninja.sprite_renderer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    SpriteView spriteView;
    LinkedHashMap<String, SpriteController> controllerMap;
    SpriteEntity entity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initialize the render and controller maps */
        controllerMap = new LinkedHashMap<>();

        /* set center view */
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int maxRes = height * 2;
        int width = displayMetrics.widthPixels;
        spriteView = (SpriteView) findViewById(R.id.spriteView);

        /* background */
        entity = new Background(getResources(), 1, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4),
                0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop");
        controllerMap.put("BackgroundController", entity.getController());

        /* dark pattern for background */

        /* light flair for background */

        /* initialize box controller */
        entity = new BoxRed(getResources(), 0.65, maxRes / 2, maxRes / 2, width, height);
        controllerMap.put("BoxController", entity.getController());

        /* red button */
        entity = new SpriteButton(getResources(), 1, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_home_on, R.mipmap.button_home_off, R.mipmap.button_home_off,
                0, 0, (8 * height / 10), (8 * height / 10), 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop");
        controllerMap.put("RedButtonController", entity.getController());

        /* green button */
        entity = new SpriteButton(getResources(), 1, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_creativemode_on, R.mipmap.button_creativemode_off, R.mipmap.button_creativemode_off,
                0, 0, (8 * height / 10), (8 * height / 10), 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop");
        controllerMap.put("RedButtonController", entity.getController());

        /* blue button */
        entity = new SpriteButton(getResources(), 1, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_rate_on, R.mipmap.button_rate_off, R.mipmap.button_rate_off,
                0, 0, (8 * height / 10), (8 * height / 10), 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop");
        controllerMap.put("RedButtonController", entity.getController());

        /* set frame rate for all controllers */
        for(LinkedHashMap.Entry<String,SpriteController> controller : controllerMap.entrySet()) {
            controller.getValue().setFrameRate(35);
        }

        /* initialize the entity for the sprite view */
        spriteView.setControllerMap(controllerMap);

    }

}
