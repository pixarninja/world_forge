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
        spriteView = (SpriteView) findViewById(R.id.spriteView);
        SpriteThread spriteThread = new SpriteThread(spriteView);
        spriteThread.setRunning(true);
        spriteThread.start();
        spriteView.setSpriteThread(spriteThread);

        int height = (int)(displayMetrics.heightPixels * 0.8);
        int maxRes = height * 2;
        int width = (int)(displayMetrics.widthPixels);

        /* background */
        spriteView.setBackgroundResource(R.drawable.background_red);

        /* dark pattern */
        entity = new DarkPattern(spriteView, getResources(), 3, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4),
                -1, 1, 0, -500, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop", null, "init");
        controllerMap.put("DarkPatternController", entity.getController());

        /* light pattern */
        entity = new LightPattern(spriteView, getResources(), 3, width, height, (int)(maxRes * 0.4), (int)(maxRes * 0.4),
                1, -1, -500, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop", null, "init");
        controllerMap.put("LightPatternController", entity.getController());

        /* red button */
        entity = new SpriteButton(spriteView, getResources(), 0.1, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_red_on, R.mipmap.button_red_off, R.mipmap.button_red_off,
                0, 0, (0.75 * width / 3), (8 * height / 10), 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop", null, "init on");
        controllerMap.put("RedButtonController", entity.getController());

        /* green button */
        entity = new SpriteButton(spriteView, getResources(), 0.1, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_green_on, R.mipmap.button_green_off, R.mipmap.button_green_off,
                0, 0, (1.5 * width / 3), (8 * height / 10), 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop", null, "init off");
        controllerMap.put("GreenButtonController", entity.getController());

        /* blue button */
        entity = new SpriteButton(spriteView, getResources(), 0.1, width, height, (int)(maxRes * 0.025), (int)(maxRes * 0.025), R.mipmap.button_blue_on, R.mipmap.button_blue_off, R.mipmap.button_blue_off,
                0, 0, (2.25 * width / 3), (8 * height / 10), 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, "loop", null, "init off");
        controllerMap.put("BlueButtonController", entity.getController());

        /* initialize box controller */
        entity = new BoxRed(spriteView, getResources(), 0.65, maxRes / 2, maxRes / 2, width, height, null, "init");
        controllerMap.put("BoxController", entity.getController());

        /* set frame rate for all controllers */
        for(LinkedHashMap.Entry<String,SpriteController> controller : controllerMap.entrySet()) {
            controller.getValue().setFrameRate(35);
        }

        /* initialize the entity for the sprite view */
        spriteView.setControllerMap(controllerMap);

        /* print memory statistics */
        final Runtime runtime = Runtime.getRuntime();
        final long usedMemInMB=(runtime.totalMemory() - runtime.freeMemory()) / 1048576L;
        final long maxHeapSizeInMB=runtime.maxMemory() / 1048576L;
        final long availHeapSizeInMB = maxHeapSizeInMB - usedMemInMB;
        System.out.println("Memory Used: " + usedMemInMB + "MB");
        System.out.println("Max Heap Size: " + maxHeapSizeInMB + "MB");
        System.out.println("Avaliable Heap Size: " + availHeapSizeInMB + "MB");

    }

    @Override
    protected void onResume() {
        super.onResume();
        spriteView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        spriteView.onPause();
    }

}
