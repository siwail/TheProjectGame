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
    Sound[] Lblaster;
    Sound[] ELblaster;
    Sound[] Rblaster;
    Sound[] ERblaster;
    Sound[] hit;
    Sound[] move;
    Sound death;
    Sound siren;
    Sound boom;
    Thread Eanime;//Анимации Врага
    Thread Rain;
    Thread Legs_1;
    Thread Legs_2;
    Thread EnergyAdd;
    Thread EnemyBrine;
    Thread EEnergyAdd;
    Thread CrossAdd;
    Thread StartLevel;
    Thread MedAdd;
    Thread BoomAdd;
    Thread TimeAdd;
    Thread space_anime;
    Thread PressAdd;
    Thread AddSkins;
    Thread AddAlert;
    Thread PacketSet;
    Thread FireAnime_1;
    Thread FireAnime_2;
    Thread FireAnime_3;
    Thread JetpackAnime;
    Thread EJetpackAnime;
    Thread FriendBrine;
    Thread ControlMove;
    Texture Frontcolor;
    Texture puck;
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

    Texture button_control;
     Texture button_control_back;

    Texture[] rain = new Texture[3];

    Texture pull;
    Texture fire_touched;
    Texture ball;
    Texture Meteort;
    Texture Splash;
    Texture Fire;
    Texture Frontground;
    Texture Wineffect;
    Texture Darkeffect;
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
    Texture big_grass;
    Texture level_circle;
    Texture level_back;
    Texture level_front;
    Texture level_line;
    Texture jetpack;
    Texture button_mine;
    Texture button_circle;
    Texture button_saw;
    Texture button_touched;
    Texture button_cant_touch;
    Texture circlet;
    Texture mine;
    Texture mine_off;
    Texture plasma;
    Texture plasma_ball;
    Texture plasma_tail;
    Texture[] boom_front = new Texture[3];
    TextureRegion circle;
    TextureRegion FrontLevel2_region;
    TextureRegion background_region;
    Texture[] fire_location = new Texture[5];
    Texture[] med = new Texture[5];
    Texture[] booms = new Texture[7];
    Texture[] begin_left = new Texture[3];
    Texture[] begin_right = new Texture[3];
    Texture[] sawt = new Texture[3];
    Texture[] Esawt = new Texture[3];
    Texture[] explosivet = new Texture[5];
    TextureRegion[] explosive = new TextureRegion[5];
    TextureRegion planet;
    TextureRegion Meteor;
    TextureRegion Effect;
    TextureRegion[] saw = new TextureRegion[3];
    TextureRegion[] Esaw = new TextureRegion[3];
    String location_name_1;
    String location_name_2;
    float Eball_state = 0.0f;
    float ball_state = 0.0f;
    float[] rip_x = new float[6];
    float[] rip_y = new float[6];
    float[] rip_rotate = new float[6];
    float[] rip_dir_x = new float[6];
    float[] rip_dir_y = new float[6];
    float[] rip_dir_rotate = new float[6];

    float[] Erip_x = new float[6];
    float[] Erip_y = new float[6];
    float[] Erip_rotate = new float[6];
    float[] Erip_dir_x = new float[6];
    float[] Erip_dir_y = new float[6];
    float[] Erip_dir_rotate = new float[6];
    int jetpack_state = 0;
    int Ejetpack_state = 0;

    int rain_quantity = 350;
    float[] rain_x = new float[rain_quantity];
    int[] rain_type = new int[rain_quantity];
    float[] rain_y = new float[rain_quantity];
    int[] rain_z = new int[rain_quantity];
    float[] rain_dir_x = new float[rain_quantity];
    float[] rain_dir_y = new float[rain_quantity];
    float[] mine_rotate = new float[3];
    float[] Emine_rotate = new float[3];
    int explosive_dir_x;
    int explosive_dir_y;
    int Eexplosive_dir_x;
    int Eexplosive_dir_y;
    int alert_x = 400;
    int alert_y = 0;
    int alert_x_plus = 0;
    int gift_size;
    int gift_y;
    int gift_x;
    int press_y;
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
    int[] bullets_size = new int[50];
    int[] bullets_x = new int[50];
    float[] bullets_y = new float[50];
    int[] bullets_dir = new int[50];
    int[] bullets_type = new int[50];
    int[] fire_x_1 = new int[10];
    int[] fire_x_2 = new int[10];
    int[] fire_x_3 = new int[10];
    int[] fire_state_1 = new int[10];
    int[] fire_state_2 = new int[10];
    int[] fire_state_3 = new int[10];
    int[] fire_anime_1 = new int[10];
    int[] fire_anime_2 = new int[10];
    int[] fire_anime_3 = new int[10];
    int[] fire_anime_dir_1 = new int[10];
    int[] fire_anime_dir_2 = new int[10];
    int[] fire_anime_dir_3 = new int[10];
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
    int energy;
    int Eenergy = 200;
    int energy_use = 0;
    int openlevel_x = 0;
    int time = 120;
    int type_achivement = 1;
    int gift_index = 0;
    int boom_front_anime;
    int experience = 0;
    float speed = 1.0f;
    float anime_grass = 0;
    int lastsaw;
    int Elastsaw;
    int[] grass_1 = new int[10];
    int[] grass_2 = new int[10];
    int[] grass_3 = new int[10];
    float[] grass_1_scale = new float[10];
    float[] grass_2_scale = new float[10];
    float[] grass_3_scale = new float[10];
    float[] grass_1_anime = new float[10];
    float[] grass_2_anime = new float[10];
    float[] grass_3_anime = new float[10];
    float[] grass_1_dir = new float[10];
    float[] grass_2_dir = new float[10];
    float[] grass_3_dir = new float[10];
    int[] grass_1_type = new int[10];
    int[] grass_2_type  = new int[10];
    int[] grass_3_type  = new int[10];
    float scale_inteface = 1.1f;
    int mines = 0;
    float[] leg_scale = new float[3];
    int[] mine_exist = new int[3];
    float[] mine_scale = new float[3];
    int[] mine_x = new int[3];
    int[] mine_y = new int[3];
    int  explosive_anime = 0;
    float[] mine_legs_rotate_1 = new float[3];
    float[] mine_legs_rotate_2 = new float[3];
     int Emines = 0;
     float[] Eleg_scale = new float[3];
     int[] Emine_exist = new int[3];
     float[] Emine_scale = new float[3];
     int[] Emine_x = new int[3];
     int[] Emine_y = new int[3];
     int  Eexplosive_anime = 0;
     float[] Emine_legs_rotate_1 = new float[3];
     float[] Emine_legs_rotate_2 = new float[3];
     int plasma_x = 0;
     int plasma_y = 0;
     int plasma_dir = 0;
     float plasma_scale = 1.0f;
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
    int jetpack_distance = 5;
    int Ejetpack_distance = 5;
    int saws_entered = 0;
    int Esaws_entered = 0;
    int jetpack_anime = 0;
    int Ejetpack_anime = 0;
    int boom_flip = 1;
    float location_2_planet_rotate = 30.0f;
    float location_2_space_rotate = 60.0f;
    float location_2_space_2_rotate = 45.0f;
    float location_2_space_3_rotate = 110.0f;
    int[] saws = new int[3];
    int[] saws_pos_x = new int[9];
    int[] saws_pos_y = new int[9];
    float[] saws_rotate = new float[9];
    int[] saws_aim_x = new int[3];
    int[] saws_aim_y = new int[3];

    int[] Esaws = new int[3];
    int[] Esaws_pos_x = new int[9];
    int[] Esaws_pos_y = new int[9];
    float[] Esaws_rotate = new float[9];
    int[] Esaws_aim_x = new int[3];
    int[] Esaws_aim_y = new int[3];

    float circle_scale;
    float circle_rotate;

     float Ecircle_scale;
     float Ecircle_rotate;


     int control_pos_x = 150;
     int control_pos_y = 150;

     boolean needMove = false;
    boolean move_control = true;
    boolean robot_explosive = false;
    boolean enemy_explosive = false;
    boolean mine_clicked = false;
    boolean Emine_clicked = false;
    boolean Esaw_can = true;
    boolean circle_can = true;
    boolean circle_touch = false;
    boolean circle_clicked = false;
    boolean Ecircle_can = true;
    boolean Ecircle_clicked = false;
    boolean saw_touch = false;
    boolean saw_clicked = false;
    boolean Esaw_clicked = false;
    boolean meteor_front_visible = false;
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
    boolean show_exp;
    boolean jetpack_can = true;
    boolean jetpack_clicked=false;
    boolean jetpack_touch=false;
    boolean jetpack_flying=false;
    boolean Ejetpack_can = true;
    boolean Ejetpack_clicked=false;
    boolean Ejetpack_flying=false;
    boolean Epull_clicked = false;
    boolean pull_clicked = false;
    boolean pull_touch = false;
    boolean plasma_clicked = false;
    boolean plasma_touch = false;


    int[] Epulls_x = new int[3];
    int[] Epulls_y = new int[3];
    int Epull_will_x = 0;
    int Epull_will_y = 0;

    int[] pulls_x = new int[3];
    int[] pulls_y = new int[3];
    int pull_will_x = 0;
    int pull_will_y = 0;


    int energy_circle_size = 0;
    int Eenergy_circle_size = 0;
    int dead_state;
    int Edead_state;

    int MEturnedFire = 0;
    int MEturnedUp = 0;
    int MEturnedDown = 0;
    int MEturnedLarge = 0;
    int MEturnedSmall = 0;
    int MEturnedMeteor = 0;
    int MEturnedBoom = 0;
    int MEturnedRedir = 0;

    int EturnedFire = 0;
    int EturnedUp = 0;
    int EturnedDown = 0;
    int EturnedLarge = 0;
    int EturnedSmall = 0;
    //int EturnedMeteor = 0;
    //int EturnedBoom = 0;
    int EturnedRedir = 0;
    int turnedSmall = 0;
    int turnedFire = 0;
    int turnedUp = 0;
    int turnedDown = 0;
    int turnedLarge = 0;
    //int turnedMeteor = 0;
    //int turnedBoom = 0;
    int turnedRedir = 0;
    public GamePlay(MainGame game, boolean online, boolean host) { this.game = game; this.online = online; this.host = host;}
    @Override
    public void show() {
        game.MusicSwap(game.random.nextInt(3)+5);
        game.robot.SetGamePlayTextures();
        if(game.robot.level !=2) {
            boom_front[0] = new Texture("Interface/white_flash_1.png");
            boom_front[1] = new Texture("Interface/white_flash_2.png");
            boom_front[2] = new Texture("Interface/white_flash_3.png");
        }else{
            boom_front[0] = new Texture("Interface/green_flash_1.png");
            boom_front[1] = new Texture("Interface/green_flash_2.png");
            boom_front[2] = new Texture("Interface/green_flash_3.png");
        }
        if (game.robot.level != 2) {
            booms[0] = new Texture("Object/energy_1.png");
            booms[1] = new Texture("Object/energy_2.png");
            booms[2] = new Texture("Object/energy_3.png");
            booms[3] = new Texture("Object/energy_4.png");
            booms[4] = new Texture("Object/energy_5.png");
            booms[5] = new Texture("Object/energy_6.png");
            booms[6] = new Texture("Object/energy_7.png");
        } else {
            booms[0] = new Texture("Object/energy_1_2.png");
            booms[1] = new Texture("Object/energy_2_2.png");
            booms[2] = new Texture("Object/energy_3_2.png");
            booms[3] = new Texture("Object/energy_4_2.png");
            booms[4] = new Texture("Object/energy_5_2.png");
            booms[5] = new Texture("Object/energy_6_2.png");
            booms[6] = new Texture("Object/energy_7_2.png");
        }
        if(game.robot.level!=2 && game.robot.level!=5) {
            fire_location[0] = new Texture("Object/fire_" + game.robot.level + "_1.png");
            fire_location[1] = new Texture("Object/fire_" + game.robot.level + "_2.png");
            fire_location[2] = new Texture("Object/fire_" + game.robot.level + "_3.png");
            fire_location[3] = new Texture("Object/fire_" + game.robot.level + "_4.png");
            fire_location[4] = new Texture("Object/fire_" + game.robot.level + "_5.png");
        }
        if(game.robot.level == 5){
            fire_location[0] = new Texture("Object/fire_3_1.png");
            fire_location[1] = new Texture("Object/fire_3_2.png");
            fire_location[2] = new Texture("Object/fire_3_3.png");
            fire_location[3] = new Texture("Object/fire_3_4.png");
            fire_location[4] = new Texture("Object/fire_3_5.png");
        }
        button_control = new Texture("Button/button_control.png");
        button_control_back = new Texture("Button/button_control_back.png");
        for(int i=0;i<5;i++){ explosivet[i] = new Texture("Object/explosive_"+(i+1)+".png"); }
        for(int i=0;i<5;i++){ explosive[i] = new TextureRegion(explosivet[i], 300, 300); }



        if(game.robot.power_small==2||game.robot.Epower_small==2) {
            mine = new Texture("Object/mine.png");
            mine_off = new Texture("Object/mine_2.png");
        }
        if(game.robot.power_large==4||game.robot.Epower_large==4) {
            circlet = new Texture("Object/energy_circle.png");
            circle = new TextureRegion(circlet, 300, 300);
        }


        if(game.robot.Epower_small==1) {
            Esawt[0] = new Texture("Object/saw_1_2.png");
            Esawt[1] = new Texture("Object/saw_2_2.png");
            Esawt[2] = new Texture("Object/saw_3_2.png");
            for (int i = 0; i < 3; i++) {
                Esaw[i] = new TextureRegion(Esawt[i], 300, 300);
            }

        }
        if(game.robot.power_small==5) {
            plasma = new Texture("Button/button_1_5_1.png");
            plasma_ball = new Texture("Object/plasma.png");
            plasma_tail = new Texture("Object/plasma_tail.png");
        }
        if(game.robot.power_small==4) {
            pull = new Texture("Button/button_1_4_1.png");
        }
        if(game.robot.power_small==1) {
            sawt[0] = new Texture("Object/saw_1_1.png");
            sawt[1] = new Texture("Object/saw_2_1.png");
            sawt[2] = new Texture("Object/saw_3_1.png");
            for (int i = 0; i < 3; i++) {
                saw[i] = new TextureRegion(sawt[i], 300, 300);
            }
            button_saw = new Texture("Button/button_1_1_1.png");
        }

        if(game.robot.power_large==4) {
            button_circle = new Texture("Button/button_2_4_1.png");
        }
        if(game.robot.power_small==2) {
            button_mine = new Texture("Button/button_1_2_1.png");
        }
        button_touched = new Texture("Button/button_touched.png");
        button_cant_touch = new Texture("Button/button_cant_touch.png");
        if(game.robot.level == 5) {
            rain[0] = new Texture("Object/snow_1.png");
            rain[1] = new Texture("Object/snow_2.png");
            rain[2] = new Texture("Object/snow_3.png");
        }
        if (game.robot.power_large==3||game.robot.power_large==2 ) {
            jetpack = new Texture("Button/button_2_" + (2 + (2 - game.robot.jetpack)) + "_1.png");
        }
        if(game.robot.power_small==3) {
            jump = new Texture("Button/button_1_3_1.png");
        }
        if(game.robot.power_large==1) {
            ball = new Texture("Button/button_2_1_1.png");
        }
        Frontcolor = new Texture("Interface/frontground_color_" + game.robot.level + ".png");

        level_circle = new Texture("Object/level_circle.png");
        level_back = new Texture("Object/level_backline.png");
        level_front = new Texture("Object/level_frontline.png");
        level_line = new Texture("Object/level_line.png");
        begin_left[0] = new Texture("Interface/openlevel_left_1.png");
        begin_left[1] = new Texture("Interface/openlevel_left_2.png");
        begin_left[2] = new Texture("Interface/openlevel_left_3.png");
        begin_right[0] = new Texture("Interface/openlevel_right_1.png");
        begin_right[1] = new Texture("Interface/openlevel_right_2.png");
        begin_right[2] = new Texture("Interface/openlevel_right_3.png");
        big_grass= new Texture("Location/grass_" + game.robot.level + "_2.png");





        metall = new Texture("Item/metall.png");
        chip = new Texture("Item/chip.png");
        bulb = new Texture("Item/bulb.png");
        gear = new Texture("Item/gear.png");
        if (game.robot.level == 2) {
            planett = new Texture("Object/planet_3.png");
            planet = new TextureRegion(planett, 400, 400);
            FrontLevel2 = new Texture("Location/background_2_front.png");
            FrontLevel2_region = new TextureRegion(FrontLevel2, 1280, 720);
        }
        if (game.robot.level == 4) {

            FrontLevel2 = new Texture("Location/background_4_front.png");
        }
        energy = game.robot.energy;
        Darkeffect = new Texture("Interface/dark.png");
        Wineffect = new Texture("Interface/gameplay_effect_1.png");

        Effect = new TextureRegion(Wineffect, 300, 300);
        Frontground = new Texture("Interface/frontground.png");

        Bluefire = new Texture("Object/bluefire.png");
        MedSwap = new Texture("Object/health_swap.png");

        Splash = new Texture("Object/splash_" + game.robot.level + ".png");


        if (game.robot.opened < game.robot.max_skin) {
            gift_index = game.random.nextInt(game.robot.max_skin-1)+1;
            puck = new Texture("Object/gift_" + gift_index + ".png");
            puck_swap = new Texture("Object/gift_swap.png");
        }
        if (game.robot.level != 1) {
            Rocket = new Texture("Object/rocket.png");
        } else {
            DownPress = new Texture("Object/down_press.png");
            UpPress = new Texture("Object/up_press.png");
            Rocket = new Texture("Object/rocket_2.png");
        }
        if(game.robot.level !=2 && game.robot.level != 4){
            Fire = new Texture("Object/fire.png");
        }
        if(game.robot.level == 4){
            Fire = new Texture("Object/fire_2.png");
        }
        if(game.robot.level == 2){
            Fire = new Texture("Object/fire_3.png");
        }
        grass = new Texture("Location/grass_" + game.robot.level + ".png");
        Meteort = new Texture("Location/meteor_" + game.robot.level + ".png");
        Meteor = new TextureRegion(Meteort, 300, 300);


        background = new Texture("Location/background_" + game.robot.level + ".png");
        if(game.robot.level == 2){
            background_region = new TextureRegion(background, 1280, 720);
        }
        floor = new Texture("Location/grass_alpha_" + game.robot.level + ".png");




        up_1 = new Texture("Button/button_up_-1.png");
        down_1 = new Texture("Button/button_down_-1.png");
        up_2 = new Texture("Button/button_up_1.png");
        down_2 = new Texture("Button/button_down_1.png");
        redir = new Texture("Button/button_redir.png");
        fire = new Texture("Button/button_fire.png");





        fire_touched = new Texture("Button/button_fire_touched.png");


        Gdx.input.setInputProcessor(new GamePlayTouch(game, this));
        Start();
        leg_scale[0] = 1.0f;
        leg_scale[1] = 1.0f;
        leg_scale[2] = 1.0f;

        Eleg_scale[0] = 1.0f;
        Eleg_scale[1] = 1.0f;
        Eleg_scale[2] = 1.0f;
        for(int i = 0; i < 10; i++){ grass_1_anime[i] = 0;grass_2_anime[i] = 0;grass_3_anime[i] = 0;}
        for(int i = 0; i < 10; i++){ grass_1_dir[i] = 1;grass_2_dir[i] = 1;grass_3_dir[i] = 1;}
        for (int i = 0; i < 5; i++) {
            med[i] = new Texture("Object/health_" + (i + 1) + ".png");
        }


        for(int i = 0; i < 6; i++){
            Erip_dir_x[i] = 0;
            Erip_dir_y[i] = 0;
            Erip_dir_rotate[i] = 0;
            while(Erip_dir_x[i]==0 || Erip_dir_y[i] == 0 || Erip_dir_rotate[i] == 0) {
                Erip_dir_x[i] = (game.random.nextInt(11) - 4) * 3;
                Erip_dir_y[i] = (game.random.nextInt(11) - 4) * 3;
                Erip_dir_rotate[i] = (game.random.nextInt(11) - 4) * 3;
            }
        }




        for(int i = 0; i < 6; i++){
            rip_dir_x[i] = 0;
            rip_dir_y[i] = 0;
            rip_dir_rotate[i] = 0;
            while(rip_dir_x[i]==0 || rip_dir_y[i] == 0 || rip_dir_rotate[i] == 0) {
                rip_dir_x[i] = (game.random.nextInt(11) - 4) * 3;
                rip_dir_y[i] = (game.random.nextInt(11) - 4) * 3;
                rip_dir_rotate[i] = (game.random.nextInt(11) - 4) * 3;
            }
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
                    Log.info("Порты забинжены");
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

        Rblaster = new Sound[3];
        Lblaster = new Sound[3];
        Rblaster[0] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_"+game.robot.LHid+"_1.wav"));
        Rblaster[1] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_"+game.robot.LHid+"_2.wav"));
        Rblaster[2] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_"+game.robot.LHid+"_3.wav"));
        if(game.robot.RHid != game.robot.LHid) {
            Lblaster[0] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_" + game.robot.RHid + "_1.wav"));
            Lblaster[1] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_" + game.robot.RHid + "_2.wav"));
            Lblaster[2] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_" + game.robot.RHid + "_3.wav"));
        }else{
            Lblaster[0] = Rblaster[0];
            Lblaster[1] = Rblaster[1];
            Lblaster[2] = Rblaster[2];
        }

        ERblaster = new Sound[3];
        ELblaster = new Sound[3];
        ERblaster[0] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_"+game.robot.ELHid+"_1.wav"));
        ERblaster[1] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_"+game.robot.ELHid+"_2.wav"));
        ERblaster[2] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_"+game.robot.ELHid+"_3.wav"));
        if(game.robot.ERHid != game.robot.ELHid) {
            ELblaster[0] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_" + game.robot.ERHid + "_1.wav"));
            ELblaster[1] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_" + game.robot.ERHid + "_2.wav"));
            ELblaster[2] = Gdx.audio.newSound(Gdx.files.internal("Sound/fire_" + game.robot.ERHid + "_3.wav"));
        }else{
            ELblaster[0] = ERblaster[0];
            ELblaster[1] = ERblaster[1];
            ELblaster[2] = ERblaster[2];
        }


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
        item_font = game.generator.generateFont(parameter);
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



        batch = new SpriteBatch();
        Legs_1 = new Thread() {
            @Override
            public void run() {
                mine_legs_rotate_1[0]=-50f;
                mine_legs_rotate_1[1]=-50f;
                mine_legs_rotate_1[2]=-50f;
                Emine_legs_rotate_1[0]=-50f;
                Emine_legs_rotate_1[1]=-50f;
                Emine_legs_rotate_1[2]=-50f;
                int dir_rotate_1 = 1;
                int dir_rotate_2 = 1;
                int dir_rotate_3 = 1;
                int Edir_rotate_1 = 1;
                int Edir_rotate_2 = 1;
                int Edir_rotate_3 = 1;
                while(!closed){
                    if(dir_rotate_1 == 1){
                        if(!ECheckCircle(mine_x[0], (int)(mine_y[0]+90*mine_scale[0]), (int)(400*mine_scale[0]), (int)(400*mine_scale[0]))) {
                            mine_legs_rotate_1[0]+=2.5f;
                        }else{
                            mine_legs_rotate_1[0]+=2.5f/8f;
                        }
                        if(mine_legs_rotate_1[0] >= 15f){
                            dir_rotate_1 = -1;
                        }
                    }else{
                        if(!ECheckCircle(mine_x[0], (int)(mine_y[0]+90*mine_scale[0]), (int)(400*mine_scale[0]), (int)(400*mine_scale[0]))) {
                            mine_legs_rotate_1[0]-=2.5f;
                        }else{
                            mine_legs_rotate_1[0]-=2.5f/8f;
                        }
                        if(  mine_legs_rotate_1[0] <= -50f){
                            dir_rotate_1 = 1;
                        }
                    }
                    if(dir_rotate_2 == 1){
                        if(!ECheckCircle(mine_x[1], (int)(mine_y[1]+90*mine_scale[1]), (int)(400*mine_scale[1]), (int)(400*mine_scale[1]))) {
                            mine_legs_rotate_1[1]+=2.5f;
                        }else{
                            mine_legs_rotate_1[1]+=2.5f/8f;
                        }
                        if(mine_legs_rotate_1[1] >= 15f){
                            dir_rotate_2 = -1;
                        }
                    }else{
                        if(!ECheckCircle(mine_x[1], (int)(mine_y[1]+90*mine_scale[1]), (int)(400*mine_scale[1]), (int)(400*mine_scale[1]))) {
                            mine_legs_rotate_1[1]-=2.5f;
                        }else{
                            mine_legs_rotate_1[1]-=2.5f/8f;
                        }
                        if(  mine_legs_rotate_1[1] <= -50f){
                            dir_rotate_2 = 1;
                        }
                    }
                    if(dir_rotate_3 == 1){
                        if(!ECheckCircle(mine_x[2], (int)(mine_y[1]+90*mine_scale[2]), (int)(400*mine_scale[2]), (int)(400*mine_scale[2]))) {
                            mine_legs_rotate_1[2]+=2.5f;
                        }else{
                            mine_legs_rotate_1[2]+=2.5f/8f;
                        }
                        if(mine_legs_rotate_1[2] >= 15f){
                            dir_rotate_3 = -1;
                        }
                    }else{
                        if(!ECheckCircle(mine_x[2], (int)(mine_y[2]+90*mine_scale[2]), (int)(400*mine_scale[2]), (int)(400*mine_scale[2]))) {
                            mine_legs_rotate_1[2]-=2.5f;
                        }else{
                            mine_legs_rotate_1[2]-=2.5f/8f;
                        }
                        if(  mine_legs_rotate_1[2] <= -50f){
                            dir_rotate_3 = 1;
                        }
                    }





                    if(Edir_rotate_1 == 1){
                        if(!CheckCircle(Emine_x[0], (int)(Emine_y[0]+90*Emine_scale[0]), (int)(400*Emine_scale[0]), (int)(400*Emine_scale[0]))) {
                            Emine_legs_rotate_1[0]+=2.5f;
                        }else{
                            Emine_legs_rotate_1[0]+=2.5f/8f;
                        }
                        if(Emine_legs_rotate_1[0] >= 15f){
                            Edir_rotate_1 = -1;
                        }
                    }else{
                        if(!CheckCircle(Emine_x[0], (int)(Emine_y[0]+90*Emine_scale[0]), (int)(400*Emine_scale[0]), (int)(400*Emine_scale[0]))) {
                            Emine_legs_rotate_1[0]-=2.5f;
                        }else{
                            Emine_legs_rotate_1[0]-=2.5f/8f;
                        }
                        if(  Emine_legs_rotate_1[0] <= -50f){
                            Edir_rotate_1 = 1;
                        }
                    }
                    if(Edir_rotate_2 == 1){
                        if(!CheckCircle(Emine_x[1], (int)(Emine_y[1]+90*Emine_scale[1]), (int)(400*Emine_scale[1]), (int)(400*Emine_scale[1]))) {
                            Emine_legs_rotate_1[1]+=2.5f;
                        }else{
                            Emine_legs_rotate_1[1]+=2.5f/8f;
                        }
                        if(Emine_legs_rotate_1[1] >= 15f){
                            Edir_rotate_2 = -1;
                        }
                    }else{
                        if(!CheckCircle(Emine_x[1], (int)(Emine_y[1]+90*Emine_scale[1]), (int)(400*Emine_scale[1]), (int)(400*Emine_scale[1]))) {
                            Emine_legs_rotate_1[1]-=2.5f;
                        }else{
                            Emine_legs_rotate_1[1]-=2.5f/8f;
                        }
                        if(  Emine_legs_rotate_1[1] <= -50f){
                            Edir_rotate_2 = 1;
                        }
                    }
                    if(Edir_rotate_3 == 1){
                        if(!CheckCircle(Emine_x[2], (int)(Emine_y[1]+90*Emine_scale[2]), (int)(400*Emine_scale[2]), (int)(400*Emine_scale[2]))) {
                            Emine_legs_rotate_1[2]+=2.5f;
                        }else{
                            Emine_legs_rotate_1[2]+=2.5f/8f;
                        }
                        if(Emine_legs_rotate_1[2] >= 15f){
                            Edir_rotate_3 = -1;
                        }
                    }else{
                        if(!CheckCircle(Emine_x[2], (int)(Emine_y[2]+90*Emine_scale[2]), (int)(400*Emine_scale[2]), (int)(400*Emine_scale[2]))) {
                            Emine_legs_rotate_1[2]-=2.5f;
                        }else{
                            Emine_legs_rotate_1[2]-=2.5f/8f;
                        }
                        if(  Emine_legs_rotate_1[2] <= -50f){
                            Edir_rotate_3 = 1;
                        }
                    }
                    Sleep(5);
                }
            }
        };
        Legs_1.start();
        Legs_2 = new Thread() {
            @Override
            public void run() {
                mine_legs_rotate_2[0]=15f;
                mine_legs_rotate_2[1]=15f;
                mine_legs_rotate_2[2]=15f;
                int dir_rotate_1 = 1;
                int dir_rotate_2 = 1;
                int dir_rotate_3 = 1;
                int Edir_rotate_1 = 1;
                int Edir_rotate_2 = 1;
                int Edir_rotate_3 = 1;
                while(!closed){
                    if(dir_rotate_1 == 1){
                        if(!ECheckCircle(mine_x[0], (int)(mine_y[0]+90*mine_scale[0]), (int)(400*mine_scale[0]), (int)(400*mine_scale[0]))) {
                            mine_legs_rotate_2[0]+=2.5f;
                        }else{
                            mine_legs_rotate_2[0]+=2.5f/8f;
                        }
                        if(mine_legs_rotate_2[0] >= 15f){
                            dir_rotate_1 = -1;
                        }
                    }else{
                        if(!ECheckCircle(mine_x[0], (int)(mine_y[0]+90*mine_scale[0]), (int)(400*mine_scale[0]), (int)(400*mine_scale[0]))) {
                            mine_legs_rotate_2[0]-=2.5f;
                        }else{
                            mine_legs_rotate_2[0]-=2.5f/8f;
                        }
                        if(  mine_legs_rotate_2[0] <= -50f){
                            dir_rotate_1 = 1;
                        }
                    }
                    if(dir_rotate_2 == 1){
                        if(!ECheckCircle(mine_x[1], (int)(mine_y[1]+90*mine_scale[1]), (int)(400*mine_scale[1]), (int)(400*mine_scale[1]))) {
                            mine_legs_rotate_2[1]+=2.5f;
                        }else{
                            mine_legs_rotate_2[1]+=2.5f/8f;
                        }
                        if(mine_legs_rotate_2[1] >= 15f){
                            dir_rotate_2 = -1;
                        }
                    }else{
                        if(!ECheckCircle(mine_x[1], (int)(mine_y[1]+90*mine_scale[1]), (int)(400*mine_scale[1]), (int)(400*mine_scale[1]))) {
                            mine_legs_rotate_2[1]-=2.5f;
                        }else{
                            mine_legs_rotate_2[1]-=2.5f/8f;
                        }
                        if(  mine_legs_rotate_2[1] <= -50f){
                            dir_rotate_2 = 1;
                        }
                    }
                    if(dir_rotate_3 == 1){
                        if(!ECheckCircle(mine_x[2], (int)(mine_y[1]+90*mine_scale[2]), (int)(400*mine_scale[2]), (int)(400*mine_scale[2]))) {
                            mine_legs_rotate_2[2]+=2.5f;
                        }else{
                            mine_legs_rotate_2[2]+=2.5f/8f;
                        }
                        if(mine_legs_rotate_2[2] >= 15f){
                            dir_rotate_3 = -1;
                        }
                    }else{
                        if(!ECheckCircle(mine_x[2], (int)(mine_y[2]+90*mine_scale[2]), (int)(400*mine_scale[2]), (int)(400*mine_scale[2]))) {
                            mine_legs_rotate_2[2]-=2.5f;
                        }else{
                            mine_legs_rotate_2[2]-=2.5f/8f;
                        }
                        if(  mine_legs_rotate_2[2] <= -50f){
                            dir_rotate_3 = 1;
                        }
                    }















                    if(Edir_rotate_1 == 1){
                        if(!CheckCircle(Emine_x[0], (int)(Emine_y[0]+90*Emine_scale[0]), (int)(400*Emine_scale[0]), (int)(400*Emine_scale[0]))) {
                            Emine_legs_rotate_2[0]+=2.5f;
                        }else{
                            Emine_legs_rotate_2[0]+=2.5f/8f;
                        }
                        if(Emine_legs_rotate_2[0] >= 15f){
                            Edir_rotate_1 = -1;
                        }
                    }else{
                        if(!CheckCircle(Emine_x[0], (int)(Emine_y[0]+90*Emine_scale[0]), (int)(400*Emine_scale[0]), (int)(400*Emine_scale[0]))) {
                            Emine_legs_rotate_2[0]-=2.5f;
                        }else{
                            Emine_legs_rotate_2[0]-=2.5f/8f;
                        }
                        if(  Emine_legs_rotate_2[0] <= -50f){
                            Edir_rotate_1 = 1;
                        }
                    }
                    if(Edir_rotate_2 == 1){
                        if(!CheckCircle(Emine_x[1], (int)(Emine_y[1]+90*Emine_scale[1]), (int)(400*Emine_scale[1]), (int)(400*Emine_scale[1]))) {
                            Emine_legs_rotate_2[1]+=2.5f;
                        }else{
                            Emine_legs_rotate_2[1]+=2.5f/8f;
                        }
                        if(Emine_legs_rotate_2[1] >= 15f){
                            Edir_rotate_2 = -1;
                        }
                    }else{
                        if(!CheckCircle(Emine_x[1], (int)(Emine_y[1]+90*Emine_scale[1]), (int)(400*Emine_scale[1]), (int)(400*Emine_scale[1]))) {
                            Emine_legs_rotate_2[1]-=2.5f;
                        }else{
                            Emine_legs_rotate_2[1]-=2.5f/8f;
                        }
                        if(  Emine_legs_rotate_2[1] <= -50f){
                            Edir_rotate_2 = 1;
                        }
                    }
                    if(Edir_rotate_3 == 1){
                        if(!CheckCircle(Emine_x[2], (int)(Emine_y[1]+90*Emine_scale[2]), (int)(400*Emine_scale[2]), (int)(400*Emine_scale[2]))) {
                            Emine_legs_rotate_2[2]+=2.5f;
                        }else{
                            Emine_legs_rotate_2[2]+=2.5f/8f;
                        }
                        if(Emine_legs_rotate_2[2] >= 15f){
                            Edir_rotate_3 = -1;
                        }
                    }else{
                        if(!CheckCircle(Emine_x[2], (int)(Emine_y[2]+90*Emine_scale[2]), (int)(400*Emine_scale[2]), (int)(400*Emine_scale[2]))) {
                            Emine_legs_rotate_2[2]-=2.5f;
                        }else{
                            Emine_legs_rotate_2[2]-=2.5f/8f;
                        }
                        if(  Emine_legs_rotate_2[2] <= -50f){
                            Edir_rotate_3 = 1;
                        }
                    }







                    Sleep(5);
                }
            }
        };
        Legs_2.start();
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

        ControlMove = new Thread() {
            @Override
            public void run() {
                    while(!closed) {
                        if(needMove) {
                            needMove=false;
                            if (control_pos_x > 150 && dir == -1) {
                                Redir();
                                continue;
                            }
                            if (control_pos_x < 150 && dir == 1) {
                                Redir();
                                continue;
                            }
                            if (control_pos_y > 150) {
                                Up();
                            }
                            if (control_pos_y < 150) {
                                Down();
                            }

                        }
                        if(move_control){
                            if(control_pos_x > 150) {
                                control_pos_x-=5;
                            }
                            if(control_pos_x < 150) {
                                control_pos_x+=5;
                            }
                            if(control_pos_y > 150) {
                                control_pos_y-=5;
                            }
                            if(control_pos_y < 150) {
                                control_pos_y+=5;
                            }

                        }
                        Sleep(5);
                    }
                }
        };
        ControlMove.start();
        FireAnime_1 = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while(i<10) {
                fire_anime_dir_1[i] = 1;
                    fire_anime_1[i] = 1;
                i++;
                }
                while (!closed) {
                    i = 0;
                    while(i<10) {
                        if (fire_anime_dir_1[i] == 1) {
                            fire_anime_1[i] += 1;
                            if (fire_anime_1[i] >= 5) {
                                fire_anime_dir_1[i] = 0;
                            }
                        } else {
                            fire_anime_1[i] -= 1;
                            if (fire_anime_1[i] <= 1) {
                                fire_anime_dir_1[i] = 1;
                            }
                        }
                        i++;
                    }

                        Sleep(50);

                }
            }
        };

        FireAnime_2 = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while(i<10) {
                    fire_anime_dir_2[i] = 1;
                    fire_anime_2[i] = 1;
                    i++;
                }
                while (!closed) {
                    i = 0;
                    while(i<10) {
                        if (fire_anime_dir_2[i] == 1) {
                            fire_anime_2[i] += 1;
                            if (fire_anime_2[i] >= 5) {
                                fire_anime_dir_2[i] = 0;
                            }
                        } else {
                            fire_anime_2[i] -= 1;
                            if (fire_anime_2[i] <= 1) {
                                fire_anime_dir_2[i] = 1;
                            }
                        }
                        i++;
                    }

                        Sleep(50);


                }
            }
        };
        FireAnime_3 = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while(i<10) {
                    fire_anime_dir_3[i] = 1;
                    fire_anime_3[i] = 1;
                    i++;
                }
                while (!closed) {
                    i = 0;
                    while(i<10) {
                        if (fire_anime_dir_3[i] == 1) {
                            fire_anime_3[i] += 1;
                            if (fire_anime_3[i] >= 5) {
                                fire_anime_dir_3[i] = 0;
                            }
                        } else {
                            fire_anime_3[i] -= 1;
                            if (fire_anime_3[i] <= 1) {
                                fire_anime_dir_3[i] = 1;
                            }
                        }
                        i++;
                    }

                        Sleep(50);

                }
            }
        };
        JetpackAnime = new Thread() {
            @Override
            public void run() {
                jetpack_anime=1;
                int dir_anime = 1;
                while (!closed) {
                    if(dir_anime==1){
                        jetpack_anime+=1;
                        if(jetpack_anime>=3){
                            dir_anime=0;
                        }
                    }else{
                        jetpack_anime-=1;
                        if(jetpack_anime<=1){
                            dir_anime=1;
                        }
                    }
                    if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale-(jetpack_state-30)*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale+(jetpack_state-30)*scale), (int)(535*scale))||game.robot.jetpack==1) {
                        Sleep(30);
                    }else{
                        Sleep(120);
                    }
                }
            }
        };
        EJetpackAnime = new Thread() {
            @Override
            public void run() {
                Ejetpack_anime=1;
                int dir_anime = 1;
                while (!closed) {
                    if(dir_anime==1){
                        Ejetpack_anime+=1;
                        if(Ejetpack_anime>=3){
                            dir_anime=0;
                        }
                    }else{
                        Ejetpack_anime-=1;
                        if(Ejetpack_anime<=1){
                            dir_anime=1;
                        }
                    }
                    if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale-(Ejetpack_state-30)*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale+(Ejetpack_state-30)*Escale), (int)(535*Escale))||game.robot.Ejetpack==1) {
                        Sleep(30);
                    }else{
                        Sleep(120);
                    }
                }
            }
        };
        /*PlanetAdd = new Thread() {
            @Override
            public void run() {
                x_planet = 300;
                while (!closed) {
                    x_planet += 1;
                    rotate_planet += 0.1;
                    if (rotate_planet >= 360.0) {
                        rotate_planet = 0.0f;
                    }
                    if (x_planet >= width + 1200) {
                        moreboom = true;
                        break;
                    }
                    Sleep(45);
                }
            }
        };*/
        space_anime = new Thread(){
            @Override
            public void run(){
                while(!closed){
                    location_2_planet_rotate+=0.3f;
                    if(location_2_planet_rotate>360.0f){
                        location_2_planet_rotate = 0.0f;
                    }
                    location_2_space_rotate-=0.2f;
                    if(location_2_space_rotate<0.0f){
                        location_2_space_rotate = 360.0f;
                    }
                    location_2_space_2_rotate-=0.1f;
                    if(location_2_space_2_rotate<0.0f){
                        location_2_space_2_rotate = 360.0f;
                    }
                    location_2_space_3_rotate-=0.3f;
                    if(location_2_space_3_rotate<0.0f){
                        location_2_space_3_rotate = 360.0f;
                    }
                    Sleep(60);
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

            if (game.robot.level == 2) {
                space_anime.start();
            }
            if (game.robot.level == 1) {
                PressAdd.start();
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
                game.music.setVolume(0.2f);
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
                    if(anime_begin<2) {
                        anime_begin++;
                    }else{
                        anime_begin = 0;
                    }

                    Sleep(100);
                }
            }
        };
        anime.start();
        Rain = new Thread() {
            @Override
            public void run() {
                for(int i=0;i<rain_quantity;i++){
                    rain_z[i] = game.random.nextInt(4);
                    rain_type[i] = game.random.nextInt(3)+1;
                    rain_x[i] = game.random.nextInt(width);
                    rain_y[i] = game.random.nextInt(height);
                    rain_dir_y[i] = -game.random.nextInt(3)-2;
                    rain_dir_x[i] = 0;
                }
                while(!closed){
                    for(int i=0;i<rain_quantity;i++){


                        if(!CheckCircle((int)rain_x[i], (int)rain_y[i], 10, 10) && !ECheckCircle((int)rain_x[i], (int)rain_y[i], 10, 10)) {
                            rain_x[i] +=  rain_dir_x[i];
                            rain_y[i] += rain_dir_y[i];
                        }else{
                            rain_x[i] +=  rain_dir_x[i]/8;
                            rain_y[i] += rain_dir_y[i]/8;
                        }
                        if(rain_x[i]>width){
                            rain_x[i] = 0;
                        }
                        if(rain_x[i]<0){
                            rain_x[i] = width;
                        }
                        if(rain_y[i]>height){
                            rain_y[i] = 0;
                        }
                        if(rain_y[i]<0){
                            rain_y[i] = height;
                        }
                    }
                            Sleep(10);
                }
            }
        };
        if(game.robot.level == 5) {
            Rain.start();
        }
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
                            if(!CheckCircle(med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60-10*med_y, med_scale, med_scale) && !ECheckCircle(med_x * (width / 10) - med_scale / 2 + 70, med_y * (height / 5) - 60-10*med_y, med_scale, med_scale)) {
                                Sleep(70);
                            }else{
                                Sleep(560);
                            }
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
                            boom_height += 100;
                            Sleep(5);
                        }
                        boom_height = height;
                        boom.play();
                        CheckBoom();
                        boom_flip = game.random.nextInt(2);
                        if(boom_flip == 0){
                            boom_flip = -1;
                        }
                        int dir_boom = 0;
                        int dir_boom_front = 0;
                        while (boom_value != 35) {
                            boom_value += 1;

                            if(dir_boom_front == 0){
                                boom_front_anime++;
                                        if(boom_front_anime > 1){
                                            dir_boom_front = 1;
                                        }
                                        if(boom_front_anime == 3){
                                            boom_front_anime = 2;
                                        }
                            }else{
                                boom_front_anime--;
                                if(boom_front_anime < 1){
                                    dir_boom_front = 0;
                                }
                            }
                            if(dir_boom == 0) {
                                boom_anime++;
                                if (boom_anime > 6) {
                                    boom_anime = 6;
                                    dir_boom = 1;
                                }
                            }else{
                                boom_anime--;
                                if (boom_anime < 1) {
                                    boom_anime=1;
                                    dir_boom = 0;
                                    boom_flip = game.random.nextInt(2);
                                    if(boom_flip == 0){
                                        boom_flip = -1;
                                    }
                                }
                            }
                            CheckBoom();
                            Sleep(25);
                        }
                        while (boom_height > 0) {
                            boom_height -= 100;
                            Sleep(5);
                        }
                        boom_height = 0;
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
        Thread Grass_anime = new Thread() {
            @Override
            public void run() {

                int grass_dir_2 = 0;
                //Указание направления анимации. Типо реверс.

                while (true) {
                    if (game.robot.level != 1) {


                        for (int i = 0; i < 10; i++) {
                            if (!CheckCircle(grass_1[i] * (width / 10), (height / 5) - 70 - 15, 150, 150) && !ECheckCircle(grass_1[i] * (width / 10), (height / 5) - 70 - 15, 150, 150)) {
                                grass_1_anime[i] += 0.5f * grass_1_dir[i];
                            } else {
                                grass_1_anime[i] += 0.5f / 8 * grass_1_dir[i];
                            }
                            if (!CheckCircle(grass_2[i] * (width / 10), (height / 5) * 2 - 70 - 15 * 2, 150, 150) && !ECheckCircle(grass_1[i] * (width / 10), (height / 5) - 70 - 15, 150, 150)) {
                                grass_2_anime[i] += 0.5f * grass_2_dir[i];
                            } else {
                                grass_2_anime[i] += 0.5f / 8 * grass_2_dir[i];
                            }
                            if (!CheckCircle(grass_3[i] * (width / 10), (height / 5) * 3 - 70 - 15 * 3, 150, 150) && !ECheckCircle(grass_3[i] * (width / 10), (height / 5) * 3 - 70 - 15 * 3, 150, 150)) {
                                grass_3_anime[i] += 0.5f * grass_3_dir[i];
                            } else {
                                grass_3_anime[i] += 0.5f / 8 * grass_3_dir[i];
                            }

                            if (grass_1_anime[i] >= 5.0f) {
                                grass_1_dir[i] = -1;
                            }
                            if (grass_1_anime[i] <= -5.0f) {
                                grass_1_dir[i] = 1;
                            }
                            if (grass_2_anime[i] >= 5.0f) {
                                grass_2_dir[i] = -1;
                            }
                            if (grass_2_anime[i] <= -5.0f) {
                                grass_2_dir[i] = 1;
                            }
                            if (grass_3_anime[i] >= 5.0f) {
                                grass_3_dir[i] = -1;
                            }
                            if (grass_3_anime[i] <= -5.0f) {
                                grass_3_dir[i] = 1;
                            }
                        }


                        if (grass_dir_2 == 1) {
                            anime_grass += 0.5f;
                            if (anime_grass >= 5.0) {
                                grass_dir_2 = 0;
                            }
                        } else {
                            anime_grass -= 0.5f;
                            if (anime_grass <= -5.0) {
                                grass_dir_2 = 1;
                            }
                        }
                    }
                    if (closed) {
                        break;
                    }
                    Sleep((int) (15 * speed));
                }
            }
            };
        Grass_anime.start();
            anime = new Thread() {
                @Override
                public void run() {
                    int dir = 2;
                    int time = game.random.nextInt(10) + 10;
                    while(true){
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
                        if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale), (int)(535*scale))) {
                            Sleep((int) (time * speed));
                        }else{
                            Sleep((int) (time * speed)*4);
                        }
                    } else {
                        if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale), (int)(535*scale))) {
                            Sleep((int) (time/2 * speed));
                        }else{
                            Sleep((int) (time/2 * speed)*4);
                        }
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
                if(game.robot.level == 5){
                    location_name_1 = "Снежное";
                    location_name_2 = "Поле";
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
                        if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale), (int)(535*Escale))) {
                            Sleep((int) (Etime * speed));
                        }else{
                            Sleep((int) (Etime * speed)*4);
                        }
                    } else {
                        if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale), (int)(535*Escale))) {
                            Sleep((int) (Etime/2 * speed));
                        }else{
                            Sleep((int) (Etime/2 * speed)*4);
                        }
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












        FriendBrine = new Thread() {
            @Override
            public void run() {
                boolean run_away = false;
                int steps_run = 0;
                int steps_to_run = 30;
                Sleep((int) (5000 * speed));
                while (true) {
                    if (!pause) {
                        if(!run_away){
                            int random_act = game.random.nextInt(28) + 1;
                            if (random_act < 11 && random_act > 0) {
                                if (CheckBulletInPlace(x, y, 800)) {
                                    int index = 0;
                                    if (bullets > 0) {
                                        while (index < 40) {
                                            if (Math.abs((float) bullets_x[index] - (float) (x * width / 10)) < 150) {
                                                SmallPower();


                                            }
                                            index++;
                                        }
                                    }
                                    int move_dir = game.random.nextInt(2) - 1;
                                    if (y - 1 > 0 && move_dir == -1) {
                                        if(dir == 1) {
                                            if (x + 1 != Ex || y - 1 != Ey || x!=8) {
                                                Down();
                                            }
                                        }else{
                                            if (x - 1 != Ex || y - 1 != Ey || x!=2) {
                                                Down();
                                            }
                                        }
                                    }
                                    if (y + 1 < 4 && move_dir == 0) {
                                        if(dir == 1) {
                                            if (x + 1 != Ex || y + 1 != Ey || x!=8) {
                                                Up();
                                            }
                                        }else{
                                            if (x - 1 != Ex || y + 1 != Ey || x!=2) {
                                                Up();
                                            }
                                        }
                                    }
                                }
                            }
                            if (random_act < 13 && random_act > 10) {
                                if (Math.abs((x * width / 10 + robot_x) - (Ex * width / 10 + Erobot_x)) > 75 && ((dir == -1 && (x * width / 10 + robot_x) < (Ex * width / 10 + Erobot_x)) || (dir == 1 && (x * width / 10 + robot_x) > (Ex * width / 10 + Erobot_x)))) {
                                    Redir();
                                }
                            }
                            if (random_act < 16 && random_act > 13) {
                                int move_dir = game.random.nextInt(2) - 1;
                                if (y - 1 > 0 && move_dir == -1) {
                                    if(dir == 1) {
                                        if (x + 1 != Ex || y - 1 != Ey || x!=8) {
                                            if(!CheckBulletInPlace(x, y-1, 400)) {
                                                Down();
                                            }
                                        }
                                    }else{
                                        if (x - 1 != Ex || y - 1 != Ey || x!=2) {
                                            if(!CheckBulletInPlace(x, y-1, 400)) {
                                                Down();
                                            }
                                        }
                                    }
                                }
                                if (y + 1 < 4 && move_dir == 0) {
                                    if(dir == 1) {
                                        if (x + 1 != Ex || y + 1 != Ey || x!=8) {
                                            if(!CheckBulletInPlace(x, y+1, 400)) {
                                                Up();
                                            }
                                        }
                                    }else{
                                        if (x - 1 != Ex || y + 1 != Ey || x!=2) {
                                            if(!CheckBulletInPlace(x, y+1, 400)) {
                                                Up();
                                            }
                                        }
                                    }
                                }
                            }
                            if (random_act < 19 && random_act > 16) {
                                int move_dir = game.random.nextInt(10) + 1;
                                if (move_dir == 3) {
                                    Redir();
                                }
                                if (move_dir < 3) {
                                    Fire();
                                }
                                if (move_dir == 10) {
                                    SmallPower();
                                }
                            }
                            if (random_act > 20 && random_act < 27) {
                                if (y == Ey && ((dir == -1 && (x * width / 10 + robot_x) > (Ex * width / 10 + Erobot_x)) || (dir == 1 && (x * width / 10 + robot_x) < (Ex * width / 10 + Erobot_x)))) {
                                    Fire();
                                }
                            }
                            if (random_act == 20) {
                                if (Math.abs((((float) x * (float) width / (float) 10) + robot_x) - (((float) Ex * (float) width / (float) 10) + Erobot_x)) <= 250.0) {
                                    int move_dir = game.random.nextInt(3) + 1;
                                    if (move_dir == 3) {
                                        if (energy >= 50) {
                                            SmallPower();
                                        }
                                    }
                                }
                            }
                            if (random_act == 27) {
                                if ((Ex > x && dir == 1) || (Ex < x && dir == -1)) {
                                    LargePower();
                                }else{
                                    int rand = game.random.nextInt(3) + 1;
                                    if(rand == 1) {
                                        Fire();
                                    }
                                }
                            }
                            if(random_act == 28){
                                boolean detect_fire = false;
                                if(y == 1 && fire_x_1[x] == 1){
                                    detect_fire = true;
                                }
                                if(y == 2 && fire_x_2[x] == 1){
                                    detect_fire = true;
                                }
                                if(y == 3 && fire_x_3[x] == 1){
                                    detect_fire = true;
                                }
                                if ((x == will_meteor_x && y == will_meteor_y) || detect_fire) {
                                    int move = game.random.nextInt(5);
                                    if(move == 0){
                                        Down();
                                    }
                                    if(move == 1){
                                        Up();
                                    }
                                }
                            }
                            int distance = Math.abs(x - Ex) + Math.abs(y - Ey);
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
                            if (!(Math.abs((x * width / 10 + robot_x) - (Ex * width / 10 + Erobot_x)) > 75 && ((dir == -1 && (x * width / 10 + robot_x) < (Ex * width / 10 + Erobot_x)) || (dir == 1 && (x * width / 10 + robot_x) > (Ex * width / 10 + Erobot_x))))) {
                                Redir();
                            }
                            if(CheckBulletInPlace(x, y, 800)){
                                int random_act = game.random.nextInt(2) + 1;
                                if(random_act == 1 && y - 1 > 0){
                                    if(dir == 1) {
                                        if (x + 1 != Ex || y - 1 != Ey || x!=8) {
                                            Down();
                                        }
                                    }else{
                                        if (x - 1 != Ex || y - 1 != Ey || x!=2) {
                                            Down();
                                        }
                                    }
                                }
                                if(random_act == 2 && y + 1 < 4){
                                    if(dir == 1) {
                                        if (x + 1 != Ex || y + 1 != Ey || x!=8) {
                                            Up();
                                        }
                                    }else{
                                        if (x - 1 != Ex && y + 1 != Ey && x!=2) {
                                            Up();
                                        }
                                    }
                                }
                            }
                            int random_act = game.random.nextInt(5) + 1;
                            if(random_act == 1 && y - 1 > 0){
                                if(dir == 1) {
                                    if (x + 1 != Ex || y - 1 != Ey || x!=8) {
                                        Down();
                                    }
                                }else{
                                    if (x - 1 != Ex || y - 1 != Ey || x!=2) {
                                        Down();
                                    }
                                }
                            }
                            if(random_act == 2 && y + 1 < 4){
                                if(dir == 1) {
                                    if (x + 1 != Ex || y + 1 != Ey || x!=8) {
                                        Up();
                                    }
                                }else{
                                    if (x - 1 != Ex || y + 1 != Ey || x!=2) {
                                        Up();
                                    }
                                }
                            }
                            if(random_act == 3){
                                SmallPower();
                            }
                            if(random_act == 4){
                                LargePower();
                            }
                            if(random_act == 5){
                                Fire();
                            }
                        }
                        if (closed) {
                            break;
                        }
                        Sleep((int) ((game.robot.energy_speed-15) * speed));
                    }
                }
            }
        };
        if(game.autoplay_enabled) {
            FriendBrine.start();
        }


















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
                        int random_act = game.random.nextInt(28) + 1;
                        if (random_act < 11 && random_act > 0) {
                            if (CheckBulletInPlace(Ex, Ey, 800)) {
                                int index = 0;
                                if (bullets > 0) {
                                    while (index < 40) {
                                        if (Math.abs((float) bullets_x[index] - (float) (Ex * width / 10)) < 150) {
                                            ESmallPower();
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
                                        if(!CheckBulletInPlace(Ex, Ey-1, 400)) {
                                            EDown();
                                        }
                                    }
                                }else{
                                    if (Ex - 1 != x || Ey - 1 != y || Ex!=2) {
                                        if(!CheckBulletInPlace(Ex, Ey-1, 400)) {
                                            EDown();
                                        }
                                    }
                                }
                            }
                            if (Ey + 1 < 4 && move_dir == 0) {
                                if(Edir == 1) {
                                    if (Ex + 1 != x || Ey + 1 != y || Ex!=8) {
                                        if(!CheckBulletInPlace(Ex, Ey+1, 400)) {
                                            EUp();
                                        }
                                    }
                                }else{
                                    if (Ex - 1 != x || Ey + 1 != y || Ex!=2) {
                                        if(!CheckBulletInPlace(Ex, Ey+1, 400)) {
                                            EUp();
                                        }
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
                                ESmallPower();
                            }
                        }
                        if (random_act > 20 && random_act < 27) {
                            if (Ey == y && ((Edir == -1 && (Ex * width / 10 + Erobot_x) > (x * width / 10 + robot_x)) || (Edir == 1 && (Ex * width / 10 + Erobot_x) < (x * width / 10 + robot_x)))) {
                                EFire();
                            }
                        }
                        if (random_act == 20) {
                            if (Math.abs((((float) Ex * (float) width / (float) 10) + Erobot_x) - (((float) x * (float) width / (float) 10) + robot_x)) <= 250.0) {
                                int move_dir = game.random.nextInt(3) + 1;
                                if (move_dir == 3) {
                                    if (Eenergy >= 50) {
                                        ESmallPower();
                                    }
                                }
                            }
                        }
                        if (random_act == 27) {
                            if ((x > Ex && Edir == 1) || (x < Ex && Edir == -1)) {
                                ELargePower();
                            }else{
                                int rand = game.random.nextInt(3) + 1;
                                if(rand == 1) {
                                    EFire();
                                }
                            }
                        }
                        if(random_act == 28){
                            boolean detect_fire = false;
                            if(Ey == 1 && fire_x_1[Ex] == 1){
                                detect_fire = true;
                            }
                            if(Ey == 2 && fire_x_2[Ex] == 1){
                                detect_fire = true;
                            }
                            if(Ey == 3 && fire_x_3[Ex] == 1){
                                detect_fire = true;
                            }
                            if ((Ex == will_meteor_x && Ey == will_meteor_y) || detect_fire) {
                                int move = game.random.nextInt(5);
                                if(move == 0){
                                    EDown();
                                }
                                if(move == 1){
                                    EUp();
                                }
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
                                if(CheckBulletInPlace(Ex, Ey, 800)){
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
                                    ESmallPower();
                                }
                                if(random_act == 4){
                                   ELargePower();
                                }
                                if(random_act == 5){
                                   EFire();
                                 }
                        }
                        if (closed) {
                            break;
                        }
                        Sleep((int) ((game.robot.Eenergy_speed-15) * speed));
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
                        if(EturnedLarge < MEturnedLarge){
                            ELargePower();
                        }
                        if(EturnedSmall < MEturnedSmall){
                            ESmallPower();
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
                FireAnime_1.start();
                FireAnime_2.start();
                FireAnime_3.start();
                JetpackAnime.start();
                EJetpackAnime.start();
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
            FireAnime_1.start();
            FireAnime_2.start();
            FireAnime_3.start();
            JetpackAnime.start();
            EJetpackAnime.start();
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
     game.robot.UpdateTextures();
        if(game.robot.level !=2) {
            boom_front[0] = new Texture("Interface/white_flash_1.png");
            boom_front[1] = new Texture("Interface/white_flash_2.png");
            boom_front[2] = new Texture("Interface/white_flash_3.png");
        }else{
            boom_front[0] = new Texture("Interface/green_flash_1.png");
            boom_front[1] = new Texture("Interface/green_flash_2.png");
            boom_front[2] = new Texture("Interface/green_flash_3.png");
        }
        if (game.robot.level != 2) {
            booms[0] = new Texture("Object/energy_1.png");
            booms[1] = new Texture("Object/energy_2.png");
            booms[2] = new Texture("Object/energy_3.png");
            booms[3] = new Texture("Object/energy_4.png");
            booms[4] = new Texture("Object/energy_5.png");
            booms[5] = new Texture("Object/energy_6.png");
            booms[6] = new Texture("Object/energy_7.png");
        } else {
            booms[0] = new Texture("Object/energy_1_2.png");
            booms[1] = new Texture("Object/energy_2_2.png");
            booms[2] = new Texture("Object/energy_3_2.png");
            booms[3] = new Texture("Object/energy_4_2.png");
            booms[4] = new Texture("Object/energy_5_2.png");
            booms[5] = new Texture("Object/energy_6_2.png");
            booms[6] = new Texture("Object/energy_7_2.png");
        }
        if(game.robot.level!=2 && game.robot.level!=5) {
            fire_location[0] = new Texture("Object/fire_" + game.robot.level + "_1.png");
            fire_location[1] = new Texture("Object/fire_" + game.robot.level + "_2.png");
            fire_location[2] = new Texture("Object/fire_" + game.robot.level + "_3.png");
            fire_location[3] = new Texture("Object/fire_" + game.robot.level + "_4.png");
            fire_location[4] = new Texture("Object/fire_" + game.robot.level + "_5.png");
        }
        if(game.robot.level == 5){
            fire_location[0] = new Texture("Object/fire_3_1.png");
            fire_location[1] = new Texture("Object/fire_3_2.png");
            fire_location[2] = new Texture("Object/fire_3_3.png");
            fire_location[3] = new Texture("Object/fire_3_4.png");
            fire_location[4] = new Texture("Object/fire_3_5.png");
        }
        Frontcolor = new Texture("Interface/frontground_color_" + game.robot.level + ".png");
        big_grass= new Texture("Location/grass_" + game.robot.level + "_2.png");
        if (game.robot.level == 2) {
            planett = new Texture("Object/planet_3.png");
            planet = new TextureRegion(planett, 400, 400);
            FrontLevel2 = new Texture("Location/background_2_front.png");
            FrontLevel2_region = new TextureRegion(FrontLevel2, 1280, 720);
        }
        if (game.robot.level == 4) {

            FrontLevel2 = new Texture("Location/background_4_front.png");
        }

        Splash = new Texture("Object/splash_" + game.robot.level + ".png");


        if (game.robot.opened < game.robot.max_skin) {
            gift_index = game.random.nextInt(game.robot.max_skin-1)+1;
            puck = new Texture("Object/gift_" + gift_index + ".png");
            puck_swap = new Texture("Object/gift_swap.png");
        }
        if (game.robot.level != 1) {
            Rocket = new Texture("Object/rocket.png");
        } else {
            DownPress = new Texture("Object/down_press.png");
            UpPress = new Texture("Object/up_press.png");
            Rocket = new Texture("Object/rocket_2.png");
        }
        if(game.robot.level !=2 && game.robot.level != 4){
            Fire = new Texture("Object/fire.png");
        }
        if(game.robot.level == 4){
            Fire = new Texture("Object/fire_2.png");
        }
        if(game.robot.level == 2){
            Fire = new Texture("Object/fire_3.png");
        }
        grass = new Texture("Location/grass_" + game.robot.level + ".png");
        Meteort = new Texture("Location/meteor_" + game.robot.level + ".png");
        Meteor = new TextureRegion(Meteort, 300, 300);
        jetpack = new Texture("Button/button_2_" + (2+(2-game.robot.jetpack)) + "_1.png");
        background = new Texture("Location/background_" + game.robot.level + ".png");
        if(game.robot.level == 2){
            background_region = new TextureRegion(background, 1280, 720);
        }
        floor = new Texture("Location/grass_alpha_" + game.robot.level + ".png");
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        if(game.robot.level == 2){
         /*   drawer.draw(background, (int)x_planet-width, 0, width, height);
            drawer.draw(background, (int)x_planet-width*2, 0, width, height);
            drawer.draw(background, (int)x_planet, 0, width, height);
            drawer.draw(FrontLevel2, (int)(x_planet*1.15)-width, 0, width, height);
            drawer.draw(FrontLevel2, (int)(x_planet*1.30), 0, width, height);
            drawer.draw(planet,  (width+100-x_planet), height-500, (float) (300), (float) (300), (float) (600), (float) (600), 1, 1,  rotate_planet, true);
        */



            drawer.draw(background_region, 0,0, 0, 0, width, height, 1, 1, 0);
            drawer.draw(background_region, -width/2.0f,-height/2.0f, width, height, width*2.0f, height*2.0f, 1, 1,  location_2_space_rotate, true);
            drawer.draw(FrontLevel2_region, -width/2.0f,-height/2.0f, width, height, width*2.0f, height*2.0f, 1, 1,  location_2_space_2_rotate, true);
            drawer.draw(FrontLevel2_region, -width/2.0f,-height/2.0f, width, height, width*2.0f, height*2.0f, 1, 1,  location_2_space_3_rotate, true);
            drawer.draw(planet, width/2+100, height/2-200, 300, 300, 600, 600, 1, 1,  location_2_planet_rotate, true);
        }else {
            if (game.robot.level == 4) {
                drawer.draw(background, 0, (int) anime_grass/1.75f+5, width, height);
                drawer.draw(FrontLevel2, 0, (int) -anime_grass/1.25f, width, height);
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
                    if(game.robot.level != 2 && game.robot.level != 5) {
                        drawer.draw(grass, grass_3[i] * (width / 10), (height / 5) * 3 - 70 - 15 * 3, 150 * grass_3_scale[i], (int) (150 * grass_3_scale[i] + grass_3_anime[i]));
                    }else{
                        drawer.draw(grass, grass_3[i] * (width / 10), (height / 5) * 3 - 70 - 15 * 3, 150 * grass_3_scale[i], (int) (150 * grass_3_scale[i]));
                    }
                } else {

                        drawer.draw(big_grass, grass_3[i] * (width / 10) - 25, (height / 5) * 3 - 90 - 15 * 3, 200 * grass_3_scale[i], (int) (200 * grass_3_scale[i] - grass_3_anime[i]));

                }
            }
            i++;
        }
        i = 0;
       if(game.robot.level != 2) {
          while (i != 10) {
             if (fire_state_3[i] != 0) {
                drawer.draw(fire_location[fire_anime_3[i] - 1], i * (width / 10) + ((width / 10) - fire_state_3[i]) / 2, (height / 5) * 3 - 80 - 15 * 3, fire_state_3[i], fire_state_3[i]);
             }
             i++;
          }
       }

        i = 0;
        if(game.robot.level == 5) {
            while (i != rain_quantity) {
                if (rain_z[i] == 3) {
                    drawer.draw(rain[rain_type[i] - 1], rain_x[i], rain_y[i], 60 / (rain_z[i] + 2), 60 / (rain_z[i] + 2));
                }
                i++;
            }
        }
        if(will_meteor_y == 3 && meteor_run){
            if(!meteor_splash) {
                if(!meteor_rocket) {
                    if( game.robot.level != 1 && game.robot.level != 2 && game.robot.level != 5) {
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
                    if(game.robot.level != 2 && game.robot.level != 5) {
                        drawer.draw(grass, grass_2[i] * (width / 10), (height / 5) * 2 - 70 - 15 * 2, 150 * grass_2_scale[i], (int) (150 * grass_2_scale[i] + grass_2_anime[i]));
                    }else{
                        drawer.draw(grass, grass_2[i] * (width / 10), (height / 5) * 2 - 70 - 15 * 2, 150 * grass_2_scale[i], (int) (150 * grass_2_scale[i]));
                    }
                } else {
                    drawer.draw(big_grass, grass_2[i] * (width / 10) - 25, (height / 5) * 2 - 90 - 15 * 2, 200*grass_2_scale[i], (int) (200*grass_2_scale[i] - grass_2_anime[i]));
                }
            }
            i++;
        }
        i = 0;
        if(game.robot.level != 2) {
           while (i != 10) {
              if (fire_state_2[i] != 0) {
                 drawer.draw(fire_location[fire_anime_2[i] - 1], i * (width / 10) + ((width / 10) - fire_state_2[i]) / 2, (height / 5) * 2 - 80 - 20 * 2, fire_state_2[i], fire_state_2[i]);
              }
              i++;
           }
        }
        if(game.robot.level == 5) {
            while (i != rain_quantity) {
                if (rain_z[i] == 2) {
                    drawer.draw(rain[rain_type[i] - 1], rain_x[i], rain_y[i], 60 / (rain_z[i] + 2), 60 / (rain_z[i] + 2));
                }
                i++;
            }
        }
        if(will_meteor_y == 2 && meteor_run){
            if(!meteor_splash) {
                if(!meteor_rocket) {
                    if( game.robot.level != 1 && game.robot.level != 2 && game.robot.level != 5) {
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
        i = 0;
        while(i!=10){
            if(grass_1_type[i]!=0) {
                if (grass_1_type[i] != 1) {
                    if(game.robot.level != 2 && game.robot.level != 5) {
                        drawer.draw(grass, grass_1[i] * (width / 10), (height / 5)  - 70 - 15, 150 * grass_1_scale[i], (int) (150 * grass_1_scale[i] + grass_1_anime[i]));
                    }else{
                        drawer.draw(grass, grass_1[i] * (width / 10), (height / 5) - 70 - 15, 150 * grass_1_scale[i], (int) (150 * grass_1_scale[i]));
                    }
                } else {
                    drawer.draw(big_grass, grass_1[i] * (width / 10) - 25, (height / 5) - 90 - 15, 200*grass_1_scale[i], (int) (200*grass_1_scale[i] - grass_1_anime[i]));
                }
            }
            i++;
        }
        i = 0;
       if(game.robot.level != 2) {
          while (i != 10) {
             if (fire_state_1[i] != 0) {
                drawer.draw(fire_location[fire_anime_1[i] - 1], i * (width / 10) + ((width / 10) - fire_state_1[i]) / 2, (height / 5) - 80 - 30, fire_state_1[i], fire_state_1[i]);
             }
             i++;
          }
       }
        if(game.robot.level == 5) {
            while (i != rain_quantity) {
                if (rain_z[i] == 1) {
                    drawer.draw(rain[rain_type[i] - 1], rain_x[i], rain_y[i], 60 / (rain_z[i] + 2), 60 / (rain_z[i] + 2));
                }
                i++;
            }
        }
        if(will_meteor_y == 1 && meteor_run){
            if(!meteor_splash) {
                if(!meteor_rocket) {
                    if( game.robot.level != 1 && game.robot.level != 2 && game.robot.level != 5) {
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
        if(mine_clicked) {
            for(int num = 0;num<3;num++) {
                if(mine_exist[num]!=3 && mine_exist[num]!=0) {
                    DrawLegs(drawer, mine_x[num] + (int) (200 * mine_scale[num] - 200 * leg_scale[num] * mine_scale[num]), mine_y[num] + (int) ((1.0f - leg_scale[num]) * 325 * mine_scale[num]), mine_scale[num] * leg_scale[num], 400 * mine_scale[num] * leg_scale[num], mine_legs_rotate_1[num], mine_legs_rotate_2[num]);
                }
                if(mine_exist[num]!=3) {
                    if(mine_exist[num]!=0) {
                        if(mine_exist[num] == 2) {
                            drawer.draw(mine, mine_x[num], mine_y[num] + 90 * mine_scale[num], mine_scale[num] * 400, mine_scale[num] * 400);

                        }else{
                            drawer.draw(mine_off, mine_x[num], mine_y[num] + 90 * mine_scale[num], mine_scale[num] * 400, mine_scale[num] * 400);
                        }
                    }
                    }
            }
        }


        if(Emine_clicked) {
            for(int num = 0;num<3;num++) {
                if(Emine_exist[num]!=3 && Emine_exist[num]!=0) {
                    DrawLegs(drawer, Emine_x[num] + (int) (200 * Emine_scale[num] - 200 * Eleg_scale[num] * Emine_scale[num]), Emine_y[num] + (int) ((1.0f - Eleg_scale[num]) * 325 * Emine_scale[num]), Emine_scale[num] * Eleg_scale[num], 400 * Emine_scale[num] * Eleg_scale[num], Emine_legs_rotate_1[num], Emine_legs_rotate_2[num]);
                }
                if(Emine_exist[num]!=3) {
                    if(Emine_exist[num]!=0) {
                        if(Emine_exist[num] == 2) {
                            drawer.draw(mine, Emine_x[num], Emine_y[num] + 90 * Emine_scale[num], Emine_scale[num] * 400, Emine_scale[num] * 400);

                        }else{
                            drawer.draw(mine_off, Emine_x[num], Emine_y[num] + 90 * Emine_scale[num], Emine_scale[num] * 400, Emine_scale[num] * 400);
                        }
                    }
                }
            }
        }

        if(saw_clicked){

            int m = 0, n;
            while(m<3) {
                if (saws[m]!=0) {
                    n = 2;
                    while (n > -1) {

                        drawer.draw(saw[n], saws_pos_x[m * 3 + n], saws_pos_y[m * 3 + n], 100, 100, 200, 200, 1, 1, saws[m]*saws_rotate[m * 3 + n]);

                        n--;
                    }
                }
                m++;
            }
        }


        if(Esaw_clicked){

            int m = 0, n;
            while(m<3) {
                if (Esaws[m]!=0) {
                    n = 2;
                    while (n > -1) {

                        drawer.draw(Esaw[n], Esaws_pos_x[m * 3 + n], Esaws_pos_y[m * 3 + n], 100, 100, 200, 200, 1, 1, Esaws[m]*Esaws_rotate[m * 3 + n]);

                        n--;
                    }
                }
                m++;
            }
        }
        if(plasma_clicked){
           drawer.draw(plasma_tail, plasma_x+50*plasma_scale, plasma_y, 100*plasma_scale*(-plasma_dir)*4, 100*plasma_scale);
           drawer.draw(plasma_ball, plasma_x, plasma_y, 100*plasma_scale, 100*plasma_scale);
        }
        if (Epull_clicked) {
            DrawPull(drawer, Epulls_x[0], Epulls_y[0] - 60 - 10 * Ey, Epulls_x[1], Epulls_y[1] - 60 - 10 * Ey, Epulls_x[2], Epulls_y[2] - 60 - 10 * Ey, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, 0 );
        }
        if (pull_clicked) {
            DrawPull(drawer, pulls_x[0], pulls_y[0] - 60 - 10 * y, pulls_x[1], pulls_y[1] - 60 - 10 * y, pulls_x[2], pulls_y[2] - 60 - 10 * y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, 0 );
        }

        int index = 0;
        if(bullets>0) {
            while (index < 50) {
                if ((bullets_dir[index] != 0 || bullets_size[index]!=0) && (Math.round(bullets_y[index]) == 3.0 || Math.round(bullets_y[index]) == 4.0)) {
                    DrawBullet(drawer, bullets_x[index], (int)((height/5)*bullets_y[index]-15*bullets_y[index]+190), bullets_type[index], bullets_size[index], bullets_dir[index]);
                }
                index++;
            }
        }
       if(Ey == 3) {
            if(Eball_state<0.4f) {
                DrawEnergyCircle(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eenergy_circle_size, Erobot_circle, Edead);

            }
            if (!Ejetpack_clicked) {
                if (!Eball_clicked) {
                    if (!Erobotboom) {
                        DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                    } else {

                        DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x - boom_anime * 3, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y - boom_anime * 3, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                    }
                } else {
                    DrawEnemyBall(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eball_state, Edir);
                }
            }else{
                if(!Edead) {
                    DrawEnemyJetpack(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, 0, 0, Ejetpack_anime, Ejetpack_state, Eswap, Ehurt);
                }else{
                    DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, true);

                }
            }
            }



        if(y == 3) {
            if(ball_state<0.4f) {
                DrawEnergyCircle(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, energy_circle_size, robot_circle, dead);
            }
            if (!jetpack_clicked) {
                if (!ball_clicked) {
                    if (!robotboom) {
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    } else {
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x - boom_anime * 3, (height / 5) * y - 60 - 10 * y + (int) robot_y - boom_anime * 3, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    }
                } else {
                    DrawRobotBall(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, ball_state, dir);
                }
            }else{
                if(!dead){
                    DrawRobotJetpack(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, 0, 0, jetpack_anime, jetpack_state, swap, hurt);
                }else{
                    DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, true, 0);
                }
            }
        }
        if(isboom && boom_y == 3){
            drawer.draw(booms[boom_anime-1], boom_x*(width/10)-275*boom_flip,  (height/5)*boom_y-60-45*boom_y+(height-boom_height), 550*boom_flip, boom_height);
        }
        if(meteor_run && will_meteor_y == 3 && game.robot.draw_interface) {
            drawer.draw(game.robot.Cross, meteor_x + (150-cross_size)/2, will_meteor_y * (height / 5) - 60 - 10 * will_meteor_y, cross_size, cross_size);
        }
        index = 0;
        if(bullets>0) {
            while (index < 50) {
                if ((bullets_dir[index] != 0 || bullets_size[index]!=0) && Math.round(bullets_y[index]) == 2.0) {
                    DrawBullet(drawer, bullets_x[index], (int)((height/5)*bullets_y[index]-15*bullets_y[index]+190), bullets_type[index], bullets_size[index], bullets_dir[index]);
                }
                index++;
            }
        }
        if(Ey == 2){
            if(Eball_state<0.4f) {
                DrawEnergyCircle(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eenergy_circle_size, Erobot_circle, Edead);
            }
            if(!Ejetpack_clicked) {
                if (!Eball_clicked) {
                    if (!Erobotboom) {
                        DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                    } else {

                        DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x - boom_anime * 3, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y - boom_anime * 3, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                    }
                } else {
                    DrawEnemyBall(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eball_state, Edir);
                }
            }else{
                if(!Edead) {
                    DrawEnemyJetpack(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, 0, 0, Ejetpack_anime, Ejetpack_state, Eswap, Ehurt);
                }else{
                    DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, true);

                }
            }
        }
        if(y == 2) {
            if(ball_state<0.4f) {
                DrawEnergyCircle(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, energy_circle_size, robot_circle, dead);
            }
                if (!jetpack_clicked) {
                if (!ball_clicked) {
                    if (!robotboom) {
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    } else {

                        DrawRobot(drawer, x * (width / 10) + (int) robot_x - boom_anime * 3, (height / 5) * y - 60 - 10 * y + (int) robot_y - boom_anime * 3, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    }
                } else {
                    DrawRobotBall(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, ball_state, dir);
                }
            }else {
                    if (!dead) {
                        DrawRobotJetpack(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, 0, 0, jetpack_anime, jetpack_state, swap, hurt);
                    }else{
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, true, 0);
                    }
                }
        }

        if(isboom && boom_y == 2){
            drawer.draw(booms[boom_anime-1], boom_x*(width/10)-275*boom_flip,  (height/5)*boom_y-60-10*boom_y+(height-boom_height), 550*boom_flip, boom_height);
        }
        if(meteor_run && will_meteor_y == 2 && game.robot.draw_interface) {
            drawer.draw(game.robot.Cross, meteor_x + (150-cross_size)/2, will_meteor_y * (height / 5) - 60 - 10 * will_meteor_y, cross_size, cross_size);
        }
        index = 0;
        if(bullets>0) {
            while (index < 50) {
                if ((bullets_dir[index] != 0 || bullets_size[index]!=0) && ((Math.round(bullets_y[index]) == 1.0) || (bullets_y[index] > 0 && bullets_y[index] < 1))) {
                    DrawBullet(drawer, bullets_x[index], (int)((height/5)*bullets_y[index]-15*bullets_y[index]+190), bullets_type[index], bullets_size[index], bullets_dir[index]);
                }
                index++;
            }
        }
        if(Ey == 1) {
            if(Eball_state<0.4f) {
                DrawEnergyCircle(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eenergy_circle_size, Erobot_circle, Edead);
            }
            if(!Ejetpack_clicked){
            if (!Eball_clicked) {
                if (!Erobotboom) {
                    DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                } else {

                    DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x - boom_anime * 3, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y - boom_anime * 3, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
                }
            } else {
                DrawEnemyBall(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eball_state, Edir);
            }
            }else{
                if(!Edead) {
                    DrawEnemyJetpack(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, 0, 0, Ejetpack_anime, Ejetpack_state, Eswap, Ehurt);
                }else{
                    DrawEnemy(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale * (1.0f - 0.03f * Ey), Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, true);

                }
            }
        }
        if(y == 1) {
            if(ball_state<0.4f) {
                DrawEnergyCircle(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, energy_circle_size, robot_circle, dead);
            }
            if (!jetpack_clicked) {
                if (!ball_clicked) {
                    if (!robotboom) {
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    } else {
                        DrawRobot(drawer, x * (width / 10) + (int) robot_x - boom_anime * 3, (height / 5) * y - 60 - 10 * y + (int) robot_y - boom_anime * 3, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
                    }
                } else {
                    DrawRobotBall(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, ball_state, dir);
                }
            }else{
                if(!dead){
                    DrawRobotJetpack(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, 0, 0, jetpack_anime, jetpack_state, swap, hurt);
                }else{
                    DrawRobot(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale * (1.0f - 0.03f * y), rothand + 90, rothead, rotleg, rot, swap, hurt, true, 0);
                }
            }
        }


        if(mine_clicked) {
            for(int num = 0;num<3;num++) {
                if(mine_exist[num]==3) {
                    drawer.draw(explosive[(int)Math.floor(explosive_anime/2.0f)], mine_x[num] - 200 * mine_scale[num], mine_y[num] - 200 * mine_scale[num] + 90 * mine_scale[num], 200 * mine_scale[num], 200 * mine_scale[num], mine_scale[num] * 400, mine_scale[num] * 400, 1, 1, mine_rotate[num]);
                }
            }
        }
        if(Emine_clicked) {
            for(int num = 0;num<3;num++) {
                if(Emine_exist[num]==3) {
                    drawer.draw(explosive[(int)Math.floor(Eexplosive_anime/2.0f)], Emine_x[num] - 200 * Emine_scale[num], Emine_y[num] - 200 * Emine_scale[num] + 90 * Emine_scale[num], 200 * Emine_scale[num], 200 * Emine_scale[num], Emine_scale[num] * 400, Emine_scale[num] * 400, 1, 1, Emine_rotate[num]);
                }
            }
        }

        if(isboom && boom_y == 1){
            drawer.draw(booms[boom_anime-1], boom_x*(width/10)-275*boom_flip,  (height/5)*boom_y-60-10*boom_y+(height-boom_height), 550*boom_flip, boom_height);
        }
        if(meteor_run && will_meteor_y == 1 && game.robot.draw_interface) {
            drawer.draw(game.robot.Cross, meteor_x + (150-cross_size)/2, will_meteor_y * (height / 5) - 60 - 10 * will_meteor_y, cross_size, cross_size);
        }
        if(meteor_run && meteor_front_visible){
            if(!meteor_splash) {
                if(!meteor_rocket) {
                    if( game.robot.level != 1 && game.robot.level != 2 && game.robot.level != 5) {
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

        if(dead){
            DrawDead(drawer, rip_x, rip_y, scale, rip_rotate, false);
        }
        if(Edead){
            DrawDead(drawer, Erip_x, Erip_y, Escale, Erip_rotate, true);
        }
        if(game.robot.level == 5) {
            i=0;
            while (i != rain_quantity) {
                if (rain_z[i] == 0) {
                    drawer.draw(rain[rain_type[i] - 1], rain_x[i], rain_y[i], 60 / (rain_z[i] + 2), 60 / (rain_z[i] + 2));
                }
                i++;
            }
        }
        if(isboom){
            drawer.draw(boom_front[boom_front_anime], 0, 0, width, height);

        }



        if(circle_clicked){
            drawer.draw(circle, x * (width / 10) + (int) robot_x-175*circle_scale+100*scale, (height / 5) * y - 60 - 10 * y + (int) robot_y+(220*scale)-175*circle_scale+15, 175*circle_scale, 175*circle_scale, 350*circle_scale, 350*circle_scale, 1, 1, circle_rotate);
        }

        if(Ecircle_clicked){
            drawer.draw(circle, Ex * (width / 10) + (int) Erobot_x-175*Ecircle_scale+100*Escale, (height / 5) *Ey - 60 - 10 * Ey + (int) Erobot_y+(220*Escale)-175*Ecircle_scale+15, 175*Ecircle_scale, 175*Ecircle_scale, 350*Ecircle_scale, 350*Ecircle_scale, 1, 1, Ecircle_rotate);
        }


        if(game.robot.draw_interface) {
            DrawEnemyIcon(drawer, Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, Escale, Ehealth);
            DrawRobotIcon(drawer, x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, scale, health);

            if (fire_touch) {                //Так как eval из JavaScript в Java не присутствует, и даже его более или менее адекватной замены я не встретил, приходится 7овнокодить...
                drawer.draw(fire_touched, (int) (width - 275 * scale_inteface), -pos_interface, (int) (250 * scale_inteface), (int) (250 * scale_inteface));
            } else {
                drawer.draw(fire, (int) (width - 275 * scale_inteface), -pos_interface, (int) (250 * scale_inteface), (int) (250 * scale_inteface));
            }/*
            if (dir == 1) {
                if (up_touch) {
                    drawer.draw(button_touched, (int) (50 * scale_inteface), (int) (125 * scale_inteface - pos_interface), (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                drawer.draw(up_2, (int) (50 * scale_inteface), (int) (125 * scale_inteface - pos_interface), (int) (150 * scale_inteface), (int) (150 * scale_inteface));

                if (down_touch) {
                    drawer.draw(button_touched, (int) (50 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                    drawer.draw(down_2, (int) (50 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            } else {
                if (up_touch) {
                    drawer.draw(button_touched, (int) (50 * scale_inteface), (int) (125 * scale_inteface - pos_interface), (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                    drawer.draw(up_1, (int) (50 * scale_inteface), (int) (125 * scale_inteface - pos_interface), (int) (150 * scale_inteface), (int) (150 * scale_inteface));

                if (down_touch) {
                    drawer.draw(button_touched, (int) (50 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                    drawer.draw(down_1, (int) (50 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));


            }
            if (redir_touch) {
                drawer.draw(button_touched, (int) (200 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
            }
                drawer.draw(redir, (int) (200 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
*/

            drawer.draw(button_control_back, 0, 0, 300*scale_inteface, 300*scale_inteface);
            drawer.draw(button_control, (control_pos_x-75)*scale_inteface, (control_pos_y-75)*scale_inteface, 150*scale_inteface, 150*scale_inteface);

            if (game.robot.power_large == 1) {
                if(ball_touch) {
                   drawer.draw(button_touched, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                if(!ball_can) {
                    drawer.draw(button_cant_touch, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                        drawer.draw(ball, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            }
            if (game.robot.power_large == 2) {
                if (jetpack_touch) {
                    drawer.draw(button_touched, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                if(!jetpack_can) {
                    drawer.draw(button_cant_touch, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                    drawer.draw(jetpack, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            }
            if (game.robot.power_large == 3) {
                if (jetpack_touch) {
                    drawer.draw(button_touched, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                if(!jetpack_can) {
                    drawer.draw(button_cant_touch, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                    drawer.draw(jetpack, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            }
            if (game.robot.power_large == 4) {
                if (circle_touch) {
                    drawer.draw(button_touched, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                if(!circle_can) {
                    drawer.draw(button_cant_touch, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                    drawer.draw(button_circle, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            }
            if (game.robot.power_large == 5) {
                if(ball_touch) {
                    drawer.draw(button_touched, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                if(!ball_can) {
                    drawer.draw(button_cant_touch, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                drawer.draw(ball, (int) (width - 400 * scale_inteface), -pos_interface + 150, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            }
            if (game.robot.power_small == 1) {
                if (saw_touch) {
                    drawer.draw(button_touched, (int) (width - 400 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                    drawer.draw(button_saw, (int) (width - 400 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            }
            if (game.robot.power_small == 2) {
                if (jump_touch) {
                    drawer.draw(button_touched, (int) (width - 400 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                    drawer.draw(button_mine, (int) (width - 400 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            }
            if (game.robot.power_small == 3) {
                if (jump_touch) {
                    drawer.draw(button_touched, (int) (width - 400 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                drawer.draw(jump, (int) (width - 400 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            }
            if (game.robot.power_small == 4) {
                if (pull_touch) {
                    drawer.draw(button_touched, (int) (width - 400 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                drawer.draw(pull, (int) (width - 400 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            }
            if (game.robot.power_small == 5) {
                if (plasma_touch) {
                    drawer.draw(button_touched, (int) (width - 400 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));
                }
                drawer.draw(plasma, (int) (width - 400 * scale_inteface), -pos_interface, (int) (150 * scale_inteface), (int) (150 * scale_inteface));

            }
            DrawEnergy(drawer, (int) (400 * (scale_inteface - 0.1)),   - pos_interface, 0.8f * (scale_inteface - 0.1f), energy, warning);
        }
        if(win != 0){
            drawer.draw(Darkeffect, 0, 0, width, height);
            drawer.draw(Effect, (float) (width/2.0-(float)win_scale/2.0), (float) (height/2.0-(float)win_scale/2.0), (float)win_scale/2.0f, (float)win_scale/2.0f, (float)win_scale, (float)win_scale, 1, 1, win_rot);
            if(win_type == 1) {
                drawer.draw(chip,  width/2-(int)((float)win_scale*0.70)/2, height/2-(int)((float)win_scale*0.70)/2, (int)((float)win_scale*0.70), (int)((float)win_scale*0.70));
            }
            if(win_type == 2) {
                drawer.draw(bulb,  width/2-(int)((float)win_scale*0.70)/2, height/2-(int)((float)win_scale*0.70)/2, (int)((float)win_scale*0.70), (int)((float)win_scale*0.70));
            }
            if(win_type == 3) {
                drawer.draw(metall,  width/2-(int)((float)win_scale*0.70)/2, height/2-(int)((float)win_scale*0.70)/2, (int)((float)win_scale*0.70), (int)((float)win_scale*0.70));
            }
            if(win_type == 4) {
                drawer.draw(gear,   width/2-(int)((float)win_scale*0.70)/2, height/2-(int)((float)win_scale*0.70)/2, (int)((float)win_scale*0.70), (int)((float)win_scale*0.70));
            }

            drawer.draw(level_back, -140+show_exp_x+30, 150, 300, 80);
            drawer.draw(level_line, -140+show_exp_x+30, 150, (int)(((float)game.robot.experience/((float)game.robot.level_win*100.0))*300.0), 80);
            drawer.draw(level_front, -140+show_exp_x+30, 150, 300, 80);
            drawer.draw(level_circle, -230+show_exp_x+30, 130, 120, 120);
            level_big_font.draw(batch, Integer.toString(game.robot.level_win), (int)((-200.0+show_exp_x+30)*wpw), (int)((215)*hph));
            level_font.draw(batch, game.robot.experience + " / " + game.robot.level_win*100, (int)((-110.0+show_exp_x+30)*wpw), (int)((205)*hph));



            resource_font.draw(batch, win_num + "", (int)(((float)width/2.0-25)*wpw), (int)(((float)win_y-160.0)*hph));

        }
        drawer.draw(Frontcolor, 0, 0, width, height);
        drawer.draw(Frontground, 0, 0, width, height);

        if(pause){
            drawer.draw(begin_left[anime_begin], openlevel_x-width-10, 0, width, height);
            drawer.draw(begin_right[anime_begin], width-openlevel_x+10, 0, width, height);
            DrawRobot(drawer, openlevel_x-width-(width-openlevel_x)/2-100, -450, scale * 3.0f, rothand + 90, rothead, rotleg, rot, swap, hurt, dead, 0);
            DrawEnemy(drawer, width-openlevel_x+1300+(width-openlevel_x)/2, -450, Escale * 3.0f, Erothand + 90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
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

        CheckDoor(drawer);
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
    public void ELargePower(){
        EturnedLarge++;
        if(game.robot.Epower_large == 1) {
            EBall();
        }
        if(game.robot.Epower_large == 2) {
            EJetpack();
        }
        if(game.robot.Epower_large == 3) {
            EJetpack();
        }
        if(game.robot.Epower_large == 4) {
            ECircle();
        }
        if(game.robot.Epower_large == 5) {
            EField();
        }
    }
    public void ESmallPower(){
        EturnedSmall++;
        if(game.robot.Epower_small == 1) {
            ESaw();
        }
        if(game.robot.Epower_small == 2) {
            EMine();
        }
        if(game.robot.Epower_small == 3) {
            EJump();
        }
        if(game.robot.Epower_small == 4) {
            EPull();
        }
        if(game.robot.Epower_small == 5) {
            EPlasma();
        }
    }

    public void LargePower(){
        turnedLarge++;
        if(game.robot.power_large == 1) {
            Ball();
        }
        if(game.robot.power_large == 2) {
            Jetpack();
        }
        if(game.robot.power_large == 3) {
            Jetpack();
        }
        if(game.robot.power_large == 4) {
            Circle();
        }
        if(game.robot.power_large == 5) {
            Field();
        }
    }
    public void SmallPower(){
        turnedSmall++;
        if(game.robot.power_small == 1) {
            Saw();
        }
        if(game.robot.power_small == 2) {
            Mine();
        }
        if(game.robot.power_small == 3) {
            Jump();
        }
        if(game.robot.power_small == 4) {
            Pull();
        }
        if(game.robot.power_small == 5) {
            Plasma();
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
       if(x > -1 && x < 10) {
          boolean can_fire = true;
          if (game.robot.level == 5 && !(grass_1_type[x] == 1)) {
             can_fire = false;
          }
          int broke_plus = 1;
          boolean grass_fired = false;
          if (y == 1 && fire_x_1[x] == 0 && fire_state_1[x] == 0 && grass_1_type[x] != 0 && can_fire) {
             fire_x_1[x] = 1;

             fire_state_1[x] = 1;
             if (grass_1_type[x] != 0) {
                grass_fired = true;
             }
             while (fire_state_1[x] < width / 10 * 1.5f) {
                if (fire_x_1[x] == 0) {
                   broke_plus = 20;
                   break;
                }
                if (grass_fired) {
                   grass_1_scale[x] -= 0.01f;
                }
                fire_state_1[x] += 1 + broke_plus;
                if (this.x == x && this.y == y && !jetpack_flying && fire_x_1[x] != 0 && fire_state_1[x] > 100) {
                   DamageRobot(game.robot.fire_damage);
                }
                if (this.Ex == x && this.Ey == y && !Ejetpack_flying && fire_x_1[x] != 0 && fire_state_1[x] > 100) {
                   DamageEnemy(game.robot.fire_damage);
                }
                if (!CheckCircle(x * (width / 10) + ((width / 10) - fire_state_1[x]) / 2, (height / 5) - 80 - 30, fire_state_1[x], fire_state_1[x])) {
                   Sleep(3);
                } else {
                   Sleep(24);
                }
             }
             while (fire_state_1[x] > 1) {
                if (fire_x_1[x] == 0) {
                   broke_plus = 20;
                }
                if (grass_fired) {
                   grass_1_scale[x] -= 0.05f;
                }
                fire_state_1[x] -= broke_plus;
                if (this.x == x && this.y == y && !jetpack_flying && fire_x_1[x] != 0 && fire_state_1[x] > 100) {
                   DamageRobot(game.robot.fire_damage);
                }
                if (this.Ex == x && this.Ey == y && !Ejetpack_flying && fire_x_1[x] != 0 && fire_state_1[x] > 100) {
                   DamageEnemy(game.robot.fire_damage);
                }
                if (!CheckCircle(x * (width / 10) + ((width / 10) - fire_state_1[x]) / 2, (height / 5) - 80 - 30, fire_state_1[x], fire_state_1[x])) {
                   Sleep(60);
                } else {
                   Sleep(480);
                }
             }
             if (grass_fired && grass_1_scale[x] <= 0.1f) {
                grass_1_type[x] = 0;
             }
             fire_x_1[x] = 0;
             fire_state_1[x] = 0;
          }
          if (y == 2 && fire_x_2[x] == 0 && fire_state_2[x] == 0 && grass_2_type[x] != 0 && can_fire) {
             fire_x_2[x] = 1;

             fire_state_2[x] = 1;
             if (grass_2_type[x] != 0) {
                grass_fired = true;
             }
             while (fire_state_2[x] < width / 10 * 1.5f) {
                if (fire_x_2[x] == 0) {
                   broke_plus = 20;
                   break;
                }
                if (grass_fired) {
                   grass_2_scale[x] -= 0.01f;
                }
                fire_state_2[x] += 1 + broke_plus;
                if (this.x == x && this.y == y && !jetpack_flying && fire_x_2[x] != 0 && fire_state_2[x] > 100) {
                   DamageRobot(game.robot.fire_damage);
                }
                if (this.Ex == x && this.Ey == y && !Ejetpack_flying && fire_x_2[x] != 0 && fire_state_2[x] > 100) {
                   DamageEnemy(game.robot.fire_damage);
                }
                if (!CheckCircle(x * (width / 10) + ((width / 10) - fire_state_2[x]) / 2, (height / 5) * 2 - 80 - 20 * 2, fire_state_2[x], fire_state_2[x])) {
                   Sleep(3);
                } else {
                   Sleep(24);
                }
             }
             while (fire_state_2[x] > 1) {
                if (fire_x_2[x] == 0) {
                   broke_plus = 20;
                }
                if (grass_fired) {
                   grass_2_scale[x] -= 0.05f;
                }
                fire_state_2[x] -= broke_plus;
                if (this.x == x && this.y == y && !jetpack_flying && fire_x_2[x] != 0 && fire_state_2[x] > 100) {
                   DamageRobot(game.robot.fire_damage);
                }
                if (this.Ex == x && this.Ey == y && !Ejetpack_flying && fire_x_2[x] != 0 && fire_state_2[x] > 100) {
                   DamageEnemy(game.robot.fire_damage);
                }
                if (!CheckCircle(x * (width / 10) + ((width / 10) - fire_state_2[x]) / 2, (height / 5) * 2 - 80 - 20 * 2, fire_state_2[x], fire_state_2[x])) {
                   Sleep(60);
                } else {
                   Sleep(480);
                }
             }
             if (grass_fired && grass_2_scale[x] <= 0.1f) {
                grass_2_type[x] = 0;
             }
             fire_x_2[x] = 0;
             fire_state_2[x] = 0;
          }
          if (y == 3 && fire_x_3[x] == 0 && fire_state_3[x] == 0 && grass_3_type[x] != 0 && can_fire) {
             fire_x_3[x] = 1;

             fire_state_3[x] = 1;
             if (grass_3_type[x] != 0) {
                grass_fired = true;
             }
             while (fire_state_3[x] < width / 10 * 1.5f) {
                if (fire_x_3[x] == 0) {
                   broke_plus = 20;
                   break;
                }
                if (grass_fired) {
                   grass_3_scale[x] -= 0.01f;
                }
                fire_state_3[x] += 1 + broke_plus;
                if (this.x == x && this.y == y && !jetpack_flying && fire_x_3[x] != 0 && fire_state_3[x] > 100) {
                   DamageRobot(game.robot.fire_damage);
                }
                if (this.Ex == x && this.Ey == y && !Ejetpack_flying && fire_x_3[x] != 0 && fire_state_3[x] > 100) {
                   DamageEnemy(game.robot.fire_damage);
                }
                if (!CheckCircle(x * (width / 10) + ((width / 10) - fire_state_3[x]) / 2, (height / 5) * 3 - 80 - 15 * 3, fire_state_3[x], fire_state_3[x])) {
                   Sleep(3);
                } else {
                   Sleep(24);
                }
             }
             while (fire_state_3[x] > 1) {
                if (fire_x_3[x] == 0) {
                   broke_plus = 20;
                }
                if (grass_fired) {
                   grass_3_scale[x] -= 0.05f;
                }
                fire_state_3[x] -= broke_plus;
                if (this.x == x && this.y == y && !jetpack_flying && fire_x_3[x] != 0 && fire_state_3[x] > 100) {
                   DamageRobot(game.robot.fire_damage);
                }
                if (this.Ex == x && this.Ey == y && !Ejetpack_flying && fire_x_3[x] != 0 && fire_state_3[x] > 100) {
                   DamageEnemy(game.robot.fire_damage);
                }
                if (!CheckCircle(x * (width / 10) + ((width / 10) - fire_state_3[x]) / 2, (height / 5) * 3 - 80 - 15 * 3, fire_state_3[x], fire_state_3[x])) {
                   Sleep(60);
                } else {
                   Sleep(480);
                }
             }
             if (grass_fired && grass_3_scale[x] <= 0.1f) {
                grass_3_type[x] = 0;
             }
             fire_x_3[x] = 0;
             fire_state_3[x] = 0;
          }
       }
    }
   /* public boolean CheckBullet(){
        if(bullets>0) {
            int index = 0;
            while (index < 40) {
                if (bullets_dir[index] != 0 && Math.floor(bullets_y[index]) == (float)Ey && Math.abs((float)bullets_x[index] - (float)(Ex*width/10)) < 800 && (((float)(Ex*width/10)-(float)bullets_x[index] > 0 && bullets_dir[index] == 1) || ((float)bullets_x[index]-(float)(Ex*width/10)> 0 && bullets_dir[index] == -1))) {
                    return true;
                }
                index++;
            }
        }
        return false;
    }*/
    public boolean CheckBulletInPlace(int x, int y, int distance){
        if(bullets>0) {
            int index = 0;
            while (index < 40) {
                if (bullets_dir[index] != 0 && Math.round(bullets_y[index]) == (float)y && Math.abs((float)bullets_x[index] - (float)(x*width/10)) < distance && (((float)(x*width/10)-(float)bullets_x[index] > 0 && bullets_dir[index] == 1) || ((float)bullets_x[index]-(float)(x*width/10)> 0 && bullets_dir[index] == -1))) {
                    return true;
                }
                index++;
            }
        }
        return false;
    }
    public void ESetBullet(int Ex, int Ey, int Edir){               //Жесткая дичь, которая добавляет пули. Работает - не трожь. Написал сам - молодец. Скопипастил - лох. Но если придерживаться логики, где вообще можно скопипастить такую хрень, а?
        if(bullets < 50){
            bullets++;
            int i = 0;
            int num = 0;
            while(i<50){
                if(bullets_dir[i] == 0){
                    num = i;
                    break;
                }
                i++;
            }
            bullets_type[num] = 2;
            bullets_x[num] = Ex+(int)(145*Edir*Escale);
            bullets_y[num] = Ey;
            bullets_dir[num] = Edir;
            lastnumbullet = num;
            bullets_size[num] = 1;
            Thread bullet_size = new Thread() {
                @Override
                public void run() {
                    int num = lastnumbullet;
                    while(bullets_size[num]<25){
                        bullets_size[num]++;
                        Sleep(20);
                    }
                    bullets_size[num] = 25;
                }
            };
            bullet_size.start();
            Thread anime = new Thread() {
                @Override
                public void run() {
                    int randomfire = game.random.nextInt(8) * (game.random.nextInt(5) - 2); //Переменная, отвечающая за кучность стрельбы.. Типо точность, или отдача
                    int num = lastnumbullet;                   //Вот, на ней все держится
                    int dir = bullets_dir[num];
                    while(true){
                        bullets_x[num] += 2 * dir;
                        bullets_y[num]-=0.0001*randomfire;
                        if(bullets_x[num] > width+100 || bullets_x[num] < -100){
                            break;
                        }
                        if(bullets_x[num] >= (int)(x*width/10+robot_x)-(int)(30*Escale) && bullets_x[num] <= (int)(x*width/10+robot_x+(230.0*scale)) && Math.round(bullets_y[num]) == y&& robot_y<(height/5)/2 && robot_y>-(height/5)/2){
                            if(!ball_clicked && !dead) {
                                DamageRobot(game.robot.Edamage);
                                break;
                            }
                        }
                        if(bullets == 0 || bullets_dir[num] == 0){
                            break;
                        }
                        int bullet_speed = game.robot.Eattack_speed;
                        if(bullet_speed > 5){
                            bullet_speed = 5;
                        }
                        if(!CheckCircle((bullets_x[num] + 135 * bullets_dir[num]), (int)((height/5)*bullets_y[num]-15*bullets_y[num]+190), bullets_size[num]+15, bullets_size[num]+10)) {
                            Sleep((int) (bullet_speed * speed));
                        }else{
                            Sleep((int) (bullet_speed * speed * 8));
                        }
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
        if(bullets < 50){
            bullets++;
            int i = 0;
            int num = 0;
            while(i<50){
                if(bullets_dir[i] == 0){
                    num = i;
                    break;
                }
                i++;
            }
            bullets_dir[num] = dir;
            bullets_type[num] = 1;
            bullets_x[num] = x+(int)(145*dir*scale);
            bullets_y[num] = y;
            Elastnumbullet = num;
            bullets_size[num] = 1;
            Thread bullet_size = new Thread() {
                @Override
                public void run() {
                    int num = Elastnumbullet;
                    while(bullets_size[num]<25){
                        bullets_size[num]++;
                        Sleep(20);
                    }
                    bullets_size[num] = 25;
                }
            };
            bullet_size.start();
            Thread anime = new Thread() {
                @Override
                public void run() {
                    int randomfire = game.random.nextInt(8) * (game.random.nextInt(5) - 2); //Переменная, отвечающая за кучность стрельбы.. Типо точность, или отдача
                    int num = Elastnumbullet;                   //Вот, на ней все держится
                    int dir = bullets_dir[num];
                    while(true){
                        bullets_x[num]+=2*dir;
                        bullets_y[num]-=0.0001*randomfire;
                        if(bullets_x[num] > width+100 || bullets_x[num] < -100){
                            break;
                        }
                        if(bullets_x[num] >= (int)(Ex*width/10+Erobot_x)-(int)(30*Escale) && bullets_x[num] <= (int)(Ex*width/10+Erobot_x+(230.0*Escale)) && Math.round(bullets_y[num]) == Ey && Erobot_y<(height/5)/2 && Erobot_y>-(height/5)/2) {
                            if (!Eball_clicked && !Edead) {
                                DamageEnemy(game.robot.damage);
                                break;
                            }

                        }
                        if(bullets == 0 || bullets_dir[num] == 0){
                            break;
                        }
                        int bullet_speed = game.robot.attack_speed;
                        if(bullet_speed > 5){
                            bullet_speed = 5;
                        }
                        if(!ECheckCircle((bullets_x[num] + 135 * bullets_dir[num]), (int)((height/5)*bullets_y[num]-15*bullets_y[num]+190), bullets_size[num]+15, bullets_size[num]+10)) {
                            Sleep((int) (bullet_speed * speed));
                        }else{
                            Sleep((int) (bullet_speed * speed * 8));
                        }
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
        if(!Eswap && !Eball_clicked && !Epull_clicked) {
                if (!Ehurt) {
                    Ehealth -= damage;
                    if(Ehealth <= 0) {
                        if(!Ejetpack_clicked) {
                            Ehealth = 0;
                        }else{
                            Ehealth = 1;
                        }
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
        if(!swap && !ball_clicked && !pull_clicked) {
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
                                if(online){
                                    if(host){
                                        server.stop();
                                    }else{
                                        client.stop();
                                    }
                                }
                            }
                        }
                        Sleep(20);
                    }
                }
            };
            anime.start();

    }
    public void SetMeteor(){
        if(!meteor_run){

            int rand = game.random.nextInt(2);
            if(rand == 0) {
                will_meteor_x = Ex;
                will_meteor_y = Ey;
            }else{
                will_meteor_x = x;
                will_meteor_y = y;
            }
            rand = game.random.nextInt(2);
            meteor_rocket = rand == 0;
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
                    meteor_run = true;
                    meteor_front_visible = true;
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
                                    DamageRobot(game.robot.health/7);
                                }else{
                                    DamageRobot(game.robot.health/10);
                                }
                            }
                            if(will_meteor_x == Ex && will_meteor_y == Ey){
                                if (game.robot.level != 1) {
                                    DamageEnemy(game.robot.Ehealth/7);
                                } else {
                                    DamageEnemy(game.robot.Ehealth/10);
                                }
                            }
                        }
                        if(cross_size> 5){
                            cross_size-=1;
                        }
                        meteor_y-=3;
                        if(meteor_y<=will_meteor_y*(height/5)){
                            meteor_front_visible = false;
                        }
                        if(!CheckCircle(meteor_x, meteor_y, 150, 150)) {

                            Sleep((int) (5 * speed));
                        }else{
                            Sleep((int) (40 * speed));
                        }
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
                        meteor_splash_size+=4;
                        if(!CheckCircle(meteor_x, meteor_y, 150, 150) && !ECheckCircle(meteor_x, meteor_y, 150, 150)) {

                            Sleep((int) (5 * speed));
                        }else{
                            Sleep((int) (40 * speed));
                        }
                    }
                    while (meteor_splash_size>-100) {
                        meteor_splash_size-=2;
                        if(!CheckCircle(meteor_x, meteor_y, 150, 150) && !ECheckCircle(meteor_x, meteor_y, 150, 150)) {

                            Sleep((int) (5 * speed));
                        }else{
                            Sleep((int) (40 * speed));
                        }
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
    public void Plasma(){
       if(!dead && !ball_clicked && !jetpack_clicked && !down_clicked && !up_clicked && !fire_clicked && !plasma_clicked && !redir_clicked) {
          plasma_clicked = true;
          Thread anime = new Thread() {
             @Override
             public void run() {
                plasma_x = x*width/10+(int)robot_x;
                plasma_y = (int)(y*height/5+robot_y+230*scale-y*15);
                plasma_scale = 0.1f;
                plasma_dir = dir;
                while(plasma_x<width+400*plasma_scale&&plasma_x>-400*plasma_scale && !CheckCircle(plasma_x, plasma_y, (int)(450*plasma_scale), (int)(100*plasma_scale))){
                     if(plasma_scale < 1.0f){
                        plasma_scale+=0.007f;
                     }
                     plasma_x += plasma_dir*10;
                   Thread fire = new Thread() {
                      @Override
                      public void run() {
                     SetFire(Math.round(plasma_x/(width/10)), (int)Math.floor(plasma_y/(height/5)));
                      }};
                   fire.start();
                   Sleep(5);
                }
                while(plasma_scale>0.01f){
                   plasma_scale-=0.01f;
                   if(!CheckCircle(plasma_x, plasma_y, (int)(450*plasma_scale), (int)(100*plasma_scale))) {
                      Sleep(5);
                   }else{
                      Sleep(40);
                   }
                }
                plasma_clicked = false;
             }};
          anime.start();
       }
    }
    public void EPlasma(){

    }
    public void Field(){

    }
    public void EField(){

    }
    public void Pull(){
        if(!dead && !ball_clicked && !jetpack_clicked && !down_clicked && !up_clicked && !fire_clicked && !pull_clicked) {
            pull_clicked = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    pull_will_y = y;
                    pull_will_x = x+dir*5;

                    pulls_x[0] = (int)(x*width/10+robot_x);
                    pulls_x[1] = (int)(x*width/10+robot_x);
                    pulls_x[2] = (int)(x*width/10+robot_x);

                    pulls_y[0] = (int)(y*height/5+robot_y);
                    pulls_y[1] = (int)(y*height/5+robot_y);
                    pulls_y[2] = (int)(y*height/5+robot_y);

                    Thread tail = new Thread() {
                        @Override
                        public void run() {
                            while(pull_clicked){
                                pulls_x[2] = pulls_x[1];
                                pulls_x[1] = pulls_x[0];
                                pulls_x[0] = (int)(x*width/10+robot_x);
                                Sleep(50);
                            }
                        }};
                    tail.start();


                    if(pull_will_x < 1){
                        pull_will_x = 1;
                    }
                    if(pull_will_x > 8){
                        pull_will_x = 8;
                    }

                    while(x!=pull_will_x){
                        if(x<pull_will_x){
                            robot_x+=10;
                        }
                        if(x>pull_will_x){
                            robot_x-=10;
                        }
                        if(robot_x>=width/10){
                            x+=1;
                            robot_x = 0;
                            TakeSkin();
                            UseMed();
                        }
                        if(robot_x<=-width/10){
                            x-=1;
                            robot_x = 0;
                            TakeSkin();
                            UseMed();
                        }
                        Sleep(5);
                    }
                    while(pulls_x[0]!=pulls_x[2]){
                        Sleep(10);
                    }
                    pull_clicked = false;
                }
            };
            anime.start();
        }
    }
     public void EPull(){
         if(!Edead && !Eball_clicked && !Ejetpack_clicked && !Edown_clicked && !Eup_clicked && !Efire_clicked && !Epull_clicked) {
             Epull_clicked = true;
             Thread anime = new Thread() {
                 @Override
                 public void run() {
                     Epull_will_y = Ey;
                     Epull_will_x = Ex+Edir*5;

                     Epulls_x[0] = (int)(Ex*width/10+Erobot_x);
                     Epulls_x[1] = (int)(Ex*width/10+Erobot_x);
                     Epulls_x[2] = (int)(Ex*width/10+Erobot_x);

                     Epulls_y[0] = (int)(Ey*height/5+Erobot_y);
                     Epulls_y[1] = (int)(Ey*height/5+Erobot_y);
                     Epulls_y[2] = (int)(Ey*height/5+Erobot_y);

                     Thread tail = new Thread() {
                         @Override
                         public void run() {
                             while(Epull_clicked){
                                 Epulls_x[2] = Epulls_x[1];
                                 Epulls_x[1] = Epulls_x[0];
                                 Epulls_x[0] = (int)(Ex*width/10+Erobot_x);
                                 Sleep(50);
                             }
                         }};
                     tail.start();


                     if(Epull_will_x < 1){
                         Epull_will_x = 1;
                     }
                     if(Epull_will_x > 8){
                         Epull_will_x = 8;
                     }

                     while(Ex!=Epull_will_x){
                         if(Ex<Epull_will_x){
                             Erobot_x+=10;
                         }
                         if(Ex>Epull_will_x){
                             Erobot_x-=10;
                         }
                         if(Erobot_x>=width/10){
                             Ex+=1;
                             Erobot_x = 0;
                             ETakeSkin();
                             EUseMed();
                         }
                         if(Erobot_x<=-width/10){
                             Ex-=1;
                             Erobot_x = 0;
                             ETakeSkin();
                             EUseMed();
                         }
                         Sleep(5);
                     }
                     while(Epulls_x[0]!=Epulls_x[2]){
                         Sleep(10);
                     }
                     Epull_clicked = false;
                 }
             };
             anime.start();
         }
     }
    public void EBall(){
        if(!Efire_clicked && !Eup_clicked && !Edown_clicked && !Eredir_clicked && !Ejump_clicked && !Edead && !pause && !Eball_clicked && Eball_can && !Epull_clicked) {
            Eball_clicked = true;
            Eball_can = false;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (Eball_state < 1.0f) {
                        Eball_state += 0.02f;
                        Sleep(5);
                    }
                    if(Edir==1) {
                        while (Ex < 8) {
                            Erobot_x += 5;
                            if (Erobot_x >= width / 10) {
                                Erobot_x = 0;
                                Ex++;
                            }
                            if (x == Ex && y == Ey) {
                                DamageRobot(game.robot.Eattack_speed * 7);
                            }
                            ETakeSkin();
                            ECheckMine();
                            EUseMed();
                            Erot -= 2.0f;
                            if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(Escale*300), (int)(Escale*300))) {
                                Sleep(5);
                            }else{
                                Sleep(40);
                            }
                        }
                    }else{
                        while (Ex > 1) {
                            Erobot_x -= 5;
                            if (Erobot_x <= -width / 10) {
                                Erobot_x = 0;
                                Ex--;
                            }
                            if (x == Ex && y == Ey) {
                                DamageRobot((8-game.robot.Eattack_speed) * 7);
                            }
                            ETakeSkin();
                            ECheckMine();
                            EUseMed();
                            Erot += 2.0f;
                            if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x, (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(Escale*300), (int)(Escale*300))) {
                                Sleep(5);
                            }else{
                                Sleep(40);
                            }
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
                    Sleep(7500);
                    Eball_can = true;
                }
            };
            anime.start();
        }
    }
    public void Ball(){
        if(!fire_clicked && !up_clicked && !down_clicked && !redir_clicked && !jump_clicked && !dead && !pause && !ball_clicked && ball_can && !jetpack_clicked && !robot_explosive && !pull_clicked) {

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
                                    DamageEnemy((8-game.robot.attack_speed)*7);
                                }
                                TakeSkin();
                                CheckMine();
                                UseMed();
                                rot -= 2.0f;
                                if(!ECheckCircle(x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(scale*300), (int)(scale*300))) {
                                    Sleep(5);
                                }else{
                                    Sleep(40);
                                }
                            }
                        }else{
                            while(x>1){
                                robot_x-=5;
                                if(robot_x<=-width/10){
                                    robot_x=0;
                                    x--;
                                }
                                if(x==Ex&&y==Ey){
                                    DamageEnemy((8-game.robot.attack_speed)*7);
                                }
                                TakeSkin();
                                CheckMine();
                                UseMed();
                                rot += 2.0f;
                                if(!ECheckCircle(x * (width / 10) + (int) robot_x, (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(scale*300), (int)(scale*300))) {
                                    Sleep(5);
                                }else{
                                    Sleep(40);
                                }
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
                        Sleep(7500);
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

                Thread anime = new Thread() {
                    @Override
                    public void run() {


                        Sleep(10000);


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
    public void EDead(){
        if(!Edead && !Ejump_clicked){

            Erip_x[0] = (int)(Ex*(width/10)+Erobot_x);
            Erip_y[0] = (int)(Ey*(height/5)+Erobot_y+335*Escale - 60 - 10 * Ey);
            Erip_x[1] = (int)(Ex*(width/10)+Erobot_x);
            Erip_y[1] = (int)(Ey*(height/5)+Erobot_y+170*Escale - 60 - 10 * Ey);
            Erip_x[2] = (int)(Ex*(width/10)+Erobot_x-50*Escale);
            Erip_y[2] = (int)(Ey*(height/5)+Erobot_y - 60 - 10 * Ey);
            Erip_x[3] = (int)(Ex*(width/10)+Erobot_x+50*Escale);
            Erip_y[3] = (int)(Ey*(height/5)+Erobot_y - 60 - 10 * Ey);
            Erip_x[4] = (int)(Ex*(width/10)+Erobot_x+90*Escale);
            Erip_y[4] = (int)(Ey*(height/5)+Erobot_y+170*Escale - 60 - 10 * Ey);
            Erip_x[5] = (int)(Ex*(width/10)+Erobot_x-90*Escale);
            Erip_y[5] = (int)(Ey*(height/5)+Erobot_y+170*Escale - 60 - 10 * Ey);
            Erip_rotate[0] = (int)(Erothead);
            Erip_rotate[1] = (int)(Erot);
            Erip_rotate[2] = (int)(-Erotleg);
            Erip_rotate[3] = (int)(Erotleg);
            Erip_rotate[4] = (int)(Erothand+90);
            Erip_rotate[5] = (int)(Erothand);
            Edead = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    death.play(0.8f);


                    while (Edead_state < 1000) {
                        if(Edead_state<500) {
                            Edead_state += 1;
                        }else{
                            Edead_state += 2;
                        }
                        for(int i = 0; i < 6; i++){
                            if(!CheckCircle((int)Erip_x[i], (int)Erip_y[i], (int)(200*Escale),  (int)(200*Escale))) {
                                Erip_rotate[i] += Erip_dir_rotate[i] / 3.0f;
                                Erip_x[i] += Erip_dir_x[i];
                                Erip_y[i] += Erip_dir_y[i];
                            }else{
                                Erip_rotate[i] += Erip_dir_rotate[i] / 24.0f;
                                Erip_x[i] += Erip_dir_x[i]/8;
                                Erip_y[i] += Erip_dir_y[i]/8;
                            }
                        }
                        Erobot_y-=4;


                        Sleep(  10);
                    }
                    EndGame(1);
                }
            };
            anime.start();
        }
    }
    public void Dead(){
        if(!dead && !jump_clicked){
            rip_x[0] = (int)(x*(width/10)+robot_x);
            rip_y[0] = (int)(y*(height/5)+robot_y+335*scale - 60 - 10 * y);
            rip_x[1] = (int)(x*(width/10)+robot_x);
            rip_y[1] = (int)(y*(height/5)+robot_y+170*scale - 60 - 10 * y);
            rip_x[2] = (int)(x*(width/10)+robot_x-50*scale);
            rip_y[2] = (int)(y*(height/5)+robot_y - 60 - 10 * y);
            rip_x[3] = (int)(x*(width/10)+robot_x+50*scale);
            rip_y[3] = (int)(y*(height/5)+robot_y - 60 - 10 * y);
            rip_x[4] = (int)(x*(width/10)+robot_x+90*scale);
            rip_y[4] = (int)(y*(height/5)+robot_y+170*scale - 60 - 10 * y);
            rip_x[5] = (int)(x*(width/10)+robot_x-90*scale);
            rip_y[5] = (int)(y*(height/5)+robot_y+170*scale - 60 - 10 * y);
            rip_rotate[0] = (int)(rothead);
            rip_rotate[1] = (int)(rot);
            rip_rotate[2] = (int)(-rotleg);
            rip_rotate[3] = (int)(rotleg);
            rip_rotate[4] = (int)(rothand+90);
            rip_rotate[5] = (int)(rothand);
            dead = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    death.play(0.8f);


                    while(circle_scale>0.0f){
                        if(!jump_clicked) {
                            circle_scale -= 0.05f;
                        }
                        Sleep(10);
                    }
                    circle_clicked = false;
                    while (dead_state < 1000) {
                        if(dead_state<500) {
                            dead_state += 1;
                        }else{
                            dead_state += 2;
                        }
                        for(int i = 0; i < 6; i++){
                            if(!ECheckCircle((int)rip_x[i], (int)rip_y[i], (int)(200*scale),  (int)(200*scale))) {
                                rip_rotate[i] += rip_dir_rotate[i] / 3.0f;
                                rip_x[i] += rip_dir_x[i];
                                rip_y[i] += rip_dir_y[i];
                            }else{
                                rip_rotate[i] += rip_dir_rotate[i] / 24.0f;
                                rip_x[i] += rip_dir_x[i]/8;
                                rip_y[i] += rip_dir_y[i]/8;
                            }
                        }

                        pos_interface+=1;
                        robot_y-=4;

                        Sleep(  10);
                    }
                    if (!Edead && win != 1) {
                        Sleep(500);
                        DoorClose(1);
                    }
                }
            };
            anime.start();
        }
    }
    public void EFire(){
        if(!Efire_clicked && !Eup_clicked && !Edown_clicked && !Eredir_clicked && !Ejump_clicked && !Edead && !pause && !Eball_clicked && !Ejetpack_clicked && bullets < 50 && !enemy_explosive && !Epull_clicked) {
            if (EEnergyExists(10)) {
                EEnergyUse(10);
                Efire_clicked = true;
                ESetBullet(Ex * width / 10 + (int) (90 * Escale), Ey, Edir);
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        float lastrot = Erothand;
                        float rot = 0;
                        int rotdir = 1;
                        ERandomFireSound();
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
        if(!fire_clicked && !up_clicked && !down_clicked && !redir_clicked && !jump_clicked && !dead && !pause && !ball_clicked && !fire_cant && !jetpack_clicked && bullets < 50 && !robot_explosive && !pull_clicked) {
            if (EnergyExists(10)) {
                EnergyUse(10);
                turnedFire++;
                fire_clicked = true;
                SetBullet(x * width / 10 + (int) (100 * scale), y, dir);
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        float lastrot = rothand;
                        float rot = 0;
                        int rotdir = 1;
                        RandomFireSound();
                        while (true) {
                            if (rotdir == 1) {
                                rot += dir;

                                rothand += 1.0f * dir;
                                if (dir * rot > 10) {
                                    rotdir = -1;
                                }
                            }
                            if (rotdir == -1) {
                                rot -= dir;

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
        if(dir == 1) {
            Rblaster[random].play(0.8f - ((float) game.random.nextInt(3) * 0.1f));
        }else{
            Lblaster[random].play(0.8f - ((float) game.random.nextInt(3) * 0.1f));
        }
    }
     public void ERandomFireSound(){
         int random = game.random.nextInt(3);
         if(Edir == 1) {
             ERblaster[random].play(0.8f - ((float) game.random.nextInt(3) * 0.1f));
         }else{
             ELblaster[random].play(0.8f - ((float) game.random.nextInt(3) * 0.1f));
         }
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
        if(!Eup_clicked && !Edown_clicked && !Efire_clicked && !Edead && !pause && !Eball_clicked && !Ejetpack_clicked && !Epull_clicked) {

            if (Ey < 3) {
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        Eup_clicked = true;
                        int dir_num = Edir;
                        int rotdir = 1;
                        boolean acess_x = false;
                        boolean acess_y = false;
                        RandomMoveSound();
                        while (!Edead) {
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
                                ECheckMine();
                                break;
                            }
                            if(Erobot_speed_bonus == 0) {
                                if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale), (int)(535*Escale))) {
                                    Sleep((int) (game.robot.Emove_speed * speed));
                                }else{
                                    Sleep((int) (game.robot.Emove_speed * speed)*4);
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
        if(Ejetpack_clicked && !Eup_clicked && !Edown_clicked && Ejetpack_flying && !Eup_cant){
            if(Ey<3) {
                Eup_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        while(Erobot_y<height/5+30){
                            Erobot_y+=5;
                            if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale-(Ejetpack_state-30)*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale+(Ejetpack_state-30)*Escale), (int)(535*Escale))) {
                                Sleep(5);
                            }else{
                                Sleep(20);
                            }
                        }
                        Erobot_y-=height/5;
                        Ey++;
                        EUseMed();
                        ETakeSkin();
                        ECheckMine();
                        Eup_clicked = false;
                    }
                };

                anime.start();
            }
        }
    }
    public void EDown(){
        if(!Eup_clicked && !Edown_clicked && !Efire_clicked && !Edead && !pause && !Eball_clicked && !Ejetpack_clicked && !Epull_clicked) {

            if (Ey > 1) {
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        Edown_clicked = true;
                        int dir_num = Edir;
                        int rotdir = 1;
                        boolean acess_x = false;
                        boolean acess_y = false;
                        RandomMoveSound();
                        while (!Edead) {
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
                                ECheckMine();
                                break;
                            }
                            if(Erobot_speed_bonus == 0) {

                                if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale), (int)(535*Escale))) {
                                    Sleep((int) (game.robot.Emove_speed * speed));
                                }else{
                                    Sleep((int) (game.robot.Emove_speed * speed)*4);
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
        if(Ejetpack_clicked && !Eup_clicked && !Edown_clicked && Ejetpack_flying && !Edown_cant){
            if(Ey>1) {
                Edown_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        while(Erobot_y>-height/5+30){
                            Erobot_y-=5;
                            if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale-(Ejetpack_state-30)*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale+(Ejetpack_state-30)*Escale), (int)(535*Escale))) {
                                Sleep(5);
                            }else{
                                Sleep(20);
                            }
                        }
                        Erobot_y+=height/5;
                        Ey--;
                        EUseMed();
                        ETakeSkin();
                        ECheckMine();
                        Edown_clicked = false;
                    }
                };

                anime.start();
            }
        }
    }
    public void Up(){                                                                                        //Вира!
        if(!up_clicked && !down_clicked && !fire_clicked && !dead && !pause && !ball_clicked && !jetpack_clicked && !robot_explosive && !pull_clicked) {
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
                        while (!dead) {
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
                                if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale), (int)(535*scale))) {
                                    Sleep((int) (game.robot.move_speed * speed));
                                }else{
                                    Sleep((int) (game.robot.move_speed * speed)*4);
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
                        CheckMine();
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
                            if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale-(jetpack_state-30)*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale+(jetpack_state-30)*scale), (int)(535*scale))) {
                                Sleep(5);
                            }else{
                                Sleep(20);
                            }
                        }
                        robot_y-=height/5;
                        y++;
                        UseMed();
                        TakeSkin();
                        CheckMine();
                        up_clicked = false;
                    }
                };

                anime.start();
            }
        }
    }
    public void Down(){                                             //Майна!
        if(!up_clicked && !down_clicked && !fire_clicked  && !dead && !pause && !ball_clicked && !jetpack_clicked && !robot_explosive && !pull_clicked) {
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
                        while (!dead) {

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
                                if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale), (int)(535*scale))) {
                                    Sleep((int) (game.robot.move_speed * speed));
                                }else{
                                    Sleep((int) (game.robot.move_speed * speed)*4);
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
                        CheckMine();
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
                            if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale-(jetpack_state-30)*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale+(jetpack_state-30)*scale), (int)(535*scale))) {
                                Sleep(5);
                            }else{
                                Sleep(20);
                            }
                        }
                        robot_y+=height/5;
                        y--;
                        UseMed();
                        TakeSkin();
                        CheckMine();
                        down_clicked = false;
                    }
                };

                anime.start();
            }
        }
    }
    public void ERedir() {                                                       // Поворот.
        if (!Eredir_clicked && !Efire_clicked && !Edead && !pause && !Eball_clicked && !Epull_clicked) {
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
                            if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale), (int)(535*Escale))) {
                                Sleep((int) (((float) game.robot.Eattack_speed / 1.20f) * speed));
                            }else{
                                Sleep((int) (((float) game.robot.Eattack_speed / 1.20f) * speed)*4);
                            }
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
        if (!redir_clicked && !fire_clicked && !dead && !pause && !ball_clicked && !robot_explosive && !pull_clicked) {
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
                            if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale), (int)(535*scale))) {
                                Sleep((int) (((float) game.robot.attack_speed / 1.20f) * speed));
                            }else{
                                Sleep((int) (((float) game.robot.attack_speed / 1.20f) * speed)*4);
                            }
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
                        if(Ecircle_clicked){
                            while(Ecircle_scale>0.1f ){
                                Ecircle_scale-=0.1f;
                                Sleep(5);
                            }
                        }
                        Eswap = true;
                        move[0].play();
                        while (true) {
                            Escale -= 0.03f;
           
                            if (Escale < 0.1f) {
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
                            Escale += 0.03f;


                            if (Escale > 0.8f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        while(Ecircle_scale<2.0f && Ecircle_clicked){
                            Ecircle_scale+=0.1f;
                            Sleep(5);
                        }
                        EUseMed();
                        ETakeSkin();
                        ECheckMine();
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
         if (!up_clicked && !down_clicked && !jump_clicked && !dead && !pause && !ball_clicked && !jetpack_clicked  && jetpack_can && !robot_explosive && !pull_clicked) {
             jetpack_can = false;
             jetpack_clicked = true;
             Thread anime = new Thread() {
                 @Override
                 public void run() {
                     while(jetpack_state<180){
                         if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale-(jetpack_state-30)*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale+(jetpack_state-30)*scale), (int)(535*scale))) {
                             jetpack_state+=5;
                         }else{
                             jetpack_state+=5/4;
                         }
                         Sleep(10);
                     }
                     jetpack_flying = false;
                     fire_cant = true;
                     jetpack_distance = 8;
                     int dir_x = dir;
                     int dir_robot_y = 0;
                     boolean is_fire_under = false;
                     float move_scale;
                     while(true) {
                         if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale-(jetpack_state-30)*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale+(jetpack_state-30)*scale), (int)(535*scale))) {
                             move_scale = 1f;
                         }else{
                             move_scale = 4f;
                         }
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
                         if (x + dir_x<9 && x+dir_x>0 && jetpack_distance >=0 ) {

                             if(robot_y < 50 && !jetpack_flying ){

                                 robot_y+=5/move_scale;
                             }else{
                                 if(!jetpack_flying) {
                                     fire_cant = false;
                                     jetpack_flying = true;

                                 }
                             }
                             if(!up_clicked && !down_clicked) {
                                 if(!is_fire_under) {
                                     if (rotleg < 30.0f) {
                                         rotleg += 0.6f/move_scale;
                                     } else {

                                         rotleg -= 0.3f/move_scale;
                                     }
                                 }else{
                                     if (rotleg < 50.0f) {
                                         rotleg += 0.6f/move_scale;
                                     } else {

                                         rotleg -= 0.3f/move_scale;
                                     }
                                 }
                             }else{
                                 if(!up_cant && !down_cant) {
                                     if (rotleg < 40.0f) {
                                         rotleg += 0.3f/move_scale;
                                     } else {

                                         rotleg -= 0.6f/move_scale;
                                     }
                                 }
                             }
                             if(jetpack_flying && !up_clicked && !down_clicked) {
                                 if (dir_robot_y == 0) {
                                     robot_y -= 1.0f/move_scale;
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
                                     robot_y += 1.0f/move_scale;
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
                                 jetpack_distance -= 1;

                             } else {
                                 if(!robotboom) {
                                     if (game.robot.jetpack == 2) {
                                         robot_x += (12 + (8-game.robot.attack_speed)) * dir_x/move_scale;
                                     }
                                     if (game.robot.jetpack == 1) {
                                         robot_x += (8 + (8-game.robot.attack_speed)) * dir_x/move_scale;
                                     }
                                 }else{
                                     robot_x += 18 * dir_x/move_scale;
                                 }
                             }

                         }else{
                             break;
                         }
                         Sleep(10);
                     }
                     up_cant = true;
                     down_cant = true;
                     while(jetpack_state>20 || rotleg>0 || robot_y>0) {
                         if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale-(jetpack_state-30)*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale+(jetpack_state-30)*scale), (int)(535*scale))) {
                             move_scale = 1f;
                         }else{
                             move_scale = 4f;
                         }
                         if (!up_clicked && !down_clicked){
                             if (robot_y > 0) {
                                 robot_y -= 15/move_scale;
                             }
                             if (rotleg > 0) {
                                 rotleg -= 1.5f/move_scale;
                             }
                             if (jetpack_state > 20) {
                                 jetpack_state -= 5/move_scale;
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
                     Sleep(7500);
                     jetpack_can = true;
                 }
             };
             anime.start();
         }
     }
    public void EJetpack() {
        if (!Eup_clicked && !Edown_clicked && !Ejump_clicked && !Edead && !pause && !Eball_clicked && !Ejetpack_clicked  && Ejetpack_can && !Epull_clicked) {
            Ejetpack_can = false;
            Ejetpack_clicked = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while(Ejetpack_state<180){
                        if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale-(Ejetpack_state-30)*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale+(Ejetpack_state-30)*Escale), (int)(535*Escale))) {
                            Ejetpack_state+=5;
                        }else{
                            Ejetpack_state+=5/4;
                        }
                        Sleep(10);
                    }
                    Ejetpack_flying = false;
                    Efire_cant = true;
                    Ejetpack_distance = 8;
                    int dir_x = Edir;
                    int dir_robot_y = 0;
                    boolean is_fire_under = false;
                    float move_scale;
                    while(true) {
                        if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale-(Ejetpack_state-30)*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale+(Ejetpack_state-30)*Escale), (int)(535*Escale))) {
                            move_scale = 1f;
                        }else{
                            move_scale = 4f;
                        }
                        if(Ey == 1){
                            if(fire_x_1[ Ex ] != 0) {
                                is_fire_under = true;
                            }
                        }
                        if(Ey == 2){
                            if(fire_x_2[ Ex ] != 0) {
                                is_fire_under = true;
                            }
                        }
                        if(Ey == 3){
                            if(fire_x_3[ Ex ] != 0) {
                                is_fire_under = true;
                            }
                        }
                        if (Ex + dir_x<9 && Ex+dir_x>0 && Ejetpack_distance >=0 ) {

                            if(Erobot_y < 50 && !Ejetpack_flying ){

                                Erobot_y+=5/move_scale;
                            }else{
                                if(!Ejetpack_flying) {
                                    Efire_cant = false;
                                    Ejetpack_flying = true;

                                }
                            }
                            if(!Eup_clicked && !Edown_clicked) {
                                if(!is_fire_under) {
                                    if (Erotleg < 30.0f) {
                                        Erotleg += 0.6f/move_scale;
                                    } else {

                                        Erotleg -= 0.3f/move_scale;
                                    }
                                }else{
                                    if (Erotleg < 50.0f) {
                                        Erotleg += 0.6f/move_scale;
                                    } else {

                                        Erotleg -= 0.3f/move_scale;
                                    }
                                }
                            }else{
                                if(!Eup_cant && !Edown_cant) {
                                    if (Erotleg < 40.0f) {
                                        Erotleg += 0.3f/move_scale;
                                    } else {

                                        Erotleg -= 0.6f/move_scale;
                                    }
                                }
                            }
                            if(Ejetpack_flying && !Eup_clicked && !Edown_clicked) {
                                if (dir_robot_y == 0) {
                                    Erobot_y -= 1.0f/move_scale;
                                    if(!is_fire_under) {
                                        if (Erobot_y < 30) {
                                            dir_robot_y = 1;
                                        }
                                    }else{
                                        if (Erobot_y < 60) {
                                            dir_robot_y = 1;
                                        }
                                    }
                                } else {
                                    Erobot_y += 1.0f/move_scale;
                                    if(!is_fire_under) {
                                        if (Erobot_y > 70) {
                                            dir_robot_y = 0;
                                        }
                                    }else{
                                        if (Erobot_y > 90) {
                                            dir_robot_y = 0;
                                        }
                                    }
                                }
                            }
                            if (Erobot_x > width / 10 || Erobot_x < -width / 10) {
                                if(game.robot.level != 2){
                                    Thread anime = new Thread(){
                                        @Override
                                        public void run() {

                                            if (game.robot.Ejetpack == 1) {
                                                    SetFire(Ex, Ey);
                                            } else {
                                                if(Ey == 1){
                                                    fire_x_1[ Ex ] = 0;
                                                }
                                                if(Ey == 2){
                                                    fire_x_2[ Ex ] = 0;
                                                }
                                                if(Ey == 3){
                                                    fire_x_3[ Ex ] = 0;
                                                }
                                            }
                                        }
                                    };
                                    anime.start();
                                }
                                ETakeSkin();
                                ECheckMine();
                                EUseMed();
                                Ex += dir_x;
                                Erobot_x = 0;
                                Ejetpack_distance -= 1;

                            } else {
                                if(!Erobotboom) {
                                    if (game.robot.Ejetpack == 2) {
                                        Erobot_x += (12 + (8-game.robot.Eattack_speed)) * dir_x/move_scale;
                                    }
                                    if (game.robot.Ejetpack == 1) {
                                        Erobot_x += (8 + (8-game.robot.Eattack_speed)) * dir_x/move_scale;
                                    }
                                }else{
                                    Erobot_x += 18 * dir_x/move_scale;
                                }
                            }

                        }else{
                            break;
                        }
                        Sleep(10);
                    }
                    Eup_cant = true;
                    Edown_cant = true;
                    while(Ejetpack_state>20 || Erotleg>0 || Erobot_y>0) {
                        if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale-(Ejetpack_state-30)*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale+(Ejetpack_state-30)*Escale), (int)(535*Escale))) {
                            move_scale = 1f;
                        }else{
                            move_scale = 4f;
                        }
                        if (!Eup_clicked && !Edown_clicked){
                            if (Erobot_y > 0) {
                                Erobot_y -= 15/move_scale;
                            }
                            if (Erotleg > 0) {
                                Erotleg -= 1.5f/move_scale;
                            }
                            if (Ejetpack_state > 20) {
                                Ejetpack_state -= 5/move_scale;
                            }
                        }
                        Sleep(10);
                    }
                    if(Ey == 1){
                        fire_x_1[ Ex ] = 0;
                    }
                    if(Ey == 2){
                        fire_x_2[ Ex ] = 0;
                    }
                    if(Ey == 3){
                        fire_x_3[ Ex ] = 0;
                    }

                    Efire_cant = false;
                    Erobot_y = 0;
                    Erotleg=0;
                    Ejetpack_state=0;
                    Ejetpack_flying = false;
                    Ejetpack_clicked = false;
                    Eup_cant = false;
                    Edown_cant = false;
                    Sleep(7500);
                    Ejetpack_can = true;
                }
            };
            anime.start();
        }
    }
    public void Jump() {                                                                // На самом деле, это не прыжок, а телепорт. Не баг, а фича!
        if (!up_clicked && !down_clicked && !jump_clicked && !dead && !pause && !ball_clicked) {
            if (EnergyExists(30)) {
                EnergyUse(30);

                jump_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        if(circle_clicked){
                            while(circle_scale>0.1f ){
                                circle_scale-=0.1f;
                                Sleep(5);
                            }
                        }
                        swap = true;
                        move[0].play();
                        while (true) {
                            scale -= 0.03f;


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


                            if (scale > 0.8f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }

                            while(circle_scale<2.0f && circle_clicked){
                                circle_scale+=0.1f;
                                Sleep(5);
                            }

                        UseMed();
                        TakeSkin();
                        CheckMine();
                        swap = false;
                        scale = 0.8f;
                        jump_clicked = false;
                    }
                };
                anime.start();
            }
        }
    }
    public void Saw() {
        if (!dead && !pause && !ball_clicked && saws_entered < 3 ) {
            if (EnergyExists(10)) {
                EnergyUse(10);
                saws_entered++;
                saw_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {

                        int saw_num = saws_entered;
                        for (int i = 0; i < 3; i++) {
                            if (saws[i] == 0) {
                                saw_num = i + 1;
                                break;
                            }
                        }
                        lastsaw = saw_num;

                        saws[saw_num - 1] = dir;
                        saws_pos_x[(saw_num - 1) * 3] = x * (width / 10) + (int) robot_x;
                        saws_pos_x[(saw_num - 1) * 3 + 1] = x * (width / 10) + (int) robot_x;
                        saws_pos_x[(saw_num - 1) * 3 + 2] = x * (width / 10) + (int) robot_x;

                        saws_pos_y[(saw_num - 1) * 3] = y * (height / 5) + (int) (80 * scale + robot_y);
                        saws_pos_y[(saw_num - 1) * 3 + 1] = y * (height / 5) + (int) (80 * scale + robot_y);
                        saws_pos_y[(saw_num - 1) * 3 + 2] = y * (height / 5) + (int) (80 * scale + robot_y);

                        saws_rotate[(saw_num - 1) * 3] = 0.0f;
                        saws_rotate[(saw_num - 1) * 3 + 1] = 1.0f;
                        saws_rotate[(saw_num - 1) * 3 + 2] = 2.0f;
                        saws_aim_x[saw_num - 1] = (x + 5 * dir) * (width / 10);
                        saws_aim_y[saw_num - 1] = y * (height / 5) + (int) ((game.random.nextInt(3) - 1) * 55 * scale);
                        Thread anime2 = new Thread() {
                            @Override
                            public void run() {
                                int saw_num = lastsaw;

                                while (saws[saw_num-1]!=0) {
                                    saws_pos_x[(saw_num - 1) * 3 + 2] = saws_pos_x[(saw_num - 1) * 3 + 1];
                                    saws_pos_x[(saw_num - 1) * 3 + 1] = saws_pos_x[(saw_num - 1) * 3];
                                    saws_pos_y[(saw_num - 1) * 3 + 2] = saws_pos_y[(saw_num - 1) * 3 + 1];
                                    saws_pos_y[(saw_num - 1) * 3 + 1] = saws_pos_y[(saw_num - 1) * 3];
                                    saws_rotate[(saw_num - 1) * 3 + 2] = saws_rotate[(saw_num - 1) * 3 + 1];
                                    saws_rotate[(saw_num - 1) * 3 + 1] = saws_rotate[(saw_num - 1) * 3];
                                    if ((float)Math.round((float) saws_pos_x[(saw_num - 1) * 3] / (float) (width / 10)) == Ex && (float)Math.round((float)( saws_pos_y[(saw_num - 1) * 3]) / (float) (height / 5)) == Ey) {
                                        DamageEnemy((8 - game.robot.attack_speed) * 4);
                                    }
                                    Sleep(80);
                                }
                            }
                        };
                        anime2.start();
                        while (saws_pos_x[(saw_num - 1) * 3] != saws_aim_x[saw_num - 1] || saws_pos_y[(saw_num - 1) * 3] != saws_aim_y[saw_num - 1]) {
                            if (saws_pos_x[(saw_num - 1) * 3] < saws_aim_x[saw_num - 1]) {
                                saws_pos_x[(saw_num - 1) * 3] += game.random.nextInt(3) + 2;
                            }
                            if (saws_pos_x[(saw_num - 1) * 3] > saws_aim_x[saw_num - 1]) {
                                saws_pos_x[(saw_num - 1) * 3] -= game.random.nextInt(3) + 2;
                            }
                            if (saws_pos_y[(saw_num - 1) * 3] < saws_aim_y[saw_num - 1]) {
                                saws_pos_y[(saw_num - 1) * 3] += game.random.nextInt(3) + 2;
                            }
                            if (saws_pos_y[(saw_num - 1) * 3] > saws_aim_y[saw_num - 1]) {
                                saws_pos_y[(saw_num - 1) * 3] -= game.random.nextInt(3) + 2;
                            }
                            saws_rotate[(saw_num - 1) * 3] += 1.25f;
                            if (saws_rotate[(saw_num - 1) * 3] >= 360.0f) {
                                saws_rotate[(saw_num - 1) * 3] = 0.0f;
                            }
                            if(!ECheckCircle(saws_pos_x[(saw_num - 1) * 3], saws_pos_y[(saw_num - 1) * 3], 200, 200)) {
                                Sleep(5);
                            }else{
                                Sleep(40);
                            }
                        }
                        while (saws_pos_x[(saw_num - 1) * 3] != x * (width / 10) + (int) robot_x || saws_pos_y[(saw_num - 1) * 3] != y * (height / 5) + (int) (80 * scale + robot_y)) {

                            if (saws_pos_x[(saw_num - 1) * 3] < x * (width / 10) + (int) robot_x) {
                                saws_pos_x[(saw_num - 1) * 3] += game.random.nextInt(3) + 2;
                            }
                            if (saws_pos_x[(saw_num - 1) * 3] > x * (width / 10) + (int) robot_x) {
                                saws_pos_x[(saw_num - 1) * 3] -= game.random.nextInt(3) + 2;
                            }
                            if (saws_pos_y[(saw_num - 1) * 3] < y * (height / 5) + (int) (80 * scale + robot_y)) {
                                saws_pos_y[(saw_num - 1) * 3] += game.random.nextInt(3) + 2;
                            }
                            if (saws_pos_y[(saw_num - 1) * 3] > y * (height / 5) + (int) (80 * scale + robot_y)) {
                                saws_pos_y[(saw_num - 1) * 3] -= game.random.nextInt(3) + 2;
                            }
                            saws_rotate[(saw_num - 1) * 3] -= 1.25f;
                            if (saws_rotate[(saw_num - 1) * 3] <= 0.0f) {
                                saws_rotate[(saw_num - 1) * 3] = 360.0f;
                            }
                            if(!ECheckCircle(saws_pos_x[(saw_num - 1) * 3], saws_pos_y[(saw_num - 1) * 3], 200, 200)) {
                                Sleep(5);
                            }else{
                                Sleep(40);
                            }
                        }
                        saws[saw_num - 1] = 0;
                        saws_entered--;
                        if (saws_entered <= 0) {
                            saw_clicked = false;
                        }

                    }
                };
                anime.start();
            }
        }
    }

    public void ESaw() {
        if (!Edead && !pause && !Eball_clicked && Esaws_entered < 3 && Esaw_can) {
            if (EEnergyExists(10)) {
                EEnergyUse(10);
                Esaw_can = false;
                Esaws_entered++;
                Esaw_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {

                        int saw_num = Esaws_entered;
                        for (int i = 0; i < 3; i++) {
                            if (Esaws[i] == 0) {
                                saw_num = i + 1;
                                break;
                            }
                        }

                        Elastsaw = saw_num;

                        Esaws[saw_num - 1] = Edir;

                        Esaws_pos_x[(saw_num - 1) * 3] = Ex * (width / 10) + (int) Erobot_x;
                        Esaws_pos_x[(saw_num - 1) * 3 + 1] = Ex * (width / 10) + (int) Erobot_x;
                        Esaws_pos_x[(saw_num - 1) * 3 + 2] = Ex * (width / 10) + (int) Erobot_x;

                        Esaws_pos_y[(saw_num - 1) * 3] = Ey * (height / 5) + (int) (80 * Escale + Erobot_y);
                        Esaws_pos_y[(saw_num - 1) * 3 + 1] = Ey * (height / 5) + (int) (80 * Escale + Erobot_y);
                        Esaws_pos_y[(saw_num - 1) * 3 + 2] = Ey * (height / 5) + (int) (80 * Escale + Erobot_y);

                        Esaws_rotate[(saw_num - 1) * 3] = 0.0f;
                        Esaws_rotate[(saw_num - 1) * 3 + 1] = 1.0f;
                        Esaws_rotate[(saw_num - 1) * 3 + 2] = 2.0f;
                        Esaws_aim_x[saw_num - 1] = (Ex + 5 * Edir) * (width / 10);
                        Esaws_aim_y[saw_num - 1] = Ey * (height / 5) + (int) ((game.random.nextInt(3) - 1) * 55 * Escale);

                        Thread Eanime2 = new Thread() {
                            @Override
                            public void run() {

                                int saw_num = Elastsaw;

                                while (Esaws[saw_num-1]!=0) {
                                    Esaws_pos_x[(saw_num - 1) * 3 + 2] = Esaws_pos_x[(saw_num - 1) * 3 + 1];
                                    Esaws_pos_x[(saw_num - 1) * 3 + 1] = Esaws_pos_x[(saw_num - 1) * 3];
                                    Esaws_pos_y[(saw_num - 1) * 3 + 2] = Esaws_pos_y[(saw_num - 1) * 3 + 1];
                                    Esaws_pos_y[(saw_num - 1) * 3 + 1] = Esaws_pos_y[(saw_num - 1) * 3];
                                    Esaws_rotate[(saw_num - 1) * 3 + 2] = Esaws_rotate[(saw_num - 1) * 3 + 1];
                                    Esaws_rotate[(saw_num - 1) * 3 + 1] = Esaws_rotate[(saw_num - 1) * 3];
                                    if ((float)Math.round((float) Esaws_pos_x[(saw_num - 1) * 3] / (float) (width / 10)) == x && (float)Math.round((float)( Esaws_pos_y[(saw_num - 1) * 3]) / (float) (height / 5)) == y) {
                                        DamageRobot((8 - game.robot.Eattack_speed) * 4);
                                    }
                                    Sleep(80);
                                }
                            }
                        };
                        Eanime2.start();
                        Esaw_can = true;
                        while (Esaws_pos_x[(saw_num - 1) * 3] != Esaws_aim_x[saw_num - 1] || Esaws_pos_y[(saw_num - 1) * 3] != Esaws_aim_y[saw_num - 1]) {



                                if (Esaws_pos_x[(saw_num - 1) * 3] < Esaws_aim_x[saw_num - 1]) {
                                    Esaws_pos_x[(saw_num - 1) * 3] += game.random.nextInt(3) + 2;
                                }
                                if (Esaws_pos_x[(saw_num - 1) * 3] > Esaws_aim_x[saw_num - 1]) {
                                    Esaws_pos_x[(saw_num - 1) * 3] -= game.random.nextInt(3) + 2;
                                }
                                if (Esaws_pos_y[(saw_num - 1) * 3] < Esaws_aim_y[saw_num - 1]) {
                                    Esaws_pos_y[(saw_num - 1) * 3] += game.random.nextInt(3) + 2;
                                }
                                if (Esaws_pos_y[(saw_num - 1) * 3] > Esaws_aim_y[saw_num - 1]) {
                                    Esaws_pos_y[(saw_num - 1) * 3] -= game.random.nextInt(3) + 2;
                                }
                                Esaws_rotate[(saw_num - 1) * 3] += 1.25f;
                                if (Esaws_rotate[(saw_num - 1) * 3] >= 360.0f) {
                                    Esaws_rotate[(saw_num - 1) * 3] = 0.0f;
                                }

                            if(!CheckCircle(Esaws_pos_x[(saw_num - 1) * 3], Esaws_pos_y[(saw_num - 1) * 3], 200, 200)) {
                                Sleep(5);
                            }else{
                                Sleep(40);
                            }
                        }
                        while (Esaws_pos_x[(saw_num - 1) * 3] != Ex * (width / 10) + (int) Erobot_x || Esaws_pos_y[(saw_num - 1) * 3] != Ey * (height / 5) + (int) (80 * Escale + Erobot_y)) {

                            if (Esaws_pos_x[(saw_num - 1) * 3] < Ex * (width / 10) + (int) Erobot_x) {
                                Esaws_pos_x[(saw_num - 1) * 3] += game.random.nextInt(3) + 2;
                            }
                            if (Esaws_pos_x[(saw_num - 1) * 3] > Ex * (width / 10) + (int) Erobot_x) {
                                Esaws_pos_x[(saw_num - 1) * 3] -= game.random.nextInt(3) + 2;
                            }
                            if (Esaws_pos_y[(saw_num - 1) * 3] < Ey * (height / 5) + (int) (80 * Escale + Erobot_y)) {
                                Esaws_pos_y[(saw_num - 1) * 3] += game.random.nextInt(3) + 2;
                            }
                            if (Esaws_pos_y[(saw_num - 1) * 3] > Ey * (height / 5) + (int) (80 * Escale + Erobot_y)) {
                                Esaws_pos_y[(saw_num - 1) * 3] -= game.random.nextInt(3) + 2;
                            }
                            Esaws_rotate[(saw_num - 1) * 3] -= 1.25f;
                            if (Esaws_rotate[(saw_num - 1) * 3] <= 0.0f) {
                                Esaws_rotate[(saw_num - 1) * 3] = 360.0f;
                            }
                            if(!CheckCircle(Esaws_pos_x[(saw_num - 1) * 3], Esaws_pos_y[(saw_num - 1) * 3], 200, 200)) {
                                Sleep(5);
                            }else{
                                Sleep(40);
                            }
                        }
                        Esaws[saw_num - 1] = 0;
                        Esaws_entered--;
                        if (Esaws_entered <= 0) {
                            Esaw_clicked = false;
                        }

                    }
                };
                anime.start();
            }
        }
    }
    public boolean CheckCircle(int Nx, int Ny, int Nwidth, int Nheight){
        //x * (width / 10) + (int) robot_x-175*circle_scale+100*scale, (height / 5) * y - 60 - 10 * y + (int) robot_y+(220*scale)-175*circle_scale+15
      boolean detect_x = false;
      boolean detect_y = false;

      if((Nx>=x * (width / 10) + (int) robot_x-150*circle_scale+100*scale && Nx<=x * (width / 10) + (int) robot_x-150*circle_scale+100*scale+300*circle_scale)||(Nx+Nwidth>=x * (width / 10) + (int) robot_x-150*circle_scale+100*scale && Nx+Nwidth<=x * (width / 10) + (int) robot_x-150*circle_scale+100*scale+300*circle_scale)){
          detect_x = true;
      }
        if((Ny>=(height / 5) * y - 60 - 10 * y + (int) robot_y+(220*scale)-150*circle_scale+15 && Ny<=(height / 5) * y - 60 - 10 * y + (int) robot_y+(220*scale)-150*circle_scale+15+300*circle_scale)||(Ny+Nheight>=(height / 5) * y - 60 - 10 * y + (int) robot_y+(220*scale)-150*circle_scale+15 && Ny+Nheight<=(height / 5) * y - 60 - 10 * y + (int) robot_y+(220*scale)-150*circle_scale+15+300*circle_scale)){
            detect_y = true;
        }
        return  detect_x && detect_y;
    }
    public boolean ECheckCircle(int Nx, int Ny, int Nwidth, int Nheight){
        //x * (width / 10) + (int) robot_x-175*circle_scale+100*scale, (height / 5) * y - 60 - 10 * y + (int) robot_y+(220*scale)-175*circle_scale+15
        boolean detect_x = false;
        boolean detect_y = false;
        if((Nx>=Ex * (width / 10) + (int) Erobot_x-175*Ecircle_scale+100*Escale && Nx<=Ex * (width / 10) + (int) Erobot_x-175*Ecircle_scale+100*Escale+300*Ecircle_scale)||(Nx+Nwidth>=Ex * (width / 10) + (int) Erobot_x-175*Ecircle_scale+100*Escale && Nx+Nwidth<=Ex * (width / 10) + (int) Erobot_x-175*Ecircle_scale+100*Escale+300*Ecircle_scale)){
            detect_x = true;
        }
        if((Ny>=(height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y+(220*Escale)-175*Ecircle_scale+15 && Ny<=(height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y+(220*Escale)-175*Ecircle_scale+15+300*Ecircle_scale)||(Ny+Nheight>=(height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y+(220*Escale)-175*Ecircle_scale+15 && Ny+Nheight<=(height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y+(220*Escale)-175*Ecircle_scale+15+300*Ecircle_scale)){
            detect_y = true;
        }
        return  detect_x && detect_y;
    }
    public void Circle(){
        if (!dead && !pause  && !circle_clicked && !jump_clicked && circle_can && !pull_clicked) {
            circle_clicked = true;
            circle_can = false;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    circle_scale = 0.0f;

                    while(circle_scale<2.0f && !jump_clicked){
                        circle_scale+=0.05f;
                        Sleep(10);
                    }
                    Sleep(5000);
                    while(circle_scale>0.0f){
                        if(!jump_clicked) {
                            circle_scale -= 0.05f;
                        }
                        Sleep(10);
                    }
                    circle_clicked = false;
                }
            };
            anime.start();
            Thread anime2 = new Thread() {
                @Override
                public void run() {
                    int dir_rotate = 1;
                    while(circle_clicked){
                        if(dir_rotate == 1){
                            circle_rotate+=2.5f;
                            if(circle_rotate>=15.0f){
                                dir_rotate = 0;
                            }
                        }else{
                            circle_rotate-=2.5f;
                            if(circle_rotate<=-15.0f){
                                dir_rotate = 1;
                            }
                        }
                        Sleep(5);
                    }
                    Sleep(5000);
                    circle_can = true;
                }
            };
            anime2.start();
        }
    }
     public void ECircle(){
         if (!Edead && !pause  && !Ecircle_clicked && !Ejump_clicked && Ecircle_can && !Epull_clicked) {
             Ecircle_clicked = true;
             Ecircle_can = false;
             Thread anime = new Thread() {
                 @Override
                 public void run() {
                     Ecircle_scale = 0.0f;

                     while(Ecircle_scale<2.0f && !Ejump_clicked){
                         Ecircle_scale+=0.05f;
                         Sleep(10);
                     }
                     Sleep(5000);
                     while(Ecircle_scale>0.0f){
                         if(!Ejump_clicked) {
                             Ecircle_scale -= 0.05f;
                         }
                         Sleep(10);
                     }
                     Ecircle_clicked = false;
                 }
             };
             anime.start();
             Thread anime2 = new Thread() {
                 @Override
                 public void run() {
                     int dir_rotate = 1;
                     while(Ecircle_clicked){
                         if(dir_rotate == 1){
                             Ecircle_rotate+=2.5f;
                             if(Ecircle_rotate>=15.0f){
                                 dir_rotate = 0;
                             }
                         }else{
                             Ecircle_rotate-=2.5f;
                             if(Ecircle_rotate<=-15.0f){
                                 dir_rotate = 1;
                             }
                         }
                         Sleep(5);
                     }
                     Sleep(5000);
                     Ecircle_can = true;
                 }
             };
             anime2.start();
         }
     }

     public void EExplosive(int dir_x, int dir_y) {
         if (!enemy_explosive) {
             enemy_explosive = true;
             Eexplosive_dir_x = dir_x;
             Eexplosive_dir_y = dir_y;

             Thread anime = new Thread() {
                 @Override
                 public void run() {

                     int will_x_1 = Eexplosive_dir_x * width / 5;
                     int will_x_2 = Eexplosive_dir_x * (int)(width / 2.5f);



                     float last_rothand = Erothand;
                     int access = 0;
                     while (access != 1) {
                         Erothand-=2f*Eexplosive_dir_x;
                         if(Erothand>=360){
                             Erothand = 0.0f;
                         }
                         if(Erothand<0){
                             Erothand = 360.0f;
                         }
                         if(Erotleg<100){
                             Erotleg+=0.5f;
                         }
                         Erobot_x += Eexplosive_dir_x*5;
                         Erobot_y += Eexplosive_dir_y*2;
                         if ((Erobot_x >= will_x_1 - 10 && Erobot_x <= will_x_1 + 10) || Erobot_x+width/10*Ex >= width-2*width/10 ||  Erobot_x+width/10*Ex <= width/10 ) {
                             access = 1;
                         }
                         if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale), (int)(535*Escale))) {
                             Sleep(4);
                         }else{
                             Sleep(16);
                         }
                     }
                     while (access != 2) {
                         Erothand-=2f*Eexplosive_dir_x;
                         if(Erothand>=360){
                             Erothand = 0.0f;
                         }
                         if(Erothand<0){
                             Erothand = 360.0f;
                         }
                         if(Erotleg>0){
                             Erotleg-=0.25f;
                         }
                         Erobot_x += Eexplosive_dir_x*5;
                         Erobot_y -= Eexplosive_dir_y*2;
                         if ((Erobot_x >= will_x_2 - 10 && Erobot_x <= will_x_2 + 10) || Erobot_x+width/10*Ex >= width-2*width/10||  Erobot_x+width/10*Ex <= width/10 ) {
                             access = 2;
                         }
                         if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale), (int)(535*Escale))) {
                             Sleep(4);
                         }else{
                             Sleep(16);
                         }
                     }
                     while(Erobot_y>0){
                         Erobot_y-=2;
                         if(Erotleg>0){
                             Erotleg-=0.25f;
                         }
                         if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale), (int)(535*Escale))) {
                             Sleep(4);
                         }else{
                             Sleep(16);
                         }
                     }
                     while(Erothand>last_rothand+3||Erothand<last_rothand-3){
                         Erothand-=2.5f*Eexplosive_dir_x;
                         if(Erothand>360){
                             Erothand = 0.0f;
                         }
                         if(Erothand<0){
                             Erothand = 360.0f;
                         }
                         if(Erotleg>0){
                             Erotleg-=0.5f;
                         }
                         if(!CheckCircle(Ex * (width / 10) + (int) Erobot_x - (int)(90*Escale), (height / 5) * Ey - 60 - 10 * Ey + (int) Erobot_y, (int)(380*Escale), (int)(535*Escale))) {
                             Sleep(4);
                         }else{
                             Sleep(16);
                         }
                     }
                     Ex += Math.round(Erobot_x/(width/10));
                     Erobot_x=0;
                     enemy_explosive = false;
                     CheckMine();
                     ETakeSkin();
                     EUseMed();
                 }
             };
             anime.start();
         }
     }

    public void Explosive(int dir_x, int dir_y) {
        if (!robot_explosive) {
            robot_explosive = true;
            explosive_dir_x = dir_x;
            explosive_dir_y = dir_y;

            Thread anime = new Thread() {
                @Override
                public void run() {

                    int will_x_1 = explosive_dir_x * width / 5;
                    int will_x_2 = explosive_dir_x * (int)(width / 2.5f);



                    float last_rothand = rothand;
                    int access = 0;
                    while (access != 1) {
                        rothand-=2f*explosive_dir_x;
                        if(rothand>=360){
                           rothand = 0.0f;
                        }
                        if(rothand<0){
                            rothand = 360.0f;
                        }
                        if(rotleg<100){
                            rotleg+=0.5f;
                        }
                        robot_x += explosive_dir_x*5;
                        robot_y += explosive_dir_y*2;
                        if ((robot_x >= will_x_1 - 10 && robot_x <= will_x_1 + 10) || robot_x+width/10*x >= width-2*width/10 ||  robot_x+width/10*x <= width/10 ) {
                            access = 1;
                        }
                        if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale), (int)(535*scale))) {
                            Sleep(4);
                        }else{
                            Sleep(16);
                        }
                    }
                    while (access != 2) {
                        rothand-=2f*explosive_dir_x;
                        if(rothand>=360){
                            rothand = 0.0f;
                        }
                        if(rothand<0){
                            rothand = 360.0f;
                        }
                        if(rotleg>0){
                            rotleg-=0.25f;
                        }
                        robot_x += explosive_dir_x*5;
                        robot_y -= explosive_dir_y*2;
                        if ((robot_x >= will_x_2 - 10 && robot_x <= will_x_2 + 10) || robot_x+width/10*x >= width-2*width/10||  robot_x+width/10*x <= width/10 ) {
                            access = 2;
                        }
                        if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale), (int)(535*scale))) {
                            Sleep(4);
                        }else{
                            Sleep(16);
                        }
                    }
                    while(robot_y>0){
                        robot_y-=2;
                        if(rotleg>0){
                            rotleg-=0.25f;
                        }
                        if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale), (int)(535*scale))) {
                            Sleep(4);
                        }else{
                            Sleep(16);
                        }
                    }
                    while(rothand>last_rothand+3||rothand<last_rothand-3){
                        rothand-=2.5f*explosive_dir_x;
                        if(rothand>360){
                            rothand = 0.0f;
                        }
                        if(rothand<0){
                            rothand = 360.0f;
                        }
                        if(rotleg>0){
                            rotleg-=0.5f;
                        }
                        if(!ECheckCircle(x * (width / 10) + (int) robot_x - (int)(90*scale), (height / 5) * y - 60 - 10 * y + (int) robot_y, (int)(380*scale), (int)(535*scale))) {
                            Sleep(4);
                        }else{
                            Sleep(16);
                        }
                    }
                    x += Math.round(robot_x/(width/10));
                    robot_x=0;
                    robot_explosive = false;
                    CheckMine();
                    TakeSkin();
                    UseMed();
                }
            };
            anime.start();
        }
    }
     public void CheckMine() {
         for(int i=0;i<3;i++){
             if(Math.round((Emine_x[i]+200*Emine_scale[i])/(width/10))==x&&Math.floor((Emine_y[i]+90*Emine_scale[i])/(height/5))+1==y&&Emine_exist[i] == 2){
                 Emine_exist[i] = 3;
                 Explosive(dir, 1);
             }
         }
     }
     public void ECheckMine() {
         for(int i=0;i<3;i++){
             if(Math.round((mine_x[i]+200*mine_scale[i])/(width/10))==Ex&&Math.floor((mine_y[i]+90*mine_scale[i])/(height/5))+1==Ey&&mine_exist[i] == 2){
                 mine_exist[i] = 3;
                 EExplosive(Edir, 1);
             }
         }
     }
    public void Mine(){
        if(mines < 3){
            mine_clicked = true;
            mines++;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    int move_y_dir = 0;
                    int steps = 0;
                    int num = 0;
                    while (true) {
                        if (mine_exist[num] == 0) break;
                        num++;
                    }
                    mine_rotate[num] = 0.0f;
                    mine_exist[num] = 1;
                    leg_scale[num] = 1.0f;
                    mine_x[num] = (int)((x*width/10)+robot_x);
                    mine_y[num] = (int)((y*height/5)+robot_y);
                    float last_scale;
                    mine_scale[num] = 0.3f;
                    int will_y = (height/5)*y-65-y*10;
                    while(mine_y[num] > will_y){
                        mine_y[num]-=5;
                        if(!ECheckCircle(mine_x[num], (int)(mine_y[num]+90*mine_scale[num]), (int)(400*mine_scale[num]), (int)(400*mine_scale[num]))) {
                            Sleep(10);
                        }else{
                            Sleep(80);
                        }
                    }
                    while(mine_y[num] < will_y){
                        mine_y[num]+=5;
                        if(!ECheckCircle(mine_x[num], (int)(mine_y[num]+90*mine_scale[num]), (int)(400*mine_scale[num]), (int)(400*mine_scale[num]))) {
                            Sleep(10);
                        }else{
                            Sleep(80);
                        }
                    }

                    last_scale = mine_scale[num];
                    while(mine_exist[num] == 1 && steps<20){
                        int move_random = game.random.nextInt(2);
                        int last_mine_x = mine_x[num];
                        if(move_random == 0 && last_mine_x+width/10<width-width/5) {
                            while (mine_x[num] < last_mine_x+width/10) {
                                mine_x[num]+=5;
                                if(!ECheckCircle(mine_x[num], (int)(mine_y[num]+90*mine_scale[num]), (int)(400*mine_scale[num]), (int)(400*mine_scale[num]))) {
                                    Sleep(10);
                                }else{
                                    Sleep(80);
                                }
                            }
                        }
                        if(move_random == 1 && last_mine_x-width/10>width/10) {
                            while (mine_x[num] > last_mine_x-width/10) {
                                mine_x[num]-=5;
                                if(!ECheckCircle(mine_x[num], (int)(mine_y[num]+90*mine_scale[num]), (int)(400*mine_scale[num]), (int)(400*mine_scale[num]))) {
                                    Sleep(10);
                                }else{
                                    Sleep(80);
                                }
                            }
                        }
                        if(move_y_dir == 0){
                            mine_scale[num]+=0.001f;
                            if(mine_scale[num] > last_scale+0.02f){
                                move_y_dir = 1;
                            }
                        }else{
                            mine_scale[num]-=0.01f;
                            if(mine_scale[num] < last_scale-0.02f){
                                move_y_dir = 0;
                            }
                        }
                        steps++;
                    }
                    mine_exist[num] = 2;
                    int last_mine_y = mine_y[num];
                    while(mine_exist[num] == 2){
                        if(mine_y[num] > last_mine_y-70){
                            mine_y[num]-=2;
                        }
                        if(mine_scale[num] < last_scale+0.1f){
                            mine_scale[num]+=0.005f;
                        }
                        if(leg_scale[num] > 0.0f){
                           leg_scale[num]-=0.01f;
                        }
                        if(!ECheckCircle(mine_x[num], (int)(mine_y[num]+90*mine_scale[num]), (int)(400*mine_scale[num]), (int)(400*mine_scale[num]))) {
                            Sleep(10);
                        }else{
                            Sleep(80);
                        }
                    }
                    while(mine_scale[num]<1.75f){

                        DamageEnemy(8-(game.robot.attack_speed)*2);
                        explosive_anime++;
                        if(explosive_anime>=8){
                            explosive_anime=0;
                        }


                            mine_scale[num]+=0.05f;
                            mine_rotate[num]+=1.0f;
                            if(mine_rotate[num]>=360.0f){
                                mine_rotate[num]=0f;
                            }
                        if(!ECheckCircle(mine_x[num], (int)(mine_y[num]+90*mine_scale[num]), (int)(400*mine_scale[num]), (int)(400*mine_scale[num]))) {
                            Sleep(10);
                        }else{
                            Sleep(80);
                        }
                    }
                    while(mine_scale[num]>0.1f){


                        explosive_anime--;
                        if(explosive_anime<0){
                            explosive_anime=7;
                        }


                        mine_scale[num]-=0.05f;
                        mine_rotate[num]+=1.0f;
                        if(mine_rotate[num]>=360.0f){
                            mine_rotate[num]=0f;
                        }
                        if(!ECheckCircle(mine_x[num], (int)(mine_y[num]+90*mine_scale[num]), (int)(400*mine_scale[num]), (int)(400*mine_scale[num]))) {
                            Sleep(10);
                        }else{
                            Sleep(80);
                        }
                    }
                    mine_exist[num]=0;
                    mines--;

                }
            };
            anime.start();
        }
    }



     public void EMine(){
         if(Emines < 3){
             Emine_clicked = true;
             Emines++;
             Thread anime = new Thread() {
                 @Override
                 public void run() {
                     int move_y_dir = 0;
                     int steps = 0;
                     int num = 0;
                     while (true) {
                         if (Emine_exist[num] == 0) break;
                         num++;
                     }
                     Emine_rotate[num] = 0.0f;
                     Emine_exist[num] = 1;
                     Eleg_scale[num] = 1.0f;
                     Emine_x[num] = (int)((Ex*width/10)+Erobot_x);
                     Emine_y[num] = (int)((Ey*height/5)+Erobot_y);
                     float last_scale;
                     Emine_scale[num] = 0.3f;
                     int will_y = (height/5)*Ey-65-Ey*10;
                     while(Emine_y[num] > will_y){
                         Emine_y[num]-=5;
                         if(!CheckCircle(Emine_x[num], (int)(Emine_y[num]+90*Emine_scale[num]), (int)(400*Emine_scale[num]), (int)(400*Emine_scale[num]))) {
                             Sleep(10);
                         }else{
                             Sleep(80);
                         }
                     }
                     while(Emine_y[num] < will_y){
                         Emine_y[num]+=5;
                         if(!CheckCircle(Emine_x[num], (int)(Emine_y[num]+90*Emine_scale[num]), (int)(400*Emine_scale[num]), (int)(400*Emine_scale[num]))) {
                             Sleep(10);
                         }else{
                             Sleep(80);
                         }
                     }

                     last_scale = Emine_scale[num];
                     while(Emine_exist[num] == 1 && steps<20){
                         int move_random = game.random.nextInt(2);
                         int last_mine_x = Emine_x[num];
                         if(move_random == 0 && last_mine_x+width/10<width-width/5) {
                             while (Emine_x[num] < last_mine_x+width/10) {
                                 Emine_x[num]+=5;
                                 if(!CheckCircle(Emine_x[num], (int)(Emine_y[num]+90*Emine_scale[num]), (int)(400*Emine_scale[num]), (int)(400*Emine_scale[num]))) {
                                     Sleep(10);
                                 }else{
                                     Sleep(80);
                                 }
                             }
                         }
                         if(move_random == 1 && last_mine_x-width/10>width/10) {
                             while (Emine_x[num] > last_mine_x-width/10) {
                                 Emine_x[num]-=5;
                                 if(!CheckCircle(Emine_x[num], (int)(Emine_y[num]+90*Emine_scale[num]), (int)(400*Emine_scale[num]), (int)(400*Emine_scale[num]))) {
                                     Sleep(10);
                                 }else{
                                     Sleep(80);
                                 }
                             }
                         }
                         if(move_y_dir == 0){
                             Emine_scale[num]+=0.001f;
                             if(Emine_scale[num] > last_scale+0.02f){
                                 move_y_dir = 1;
                             }
                         }else{
                             Emine_scale[num]-=0.01f;
                             if(Emine_scale[num] < last_scale-0.02f){
                                 move_y_dir = 0;
                             }
                         }
                         steps++;
                     }
                     Emine_exist[num] = 2;
                     int last_mine_y = Emine_y[num];
                     while(Emine_exist[num] == 2){
                         if(Emine_y[num] > last_mine_y-70){
                             Emine_y[num]-=2;
                         }
                         if(Emine_scale[num] < last_scale+0.1f){
                             Emine_scale[num]+=0.005f;
                         }
                         if(Eleg_scale[num] > 0.0f){
                             Eleg_scale[num]-=0.01f;
                         }
                         if(!CheckCircle(Emine_x[num], (int)(Emine_y[num]+90*Emine_scale[num]), (int)(400*Emine_scale[num]), (int)(400*Emine_scale[num]))) {
                             Sleep(10);
                         }else{
                             Sleep(80);
                         }
                     }
                     while(Emine_scale[num]<1.75f){

                         DamageRobot(8-(game.robot.Eattack_speed)*2);
                         Eexplosive_anime++;
                         if(Eexplosive_anime>=8){
                             Eexplosive_anime=0;
                         }


                         Emine_scale[num]+=0.05f;
                         Emine_rotate[num]+=1.0f;
                         if(Emine_rotate[num]>=360.0f){
                             Emine_rotate[num]=0f;
                         }
                         if(!ECheckCircle(Emine_x[num], (int)(Emine_y[num]+90*Emine_scale[num]), (int)(400*Emine_scale[num]), (int)(400*Emine_scale[num]))) {
                             Sleep(10);
                         }else{
                             Sleep(80);
                         }
                     }
                     while(Emine_scale[num]>0.1f){


                         Eexplosive_anime--;
                         if(Eexplosive_anime<0){
                             Eexplosive_anime=7;
                         }


                         Emine_scale[num]-=0.05f;
                         Emine_rotate[num]+=1.0f;
                         if(Emine_rotate[num]>=360.0f){
                             Emine_rotate[num]=0f;
                         }
                         if(!ECheckCircle(Emine_x[num], (int)(Emine_y[num]+90*Emine_scale[num]), (int)(400*Emine_scale[num]), (int)(400*Emine_scale[num]))) {
                             Sleep(10);
                         }else{
                             Sleep(80);
                         }
                     }
                     Emine_exist[num]=0;
                     Emines--;

                 }
             };
             anime.start();
         }
     }

    @Override
    public void dispose (){

        if(game.robot.power_large==4) {
            button_circle.dispose();
        }
        if(game.robot.power_small==2) {
            button_mine.dispose();
        }
        Rblaster[0].dispose();
        Rblaster[1].dispose();
        Rblaster[2].dispose();
        Lblaster[0].dispose();
        Lblaster[1].dispose();
        Lblaster[2].dispose();
        ERblaster[0].dispose();
        ERblaster[1].dispose();
        ERblaster[2].dispose();
        ELblaster[0].dispose();
        ELblaster[1].dispose();
        ELblaster[2].dispose();
        hit[0].dispose();
        hit[1].dispose();
        hit[2].dispose();
        move[0].dispose();
        move[1].dispose();
        move[2].dispose();
        for(Texture texture: med){ texture.dispose(); }
        if(game.robot.Epower_small==1) {
            for(Texture texture: Esawt){ texture.dispose(); }

        }
        if(game.robot.power_small==1) {
            for (Texture texture : sawt) {
                texture.dispose();
            }
            button_saw.dispose();
        }
        if(game.robot.power_small==4) {
            pull.dispose();
        }
        for(Texture texture: explosivet){ texture.dispose(); }
        death.dispose();
        grass.dispose();
        game.robot.DisposeGamePlayTextures();
        Frontground.dispose();
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
        fire_touched.dispose();
        boom_front[0].dispose();
        boom_front[1].dispose();
        boom_front[2].dispose();
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
        booms[3].dispose();
        booms[4].dispose();
        booms[5].dispose();
        booms[6].dispose();
        if (game.robot.power_large==3||game.robot.power_large==2 ) {
            jetpack.dispose();
        }
        if(game.robot.power_small==3) {
            jump.dispose();
        }
        if(game.robot.power_large==1) {
            ball.dispose();
        }
        begin_left[0].dispose();
        begin_left[1].dispose();
        begin_left[2].dispose();
        begin_right[0].dispose();
        begin_right[1].dispose();
        begin_right[2].dispose();
        background.dispose();

        if(game.robot.level == 5) {
            rain[0].dispose();
            rain[1].dispose();
            rain[2].dispose();
        }
        big_grass.dispose();
        level_circle.dispose();
        level_back.dispose();
        level_front.dispose();
        level_line.dispose();
        machine_4.dispose();
        machine_2.dispose();
        machine_3.dispose();
        if(game.robot.power_large==4||game.robot.Epower_large==4) {
            circlet.dispose();

        }
        if(game.robot.power_small == 5) {
           plasma.dispose();
           plasma_ball.dispose();
           plasma_tail.dispose();
        }
        Frontcolor.dispose();
        button_touched.dispose();
        button_cant_touch.dispose();
        button_control.dispose();
        button_control_back.dispose();
        if(game.robot.power_small==2||game.robot.Epower_small==2) {
            mine.dispose();
            mine_off.dispose();
        }
        if(game.robot.level!=2) {
            fire_location[0].dispose();
            fire_location[1].dispose();
            fire_location[2].dispose();
            fire_location[3].dispose();
            fire_location[4].dispose();

        }
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