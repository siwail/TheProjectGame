package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Openable {
    MainGame game;
    Texture door_left;
    Texture door_right;
    Thread door;
    boolean closed = false;
    boolean willClose = false;
    boolean isOpen = false;
    int width;
    int height;
    int open_x;
    public void Start(){
        door_left =  new Texture("door_1.png");
        door_right=  new Texture("door_2.png");
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        open_x = width/2;
    }
    public void DoorOpen(){
        door = new Thread(){
            @Override
            public void run(){
                Sleep(this, 1000);
                while(open_x < width) {
                    open_x += 5;
                    Sleep(this, 5);
                }
                isOpen = true;
            }
        };
        door.start();
    }
    public void DoorClose(){
        if(!willClose) {
            willClose = true;
            door = new Thread() {
                @Override
                public void run() {
                    while (open_x > 0) {
                        open_x -= 5;
                        Sleep(this, 5);
                    }
                    closed = true;
                }
            };
            door.start();
        }
    }

    public void CheckOpen(SpriteBatch drawer){
        if(!isOpen) {
            drawer.draw(door_right, open_x, 0, width, height);
            drawer.draw(door_left, -open_x, 0, width, height);
        }
    }
    public void CheckClose(SpriteBatch drawer){
        if (willClose) {
            drawer.draw(door_left, -open_x, 0, width, height);
            drawer.draw(door_right, open_x, 0, width, height);
        }
    }
    public void Sleep(Thread t, int time){
        try {
            t.sleep(time);
        } catch (Exception ignored) { }
    }


}
