package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;
public class GamePlay extends Openable implements Screen{
    SpriteBatch batch;
    Thread anime_hand;
    Texture floor;
    Texture background;
    public GamePlay(MainGame game) { this.game = game; }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(new GamePlayTouch(game, this));
        Start();
        background = new Texture("background.png");
        floor = new Texture("grass_alpha.png");
        open_x = 0;
        batch = new SpriteBatch();
        anime_hand = new Thread(){
            @Override
            public void run(){
                while(true){

                    Sleep(this, 100);
                }
            }
        };
        anime_hand.start();
        DoorOpen();
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, width, height);

        batch.draw(floor, 0, height/2-150, width, height/4);
        batch.draw(floor, 0, height/4-100, width, height/4);
        batch.draw(floor, 0, -50, width, height/4);

        CheckClose(batch);
        CheckOpen(batch);
        batch.end();
    }
    @Override
    public void dispose (){
        batch.dispose();
        floor.dispose();
    }
}
