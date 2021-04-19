package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Openable implements Screen{
    MainGame game;
    BitmapFont item_font;
    Texture door_left;
    Texture door_right;
    Thread door;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("main_font.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    public static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
    boolean closed = false;
    boolean willClose = false;
    boolean isOpen = false;
    int type_close = 0;
    int width;
    int height;
    int open_x = 0;
    public void Start(){
        parameter.size = 35;
        parameter.characters = FONT_CHARACTERS;
        item_font = generator.generateFont(parameter);
        generator.dispose();
        item_font.setColor(Color.WHITE);
        door_left =  new Texture("door_1.png");
        door_right=  new Texture("door_2.png");
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        open_x = width/2;
    }
    public void DrawRobot(SpriteBatch drawer, int x, int y, double scale, float rothand, float rothead, float rotleg, float rot) {
        drawer.draw(game.robot.H, x, (float)(y+335*scale), 150, 25, (float)(200*scale), (float)(200*scale), 1, 1,(float) rothead);
        drawer.draw(game.robot.B, x, (float)(y+170*scale), 150, 25, (float)(200*scale), (float)(200*scale), 1, 1, (float)rot);
        drawer.draw(game.robot.LL, (float)(x-50*scale), y, (float)(100*scale), (float)(160*scale), (float)(200*scale), (float)(200*scale), 1, 1,(float)-rotleg);
        drawer.draw(game.robot.RL, (float)(x+50*scale), y, (float)(100*scale), (float)(160*scale), (float)(200*scale), (float)(200*scale), 1, 1,(float)rotleg);
        drawer.draw(game.robot.LH, (float)(x+90*scale), (float)(y+170*scale), (float)(100*scale), (float)(160*scale), (float)(200*scale), (float)(200*scale), 1,1, (float)rothand);
        drawer.draw(game.robot.RH, (float)(x-90*scale), (float)(y+170*scale), (float)(100*scale), (float)(160*scale), (float)(200*scale), (float)(200*scale), 1, 1, (float)rothand-90);
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
    public void DoorClose(int type_close){
        this.type_close = type_close;
        if(!willClose) {
            willClose = true;
            door = new Thread() {
                @Override
                public void run() {
                    while (open_x > 0) {
                        open_x -= 5;
                        Sleep(this, 5);
                    }
                    Sleep(this, 100);
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
    @Override
    public void render(float d) { }
    @Override
    public void show() { }
    @Override
    public void resize(int width, int height) { }
    @Override
    public void pause() { }
    @Override
    public void resume() { }
    @Override
    public void hide() { }
    @Override
    public void dispose(){
   }
}
