package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import org.omg.CORBA.WrongTransaction;

public class GamePlay extends Openable implements Screen{
    SpriteBatch batch;
    Sound[] blaster;
    Sound[] hit;
    Sound[] move;
    Sound death;
    Sound siren;
    Thread anime;//Анимации перса
    Thread Eanime;//Анимации Врага
    Thread EnergyAdd;
    Thread EnemyBrine;
    Thread EEnergyAdd;
    Thread CrossAdd;
    Thread StartLevel;
    Thread MedAdd;
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
    Texture[] med = new Texture[5];
    TextureRegion Meteor;
    TextureRegion Effect;
    int win_y = 0;
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
    double speed = 1.0;
    double anime_grass = 0;
    int[] grass_1 = new int[5];
    int[] grass_2 = new int[5];
    int[] grass_3 = new int[5];
    double scale_inteface = 1.1;
    double robot_x = 0;
    double robot_y = 0;
    double Erobot_x = 0;
    double Erobot_y = 0;
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
    public GamePlay(MainGame game) { this.game = game; }
    @Override
    public void show() {
        game.robot.SetGamePlayTextures();
        metall = new Texture("Item/metall.png");
        chip = new Texture("Item/chip.png");
        bulb = new Texture("Item/bulb.png");
        gear = new Texture("Item/gear.png");
        energy = game.robot.energy;
        Darkeffect = new Texture("Interface/dark.png");
        Wineffect = new Texture("Interface/gameplay_effect_1.png");
        Rocket = new Texture("Object/rocket.png");
        Effect = new TextureRegion(Wineffect, 300, 300);
        Frontground = new Texture("Interface/frontground.png");
        Openlevel_1 = new Texture("Interface/openlevel_1.png");
        Openlevel_2 = new Texture("Interface/openlevel_2.png");
        Bluefire = new Texture("Object/bluefire.png");
        MedSwap = new Texture("Object/health_swap.png");
        Splash = new Texture("Object/splash.png");
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
        up_1_touched = new Texture("Button/button_up_-1_touched.png");
        down_1_touched = new Texture("Button/button_down_-1_touched.png");
        up_2_touched = new Texture("Button/button_up_1_touched.png");
        down_2_touched = new Texture("Button/button_down_1_touched.png");
        redir_touched = new Texture("Button/button_redir_touched.png");
        fire_touched = new Texture("Button/button_fire_touched.png");
        jump_touched = new Texture("Button/button_jump_touched.png");
        Gdx.input.setInputProcessor(new GamePlayTouch(game, this));
        Start();
        for(int i=0;i<5;i++){
            med[i] = new Texture("Object/health_" + (i+1) + ".png");
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
        parameter.size = (int)(150.0*wpw);
        item_font = generator.generateFont(parameter);
        item_font.setColor(Color.GREEN);
        int i = 0;                                                 //Стандартная переменная, которая, почему-то, используется везде. Зачем я вообще написал этот комментарий?
        while(i != 5){
            grass_1[i] = game.random.nextInt(10)+1;
            i++;
        }
        i = 0;
        while(i != 5){
            grass_2[i] = game.random.nextInt(10)+1;
            i++;
        }
        i = 0;
        while(i != 5){
            grass_3[i] = game.random.nextInt(10)+1;
            i++;
        }
        health = game.robot.health;
        Ehealth = game.robot.Ehealth;
        y = game.random.nextInt(3)+1;
        Ey = game.random.nextInt(3)+1;
        background = new Texture("Location/background_" + game.robot.level + ".png");
        floor = new Texture("Location/grass_alpha_" + game.robot.level + ".png");
        open_x = 0;
        batch = new SpriteBatch();
        StartLevel = new Thread(){
            @Override
            public void run(){
                openlevel_x = 0;
                Sleep(1500);
                while(openlevel_x<width){
                    openlevel_x+=2;
                    Sleep(1);
                }
                Sleep(1000);
                while(openlevel_x>-200){
                    openlevel_x-=2;
                    Sleep(1);
                }
                openlevel_x = 0;
                pause=false;
            }
        };
        MedAdd = new Thread(){
            @Override
            public void run(){
                Sleep(7000);
                while(!closed){
                    if(!med_is && !pause) {
                        med_is = true;
                        med_x = (game.random.nextInt(7) + 2);
                        med_y = (game.random.nextInt(3) + 1);
                        med_scale = 0;
                        med_swap = true;
                        med_anime = 0;
                        move[1].play(0.9f);
                        while (med_scale<150) {
                            med_scale+=2;
                            Sleep(5);
                        }
                        med_swap = false;
                        int med_dir = 1;
                        while (med_is) {
                            if(med_dir == 1) {
                                if (med_anime+1 < 5) {
                                    med_anime++;
                                    med_scale-=1;
                                }else{
                                    med_dir = 0;
                                }
                            }else{
                                if (med_anime-1 > -1) {
                                    med_anime--;
                                    med_scale+=1;
                                }else{
                                    med_dir = 1;
                                }
                            }
                            Sleep(70);
                        }

                    }
                    Sleep((game.random.nextInt(15) + 5) * 1000);
                }
            }
        };
        anime = new Thread(){
            @Override
            public void run(){
                int dir = 2;                                        //Указание направления анимации. Типо реверс.
                int time = game.random.nextInt(10)+10;
                while(true){
                    if(grass_dir == 1){
                        anime_grass+=0.5;
                        if(anime_grass>=5.0){
                            grass_dir = 0;
                        }
                    }else{
                        anime_grass-=0.5;
                        if(anime_grass<=-5.0){
                            grass_dir = 1;
                        }
                    }
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
                    if(closed){
                        break;
                    }
                    Sleep(  (int)(time*speed));
                }
            }
        };
        CrossAdd = new Thread(){
            @Override
            public void run(){
                Sleep( (int)(5000*speed));
                int random;
                while(true){
                    if(!pause) {
                        random = game.random.nextInt(5);
                        if (!meteor_run && random == 0) {
                            meteor_run = true;
                            SetMeteor();
                        }
                        if (closed) {
                            break;
                        }
                    }
                    Sleep(  (int)(1000*speed));
                }
            }
        };
        Eanime = new Thread(){
            @Override
            public void run(){
                int Edir = 2;                                         //Переменные с обозначением "E" в начале принадлежат врагу.
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
                    if(closed){
                        break;
                    }
                    Sleep(  (int)(Etime*speed));
                }
            }
        };
        EnergyAdd = new Thread(){
            @Override
            public void run(){
                Sleep(  (int)(5000*speed));
                while(true){
                    if(energy<game.robot.energy){
                        energy+=1;
                    }
                    if(closed){
                        break;
                    }
                    Sleep(  (int)(game.robot.energy_speed*speed));
                }
            }
        };
        EEnergyAdd = new Thread(){
            @Override
            public void run(){
                Sleep(  (int)(5000*speed));
                while(true){
                    if(Eenergy<game.robot.energy){
                        Eenergy+=1;
                    }
                    if(closed){
                        break;
                    }
                    Sleep(  (int)(game.robot.Eenergy_speed*speed));
                }
            }
        };
        EnemyBrine = new Thread(){
            @Override
            public void run(){
                Sleep(  (int)(5000*speed));
                while(true) {
                    if(!pause) {
                    int random_act = game.random.nextInt(26) + 1;
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
                                EDown();
                            }
                            if (Ey + 1 < 4 && move_dir == 0) {
                                EUp();
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
                            EDown();
                        }
                        if (Ey + 1 < 4 && move_dir == 0) {
                            EUp();
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
                    if (random_act > 20) {
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
                    if (closed) {
                        break;
                    }
                    Sleep((int) (50 * speed));
                }
                }
            }
        };
        drawer = new SpriteBatchRubber(this, batch);
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
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        drawer.draw(background, 0, 0, width, height);
        int i = 0;
        while(i!=5){
            drawer.draw(grass, grass_3[i]*(width/10), (height/5)*3-70-15*3, 150, (int)(150+anime_grass));
            i++;
        }
        if(will_meteor_y == 3 && meteor_run){
            if(!meteor_splash) {
                if(!meteor_rocket) {
                    drawer.draw(Fire, meteor_x - 12, meteor_y, 175.0f, 200.0f + (meteor_rot) / 4);
                    drawer.draw(Meteor, meteor_x, meteor_y, 75.0f, 75.0f, 150.0f, 150.0f, 1, 1, meteor_rot);
                }else{
                    drawer.draw(Fire, meteor_x - 12, meteor_y+70, 175.0f, 200.0f + (meteor_rot) / 4);
                    drawer.draw(Rocket, meteor_x-50, meteor_y-10, 250, 250);
                }
            }else{
                drawer.draw(Splash, meteor_x-meteor_splash_size/2, meteor_y, 150+meteor_splash_size, 150+meteor_splash_size);
            }
        }
        drawer.draw(floor, 0, height/5*2-80, width, height/5);
        if(meteor_run && will_meteor_y == 3) {
            drawer.draw(game.robot.Cross, meteor_x + (150-cross_size)/2, will_meteor_y * (height / 5) - 60 - 10 * will_meteor_y, cross_size, cross_size);
        }
        i = 0;
        while(i!=5){
            drawer.draw(grass, grass_2[i]*(width/10), (height/5)*2-105, 150, (int)(150+anime_grass));
            i++;
        }
        if(will_meteor_y == 2 && meteor_run){
            if(!meteor_splash) {
                if(!meteor_rocket) {
                    drawer.draw(Fire, meteor_x - 12, meteor_y, 175.0f, 200.0f + (meteor_rot) / 4);
                    drawer.draw(Meteor, meteor_x, meteor_y, 75.0f, 75.0f, 150.0f, 150.0f, 1, 1, meteor_rot);
                }else{
                    drawer.draw(Fire, meteor_x - 12, meteor_y+70, 175.0f, 200.0f + (meteor_rot) / 4);
                    drawer.draw(Rocket, meteor_x-50, meteor_y-10, 250, 250);
                }
            }else{
                drawer.draw(Splash, meteor_x-meteor_splash_size/2, meteor_y, 150+meteor_splash_size, 150+meteor_splash_size);
            }
        }
        drawer.draw(floor, 0, height/5-70, width, height/5);
        if(meteor_run && will_meteor_y == 2) {
            drawer.draw(game.robot.Cross, meteor_x + (150-cross_size)/2, will_meteor_y * (height / 5) - 60 - 10 * will_meteor_y, cross_size, cross_size);
        }
        i = 0;
        while(i!=5){
            drawer.draw(grass, grass_1[i]*(width/10), (height/5)-70-15, 150, (int)(150+anime_grass));
            i++;
        }
        if(will_meteor_y == 1 && meteor_run){
            if(!meteor_splash) {
                if(!meteor_rocket) {
                    drawer.draw(Fire, meteor_x - 12, meteor_y, 175.0f, 200.0f + (meteor_rot) / 4);
                    drawer.draw(Meteor, meteor_x, meteor_y, 75.0f, 75.0f, 150.0f, 150.0f, 1, 1, meteor_rot);
                }else{
                    drawer.draw(Fire, meteor_x - 12, meteor_y+70, 175.0f, 200.0f + (meteor_rot) / 4);
                    drawer.draw(Rocket, meteor_x-50, meteor_y-10, 250, 250);
                }
            }else{
                drawer.draw(Splash, meteor_x-meteor_splash_size/2, meteor_y, 150+meteor_splash_size, 150+meteor_splash_size);
            }
        }
        drawer.draw(floor, 0, -60, width, height/5);
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
        if(Ey == 3){
            DrawEnemy(drawer, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale*(1.0f-0.03f*Ey), Erothand+90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
        }
        if(y == 3){
            DrawRobot(drawer, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale*(1.0f-0.03f*y), rothand+90, rothead, rotleg, rot , swap, hurt, dead, 0);
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
        if(Ey == 2){
            DrawEnemy(drawer, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale*(1.0f-0.03f*Ey), Erothand+90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
        }
        if(y == 2){
            DrawRobot(drawer, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale*(1.0f-0.03f*y), rothand+90, rothead, rotleg, rot , swap, hurt, dead, 0);
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
        if(Ey == 1){
            DrawEnemy(drawer, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale*(1.0f-0.03f*Ey), Erothand+90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
        }
        if(y == 1){
            DrawRobot(drawer, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale*(1.0f-0.03f*y), rothand+90, rothead, rotleg, rot , swap, hurt, dead, 0);
        }
        DrawEnemyIcon(drawer, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale, Ehealth);
        DrawRobotIcon(drawer, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale, health);
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
        if(jump_touch) {
            drawer.draw(jump_touched, (int)(width-400*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }else{
            drawer.draw(jump, (int)(width-400*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }
        DrawEnergy(drawer, (int)(400*(scale_inteface-0.1)), (int)(-50*(scale_inteface-0.1)), 1.3*(scale_inteface-0.1), energy, warning);
        if(win != 0){
            drawer.draw(Darkeffect, 0, 0, width, height);
            drawer.draw(Effect, (float) (width/2.0-(double)win_scale/2.0), (float) (height/2.0-(double)win_scale/2.0), (float)win_scale/2.0f, (float)win_scale/2.0f, (float)win_scale, (float)win_scale, 1, 1, (float)win_rot);
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
            resource_font.draw(batch, win_num + "", (int)(((double)width/2.0-50)*wpw), (int)(((double)win_y-160.0)*hph));
            resource_font.draw(batch, "ХЛАМ", (int)(((double)width/2.0-200)*wpw), (int)(((double)height-(double)win_y+260.0)*hph));
        }
        drawer.draw(Frontground, 0, 0, width, height);
        if(pause){
            drawer.draw(Openlevel_1, openlevel_x-width-10, 0, width, height);
            drawer.draw(Openlevel_2, width-openlevel_x+10, 0, width, height);
            item_font.draw(batch, game.robot.level + " УРОВЕНЬ", (int)((double)(width/2.0-400.0)*wpw), (int)(((double)height/(double)width*(double)openlevel_x/2.0-50)*hph));
        }
        CheckClose(drawer);
        CheckOpen(drawer);
        batch.end();
        if(closed){
            if(type_close == 1) {
                game.setGameMenu();
            }
        }
        if(end && !ending){
            ending = true;
            DoorClose(1);
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
                            DamageRobot(game.robot.Edamage);
                            break;
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
                            DamageEnemy(game.robot.damage);
                            break;
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
        if(!Eswap) {
                if (!Ehurt) {
                    Ehealth -= damage;
                    if(Ehealth <= 0) {
                        Ehealth = 0;
                    }
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
        if(!swap) {
            if (!hurt) {
                health -= damage;
                if(health <= 0) {
                    health = 0;
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
                                anime_pos += 1;
                                if (anime_pos >= 40) {
                                    anime_dir = 2;
                                }
                            } else {
                                scale -= 0.001f;
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
                    while (pos_interface<500) {
                        scale_inteface-=0.0002;
                        pos_interface+=1;
                        Erobot_y-=2;
                        Escale-=0.0002f;
                        Sleep(  5);
                    }
                    Sleep(  500);
                    EndGame(1);
                }
            };
            anime.start();
        }
    }
    public void EndGame(int win){
        win_num = game.random.nextInt(7)+1;
        win_rot = 0.0f;
        win_type = game.robot.level;
        this.win = win;
        game.click.play(0.8f);
        Thread anime = new Thread() {
            @Override
            public void run() {
                if(win_type == 1){
                    game.robot.microchips+=win_num;
                }
                if(win_type == 2){
                    game.robot.lamps+=win_num;
                }
                if(win_type == 3){
                    game.robot.metal+=win_num;
                }
                if(win_type == 4){
                    game.robot.gears+=win_num;
                }
                int dir_scale = 1;
                int level_dir = 0;
                Sleep(  200);
                while (win_scale<500) {
                    win_rot+=0.7;
                    win_scale+=2;
                    if(win_scale%100==0){
                        move[2].play(0.7f);
                    }
                    if(win_rot >= 360){
                        win_rot = 0;
                    }
                    Sleep(5);
                }
                while (!closed) {
                    if(win_y<300){
                        win_y+=4;
                    }
                    win_rot+=0.2f;
                    if(dir_scale==1) {
                        win_scale+=1;
                        if (win_scale > 525) {
                            dir_scale=-1;
                            level_dir++;
                        }
                    }else{
                        win_scale-=1;
                        if (win_scale < 500) {
                            dir_scale=1;
                            level_dir++;
                        }
                    }
                    if(win_rot >= 360){
                        win_rot = 0;
                    }
                    if(level_dir>4){
                        end = true;
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
            meteor_y = height;
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
                                DamageRobot(10);
                            }
                            if(will_meteor_x == Ex && will_meteor_y == Ey){
                                DamageEnemy(10);
                            }
                        }
                        if(cross_size> 5){
                            cross_size-=1;
                        }
                        meteor_y-=3;
                        Sleep(  (int)(5*speed));
                    }
                    if(will_meteor_x == x && will_meteor_y == y){
                        DamageRobot(20);
                    }
                    if(will_meteor_x == Ex && will_meteor_y == Ey){
                        DamageEnemy(10);
                    }
                    meteor_rot = 0.0f;
                    meteor_splash=true;
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
    public void Dead(){
        if(!dead){
            dead = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    death.play(0.8f);
                    Sleep(  200);
                    while (pos_interface<500) {
                        scale_inteface-=0.0002;
                        pos_interface+=1;
                        robot_y-=2;
                        scale-=0.0002f;
                        Sleep(  5);
                    }
                    Sleep(  500);
                    DoorClose(1);
                }
            };
            anime.start();
        }
    }
    public void EFire(){
        if(!Efire_clicked && !Eup_clicked && !Edown_clicked && !Eredir_clicked && !Ejump_clicked && !Edead && !pause) {
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
                            Sleep(  (int)(game.robot.Eattack_speed*speed));
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
        if(!fire_clicked && !up_clicked && !down_clicked && !redir_clicked && !jump_clicked && !dead && !pause) {
            if (EnergyExists(10)) {
                EnergyUse(10);
                fire_clicked = true;
                SetBullet(x * width / 10 + (int) (90 * scale), y, dir);
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
                            Sleep(  (int)(game.robot.attack_speed*speed));
                        }
                        scale_inteface = 1.1;
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
            Ehealth+=20;
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
            health+=20;
            if(health > game.robot.health){
                health = game.robot.health;
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
    public void EUp(){
        if(!Eup_clicked && !Edown_clicked && !Efire_clicked && !Edead && !pause) {
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
                                break;
                            }
                                Sleep(  (int)(game.robot.Emove_speed*speed));
                        }
                    }
                };
                anime.start();
            }
        }
    }
    public void EDown(){
        if(!Eup_clicked && !Edown_clicked && !Efire_clicked && !Edead && !pause) {
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
                                break;
                            }
                                Sleep(  (int)(game.robot.Emove_speed*speed));
                        }
                    }
                };
                anime.start();
            }
        }
    }
    public void Up(){                                                                                        //Вира!
        if(!up_clicked && !down_clicked && !fire_clicked && !dead && !pause) {
            if (y < 3) {
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

                                Sleep(  (int)(game.robot.move_speed*speed));
                        }
                        up_clicked = false;
                        rotleg = 0;
                        robot_y = 0;
                        robot_x = 0;
                        UseMed();
                    }
                };
                anime.start();
            }
        }
    }
    public void Down(){                                             //Майна!
        if(!up_clicked && !down_clicked && !fire_clicked  && !dead && !pause) {
            if (y > 1) {
                down_clicked = true;
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
                                Sleep(  (int)(game.robot.move_speed*speed));
                        }
                        down_clicked = false;
                        rotleg = 0;
                        robot_y = 0;
                        robot_x = 0;
                        UseMed();
                    }
                };
                anime.start();
            }
        }
    }
    public void ERedir() {                                                       // Поворот.
        if (!Eredir_clicked && !Efire_clicked && !Edead && !pause) {
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
                        Sleep(  (int)(5*speed));
                    }
                    Eredir_clicked = false;
                    Edir = -Edir;
                }
            };
            anime.start();
        }
    }
    public void Redir() {                                                       // Поворот.
        if (!redir_clicked && !fire_clicked && !dead && !pause) {
            redir_clicked = true;
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
                        Sleep(  (int)(5*speed));
                    }
                    redir_clicked = false;
                    dir = -dir;
                }
            };
            anime.start();
        }
    }
    public void EJump() {                                                                // На самом деле, это не прыжок, а телепорт. Не баг, а фича!
        if (!Eup_clicked && !Edown_clicked && !Ejump_clicked  && !Edead && !pause) {
            if (EEnergyExists(30)) {
                EEnergyUse(30);
                Ejump_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        Eswap = true;
                        move[0].play();
                        while (true) {
                            Escale -= 0.02f;
                            Erobot_y += 5;
                            if (Escale < 0.5f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        Ex += 4 * Edir;
                        if (Ex < 1) {
                            Ex = 1;
                        }
                        if (Ex > 8) {
                            Ex = 8;
                        }
                        while (true) {
                            Escale += 0.02f;
                            Erobot_y -= 5;
                            if (Escale > 0.8f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        EUseMed();
                        Eswap = false;
                        Escale = 0.8f;
                        Erobot_y = 0;
                        Erobot_x = 0;
                        Ejump_clicked = false;
                    }
                };
                anime.start();
            }
        }
    }
    public void Jump() {                                                                // На самом деле, это не прыжок, а телепорт. Не баг, а фича!
        if (!up_clicked && !down_clicked && !jump_clicked && !dead && !pause) {
            if (EnergyExists(30)) {
                EnergyUse(30);
                jump_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        swap = true;
                        move[0].play();
                        while (true) {
                            scale -= 0.02f;
                            scale_inteface-=0.003;
                            robot_y += 5;
                            if (scale < 0.5f) {
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
                            scale += 0.02f;
                            scale_inteface+=0.003;
                            robot_y -= 5;
                            if (scale > 0.8f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        UseMed();
                        swap = false;
                        scale = 0.8f;
                        robot_y = 0;
                        robot_x = 0;
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
    }
}