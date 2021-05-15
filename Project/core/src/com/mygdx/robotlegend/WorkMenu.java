package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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
    Texture lightt_1;
    Texture lightt_2;
    Texture metall;
    Texture gear;
    Texture chip;
    Texture bulb;
    Texture upgrade_1;
    Texture upgrade_2;
    Texture upgrade_touched;
    Texture red_touched;
    Texture not;
    Texture yes;
    TextureRegion lamp;
    TextureRegion[] light = new TextureRegion[2];
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
    boolean exit_touch = false;
    boolean upgrade_can = true;
    boolean upgrade_touch = false;
    public WorkMenu(MainGame mainGame){
        this.game = mainGame;
    }
    @Override
    public void show() {
        game.robot.SetWorkMenuTextures();
        Gdx.input.setInputProcessor(new WorkMenuTouch(game, this));
        Start();
        x = width/2-400;
        upgrade = Gdx.audio.newSound(Gdx.files.internal("Sound/upgrade.wav"));
        lightt_1 = new Texture("Interface/light1.png");
        lightt_2 = new Texture("Interface/light2.png");
        light[0] = new TextureRegion(lightt_1, 1280, 720);
        light[1] = new TextureRegion(lightt_2, 1280, 720);
        lampt = new Texture("Interface/lamp_full.png");
        lamp = new TextureRegion(lampt, 1280, 720);
        not = new Texture("Interface/cross.png");
        yes = new Texture("Interface/cross.png");
        frame = new Texture("Interface/frame.png");
        background = new Texture("Interface/back.png");
        upgrade_1 = new Texture("Button/button_upgrade_1.png");
        upgrade_2 = new Texture("Button/button_upgrade_2.png");
        upgrade_touched = new Texture("Button/button_upgrade_touched.png");
        red = new Texture("Button/button_red.png");
        red_touched = new Texture("Button/button_red_touched.png");
        metal = new Texture("Interface/metalic.png");
        metall = new Texture("Item/metall.png");
        gear = new Texture("Item/gear.png");
        chip = new Texture("Item/chip.png");
        bulb = new Texture("Item/bulb.png");
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
        drawer.draw(background, 0, 0, width, height);
        if(!exit_touch) {
            drawer.draw(red, 10, height - 150, 150, 150);
        }else{
            drawer.draw(red_touched, 10, height - 150, 150, 150);
        }
        drawer.draw(frame, 10, height-350, 150, 150);
        drawer.draw(frame, 10, height-500, 150, 150);
        drawer.draw(frame, 10, height-650, 150, 150);
        drawer.draw(frame, 10, height-800, 150, 150);
        drawer.draw(metall, 10, height-350, 150, 150);
        drawer.draw(gear, 10, height-500, 150, 150);
        drawer.draw(chip, 10, height-650, 150, 150);
        drawer.draw(bulb, 10, height-800, 150, 150);

        item_font.draw(batch, Integer.toString(game.robot.metal), 20, height-310);
        item_font.draw(batch, Integer.toString(game.robot.gears), 20, height-460);
        item_font.draw(batch, Integer.toString(game.robot.microchips), 20, height-610);
        item_font.draw(batch, Integer.toString(game.robot.lamps), 20, height-760);
        drawer.draw(metal, width-600, 0, 600, height);
        drawer.draw(not, width-500, 375, 150, 150);
        drawer.draw(yes, width-250, 375, 150, 150);
        drawer.draw(gear, width-500, 200, 150, 150);
        drawer.draw(metall, width-250, 200, 150, 150);
        if(!upgrade_can) {
            drawer.draw(upgrade_1, width-500, 0, 400, 175);
        }else{
            if(!upgrade_touch) {
                drawer.draw(upgrade_2, width-500, 0, 400, 175);
            }else{
                drawer.draw(upgrade_touched, width-500, 0, 400, 175);
            }
        }

        DrawRobot(drawer, (int)x, y, scale, rothand, rothead, rotleg, rot, false, false, false, 90);
        DrawSelect(drawer, (int)x, y, scale, rothand, rothead, rotleg, rot, which_select);
        if(light_anime<3) {
            drawer.draw(light[light_anime-1], -200.0f, -200, (float) (width / 2 - 100), height + 350.0f, (float) (width), (float) (height + 300), 1, 1, rotlamp);
        }
        drawer.draw(lamp, -200.0f, -250, (float)(width/2-100), height+350.0f, (float) (width), (float) (height+300), 1, 1, rotlamp);
        CheckOpen(drawer);
        CheckClose(drawer);
        batch.end();
        if(closed){
            game.setGameMenu();
        }
    }
    public void upgrade(){
        if(which_select == 1) {
            if (game.robot.Hid < 5) {
                game.robot.Hid++;
                game.robot.UpdateRobotTexture(which_select);
                upgrade.play(0.8f);
            }
        }
        if(which_select == 2) {
            if (game.robot.Bid < 5) {
                game.robot.Bid++;
                game.robot.UpdateRobotTexture(which_select);
                upgrade.play(0.8f);
            }
        }
        if(which_select == 6) {
            if (game.robot.RHid < 5) {
                game.robot.RHid++;
                game.robot.UpdateRobotTexture(which_select);
                upgrade.play(0.8f);
            }
        }
        if(which_select == 5) {
            if (game.robot.LHid < 5) {
                game.robot.LHid++;
                game.robot.UpdateRobotTexture(which_select);
                upgrade.play(0.8f);
            }
        }
        if(which_select == 4) {
            if (game.robot.RLid < 5) {
                game.robot.RLid++;
                game.robot.UpdateRobotTexture(which_select);
                upgrade.play(0.8f);
            }
        }
        if(which_select == 3) {
            if (game.robot.LLid < 5) {
                game.robot.LLid++;
                game.robot.UpdateRobotTexture(which_select);
                upgrade.play(0.8f);
            }
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
        red_touched.dispose();
        upgrade.dispose();
        game.robot.DisposeWorkMenuTextures();
        lightt_1.dispose();
        lightt_2.dispose();
        lampt.dispose();
        red.dispose();
        background.dispose();
        frame.dispose();
        door_left.dispose();
        door_right.dispose();
        upgrade_1.dispose();
        upgrade_2.dispose();
        upgrade_touched.dispose();
        not.dispose();
        yes.dispose();
    }
}