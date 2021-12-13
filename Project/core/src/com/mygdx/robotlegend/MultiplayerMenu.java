package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class MultiplayerMenu  extends Openable implements Screen{
    SpriteBatch batch;
    Texture background;
    Texture metall;
    Texture gear;
    Texture chip;
    Texture bulb;
    Texture white;
    Texture connect;
    Texture create;
    Texture right;
    Texture left;
    Texture close;
    Texture close_touched;
    Texture coming_soon;
    int which_select = 1;
    int resize = 0;
    boolean resize_item = false;
    boolean right_touch = false;
    boolean left_touch = false;
    boolean close_touch = false;
    boolean create_touch = false;
    boolean connected_touch = false;
    public MultiplayerMenu(MainGame game){
        this.game = game;
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        drawer.draw(background, 0, 0, width, height);
        if(which_select == 1) {
            drawer.draw(gear, 400 + resize / 2, height / 2 - 200 + resize / 2, 400 - resize, 400 - resize);
        }
        if(which_select == 2) {
            drawer.draw(metall, 400 + resize / 2, height / 2 - 200 + resize / 2, 400 - resize, 400 - resize);
        }
        if(which_select == 3) {
            drawer.draw(bulb, 400 + resize / 2, height / 2 - 200 + resize / 2, 400 - resize, 400 - resize);
        }
        if(which_select == 4) {
            drawer.draw(chip, 400 + resize / 2, height / 2 - 200 + resize / 2, 400 - resize, 400 - resize);
        }
        drawer.draw(metall, 360, height-120, 120, 120);
        drawer.draw(gear, 490, height-120, 120, 120);
        drawer.draw(chip, 610, height-120, 120, 120);
        drawer.draw(bulb, 720, height-120, 120, 120);
        item_font.draw(batch, Integer.toString(game.robot.metal), (int)(375.0*wpw), (int)((height-130)*hph));
        item_font.draw(batch, Integer.toString(game.robot.gears), (int)(495.0*wpw), (int)((height-130)*hph));
        item_font.draw(batch, Integer.toString(game.robot.microchips), (int)(625.0*wpw), (int)((height-130)*hph));
        item_font.draw(batch, Integer.toString(game.robot.lamps), (int)(755.0*wpw), (int)((height-130)*hph));
        multiplayer_font.draw(batch, "5", (int)(550.0*wpw), (int)((150)*hph));
        if(!right_touch) {
            drawer.draw(right, 850, height/2-100, 200, 200);
        }else{
            drawer.draw(right, 860, height/2-110, 180, 180);
        }
        if(!left_touch) {
            drawer.draw(left, 150 , height/2-100, 200, 200);
        }else{
            drawer.draw(left, 160 , height/2-110, 180, 180);
        }
        if(!close_touch) {
            drawer.draw(close, 0, height - 200, 200, 200);
        }else{
            drawer.draw(close_touched, 0, height - 200, 200, 200);
        }
        if(!create_touch) {
            drawer.draw(create, width - 600, 100, 400, 200);
        }else{
            drawer.draw(white, width - 600, 100, 400, 200);
        }
        if(!connected_touch) {
            drawer.draw(connect, width-600, height-300, 400, 200);
        }else{
            drawer.draw(white, width-600, height-300, 400, 200);
        }
        CheckDoor(drawer);
        if(closed){
            if(type_close == 1) {
                game.setGameMenu();
            }
            if(type_close == 2) {
                game.setGamePlay(true, true);
            }
            if(type_close == 3) {
                game.setGamePlay(true, false);
            }
        }
        batch.end();
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        Start();
        Gdx.input.setInputProcessor(new MultiplayerMenuTouch(game, this));
        white = new Texture("Button/button_white.png");
        close = new Texture("Button/button_close.png");
        close_touched = new Texture("Button/button_close_touched.png");
        right = new Texture("Button/button_right.png");
        left = new Texture("Button/button_left.png");
        connect = new Texture("Button/button_connect.png");
        create = new Texture("Button/button_create.png");
        background = new Texture("Interface/back.png");
        coming_soon = new Texture("Decoration/comingsoon.png");
        metall = new Texture("Item/metall.png");
        gear = new Texture("Item/gear.png");
        chip = new Texture("Item/chip.png");
        bulb = new Texture("Item/bulb.png");
        DoorOpen();
        drawer = new SpriteBatchRubber(this, batch);
    }
    public void NextRight(){
        if(!resize_item){
            Thread anime = new Thread(){
                @Override
                public void run(){
                    resize_item=true;
                    while(resize<100){
                        resize+=2;
                        Sleep(3);
                    }
                    while(resize<300){
                        resize+=2;
                        Sleep(1);
                    }
                    which_select++;
                    if(which_select>=5){
                        which_select=1;
                    }
                    multiplayer_font.setColor(Color.RED);
                    if(which_select==1 && game.robot.gears>=5){
                        multiplayer_font.setColor(Color.GREEN);
                    }
                    if(which_select==2 && game.robot.metal>=5){
                        multiplayer_font.setColor(Color.GREEN);
                    }
                    if(which_select==3 && game.robot.lamps>=5){
                        multiplayer_font.setColor(Color.GREEN);
                    }
                    if(which_select==4 && game.robot.microchips>=5){
                        multiplayer_font.setColor(Color.GREEN);
                    }
                    while(resize>0){
                        resize-=2;
                        Sleep(2);
                    }
                    resize_item=false;
                }
            };
            anime.start();
        }
    }
    public void NextLeft(){
        if(!resize_item){
            Thread anime = new Thread(){
                @Override
                public void run(){
                    resize_item=true;
                    while(resize<100){
                        resize+=2;
                        Sleep(3);
                    }
                    while(resize<300){
                        resize+=2;
                        Sleep(1);
                    }
                    which_select--;
                    if(which_select<=0){
                        which_select=4;
                    }
                    multiplayer_font.setColor(Color.RED);
                    if(which_select==1 && game.robot.gears>=5){
                        multiplayer_font.setColor(Color.GREEN);
                    }
                    if(which_select==2 && game.robot.metal>=5){
                        multiplayer_font.setColor(Color.GREEN);
                    }
                    if(which_select==3 && game.robot.lamps>=5){
                        multiplayer_font.setColor(Color.GREEN);
                    }
                    if(which_select==4 && game.robot.microchips>=5){
                        multiplayer_font.setColor(Color.GREEN);
                    }
                    while(resize>0){
                        resize-=2;
                        Sleep(2);
                    }
                    resize_item=false;
                }
            };
            anime.start();
        }
    }
    @Override
    public void dispose () {
        background.dispose();
        white.dispose();
        metall.dispose();
        gear.dispose();
        chip.dispose();
        bulb.dispose();
        connect.dispose();
        create.dispose();
        right.dispose();
        left.dispose();
        close.dispose();
        coming_soon.dispose();
        close_touched.dispose();
    }
}
