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
    Texture close;
    Texture close_touched;
    Texture max;
    Texture leg_lu;
    Texture leg_ru;
    Texture leg_cu;
    Texture leg_ld;
    Texture leg_rd;
    Texture leg_cd;
    Texture saw_texture;
    Texture[] fire = new Texture[4];
    TextureRegion lamp;
    TextureRegion[] light = new TextureRegion[2];
    TextureRegion saw;
    float x = 0.0f;
    int y = 0;
    int type_1 = 0;
    int type_2 = 0;
    int number_1 = 0;
    int number_2 = 0;
    float scale_frame = 1.0f;
    float scale = 1.35f;
    float rotlamp = 0.0f;
    float rothand = 0;
    float rothead = 0;
    float rotleg = 0;
    float rot = 0;
    float saw_rotate = 0;
    float saw_scale = 0.0f;
    int y_ld = 0;
    int y_rd = 0;
    int y_cd = 0;
    int y_lu = 0;
    int y_ru = 0;
    int y_cu = 0;



    int which_select = 0;
    int which_select_will = 0;
    int light_anime = 1;

    boolean fire_now = false;
    boolean ld = false;
    boolean rd = false;
    boolean cd = false;
    boolean lu = false;
    boolean ru = false;
    boolean cu = false;

    boolean max_level = false;
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
        game.MusicSwap(4);
        game.robot.SetWorkMenuTextures();
        Gdx.input.setInputProcessor(new WorkMenuTouch(game, this));
        Start();
        x = width/2-400;
        game.robot.UpdateParameters();
        upgrade = Gdx.audio.newSound(Gdx.files.internal("Sound/upgrade.wav"));
        lightt_1 = new Texture("Interface/light1.png");
        lightt_2 = new Texture("Interface/light2.png");
        light[0] = new TextureRegion(lightt_1, 960, 540);
        light[1] = new TextureRegion(lightt_2, 960, 540);
        lampt = new Texture("Interface/lamp_full.png");
        lamp = new TextureRegion(lampt, 960, 540);
        Frontground = new Texture("Interface/frontground.png");
        not = new Texture("Interface/cross.png");
        yes = new Texture("Interface/yes.png");
        max = new Texture("Object/max.png");
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
        close = new Texture("Button/button_close.png");
        close_touched = new Texture("Button/button_close_touched.png");
        red = new Texture("Button/button_red.png");
        red_touched = new Texture("Button/button_red_touched.png");
        metal = new Texture("Interface/metalic.png");
        metall = new Texture("Item/metall.png");
        gear = new Texture("Item/gear.png");
        chip = new Texture("Item/chip.png");
        bulb = new Texture("Item/bulb.png");
        fire[0] = new Texture("Object/fire_1.png");
        fire[1] = new Texture("Object/fire_2.png");
        fire[2] = new Texture("Object/fire_3.png");
        fire[3] = new Texture("Object/fire_4.png");

        leg_lu = new Texture("Object/leg_lu.png");
        leg_ru = new Texture("Object/leg_ru.png");
        leg_cu = new Texture("Object/leg_cu.png");
        leg_ld = new Texture("Object/leg_ld.png");
        leg_rd = new Texture("Object/leg_rd.png");
        leg_cd = new Texture("Object/leg_cd.png");

        saw_texture = new Texture("Object/saw.png");
        saw = new TextureRegion(saw_texture, 300, 300);

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
            drawer.draw(close, 10, height - 150, 150, 150);
            drawer.draw(red, width-700, height - 100, 100, 100);
        } else {
            drawer.draw(close_touched, 10, height - 150, 150, 150);
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
        item_font.draw(batch, Integer.toString(game.robot.metal), (int)(170.0*wpw), (int)(((float)height - 310.0)*hph));
        item_font.draw(batch, Integer.toString(game.robot.gears), (int)(170.0*wpw), (int)(((float)height - 450.0)*hph));
        item_font.draw(batch, Integer.toString(game.robot.microchips), (int)(170.0*wpw), (int)(((float)height - 600.0)*hph));
        item_font.draw(batch, Integer.toString(game.robot.lamps), (int)(170.0*wpw),(int)(((float)height - 750.0)*hph));
        drawer.draw(metal, RS(width - 600), RS(0), RS(600), RS(height));
        if(!max_level) {
            if (upgrade_can && which_select != 0) {
                drawer.draw(green_back, RS(width - 595), RS(0), RS(600), RS(350));
            }
            if (!upgrade_can && which_select != 0) {
                drawer.draw(red_back, RS(width - 595), RS(0), RS(600), RS(350));
            }
            if (which_select != 0) {
                if (type_1 == 4) {
                    drawer.draw(gear, RS(width - 500), RS(200), RS(150), RS(150));
                }
                if (type_1 == 3) {
                    drawer.draw(chip, RS(width - 500), RS(200), RS(150), RS(150));
                }
                if (type_1 == 2) {
                    drawer.draw(bulb, RS(width - 500), RS(200), RS(150), RS(150));
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
            if (type_1 != 0 && type_2 != 0 && which_select != 0) {
                if (can_type_1) {
                    drawer.draw(yes, RS(width - 425), RS(220), RS(100), RS(100));
                } else {
                    drawer.draw(not, RS(width - 425), RS(220), RS(100), RS(100));
                }
                if (can_type_2) {
                    drawer.draw(yes, RS(width - 175), RS(220), RS(100), RS(100));
                } else {
                    drawer.draw(not, RS(width - 175), RS(220), RS(100), RS(100));
                }
                item_font.draw(batch, number_1 + "", RS((int) (((float) width - 500.0) * wpw)), RS((int) (225.0 * hph)));
                item_font.draw(batch, number_2 + "", RS((int) (((float) width - 250.0) * wpw)), RS((int) (225.0 * hph)));
            }
            if (which_select != 0) {
                if (!upgrade_can || which_select == 0) {
                    drawer.draw(upgrade_1, RS(width - 500), RS(0), RS(400), RS(175));
                } else {
                    if (!upgrade_touch) {
                        drawer.draw(upgrade_2, RS(width - 500), RS(0), RS(400), RS(175));
                    } else {
                        drawer.draw(upgrade_touched, RS(width - 500), RS(0), RS(400), RS(175));
                    }
                }
            }
        }else{
            if(which_select != 0) {
                drawer.draw(red_back, RS(width - 595), RS(0), RS(600), RS(350));
                drawer.draw(max, RS(width - 500), RS(200), RS(150), RS(150));
                drawer.draw(max, RS(width - 250), RS(200), RS(150), RS(150));
                drawer.draw(not, RS(width - 425), RS(220), RS(100), RS(100));
                drawer.draw(not, RS(width - 175), RS(220), RS(100), RS(100));
            }
        }
        drawer.draw(health, RS(width-500), RS(550), RS(150), RS(150));
        if(which_select!=0) {
            item_font.draw(batch, "Здоровье", RS((int) (((float) width - 350.0) * wpw)), RS((int) (650.0 * hph)));
        }
        if(which_select == 0){
            drawer.draw(blue_back, RS(width - 595), RS(370), RS(600), RS(160));
            item_font.draw(batch, "Параметры", RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, (game.robot.Hid*10)+(game.robot.Bid*15)+(game.robot.RHid*5)+(game.robot.LHid*5)+(game.robot.RLid*5)+(game.robot.LLid*5) +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            if(game.robot.Bhealth != 0){
                item_green_font.draw(batch,  " +" + game.robot.Bhealth, RS((int)(((float)width-440.0)*wpw)), RS((int)(570.0*hph)));
            }
            drawer.draw(energy, RS(width-250), RS(550), RS(150), RS(150));
            item_font.draw(batch, (game.robot.Hid*10)+"", RS((int)(((float)width-250.0)*wpw)), RS((int)(570.0*hph)));
            if(game.robot.Benergy_speed != 0){
                item_green_font.draw(batch,  " +" + game.robot.Benergy_speed, RS((int)(((float)width-190.0)*wpw)), RS((int)(570.0*hph)));
            }
            drawer.draw(move_speed, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, (game.robot.LLid+game.robot.RLid) +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));
            if(game.robot.Bmove_speed != 0){
                item_green_font.draw(batch,  " +" + game.robot.Bmove_speed, RS((int)(((float)width-440.0)*wpw)), RS((int)(400.0*hph)));
            }

            drawer.draw(attack_speed, RS(width-250), RS(380), RS(150), RS(150));
            item_font.draw(batch, (game.robot.Bid)+"", RS((int)(((float)width-250.0)*wpw)), RS((int)(400.0*hph)));
            if(game.robot.Battack_speed != 0){
                item_green_font.draw(batch,  " +" + game.robot.Battack_speed, RS((int)(((float)width-190.0)*wpw)), RS((int)(400.0*hph)));
            }
            drawer.draw(damage, RS(width-375), RS(210), RS(150), RS(150));
            item_font.draw(batch, (game.robot.LHid+game.robot.RHid)*2+"", RS((int)(((float)width-375.0)*wpw)), RS((int)(230.0*hph)));
            if(game.robot.Bdamage != 0){
                item_green_font.draw(batch,  " +" + game.robot.Bdamage, RS((int)(((float)width-315.0)*wpw)), RS((int)(230.0*hph)));
            }
        }
        if(which_select == 1){
            item_font.draw(batch, "Мозг робота Ур. " + game.robot.Hid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.Hid*10 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(energy, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Энергия", RS((int)(((float)width-350.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.Hid*10)+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        if(which_select == 2){
            item_font.draw(batch, "Корпус Ур. " + game.robot.Bid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.Bid*15 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(attack_speed, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Динамика", RS((int)(((float)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.Bid)+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        if(which_select == 3){
            item_font.draw(batch, "Механо-нога Ур. " + game.robot.LLid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.LLid*5 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(move_speed, RS(width-500),RS( 380),RS( 150), RS(150));
            item_font.draw(batch, "Скорость", RS((int)(((float)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.LLid)+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        if(which_select == 4){
            item_font.draw(batch, "Механо-нога Ур. " + game.robot.RLid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.RLid*5 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(move_speed, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Скорость", RS((int)(((float)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.RLid)+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        if(which_select == 5){
            item_font.draw(batch, "Бластер Ур. " + game.robot.LHid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.LHid*5 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(damage, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Урон", RS((int)(((float)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.LHid)*2+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        if(which_select == 6){
            item_font.draw(batch, "Бластер Ур. " + game.robot.RHid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.RHid*5 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(damage, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Урон", RS((int)(((float)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.RHid)*2+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));
        }
        DrawRobot(drawer, (int)x, y, scale, rothand, rothead, rotleg, rot, false, false, false, 90);
        DrawSelect(drawer, (int)x, y, scale, rothand, rothead, rotleg, rot, which_select_will);
        if(cu){
            drawer.draw(leg_cu, (int)x-(int)(50*scale), height-y_cu, 400, 400);
            if(y_cu>=300){
                drawer.draw(saw, (int)x-(int)(50*scale)+50, height-50-y_cu+50, 150*saw_scale, 150*saw_scale, (float) (300*saw_scale), (float) (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(cd){
            drawer.draw(leg_cd, (int)x-(int)(50*scale), y_cd-400, 400, 400);
            if(y_cd>=400){
                drawer.draw(saw, (int)x-(int)(50*scale)+50, y_cd-350+50, 150*saw_scale, 150*saw_scale, (float) (300*saw_scale), (float) (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(ld){
            drawer.draw(leg_ld, (int)x-(int)(100*scale), y_ld-300, 400, 400);
            if(y_ld>=300){
                drawer.draw(saw, (int)x-(int)(100*scale)+50, y_ld-250+50, 150*saw_scale, 150*saw_scale, (float) (300*saw_scale), (float) (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(rd){
            drawer.draw(leg_rd, (int)x+(int)(10*scale), y_rd-300, 400, 400);
            if(y_rd>=300){
                drawer.draw(saw, (int)x+(int)(10*scale)+50, y_rd-250+50, 150*saw_scale, 150*saw_scale, (float) (300*saw_scale), (float) (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(lu){
            drawer.draw(leg_lu, (int)x-(int)(170*scale), height-y_lu, 500, 500);
            if(y_lu>=500){
                drawer.draw(saw, (int)x-(int)(170*scale)+100, height-y_lu-80+100, 150*saw_scale, 150*saw_scale, (float) (300*saw_scale), (float) (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(ru){
            drawer.draw(leg_ru, (int)x+(int)(30*scale)-10, height-y_ru, 500, 500);
            if(y_ru>=500){
                drawer.draw(saw, (int)x+(int)(20*scale)-10+100, height-y_ru-80+100, 150*saw_scale, 150*saw_scale, (float) (300*saw_scale), (float) (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
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
                        max_level = game.robot.Hid >= 5;
                        type_1 = 3;
                        type_2 = 2;
                        number_1 = 8 * game.robot.Hid;
                        number_2 = 5 * game.robot.Hid;
                        can_type_1 = game.robot.microchips >= number_1;
                        can_type_2 = game.robot.lamps >= number_2;
                        upgrade_can = game.robot.microchips >= number_1 && game.robot.lamps >= number_2;
                    }
                    if (which_select == 2) {
                        max_level = game.robot.Bid >= 5;
                        type_1 = 3;
                        type_2 = 1;
                        number_1 = 6 * game.robot.Bid;
                        number_2 = 9 * game.robot.Bid;
                        can_type_1 = game.robot.microchips >= number_1;
                        can_type_2 = game.robot.metal >= number_2;
                        upgrade_can = game.robot.microchips >= number_1 && game.robot.metal >= number_2;
                    }
                    if (which_select == 3) {
                        max_level = game.robot.LLid >= 5;
                        type_1 = 4;
                        type_2 = 1;
                        number_1 = 6 * game.robot.LLid;
                        number_2 = 7 * game.robot.LLid;
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.metal >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.metal >= number_2;
                    }
                    if (which_select == 4) {
                        max_level = game.robot.RLid >= 5;
                        type_1 = 4;
                        type_2 = 1;
                        number_1 = 6 * game.robot.RLid;
                        number_2 = 7 * game.robot.RLid;
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.metal >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.metal >= number_2;
                    }
                    if (which_select == 5) {
                        max_level = game.robot.LHid >= 5;
                        type_1 = 4;
                        type_2 = 2;
                        number_1 = 6 * game.robot.LHid;
                        number_2 = 8 * game.robot.LHid;
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.lamps >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.lamps >= number_2;
                    }
                    if (which_select == 6) {
                        max_level = game. robot.RHid >= 5;
                        type_1 = 4;
                        type_2 = 2;
                        number_1 = 6 * game.robot.RHid;
                        number_2 = 8 * game.robot.RHid;
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
        return (int)((float)value*scale_frame)-(int)((1.0-scale_frame)*400);
    }
    public void AddLeg(int leg){
        if(leg == 1) {
            cu = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (y_cu<300) {
                        y_cu+=5;
                        Sleep(5);
                    }
                    Fire();
                    while (y_cu>0) {
                        y_cu-=2;
                        Sleep(5);
                    }
                }
            };
            anime.start();
        }
        if(leg == 2) {
            cd= true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (y_cd<400) {
                        y_cd+=5;
                        Sleep(5);
                    }
                    Fire();
                    while (y_cd>0) {
                        y_cd-=2;
                        Sleep(5);
                    }
                }
            };
            anime.start();
        }
        if(leg == 3) {
            ld= true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (y_ld<300) {
                        y_ld+=5;
                        Sleep(5);
                    }
                    Fire();
                    while (y_ld>0) {
                        y_ld-=2;
                        Sleep(5);
                    }
                }
            };
            anime.start();
        }
        if(leg == 4) {
            rd= true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (y_rd<300) {
                        y_rd+=5;
                        Sleep(5);
                    }
                    Fire();
                    while (y_rd>0) {
                        y_rd-=2;
                        Sleep(5);
                    }
                }
            };
            anime.start();
        }
        if(leg == 5) {
            ru= true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (y_ru<500) {
                        y_ru+=5;
                        Sleep(5);
                    }
                    Fire();
                    while (y_ru>0) {
                        y_ru-=2;
                        Sleep(5);
                    }
                }
            };
            anime.start();
        }
        if(leg == 6) {
            lu= true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (y_lu<500) {
                        y_lu+=5;
                        Sleep(5);
                    }
                    Fire();
                    while (y_lu>0) {
                        y_lu-=2;
                        Sleep(5);
                    }
                }
            };
            anime.start();
        }
    }
    public void Fire(){
        boolean can_anime;
        can_anime= !fire_now;
                int anime = 0;
                while (anime < 300) {
                    if(can_anime) {

                        if(saw_rotate<360.0f){
                            saw_rotate+=1.2f;
                        }else{
                            saw_rotate=0.0f;
                        }
                        if(anime>250){
                            if(saw_scale>0.0f){
                                saw_scale-=0.02f;
                            }
                        }else{
                            if(saw_scale<1.0f){
                                saw_scale+=0.02f;
                            }
                        }
                    }

                    anime++;
                    Sleep(5);
                }


    }
    public void upgrade() {
        if (upgrade_can && !max_level) {
            if (which_select == 1) {
                if (game.robot.Hid < 5) {
                    game.robot.Hid++;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(1);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 2) {
                if (game.robot.Bid < 5) {
                    game.robot.Bid++;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(2);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 6) {
                if (game.robot.RHid < 5) {
                    game.robot.RHid++;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(6);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 5) {
                if (game.robot.LHid < 5) {
                    game.robot.LHid++;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(5);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 4) {
                if (game.robot.RLid < 5) {
                    game.robot.RLid++;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(4);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 3) {
                if (game.robot.LLid < 5) {
                    game.robot.LLid++;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(3);
                    upgrade.play(0.8f);
                }
            }
            Gdx.input.vibrate(200);
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
        close.dispose();
        close_touched.dispose();
        max.dispose();
        fire[0].dispose();
        fire[1].dispose();
        fire[2].dispose();
        fire[3].dispose();

        leg_lu.dispose();
        leg_ru.dispose();
        leg_cu.dispose();
        leg_ld.dispose();
        leg_rd.dispose();
        leg_cd.dispose();
    }
    }