package com.pixarninja.world_forge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

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

        /* set bottom view */
        TextView score = (TextView) findViewById(R.id.output);
        String newText = "Welcome to the World Forge! Using the buttons above, you have the power to create new worlds! Each button serves a specific purpose, it is your duty to find the combination of buttons that yields the most populated civilization...\nGood luck, Mighty Creator!";
        score.setText(newText);

        /* width and height are multiplied by the factor the SpriteView is set in comparison to the screen */
        int height = (int)(displayMetrics.heightPixels * 0.75);
        int width = (int)(displayMetrics.widthPixels * 1.0);
        int maxRes = width;

        /* background */
        spriteView.setBackgroundResource(R.drawable.white_square);

        /* world forge */
        entity = new WorldForge(getResources(), 1, width, height, maxRes, maxRes);
        controllerMap.put("WorldForgeController", entity.getController());

        /* buttons strip */
        entity = new SpriteProp(getResources(), 1, width, height, maxRes, maxRes, R.drawable.colored_strip,
                0, 0, 0, 8 * height / 10, 1, 1, 1,
                1, 1, 0, 0, 1, 1, "loop", "forwards", null, "strip", "init");
        controllerMap.put("StripController", entity.getController());

        /* fire button */
        entity = new SpriteButton(getResources(), 0.15, width, height, maxRes, maxRes, R.mipmap.button_fire_off, R.mipmap.button_fire_off, R.mipmap.button_fire_on,
                0, 0, width / 6, 8.85 * height / 10, 1, 1, 1, 1, 1, 0, 0, 1, 1, "forwards", null, "button fire", "init");
        controllerMap.put("FireButtonController", entity.getController());

        /* water button */
        entity = new SpriteButton(getResources(), 0.15, width, height, maxRes, maxRes, R.mipmap.button_water_off, R.mipmap.button_water_off, R.mipmap.button_water_on,
                0, 0, (2 * width / 6), 8.85 * height / 10, 1, 1, 1, 1, 1, 0, 0, 1, 1, "forwards", null, "button water", "init");
        controllerMap.put("WaterButtonController", entity.getController());

        /* wood button */
        entity = new SpriteButton(getResources(), 0.15, width, height, maxRes, maxRes, R.mipmap.button_wood_off, R.mipmap.button_wood_off, R.mipmap.button_wood_on,
                0, 0, (3 * width / 6), 8.85 * height / 10, 1, 1, 1, 1, 1, 0, 0, 1, 1, "forwards", null, "button wood", "init");
        controllerMap.put("WoodButtonController", entity.getController());

        /* earth button */
        entity = new SpriteButton(getResources(), 0.15, width, height, maxRes, maxRes, R.mipmap.button_earth_off, R.mipmap.button_earth_off, R.mipmap.button_earth_on,
                0, 0, (4 * width / 6), 8.85 * height / 10, 1, 1, 1, 1, 1, 0, 0, 1, 1, "forwards", null, "button earth", "init");
        controllerMap.put("EarthButtonController", entity.getController());

        /* stone button */
        entity = new SpriteButton(getResources(), 0.15, width, height, maxRes, maxRes, R.mipmap.button_stone_off, R.mipmap.button_stone_off, R.mipmap.button_stone_on,
                0, 0, (5 * width / 6), 8.85 * height / 10, 1, 1, 1, 1, 1, 0, 0, 1, 1, "forwards", null, "button stone", "init");
        controllerMap.put("StoneButtonController", entity.getController());

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
        System.out.println("Available Heap Size: " + availHeapSizeInMB + "MB");

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
