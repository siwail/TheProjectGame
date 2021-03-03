package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMenu implements Screen{
    Game game;
    Texture camp;
    Thread anime;
    SpriteBatch batch;
    int width;
    int height;
    public GameMenu(Game game) {
    this.game = game;

    }

    @Override
    public void show() {
        width = Gdx.graphics.getWidth()*2;
        height = Gdx.graphics.getHeight()*2;
        camp = new Texture("camp_2.png");
        batch = new SpriteBatch();
        anime = new Thread(){
            @Override
            public void run(){
                while(width > Gdx.graphics.getWidth() || height > Gdx.graphics.getHeight() ){
                    if(width > Gdx.graphics.getWidth()){
                        width-=25;
                    }
                    if(height > Gdx.graphics.getHeight()){
                        height-=25;
                    }
                    try{
                        sleep(5);
                    }catch (Exception ignored){

                    }
                }
            }
        };
        anime.start();
    }

    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        batch.begin();
        batch.draw(camp, 0, 0, width, height);
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

    }

}
