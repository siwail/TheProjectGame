package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class WorkMenu extends Openable implements Screen {
    SpriteBatch batch = new SpriteBatch();
    Texture frame;
    Texture back;
    Texture metal;
    Texture red;
    public WorkMenu(MainGame mainGame){
        this.game = mainGame;
    }
    @Override
    public void show() {
        Start();
        frame = new Texture("frame.png");
        back = new Texture("back.png");
        red = new Texture("button_red.png");
        metal = new Texture("metalic.png");
        open_x = 0;
        DoorOpen();
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
        CheckOpen(batch);
        batch.end();
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