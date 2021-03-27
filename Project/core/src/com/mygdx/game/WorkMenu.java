package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class WorkMenu implements Screen {
    MainGame mainGame;
    SpriteBatch batch = new SpriteBatch();
    Thread anime;
    Thread door;
    Texture frame;
    Texture door_left;
    Texture back;
    Texture door_right;
    Texture metal;
    Texture red;
    boolean isOpen = false;
    boolean willClose;
    int open_x;
    int height;
    int width;
    public WorkMenu(MainGame mainGame){
        this.mainGame = mainGame;
    }
    @Override
    public void show() {
        height = Gdx.graphics.getHeight();
        width = Gdx.graphics.getWidth();
        frame = new Texture("frame.png");
        door_left =  new Texture("door_1.png");
        door_right=  new Texture("door_2.png");
        back = new Texture("back.png");
        red = new Texture("button_red.png");
        metal = new Texture("metalic.png");
        door = new Thread(){
            @Override
            public void run(){
                Sleep(this,1000);
                while(open_x < width) {
                    open_x += 5;
                    Sleep(this,5);
                }
                isOpen = true;
            }

        };
        door.start();
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        batch.begin();
        batch.draw(back, 0, 0, width, height);
        batch.draw(frame, 50, height-200, 125, 125);
        batch.draw(frame, 50, height-325, 125, 125);
        batch.draw(frame, 50, height-450, 125, 125);
        batch.draw(frame, 50, height-575, 125, 125);
        batch.draw(frame, 50, height-700, 125, 125);
        batch.draw(metal, width/2+250, 25, width/2-300, height-50);
        if(!isOpen) {
            batch.draw(door_right, open_x, 0, width, height);
            batch.draw(door_left, -open_x, 0, width, height);
        }
        batch.end();
    }
    public void Sleep(Thread t, int time){
        try {
            t.sleep(time);
        } catch (Exception ignored) { }
    }
    @Override
    public void resize(int width, int height) { }
    @Override
    public void pause() { }
    @Override
    public void resume() { }
    @Override
    public void hide() { }
    @Override
    public void dispose() {
        back.dispose();
        frame.dispose();
        door_left.dispose();
        door_right.dispose();
    }
}