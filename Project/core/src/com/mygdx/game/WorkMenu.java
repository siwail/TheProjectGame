package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class WorkMenu extends Openable implements Screen {
    SpriteBatch batch = new SpriteBatch();
    Sound upgrade;
    Thread anime;
    Thread anime_hand;
    Texture frame;
    Texture background;
    Texture metal;
    Texture red;
    Texture lampt;
    Texture lightt;
    TextureRegion lamp;
    TextureRegion light;
    double x = 0.0;
    int y = 0;
    double scale = 1.35;
    float rotlamp = 0.0f;
    float rothand = 0;
    float rothead = 0;
    float rotleg = 0;
    float rot = 0;
    int which_select = 0;
    int light_anime = 1;
    public WorkMenu(MainGame mainGame){
        this.game = mainGame;
    }
    @Override
    public void show() {
        game.robot.SetWorkMenuTextures();
        Gdx.input.setInputProcessor(new WorkMenuTouch(game, this));
        Start();
        upgrade = Gdx.audio.newSound(Gdx.files.internal("Sound/upgrade.wav"));
        x = width/2-400;
        lampt = new Texture("Interface/lamp_full.png");
        lamp = new TextureRegion(lampt, 1280, 720);
        frame = new Texture("Interface/frame.png");
        background = new Texture("Interface/back.png");
        red = new Texture("Button/button_red.png");
        metal = new Texture("Interface/metalic.png");
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
        anime_hand = new Thread(){
            @Override
            public void run(){
                int dir = 0;
                int dir_lamp = 0;
                int time = game.random.nextInt(10)+6;
                while(true){
                    if(dir_lamp == 1){
                        rotlamp+=0.2f;
                        if(rotlamp>=10){
                            dir_lamp=0;
                        }
                    }else{
                        rotlamp-=0.2f;
                        if(rotlamp<=-10){
                            dir_lamp=1;
                        }
                    }
                    if(dir==1){
                        x+=0.1;
                        scale-=0.0008f;
                        rothead+=0.2f;
                        rothand-=0.1f;
                        if(rothead>=4.0f){
                            dir=2;
                            time = game.random.nextInt(10)+6;
                        }
                    }else{
                        x-=0.1;
                        scale+=0.0008f;
                        rothead-=0.2f;
                        rothand+=0.1f;
                        if(rothead<=-4.0f){
                            dir=1;
                            time = game.random.nextInt(10)+6;
                        }
                    }
                    if(closed){
                        break;
                    }
                    Sleep( time);
                }
            }
        };
        drawer = new SpriteBatchRubber(this, batch);
        anime_hand.start();
        anime.start();
        DoorOpen();
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        batch.begin();
        if(light_anime<3) {
            lightt = new Texture("Interface/light" + light_anime + ".png");
        }
        light = new TextureRegion(lightt, 1280, 720);
        drawer.draw(background, 0, 0, width, height);
        drawer.draw(red, 10, height-150, 150, 150);
        drawer.draw(frame, 10, height-350, 150, 150);
        drawer.draw(frame, 10, height-500, 150, 150);
        drawer.draw(frame, 10, height-650, 150, 150);
        drawer.draw(frame, 10, height-800, 150, 150);
        drawer.draw(metal, width/2+250, 25, width/2-300, height-50);
        DrawRobot(drawer, (int)x, y, scale, rothand, rothead, rotleg, rot, false, false, false, 90);
        DrawSelect(drawer, (int)x, y, scale, rothand, rothead, rotleg, rot, which_select);
        drawer.draw(light, -200.0f, -200, (float)(width/2-100), height+350.0f, (float) (width), (float) (height+300), 1, 1, rotlamp);
        drawer.draw(lamp, -200.0f, -250, (float)(width/2-100), height+350.0f, (float) (width), (float) (height+300), 1, 1, rotlamp);
        CheckOpen(drawer);
        CheckClose(drawer);
        batch.end();
        lightt.dispose();
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
        upgrade.dispose();
        batch.dispose();
        game.robot.DisposeWorkMenuTextures();
        lightt.dispose();
        lampt.dispose();
        red.dispose();
        background.dispose();
        frame.dispose();
        door_left.dispose();
        door_right.dispose();
    }
}