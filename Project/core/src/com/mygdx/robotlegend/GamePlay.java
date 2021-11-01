 package com.mygdx.robotlegend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

public class GamePlay extends Openable implements Screen{
    SpriteBatch batch;
    Server server;
    Client client;
    Sound[] blaster;
    Sound[] hit;
    Sound[] move;
    Sound death;
    Sound siren;
    Sound boom;
    Thread AddResize;
    Thread Eanime;//Анимации Врага
    Thread EnergyAdd;
    Thread EnemyBrine;
    Thread EEnergyAdd;
    Thread CrossAdd;
    Thread StartLevel;
    Thread MedAdd;
    Thread BoomAdd;
    Thread TimeAdd;
    Thread PlanetAdd;
    Thread PressAdd;
    Thread AddSkins;
    Thread AddAlert;
    Thread PacketSet;
    Thread FireAnime;
    Texture puck;
    Texture Front_energy;
    Texture Rocket;
    Texture floor;
    Texture background;
    Texture grass;
    Texture up_1;
    Texture down_1;
    Texture up_2;
    Texture down_2;
    Texture redir;
    Texture fire;
    Texture jump;
    Texture up_1_touched;
    Texture down_1_touched;
    Texture up_2_touched;
    Texture down_2_touched;
    Texture redir_touched;
    Texture fire_touched;
    Texture jump_touched;
    Texture ball;
    Texture ball_touched;
    Texture Meteort;
    Texture Splash;
    Texture Fire;
    Texture Frontground;
    Texture Wineffect;
    Texture Darkeffect;
    Texture Openlevel_1;
    Texture Openlevel_2;
    Texture MedSwap;
    Texture gear;
    Texture chip;
    Texture metall;
    Texture bulb;
    Texture Bluefire;
    Texture planett;
    Texture FrontLevel2;
    Texture UpPress;
    Texture DownPress;
    Texture puck_swap;
    Texture ball_cant;
    Texture resize;
    Texture resize_2;
    Texture big_grass;
    Texture level_circle;
    Texture level_back;
    Texture level_front;
    Texture level_line;
    Texture energy_circle_texture;
    Texture jetpack;
    Texture jetpack_touched;
    Texture[] fire_location = new Texture[3];
    Texture[] achivement = new Texture[4];
    Texture[] med = new Texture[5];
    Texture[] booms = new Texture[3];
    Texture[] begin_left = new Texture[3];
    Texture[] begin_right = new Texture[3];
    TextureRegion energy_circle;
    TextureRegion planet;
    TextureRegion Meteor;
    TextureRegion Effect;
    String location_name_1;
    String location_name_2;
    float Eball_state = 0.0f;
    float ball_state = 0.0f;
    int jetpack_state = 0;
    int resize_y = 0;
    int alert_x = 400;
    int alert_y = 0;
    int alert_x_plus = 0;
    int gift_size;
    int gift_y;
    int gift_x;
    int press_y;
    int front_energy_scale = 0;
    int win_y = 0;
    int boom_x = 0;
    int boom_y = 0;
    int boom_anime = 1;
    int boom_height = 0;
    int robot_speed_bonus = 0;
    int Erobot_speed_bonus = 0;
    float win_rot = 0.0f;
    int win_scale = 0;
    int win = 0;
    int win_type = 0;
    int win_num = 0;
    int meteor_splash_size = 0;
    int cross_size= 0;
    int meteor_x = 0;
    int meteor_y = 0;
    int will_meteor_x = 0;
    int will_meteor_y = 0;
    int med_x = 0;
    int med_y = 0;
    int med_scale = 0;
    int med_anime = 0;
    int[] bullets_x = new int[40];
    double[] bullets_y = new double[40];
    int[] bullets_dir = new int[40];
    int[] bullets_type = new int[40];
    int[] fire_x_1 = new int[10];
    int[] fire_x_2 = new int[10];
    int[] fire_x_3 = new int[10];
    int[] fire_state_1 = new int[10];
    int[] fire_state_2 = new int[10];
    int[] fire_state_3 = new int[10];
    int fire_anime = 0;
    int warning = 0;
    int lastnumbullet;
    int Elastnumbullet;             //Это я делал, чтобы передавать номер обрабатываемой пули в поток с анимацией этой пули. Жесткая дичь, но работает.
    int bullets = 0;
    int pos_interface = 0;
    int dir = 1;
    int y = 1;
    int x = 1;
    int health;
    int Edir = -1;
    int Ey = 1;
    int Ex = 8;
    int Ehealth;
    int grass_dir = 1;
    int energy;
    int Eenergy = 200;
    int energy_use = 0;
    int openlevel_x = 0;
    int time = 120;
    int type_achivement = 1;
    int gift_index = 0;
    int local_speed = 0;
    int resized = 0;
    int experience = 0;
    double speed = 1.0;
    double anime_grass = 0;
    double rotate_planet = 0;
    double x_planet = 0;
    int[] grass_1 = new int[10];
    int[] grass_2 = new int[10];
    int[] grass_3 = new int[10];
    float[] grass_1_scale = new float[10];
    float[] grass_2_scale = new float[10];
    float[] grass_3_scale = new float[10];
    int[] grass_1_type = new int[10];
    int[] grass_2_type  = new int[10];
    int[] grass_3_type  = new int[10];
    float scale_inteface = 1.1f;
    float robot_x = 0;
    float robot_y = 0;
    float Erobot_x = 0;
    float Erobot_y = 0;
    float rothand = 0;
    float rotleg = 0;
    float rothead = 0;
    float rot = 0;
    float scale = 0.8f;
    float Erothand = 270;
    float Erotleg = 0;
    float Erothead = 0;
    float Erot = 0;
    float Escale = 0.8f;
    float meteor_rot = 0.0f;
    int connect_try = 0;
    int tcp = 26980;
    int udp = 26980;
    int anime_begin = 1;
    int show_exp_x = -500;
    boolean up_cant = false;
    boolean down_cant = false;
    boolean Eup_cant = false;
    boolean Edown_cant = false;
    boolean fire_cant = false;
    boolean Efire_cant = false;
    boolean robot_circle = false;
    boolean Erobot_circle = false;
    boolean needOnlineChanges = false;
    boolean host;
    boolean connected = false;
    boolean online;
    boolean music_swapped = false;
    boolean Eball_can = true;
    boolean Eball_clicked = false;
    boolean ball_can = true;
    boolean ball_touch = false;
    boolean ball_clicked = false;
    boolean needGift = false;
    boolean EneedGift = false;
    boolean gift_swap = false;
    boolean gift_added = false;
    boolean Erobotboom = false;
    boolean robotboom = false;
    boolean isboom = false;
    boolean meteor_rocket = false;
    boolean med_used = false;
    boolean med_is = false;
    boolean med_swap = false;
    boolean meteor_splash = false;
    boolean meteor_run = false;
    boolean dead = false;
    boolean Edead = false;
    boolean hurt = false;
    boolean Ehurt = false;
    boolean isEnergyWarning = false;
    boolean fire_clicked = false;
    boolean swap = false;
    boolean Eswap = false;
    boolean Efire_clicked = false;
    boolean Eredir_clicked = false;
    boolean Eup_clicked = false;
    boolean Edown_clicked = false;
    boolean Ejump_clicked = false;
    boolean redir_clicked = false;
    boolean up_clicked = false;
    boolean down_clicked = false;
    boolean jump_clicked = false;
    boolean up_touch = false;
    boolean down_touch = false;
    boolean redir_touch = false;
    boolean fire_touch = false;
    boolean jump_touch = false;
    boolean end = false;
    boolean ending = false;
    boolean moreboom = false;
    boolean alert_location = false;
    boolean resizing=false;
    boolean show_exp;
    boolean Ejetpack_clicked=false;
    boolean Ejetpack_touch=false;
    boolean Ejetpack_flying=false;
    boolean jetpack_clicked=false;
    boolean jetpack_touch=false;
    boolean jetpack_flying=false;
    int energy_circle_size = 0;
    int Eenergy_circle_size = 0;
    int dead_state;
    int Edead_state;
    int MEturnedJump = 0;
    int MEturnedFire = 0;
    int MEturnedUp = 0;
    int MEturnedDown = 0;
    int MEturnedBall = 0;
    int MEturnedMeteor = 0;
    int MEturnedBoom = 0;
    int MEturnedRedir = 0;
    int EturnedJump = 0;
    int EturnedFire = 0;
    int EturnedUp = 0;
    int EturnedDown = 0;
    int EturnedBall = 0;
    //int EturnedMeteor = 0;
    //int EturnedBoom = 0;
    int EturnedRedir = 0;
    int turnedJump = 0;
    int turnedFire = 0;
    int turnedUp = 0;
    int turnedDown = 0;
    int turnedBall = 0;
    //int turnedMeteor = 0;
    //int turnedBoom = 0;
    int turnedRedir = 0;
    public GamePlay(MainGame game, boolean online, boolean host) { this.game = game; this.online = online; this.host = host;}
    @Override
    public void show() {
        game.MusicSwap(2);
        game.robot.SetGamePlayTextures();
        if (game.robot.level != 2) {
            booms[0] = new Texture("Object/energy_1.png");
            booms[1] = new Texture("Object/energy_2.png");
            booms[2] = new Texture("Object/energy_3.png");
        } else {
            booms[0] = new Texture("Object/energy_1_2.png");
            booms[1] = new Texture("Object/energy_2_2.png");
            booms[2] = new Texture("Object/energy_3_2.png");
        }
        if(game.robot.level!=2) {
            fire_location[0] = new Texture("Object/fire_" + game.robot.level + "_1.png");
            fire_location[1] = new Texture("Object/fire_" + game.robot.level + "_2.png");
            fire_location[2] = new Texture("Object/fire_" + game.robot.level + "_3.png");
        }
        level_circle =  new Texture("Object/level_circle.png");
        level_back =  new Texture("Object/level_backline.png");
        level_front =  new Texture("Object/level_frontline.png");
        level_line =  new Texture("Object/level_line.png");
        begin_left[0] = new Texture("Interface/openlevel_left_1.png");
        begin_left[1] = new Texture("Interface/openlevel_left_2.png");
        begin_left[2] = new Texture("Interface/openlevel_left_3.png");
        begin_right[0] = new Texture("Interface/openlevel_right_1.png");
        begin_right[1] = new Texture("Interface/openlevel_right_2.png");
        begin_right[2] = new Texture("Interface/openlevel_right_3.png");
        big_grass= new Texture("Location/grass_" + game.robot.level + "_2.png");

        energy_circle_texture = new Texture("Object/energy_circle.png");
        energy_circle = new TextureRegion(energy_circle_texture, 300, 300);

        metall = new Texture("Item/metall.png");
        chip = new Texture("Item/chip.png");
        bulb = new Texture("Item/bulb.png");
        gear = new Texture("Item/gear.png");
        if (game.robot.level == 2) {
            planett = new Texture("Object/planet_3.png");
            planet = new TextureRegion(planett, 400, 400);
            FrontLevel2 = new Texture("Location/background_2_front.png");
        }
        if (game.robot.level == 4) {

            FrontLevel2 = new Texture("Location/background_4_front.png");
        }
        achivement[0] = new Texture("Object/swap.png");
        achivement[1] = new Texture("Object/gold.png");
        achivement[2] = new Texture("Object/silver.png");
        achivement[3] = new Texture("Object/bronze.png");
        energy = game.robot.energy;
        Darkeffect = new Texture("Interface/dark.png");
        Wineffect = new Texture("Interface/gameplay_effect_1.png");
        if (game.robot.level != 1) {
            Rocket = new Texture("Object/rocket.png");
        } else {
            DownPress = new Texture("Object/down_press.png");
            UpPress = new Texture("Object/up_press.png");
            Rocket = new Texture("Object/rocket_2.png");
        }
        Effect = new TextureRegion(Wineffect, 300, 300);
        Frontground = new Texture("Interface/frontground.png");
        Front_energy = new Texture("Interface/frontground_energy.png");
        Openlevel_1 = new Texture("Interface/openlevel_1.png");
        Openlevel_2 = new Texture("Interface/openlevel_2.png");
        Bluefire = new Texture("Object/bluefire.png");
        MedSwap = new Texture("Object/health_swap.png");
        if (game.robot.level != 2 && game.robot.level != 1) {
            Splash = new Texture("Object/splash.png");
        } else {
            if (game.robot.level == 2) {
                local_speed = 2;
                Splash = new Texture("Object/splash_2.png");
            } else {
                Splash = new Texture("Object/splash_3.png");
            }
        }
        if (game.robot.opened < game.robot.max_skin) {
            gift_index = game.random.nextInt(game.robot.max_skin-1)+1;
            puck = new Texture("Object/gift_" + gift_index + ".png");
            puck_swap = new Texture("Object/gift_swap.png");
        }
        Fire = new Texture("Object/fire.png");
        Meteort = new Texture("Location/meteor_" + game.robot.level + ".png");
        Meteor = new TextureRegion(Meteort, 300, 300);

        grass = new Texture("Location/grass_" + game.robot.level + ".png");
        up_1 = new Texture("Button/button_up_-1.png");
        down_1 = new Texture("Button/button_down_-1.png");
        up_2 = new Texture("Button/button_up_1.png");
        down_2 = new Texture("Button/button_down_1.png");
        redir = new Texture("Button/button_redir.png");
        fire = new Texture("Button/button_fire.png");
        jump = new Texture("Button/button_jump.png");
        ball = new Texture("Button/button_ball.png");
        ball_cant = new Texture("Button/button_ball_red.png");
        ball_touched = new Texture("Button/button_ball_touched.png");
        up_1_touched = new Texture("Button/button_up_-1_touched.png");
        down_1_touched = new Texture("Button/button_down_-1_touched.png");
        up_2_touched = new Texture("Button/button_up_1_touched.png");
        down_2_touched = new Texture("Button/button_down_1_touched.png");
        redir_touched = new Texture("Button/button_redir_touched.png");
        fire_touched = new Texture("Button/button_fire_touched.png");
        jump_touched = new Texture("Button/button_jump_touched.png");
        jetpack = new Texture("Button/button_jetpack_" + game.robot.jetpack + ".png");
        jetpack_touched = new Texture("Button/button_jetpack_" + game.robot.jetpack + "_touched.png");
        Gdx.input.setInputProcessor(new GamePlayTouch(game, this));
        Start();
        for (int i = 0; i < 5; i++) {
            med[i] = new Texture("Object/health_" + (i + 1) + ".png");
        }
        server = game.server;
        client = game.client;
        if(online){
            if(host){
                x=1;
                Ex=8;
                dir=1;
                Edir=-1;
                try {
                    server.bind(udp, tcp);
                }catch (Exception ignored){}
                server.start();
                server.addListener(new GameServerListener(this));
            }else{
                x=8;
                Ex=1;
                dir=-1;
                Edir=1;
                client.start();
                try {
                    Log.info("Коннект идёт");
                    client.connect(5000, client.discoverHost(tcp, 3000), tcp, udp);
                    Log.info("Коннект есть");
                }catch (Exception ignored){}
                client.addListener(new GameClientListener(this));
            }
        }

        blaster = new Sound[3];
        blaster[0] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_1.wav"));
        blaster[1] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_2.wav"));
        blaster[2] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_3.wav"));
        hit = new Sound[3];
        hit[0] = Gdx.audio.newSound(Gdx.files.internal("Sound/hit_1.wav"));
        hit[1] = Gdx.audio.newSound(Gdx.files.internal("Sound/hit_2.wav"));
        hit[2] = Gdx.audio.newSound(Gdx.files.internal("Sound/hit_3.wav"));
        move = new Sound[3];
        move[0] = Gdx.audio.newSound(Gdx.files.internal("Sound/move_1.wav"));
        move[1] = Gdx.audio.newSound(Gdx.files.internal("Sound/move_2.wav"));
        move[2] = Gdx.audio.newSound(Gdx.files.internal("Sound/move_3.wav"));
        death = Gdx.audio.newSound(Gdx.files.internal("Sound/dead.wav"));
        siren = Gdx.audio.newSound(Gdx.files.internal("Sound/siren.wav"));
        boom = Gdx.audio.newSound(Gdx.files.internal("Sound/upgrade.wav"));
        parameter.size = (int) (150.0 * wpw);
        item_font = generator.generateFont(parameter);
    item_font.setColor(0, 140, 255, 1);
        int i = 0;

        if(game.robot.level!=1 && game.robot.level!=2) {
            while (i != 10) {
                grass_1[i] = i;
                grass_1_type[i] = 0;
                if (game.random.nextInt(2) == 1) {
                    if (game.random.nextInt(4) == 1) {
                        grass_1_type[i] = 1;
                    } else {
                        grass_1_type[i] = 2;
                    }
                }
                i++;
            }
            i = 0;
            while (i != 10) {
                grass_2[i] = i;
                grass_2_type[i] = 0;
                if (game.random.nextInt(2) == 1) {
                    if (game.random.nextInt(4) == 1) {
                        grass_2_type[i] = 1;
                    } else {
                        grass_2_type[i] = 2;
                    }
                }
                i++;
            }
            i = 0;
            while (i != 10) {
                grass_3[i] = i;
                grass_3_type[i] = 0;
                if (game.random.nextInt(2) == 1) {
                    if (game.random.nextInt(4) == 1) {
                        grass_3_type[i] = 1;
                    } else {
                        grass_3_type[i] = 2;
                    }
                }
                i++;
            }
        }else{
            while (i != 10) {
                grass_1[i] = i;
                grass_1_type[i] = 0;
                if (game.random.nextInt(4) == 1) {
                    if (game.random.nextInt(6) == 1) {
                        grass_1_type[i] = 1;
                    } else {
                        grass_1_type[i] = 2;
                    }
                }
                i++;
            }
            i = 0;
            while (i != 10) {
                grass_2[i] = i;
                grass_2_type[i] = 0;
                if (game.random.nextInt(4) == 1) {
                    if (game.random.nextInt(5) == 1) {
                        grass_2_type[i] = 1;
                    } else {
                        grass_2_type[i] = 2;
                    }
                }
                i++;
            }
            i = 0;
            while (i != 10) {
                grass_3[i] = i;
                grass_3_type[i] = 0;
                if (game.random.nextInt(4) == 1) {
                    if (game.random.nextInt(6) == 1) {
                        grass_3_type[i] = 1;
                    } else {
                        grass_3_type[i] = 2;
                    }
                }
                i++;
            }
        }
        i = 0;
        while (i != 10) {
            grass_1_scale[i] = 1.0f-(game.random.nextInt(3)*0.08f);
            grass_2_scale[i] = 1.0f-(game.random.nextInt(3)*0.08f);
            grass_3_scale[i] = 1.0f-(game.random.nextInt(3)*0.08f);
            i++;
        }
        health = game.robot.health;
        Ehealth = game.robot.Ehealth;
        if(!online) {
            y = game.random.nextInt(3) + 1;
            Ey = game.random.nextInt(3) + 1;
        }else{
            y = 2;
            Ey = 2;
        }
        background = new Texture("Location/background_" + game.robot.level + ".png");
        floor = new Texture("Location/grass_alpha_" + game.robot.level + ".png");
        open_x = 0;
        front_energy_scale = height * 2;
        batch = new SpriteBatch();
        AddSkins = new Thread() {
            @Override
            public void run() {
                Sleep((game.random.nextInt(180) + 5) * 1000);
                    gift_added = true;
                    gift_x = (game.random.nextInt(7) + 2);
                    gift_y = (game.random.nextInt(3) + 1);
                    gift_size = 10;
                    gift_swap = true;
                    while (gift_size < 150) {
                        gift_size += 2;
                        Sleep(5);
                    }
                    gift_swap = false;
                    int dir_anime = 0;
                    while (!closed && gift_added) {
                        if (dir_anime == 0) {
                            gift_size += 1;
                            if (gift_size > 130) {
                                dir_anime = 1;
                            }
                        } else {
                            gift_size -= 1;
                            if (gift_size < 170) {
                                dir_anime = 0;
                            }
                        }
                        Sleep(15);
                    }

            }
        };
        FireAnime = new Thread() {
            @Override
            public void run() {
                fire_anime=1;
                int dir_anime = 1;
                while (!closed) {
                    if(dir_anime==1){
                        fire_anime+=1;
                        if(fire_anime>=3){
                            dir_anime=0;
                        }
                    }else{
                        fire_anime-=1;
                        if(fire_anime<=1){
                            dir_anime=1;
                        }
                    }
                    Sleep(70);
                }
            }
        };
        PlanetAdd = new Thread() {
            @Override
            public void run() {
                x_planet = 300;
                while (!closed) {
                    x_planet += 1;
                    rotate_planet += 0.1;
                    if (rotate_planet >= 360.0) {
                        rotate_planet = 0.0;
                    }
                    if (x_planet >= width + 1200) {
                        moreboom = true;
                        break;
                    }
                    Sleep(45);
                }
            }
        };
        PressAdd = new Thread() {
            @Override
            public void run() {
                int dir = 0;
                while (!closed) {
                    if (dir == 0) {
                        press_y += 2;
                        if (press_y > 280) {
                            dir = 1;
                            Sleep(1500);
                        }
                    } else {
                        press_y -= 2;
                        if (press_y < -280) {
                            dir = 0;
                            Sleep(1500);
                        }
                    }
                    Sleep(5);
                }
            }
        };
        if(!online) {
            if (game.robot.level == 2) {
                PlanetAdd.start();
            }
            if (game.robot.level == 1) {
                PressAdd.start();
            }
        }
        TimeAdd = new Thread() {
            @Override
            public void run() {
                time = 120;
                type_achivement = 1;
                Sleep(5000);
                while (!closed && time > 0) {
                    if (!pause) {
                        time--;
                        button_font.setColor(255 - time, 75 + time, 75 + time, 75);
                        if (time == 90 || time == 60) {
                            type_achivement = 0;
                        }
                        if (time <= 90) {
                            type_achivement = 2;
                        }
                        if (time <= 60) {
                            type_achivement = 3;
                        }
                    }
                    Sleep((int) (1000 * speed));
                }
            }
        };
        StartLevel = new Thread() {
            @Override
            public void run() {
                openlevel_x = 0;
                Sleep(1500);
                game.music_war.setVolume(0.2f);
                while (openlevel_x < width) {
                    openlevel_x += 5;
                    Sleep(1);
                }
                Sleep(2200);
                while (openlevel_x > -200) {
                    openlevel_x -= 2;
                    Sleep(1);
                }
                openlevel_x = 0;
                pause = false;
            }
        };
        Thread anime = new Thread() {
            @Override
            public void run() {
                while(pause){
                    anime_begin++;
                    if(anime_begin >2){
                        anime_begin=0;
                    }
                    Sleep(100);
                }
            }
        };
        anime.start();
        MedAdd = new Thread() {
            @Override
            public void run() {
                Sleep(7000);
                while (!closed && time > 0) {
                    if (!med_is && !pause) {
                        med_is = true;
                        med_x = (game.random.nextInt(7) + 2);
                        med_y = (game.random.nextInt(3) + 1);
                        med_scale = 0;
                        med_swap = true;
                        med_anime = 0;
                        move[1].play(0.9f);
                        while (med_scale < 150) {
                            med_scale += 2;
                            Sleep(5);
                        }
                        med_swap = false;
                        int med_dir = 1;
                        while (med_is) {
                            if (med_dir == 1) {
                                if (med_anime + 1 < 5) {
                                    med_anime++;
                                    med_scale -= 1;
                                } else {
                                    med_dir = 0;
                                }
                            } else {
                                if (med_anime - 1 > -1) {
                                    med_anime--;
                                    med_scale += 1;
                                } else {
                                    med_dir = 1;
                                }
                            }
                            Sleep(70);
                        }

                    }
                    Sleep((game.random.nextInt(20) + 5) * 1000);
                }
            }
        };
        BoomAdd = new Thread() {
            @Override
            public void run() {
                if (game.robot.level != 1) {
                    Sleep((game.random.nextInt(25) + 13 - type_achivement * 3) * 1000);
                } else {
                    Sleep((game.random.nextInt(5) + 4 - type_achivement) * 1000);
                }
                while (!closed) {
                    if (!pause) {
                        boom_x = game.random.nextInt(7) + 2;
                        boom_y = game.random.nextInt(3) + 1;
                        boom_height = 10;
                        isboom = true;
                        int boom_value = 0;
                        boom.play();
                        while (boom_height < height) {
                            boom_height += 8;
                            Sleep(1);
                        }
                        boom.play();
                        CheckBoom();
                        while (boom_value != 15) {
                            boom_value += 1;
                            boom_anime++;
                            if (boom_anime > 3) {
                                boom_anime = 1;
                            }
                            CheckBoom();
                            Sleep(50);
                        }
                        while (boom_height > 0) {
                            boom_height -= 8;
                            Sleep(1);
                        }
                        robotboom = false;
                        Erobotboom = false;
                        boom_x = 0;
                        boom_y = 0;
                        boom_anime = 1;
                        isboom = false;
                    }
                    if (game.robot.level != 1) {
                        if (!moreboom) {
                            if (time > 0) {
                                Sleep((game.random.nextInt(25) + 13 - type_achivement * 3) * 1000);
                            } else {
                                Sleep((game.random.nextInt(5) + 5) * 1000);
                            }
                        } else {
                            Sleep((game.random.nextInt(2) + 3) * 1000);
                        }
                    } else {
                        Sleep((game.random.nextInt(5) + 4 - type_achivement) * 1000);
                    }
                }
            }
        };
        anime = new Thread() {
            @Override
            public void run() {
                int dir = 2;                                        //Указание направления анимации. Типо реверс.
                int time = game.random.nextInt(10) + 10;
                while (true) {
                    if (game.robot.level != 2 && game.robot.level != 1) {
                        if (grass_dir == 1) {
                            anime_grass += 0.5;
                            if (anime_grass >= 5.0) {
                                grass_dir = 0;
                            }
                        } else {
                            anime_grass -= 0.5;
                            if (anime_grass <= -5.0) {
                                grass_dir = 1;
                            }
                        }
                    }
                    if (dir == 1) {
                        robot_x += 0.1;
                        scale -= 0.0008f;
                        rothead += 0.2f;
                        rothand -= 0.1f;
                        if (rothead >= 3.0f) {
                            dir = 2;
                            time = game.random.nextInt(10) + 10;
                        }
                    } else {
                        robot_x -= 0.1;
                        scale += 0.0008f;
                        rothead -= 0.2f;
                        rothand += 0.1f;
                        if (rothead <= -3.0f) {
                            dir = 1;
                            time = game.random.nextInt(10) + 10;
                        }
                    }
                    if (closed) {
                        break;
                    }
                    if (time > 0) {
                        Sleep((int) (time * speed));
                    } else {
                        Sleep((int) (time / 2 * speed));
                    }
                }
            }
        };
        CrossAdd = new Thread() {
            @Override
            public void run() {
                Sleep((int) (5000 * speed));
                int random;
                while (true) {
                    if (!pause) {
                        random = game.random.nextInt(6 - type_achivement);
                        if (!meteor_run && random == 0) {
                            meteor_run = true;
                            SetMeteor();
                        }
                        if (closed) {
                            break;
                        }
                    }
                    Sleep((int) (1000 * speed));
                }
            }
        };
        AddResize = new Thread() {
            @Override
            public void run() {
                Sleep((game.random.nextInt(90)*1000)+6000);
                resize_y=height;
                resizing = true;
                while (resize_y>0) {
                    resize_y-=2;
                    Sleep(2);
                }
                resizing = false;
                resized=1;
                if(x<3){
                    DamageRobot(game.robot.health/2);
                }
                if(x>8){
                    DamageRobot(game.robot.health/2);
                }
                if(Ex<3){
                    DamageRobot(game.robot.Ehealth/2);
                }
                if(Ex>8){
                    DamageRobot(game.robot.Ehealth/2);
                }
            }
        };
        AddAlert = new Thread() {
            @Override
            public void run() {
                Sleep(4000);
                if(game.robot.level == 1){
                    location_name_1 = "Сборочный";
                    location_name_2 = "Цех";
                    alert_x_plus = 20;
                }
                if(game.robot.level == 2){
                    location_name_1 = "Спутник";
                    location_name_2 = "Планеты";
                    alert_x_plus = 20;
                }
                if(game.robot.level == 3){
                    location_name_1 = "Выжженная";
                    location_name_2 = "Роща";
                    alert_x_plus = 20;
                }
                if(game.robot.level == 4){
                    location_name_1 = "Тёмное";
                    location_name_2 = "Место";
                    alert_x_plus = 20;
                }
                alert_x = 400;
                alert_y = height-200;
                alert_location = true;
                while (alert_x>0) {
                    alert_x-=2;
                    Sleep(5);
                }
                Sleep(2000);
                while (alert_x<400) {
                    alert_x+=2;
                    Sleep(5);
                }
                alert_location = false;
            }
        };
        Eanime = new Thread() {
            @Override
            public void run() {
                int Edir = 2;                                         //Переменные с обозначением "E" в начале принадлежат врагу.
                int Etime = game.random.nextInt(10) + 10;
                while (true) {
                    if (Edir == 1) {
                        Erobot_x += 0.1;
                        Escale -= 0.0008f;
                        Erothead += 0.2f;
                        Erothand -= 0.1f;
                        if (Erothead >= 3.0f) {
                            Edir = 2;
                            Etime = game.random.nextInt(10) + 10;
                        }
                    } else {
                        Erobot_x -= 0.1;
                        Escale += 0.0008f;
                        Erothead -= 0.2f;
                        Erothand += 0.1f;
                        if (Erothead <= -3.0f) {
                            Edir = 1;
                            Etime = game.random.nextInt(10) + 10;
                        }
                    }
                    if (closed) {
                        break;
                    }
                    if (Etime > 0) {
                        Sleep((int) (Etime * speed));
                    } else {
                        Sleep((int) (Etime / 2 * speed));
                    }
                }
            }
        };
        EnergyAdd = new Thread() {
            @Override
            public void run() {
                Sleep((int) (5000 * speed));
                while (true) {
                    if (energy < game.robot.energy) {
                        energy += 1;
                    }
                    if (closed) {
                        break;
                    }
                    if (robot_speed_bonus == 0) {
                        if (time > 0) {
                            Sleep((int) (game.robot.energy_speed * speed));
                        } else {
                            Sleep((int) (game.robot.energy_speed / 2 * speed));
                        }
                    } else {
                        Sleep((int) (40 * speed));
                    }
                }
            }
        };
        EEnergyAdd = new Thread() {
            @Override
            public void run() {
                Sleep((int) (5000 * speed));
                while (true) {
                    if (Eenergy < game.robot.energy) {
                        Eenergy += 1;
                    }
                    if (closed) {
                        break;
                    }
                    if (Erobot_speed_bonus == 0) {
                        if (time > 0) {
                            Sleep((int) (game.robot.Eenergy_speed * speed));
                        } else {
                            Sleep((int) (game.robot.Eenergy_speed / 2 * speed));
                        }
                    } else {
                        Sleep((int) (40 * speed));
                    }
                }
            }
        };
        FireAnime.start();
        EnemyBrine = new Thread() {
            @Override
            public void run() {
                boolean run_away = false;
                int steps_run = 0;
                int steps_to_run = 30;
                Sleep((int) (5000 * speed));
                while (true) {
                    if (!pause) {
                        if(!run_away){
                        int random_act = game.random.nextInt(27) + 1;
                        if (random_act < 11 && random_act > 0) {
                            if (CheckBullet()) {
                                int index = 0;
                                if (bullets > 0) {
                                    while (index < 40) {
                                        if (Math.abs((double) bullets_x[index] - (double) (Ex * width / 10)) < 150) {
                                            EJump();
                                        }
                                        index++;
                                    }
                                }
                                int move_dir = game.random.nextInt(2) - 1;
                                if (Ey - 1 > 0 && move_dir == -1) {
                                    if(Edir == 1) {
                                        if (Ex + 1 != x || Ey - 1 != y || Ex!=8) {
                                            EDown();
                                        }
                                    }else{
                                        if (Ex - 1 != x || Ey - 1 != y || Ex!=2) {
                                            EDown();
                                        }
                                    }
                                }
                                if (Ey + 1 < 4 && move_dir == 0) {
                                    if(Edir == 1) {
                                        if (Ex + 1 != x || Ey + 1 != y || Ex!=8) {
                                            EUp();
                                        }
                                    }else{
                                        if (Ex - 1 != x || Ey + 1 != y || Ex!=2) {
                                            EUp();
                                        }
                                    }
                                }
                            }
                        }
                        if (random_act < 13 && random_act > 10) {
                            if (Math.abs((Ex * width / 10 + Erobot_x) - (x * width / 10 + robot_x)) > 75 && ((Edir == -1 && (Ex * width / 10 + Erobot_x) < (x * width / 10 + robot_x)) || (Edir == 1 && (Ex * width / 10 + Erobot_x) > (x * width / 10 + robot_x)))) {
                                ERedir();
                            }
                        }
                        if (random_act < 16 && random_act > 13) {
                            int move_dir = game.random.nextInt(2) - 1;
                            if (Ey - 1 > 0 && move_dir == -1) {
                                if(Edir == 1) {
                                    if (Ex + 1 != x || Ey - 1 != y || Ex!=8) {
                                        EDown();
                                    }
                                }else{
                                    if (Ex - 1 != x || Ey - 1 != y || Ex!=2) {
                                        EDown();
                                    }
                                }
                            }
                            if (Ey + 1 < 4 && move_dir == 0) {
                                if(Edir == 1) {
                                    if (Ex + 1 != x || Ey + 1 != y || Ex!=8) {
                                        EUp();
                                    }
                                }else{
                                    if (Ex - 1 != x || Ey + 1 != y || Ex!=2) {
                                        EUp();
                                    }
                                }
                            }
                        }
                        if (random_act < 19 && random_act > 16) {
                            int move_dir = game.random.nextInt(10) + 1;
                            if (move_dir == 3) {
                                ERedir();
                            }
                            if (move_dir < 3) {
                                EFire();
                            }
                            if (move_dir == 10) {
                                EJump();
                            }
                        }
                        if (random_act > 20 && random_act < 27) {
                            if (Ey == y && ((Edir == -1 && (Ex * width / 10 + Erobot_x) > (x * width / 10 + robot_x)) || (Edir == 1 && (Ex * width / 10 + Erobot_x) < (x * width / 10 + robot_x)))) {
                                EFire();
                            }
                        }
                        if (random_act == 20) {
                            if (Math.abs((((double) Ex * (double) width / (double) 10) + Erobot_x) - (((double) x * (double) width / (double) 10) + robot_x)) <= 250.0) {
                                int move_dir = game.random.nextInt(3) + 1;
                                if (move_dir == 3) {
                                    if (Eenergy >= 50) {
                                        EJump();
                                    }
                                }
                            }
                        }
                        if (random_act == 27) {
                            if ((x > Ex && Edir == 1) || (x < Ex && Edir == -1)) {
                                EBall();
                            }
                        }
                        int distance = Math.abs(Ex - x) + Math.abs(Ey - y);
                        if (distance <= 1) {
                            steps_run++;
                            if (steps_run >= steps_to_run) {
                                run_away = true;
                            }
                        } else {
                            if(steps_run > 0) {
                                steps_run--;
                            }
                        }
                    }else{
                            steps_run-=2;
                            if(steps_run <=0){
                                steps_run = 0;
                                run_away = false;
                            }
                                if (!(Math.abs((Ex * width / 10 + Erobot_x) - (x * width / 10 + robot_x)) > 75 && ((Edir == -1 && (Ex * width / 10 + Erobot_x) < (x * width / 10 + robot_x)) || (Edir == 1 && (Ex * width / 10 + Erobot_x) > (x * width / 10 + robot_x))))) {
                                    ERedir();
                                }
                                if(CheckBullet()){
                                    int random_act = game.random.nextInt(2) + 1;
                                    if(random_act == 1 && Ey - 1 > 0){
                                        if(Edir == 1) {
                                            if (Ex + 1 != x || Ey - 1 != y || Ex!=8) {
                                                EDown();
                                            }
                                        }else{
                                            if (Ex - 1 != x || Ey - 1 != y || Ex!=2) {
                                                EDown();
                                            }
                                        }
                                    }
                                    if(random_act == 2 && Ey + 1 < 4){
                                        if(Edir == 1) {
                                            if (Ex + 1 != x || Ey + 1 != y || Ex!=8) {
                                                EUp();
                                            }
                                        }else{
                                            if (Ex - 1 != x && Ey + 1 != y && Ex!=2) {
                                                EUp();
                                            }
                                        }
                                    }
                                }
                            int random_act = game.random.nextInt(5) + 1;
                                if(random_act == 1 && Ey - 1 > 0){
                                    if(Edir == 1) {
                                        if (Ex + 1 != x || Ey - 1 != y || Ex!=8) {
                                            EDown();
                                        }
                                    }else{
                                        if (Ex - 1 != x || Ey - 1 != y || Ex!=2) {
                                            EDown();
                                        }
                                    }
                                }
                                if(random_act == 2 && Ey + 1 < 4){
                                    if(Edir == 1) {
                                        if (Ex + 1 != x || Ey + 1 != y || Ex!=8) {
                                            EUp();
                                        }
                                    }else{
                                        if (Ex - 1 != x || Ey + 1 != y || Ex!=2) {
                                            EUp();
                                        }
                                    }
                                }
                                if(random_act == 3){
                                    EJump();
                                }
                                if(random_act == 4){
                                   EBall();
                                }
                                if(random_act == 5){
                                   EFire();
                                 }
                        }
                        if (closed) {
                            break;
                        }
                        Sleep((int) (50 * speed));
                    }
                }
            }
        };

        drawer = new SpriteBatchRubber(this, batch);
        if(online) {
            PacketSet = new Thread() {
                @Override
                public void run() {
                    while (!closed) {
                        if(EturnedBall < MEturnedBall){
                            if(!Eball_clicked){
                                EBall();
                                EturnedBall+=1;
                            }
                        }
                        if(EturnedDown < MEturnedDown){
                            if(!Edown_clicked){
                                EDown();
                                EturnedDown+=1;
                            }
                        }
                        if(EturnedUp < MEturnedUp){
                            if(!Eup_clicked){
                                EUp();
                                EturnedUp+=1;
                            }
                        }
                        if(EturnedFire < MEturnedFire){
                            if(!Efire_clicked){
                                EFire();
                                EturnedFire+=1;
                            }
                        }
                        if(EturnedRedir < MEturnedRedir){
                            if(!Eredir_clicked){
                                ERedir();
                                EturnedRedir+=1;
                            }
                        }
                        if(EturnedJump < MEturnedJump){
                            if(!Ejump_clicked){
                                EJump();
                                EturnedJump+=1;
                            }
                        }
                        Sleep(100);
                    }
                }
            };
            PacketSet.start();
            while (!connected && connect_try < 30) {
                Sleep(500);
                connect_try += 1;
            }
            if (connected) {
                if (game.robot.max_skin > game.robot.opened) {
                    AddSkins.start();
                }
                AddAlert.start();
                TimeAdd.start();
                BoomAdd.start();
                MedAdd.start();
                StartLevel.start();
                CrossAdd.start();
                EnergyAdd.start();
                EEnergyAdd.start();
                anime.start();
                Eanime.start();
                DoorOpen();
            }else{
                if(host){
                        server.stop();
                }else{
                        client.stop();
                }
                closed = true;
                type_close=2;
            }
        }else{
            if (game.robot.max_skin > game.robot.opened) {
                AddSkins.start();
            }

            AddAlert.start();
            TimeAdd.start();
            BoomAdd.start();
            MedAdd.start();
            StartLevel.start();
            CrossAdd.start();
            EnemyBrine.start();
            EnergyAdd.start();
            EEnergyAdd.start();
            anime.start();
            Eanime.start();
            DoorOpen();
        }
    }
    public void OnlineChanges() {
        game.robot.ERHt.dispose();
        game.robot.ELHt.dispose();
        game.robot.ERLt.dispose();
        game.robot.ELLt.dispose();
        game.robot.EHt.dispose();
        game.robot.EBt.dispose();
        game.robot.ERHt = new Texture("Robot/hand_" + game.robot.ERHid + ".png");
        game.robot.ELHt = new Texture("Robot/hand_" + game.robot.ELHid + ".png");
        game.robot.ERLt = new Texture("Robot/leg_" + game.robot.ERLid + ".png");
        game.robot.ELLt = new Texture("Robot/leg_" + game.robot.ELLid + ".png");
        game.robot.EHt = new Texture("Robot/head_" + game.robot.EHid + ".png");
        game.robot.EBt = new Texture("Robot/body_" + game.robot.EBid + ".png");
        game.robot.ERH = new TextureRegion(game.robot.ERHt, 300, 300);
        game.robot.ELH = new TextureRegion(game.robot.ELHt, 300, 300);
        game.robot.ERL = new TextureRegion(game.robot.ERLt, 300, 300);
        game.robot.ELL = new TextureRegion(game.robot.ELLt, 300, 300);
        game.robot.EH = new TextureRegion(game.robot.EHt, 300, 300);
        game.robot.EB = new TextureRegion(game.robot.EBt, 300, 300);
        game.robot.EUpdateSkin();
        game.robot.UpdateParameters();
        if(!host){
        booms[0].dispose();
        booms[1].dispose();
        booms[2].dispose();
        Rocket.dispose();
        Splash.dispose();
        grass.dispose();
        Meteort.dispose();
        background.dispose();
        floor.dispose();
        if (game.robot.level != 2) {
            booms[0] = new Texture("Object/energy_1.png");
            booms[1] = new Texture("Object/energy_2.png");
            booms[2] = new Texture("Object/energy_3.png");
        } else {
            booms[0] = new Texture("Object/energy_1_2.png");
            booms[1] = new Texture("Object/energy_2_2.png");
            booms[2] = new Texture("Object/energy_3_2.png");
        }
        if (game.robot.level == 2) {
            planett = new Texture("Object/planet_3.png");
            planet = new TextureRegion(planett, 400, 400);
            FrontLevel2 = new Texture("Location/background_2_front.png");
        }
        if (game.robot.level != 1) {
            Rocket = new Texture("Object/rocket.png");
        } else {
            Rocket = new Texture("Object/rocket_2.png");
        }
        if (game.robot.level != 2 && game.robot.level != 1) {
            Splash = new Texture("Object/splash.png");
        } else {
            if (game.robot.level == 2) {
                local_speed = 2;
                Splash = new Texture("Object/splash_2.png");
            } else {
                Splash = new Texture("Object/splash_3.png");
            }
        }
        grass = new Texture("Location/grass_" + game.robot.level + ".png");
        Meteort = new Texture("Location/meteor_" + game.robot.level + ".png");
        Meteor = new TextureRegion(Meteort, 300, 300);
        background = new Texture("Location/background_" + game.robot.level + ".png");
        floor = new Texture("Location/grass_alpha_" + game.robot.level + ".png");

        if (game.robot.level == 2) {
            PlanetAdd.start();
        }
        if (game.robot.level == 1) {
            PressAdd.start();
        }
    }
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        if(game.robot.level == 2){
            drawer.draw(background, (int)x_planet-width, 0, width, height);
            drawer.draw(background, (int)x_planet-width*2, 0, width, height);
            drawer.draw(background, (int)x_planet, 0, width, height);
            drawer.draw(FrontLevel2, (int)(x_planet*1.15)-width, 0, width, height);
            drawer.draw(FrontLevel2, (int)(x_planet*1.30), 0, width, height);
            drawer.draw(planet, (float) (width+100-x_planet), height-500, (float) (300), (float) (300), (float) (600), (float) (600), 1, 1,  (float)rotate_planet, true);
        }else {
            if (game.robot.level == 4) {
                drawer.draw(background, 0, (int) anime_grass / 3, width, height);
                drawer.draw(FrontLevel2, 0, (int) -anime_grass / 3, width, height);
            } else {
                if (game.robot.level != 1) {
                    drawer.draw(background, 0, 0, width, height);
                } else {
                    drawer.draw(background, 0, 0, width, height);
                    drawer.draw(UpPress, 100, height-press_y, 300, 300);
                    drawer.draw(UpPress, width-400, height-press_y, 300, 300);
                    drawer.draw(UpPress, width/2-150, height+press_y, 300, 300);
                    drawer.draw(DownPress, 100, press_y, 300, 300);
                    drawer.draw(DownPress, width-400, press_y, 300, 300);
                    drawer.draw(DownPress, width/2-150, -press_y, 300, 300);
                }
            }
        }
        drawer.draw(game.robot.contrast, 0, 0, width, height);
        int i = 0;
        while(i!=10) {
            if (grass_3_type[i] != 0) {
                if (grass_3_type[i] != 1) {
                    drawer.draw(grass, grass_3[i] * (width / 10), (height / 5) * 3 - 70 - 15 * 3, 150*grass_3_scale[i], (int) (150*grass_3_scale[i] + anime_grass));
                } else {
                    drawer.draw(big_grass, grass_3[i] * (width / 10) - 25, (height / 5) * 3 - 90 - 15 * 3, 200*grass_3_scale[i], (int) (200*grass_3_scale[i] + anime_grass));
                }
            }
            i++;
        }
        i = 0;
        while(i!=10) {
            if (fire_x_3[i] == 1) {
                drawer.draw(fire_location[fire_anime-1], i * (width / 10) + ((width/10)-fire_state_3[i])/2, (height / 5) * 3 - 80 - 15 * 3, fire_state_3[i], fire_state_3[i]);
            }
            i++;
        }
        if(will_meteor_y == 3 && meteor_run){
            if(!meteor_splash) {
                if(!meteor_rocket) {
                    if(game.robot.level != 2 && game.robot.level != 1) {
                        drawer.draw(Fire, meteor_x - 12, meteor_y, 175.0f, 200.0f + (meteor_rot) / 4);
                    }
                    drawer.draw(Meteor, meteor_x, meteor_y, 75.0f, 75.0f, 150.0f, 150.0f, 1, 1, meteor_rot);
                }else{
                    if(game.robot.level != 2 && game.robot.level != 1) {
                        drawer.draw(Fire, meteor_x - 12, meteor_y, 175.0f, 200.0f + (meteor_rot) / 4);
                    }
                    drawer.draw(Rocket, meteor_x-50, meteor_y-80, 250, 250);
                }
            }else{
                drawer.draw(Splash, meteor_x-meteor_splash_size/2, meteor_y, 150+meteor_splash_size, 150+meteor_splash_size);
            }
        }
        if(gift_added && gift_y == 3){
            if(!gift_swap) {
                drawer.draw(puck, gift_x * (width / 10) - gift_size / 2 + 70, gift_y * (height / 5) - 70 - 10 * gift_y, gift_size, gift_size);
            }else{
                drawer.draw(puck_swap, gift_x * (width / 10) - gift_size / 2 + 70, gift_y * (height / 5) - 70 - 10 * gift_y, gift_size, gift_size);
            }
        }
        if(meteor_run && will_meteor_y == 3) {
            drawer.draw(game.robot.Cross, meteor_x + (150-cross_size)/2, will_meteor_y * (height / 5) - 60 - 10 * will_meteor_y, cross_size, cross_size);
        }
        drawer.draw(floor, 0, height/5*2-80, width, height/5);
        if(med_is && med_y == 3){
            if(!med_swap && !med_used) {
                drawer.draw(med[med_anime], med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60-10*med_y, med_scale, med_scale);
            }else{
                if(med_used) {
                    drawer.draw(Bluefire, med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60 - 10 * med_y, med_scale, med_scale);
                }else{
                    drawer.draw(MedSwap, med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60 - 10 * med_y, med_scale, med_scale);
                }
            }
        }
        i = 0;
        while(i!=10) {
            if (grass_2_type[i] != 0) {
                if (grass_2_type[i] != 1) {
                    drawer.draw(grass, grass_2[i] * (width / 10), (height / 5) * 2 - 70 - 15 * 2, 150*grass_2_scale[i], (int) (150*grass_2_scale[i] + anime_grass));
                } else {
                    drawer.draw(big_grass, grass_2[i] * (width / 10) - 25, (height / 5) * 2 - 90 - 15 * 2, 200*grass_2_scale[i], (int) (200*grass_2_scale[i] + anime_grass));
                }
            }
            i++;
        }
        i = 0;
        while(i!=10) {
            if (fire_x_2[i] == 1) {
                drawer.draw(fire_location[fire_anime-1], i * (width / 10) + ((width/10)-fire_state_2[i])/2, (height / 5) * 2 - 80 - 20 * 2, fire_state_2[i], fire_state_2[i]);
            }
            i++;
        }
        if(will_meteor_y == 2 && meteor_run){
            if(!meteor_splash) {
                if(!meteor_rocket) {
                    if(game.robot.level != 2 && game.robot.level != 1) {
                        drawer.draw(Fire, meteor_x - 12, meteor_y, 175.0f, 200.0f + (meteor_rot) / 4);
                    }
                    drawer.draw(Meteor, meteor_x, meteor_y, 75.0f, 75.0f, 150.0f, 150.0f, 1, 1, meteor_rot);
                }else{
                    if(game.robot.level != 2 && game.robot.level != 1) {
                        drawer.draw(Fire, meteor_x - 12, meteor_y, 175.0f, 200.0f + (meteor_rot) / 4);
                    }
                    drawer.draw(Rocket, meteor_x-50, meteor_y-80, 250, 250);

                }
            }else{
                drawer.draw(Splash, meteor_x-meteor_splash_size/2, meteor_y, 150+meteor_splash_size, 150+meteor_splash_size);
            }
        }
        if(gift_added && gift_y == 2){
            if(!gift_swap) {
                drawer.draw(puck, gift_x * (width / 10) - gift_size / 2 + 70, gift_y * (height / 5) - 70 - 10 * gift_y, gift_size, gift_size);
            }else{
                drawer.draw(puck_swap, gift_x * (width / 10) - gift_size / 2 + 70, gift_y * (height / 5) - 70 - 10 * gift_y, gift_size, gift_size);
            }
        }
        drawer.draw(floor, 0, height/5-70, width, height/5);
        if(med_is && med_y == 2){
            if(!med_swap &&  !med_used) {
                drawer.draw(med[med_anime], med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60-10*med_y, med_scale, med_scale);
            }else{
                if(med_used) {
                    drawer.draw(Bluefire, med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60 - 10 * med_y, med_scale, med_scale);
                }else{
                    drawer.draw(MedSwap, med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60 - 10 * med_y, med_scale, med_scale);
                }
            }
        }
        if(meteor_run && will_meteor_y == 2) {
            drawer.draw(game.robot.Cross, meteor_x + (150-cross_size)/2, will_meteor_y * (height / 5) - 60 - 10 * will_meteor_y, cross_size, cross_size);
        }
        i = 0;
        while(i!=10){
            if(grass_1_type[i]!=0) {
                if (grass_1_type[i] != 1) {
                    drawer.draw(grass, grass_1[i] * (width / 10), (height / 5) - 70 - 15, 150*grass_1_scale[i], (int) (150*grass_1_scale[i] + anime_grass));
                } else {
                    drawer.draw(big_grass, grass_1[i] * (width / 10) - 25, (height / 5) - 90 - 15, 200*grass_1_scale[i], (int) (200*grass_1_scale[i] + anime_grass));
                }
            }
            i++;
        }
        i = 0;
        while(i!=10) {
            if (fire_x_1[i] == 1) {
                drawer.draw(fire_location[fire_anime-1], i * (width / 10) + ((width/10)-fire_state_1[i])/2, (height / 5)  - 80 - 30 , fire_state_1[i], fire_state_1[i]);
            }
            i++;
        }
        if(will_meteor_y == 1 && meteor_run){
            if(!meteor_splash) {
                if(!meteor_rocket) {
                    if(game.robot.level != 2 && game.robot.level != 1) {
                        drawer.draw(Fire, meteor_x - 12, meteor_y, 175.0f, 200.0f + (meteor_rot) / 4);
                    }
                        drawer.draw(Meteor, meteor_x, meteor_y, 75.0f, 75.0f, 150.0f, 150.0f, 1, 1, meteor_rot);
                }else{
                    if(game.robot.level != 2 && game.robot.level != 1) {
                        drawer.draw(Fire, meteor_x - 12, meteor_y, 175.0f, 200.0f + (meteor_rot) / 4);
                    }
                        drawer.draw(Rocket, meteor_x - 50, meteor_y - 80, 250, 250);
                }
            }else{
                drawer.draw(Splash, meteor_x-meteor_splash_size/2, meteor_y, 150+meteor_splash_size, 150+meteor_splash_size);
            }
        }
        if(gift_added && gift_y == 1){
            if(!gift_swap) {
                drawer.draw(puck, gift_x * (width / 10) - gift_size / 2 + 70, gift_y * (height / 5) - 70 - 10 * gift_y, gift_size, gift_size);
            }else{
                drawer.draw(puck_swap, gift_x * (width / 10) - gift_size / 2 + 70, gift_y * (height / 5) - 70 - 10 * gift_y, gift_size, gift_size);
            }
        }
        drawer.draw(floor, 0, -60, width, height/5);
        if(med_is && med_y == 1){
            if(!med_swap &&  !med_used) {
                drawer.draw(med[med_anime], med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60-10*med_y, med_scale, med_scale);
            }else{
                if(med_used) {
                    drawer.draw(Bluefire, med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60 - 10 * med_y, med_scale, med_scale);
                }else{
                    drawer.draw(MedSwap, med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60 - 10 * med_y, med_scale, med_scale);
                }
            }
        }
        if(meteor_run && will_meteor_y == 1) {
            drawer.draw(game.robot.Cross, meteor_x + (150-cross_size)/2, will_meteor_y * (height / 5) - 60 - 10 * will_meteor_y, cross_size, cross_size);
        }
        int index = 0;
        if(bullets>0) {
            while (index < 40) {
                if (bullets_dir[index] != 0 && Math.floor(bullets_y[index]) == 3.0) {
                    DrawBullet(drawer, (bullets_x[index] + 135 * bullets_dir[index]), (int)((height/5)*bullets_y[index]-15*bullets_y[index]+190), bullets_type[index]);
                }
                index++;
            }
        }
        if(Ey == 3) {
            if(Eball_state<0.4f) {
                DrawEnergyCircle(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eenergy_circle_size, Erobot_circle);
            }
            if (!Eball_clicked) {
                    if (!Erobotboom) {
                        DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                    } else {

                        DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x - boom_anime * 10, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y - boom_anime * 10, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                    }
                } else {
                    DrawEnemyBall(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eball_state);
                }
            }


        if(y == 3) {
            if(ball_state<0.4f) {
                DrawEnergyCircle(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, energy_circle_size, robot_circle);
            }
            if (!jetpack_clicked) {
                if (!ball_clicked) {
                    if (!robotboom) {
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    } else {
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x - boom_anime * 10, (height / 5) * y - 60 - 10 * y + (int) robot_y - boom_anime * 10, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    }
                } else {
                    DrawRobotBall(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, ball_state);
                }
            }else{
                if(!dead){
                    DrawRobotJetpack(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, 0, 0, fire_anime, jetpack_state, swap, hurt);
                }else{
                    DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                }
            }
        }
        index = 0;
        if(bullets>0) {
            while (index < 40) {
                if (bullets_dir[index] != 0 && Math.floor(bullets_y[index]) == 2.0) {
                    DrawBullet(drawer, (bullets_x[index] + 135  * bullets_dir[index]), (int)((height/5)*bullets_y[index]-15*bullets_y[index]+190), bullets_type[index]);
                }
                index++;
            }
        }
        if(Ey == 2){
            if(Eball_state<0.4f) {
                DrawEnergyCircle(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eenergy_circle_size, Erobot_circle);
            }
            if(!Eball_clicked) {
                if (!Erobotboom) {
                    DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                } else {

                    DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x - boom_anime * 10, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y - boom_anime * 10, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                }
            }else{
                DrawEnemyBall(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eball_state);
            }
        }
        if(y == 2) {
            if(ball_state<0.4f) {
                DrawEnergyCircle(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, energy_circle_size, robot_circle);
            }
                if (!jetpack_clicked) {
                if (!ball_clicked) {
                    if (!robotboom) {
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    } else {

                        DrawRobot(drawer, x * (width / 10) + (int) robot_x - boom_anime * 10, (height / 5) * y - 60 - 10 * y + (int) robot_y - boom_anime * 10, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    }
                } else {
                    DrawRobotBall(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, ball_state);
                }
            }else {
                    if (!dead) {
                        DrawRobotJetpack(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, 0, 0, fire_anime, jetpack_state, swap, hurt);
                    }else{
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    }
                }
        }
        index = 0;
        if(bullets>0) {
            while (index < 40) {
                if (bullets_dir[index] != 0 && Math.floor(bullets_y[index]) == 1.0) {
                    DrawBullet(drawer, (bullets_x[index] + 135 * bullets_dir[index]), (int)((height/5)*bullets_y[index]-15*bullets_y[index]+190), bullets_type[index]);
                }
                index++;
            }
        }
        if(Ey == 1) {
            if(Eball_state<0.4f) {
                DrawEnergyCircle(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eenergy_circle_size, Erobot_circle);
            }
            if (!Eball_clicked) {
                if (!Erobotboom) {
                    DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                } else {

                    DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x - boom_anime * 10, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y - boom_anime * 10, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                }
            } else {
                DrawEnemyBall(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eball_state);
            }
        }
        if(y == 1) {
            if(ball_state<0.4f) {
                DrawEnergyCircle(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, energy_circle_size, robot_circle);
            }
            if (!jetpack_clicked) {
                if (!ball_clicked) {
                    if (!robotboom) {
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    } else {
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x - boom_anime * 10, (height / 5) * y - 60 - 10 * y + (int) robot_y - boom_anime * 10, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    }
                } else {
                    DrawRobotBall(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, ball_state);
                }
            }else{
                if(!dead){
                    DrawRobotJetpack(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, 0, 0, fire_anime, jetpack_state, swap, hurt);
                }else{
                    DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                }
            }
        }
        if(dead){
            DrawRobotDead(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y - boom_anime*10, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, 0, dead_state);
        }
        if(Edead){
            DrawEnemyDead(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y - boom_anime*10, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, 0, Edead_state);
        }
        if(isboom){
            drawer.draw(booms[boom_anime-1], boom_x*(width/10)-250,  (height/5)*boom_y-60-10*boom_y+(height-boom_height), 500, boom_height);
        }
        if(resized>0 || resizing){
            if(game.robot.level==4) {
                drawer.draw(resize, -height/2, resize_y, 810, height);
                drawer.draw(resize_2, width-height/2, resize_y, 810, height);
            }else{
                drawer.draw(resize, -height/2, resize_y, 810, height);
                drawer.draw(resize, width-height/2, resize_y, 810, height);
            }
        }
        DrawEnemyIcon(drawer, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale, Ehealth);
        DrawRobotIcon(drawer, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale, health);
        if(robot_speed_bonus > 0){
            drawer.draw(Front_energy, -(front_energy_scale)/2, (-front_energy_scale)/2, width+front_energy_scale, height+front_energy_scale);
        }
        if(fire_touch) {                //Так как eval из JavaScript в Java не присутствует, и даже его более или менее адекватной замены я не встретил, приходится 7овнокодить...
            drawer.draw(fire_touched, (int) (width - 275 * scale_inteface), -pos_interface, (int) (250 * scale_inteface), (int) (250 * scale_inteface));
        }else{
            drawer.draw(fire, (int) (width - 275 * scale_inteface), -pos_interface, (int) (250 * scale_inteface), (int) (250 * scale_inteface));
        }
        if(dir == 1) {
            if (up_touch) {
                drawer.draw(up_2_touched, (int) (50 * scale_inteface), (int) (125 * scale_inteface - pos_interface), (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            }else{
                drawer.draw(up_2, (int) (50 * scale_inteface), (int) (125 * scale_inteface - pos_interface), (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            }
            if(down_touch) {
                drawer.draw(down_2_touched, (int) (50 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            } else {
                drawer.draw(down_2, (int) (50 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            }
        }else{
            if (up_touch) {
                drawer.draw(up_1_touched, (int) (50 * scale_inteface), (int) (125 * scale_inteface - pos_interface), (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            } else {
                drawer.draw(up_1, (int) (50 * scale_inteface), (int) (125 * scale_inteface - pos_interface), (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            }
            if (down_touch) {
                drawer.draw(down_1_touched, (int) (50 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            } else {
                drawer.draw(down_1, (int) (50 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            }

        }
        if(redir_touch) {
            drawer.draw(redir_touched, (int)(200*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }else{
            drawer.draw(redir, (int)(200*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }
        if(ball_clicked) {
            drawer.draw(ball_touched, (int)(width-400*scale_inteface), -pos_interface+150, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }else{
            if(ball_can) {
                drawer.draw(ball, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            }else{
                drawer.draw(ball_cant, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            }
        }
        if(jump_touch) {
            drawer.draw(jump_touched, (int)(width-400*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }else{
            drawer.draw(jump, (int)(width-400*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }
        if(jetpack_touch) {
            drawer.draw(jetpack_touched, (int)(width-600*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }else{
            drawer.draw(jetpack, (int)(width-600*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }
        DrawEnergy(drawer, (int)(400*(scale_inteface-0.1)), (int)(-50*(scale_inteface-0.1))-pos_interface, 1.3f*(scale_inteface-0.1f), energy, warning);
        if(time > 0) {
            button_font.draw(batch, time + "", (int) (700.0 * wpw * scale_inteface), (int) ((85.0-(double)pos_interface) * hph * scale_inteface));
        }else{
            button_font.draw(batch, "ХАРД", (int) ((680.0-(double)pos_interface) * wpw * scale_inteface), (int) ((85.0-(double)pos_interface) * hph * scale_inteface));
        }
        //drawer.draw(achivement[type_achivement], , height-100, (int)(100*scale_inteface), (int)(100*scale_inteface));
        if(win != 0){
            drawer.draw(Darkeffect, 0, 0, width, height);
            drawer.draw(Effect, (float) (width/2.0-(double)win_scale/2.0), (float) (height/2.0-(double)win_scale/2.0), (float)win_scale/2.0f, (float)win_scale/2.0f, (float)win_scale, (float)win_scale, 1, 1, win_rot);
            if(win_type == 1) {
                drawer.draw(chip,  width/2-(int)((double)win_scale*0.70)/2, height/2-(int)((double)win_scale*0.70)/2, (int)((double)win_scale*0.70), (int)((double)win_scale*0.70));
            }
            if(win_type == 2) {
                drawer.draw(bulb,  width/2-(int)((double)win_scale*0.70)/2, height/2-(int)((double)win_scale*0.70)/2, (int)((double)win_scale*0.70), (int)((double)win_scale*0.70));
            }
            if(win_type == 3) {
                drawer.draw(metall,  width/2-(int)((double)win_scale*0.70)/2, height/2-(int)((double)win_scale*0.70)/2, (int)((double)win_scale*0.70), (int)((double)win_scale*0.70));
            }
            if(win_type == 4) {
                drawer.draw(gear,   width/2-(int)((double)win_scale*0.70)/2, height/2-(int)((double)win_scale*0.70)/2, (int)((double)win_scale*0.70), (int)((double)win_scale*0.70));
            }

            drawer.draw(level_back, -140+show_exp_x+30, 150, 300, 80);
            drawer.draw(level_line, -140+show_exp_x+30, 150, (int)(((double)game.robot.experience/((double)game.robot.level_win*100.0))*300.0), 80);
            drawer.draw(level_front, -140+show_exp_x+30, 150, 300, 80);
            drawer.draw(level_circle, -230+show_exp_x+30, 130, 120, 120);
            level_big_font.draw(batch, Integer.toString(game.robot.level_win), (int)((-200.0+show_exp_x+30)*wpw), (int)((215)*hph));
            level_font.draw(batch, game.robot.experience + " / " + game.robot.level_win*100, (int)((-110.0+show_exp_x+30)*wpw), (int)((205)*hph));



            resource_font.draw(batch, win_num + "", (int)(((double)width/2.0-50)*wpw), (int)(((double)win_y-160.0)*hph));
            resource_font.draw(batch, "ХЛАМ", (int)(((double)width/2.0-200)*wpw), (int)(((double)height-(double)win_y+260.0)*hph));
        }
        drawer.draw(Frontground, 0, 0, width, height);
        if(pause){
            drawer.draw(begin_left[anime_begin], openlevel_x-width-10, 0, width, height);
            drawer.draw(begin_right[anime_begin], width-openlevel_x+10, 0, width, height);
            DrawRobot(drawer, openlevel_x-width-(width-openlevel_x)/2-100, -450, scale * 3.0f, rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
            DrawEnemy(drawer, width-openlevel_x+1300+(width-openlevel_x)/2, -450, Escale * 3.0f, Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
            item_font.draw(batch, game.robot.level_win + " УРОВЕНЬ", (int)((width/2.0-400.0)*wpw), (int)(((double)height/(double)width*(double)openlevel_x/2.0-250)*hph));
        }
        if(alert_location){
            DrawAlert(drawer, alert_x, alert_y, location_name_1, location_name_2, alert_x_plus);
        }
        if(EneedGift){
            EneedGift = false;
            game.robot.EUpdateSkin();
        }
        if(needGift){
            needGift = false;
            game.robot.UpdateSkin();
        }

        CheckClose(drawer);
        CheckOpen(drawer);
        batch.end();
        if(closed){
            if(online){
                if(host){
                    server.stop();
                }else{
                    client.stop();
                }
                closed = true;
                type_close=2;
            }
            if(type_close == 1) {
                game.setGameMenu();
            }
            if(type_close == 2) {
                game.setMultiplayerMenu();
            }
        }
        if(needOnlineChanges){
            needOnlineChanges = false;
            OnlineChanges();
        }
        if(end && !ending){
            ending = true;
            DoorClose(1);
        }
    }
    public void TakeSkin(){
        if(x == gift_x && y == gift_y && gift_added && !gift_swap){
            gift_added = false;
            boom.play();
            game.robot.skin = gift_index;
            game.robot.AddSkin(gift_index);
            needGift = true;
        }
    }
    public void ETakeSkin(){
        if(Ex == gift_x && Ey == gift_y && gift_added && !gift_swap){
            gift_added = false;
            boom.play();
            game.robot.Eskin = gift_index;
            EneedGift = true;
        }
    }
    public void SetFire(int x, int y){
        int broke_plus = 1;
        boolean grass_fired = false;
        if(y == 1 && fire_x_1[ x ] == 0 && fire_state_1[ x ] == 0){
            fire_x_1[ x ] = 1;
            fire_state_1[ x ] = 1;
            if(grass_1_type[ x-1 ] != 0){
                grass_fired = true;
            }
            while(fire_state_1[ x ]<width/10*1.5f){
                if(fire_x_1[ x ] == 0){
                    broke_plus = 3;
                }
                if(grass_fired){
                    grass_1_scale[ x ]-=0.01f;
                }
                fire_state_1[ x ]+=1+broke_plus;
                if(this.x==x && this.y==y && !jetpack_flying && fire_x_1[ x ] != 0){
                    DamageRobot(game.robot.fire_damage);
                }
                if(this.Ex==x && this.Ey==y && !Ejetpack_flying && fire_x_1[ x ] != 0){
                    DamageEnemy(game.robot.fire_damage);
                }
                Sleep(10);
            }
            while(fire_state_1[ x ]>1){
                if(fire_x_1[ x ] == 0){
                    broke_plus = 3;
                }
                if(grass_fired){
                    grass_1_scale[ x ]-=0.05f;
                }
                fire_state_1[ x ]-=broke_plus;
                if(this.x==x && this.y==y  && !jetpack_flying && fire_x_1[ x ] != 0){
                    DamageRobot(game.robot.fire_damage);
                }
                if(this.Ex==x && this.Ey==y && !Ejetpack_flying && fire_x_1[ x ] != 0){
                    DamageEnemy(game.robot.fire_damage);
                }
                Sleep(10);
            }
            if(grass_fired && grass_1_scale[ x-1 ] <= 0.1f){
                grass_1_type[ x-1 ] = 0;
            }
            fire_x_1[ x ] = 0;
            fire_state_1[ x ] = 0;
        }
        if(y == 2 && fire_x_2[ x ] == 0 && fire_state_2[ x ] == 0){
            fire_x_2[ x ] = 1;
            fire_state_2[ x ] = 1;
            if(grass_2_type[ x-1 ] != 0){
                grass_fired = true;
            }
            while(fire_state_2[ x ]<width/10*1.5f){
                if(fire_x_2[ x ] == 0){
                    broke_plus = 3;
                }
                if(grass_fired){
                    grass_2_scale[ x ]-=0.01f;
                }
                fire_state_2[ x ]+=1+broke_plus;
                if(this.x==x && this.y==y && !jetpack_flying && fire_x_2[ x ] != 0){
                    DamageRobot(game.robot.fire_damage);
                }
                if(this.Ex==x && this.Ey==y && !Ejetpack_flying && fire_x_2[ x ] != 0){
                    DamageEnemy(game.robot.fire_damage);
                }
                Sleep(10);
            }
            while(fire_state_2[ x ]>1){
                if(fire_x_2[ x ] == 0){
                    broke_plus = 3;
                }
                if(grass_fired){
                    grass_1_scale[ x ]-=0.05f;
                }
                fire_state_2[ x ]-=broke_plus;
                if(this.x==x && this.y==y && !jetpack_flying && fire_x_2[ x ] != 0){
                    DamageRobot(game.robot.fire_damage);
                }
                if(this.Ex==x && this.Ey==y && !Ejetpack_flying && fire_x_2[ x ] != 0){
                    DamageEnemy(game.robot.fire_damage);
                }
                Sleep(10);
            }
            if(grass_fired && grass_2_scale[ x-1 ] <= 0.1f){
                grass_2_type[ x-1 ] = 0;
            }
            fire_x_2[ x ] = 0;
            fire_state_2[ x ] = 0;
        }
        if(y == 3 && fire_x_3[ x ] == 0 && fire_state_3[ x ] == 0){
            fire_x_3[ x ] = 1;
            fire_state_3[ x ] = 1;
            if(grass_3_type[ x-1 ] != 0){
                grass_fired = true;
            }
            while(fire_state_3[ x ]<width/10*1.5f){
                if(fire_x_3[ x ] == 0){
                    broke_plus = 3;
                }
                if(grass_fired){
                    grass_3_scale[ x ]-=0.01f;
                }
                fire_state_3[ x ]+=1+broke_plus;
                if(this.x==x && this.y==y && !jetpack_flying && fire_x_3[ x ] != 0){
                    DamageRobot(game.robot.fire_damage);
                }
                if(this.Ex==x && this.Ey==y && !Ejetpack_flying && fire_x_3[ x ] != 0){
                    DamageEnemy(game.robot.fire_damage);
                }
                Sleep(10);
            }
            while(fire_state_3[ x ]>1){
                if(fire_x_3[ x ] == 0){
                    broke_plus = 3;
                }
                if(grass_fired){
                    grass_3_scale[ x ]-=0.05f;
                }
                fire_state_3[ x ]-=broke_plus;
                if(this.x==x && this.y==y && !jetpack_flying && fire_x_3[ x ] != 0){
                    DamageRobot(game.robot.fire_damage);
                }
                if(this.Ex==x && this.Ey==y && !Ejetpack_flying && fire_x_3[ x ] != 0){
                    DamageEnemy(game.robot.fire_damage);
                }
                Sleep(10);
            }
            if(grass_fired && grass_3_scale[ x-1 ] <= 0.1f){
                grass_3_type[ x-1 ] = 0;
            }
            fire_x_3[ x ] = 0;
            fire_state_3[ x ] = 0;
        }
    }
    public boolean CheckBullet(){
        if(bullets>0) {
            int index = 0;
            while (index < 40) {
                if (bullets_dir[index] != 0 && Math.floor(bullets_y[index]) == (double)Ey && Math.abs((double)bullets_x[index] - (double)(Ex*width/10)) < 800 && (((double)(Ex*width/10)-(double)bullets_x[index] > 0 && bullets_dir[index] == 1) || ((double)bullets_x[index]-(double)(Ex*width/10)> 0 && bullets_dir[index] == -1))) {
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    public void ESetBullet(int Ex, int Ey, int Edir){               //Жесткая дичь, которая добавляет пули. Работает - не трожь. Написал сам - молодец. Скопипастил - лох. Но если придерживаться логики, где вообще можно скопипастить такую хрень, а?
        if(bullets < 40){
            bullets++;
            int i = 0;
            int num = 0;
            while(i<40){
                if(bullets_dir[i] == 0){
                    num = i;
                    break;
                }
                i++;
            }
            bullets_type[num] = 2;
            bullets_x[num] = Ex;
            bullets_y[num] = Ey;
            bullets_dir[num] = Edir;
            lastnumbullet = num;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    int randomfire = game.random.nextInt(6) * (game.random.nextInt(2) - 1); //Переменная, отвечающая за кучность стрельбы.. Типо точность, или отдача
                    int num = lastnumbullet;                   //Вот, на ней все держится
                    int dir = bullets_dir[num];
                    while(true){
                        bullets_x[num] += 2 * dir;
                        bullets_y[num]-=0.0001*randomfire;
                        if(bullets_x[num] > width+100 || bullets_x[num] < -100){
                            break;
                        }
                        if(bullets_x[num] >= (int)(x*width/10+robot_x) && bullets_x[num] <= (int)(x*width/10+robot_x+(290.0*scale)) && (int)Math.round(bullets_y[num]) == y){
                            if(!ball_clicked && !dead) {
                                DamageRobot(game.robot.Edamage);
                                break;
                            }
                        }
                        if(bullets == 0 || bullets_dir[num] == 0){
                            break;
                        }
                        Sleep(  (int)(5*speed));
                    }
                    bullets_type[num] = 0;
                    bullets_x[num] = 0;
                    bullets_y[num] = 0;
                    bullets_dir[num] = 0;
                    bullets--;
                }
            };
            anime.start();
        }
    }
    public void SetBullet(int x, int y, int dir){               //Жесткая дичь, которая добавляет пули. Работает - не трожь. Написал сам - молодец. Скопипастил - лох. Но если придерживаться логики, где вообще можно скопипастить такую хрень, а?
        if(bullets < 40){
            bullets++;
            int i = 0;
            int num = 0;
            while(i<40){
                if(bullets_dir[i] == 0){
                    num = i;
                    break;
                }
                i++;
            }
            bullets_type[num] = 1;
            bullets_x[num] = x;
            bullets_y[num] = y;
            bullets_dir[num] = dir;
            Elastnumbullet = num;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    int randomfire = game.random.nextInt(6) * (game.random.nextInt(2) - 1); //Переменная, отвечающая за кучность стрельбы.. Типо точность, или отдача
                    int num = Elastnumbullet;                   //Вот, на ней все держится
                    int dir = bullets_dir[num];
                    while(true){
                        bullets_x[num]+=2*dir;
                        bullets_y[num]-=0.0001*randomfire;
                        if(bullets_x[num] > width+100 || bullets_x[num] < -100){
                            break;
                        }
                        if(bullets_x[num] >= (int)(Ex*width/10+Erobot_x) && bullets_x[num] <= (int)(Ex*width/10+Erobot_x+(290.0*scale)) && (int)Math.round(bullets_y[num]) == Ey){
                            if(!Eball_clicked && !Edead) {
                                DamageEnemy(game.robot.damage);
                                break;
                            }

                        }
                        if(bullets == 0 || bullets_dir[num] == 0){
                            break;
                        }
                        Sleep(  (int)(5*speed));
                    }
                    bullets_type[num] = 0;
                    bullets_x[num] = 0;
                    bullets_y[num] = 0;
                    bullets_dir[num] = 0;
                    bullets--;
                }
            };
            anime.start();
        }
    }
    public void DamageEnemy(int damage){
        if(!Eswap && !Eball_clicked) {
                if (!Ehurt) {
                    Ehealth -= damage;
                    if(Ehealth <= 0) {
                        Ehealth = 0;
                    }
                    experience+=game.robot.level_win;
                    RandomHitSound();
                    Thread anime = new Thread() {
                        @Override
                        public void run() {
                            int anime_dir = 1;
                            Ehurt = true;
                            int anime_pos = 0;
                            while (anime_dir != 3) {
                                if (anime_dir == 1) {
                                    Escale += 0.001f;
                                    anime_pos += 1;
                                    if (anime_pos >= 40) {
                                        anime_dir = 2;
                                    }
                                } else {
                                    Escale -= 0.001f;
                                    anime_pos -= 1;
                                    if (anime_pos <= 0) {
                                        anime_dir = 3;
                                    }
                                }
                                Sleep((int) (2 * speed));
                            }
                            if(Ehealth <= 0) {
                                Ehealth = 0;
                                EDead();
                            }
                            Ehurt = false;
                            Escale = 0.8f;
                        }
                    };
                    anime.start();
                }
            }
    }
    public void DamageRobot(int damage){
        if(!swap && !ball_clicked) {
            if (!hurt) {

                    health -= damage;

                    if (health <= 0) {
                        if(!jetpack_clicked) {
                            health = 0;
                        }else{
                            health = 1;
                        }
                    }

                RandomHitSound();
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        int anime_dir = 1;
                        hurt = true;
                        int anime_pos = 0;
                        while (anime_dir != 3) {
                            if (anime_dir == 1) {
                                scale += 0.001f;
                                scale_inteface-=0.002;
                                anime_pos += 1;
                                if (anime_pos >= 40) {
                                    anime_dir = 2;
                                }
                            } else {
                                scale -= 0.001f;
                                scale_inteface+=0.002;
                                anime_pos -= 1;
                                if (anime_pos <= 0) {
                                    anime_dir = 3;
                                }
                            }
                            Sleep((int) (2 * speed));
                        }
                        if(health <= 0) {
                            health = 0;
                            Dead();
                        }
                        hurt = false;
                        scale = 0.8f;
                    }
                };
                anime.start();
            }
        }
    }
    public void EDead(){
        if(!Edead){
            Edead = true;

            Thread anime = new Thread() {
                @Override
                public void run() {
                    death.play(0.8f);
                    Sleep(  200);
                    while (Edead_state < 1050) {
                        if(Edead_state<500) {
                            Edead_state += 1;
                        }else{
                            Edead_state += 2;
                        }
                        scale_inteface-=0.0002;
                        pos_interface+=2;
                        Erobot_y-=4;
                        Escale-=0.0004f;
                        Sleep(  10);
                    }
                    EndGame(1);
                }
            };
            anime.start();
        }
    }
    public void EndGame(int win) {
            win_num = game.random.nextInt(6) + (5-(3-type_achivement));
            win_rot = 0.0f;
            int random_num = game.random.nextInt(100)+1;
            win_type = 1;
            if(random_num<=game.robot.metal_chance[game.robot.level-1]){
                win_type = 3;
            }
            if(random_num<=game.robot.metal_chance[game.robot.level-1]+game.robot.chip_chance[game.robot.level-1]&&random_num>game.robot.metal_chance[game.robot.level-1]){
                win_type = 1;
            }
            if(random_num<=game.robot.metal_chance[game.robot.level-1]+game.robot.chip_chance[game.robot.level-1]+game.robot.bulb_chance[game.robot.level-1]&&random_num>game.robot.metal_chance[game.robot.level-1]+game.robot.chip_chance[game.robot.level-1]){
            win_type = 2;
            }
            if(random_num<=game.robot.metal_chance[game.robot.level-1]+game.robot.chip_chance[game.robot.level-1]+game.robot.bulb_chance[game.robot.level-1]+game.robot.gear_chance[game.robot.level-1]&&random_num>game.robot.metal_chance[game.robot.level-1]+game.robot.chip_chance[game.robot.level-1]+game.robot.bulb_chance[game.robot.level-1]){
            win_type = 4;
            }
            this.win = win;
            game.click.play(0.8f);
            Thread anime = new Thread() {
                @Override
                public void run() {
                    if (win_type == 1) {
                        game.robot.microchips += win_num;
                    }
                    if (win_type == 2) {
                        game.robot.lamps += win_num;
                    }
                    if (win_type == 3) {
                        game.robot.metal += win_num;
                    }
                    if (win_type == 4) {
                        game.robot.gears += win_num;
                    }
                    int dir_scale = 1;
                    int level_dir = 0;
                    Sleep(200);
                    while (win_scale < 500) {
                        win_rot += 0.7;
                        win_scale += 2;
                        if (win_scale % 100 == 0) {
                            move[2].play(0.7f);
                        }
                        if (win_rot >= 360) {
                            win_rot = 0;
                        }
                        Sleep(5);
                    }

                    if(!music_swapped) {
                        music_swapped=true;
                        game.MusicSwap(1);
                    }

                    Thread AddExp = new Thread() {
                        @Override
                        public void run() {
                            show_exp = true;
                            while(show_exp_x < width/2+100 ){
                                show_exp_x+=15;
                                Sleep(5);
                            }
                            while(show_exp_x > width/2-50 ){
                                show_exp_x-=10;
                                Sleep(5);
                            }
                            while(show_exp_x < width/2 ){
                                show_exp_x+=5;
                                Sleep(5);
                            }
                            game.robot.AddExperience(experience);
                        }
                    };
                    AddExp.start();
                    while (!closed) {
                        if (win_y < 300) {
                            win_y += 4;
                        }
                        win_rot += 0.2f;
                        if (dir_scale == 1) {
                            win_scale += 1;
                            if (win_scale > 525) {
                                dir_scale = -1;
                                level_dir++;
                            }
                        } else {
                            win_scale -= 1;
                            if (win_scale < 500) {
                                dir_scale = 1;
                                level_dir++;
                            }
                        }
                        if (win_rot >= 360) {
                            win_rot = 0;
                        }
                        if (level_dir > 7){
                            if(!game.robot.exp_process) {
                                end = true;
                            }
                        }
                        Sleep(20);
                    }
                }
            };
            anime.start();

    }
    public void SetMeteor(){
        if(meteor_run){
            int rand = game.random.nextInt(3);
            if(rand == 0) {
                will_meteor_x = Ex;
                will_meteor_y = Ey;
            }else{
                if(rand == 1){
                    meteor_rocket = true;
                }
                will_meteor_x = x;
                will_meteor_y = y;
            }
            siren.play(0.2f);
            if(!meteor_rocket) {
                meteor_y = height;
            }else{
                meteor_y = height+100;
            }
            meteor_x = will_meteor_x*width/10;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    cross_size= 5;
                    while (cross_size< 200) {
                        cross_size+=1;
                        Sleep(  (int)(5*speed));
                    }
                    while (meteor_y>will_meteor_y*(height/5)-300) {
                        meteor_rot += 0.5f;
                        if(meteor_rot >= 360.0f){
                            meteor_rot = 0.0f;
                        }

                        if(meteor_y < will_meteor_y*(height/5)+150 && meteor_y > will_meteor_y*(height/5)-100){
                            if(will_meteor_x == x && will_meteor_y == y){
                                if(game.robot.level != 1) {
                                    DamageRobot(game.robot.health/5);
                                }else{
                                    DamageRobot(game.robot.health/9);
                                }
                            }
                            if(will_meteor_x == Ex && will_meteor_y == Ey){
                                if (game.robot.level != 1) {
                                    DamageEnemy(game.robot.Ehealth/5);
                                } else {
                                    DamageEnemy(game.robot.Ehealth/9);
                                }
                            }
                        }
                        if(cross_size> 5){
                            cross_size-=1;
                        }
                        meteor_y-=3;
                        Sleep(  (int)(5*speed));
                    }

                    if(will_meteor_x == x && will_meteor_y == y){
                        if(game.robot.level != 1) {
                            DamageRobot(game.robot.health/3);
                        }else{
                            DamageRobot(game.robot.health/5);
                        }
                    }
                    if(will_meteor_x == Ex && will_meteor_y == Ey) {
                        if (game.robot.level != 1) {
                            DamageEnemy(game.robot.Ehealth/3);
                        } else {
                            DamageEnemy(game.robot.Ehealth/5);
                        }
                    }
                    meteor_rot = 0.0f;
                    meteor_splash=true;
                    drawer.Shake();
                    while (meteor_splash_size<225) {
                        meteor_splash_size+=2;
                        Sleep(  (int)(5*speed));
                    }
                    while (meteor_splash_size>-100) {
                        meteor_splash_size-=1;
                        Sleep(  (int)(5*speed));
                    }
                    meteor_y = 0;
                    meteor_x = 0;
                    will_meteor_y = 0;
                    will_meteor_x = 0;
                    cross_size=0;
                    meteor_rocket = false;
                    meteor_splash=false;
                    meteor_run = false;
                }
            };
            anime.start();
        }
    }
    public void EBall(){
        if(!Efire_clicked && !Eup_clicked && !Edown_clicked && !Eredir_clicked && !Ejump_clicked && !Edead && !pause && !Eball_clicked && Eball_can) {
            Eball_clicked = true;
            Eball_can = false;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (Eball_state < 1.0f) {
                        Eball_state += 0.02f;
                        Sleep(5);
                    }
                    if(Edir==1){
                        while(Ex<8){
                            Erobot_x+=5;
                            if(Erobot_x>=width/10){
                                Erobot_x=0;
                                Ex++;
                            }
                            if(x==Ex&&y==Ey){
                                DamageRobot(game.robot.Eattack_speed*4);
                            }
                            ETakeSkin();
                            EUseMed();
                            Erot -= 2.0f;
                            Sleep(5);
                        }
                    }else{
                        while(Ex>1){
                            Erobot_x-=5;
                            if(Erobot_x<=-width/10){
                                Erobot_x=0;
                                Ex--;
                            }
                            if(x==Ex&&y==Ey){
                                DamageRobot(game.robot.Eattack_speed*4);
                            }
                            ETakeSkin();
                            EUseMed();
                            Erot += 2.0f;
                            Sleep(5);
                        }
                    }
                    Erobot_x = 0;
                    Erot = 0.0f;
                    Sleep(100);
                    while (Eball_state > 0.0f) {
                        Eball_state -= 0.02f;
                        Sleep(5);
                    }
                    Eball_clicked = false;
                    Sleep(10000);
                    Eball_can = true;
                }
            };
            anime.start();
        }
    }
    public void Ball(){
        if(!fire_clicked && !up_clicked && !down_clicked && !redir_clicked && !jump_clicked && !dead && !pause && !ball_clicked && ball_can && !jetpack_clicked) {
                turnedBall++;
                ball_clicked = true;
                ball_can = false;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        while (ball_state < 1.0f) {
                            ball_state += 0.02f;
                            Sleep(5);
                        }
                        if(dir==1){
                            while(x<8){
                                robot_x+=5;
                                if(robot_x>=width/10){
                                    robot_x=0;
                                    x++;
                                }
                                if(x==Ex&&y==Ey){
                                    DamageEnemy(game.robot.attack_speed*4);
                                }
                                TakeSkin();
                                UseMed();
                                rot -= 2.0f;
                                Sleep(5);
                            }
                        }else{
                            while(x>1){
                                robot_x-=5;
                                if(robot_x<=-width/10){
                                    robot_x=0;
                                    x--;
                                }
                                if(x==Ex&&y==Ey){
                                    DamageEnemy(game.robot.attack_speed*4);
                                }
                                TakeSkin();
                                UseMed();
                                rot += 2.0f;
                                Sleep(5);
                            }
                        }
                        robot_x = 0;
                        rot = 0.0f;
                        Sleep(100);
                        while (ball_state > 0.0f) {
                            ball_state -= 0.02f;
                            Sleep(5);
                        }
                        ball_clicked = false;
                        Sleep(10000);
                        ball_can = true;
                    }
                };
                anime.start();
        }
    }
    public void CheckBoom(){
            drawer.Shake();
            if(x == boom_x && y == boom_y && !robotboom && robot_speed_bonus == 0){
                experience+=5*game.robot.level_win;
                robotboom = true;
                health = health/2;
                robot_speed_bonus = 1;
                front_energy_scale=width*2;

                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        while (front_energy_scale>0) {
                            front_energy_scale-=5;
                            Sleep(  3);
                        }

                        Sleep(10000);

                        while (front_energy_scale<width*2) {
                            front_energy_scale+=5;
                            Sleep(  3);
                        }
                        robot_speed_bonus = 0;
                        robotboom = false;
                    }
                };
                anime.start();
                Thread energy_circle_anime = new Thread() {
                    @Override
                    public void run() {
                        robot_circle = true;
                        energy_circle_size = -30;
                        while (energy_circle_size<10) {
                            energy_circle_size+=1;
                            Sleep(  10);
                        }
                        int dir = 1;
                        while(robot_speed_bonus==1){
                            if(ball_clicked){
                                if(energy_circle_size>-200) {
                                    energy_circle_size -= 10;
                                }
                            }
                            if(dir==1) {
                                energy_circle_size-=2;
                                if(energy_circle_size<=0){
                                    dir = 0;
                                }
                            }else{
                                energy_circle_size+=2;
                                if(energy_circle_size>25){
                                    dir = 1;
                                }
                            }
                            Sleep(5);
                        }
                        while (energy_circle_size>-190) {
                            energy_circle_size-=1;
                            Sleep(  10);
                        }
                        energy_circle_size = 0;
                        robot_circle = false;
                    }
                };
                energy_circle_anime.start();
            }

        if(Ex == boom_x && Ey == boom_y && !Erobotboom && Erobot_speed_bonus == 0){
            Erobotboom = true;
            Ehealth = Ehealth/2;
            Erobot_speed_bonus = 1;

            Thread anime = new Thread() {
                @Override
                public void run() {

                    Sleep(11000);

                    Erobot_speed_bonus = 0;
                    Erobotboom = false;
                }
            };
            anime.start();
            Thread energy_circle_anime = new Thread() {
                @Override
                public void run() {
                    Erobot_circle = true;
                    Eenergy_circle_size = -30;
                    while (Eenergy_circle_size<10) {
                        Eenergy_circle_size+=1;
                        Sleep(  10);
                    }
                    int dir = 1;
                    while(Erobot_speed_bonus==1){
                        if(Eball_clicked){
                            if(Eenergy_circle_size>-200) {
                                Eenergy_circle_size -= 10;
                            }
                        }
                        if(dir==1) {
                            Eenergy_circle_size-=2;
                            if(Eenergy_circle_size<=0){
                                dir = 0;
                            }
                        }else{
                            Eenergy_circle_size+=2;
                            if(Eenergy_circle_size>25){
                                dir = 1;
                            }
                        }
                        Sleep(5);
                    }
                    while (Eenergy_circle_size>-190) {
                        Eenergy_circle_size-=1;
                        Sleep(  10);
                    }
                    Eenergy_circle_size = 0;
                    Erobot_circle = false;
                }
            };
            energy_circle_anime.start();
        }
    }
    public void Dead(){
        if(!dead){
            dead = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    death.play(0.8f);
                    Sleep(  200);
                    Gdx.input.vibrate(500);
                    while (dead_state < 1050) {
                        if(dead_state<500) {
                            dead_state += 1;
                        }else{
                            dead_state += 2;
                        }
                        scale_inteface-=0.0004;
                        pos_interface+=1;
                        robot_y-=4;
                        scale-=0.0004f;
                        Sleep(  10);
                    }
                    if (!Edead && win != 1) {
                        Sleep(500);
                        if(!music_swapped) {
                            music_swapped=true;
                            game.MusicSwap(1);
                        }
                        DoorClose(1);
                    }
                }
            };
            anime.start();
        }
    }
    public void EFire(){
        if(!Efire_clicked && !Eup_clicked && !Edown_clicked && !Eredir_clicked && !Ejump_clicked && !Edead && !pause && !Eball_clicked) {
            if (EEnergyExists(10)) {
                EEnergyUse(10);
                Efire_clicked = true;
                ESetBullet(Ex * width / 10 + (int) (90 * Escale), Ey, Edir);
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        float lastrot = Erothand;
                        double rot = 0;
                        int rotdir = 1;
                        RandomFireSound();
                        while (true) {
                            if (rotdir == 1) {
                                rot += Edir;
                                Erothand += 1.0f * Edir;
                                if (Edir * rot > 10) {
                                    rotdir = -1;
                                }
                            }
                            if (rotdir == -1) {
                                rot -= Edir;
                                Erothand -= 1.0f * Edir;
                                if (Edir * rot < 0) {
                                    break;
                                }
                            }
                            if(Erobot_speed_bonus == 0) {
                                Sleep((int) (game.robot.Eattack_speed * speed));
                            }else{
                                Sleep((int) (1 * speed));
                            }
                        }
                        Efire_clicked = false;
                        Erothand = lastrot;
                    }
                };
                anime.start();
            }
        }
    }
    public void Fire(){
        if(!fire_clicked && !up_clicked && !down_clicked && !redir_clicked && !jump_clicked && !dead && !pause && !ball_clicked &&!fire_cant && !jetpack_clicked) {
            if (EnergyExists(10)) {
                EnergyUse(10);
                turnedFire++;
                fire_clicked = true;
                if(robot_y<100) {
                    SetBullet(x * width / 10 + (int) (90 * scale), y, dir);
                }else{
                    SetBullet(x * width / 10 + (int) (90 * scale), y+1, dir);
                }
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        float lastrot = rothand;
                        double rot = 0;
                        int rotdir = 1;
                        RandomFireSound();
                        while (true) {
                            if (rotdir == 1) {
                                rot += dir;
                                scale_inteface-=0.003;
                                rothand += 1.0f * dir;
                                if (dir * rot > 10) {
                                    rotdir = -1;
                                }
                            }
                            if (rotdir == -1) {
                                rot -= dir;
                                scale_inteface+=0.003;
                                rothand -= 1.0f * dir;
                                if (dir * rot < 0) {
                                    break;
                                }
                            }
                            if(robot_speed_bonus == 0) {
                                Sleep((int) (game.robot.attack_speed * speed));
                            }else{
                                Sleep((int) (1 * speed));
                            }
                        }
                        scale_inteface = 1.1f;
                        fire_clicked = false;
                        rothand = lastrot;
                    }
                };
                anime.start();//Огонь!
            }
        }
    }
    public void RandomFireSound(){
        int random = game.random.nextInt(3);
        blaster[random].play(0.8f-((float)game.random.nextInt(3)*0.1f));
    }
    public void RandomHitSound(){
        int random = game.random.nextInt(3);
        hit[random].play(0.8f-((float)game.random.nextInt(3)*0.1f));
    }
    public void RandomMoveSound(){
        int random = game.random.nextInt(3);
        move[random].play(0.6f-((float)game.random.nextInt(3)*0.1f));
    }
    public void EEnergyUse(int en){
        Eenergy-=en;
    }
    public void EnergyUse(int en){
        energy_use = en;
        Thread anime = new Thread() {
            @Override
            public void run() {
                int energy_num = 0;
                while (energy_num<energy_use) {
                    energy_num+=1;
                    energy-=1;
                    if(energy<=0){
                        break;
                    }
                    Sleep((int)(5*speed));
                }
            }
        };
        anime.start();
    }
    public boolean EEnergyExists(int energy){
        return this.Eenergy >= energy;
    }
    public boolean EnergyExists(int energy){
        if(!(this.energy>=energy)){
            if(!isEnergyWarning) {
                isEnergyWarning = true;
                warning = 1;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        Sleep(  (int)(100*speed));
                        warning = 2;
                        Sleep(  (int)(100*speed));
                        warning = 0;
                        isEnergyWarning = false;
                    }
                };
                anime.start();
            }
        }
        return this.energy >= energy;
    }
    public void EUseMed(){
        if(med_y == Ey && med_x == Ex && !med_used && med_is && !med_swap){
            move[1].play(0.9f);
            Ehealth+=game.robot.Ehealth/4;
            if(Ehealth > game.robot.Ehealth){
                Ehealth = game.robot.Ehealth;
            }
            med_scale = 10;
            med_used = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (med_scale>10) {
                        med_scale-=2;
                        Sleep( 5);
                    }
                    while (med_scale<150) {
                        med_scale+=2;
                        Sleep( 5);
                    }
                    while (med_scale>10) {
                        med_scale-=2;
                        Sleep( 5);
                    }
                    med_used = false;
                    med_is = false;
                    med_scale = 150;
                }
            };
            anime.start();
        }
    }
    public void UseMed(){
        if(med_y == y && med_x == x && !med_used && med_is && !med_swap){
            move[1].play(0.9f);
            health+=game.robot.health/4;
            if(health > game.robot.health){
                health = game.robot.health;
            }
            experience+=3*game.robot.level_win;
            med_scale = 10;
            med_used = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (med_scale>10) {
                        med_scale-=2;
                        Sleep( 5);
                    }
                    while (med_scale<150) {
                        med_scale+=2;
                        Sleep( 5);
                    }
                    while (med_scale>10) {
                        med_scale-=2;
                        Sleep( 5);
                    }
                    med_used = false;
                    med_is = false;
                    med_scale = 150;
                }
            };
            anime.start();
        }
    }
    public void EUp(){
        if(!Eup_clicked && !Edown_clicked && !Efire_clicked && !Edead && !pause && !Eball_clicked ) {
            Eup_clicked = true;
            if (Ey < 3) {
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        int dir_num = Edir;
                        int rotdir = 1;
                        boolean acess_x = false;
                        boolean acess_y = false;
                        RandomMoveSound();
                        while (true) {
                            if (Erobot_y < (height / 5)) {
                                Erobot_y += 2;
                            } else {
                                acess_y = true;
                            }
                            if (dir_num + Ex != 0 && dir_num + Ex != 9) {
                                if (dir_num * Erobot_x <= (width / 10)) {
                                    Erobot_x += dir_num * 2;
                                } else {
                                    acess_x = true;
                                }
                            } else {
                                acess_x = true;
                            }
                            if (rotdir == 1) {
                                Erotleg += 2;
                                if (Erotleg > 90) {
                                    rotdir = 0;
                                }
                            } else {
                                Erotleg -= 2;
                                if (Erotleg < 0) {
                                    rotdir = 1;
                                }
                            }
                            if (acess_x && acess_y) {
                                Ey += 1;
                                if (dir_num + Ex != 0 && dir_num + Ex != 9) {
                                    Ex += dir_num;
                                }
                                Eup_clicked = false;
                                Erotleg = 0;
                                Erobot_y = 0;
                                Erobot_x = 0;
                                EUseMed();
                                ETakeSkin();
                                break;
                            }
                            if(Erobot_speed_bonus == 0) {
                                if(game.robot.level!=2) {
                                    Sleep((int) (game.robot.Emove_speed * speed));
                                }else{

                                    Sleep((int) ((5+game.robot.Emove_speed/2) * speed));
                                }
                            }else{
                                Sleep(  (int)(1*speed));
                            }

                        }
                    }
                };
                anime.start();
            }
        }
    }
    public void EDown(){
        if(!Eup_clicked && !Edown_clicked && !Efire_clicked && !Edead && !pause && !Eball_clicked) {
            Edown_clicked = true;
            if (Ey > 1) {
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        int dir_num = Edir;
                        int rotdir = 1;
                        boolean acess_x = false;
                        boolean acess_y = false;
                        RandomMoveSound();
                        while (true) {
                            if (Erobot_y > -(height / 5)) {
                                Erobot_y -= 2;
                            } else {
                                acess_y = true;
                            }
                            if (dir_num + Ex != 0 && dir_num + Ex != 9) {
                                if (dir_num * Erobot_x <= (width / 10)) {
                                    Erobot_x += dir_num * 2;
                                } else {
                                    acess_x = true;
                                }
                            } else {
                                acess_x = true;
                            }
                            if (rotdir == 1) {
                                Erotleg += 2;
                                if (Erotleg > 90) {
                                    rotdir = 0;
                                }
                            } else {
                                Erotleg -= 2;
                                if (Erotleg < 0) {
                                    rotdir = 1;
                                }
                            }
                            if (acess_x && acess_y) {
                                Ey -= 1;
                                if (dir_num + Ex != 0 && dir_num + Ex != 9) {
                                    Ex += dir_num;
                                }
                                Edown_clicked = false;
                                Erotleg = 0;
                                Erobot_y = 0;
                                Erobot_x = 0;
                                EUseMed();
                                ETakeSkin();
                                break;
                            }
                            if(Erobot_speed_bonus == 0) {
                                if(game.robot.level!=2) {
                                    Sleep((int) (game.robot.Emove_speed * speed));
                                }else{

                                    Sleep((int) ((5+game.robot.Emove_speed/2) * speed));
                                }
                            }else{
                                Sleep(  (int)(1*speed));
                            }
                        }
                    }
                };
                anime.start();
            }
        }
    }
    public void Up(){                                                                                        //Вира!
        if(!up_clicked && !down_clicked && !fire_clicked && !dead && !pause && !ball_clicked && !jetpack_clicked) {
            if (y < 3) {
                turnedUp++;
                up_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        int dir_num = dir;
                        int rotdir = 1;
                        boolean acess_x = false;
                        boolean acess_y = false;
                        RandomMoveSound();
                        while (true) {
                            if (robot_y < (height / 5)) {
                                robot_y += 2;
                            }else{
                                acess_y = true;
                            }
                            if (dir_num + x != 0 && dir_num + x != 9) {
                                if (dir_num * robot_x <= (width / 10)) {
                                    robot_x += dir_num * 2;
                                }else{
                                    acess_x = true;
                                }
                            }else{
                                acess_x = true;
                            }
                            if (rotdir == 1) {
                                rotleg += 2;
                                if (rotleg > 90) {
                                    rotdir = 0;
                                }
                            } else {
                                rotleg -= 2;
                                if (rotleg < 0) {
                                    rotdir = 1;
                                }
                            }
                            if (acess_x && acess_y) {
                                y += 1;
                                if (dir_num + x != 0 && dir_num + x != 9) {
                                    x += dir_num;
                                }
                                break;
                            }

                            if(robot_speed_bonus == 0) {
                                if(game.robot.level!=2) {
                                    Sleep((int) (game.robot.move_speed * speed));
                                }else{

                                    Sleep((int) ((5+game.robot.move_speed/2) * speed));
                                }
                            }else{
                                Sleep(  (int)(1*speed));
                            }
                        }

                        up_clicked = false;
                        rotleg = 0;
                        robot_y = 0;
                        robot_x = 0;
                        UseMed();
                        TakeSkin();
                    }
                };
                anime.start();
            }
        }
        if(jetpack_clicked && !up_clicked && !down_clicked && jetpack_flying && !up_cant){
            if(y<3) {
                up_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        while(robot_y<height/5+30){
                            robot_y+=5;
                            Sleep(5);
                        }
                        robot_y-=height/5;
                        y++;
                        UseMed();
                        TakeSkin();
                        up_clicked = false;
                    }
                };

                anime.start();
            }
        }
    }
    public void Down(){                                             //Майна!
        if(!up_clicked && !down_clicked && !fire_clicked  && !dead && !pause && !ball_clicked && !jetpack_clicked) {
            if (y > 1) {
                down_clicked = true;
                turnedDown++;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        int dir_num = dir;
                        int rotdir = 1;
                        boolean acess_x = false;
                        boolean acess_y = false;
                        RandomMoveSound();
                        while (true) {
                            if (robot_y > -(height / 5)) {
                                robot_y -= 2;
                            }else{
                                acess_y = true;
                            }
                            if (dir_num + x != 0 && dir_num + x != 9) {
                                if (dir_num * robot_x <= (width / 10)) {
                                    robot_x += dir_num * 2;
                                }else{
                                    acess_x = true;
                                }
                            }else{
                                acess_x = true;
                            }
                            if (rotdir == 1) {
                                rotleg += 2;
                                if (rotleg > 90) {
                                    rotdir = 0;
                                }
                            } else {
                                rotleg -= 2;
                                if (rotleg < 0) {
                                    rotdir = 1;
                                }
                            }
                            if (acess_x && acess_y) {
                                y -= 1;
                                if (dir_num + x != 0 && dir_num + x != 9) {
                                    x += dir_num;
                                }
                                break;
                            }
                            if(robot_speed_bonus == 0) {
                                if(game.robot.level!=2) {
                                    Sleep((int) (game.robot.move_speed * speed));
                                }else{

                                    Sleep((int) ((5+game.robot.move_speed/2) * speed));
                                }
                            }else{
                                Sleep(  (int)(1*speed));
                            }
                        }
                        down_clicked = false;
                        rotleg = 0;
                        robot_y = 0;
                        robot_x = 0;
                        UseMed();
                        TakeSkin();
                    }
                };
                anime.start();
            }
        }
        if(jetpack_clicked && !up_clicked && !down_clicked && jetpack_flying && !down_cant){
            if(y>1) {
                down_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        while(robot_y>-height/5+30){
                            robot_y-=5;
                            Sleep(5);
                        }
                        robot_y+=height/5;
                        y--;
                        UseMed();
                        TakeSkin();
                        down_clicked = false;
                    }
                };

                anime.start();
            }
        }
    }
    public void ERedir() {                                                       // Поворот.
        if (!Eredir_clicked && !Efire_clicked && !Edead && !pause && !Eball_clicked) {
            Eredir_clicked = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while(true) {
                        if(Edir == 1) {
                            if (Erothand < 270) {
                                Erothand += 3;
                            } else {
                                Erothand = 270;
                                break;
                            }
                        }else{
                            if (Erothand > 0) {
                                Erothand -= 3;
                            } else {
                                Erothand = 0;
                                break;
                            }
                        }
                        if(Erobot_speed_bonus == 0) {
                            Sleep(  (int)(((double)game.robot.Eattack_speed/1.20)*speed));
                        }else{
                            Sleep(  (int)(2*speed));
                        }

                    }
                    Eredir_clicked = false;
                    Edir = -Edir;
                }
            };
            anime.start();
        }
    }
    public void Redir() {                                                       // Поворот.
        if (!redir_clicked && !fire_clicked && !dead && !pause && !ball_clicked) {
            redir_clicked = true;
            turnedRedir++;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while(true) {
                        if(dir == 1) {
                            if (rothand < 270) {
                                rothand += 3;
                            } else {
                                rothand = 270;
                                break;
                            }
                        }else{
                            if (rothand > 0) {
                                rothand -= 3;
                            } else {
                                rothand = 0;
                                break;
                            }
                        }
                        if(robot_speed_bonus == 0) {
                            Sleep(  (int)(((double)game.robot.attack_speed/1.20)*speed));
                        }else{
                            Sleep(  (int)(2*speed));
                        }
                    }
                    redir_clicked = false;
                    dir = -dir;
                }
            };
            anime.start();
        }
    }
    public void EJump() {                                                                // На самом деле, это не прыжок, а телепорт. Не баг, а фича!
        if (!Eup_clicked && !Edown_clicked && !Ejump_clicked  && !Edead && !pause && !Eball_clicked) {
            if (EEnergyExists(30)) {
                EEnergyUse(30);
                Ejump_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        Eswap = true;
                        move[0].play();
                        while (true) {
                            Escale -= 0.03f;
           
                            if (Escale < 0.1f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        Ex = 4 * Edir;
                        if (Ex < 1) {
                            Ex = 1;
                        }
                        if (Ex > 8) {
                            Ex = 8;
                        }

                        while (true) {
                            Escale += 0.03f;


                            if (Escale > 0.8f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        EUseMed();
                        Eswap = false;
                        Escale = 0.8f;
                        Ejump_clicked = false;
                    }
                };
                anime.start();
            }
        }
    }
    public void Jetpack() {
        if (!up_clicked && !down_clicked && !jump_clicked && !dead && !pause && !ball_clicked && !jetpack_clicked && EnergyExists(50)) {
            EnergyUse(50);
            jetpack_clicked = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                   while(jetpack_state<180){
                        jetpack_state+=5;
                        Sleep(10);
                   }
                   jetpack_flying = false;
                   fire_cant = true;
                   int dir_x = dir;
                   int dir_robot_y = 0;
                   int distance = 5;
                   boolean is_fire_under = false;
                   while(true) {
                       if(y == 1){
                           if(fire_x_1[ x ] != 0) {
                               is_fire_under = true;
                           }
                       }
                       if(y == 2){
                           if(fire_x_2[ x ] != 0) {
                               is_fire_under = true;
                           }
                       }
                       if(y == 3){
                           if(fire_x_3[ x ] != 0) {
                               is_fire_under = true;
                           }
                       }
                       if (x + dir_x<9 && x+dir_x>0 && distance >=0 ) {

                           if(robot_y < 50 && !jetpack_flying ){
                               robot_y+=5;
                           }else{
                               if(!jetpack_flying) {
                                   fire_cant = false;
                                   jetpack_flying = true;

                               }
                           }
                           if(!up_clicked && !down_clicked) {
                               if(!is_fire_under) {
                                   if (rotleg < 30.0f) {
                                       rotleg += 0.6f;
                                   } else {

                                       rotleg -= 0.3f;
                                   }
                               }else{
                                   if (rotleg < 50.0f) {
                                       rotleg += 0.6f;
                                   } else {

                                       rotleg -= 0.3f;
                                   }
                               }
                           }else{
                               if(!up_cant && !down_cant) {
                                   if (rotleg < 40.0f) {
                                       rotleg += 0.3f;
                                   } else {

                                       rotleg -= 0.6f;
                                   }
                               }
                           }
                            if(jetpack_flying && !up_clicked && !down_clicked) {
                                if (dir_robot_y == 0) {
                                    robot_y -= 1.0f;
                                    if(!is_fire_under) {
                                        if (robot_y < 30) {
                                            dir_robot_y = 1;
                                        }
                                    }else{
                                        if (robot_y < 60) {
                                            dir_robot_y = 1;
                                        }
                                    }
                                } else {
                                    robot_y += 1.0f;
                                    if(!is_fire_under) {
                                        if (robot_y > 70) {
                                            dir_robot_y = 0;
                                        }
                                    }else{
                                        if (robot_y > 90) {
                                            dir_robot_y = 0;
                                        }
                                    }
                                }
                            }
                                if (robot_x > width / 10 || robot_x < -width / 10) {
                                    if(game.robot.level != 2){
                                        Thread anime = new Thread(){
                                            @Override
                                            public void run() {

                                                if (game.robot.jetpack == 1) {
                                                    SetFire(x, y);
                                                } else {
                                                    if(y == 1){
                                                        fire_x_1[ x ] = 0;
                                                    }
                                                    if(y == 2){
                                                        fire_x_2[ x ] = 0;
                                                    }
                                                    if(y == 3){
                                                        fire_x_3[ x ] = 0;
                                                    }
                                                }
                                            }
                                        };
                                        anime.start();
                                    }
                                    TakeSkin();
                                    UseMed();
                                    x += dir_x;
                                    robot_x = 0;
                                    distance -= 1;

                                } else {
                                    if(!robotboom) {
                                        if (game.robot.jetpack == 2) {
                                            robot_x += (12 + game.robot.attack_speed) * dir_x;
                                        }
                                        if (game.robot.jetpack == 1) {
                                            robot_x += (8 + game.robot.attack_speed) * dir_x;
                                        }
                                    }else{
                                        robot_x += 18 * dir_x;
                                    }
                                }

                       }else{
                           break;
                       }
                       Sleep(10);
                   }
                    up_cant = true;
                    down_cant = true;
                    while(jetpack_state>20 || rotleg>0 ) {
                        if (!up_clicked && !down_clicked){
                            if (robot_y > 0) {
                                if (game.robot.level != 2) {
                                    robot_y -= 15;
                                } else {
                                    robot_y -= 5;
                                }
                            }
                        if (rotleg > 0) {
                            rotleg -= 1.5f;
                        }
                        if (jetpack_state > 20) {
                            jetpack_state -= 5;
                        }
                    }
                        Sleep(10);
                    }
                    if(y == 1){
                        fire_x_1[ x ] = 0;
                    }
                    if(y == 2){
                        fire_x_2[ x ] = 0;
                    }
                    if(y == 3){
                        fire_x_3[ x ] = 0;
                    }
                    fire_cant = false;
                    robot_y = 0;
                    rotleg=0;
                    jetpack_state=0;
                    jetpack_flying = false;
                    jetpack_clicked = false;
                    up_cant = false;
                    down_cant = false;
                }
            };
            anime.start();
        }
    }
    public void Jump() {                                                                // На самом деле, это не прыжок, а телепорт. Не баг, а фича!
        if (!up_clicked && !down_clicked && !jump_clicked && !dead && !pause && !ball_clicked) {
            if (EnergyExists(30)) {
                EnergyUse(30);
                turnedJump++;
                jump_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        swap = true;
                        move[0].play();
                        while (true) {
                            scale -= 0.03f;
                            scale_inteface-=0.002;

                            if (scale < 0.1f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        x += 4 * dir;
                        if (x < 1) {
                            x = 1;
                        }
                        if (x > 8) {
                            x = 8;
                        }
                        while (true) {
                            scale += 0.03f;
                            scale_inteface+=0.002;

                            if (scale > 0.8f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        UseMed();
                        swap = false;
                        scale = 0.8f;
                        jump_clicked = false;
                    }
                };
                anime.start();
            }
        }
    }
    @Override
    public void dispose (){
        blaster[0].dispose();
        blaster[1].dispose();
        blaster[2].dispose();
        hit[0].dispose();
        hit[1].dispose();
        hit[2].dispose();
        move[0].dispose();
        move[1].dispose();
        move[2].dispose();
        for(Texture texture: med){ texture.dispose(); }
        death.dispose();
        grass.dispose();
        game.robot.DisposeGamePlayTextures();
        Frontground.dispose();
        Openlevel_1.dispose();
        Openlevel_2.dispose();
        Splash.dispose();
        Fire.dispose();
        Meteort.dispose();                          //Очистка памяти.
        batch.dispose();
        floor.dispose();
        up_1.dispose();
        down_1.dispose();
        up_2.dispose();
        down_2.dispose();
        redir.dispose();
        fire.dispose();
        jump.dispose();
        up_1_touched.dispose();
        down_1_touched.dispose();
        up_2_touched.dispose();
        down_2_touched.dispose();
        redir_touched.dispose();
        fire_touched.dispose();
        jump_touched.dispose();
        door_left.dispose();
        door_right.dispose();
        Wineffect.dispose();
        bulb.dispose();
        gear.dispose();
        metall.dispose();
        chip.dispose();
        Darkeffect.dispose();
        MedSwap.dispose();
        Bluefire.dispose();
        boom.dispose();
        booms[0].dispose();
        booms[1].dispose();
        booms[2].dispose();
        Front_energy.dispose();
        achivement[0].dispose();
        achivement[1].dispose();
        achivement[2].dispose();
        achivement[3].dispose();
        begin_left[0].dispose();
        begin_left[1].dispose();
        begin_left[2].dispose();
        begin_right[0].dispose();
        begin_right[1].dispose();
        begin_right[2].dispose();
        background.dispose();
        ball.dispose();
        ball_cant.dispose();
        ball_touched.dispose();
        big_grass.dispose();
        level_circle.dispose();
        level_back.dispose();
        level_front.dispose();
        level_line.dispose();
        if(game.robot.level!=2) {
            fire_location[0].dispose();
            fire_location[1].dispose();
            fire_location[2].dispose();
        }
        energy_circle_texture.dispose();
        if(game.robot.level == 2 || game.robot.level == 4){
            FrontLevel2.dispose();
        }
        if(game.robot.level == 2){
            planett.dispose();
        }
        if (game.robot.opened < game.robot.max_skin) {
            puck.dispose();
            puck_swap.dispose();
        }
    }
}