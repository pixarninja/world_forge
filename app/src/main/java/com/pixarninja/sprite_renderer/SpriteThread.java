package com.pixarninja.sprite_renderer;

public class SpriteThread extends Thread implements Runnable {

    SpriteView spriteView;
    private boolean running = false;


    public SpriteThread(SpriteView view) {
        spriteView = view;
    }

    public boolean getRunning() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while(running){

            if(spriteView.getControllerMap() != null) {
                spriteView.drawSprite();
            }

            try {
                sleep(spriteView.getFrameRate());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /*public void onResume(){
        isRunning = true;
        spriteThread = new SpriteThread(render[0], this);
        spriteThread.start();
    }

    public void onPause(){
        boolean retry = true;
        isRunning = false;
        while(retry){
            try {
                spriteThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

}