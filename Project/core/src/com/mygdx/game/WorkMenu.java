package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class WorkMenu extends Openable implements Screen {
    SpriteBatch batch = new SpriteBatch();
    Thread anime;
    Texture frame;
    Texture background;
    Texture metal;
    Texture red;
    Texture lamp;
    Texture light;
    int light_anime = 1;
    public WorkMenu(MainGame mainGame){
        this.game = mainGame;
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(new WorkMenuTouch(game, this));
        Start();

        lamp = new Texture("lamp.png");
        frame = new Texture("frame.png");
        background = new Texture("back.png");
        red = new Texture("button_red.png");
        metal = new Texture("metalic.png");
        open_x = 0;

        anime  = new Thread(){
            @Override
            public void run(){
                while(true){
                    light_anime++;
                    if (light_anime>2){
                        light_anime=1; }
                    if(closed){
                        break;
                    }
                    Sleep( 500);
                }
            }
        };
        anime.start();
        DoorOpen();
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        batch.begin();
        light = new Texture("light"+ light_anime +".png");
        batch.draw(background, 0, 0, width, height);
        batch.draw(red, 250, height-145, 150, 150);
        batch.draw(frame, 50, height-200, 125, 125);
        batch.draw(frame, 50, height-325, 125, 125);
        batch.draw(frame, 50, height-450, 125, 125);
        batch.draw(frame, 50, height-575, 125, 125);
        batch.draw(frame, 50, height-700, 125, 125);
        batch.draw(metal, width/2+250, 25, width/2-300, height-50);
        batch.draw(light, width/2-500, -50, 1000, height);
        batch.draw(lamp, width/2-200, height-200, 400,350);
        CheckOpen(batch);
        CheckClose(batch);

        batch.end();

        light.dispose();

        if(closed){
            game.setGameMenu();
        }

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
        light.dispose();
        lamp.dispose();
        red.dispose();
        background.dispose();
        frame.dispose();
        door_left.dispose();
        door_right.dispose();
    }
}