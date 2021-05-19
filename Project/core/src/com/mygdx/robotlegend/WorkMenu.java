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
    Texture damage;
    Texture move_speed;
    Texture attack_speed;
    Texture health;
    Texture energy;
    Texture Frontground;
    Texture blue_back;
    Texture red_back;
    Texture green_back;
    TextureRegion lamp;
    TextureRegion[] light = new TextureRegion[2];
    double x = 0.0;
    int y = 0;
    int type_1 = 0;
    int type_2 = 0;
    int number_1 = 0;
    int number_2 = 0;
    double scale_frame = 1.0;
    double scale = 1.35;
    float rotlamp = 0.0f;
    float rothand = 0;
    float rothead = 0;
    float rotleg = 0;
    float rot = 0;
    int which_select = 0;
    int which_select_will = 0;
    int light_anime = 1;
    boolean can_swap = true;
    boolean can_type_1 = false;
    boolean can_type_2 = false;
    boolean exit_touch = false;
    boolean upgrade_can = false;
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
        Frontground = new Texture("Interface/frontground.png");
        not = new Texture("Interface/cross.png");
        yes = new Texture("Interface/yes.png");
        frame = new Texture("Interface/frame.png");
        damage = new Texture("Interface/damage_icon.png");
        move_speed = new Texture("Interface/speed_move_icon.png");
        attack_speed = new Texture("Interface/speed_attack_icon.png");
        health = new Texture("Interface/health_icon.png");
        energy = new Texture("Interface/energy_icon.png");
        blue_back = new Texture("Interface/blue.png");
        green_back = new Texture("Interface/green.png");
        red_back = new Texture("Interface/red.png");
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
                    light_anime = 1-light_anime;
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
                while(!closed){
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
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        drawer.draw(background, 0, 0, width, height);
        if (!exit_touch) {
            drawer.draw(red, 10, height - 150, 150, 150);
            drawer.draw(red, width-700, height - 100, 100, 100);
        } else {
            drawer.draw(red_touched, 10, height - 150, 150, 150);
            drawer.draw(red_touched, width-700, height - 100, 100, 100);
        }
        drawer.draw(frame, 10, height - 350, 150, 150);
        drawer.draw(frame, 10, height - 500, 150, 150);
        drawer.draw(frame, 10, height - 650, 150, 150);
        drawer.draw(frame, 10, height - 800, 150, 150);
        drawer.draw(metall, 10, height - 350, 150, 150);
        drawer.draw(gear, 10, height - 500, 150, 150);
        drawer.draw(chip, 10, height - 650, 150, 150);
        drawer.draw(bulb, 10, height - 800, 150, 150);
        item_font.draw(batch, Integer.toString(game.robot.metal), (int)(170.0*wpw), (int)(((double)height - 310.0)*hph));
        item_font.draw(batch, Integer.toString(game.robot.gears), (int)(170.0*wpw), (int)(((double)height - 450.0)*hph));
        item_font.draw(batch, Integer.toString(game.robot.microchips), (int)(170.0*wpw), (int)(((double)height - 600.0)*hph));
        item_font.draw(batch, Integer.toString(game.robot.lamps), (int)(170.0*wpw),(int)(((double)height - 750.0)*hph));
        drawer.draw(metal, RS(width - 600), RS(0), RS(600), RS(height));
        if(upgrade_can && which_select != 0){
            drawer.draw(green_back, RS(width - 595), RS(0), RS(600), RS(350));
        }
        if(!upgrade_can && which_select != 0){
            drawer.draw(red_back, RS(width - 595), RS(0), RS(600), RS(350));
        }
        if(which_select!=0) {
            if (type_1 == 4) {
                drawer.draw(gear, RS(width - 500), RS(200), RS(150), RS(150));
            }
            if (type_1 == 3) {
                drawer.draw(chip, RS(width - 500), RS(200), RS(150), RS(150));
            }
            if (type_1 == 2) {
                drawer.draw(bulb, RS(width -500), RS(200), RS(150), RS(150));
            }
            if (type_1 == 1) {
                drawer.draw(metall, RS(width - 500), RS(200), RS(150), RS(150));
            }
            if (type_2 == 4) {
                drawer.draw(gear, RS(width - 250), RS(200), RS(150), RS(150));
            }
            if (type_2 == 3) {
                drawer.draw(chip, RS(width - 250), RS(200), RS(150), RS(150));
            }
            if (type_2 == 2) {
                drawer.draw(bulb, RS(width - 250), RS(200), RS(150), RS(150));
            }
            if (type_2 == 1) {
                drawer.draw(metall, RS(width - 250), RS(200), RS(150), RS(150));
            }
        }
        if (type_1 != 0 && type_2 != 0 && which_select!=0){
            if(can_type_1) {
                drawer.draw(yes, RS(width - 425), RS(220), RS(100), RS(100));
            }else{
                drawer.draw(not, RS(width - 425), RS(220), RS(100), RS(100));
            }
            if(can_type_2) {
                drawer.draw(yes, RS(width - 175), RS(220), RS(100), RS(100));
            }else{
                drawer.draw(not, RS(width - 175), RS(220), RS(100), RS(100));
            }
            item_font.draw(batch, number_1 +"", RS((int)(((double)width-500.0)*wpw)), RS((int)(225.0*hph)));
            item_font.draw(batch, number_2 +"", RS((int)(((double)width-250.0)*wpw)), RS((int)(225.0*hph)));
        }
        if(!upgrade_can || which_select==0) {
            drawer.draw(upgrade_1, RS(width-500), RS(0), RS(400), RS(175));
        }else{
            if(!upgrade_touch) {
                drawer.draw(upgrade_2, RS(width-500), RS(0), RS(400), RS(175));
            }else{
                drawer.draw(upgrade_touched, RS(width-500), RS(0), RS(400), RS(175));
            }
        }
        drawer.draw(health, RS(width-500), RS(550), RS(150), RS(150));
        if(which_select!=0) {
            item_font.draw(batch, "Здоровье", RS((int) (((double) width - 350.0) * wpw)), RS((int) (650.0 * hph)));
        }
        if(which_select == 0){
            drawer.draw(blue_back, RS(width - 595), RS(370), RS(600), RS(160));
            item_font.draw(batch, "Параметры", RS((int)(((double)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, (game.robot.Hid*10)+(game.robot.Bid*15)+(game.robot.RHid*5)+(game.robot.LHid*5)+(game.robot.RLid*5)+(game.robot.LLid*5) +"", RS((int)(((double)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(energy, RS(width-250), RS(550), RS(150), RS(150));
            item_font.draw(batch, (game.robot.Hid*10)+"", RS((int)(((double)width-250.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(move_speed, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, (game.robot.LLid+game.robot.RLid) +"", RS((int)(((double)width-500.0)*wpw)), RS((int)(400.0*hph)));
            drawer.draw(attack_speed, RS(width-250), RS(380), RS(150), RS(150));
            item_font.draw(batch, (game.robot.Bid)+"", RS((int)(((double)width-250.0)*wpw)), RS((int)(400.0*hph)));
            drawer.draw(damage, RS(width-375), RS(210), RS(150), RS(150));
            item_font.draw(batch, (game.robot.LHid+game.robot.RHid)*2+"", RS((int)(((double)width-375.0)*wpw)), RS((int)(230.0*hph)));
        }
        if(which_select == 1){
            item_font.draw(batch, "Мозг робота Ур. " + game.robot.Hid, RS((int)(((double)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.Hid*10 +"", RS((int)(((double)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(energy, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Энергия", RS((int)(((double)width-350.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.Hid*10)+"", RS((int)(((double)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        if(which_select == 2){
            item_font.draw(batch, "Корпус Ур. " + game.robot.Bid, RS((int)(((double)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.Bid*15 +"", RS((int)(((double)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(attack_speed, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Динамика", RS((int)(((double)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.Bid)+"", RS((int)(((double)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        if(which_select == 3){
            item_font.draw(batch, "Механо-нога Ур. " + game.robot.LLid, RS((int)(((double)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.LLid*5 +"", RS((int)(((double)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(move_speed, RS(width-500),RS( 380),RS( 150), RS(150));
            item_font.draw(batch, "Скорость", RS((int)(((double)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.LLid)+"", RS((int)(((double)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        if(which_select == 4){
            item_font.draw(batch, "Механо-нога Ур. " + game.robot.RLid, RS((int)(((double)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.RLid*5 +"", RS((int)(((double)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(move_speed, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Скорость", RS((int)(((double)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.RLid)+"", RS((int)(((double)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        if(which_select == 5){
            item_font.draw(batch, "Бластер Ур. " + game.robot.LHid, RS((int)(((double)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.LHid*5 +"", RS((int)(((double)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(damage, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Урон", RS((int)(((double)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.LHid)*2+"", RS((int)(((double)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        if(which_select == 6){
            item_font.draw(batch, "Бластер Ур. " + game.robot.RHid, RS((int)(((double)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.RHid*5 +"", RS((int)(((double)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(damage, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Урон", RS((int)(((double)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.RHid)*2+"", RS((int)(((double)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        DrawRobot(drawer, (int)x, y, scale, rothand, rothead, rotleg, rot, false, false, false, 90);
        DrawSelect(drawer, (int)x, y, scale, rothand, rothead, rotleg, rot, which_select_will);
        if(light_anime<3) {
            drawer.draw(light[light_anime], -200.0f, -200, (float) (width / 2 - 100), height + 350.0f, (float) (width), (float) (height + 300), 1, 1, rotlamp);
        }
        drawer.draw(Frontground, 0, 0, width, height);
        drawer.draw(lamp, -200.0f, -250, (float)(width/2-100), height+350.0f, (float) (width), (float) (height+300), 1, 1, rotlamp);
        CheckOpen(drawer);
        CheckClose(drawer);
        batch.end();
        if(closed){
            game.setGameMenu();
        }
    }
    public void Swap(){
        if(can_swap) {
            can_swap = false;
            anime = new Thread() {
                @Override
                public void run() {
                    while (scale_frame > 0.1) {
                        scale_frame -= 0.01;
                        Sleep(3);
                    }
                    which_select = which_select_will;
                    if (which_select == 1) {
                        type_1 = 3;
                        type_2 = 2;
                        number_1 = 5 * game.robot.Hid;
                        number_2 = 2 * game.robot.Hid;
                        can_type_1 = game.robot.microchips >= number_1;
                        can_type_2 = game.robot.lamps >= number_2;
                        upgrade_can = game.robot.microchips >= number_1 && game.robot.lamps >= number_2;
                    }
                    if (which_select == 2) {
                        type_1 = 3;
                        type_2 = 1;
                        number_1 = 3 * game.robot.Bid;
                        number_2 = 5 * game.robot.Bid;
                        can_type_1 = game.robot.microchips >= number_1;
                        can_type_2 = game.robot.metal >= number_2;
                        upgrade_can = game.robot.microchips >= number_1 && game.robot.metal >= number_2;
                    }
                    if (which_select == 3) {
                        type_1 = 4;
                        type_2 = 1;
                        number_1 = 3 * game.robot.LLid;
                        number_2 = 4 * game.robot.LLid;
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.metal >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.metal >= number_2;
                    }
                    if (which_select == 4) {
                        type_1 = 4;
                        type_2 = 1;
                        number_1 = 3 * game.robot.RLid;
                        number_2 = 4 * game.robot.RLid;
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.metal >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.metal >= number_2;
                    }
                    if (which_select == 5) {
                        type_1 = 4;
                        type_2 = 2;
                        number_1 = 3 * game.robot.LHid;
                        number_2 = 4 * game.robot.LHid;
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.lamps >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.lamps >= number_2;
                    }
                    if (which_select == 6) {
                        type_1 = 4;
                        type_2 = 2;
                        number_1 = 3 * game.robot.RHid;
                        number_2 = 4 * game.robot.RHid;
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.lamps >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.lamps >= number_2;
                    }
                    while (scale_frame < 1.0) {
                        scale_frame += 0.01;
                        Sleep(3);
                    }
                    can_swap = true;
                }

            };
            anime.start();
        }
    }
    public void check_model(){
        anime  = new Thread() {
            @Override
            public void run() {
                if (can_swap) {
                  Swap();
                }
            }
        };
        anime.start();
    }
    public int RS(int value){ //right scale
        return (int)((double)value*scale_frame)-(int)((1.0-scale_frame)*400);
    }
    public void upgrade() {
        if (upgrade_can) {
            if (which_select == 1) {
                if (game.robot.Hid < 5) {
                    game.robot.Hid++;
                    game.robot.UpdateRobotTexture(which_select);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 2) {
                if (game.robot.Bid < 5) {
                    game.robot.Bid++;
                    game.robot.UpdateRobotTexture(which_select);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 6) {
                if (game.robot.RHid < 5) {
                    game.robot.RHid++;
                    game.robot.UpdateRobotTexture(which_select);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 5) {
                if (game.robot.LHid < 5) {
                    game.robot.LHid++;
                    game.robot.UpdateRobotTexture(which_select);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 4) {
                if (game.robot.RLid < 5) {
                    game.robot.RLid++;
                    game.robot.UpdateRobotTexture(which_select);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 3) {
                if (game.robot.LLid < 5) {
                    game.robot.LLid++;
                    game.robot.UpdateRobotTexture(which_select);
                    upgrade.play(0.8f);
                }
            }
            if(type_1 == 1){
                game.robot.metal -= number_1;
            }
            if(type_1 == 2){
                game.robot.lamps -= number_1;
            }
            if(type_1 == 3){
                game.robot.microchips -= number_1;
            }
            if(type_1 == 4){
                game.robot.gears -= number_1;
            }
            if(type_2 == 1){
                game.robot.metal -= number_2;
            }
            if(type_2 == 2){
                game.robot.lamps -= number_2;
            }
            if(type_2 == 3){
                game.robot.microchips -= number_2;
            }
            if(type_2 == 4){
                game.robot.gears -= number_2;
            }
            check_model();
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
        damage.dispose();
        attack_speed.dispose();
        move_speed.dispose();
        health.dispose();
        energy.dispose();
        Frontground.dispose();
        red_back.dispose();
        green_back.dispose();
        blue_back.dispose();
    }
}