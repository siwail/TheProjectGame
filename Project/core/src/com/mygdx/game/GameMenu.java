package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.xml.soap.Text;

public class GameMenu implements Screen{
    MainGame game;
    Texture camp;
    Thread anime;
    private SpriteBatch batch;
    Texture door_left;
    Texture door_right;
    int open_x;
    boolean isOpen = false;
    int width;
    int height;

    public GameMenu(MainGame game) {
    this.game = game;


    }

    @Override
    public void show() {
        door_left =  new Texture("door_1.png");
        door_right=  new Texture("door_2.png");
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        camp = new Texture("camp_2.png");
        batch = new SpriteBatch();
        anime = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(1000);
                } catch (Exception ignored) {

                }
                    while(open_x < width) {
                        open_x += 5;

                        try {
                            sleep(5);
                        } catch (Exception ignored) {

                        }
                    }
                    isOpen = true;
                    door_left.dispose();
                    door_right.dispose();
                }

        };
        anime.start();
    }

    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        batch.begin();
        batch.draw(camp, 0, 0, width, height);
        if(!isOpen) {
            batch.draw(door_right, open_x, 0, width, height);
            batch.draw(door_left, -open_x, 0, width, height);

        }


        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

}

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose () {
    camp.dispose();
    batch.dispose();
    }

}
