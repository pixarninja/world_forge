package com.pixarninja.sprite_renderer;

import java.util.LinkedHashMap;

abstract class SpriteController {

    private LinkedHashMap<String, SpriteEntity> controller;
    private SpriteEntity entity;

    public LinkedHashMap<String, SpriteEntity> getController() { return this.controller; }
    public void setController(LinkedHashMap<String, SpriteEntity> controller) { this.controller = controller; }

    public SpriteEntity getEntity() { return this.entity; }
    public void setEntity(SpriteEntity entity) { this.entity = entity; }

    public SpriteEntity getTransition(String ID) { return this.controller.get(ID); }
    public void setTransition(String ID, SpriteEntity entity) { this.controller.put(ID, entity); }

    public Sprite getSprite(String ID) { return getTransition(ID).getSprite(); }

}
