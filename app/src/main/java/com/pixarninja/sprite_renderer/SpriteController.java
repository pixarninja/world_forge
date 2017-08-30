package com.pixarninja.sprite_renderer;

import java.util.LinkedHashMap;

public class SpriteController {

    private SpriteEntity entity;
    private double xInit;
    private double yInit;
    private double xPos;
    private double yPos;
    private double xDelta;
    private double yDelta;
    private int frameLengthInMilliseconds = 35;
    private long lastFrameChangeTime;


    public SpriteEntity getEntity() { return this.entity; }
    public void setEntity(SpriteEntity entity) { this.entity = entity; }

    public double getXInit() { return this.xInit; }
    public void setXInit(double xInit) { this.xInit = xInit; }

    public double getYInit() { return this.yInit; }
    public void setYInit(double yInit) { this.yInit = yInit; }

    public double getXPos() { return this.xPos; }
    public void setXPos(double xPos) { this.xPos = xPos; }

    public double getYPos() { return this.yPos; }
    public void setYPos(double yPos) { this.yPos = yPos; }

    public double getXDelta() {
        return this.xDelta;
    }
    public void setXDelta(double xDelta) {
        this.xDelta = xDelta;
    }

    public double getYDelta() {
        return this.yDelta;
    }
    public void setYDelta(double yDelta) {
        this.yDelta = yDelta;
    }

    public int getFrameRate() { return this.frameLengthInMilliseconds; }
    public void setFrameRate(int frameLengthInMilliseconds) { this.frameLengthInMilliseconds = frameLengthInMilliseconds; }

    public long getLastFrameChangeTime() { return this.lastFrameChangeTime; }
    public void setLastFrameChangeTime(long lastFrameChangeTime) { this.lastFrameChangeTime = lastFrameChangeTime; }

    public void makeTransition(String ID) {
        this.entity.refreshCharacter(ID);
    }

}