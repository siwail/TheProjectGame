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
    Thread anime;
    Thread Eanime;
    Texture floor;
    Texture background;
    int y = 1;
    int x = 1;
    int health;
    int Ey = 1;
    int Ex = 8;
    int Ehealth;
    double robot_x = 0;
    double robot_y = 0;
    double Erobot_x = 0;
    double Erobot_y = 0;
    float rothand = 0;
    float rotleg = 0;
    float rothead = 0;
    float rot = 0;
    float scale = 0.8f;
    float Erothand = 0;
    float Erotleg = 0;
    float Erothead = 0;
    float Erot = 0;
    float Escale = 0.8f;
    public GamePlay(MainGame game) { this.game = game; }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(new GamePlayTouch(game, this));
        Start();
        health = game.robot.health;
        Ehealth = game.robot.Ehealth;
        y = 3;//game.random.nextInt(3)+1;
        background = new Texture("background.png");
        floor = new Texture("grass_alpha.png");
        open_x = 0;
        batch = new SpriteBatch();
        anime = new Thread(){
            @Override
            public void run(){
                int dir = 2;
                int time = game.random.nextInt(10)+10;
                while(true){
                    if(dir==1){
                        robot_x+=0.1;
                        scale-=0.0008f;
                        rothead+=0.2f;
                        rothand-=0.1f;
                        if(rothead>=3.0f){
                            dir=2;
                            time = game.random.nextInt(10)+10;
                        }
                    }else{
                        robot_x-=0.1;
                        scale+=0.0008f;
                        rothead-=0.2f;
                        rothand+=0.1f;
                        if(rothead<=-3.0f){
                            dir=1;
                            time = game.random.nextInt(10)+10;
                        }
                    }
                    Sleep(this, time);
                }
            }
        };

        Eanime = new Thread(){
            @Override
            public void run(){
                int Edir = 2;
                int Etime = game.random.nextInt(10)+10;
                while(true){
                    if(Edir==1){
                        Erobot_x+=0.1;
                        Escale-=0.0008f;
                        Erothead+=0.2f;
                        Erothand-=0.1f;
                        if(Erothead>=3.0f){
                            Edir=2;
                            Etime = game.random.nextInt(10)+10;
                        }
                    }else{
                        Erobot_x-=0.1;
                        Escale+=0.0008f;
                        Erothead-=0.2f;
                        Erothand+=0.1f;
                        if(Erothead<=-3.0f){
                            Edir=1;
                            Etime = game.random.nextInt(10)+10;
                        }
                    }
                    Sleep(this, Etime);
                }
            }
        };
        anime.start();
        Eanime.start();
        DoorOpen();
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, width, height);
        batch.draw(floor, 0, height/5*2-80, width, height/5);
        batch.draw(floor, 0, height/5-70, width, height/5);
        batch.draw(floor, 0, -60, width, height/5);
        DrawEnemy(batch, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale*(1.0f-0.03f*Ey), Erothand+90, Erothead, Erotleg, Erot );
        DrawRobot(batch, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale*(1.0f-0.03f*y), rothand+90, rothead, rotleg, rot );
        DrawEnemyIcon(batch, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale, Ehealth);
        DrawRobotIcon(batch, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale, health);
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