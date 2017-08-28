package com.pixarninja.sprite_renderer;

import android.content.res.Resources;

import java.util.LinkedHashMap;

public class BaxterController extends SpriteController{

    public BaxterController(Resources res, double percentOfScreen, int xRes, int yRes, int width, int height) {

        /* instantiate baxter characters */
        SpriteCharacter init = new BaxterInit(res, percentOfScreen, xRes, yRes, width, height);
        SpriteCharacter happy = new BaxterHappy(res, percentOfScreen, xRes, yRes, width, height);
        SpriteCharacter sad = new BaxterSad(res, percentOfScreen, xRes, yRes, width, height);

        /* set frame rate for each chracter */
        init.setFrameRate(35);
        happy.setFrameRate(35);
        sad.setFrameRate(35);

        /* initialize character rendered */
        setEntity(init);

        /* store the transitions into the controller */
        LinkedHashMap<String, SpriteEntity> controller = new LinkedHashMap<>();
        controller.put("init", init);
        controller.put("happy", happy);
        controller.put("sad", sad);
        setController(controller);
        init.setController(this);
        happy.setController(this);
        sad.setController(this);

    }

}
