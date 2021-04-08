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
    int open_x = 0;
    public void Start(){
        door_left =  new Texture("door_1.png");
        door_right=  new Texture("door_2.png");
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        open_x = width/2;
    }
    public void DrawRobot(SpriteBatch drawer, int x, int y, int scale, int rothand, int rothead, int rotleg, int rot) {
        drawer.draw(game.robot.H, x+100, y+350, 0, 0, 200, 200, scale, scale,(float) rot);
        drawer.draw(game.robot.B, x+100, y+150, 0, 0, 200, 200, scale, scale, (float)rot);
        drawer.draw(game.robot.LH, x, y+200, 0, 0, 200, 200, scale, scale, (float) rot);
        drawer.draw(game.robot.RH, x+200, y+200, 0, 0, 200, 200, scale, scale, (float)rot);
        drawer.draw(game.robot.LL, x, y, 0, 0, 200, 200, scale, scale,(float)rot);
        drawer.draw(game.robot.RL, x+200, y, 0, 0, 200, 200, scale, scale,(float)rot);


    }
    public void DoorOpen(){
        door = new Thread(){
            @Override
            public void run(){
                Sleep(this, 1000);
                while(open_x < width/2) {
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