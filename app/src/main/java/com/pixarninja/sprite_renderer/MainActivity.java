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

        /* initialize box controller */
        entity = new BoxRed(getResources(), 0.65, maxRes / 2, maxRes / 2, width, height, null, "init");
        controllerMap.put("BoxController", entity.getController());

        /* red button */
        entity = new SpriteButton(getResources(), 0.1, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_red_on, R.mipmap.button_red_off, R.mipmap.button_red_off,
                0, 0, (0.75 * width / 3), (8 * height / 10), 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop");
        controllerMap.put("RedButtonController", entity.getController());

        /* green button */
        entity = new SpriteButton(getResources(), 0.1, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_green_on, R.mipmap.button_green_off, R.mipmap.button_green_off,
                0, 0, (1.5 * width / 3), (8 * height / 10), 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop");
        controllerMap.put("GreenButtonController", entity.getController());

        /* blue button */
        entity = new SpriteButton(getResources(), 0.1, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_blue_on, R.mipmap.button_blue_off, R.mipmap.button_blue_off,
                0, 0, (2.25 * width / 3), (8 * height / 10), 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop");
        controllerMap.put("BlueButtonController", entity.getController());

        /* set frame rate for all controllers */
        for(LinkedHashMap.Entry<String,SpriteController> controller : controllerMap.entrySet()) {
            controller.getValue().setFrameRate(35);
        }

        /* initialize the entity for the sprite view */
        spriteView.setControllerMap(controllerMap);

    }

}
