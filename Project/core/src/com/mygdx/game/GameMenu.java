package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;
public class GameMenu extends Openable implements Screen{
    SpriteBatch batch;
    Thread anime_smoke;
    Thread anime_hand;
    Texture camp;
    Texture play;
    Texture close;
    Texture music;
    Texture workspace;
    Texture frame;
    Texture smoke;
    Texture bird;
    Texture gear;
    Texture chip;
    Texture metall;
    Texture bulb;
    float rotation_hand = 0.0f;
    float scale = 1.05f;
    float rotation_head = 0.0f;
    float rotation = 0.0f;
    float rotation_leg = 0.0f;
    boolean close_touch = false;
    boolean play_touch = false;
    boolean BirdFly;
    boolean work_touch = false;
    boolean isJump = false;
    double robot_x;
    int robot_y = 250;
    int smoke_anime = 1;
    int birdx;
    int birdy;
    int bird_anime;
    public GameMenu(MainGame game) { this.game = game; }
    @Override
    public void show() {
        metall = new Texture("metall.png");
        chip = new Texture("chip.png");
        bulb = new Texture("bulb.png");
        gear = new Texture("gear.png");
        Gdx.input.setInputProcessor(new GameMenuTouch(game, this));
        frame = new Texture("frame.png");
        play =  new Texture("button.png");
        music =  new Texture("music_1.png");
        camp = new Texture("camp_2.png");
        Start();
        robot_x = width-400;
        open_x = 0;
        setRandomAnime();
        batch = new SpriteBatch();
        anime_smoke = new Thread(){
            @Override
            public void run(){
                while(true){
                    smoke_anime++;
                    if (smoke_anime>=5){
                        smoke_anime=1;
                    }
                    Sleep(this, 100);
                }
            }
        };
        anime_hand = new Thread(){
            @Override
            public void run(){
                int dir = 0;
                int time = game.random.nextInt(10)+6;
                while(true){
                    if(dir==1){
                        robot_x+=0.1;
                        scale-=0.0008f;
                        rotation_head+=0.2f;
                        rotation_hand-=0.1f;
                        if(rotation_head>=4.0f){
                            dir=2;
                            time = game.random.nextInt(10)+6;
                        }
                    }else{
                        robot_x-=0.1;
                        scale+=0.0008f;
                        rotation_head-=0.2f;
                        rotation_hand+=0.1f;
                        if(rotation_head<=-4.0f){
                            dir=1;
                            time = game.random.nextInt(10)+6;
                        }
                    }
                    Sleep(this, time);
                }
            }
        };
        anime_hand.start();
        anime_smoke.start();
        DoorOpen();
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        batch.begin();
        batch.draw(camp, 0, 0, width, height);
        DrawRobot(batch, (int)robot_x, robot_y, scale, rotation_hand+90, rotation_head, rotation_leg, 0 );
        bird = new Texture("bird_1.png");
        if (BirdFly) {
            if (bird_anime - 2 > 0) {
                bird.dispose();
                    try {
                        bird = new Texture("bird_" + (bird_anime - 2) + ".png");
                    }catch (Exception ignored){}
            }
            TextureRegion bird_region = new TextureRegion(bird, 400, 400);
            batch.draw(bird_region, birdx, birdy,0, 0, 250, 250, 1, 1, (birdy-height/2)/5);
        }
        if(close_touch){
            close= new Texture("button_white.png");
        }else{
            close= new Texture("exit.png");
        }
        if(work_touch){
            workspace= new Texture("button_white.png");
        }else{
            workspace= new Texture("work.png");
        }
        if(play_touch){
            play= new Texture("button_white.png");
        }else{
            play= new Texture("button.png");
        }
        smoke = new Texture("smoke" + smoke_anime + ".png");
        batch.draw(close, 50, 0, 500, 250);
        batch.draw(play, width-550, 0, 500, 250);
        batch.draw(workspace, 620, height-200, 400, 200);
        batch.draw(music, 1020, height-100, 100, 100);
        batch.draw(frame, 10, height-120, 120, 120);
        batch.draw(frame, 130, height-120, 120, 120);
        batch.draw(frame, 250, height-120, 120, 120);
        batch.draw(frame, 370, height-120, 120, 120);
        batch.draw(frame, 490, height-120, 120, 120);
        batch.draw(metall, 10, height-120, 120, 120);
        batch.draw(gear, 130, height-120, 120, 120);
        batch.draw(chip, 250, height-120, 120, 120);
        batch.draw(bulb, 370, height-120, 120, 120);
        batch.draw(frame, 490, height-120, 120, 120);
        item_font.draw(batch, Integer.toString(game.robot.metal), 20, height-80);
        item_font.draw(batch, Integer.toString(game.robot.gears), 140, height-80);
        item_font.draw(batch, Integer.toString(game.robot.microchips), 260, height-80);
        item_font.draw(batch, Integer.toString(game.robot.lamps), 380, height-80);
        item_font.draw(batch, Integer.toString(game.robot.gears), 500, height-80);
        batch.draw(smoke, width/2-125, 400, 175, 175);
        CheckClose(batch);
        CheckOpen(batch);
        batch.end();
        workspace.dispose();
        bird.dispose();
        close.dispose();
        play.dispose();
        smoke.dispose();
        if(closed){
            if(type_close == 1) {
                game.setWorkMenu();
            }
            if(type_close == 2) {
                game.setGamePlay();
            }
        }
    }
    public void setRandomAnime(){
        Thread rand = new Thread(){
            @Override
            public void run(){
                while(true){
                    int a = game.random.nextInt( 20);
                    if (a == 1){
                        if(!BirdFly){
                            Bird();
                        }
                    }
                    if(a == 2){
                        BotJump();
                    }
                    if(a == 3){
                        HandSwap();
                    }
                    if(a == 4){
                        HandStab();
                    }
                    Sleep(this, 1000);
                }
            }
        };
        rand.start();
    }
    public void HandStab(){
        Thread stab = new Thread(){
            @Override
            public void run(){
                while(rotation_hand<=-1.5f||rotation_hand>=1.5f){
                    if(rotation_hand>0){
                        rotation_hand-=0.5f;
                    }
                    if(rotation_hand<0){
                        rotation_hand+=0.5f;
                    }
                    Sleep(this, 5);
                }
            }
        };
        stab.start();
    }
    public void HandSwap(){
        Thread swap = new Thread(){
            @Override
            public void run(){
                int hand = 0;
                while(hand < 270){
                    hand+=1;
                    rotation_hand-=1.0f;
                    Sleep(this, 5);
                }
            }
        };
        swap.start();
    }
    public void BotJump() {
        if (!isJump) {
            Thread top = new Thread() {
                @Override
                public void run() {
                    isJump=true;
                    int rotdirect = 1;
                    while (rotdirect != 3) {
                        if (rotdirect == 1) {
                            rotation_leg += 1.0;
                            robot_y += 3;
                            if (rotation_leg >= 30.0f) {
                                rotdirect = 2;
                            }
                        } else {
                            robot_y -= 3;
                            rotation_leg -= 1.0f;
                            if (rotation_leg <= 0.0f) {
                                rotdirect = 3;
                            }
                        }
                        Sleep(this, 10);
                    }
                    isJump=false;
                    rotation_leg = 0.0f;
                    robot_y = 250;
                }
            };
            top.start();
        }
    }
    public void Bird(){
        Thread fly = new Thread(){
            @Override
            public  void run(){
                BirdFly = true;
                bird_anime = 1;
                birdx = -250;
                birdy = height/2 - game.random.nextInt(80);
                while(birdx < width+250){
                    birdx+=10;
                    birdy++;
                    bird_anime++;
                    if(bird_anime > 10){
                        bird_anime = 1;
                    }
                    Sleep(this, 30);
                }
                BirdFly = false;
                bird.dispose();
            }
        };
        fly.start();
    }
    @Override
    public void dispose () {
        smoke.dispose();
        camp.dispose();
        batch.dispose();
        door_left.dispose();
        door_right.dispose();
        play.dispose();
        workspace.dispose();
        music.dispose();

    }
}
