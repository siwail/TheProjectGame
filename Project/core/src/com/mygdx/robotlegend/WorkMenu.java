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
    Thread button;
    Thread tube_events;
    Thread tube_events2;
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
    Texture state_bonus;
    Texture state_back;
    Texture state_frame;
    Texture state_health;
    Texture state_energy;
    Texture state_damage;
    Texture state_speed;
    Texture leg_lu;
    Texture leg_ru;
    Texture leg_cu;
    Texture leg_ld;
    Texture leg_rd;
    Texture leg_cd;
    Texture saw_texture;
    Texture workpage;
    Texture workpage_blue;
    Texture workpage_red;
    Texture left;
    Texture right;
    Texture level_circle;
    Texture green_circle;
    Texture red_circle;
    Texture tube;
    Texture power_1;
    Texture power_2;
    Texture[] tube_elements_texture = new Texture[5];
    TextureRegion[] tube_elements = new TextureRegion[5];
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

    int LHid, LBid, LRHid, LLHid, LRLid, LLLid;
    int LHl, LBl, LRHl, LLHl, LRLl, LLLl;

    int tube_element2_index;
    int tube_element2_speed;
    float tube_element2_rotate;
    float tube_element2_y;

    int tube_element_index;
    int tube_element_speed;
    float tube_element_rotate;
    float tube_element_y;
    float left_scale = 1.0f;
    float right_scale = 1.0f;

    int which_select = 0;
    int which_select_will = 0;
    int light_anime = 1;

    boolean created_level = false;
    boolean fire_now = false;
    boolean ld = false;
    boolean rd = false;
    boolean cd = false;
    boolean lu = false;
    boolean ru = false;
    boolean cu = false;
    boolean left_touch = false;
    boolean right_touch = false;
    boolean max_level = false;
    boolean can_swap = true;
    boolean can_type_1 = false;
    boolean can_type_2 = false;
    boolean exit_touch = false;
    boolean upgrade_can = false;
    boolean upgrade_touch = false;
    boolean need_to_upgrade_power_1 = false;
    boolean need_to_upgrade_power_2 = false;
    boolean need_to_update_detail = false;
    boolean actual_model = true;
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
            power_1 = new Texture("Interface/dark.png");
            power_2 = new Texture("Interface/dark.png");
            tube_elements_texture[0] = new Texture("Location/grass_1.png");
            tube_elements_texture[1] = new Texture("Location/meteor_1.png");
            tube_elements_texture[2] = new Texture("Item/gear.png");
            tube_elements_texture[3] = new Texture("Item/bulb.png");
            tube_elements_texture[4] = new Texture("Robot/head_dead.png");
            for(int i = 0; i<5; i++) tube_elements[i] = new TextureRegion(tube_elements_texture[i]);
            tube = new Texture("Object/tube.png");
            level_circle =  new Texture("Object/level_circle.png");
            green_circle =  new Texture("Object/green_circle.png");
            red_circle =  new Texture("Object/red_circle.png");
            upgrade = Gdx.audio.newSound(Gdx.files.internal("Sound/upgrade.wav"));
            left = new Texture("Button/button_left.png");
            right = new Texture("Button/button_right.png");
            workpage = new Texture("Object/workpage_1.png");
            workpage_red = new Texture("Object/workpage_3.png");
            workpage_blue = new Texture("Object/workpage_2.png");
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
            state_bonus = new Texture("Interface/state_bonus.png");
            state_back = new Texture("Interface/state_back.png");
            state_frame = new Texture("Interface/state_frame.png");
            state_health = new Texture("Interface/state_health.png");
            state_energy = new Texture("Interface/state_energy.png");
            state_damage = new Texture("Interface/state_damage.png");
            state_speed = new Texture("Interface/state_speed.png");
            leg_lu = new Texture("Object/leg_lu.png");
            leg_ru = new Texture("Object/leg_ru.png");
            leg_cu = new Texture("Object/leg_cu.png");
            leg_ld = new Texture("Object/leg_ld.png");
            leg_rd = new Texture("Object/leg_rd.png");
            leg_cd = new Texture("Object/leg_cd.png");
            saw_texture = new Texture("Object/saw_1.png");
            saw = new TextureRegion(saw_texture, 300, 300);
            button  = new Thread(){
            @Override
            public void run(){
                while(!closed){
                    if(left_touch && left_scale>=0.5f){
                        left_scale -=0.1f;

                    }
                    if(!left_touch && left_scale<1.0f){
                        left_scale +=0.1f;

                    }
                    if(right_touch && right_scale>=0.5f){
                        right_scale -=0.1f;

                    }
                    if(!right_touch && right_scale<1.0f){
                        right_scale +=0.1f;

                    }
                    Sleep( 15);
                }
            }
            };
        tube_events  = new Thread(){
            @Override
            public void run(){
                while(!closed){
                    tube_element_y = height;
                    tube_element_speed = (game.random.nextInt(3)+1);
                    tube_element_index = game.random.nextInt(5);
                    while(tube_element_y>-200) {
                        tube_element_y-=5*tube_element_speed;
                        tube_element_rotate+=1.0f;
                        if(tube_element_rotate > 360.0f){
                            tube_element_rotate = 0.0f;
                        }
                        Sleep(10);
                    }
                }
            }
        };
        tube_events2  = new Thread(){
            @Override
            public void run(){
                while(!closed){
                    tube_element2_y = height;
                    tube_element2_speed = (game.random.nextInt(3)+1);
                    tube_element2_index = game.random.nextInt(5);
                    while(tube_element2_y>-200) {
                        tube_element2_y-=5*tube_element2_speed;
                        tube_element2_rotate+=1.0f;
                        if(tube_element2_rotate > 360.0f){
                            tube_element2_rotate = 0.0f;
                        }
                        Sleep(10);
                    }
                }
            }
        };
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
            tube_events.start();
            tube_events2.start();
            anime_hand.start();
            anime.start();
            button.start();
            DoorOpen();
            LHid = game.robot.Hid;
            LBid = game.robot.Bid;
            LRHid = game.robot.RHid;
            LLHid = game.robot.LHid;
            LRLid = game.robot.RLid;
            LLLid = game.robot.LLid;

            LHl = game.robot.Hl;
            LBl = game.robot.Bl;
            LRHl = game.robot.RHl;
            LLHl = game.robot.LHl;
            LRLl = game.robot.RLl;
            LLLl = game.robot.LLl;
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        drawer.draw(background, 0, 0, width, height+20);
        drawer.draw(tube_elements[tube_element_index], width-775+(height-100)/2, tube_element_y, 100, 100, 100, 100, 1, 1, tube_element_rotate);
        drawer.draw(tube_elements[tube_element2_index], width-775+(height-100)/2, tube_element2_y, 100, 100, 100, 100, 1, 1, tube_element2_rotate);
        drawer.draw(tube, width-675, -50, height-100, height+100);

        if (!exit_touch) {
            drawer.draw(close, 10, height - 150, 150, 150);
            if(scale_frame>=0.7) {
                drawer.draw(red, RS(width - 700), RS(height - 100), RS(100), RS(100));
            }
        } else {
            drawer.draw(close_touched, 10, height - 150, 150, 150);
            if(scale_frame>=0.7) {
                drawer.draw(red_touched, RS(width - 700), RS(height - 100), RS(100), RS(100));
            }
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
                }if(number_1>0&&number_2>0) {
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
            }
                if (which_select != 0) {
                    if (!upgrade_can) {
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
                drawer.draw(upgrade_1, RS(width - 500), RS(0), RS(400), RS(175));
            }
        }
        if(which_select == 0){
            item_font.draw(batch, "Параметры", RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));

            drawer.draw(state_back, RS(width-550), RS(570), RS(525), RS(75));
            drawer.draw(state_bonus, RS(width-540), RS(570), RS((int)(525.0f*(game.robot.health)/552.5f)), RS(75));
            drawer.draw(state_health, RS(width-540), RS(570), RS((int)(525.0f*(game.robot.health-game.robot.Bhealth)/552.5f)), RS(75));
            drawer.draw(state_frame, RS(width-550), RS(570), RS(525), RS(75));
            item_font.draw(batch, game.robot.health +"", RS((int)(((float)width-410.0)*wpw)), RS((int)(625.0*hph)));
            drawer.draw(health, RS(width-560), RS(540), RS(130), RS(130));
            if(Math.abs(game.robot.Bhealth) != 0){
                item_green_font.draw(batch,  " +" + Math.abs(game.robot.Bhealth), RS((int)(((float)width-180.0)*wpw)), RS((int)(625.0*hph)));
            }


            drawer.draw(state_back, RS(width-550), RS(470), RS(525), RS(75));
            drawer.draw(state_bonus, RS(width-540), RS(470), RS((int)(525.0f*(90-game.robot.energy_speed)/70.0f)), RS(75));
            drawer.draw(state_energy, RS(width-540), RS(470), RS((int)(525.0f*((90-game.robot.energy_speed)+game.robot.Benergy_speed)/70.0f)), RS(75));
            drawer.draw(state_frame, RS(width-550), RS(470), RS(525), RS(75));
            item_font.draw(batch, (90-game.robot.energy_speed+game.robot.Benergy_speed) +"", RS((int)(((float)width-410.0)*wpw)), RS((int)(525.0*hph)));
            drawer.draw(energy, RS(width-560), RS(435), RS(150), RS(150));
            if(Math.abs(game.robot.Benergy_speed) != 0){
                item_green_font.draw(batch,  " +" + Math.abs(game.robot.Benergy_speed), RS((int)(((float)width-180.0)*wpw)), RS((int)(525.0*hph)));
            }



            drawer.draw(state_back, RS(width-550), RS(370), RS(525), RS(75));
            drawer.draw(state_bonus, RS(width-540), RS(370), RS((int)(525.0f*(11-game.robot.move_speed)/8.5f)), RS(75));
            drawer.draw(state_speed, RS(width-540), RS(370), RS((int)(525.0f*((11-game.robot.move_speed)+game.robot.Bmove_speed)/8.5f)), RS(75));
            drawer.draw(state_frame, RS(width-550), RS(370), RS(525), RS(75));
            item_font.draw(batch, (11-game.robot.move_speed+game.robot.Bmove_speed) +"", RS((int)(((float)width-410.0)*wpw)), RS((int)(425.0*hph)));
            drawer.draw(move_speed, RS(width-545), RS(350), RS(120), RS(120));
            if(Math.abs(game.robot.Bmove_speed) != 0){
                item_green_font.draw(batch,  " +" + Math.abs(game.robot.Bmove_speed), RS((int)(((float)width-180.0)*wpw)), RS((int)(425.0*hph)));
            }



            drawer.draw(state_back, RS(width-550), RS(270), RS(525), RS(75));
            drawer.draw(state_bonus, RS(width-540), RS(270), RS((int)(525.0f*(8-game.robot.attack_speed)/8.5f)), RS(75));
            drawer.draw(state_speed, RS(width-540), RS(270), RS((int)(525.0f*((8-game.robot.attack_speed)+game.robot.Battack_speed)/8.5f)), RS(75));
            drawer.draw(state_frame, RS(width-550), RS(270), RS(525), RS(75));
            item_font.draw(batch, (8-game.robot.attack_speed+game.robot.Battack_speed) +"", RS((int)(((float)width-410.0)*wpw)), RS((int)(325.0*hph)));
            drawer.draw(attack_speed, RS(width-545), RS(250), RS(120), RS(120));
            if(Math.abs(game.robot.Battack_speed) != 0){
                item_green_font.draw(batch,  " +" + Math.abs(game.robot.Battack_speed), RS((int)(((float)width-180.0)*wpw)), RS((int)(325.0*hph)));
            }


            drawer.draw(state_back, RS(width-550), RS(170), RS(525), RS(75));
            drawer.draw(state_bonus, RS(width-540), RS(170), RS((int)(525.0f*(game.robot.damage)/55.0f)), RS(75));
            drawer.draw(state_damage, RS(width-540), RS(170), RS((int)(525.0f*(game.robot.damage-game.robot.Bdamage)/55.0f)), RS(75));
            drawer.draw(state_frame, RS(width-550), RS(170), RS(525), RS(75));
            item_font.draw(batch, (game.robot.damage-game.robot.Bdamage) +"", RS((int)(((float)width-410.0)*wpw)), RS((int)(225.0*hph)));
            drawer.draw(damage, RS(width-565), RS(155), RS(110), RS(110));
            if(Math.abs(game.robot.Bdamage) != 0){
                item_green_font.draw(batch,  " +" + Math.abs(game.robot.Bdamage), RS((int)(((float)width-180.0)*wpw)), RS((int)(225.0*hph)));
            }
        }
        if(which_select == 1){
            item_font.draw(batch, "Мозг", RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            if(game.robot.BHead[game.robot.Hid-1] > 0) {
                drawer.draw(workpage, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BHead[game.robot.Hid-1] == -1) {
                drawer.draw(workpage_red, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BHead[game.robot.Hid-1] == 0) {
                drawer.draw(workpage_blue, RS(width - 580), RS(350), RS(560), RS(365));
            }
            drawer.draw(game.robot.H, RS(width-415), RS(435), RS(115), RS(115), RS(230), RS(230), left_scale*right_scale, left_scale*right_scale, 0);
            if(scale_frame>=0.7) {
                if(game.robot.BHead[game.robot.Hid-1] > 0) {
                    drawer.draw(green_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    level_big_font.draw(batch, "" + game.robot.Hl, RS((int)(((float)width-537.5f)*wpw)), RS((int)(685.0*hph)));
                }
                if(game.robot.BHead[game.robot.Hid-1] == 0) {
                    drawer.draw(level_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(yes, RS(width - 575), RS(605), RS(110), RS(110));
                }
                if(game.robot.BHead[game.robot.Hid-1] < 0) {
                    drawer.draw(red_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(not, RS(width - 575), RS(605), RS(110), RS(110));
                }
            }
            drawer.draw(power_1, RS(width - 135), RS(605), RS(110), RS(110));
            if(number_1>0&&number_2>0){
                drawer.draw(state_back, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(state_energy, RS(width - 535), RS(380), RS((int) (250.0f * game.robot.TR(1, game.robot.Hid, game.robot.Hl, 3) / 50.0f)), RS(40));
                drawer.draw(state_frame, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(energy, RS(width - 565), RS(355), RS(100), RS(100));
                drawer.draw(state_back, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(state_health, RS(width - 275), RS(380), RS((int) (250.0f * game.robot.TR(1, game.robot.Hid, game.robot.Hl, 1) / 80.0f)), RS(40));
                drawer.draw(state_frame, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(health, RS(width - 295), RS(355), RS(100), RS(100));

                alert_font.draw(batch, "" + (int) game.robot.TR(1, game.robot.Hid, game.robot.Hl, 1), RS((int) (((float) width - 195.0) * wpw)), RS((int) (412.5 * hph)));
                alert_font.draw(batch, "" + (int) game.robot.TR(1, game.robot.Hid, game.robot.Hl, 3), RS((int) (((float) width - 455.0) * wpw)), RS((int) (412.5 * hph)));
            }
            drawer.draw(left, RS(width - 550 - 120 / 2 * left_scale + 60), RS(470 - 100 / 2 * left_scale + 50), RS(100 * left_scale), RS(120 * left_scale));
            drawer.draw(right, RS(width - 150 - 120 / 2 * right_scale + 60), RS(470 - 100 / 2 * right_scale + 50), RS(100 * right_scale), RS(120 * right_scale));
            /*
            item_font.draw(batch, "Мозг робота Ур. " + game.robot.Hid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.Hid*10 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(state_back, RS(width-550), RS(380), RS(525), RS(75));
            drawer.draw(state_bonus, RS(width-540), RS(380), RS((int)(525.0f*(90-game.robot.energy_speed)/90.0f)), RS(75));
            drawer.draw(state_energy, RS(width-540), RS(380), RS((int)(525.0f*((90-game.robot.energy_speed)+game.robot.Benergy_speed)/90.0f)), RS(75));
            drawer.draw(state_frame, RS(width-550), RS(380), RS(525), RS(75));
            drawer.draw(energy, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Энергия", RS((int)(((float)width-350.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (90-game.robot.energy_speed)+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));*/

        }
        if(which_select == 2){
            item_font.draw(batch, "Корпус", RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            if(game.robot.BBody[game.robot.Bid-1] > 0) {
                drawer.draw(workpage, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BBody[game.robot.Bid-1] == -1) {
                drawer.draw(workpage_red, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BBody[game.robot.Bid-1] == 0) {
                drawer.draw(workpage_blue, RS(width - 580), RS(350), RS(560), RS(365));
            }
            drawer.draw(game.robot.B, RS(width-415), RS(435), RS(115), RS(115), RS(230), RS(230), left_scale*right_scale, left_scale*right_scale, 0);
            if(scale_frame>=0.7) {
                if(game.robot.BBody[game.robot.Bid-1] > 0) {
                    drawer.draw(green_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    level_big_font.draw(batch, "" + game.robot.Bl, RS((int)(((float)width-537.5f)*wpw)), RS((int)(685.0*hph)));
                }
                if(game.robot.BBody[game.robot.Bid-1] == 0) {
                    drawer.draw(level_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(yes, RS(width - 575), RS(605), RS(110), RS(110));
                }
                if(game.robot.BBody[game.robot.Bid-1] < 0) {
                    drawer.draw(red_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(not, RS(width - 575), RS(605), RS(110), RS(110));
                }
            }
            drawer.draw(power_2, RS(width - 135), RS(605), RS(110), RS(110));
            if(number_1>0&&number_2>0){
                drawer.draw(state_back, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(state_speed, RS(width - 535), RS(380), RS((int) (250.0f * game.robot.TR(2, game.robot.Bid, game.robot.Bl, 4) / 7.5f)), RS(40));
                drawer.draw(state_frame, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(attack_speed, RS(width - 565), RS(355), RS(100), RS(100));
                drawer.draw(state_back, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(state_health, RS(width - 275), RS(380), RS((int) (250.0f * game.robot.TR(2, game.robot.Bid, game.robot.Bl, 1) / 200.0f)), RS(40));
                drawer.draw(state_frame, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(health, RS(width - 295), RS(355), RS(100), RS(100));

                alert_font.draw(batch, "" + (int) game.robot.TR(2, game.robot.Bid, game.robot.Bl, 1), RS((int) (((float) width - 195.0) * wpw)), RS((int) (412.5 * hph)));
                alert_font.draw(batch, "" + (int) game.robot.TR(2, game.robot.Bid, game.robot.Bl, 4), RS((int) (((float) width - 455.0) * wpw)), RS((int) (412.5 * hph)));
            }
                drawer.draw(left, RS(width-550-120/2*left_scale+60), RS(470-100/2*left_scale+50), RS(100*left_scale), RS(120*left_scale));
                drawer.draw(right, RS(width-150-120/2*right_scale+60), RS(470-100/2*right_scale+50), RS(100*right_scale), RS(120*right_scale));
        }
        if(which_select == 3){
            item_font.draw(batch, "Механо-нога", RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            if(game.robot.BLeg[game.robot.LLid-1] > 0) {
                drawer.draw(workpage, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BLeg[game.robot.LLid-1] == -1) {
                drawer.draw(workpage_red, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BLeg[game.robot.LLid-1] == 0) {
                drawer.draw(workpage_blue, RS(width - 580), RS(350), RS(560), RS(365));
            }
            drawer.draw(game.robot.LL, RS(width-405), RS(445), RS(115), RS(115), RS(210), RS(210), left_scale*right_scale, left_scale*right_scale, 0);
            if(scale_frame>=0.7) {
                if(game.robot.BLeg[game.robot.LLid-1] > 0) {
                    drawer.draw(green_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    level_big_font.draw(batch, "" + game.robot.LLl, RS((int)(((float)width-537.5f)*wpw)), RS((int)(685.0*hph)));
                }
                if(game.robot.BLeg[game.robot.LLid-1] == 0) {
                    drawer.draw(level_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(yes, RS(width - 575), RS(605), RS(110), RS(110));
                }
                if(game.robot.BLeg[game.robot.LLid-1] < 0) {
                    drawer.draw(red_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(not, RS(width - 575), RS(605), RS(110), RS(110));
                }
            }
            if(number_1>0&&number_2>0){
                drawer.draw(state_back, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(state_speed, RS(width - 535), RS(380), RS((int) (250.0f * game.robot.TR(3, game.robot.LLid, game.robot.LLl, 5) / 7.5f)), RS(40));
                drawer.draw(state_frame, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(move_speed, RS(width - 565), RS(355), RS(100), RS(100));
                drawer.draw(state_back, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(state_health, RS(width - 275), RS(380), RS((int) (250.0f * game.robot.TR(3, game.robot.LLid, game.robot.LLl, 1) / 110.0f)), RS(40));
                drawer.draw(state_frame, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(health, RS(width - 295), RS(355), RS(100), RS(100));
                alert_font.draw(batch, "" + (int) game.robot.TR(3, game.robot.LLid, game.robot.LLl, 1), RS((int) (((float) width - 195.0) * wpw)), RS((int) (412.5 * hph)));
                alert_font.draw(batch, "" + (int) game.robot.TR(3, game.robot.LLid, game.robot.LLl, 5), RS((int) (((float) width - 455.0) * wpw)), RS((int) (412.5 * hph)));
            }
            drawer.draw(left, RS(width-550-120/2*left_scale+60), RS(470-100/2*left_scale+50), RS(100*left_scale), RS(120*left_scale));
            drawer.draw(right, RS(width-150-120/2*right_scale+60), RS(470-100/2*right_scale+50), RS(100*right_scale), RS(120*right_scale));
            /*
            item_font.draw(batch, "Механо-нога Ур. " + game.robot.LLid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.LLid*5 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(move_speed, RS(width-500),RS( 380),RS( 150), RS(150));
            item_font.draw(batch, "Скорость", RS((int)(((float)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.LLid)+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));*/
        }
        if(which_select == 4){
            item_font.draw(batch, "Механо-нога", RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            if(game.robot.BLeg[game.robot.RLid-1] > 0) {
                drawer.draw(workpage, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BLeg[game.robot.RLid-1] == -1) {
                drawer.draw(workpage_red, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BLeg[game.robot.RLid-1] == 0) {
                drawer.draw(workpage_blue, RS(width - 580), RS(350), RS(560), RS(365));
            }
            drawer.draw(game.robot.RL, RS(width-405), RS(445), RS(115), RS(115), RS(210), RS(210), left_scale*right_scale, left_scale*right_scale, 0);
            if(scale_frame>=0.7) {
                if(game.robot.BLeg[game.robot.RLid-1] > 0) {
                    drawer.draw(green_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    level_big_font.draw(batch, "" + game.robot.RLl, RS((int)(((float)width-537.5f)*wpw)), RS((int)(685.0*hph)));
                }
                if(game.robot.BLeg[game.robot.RLid-1] == 0) {
                    drawer.draw(level_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(yes, RS(width - 575), RS(605), RS(110), RS(110));
                }
                if(game.robot.BLeg[game.robot.RLid-1] < 0) {
                    drawer.draw(red_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(not, RS(width - 575), RS(605), RS(110), RS(110));
                }
            }
            if(number_1>0&&number_2>0){
                drawer.draw(state_back, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(state_speed, RS(width - 535), RS(380), RS((int) (250.0f * game.robot.TR(3, game.robot.RLid, game.robot.RLl, 5) / 7.5f)), RS(40));
                drawer.draw(state_frame, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(move_speed, RS(width - 565), RS(355), RS(100), RS(100));
                drawer.draw(state_back, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(state_health, RS(width - 275), RS(380), RS((int) (250.0f * game.robot.TR(3, game.robot.RLid, game.robot.RLl, 1) / 110.0f)), RS(40));
                drawer.draw(state_frame, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(health, RS(width - 295), RS(355), RS(100), RS(100));

                alert_font.draw(batch, "" + (int) game.robot.TR(3, game.robot.RLid, game.robot.RLl, 1), RS((int) (((float) width - 195.0) * wpw)), RS((int) (412.5 * hph)));
                alert_font.draw(batch, "" + (int) game.robot.TR(3, game.robot.RLid, game.robot.RLl, 5), RS((int) (((float) width - 455.0) * wpw)), RS((int) (412.5 * hph)));
            }
            drawer.draw(left, RS(width - 550 - 120 / 2 * left_scale + 60), RS(470 - 100 / 2 * left_scale + 50), RS(100 * left_scale), RS(120 * left_scale));
            drawer.draw(right, RS(width - 150 - 120 / 2 * right_scale + 60), RS(470 - 100 / 2 * right_scale + 50), RS(100 * right_scale), RS(120 * right_scale));
            /*
            item_font.draw(batch, "Механо-нога Ур. " + game.robot.RLid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.RLid*5 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(move_speed, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Скорость", RS((int)(((float)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.RLid)+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));*/
        }
        if(which_select == 5){
            item_font.draw(batch, "Пушка", RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            if(game.robot.BHand[game.robot.LHid-1] > 0) {
                drawer.draw(workpage, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BHand[game.robot.LHid-1] == -1) {
                drawer.draw(workpage_red, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BHand[game.robot.LHid-1] == 0) {
                drawer.draw(workpage_blue, RS(width - 580), RS(350), RS(560), RS(365));
            }
            drawer.draw(game.robot.LH, RS(width-410), RS(440), RS(115), RS(115), RS(220), RS(220), left_scale*right_scale, left_scale*right_scale, 0);
            if(scale_frame>=0.7) {
                if(game.robot.BHand[game.robot.LHid-1] > 0) {
                    drawer.draw(green_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    level_big_font.draw(batch, "" + game.robot.LHl, RS((int)(((float)width-537.5f)*wpw)), RS((int)(685.0*hph)));
                }
                if(game.robot.BHand[game.robot.LHid-1] == 0) {
                    drawer.draw(level_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(yes, RS(width - 575), RS(605), RS(110), RS(110));
                }
                if(game.robot.BHand[game.robot.LHid-1] < 0) {
                    drawer.draw(red_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(not, RS(width - 575), RS(605), RS(110), RS(110));
                }
            }
            if(number_1>0&&number_2>0){
                drawer.draw(state_back, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(state_damage, RS(width - 535), RS(380), RS((int) (250.0f * game.robot.TR(4, game.robot.LHid, game.robot.LHl, 2) / 27.5f)), RS(40));
                drawer.draw(state_frame, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(damage, RS(width - 565), RS(355), RS(100), RS(100));
                drawer.draw(state_back, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(state_health, RS(width - 275), RS(380), RS((int) (250.0f * game.robot.TR(4, game.robot.LHid, game.robot.LHl, 1) / 112.5f)), RS(40));
                drawer.draw(state_frame, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(health, RS(width - 295), RS(355), RS(100), RS(100));

                alert_font.draw(batch, "" + (int) game.robot.TR(4, game.robot.LHid, game.robot.LHl, 1), RS((int) (((float) width - 195.0) * wpw)), RS((int) (412.5 * hph)));
                alert_font.draw(batch, "" + (int) game.robot.TR(4, game.robot.LHid, game.robot.LHl, 2), RS((int) (((float) width - 455.0) * wpw)), RS((int) (412.5 * hph)));
            }
            drawer.draw(left, RS(width - 550 - 120 / 2 * left_scale + 60), RS(470 - 100 / 2 * left_scale + 50), RS(100 * left_scale), RS(120 * left_scale));
            drawer.draw(right, RS(width - 150 - 120 / 2 * right_scale + 60), RS(470 - 100 / 2 * right_scale + 50), RS(100 * right_scale), RS(120 * right_scale));
            /*
            item_font.draw(batch, "Бластер Ур. " + game.robot.LHid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.LHid*5 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(damage, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Урон", RS((int)(((float)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.LHid)*2+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));*/
        }
        if(which_select == 6){
            item_font.draw(batch, "Пушка", RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            if(game.robot.BHand[game.robot.RHid-1] > 0) {
                drawer.draw(workpage, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BHand[game.robot.RHid-1] == -1) {
                drawer.draw(workpage_red, RS(width - 580), RS(350), RS(560), RS(365));
            }
            if(game.robot.BHand[game.robot.RHid-1] == 0) {
                drawer.draw(workpage_blue, RS(width - 580), RS(350), RS(560), RS(365));
            }
            drawer.draw(game.robot.RH, RS(width-410), RS(440), RS(115), RS(115), RS(220), RS(220), left_scale*right_scale, left_scale*right_scale, 0);
            if(scale_frame>=0.7) {
                if(game.robot.BHand[game.robot.RHid-1] > 0) {
                    drawer.draw(green_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    level_big_font.draw(batch, "" + game.robot.RHl, RS((int)(((float)width-537.5f)*wpw)), RS((int)(685.0*hph)));
                }
                if(game.robot.BHand[game.robot.RHid-1] == 0) {
                    drawer.draw(level_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(yes, RS(width - 575), RS(605), RS(110), RS(110));
                }
                if(game.robot.BHand[game.robot.RHid-1] < 0) {
                    drawer.draw(red_circle, RS(width - 575), RS(605), RS(110), RS(110));
                    drawer.draw(not, RS(width - 575), RS(605), RS(110), RS(110));
                }
            }
            if(number_1>0&&number_2>0){
                drawer.draw(state_back, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(state_damage, RS(width - 535), RS(380), RS((int) (250.0f * game.robot.TR(4, game.robot.RHid, game.robot.RHl, 2) / 27.5f)), RS(40));
                drawer.draw(state_frame, RS(width - 545), RS(380), RS(250), RS(40));
                drawer.draw(damage, RS(width - 565), RS(355), RS(100), RS(100));
                drawer.draw(state_back, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(state_health, RS(width - 275), RS(380), RS((int) (250.0f * game.robot.TR(4, game.robot.RHid, game.robot.RHl, 1) / 112.5f)), RS(40));
                drawer.draw(state_frame, RS(width - 285), RS(380), RS(250), RS(40));
                drawer.draw(health, RS(width - 295), RS(355), RS(100), RS(100));
                alert_font.draw(batch, "" + (int) game.robot.TR(4, game.robot.RHid, game.robot.RHl, 1), RS((int) (((float) width - 195.0) * wpw)), RS((int) (412.5 * hph)));
                alert_font.draw(batch, "" + (int) game.robot.TR(4, game.robot.RHid, game.robot.RHl, 2), RS((int) (((float) width - 455.0) * wpw)), RS((int) (412.5 * hph)));
            }
            drawer.draw(left, RS(width - 550 - 120 / 2 * left_scale + 60), RS(470 - 100 / 2 * left_scale + 50), RS(100 * left_scale), RS(120 * left_scale));
            drawer.draw(right, RS(width - 150 - 120 / 2 * right_scale + 60), RS(470 - 100 / 2 * right_scale + 50), RS(100 * right_scale), RS(120 * right_scale));
            /*
            item_font.draw(batch, "Бластер Ур. " + game.robot.RHid, RS((int)(((float)width-540.0)*wpw)), RS((int)(780.0*hph)));
            item_font.draw(batch, game.robot.RHid*5 +"", RS((int)(((float)width-500.0)*wpw)), RS((int)(570.0*hph)));
            drawer.draw(damage, RS(width-500), RS(380), RS(150), RS(150));
            item_font.draw(batch, "Урон", RS((int)(((float)width-340.0)*wpw)), RS((int)(480.0*hph)));
            item_font.draw(batch, (game.robot.RHid)*2+"", RS((int)(((float)width-500.0)*wpw)), RS((int)(400.0*hph)));*/
        }
        DrawRobot(drawer, (int)x, y, scale, rothand, rothead, rotleg, rot, false, false, false, 90);
        DrawSelect(drawer, (int)x, y, scale, rothand, rothead, rotleg, rot, which_select_will, actual_model);
        if(cu){
            drawer.draw(leg_cu, (int)x-(int)(50*scale), height-y_cu, 400, 400);
            if(y_cu>=300){
                drawer.draw(saw, (int)x-(int)(50*scale)+50, height-50-y_cu+50, 150*saw_scale, 150*saw_scale,  (300*saw_scale),  (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(cd){
            drawer.draw(leg_cd, (int)x-(int)(50*scale), y_cd-400, 400, 400);
            if(y_cd>=400){
                drawer.draw(saw, (int)x-(int)(50*scale)+50, y_cd-350+50, 150*saw_scale, 150*saw_scale,  (300*saw_scale),  (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(ld){
            drawer.draw(leg_ld, (int)x-(int)(100*scale), y_ld-300, 400, 400);
            if(y_ld>=300){
                drawer.draw(saw, (int)x-(int)(100*scale)+50, y_ld-250+50, 150*saw_scale, 150*saw_scale,  (300*saw_scale),  (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(rd){
            drawer.draw(leg_rd, (int)x+(int)(10*scale), y_rd-300, 400, 400);
            if(y_rd>=300){
                drawer.draw(saw, (int)x+(int)(10*scale)+50, y_rd-250+50, 150*saw_scale, 150*saw_scale,  (300*saw_scale),  (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(lu){
            drawer.draw(leg_lu, (int)x-(int)(170*scale), height-y_lu, 500, 500);
            if(y_lu>=500){
                drawer.draw(saw, (int)x-(int)(170*scale)+100, height-y_lu-80+100, 150*saw_scale, 150*saw_scale,  (300*saw_scale),  (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(ru){
            drawer.draw(leg_ru, (int)x+(int)(30*scale)-10, height-y_ru, 500, 500);
            if(y_ru>=500){
                drawer.draw(saw, (int)x+(int)(20*scale)-10+100, height-y_ru-80+100, 150*saw_scale, 150*saw_scale,  (300*saw_scale),  (300*saw_scale), 1, 1,  saw_rotate);
            }
        }
        if(light_anime<3) {
            drawer.draw(light[light_anime], -200.0f, -200, (float) (width / 2 - 100), height + 350.0f, (float) (width), (float) (height + 300), 1, 1, rotlamp);
        }
        drawer.draw(Frontground, 0, 0, width, height);
        drawer.draw(lamp, -200.0f, -250, (float)(width/2-100), height+350.0f, (float) (width), (float) (height+300), 1, 1, rotlamp);
        CheckDoor(drawer);
        batch.end();
        if(closed){
            if(!actual_model) {
                game.robot.Hid = LHid;
                game.robot.Bid = LBid;
                game.robot.RHid = LRHid;
                game.robot.LHid = LLHid;
                game.robot.RLid = LRLid;
                game.robot.LLid = LLLid;

                game.robot.Hid = LHid;
                game.robot.Bid = LBid;
                game.robot.RHid = LRHid;
                game.robot.LHid = LLHid;
                game.robot.RLid = LRLid;
                game.robot.LLid = LLLid;
                game.robot.UpdateRobotTexture(which_select);
                actual_model = true;
            }
            game.setGameMenu();
        }
        if(need_to_upgrade_power_1){
            power_1.dispose();
            power_1 = new Texture("Button/button_1_" + game.robot.Hid + "_1.png");
            need_to_upgrade_power_1 = false;
        }
        if(need_to_upgrade_power_2){
            power_2.dispose();
            power_2 = new Texture("Button/button_2_" + game.robot.Bid + "_1.png");
            need_to_upgrade_power_2 = false;
        }
        if(need_to_update_detail){
            game.robot.UpdateRobotTexture(which_select);
            need_to_update_detail = false;
        }
    }
    public void NextRightPart(int select){
        if(select == 1){
            if(game.robot.Hid < 5){
                game.robot.Hid++;
                game.robot.Hl = game.robot.BHead[game.robot.Hid-1];
                power_1.dispose();
                power_1 = new Texture("Button/button_1_" + game.robot.Hid + "_1.png");
                max_level = game.robot.Hl >= 5;
                created_level = game.robot.BHead[game.robot.Hid-1] > 0;
                type_1 = 3;
                type_2 = 2;
                number_1 = 8 * game.robot.Hl;
                number_2 = 5 * game.robot.Hl;
                SetNumbersCost(game.robot.Hid);
                can_type_1 = game.robot.microchips >= number_1;
                can_type_2 = game.robot.lamps >= number_2;
                upgrade_can = game.robot.microchips >= number_1 && game.robot.lamps >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
        if(select == 2){
            if(game.robot.Bid < 5){
                game.robot.Bid++;
                game.robot.Bl = game.robot.BBody[game.robot.Bid-1];
                power_2.dispose();
                power_2 = new Texture("Button/button_2_" + game.robot.Bid + "_1.png");
                max_level = game.robot.Bl >= 5;
                created_level = game.robot.BBody[game.robot.Bid-1] > 0;
                type_1 = 3;
                type_2 = 1;
                number_1 = 6 * game.robot.Bl;
                number_2 = 9 * game.robot.Bl;
                SetNumbersCost(game.robot.Bid);
                can_type_1 = game.robot.microchips >= number_1;
                can_type_2 = game.robot.metal >= number_2;
                upgrade_can = game.robot.microchips >= number_1 && game.robot.metal >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
        if(select == 3){
            if(game.robot.LLid < 5){
                game.robot.LLid++;
                game.robot.LLl = game.robot.BLeg[game.robot.LLid-1];
                max_level = game.robot.LLl >= 5;
                created_level = game.robot.BLeg[game.robot.LLid-1] > 0;
                type_1 = 4;
                type_2 = 1;
                number_1 = 6 * game.robot.LLl;
                number_2 = 7 * game.robot.LLl;
                SetNumbersCost(game.robot.LLid);
                can_type_1 = game.robot.gears >= number_1;
                can_type_2 = game.robot.metal >= number_2;
                upgrade_can = game.robot.gears >= number_1 && game.robot.metal >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
        if(select == 4){
            if(game.robot.RLid < 5){
                game.robot.RLid++;
                game.robot.RLl = game.robot.BLeg[game.robot.RLid-1];
                max_level = game.robot.RLl >= 5;
                created_level = game.robot.BLeg[game.robot.RLid-1] > 0;
                type_1 = 4;
                type_2 = 1;
                number_1 = 6 * game.robot.RLl;
                number_2 = 7 * game.robot.RLl;
                SetNumbersCost(game.robot.RLid);
                can_type_1 = game.robot.gears >= number_1;
                can_type_2 = game.robot.metal >= number_2;
                upgrade_can = game.robot.gears >= number_1 && game.robot.metal >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
        if(select == 5){
            if(game.robot.LHid < 5){
                game.robot.LHid++;
                game.robot.LHl = game.robot.BHand[game.robot.LHid-1];
                max_level = game.robot.LHl >= 5;
                created_level = game.robot.BHand[game.robot.LHid-1] > 0;
                type_1 = 4;
                type_2 = 2;
                number_1 = 6 * game.robot.LHl;
                number_2 = 8 * game.robot.LHl;
                SetNumbersCost(game.robot.LHid);
                can_type_1 = game.robot.gears >= number_1;
                can_type_2 = game.robot.lamps >= number_2;
                upgrade_can = game.robot.gears >= number_1 && game.robot.lamps >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
        if(select == 6){
            if(game.robot.RHid < 5){
                game.robot.RHid++;
                game.robot.RHl = game.robot.BHand[game.robot.RHid-1];
                max_level = game.robot.RHl >= 5;
                created_level = game.robot.BHand[game.robot.RHid-1] > 0;
                type_1 = 4;
                type_2 = 2;
                number_1 = 6 * game.robot.RHl;
                number_2 = 8 * game.robot.RHl;
                SetNumbersCost(game.robot.RHid);
                can_type_1 = game.robot.gears >= number_1;
                can_type_2 = game.robot.lamps >= number_2;
                upgrade_can = game.robot.gears >= number_1 && game.robot.lamps >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }

        game.robot.UpdateRobotTexture(select);

    }
    public void NextLeftPart(int select){
        if(select == 1){
            if(game.robot.Hid > 1){
                game.robot.Hid--;
                game.robot.Hl = game.robot.BHead[game.robot.Hid-1];
                power_1.dispose();
                power_1 = new Texture("Button/button_1_" + game.robot.Hid + "_1.png");
                max_level = game.robot.Hl >= 5;
                created_level = game.robot.BHead[game.robot.Hid-1] > 0;
                type_1 = 3;
                type_2 = 2;
                number_1 = 8 * game.robot.Hl;
                number_2 = 5 * game.robot.Hl;
                SetNumbersCost(game.robot.Hid);
                can_type_1 = game.robot.microchips >= number_1;
                can_type_2 = game.robot.lamps >= number_2;
                upgrade_can = game.robot.microchips >= number_1 && game.robot.lamps >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
        if(select == 2){
            if(game.robot.Bid > 1){
                game.robot.Bid--;
                game.robot.Bl = game.robot.BBody[game.robot.Bid-1];
                power_2.dispose();
                power_2 = new Texture("Button/button_2_" + game.robot.Bid + "_1.png");
                max_level = game.robot.Bl >= 5;
                created_level = game.robot.BBody[game.robot.Bid-1] > 0;
                type_1 = 3;
                type_2 = 1;
                number_1 = 6 * game.robot.Bl;
                number_2 = 9 * game.robot.Bl;
                SetNumbersCost(game.robot.Bid);
                can_type_1 = game.robot.microchips >= number_1;
                can_type_2 = game.robot.metal >= number_2;
                upgrade_can = game.robot.microchips >= number_1 && game.robot.metal >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
        if(select == 3){
            if(game.robot.LLid > 1){
                game.robot.LLid--;
                game.robot.LLl = game.robot.BLeg[game.robot.LLid-1];
                max_level = game.robot.LLl >= 5;
                created_level = game.robot.BLeg[game.robot.LLid-1] > 0;
                type_1 = 4;
                type_2 = 1;
                number_1 = 6 * game.robot.LLl;
                number_2 = 7 * game.robot.LLl;
                SetNumbersCost(game.robot.LLid);
                can_type_1 = game.robot.gears >= number_1;
                can_type_2 = game.robot.metal >= number_2;
                upgrade_can = game.robot.gears >= number_1 && game.robot.metal >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
        if(select == 4){
            if(game.robot.RLid > 1){
                game.robot.RLid--;
                game.robot.RLl = game.robot.BLeg[game.robot.RLid-1];
                max_level = game.robot.RLl >= 5;
                created_level = game.robot.BLeg[game.robot.RLid-1] > 0;
                type_1 = 4;
                type_2 = 1;
                number_1 = 6 * game.robot.RLl;
                number_2 = 7 * game.robot.RLl;
                SetNumbersCost(game.robot.RLid);
                can_type_1 = game.robot.gears >= number_1;
                can_type_2 = game.robot.metal >= number_2;
                upgrade_can = game.robot.gears >= number_1 && game.robot.metal >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
        if(select == 5){
            if(game.robot.LHid > 1){
                game.robot.LHid--;
                game.robot.LHl = game.robot.BHand[game.robot.LHid-1];
                max_level = game.robot.LHl >= 5;
                created_level = game.robot.BHand[game.robot.LHid-1] > 0;
                type_1 = 4;
                type_2 = 2;
                number_1 = 6 * game.robot.LHl;
                number_2 = 8 * game.robot.LHl;
                SetNumbersCost(game.robot.LHid);
                can_type_1 = game.robot.gears >= number_1;
                can_type_2 = game.robot.lamps >= number_2;
                upgrade_can = game.robot.gears >= number_1 && game.robot.lamps >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
        if(select == 6){
            if(game.robot.RHid > 1){
                game.robot.RHid--;
                game.robot.RHl = game.robot.BHand[game.robot.RHid-1];
                max_level = game.robot.RHl >= 5;
                created_level = game.robot.BHand[game.robot.RHid-1] > 0;
                type_1 = 4;
                type_2 = 2;
                number_1 = 6 * game.robot.RHl;
                number_2 = 8 * game.robot.RHl;
                SetNumbersCost(game.robot.RHid);
                can_type_1 = game.robot.gears >= number_1;
                can_type_2 = game.robot.lamps >= number_2;
                upgrade_can = game.robot.gears >= number_1 && game.robot.lamps >= number_2;
                CanUpgrade();
                CheckActual(which_select);
            }
        }
                game.robot.UpdateRobotTexture(select);

    }
    public void CheckActual( int selected){
       if(selected == 1){
           if(game.robot.BHead[game.robot.Hid-1] > 0){
               actual_model = true;
               LHid = game.robot.Hid;
               LHl = game.robot.Hl;
           }else{
               actual_model = false;
           }
       }
        if(selected == 2){
            if(game.robot.BBody[game.robot.Bid-1] > 0){
                actual_model = true;
                LBid = game.robot.Bid;
                LBl = game.robot.Bl;
            }else{
                actual_model = false;
            }
        }
        if(selected == 6){
            if(game.robot.BHand[game.robot.RHid-1] > 0){
                actual_model = true;
                LRHid = game.robot.RHid;
                LRHl = game.robot.RHl;
            }else{
                actual_model = false;
            }
        }
        if(selected == 5){
            if(game.robot.BHand[game.robot.LHid-1] > 0){
                actual_model = true;
                LLHid = game.robot.LHid;
                LLHl = game.robot.LHl;
            }else{
                actual_model = false;
            }
        }
        if(selected == 4){
            if(game.robot.BLeg[game.robot.RLid-1] > 0){
                actual_model = true;
                LRLid = game.robot.RLid;
                LRLl = game.robot.RLl;
            }else{
                actual_model = false;
            }
        }
        if(selected == 3){
            if(game.robot.BLeg[game.robot.LLid-1] > 0){
                actual_model = true;
                LLLid = game.robot.LLid;
                LLLl = game.robot.LLl;
            }else{
                actual_model = false;
            }
        }
    }
    public void SetNumbersCost(int m){//model

        if(number_1==0){
            number_1=m*5;
        }
        if(number_2==0){
            number_2=m*5;
        }
    }
    public void CanUpgrade(){
        if(number_1<0||number_2<0){
            upgrade_can = false;
        }
    }
    public void Swap(){
        if(can_swap) {
            can_swap = false;
            anime = new Thread() {
                @Override
                public void run() {
                    if(!actual_model) {
                        game.robot.Hid = LHid;
                        game.robot.Bid = LBid;
                        game.robot.RHid = LRHid;
                        game.robot.LHid = LLHid;
                        game.robot.RLid = LRLid;
                        game.robot.LLid = LLLid;

                        game.robot.Hl = LHl;
                        game.robot.Bl = LBl;
                        game.robot.RHl = LRHl;
                        game.robot.LHl = LLHl;
                        game.robot.RLl = LRLl;
                        game.robot.LLl = LLLl;
                        need_to_update_detail = true;
                        actual_model = true;
                    }
                    while (scale_frame > 0.1) {
                        scale_frame -= 0.01;
                        Sleep(3);
                    }

                    which_select = which_select_will;

                    if (which_select == 1) {
                        game.robot.Hl = game.robot.BHead[game.robot.Hid-1];
                        max_level = game.robot.Hl >= 5;
                        need_to_upgrade_power_1 = true;
                        created_level = game.robot.BHead[game.robot.Hid-1] > 0;
                        type_1 = 3;
                        type_2 = 2;
                        number_1 = 8 * game.robot.Hl;
                        number_2 = 5 * game.robot.Hl;
                        SetNumbersCost(game.robot.Hid);
                        can_type_1 = game.robot.microchips >= number_1;
                        can_type_2 = game.robot.lamps >= number_2;
                        upgrade_can = game.robot.microchips >= number_1 && game.robot.lamps >= number_2;
                        CanUpgrade();
                        CheckActual(which_select);
                    }
                    if (which_select == 2) {
                        game.robot.Bl = game.robot.BBody[game.robot.Bid-1];
                        max_level = game.robot.Bl >= 5;
                        need_to_upgrade_power_2 = true;
                        created_level = game.robot.BBody[game.robot.Bid-1] > 0;
                        type_1 = 3;
                        type_2 = 1;
                        number_1 = 6 * game.robot.Bl;
                        number_2 = 9 * game.robot.Bl;
                        SetNumbersCost(game.robot.Hid);
                        can_type_1 = game.robot.microchips >= number_1;
                        can_type_2 = game.robot.metal >= number_2;
                        upgrade_can = game.robot.microchips >= number_1 && game.robot.metal >= number_2;
                        CanUpgrade();
                        CheckActual(which_select);
                    }
                    if (which_select == 3) {
                        game.robot.LLl = game.robot.BLeg[game.robot.LLid-1];
                        max_level = game.robot.LLl >= 5;
                        created_level = game.robot.BLeg[game.robot.LLid-1] > 0;
                        type_1 = 4;
                        type_2 = 1;
                        number_1 = 6 * game.robot.LLl;
                        number_2 = 7 * game.robot.LLl;
                        SetNumbersCost(game.robot.Hid);
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.metal >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.metal >= number_2;
                        CanUpgrade();
                        CheckActual(which_select);
                    }
                    if (which_select == 4) {
                        game.robot.RLl = game.robot.BLeg[game.robot.RLid-1];
                        max_level = game.robot.RLl >= 5;
                        created_level = game.robot.BLeg[game.robot.RLid-1] > 0;
                        type_1 = 4;
                        type_2 = 1;
                        number_1 = 6 * game.robot.RLl;
                        number_2 = 7 * game.robot.RLl;
                        SetNumbersCost(game.robot.Hid);
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.metal >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.metal >= number_2;
                        CanUpgrade();
                        CheckActual(which_select);
                    }
                    if (which_select == 5) {
                        game.robot.LHl = game.robot.BHand[game.robot.LHid-1];
                        max_level = game.robot.LHl >= 5;
                        created_level = game.robot.BHand[game.robot.LHid-1] > 0;
                        type_1 = 4;
                        type_2 = 2;
                        number_1 = 6 * game.robot.LHl;
                        number_2 = 8 * game.robot.LHl;
                        SetNumbersCost(game.robot.Hid);
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.lamps >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.lamps >= number_2;
                        CanUpgrade();
                        CheckActual(which_select);
                    }
                    if (which_select == 6) {
                        game.robot.RHl = game.robot.BHand[game.robot.RHid-1];
                        max_level = game.robot.RHl >= 5;
                        created_level = game.robot.BHand[game.robot.RHid-1] > 0;
                        type_1 = 4;
                        type_2 = 2;
                        number_1 = 6 * game.robot.RHl;
                        number_2 = 8 * game.robot.RHl;
                        SetNumbersCost(game.robot.Hid);
                        can_type_1 = game.robot.gears >= number_1;
                        can_type_2 = game.robot.lamps >= number_2;
                        upgrade_can = game.robot.gears >= number_1 && game.robot.lamps >= number_2;
                        CanUpgrade();
                        CheckActual(which_select);
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
    public int RS(float value){ //right scale
        return (int)(value*scale_frame)-(int)((1.0-scale_frame)*400);
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
                if (game.robot.Hl < 5) {
                    game.robot.Hl++;
                    game.robot.BHead[game.robot.Hid-1] = game.robot.Hl;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(1);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 2) {
                if (game.robot.Bl < 5) {
                    game.robot.Bl++;
                    game.robot.BBody[game.robot.Bid-1] = game.robot.Bl;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(2);
                    upgrade.play(0.8f);
                }
            }
            if (which_select == 6) {
                if (game.robot.RHl < 5) {
                    game.robot.RHl++;
                    game.robot.BHand[game.robot.RHid-1] = game.robot.RHl;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(6);
                    upgrade.play(0.8f);
                    if(game.robot.RHid == game.robot.LHid){
                        game.robot.LHl++;
                        game.robot.BHand[game.robot.LHid-1] = game.robot.LHl;
                        game.robot.UpdateRobotTexture(5);
                        AddLeg(5);
                    }
                }
            }
            if (which_select == 5) {
                if (game.robot.LHl < 5) {
                    game.robot.LHl++;
                    game.robot.BHand[game.robot.LHid-1] = game.robot.LHl;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(5);
                    upgrade.play(0.8f);
                    if(game.robot.RHid == game.robot.LHid) {
                        game.robot.RHl++;
                        game.robot.BHand[game.robot.RHid-1] = game.robot.RHl;
                        game.robot.UpdateRobotTexture(6);
                        AddLeg(6);
                    }
                    }
            }
            if (which_select == 4) {
                if (game.robot.RLl < 5) {
                    game.robot.RLl++;
                    game.robot.BLeg[game.robot.RLid - 1] = game.robot.RLl;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(4);
                    upgrade.play(0.8f);
                    if (game.robot.RLid == game.robot.LLid) {
                        game.robot.LLl++;
                        game.robot.BLeg[game.robot.LLid - 1] = game.robot.LLl;
                        game.robot.UpdateRobotTexture(3);
                        AddLeg(3);
                    }
                }
            }
            if (which_select == 3) {
                if (game.robot.LLl < 5) {
                    game.robot.LLl++;
                    game.robot.BLeg[game.robot.LLid-1] = game.robot.LLl;
                    game.robot.UpdateRobotTexture(which_select);
                    AddLeg(3);
                    upgrade.play(0.8f);
                    if (game.robot.RLid == game.robot.LLid) {
                        game.robot.RLl++;
                        game.robot.BLeg[game.robot.RLid - 1] = game.robot.RLl;
                        game.robot.UpdateRobotTexture(4);
                        AddLeg(4);
                    }
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
            actual_model = true;
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
        for(int i = 0; i<5; i++) tube_elements_texture[i].dispose();

        tube.dispose();
        machine_4.dispose();
        machine_2.dispose();
        machine_3.dispose();
        red_touched.dispose();
        upgrade.dispose();
        game.robot.DisposeWorkMenuTextures();
        lightt_1.dispose();
        lightt_2.dispose();
        lampt.dispose();
        red.dispose();
        background.dispose();
        frame.dispose();
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
        leg_lu.dispose();
        leg_ru.dispose();
        leg_cu.dispose();
        leg_ld.dispose();
        leg_rd.dispose();
        leg_cd.dispose();
        state_bonus.dispose();
        state_back.dispose();
        state_frame.dispose();
        state_health.dispose();
        state_energy.dispose();
        state_damage.dispose();
        state_speed.dispose();
        saw_texture.dispose();
        workpage.dispose();
        workpage_red.dispose();
        workpage_blue.dispose();
        metal.dispose();
        metall.dispose();
        left.dispose();
        right.dispose();
        level_circle.dispose();
        green_circle.dispose();
        red_circle.dispose();
        power_1.dispose();
        power_2.dispose();
    }
    }