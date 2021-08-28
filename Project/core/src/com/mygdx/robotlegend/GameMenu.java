package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class GameMenu extends Openable implements Screen{
    SpriteBatch batch;
    Thread anime_smoke;
    Thread anime_hand;
    Thread anime_grass;
    Thread ring_anime;
    Thread space_anime;
    Sound[] hush = new Sound[3];
    Texture camp;
    Texture play;
    Texture close;
    Texture music;
    Texture music_stop;
    Texture workspace;
    Texture grass;
    Texture gear;
    Texture chip;
    Texture metall;
    Texture bulb;
    Texture white;
    Texture exit;
    Texture work;
    Texture go;
    Texture multiplayer;
    Texture tutorial;
    Texture front_break;
    Texture ring;
    Texture throne;
    Texture button_right;
    Texture button_left;
    Texture tutorials;
    Texture frame;
    Texture planet;
    Texture aim;
    Texture speed;
    Texture damage;
    Texture med;
    Texture head;
    Texture puck;
    Texture select;
    Texture button_ship;
    Texture space;
    Texture space2;
    Texture back_space;
    Texture frame_green_1;
    Texture frame_green_2;
    Texture scanner;
    Texture planet_icon;
    Texture big_grass;
    Texture meteor;
    Texture tv;
    Texture level_circle;
    Texture level_back;
    Texture level_front;
    Texture level_line;
    Texture location_2_planet_texture;
    Texture[] background = new Texture[8];
    Texture[] smoke = new Texture[4];
    Texture[] birds = new Texture[5];
    TextureRegion location_2_planet;
    TextureRegion location_2_space;
    TextureRegion location_2_space_2;
    int last_level;
    int tv_size = 10;
    int prob_y = 400;
    int planet_id = 1;
    float scan_height = 0.0f;
    int scan_y = 0;
    int select_x = 0;
    int which_select = 1;
    int box_size = 200;
    int ring_1_xy = 0;
    int ring_2_xy = 100;
    int skin_y = 0;
    int plus_width = 0;
    int plus_height = 0;
    float bird_scale = 1.0f;
    float rotation_hand = 0.0f;
    float scale = 1.05f;
    float rotation_head = 0.0f;
    float rotation_leg = 0.0f;
    float space_rotate = 0.0f;
    float planet_rotate = 0.0f;
    float location_2_planet_rotate = 0.0f;
    float location_2_space_rotate = 0.0f;
    float location_2_space_2_rotate = 0.0f;
    float location_2_space_3_rotate = 0.0f;
    boolean zoom_planet = false;
    boolean NeedUpdatePlanet = false;
    boolean NeedUpdatePlanetPart = false;
    boolean button_ship_touched = false;
    boolean isTv = false;
    boolean search_planet = false;
    boolean resize_gift = false;
    boolean right_touched = false;
    boolean left_touched = false;
    boolean close_touch = false;
    boolean play_touch = false;
    boolean multiplayer_touch = false;
    boolean BirdFly;
    boolean work_touch = false;
    boolean isJump = false;
    double robot_x;
    boolean tutorial_touch = false;
    boolean istutorial = false;
    boolean resize_scene = false;
    boolean bird_swap = false;
    boolean swap_planet = false;
    boolean scan = false;
    int scene_size = 0;
    int tutorial_scene = 0;
    int max_tutorial_scene = 7;
    int anime_grass_1 = 0;
    int anime_grass_2 = 0;
    int grass_dir_1 = 1;
    int grass_dir_2 = 0;
    int robot_y = 250;
    int smoke_anime = 1;
    int birdx;
    int birdy;
    int bird_anime;
    public GameMenu(MainGame game) { this.game = game; }
    @Override
    public void show() {
        game.MusicSwap(1);
        game.robot.Safe();
        game.robot.RandomEnemy();
        /*
        game.robot.Hid = 5;
        game.robot.Bid = 5;
        game.robot.LHid = 5;
        game.robot.RHid = 5;
        game.robot.LLid = 5;
        game.robot.RLid = 5;

        game.robot.EHid = 5;
        game.robot.EBid = 5;
        game.robot.ELHid = 5;
        game.robot.ERHid = 5;
        game.robot.ELLid = 5;
        game.robot.ERLid = 5;


        game.robot.RHt.dispose();
        game.robot.LHt.dispose();
        game.robot.RLt.dispose();
        game.robot.LLt.dispose();
        game.robot.Ht.dispose();
        game.robot.Bt.dispose();
        game.robot.RHt =  new Texture("Robot/hand_" +  game.robot.RHid + ".png");
        game.robot.LHt = new Texture("Robot/hand_" +  game.robot.LHid + ".png");
        game.robot.RLt = new Texture("Robot/leg_" +  game.robot.RLid + ".png");
        game.robot.LLt = new Texture("Robot/leg_" +  game.robot.LLid + ".png");
        game.robot.Ht = new Texture("Robot/head_" +  game.robot.Hid + ".png");
        game.robot.Bt = new Texture("Robot/body_" +  game.robot.Bid + ".png");
        game.robot.RH =  new TextureRegion( game.robot.RHt, 300, 300);
        game.robot.LH =  new TextureRegion( game.robot.LHt, 300, 300);
        game.robot.RL =  new TextureRegion( game.robot.RLt, 300, 300);
        game.robot.LL =  new TextureRegion( game.robot.LLt, 300, 300);
        game.robot.H =  new TextureRegion( game.robot.Ht, 300, 300);
        game.robot.B =  new TextureRegion( game.robot.Bt, 300, 300);

        game.robot.ERHt.dispose();
        game.robot.ELHt.dispose();
        game.robot.ERLt.dispose();
        game.robot.ELLt.dispose();
        game.robot.EHt.dispose();
        game.robot.EBt.dispose();
        game.robot.ERHt =  new Texture("Robot/hand_" +  game.robot.ERHid + ".png");
        game.robot.ELHt = new Texture("Robot/hand_" +  game.robot.ELHid + ".png");
        game.robot.ERLt = new Texture("Robot/leg_" +  game.robot.ERLid + ".png");
        game.robot.ELLt = new Texture("Robot/leg_" +  game.robot.ELLid + ".png");
        game.robot.EHt = new Texture("Robot/head_" +  game.robot.EHid + ".png");
        game.robot.EBt = new Texture("Robot/body_" +  game.robot.EBid + ".png");
        game.robot.ERH =  new TextureRegion( game.robot.ERHt, 300, 300);
        game.robot.ELH =  new TextureRegion( game.robot.ELHt, 300, 300);
        game.robot.ERL =  new TextureRegion( game.robot.ERLt, 300, 300);
        game.robot.ELL =  new TextureRegion( game.robot.ELLt, 300, 300);
        game.robot.EH =  new TextureRegion( game.robot.EHt, 300, 300);
        game.robot.EB =  new TextureRegion( game.robot.EBt, 300, 300);

        X6:
        3 - 14px and 50%
        6 - 9px and 40%
        6 - 7px and 35%

        game.robot.UpdateParameters();*/
        last_level = game.robot.level;
        level_circle =  new Texture("Object/level_circle.png");
        level_back =  new Texture("Object/level_backline.png");
        level_front =  new Texture("Object/level_frontline.png");
        level_line =  new Texture("Object/level_line.png");
        planet_icon =  new Texture("Button/button_" + game.robot.level + ".png");
        big_grass =  new Texture("Location/grass_" + game.robot.level + "_2.png");
        meteor =  new Texture("Location/meteor_" + game.robot.level + ".png");
        scanner =  new Texture("Object/scanner.png");
        back_space =  new Texture("Interface/space.png");
        space =  new Texture("Location/background_2.png");
        space2 =  new Texture("Location/background_2_front.png");
        location_2_space = new TextureRegion(space, 1280, 720);
        location_2_space_2 = new TextureRegion(space, 1280, 720);
        frame_green_1 =  new Texture("Object/frame_2.png");
        frame_green_2 =  new Texture("Object/frame_1.png");
        tv =  new Texture("Object/gold.png");
        button_ship = new Texture("Button/button_ship.png");
        multiplayer = new Texture("Button/button3.png");
        tutorial = new Texture("Button/button_tutorial.png");
        tutorials = new Texture("Interface/back.png");
        ring = new Texture("Object/ring.png");
        throne = new Texture("Object/stand.png");
        smoke[0] = new Texture("Object/smoke1.png");
        smoke[1] = new Texture("Object/smoke2.png");
        smoke[2] = new Texture("Object/smoke3.png");
        smoke[3] = new Texture("Object/smoke4.png");
        hush[0] = Gdx.audio.newSound(Gdx.files.internal("Sound/p1.wav"));
        hush[1] = Gdx.audio.newSound(Gdx.files.internal("Sound/p2.wav"));
        hush[2] = Gdx.audio.newSound(Gdx.files.internal("Sound/p3.wav"));
        if(game.robot.level == 3 || game.robot.level == 4 ) {
            birds[0] = new Texture("Object/bird_1.png");
            birds[1] = new Texture("Object/bird_2.png");
            birds[2] = new Texture("Object/bird_3.png");
            birds[3] = new Texture("Object/bird_4.png");
        }
        if(game.robot.level == 2 ) {
            birds[0] = new Texture("Object/bird_1_2.png");
            birds[1] = new Texture("Object/bird_2_2.png");
            birds[2] = new Texture("Object/bird_3_2.png");
            birds[3] = new Texture("Object/bird_4_2.png");
        }
        if(game.robot.level == 1 ) {
            birds[0] = new Texture("Object/bird_1_3.png");
            birds[1] = new Texture("Object/bird_2_3.png");
            birds[2] = new Texture("Object/bird_3_3.png");
            birds[3] = new Texture("Object/bird_4_3.png");
        }
            birds[4] = new Texture("Object/bird_5.png");
        if(game.random.nextInt(3) == 0) {
            game.robot.Eskin = game.random.nextInt(game.robot.max_skin);
            game.robot.EUpdateSkin();
        }else{
            game.robot.Eskin = 0;
        }
        for(int i = 0; i<8; i++) background[i] = new Texture("Tutorial/tutorial_" + (i+1) + ".png");
        work = new Texture("Button/work.png");
        location_2_planet_texture = new Texture("Object/planet_3.png");
        front_break = new Texture("Interface/break.png");
        exit = new Texture("Button/exit.png");
        go = new Texture("Button/button.png");
        white = new Texture("Button/button_white.png");
        grass = new Texture("Location/grass_" + game.robot.level + ".png");
        metall = new Texture("Item/metall.png");
        chip = new Texture("Item/chip.png");
        bulb = new Texture("Item/bulb.png");
        gear = new Texture("Item/gear.png");
        frame= new Texture("Interface/frame.png");
        planet_id = game.robot.level;
        location_2_planet = new TextureRegion(location_2_planet_texture, 400, 400);
        planet = new Texture("Object/planet_" + planet_id + ".png");
        aim = new Texture("Object/aim.png");
        speed = new Texture("Interface/speed_move_icon.png");
        damage = new Texture("Interface/damage_icon.png");
        med = new Texture("Object/health_5.png");
        head = new Texture("Robot/head_1.png");
        puck = new Texture("Object/gift_1.png");
        select = new Texture("Interface/select2.png");
        Gdx.input.setInputProcessor(new GameMenuTouch(game, this));
        button_right =  new Texture("Button/button_right.png");
        button_left =  new Texture("Button/button_left.png");
        music =  new Texture("Button/music_1.png");
        music_stop =  new Texture("Button/music_2.png");
        camp = new Texture("Interface/camp_" + game.robot.level + ".png");
        Start();
        robot_x = width-400;
        open_x = 0;
        setRandomAnime();
        game.robot.UpdateSkins();
        batch = new SpriteBatch();
        anime_grass = new Thread(){
            @Override
            public void run(){
                while(true){
                    if(game.robot.level == 3 || game.robot.level == 4) {
                        if (grass_dir_1 == 1) {
                            anime_grass_1 += 1;
                            if (anime_grass_1 >= 50) {
                                grass_dir_1 = 0;
                            }
                        } else {
                            anime_grass_1 -= 1;
                            if (anime_grass_1 <= -10) {
                                grass_dir_1 = 1;
                            }
                        }
                        if (grass_dir_2 == 1) {
                            anime_grass_2 += 1;
                            if (anime_grass_2 >= 50) {
                                grass_dir_2 = 0;
                            }
                        } else {
                            anime_grass_2 -= 1;
                            if (anime_grass_2 <= -10) {
                                grass_dir_2 = 1;
                            }
                        }
                        if (closed) {
                            break;
                        }
                    }
                    Sleep(15);
                }
            }
        };
        anime_smoke = new Thread(){
            @Override
            public void run(){
                while(true) {
                    if (game.robot.level == 3 || game.robot.level == 4) {
                        smoke_anime++;
                        if (smoke_anime >= 3) {
                            smoke_anime = 0;
                        }
                        if (closed) {
                            break;
                        }
                        Sleep(100);
                    }
                }
            }
        };
        ring_anime = new Thread(){
            @Override
            public void run(){
                int dir_skin = 1;
                while(!closed){
                    ring_1_xy -=2;
                    if(ring_1_xy < 10){
                        ring_1_xy = 200;
                    }
                    ring_2_xy -=2;
                    if(ring_2_xy < 10){
                        ring_2_xy = 200;
                    }
                    if(dir_skin == 1){
                        skin_y+=1;
                        if(skin_y>60){
                            dir_skin=0;
                        }
                    }else{
                        skin_y-=1;
                        if(skin_y<25){
                            dir_skin=1;
                        }
                    }
                    Sleep( 10);
                }
            }
        };

        anime_hand = new Thread(){
            @Override
            public void run(){
                int dir = 0;
                int time = game.random.nextInt(10)+6;
                while(true){
                    if(dir==1){
                        robot_x+=0.1;
                        scale-=0.0008f;
                        rotation_head+=0.2f;
                        rotation_hand-=0.1f;
                        if(rotation_head>=4.0f){
                            dir=2;
                            time = game.random.nextInt(10)+6;
                        }
                    }else{
                        robot_x-=0.1;
                        scale+=0.0008f;
                        rotation_head-=0.2f;
                        rotation_hand+=0.1f;
                        if(rotation_head<=-4.0f){
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
        drawer = new SpriteBatchRubber(this, batch);
        ring_anime.start();

            anime_grass.start();
            anime_smoke.start();
            space_anime.start();
        anime_hand.start();
        DoorOpen();
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        batch.begin();
        if(game.robot.level == 2){
            drawer.draw(location_2_space, -width/1.5f,-height/1.5f, width, height, width*3.0f, height*3.0f, 1, 1,  location_2_space_rotate, true);
            drawer.draw(location_2_space_2, -width/1.5f,-height/1.5f, width, height, width*3.0f, height*3.0f, 1, 1,  location_2_space_2_rotate, true);
            drawer.draw(location_2_space_2, -width/1.5f,-height/1.5f, width, height, width*3.0f, height*3.0f, 1, 1,  location_2_space_3_rotate, true);
            drawer.draw(location_2_planet, width/2, height/2-300, 400, 400, 800, 800, 1, 1,  location_2_planet_rotate, true);
        }
        drawer.draw(camp, 0, 0, width, height);

        if (BirdFly) {
            TextureRegion bird_region;
                bird_region = new TextureRegion(birds[bird_anime], 400, 400);
                if(!bird_swap) {
                    if (game.robot.level == 3 || game.robot.level == 4) {
                        drawer.draw(bird_region, birdx, birdy, 0, 0, 250.0f * bird_scale, 250.0f * bird_scale, 1, 1, (birdy - height / 2) / 5);
                    }
                }
            if(game.robot.level == 1 ) {
                drawer.draw(bird_region, birdx, birdy-200, 0, 0, 400, 300, 1, 1, (birdy - height / 2) / 15);
            }
            if(game.robot.level == 2 ) {
                drawer.draw(bird_region, birdx, birdy, 0, 0, 450, 450, 1, 1, (birdy - height / 2) / 30);
            }
        }
        drawer.draw(game.robot.contrast, 0, 0, width, height);
        if(game.robot.level!=2) {
            drawer.draw(grass, width - 200, 225, 250, 250 + anime_grass_1);
            drawer.draw(grass, -70, 225, 250, 250 + anime_grass_2);
        }else{
            drawer.draw(grass, width - 200, 235, 250, 260 + anime_grass_1);
            drawer.draw(grass, -70, 235, 245, 260 + anime_grass_2);
        }

        DrawRobot(drawer, (int)robot_x, robot_y, scale, rotation_hand+90, rotation_head, rotation_leg, 0 , false, false, false, 0);
        drawer.draw(level_back, width/2-140, 150, 300, 80);
        drawer.draw(level_line, width/2-140, 150, (int)(((double)game.robot.experience/((double)game.robot.level_win*100.0))*300.0), 80);
        drawer.draw(level_front, width/2-140, 150, 300, 80);
        drawer.draw(level_circle, width/2-230, 130, 120, 120);
        if(game.robot.level_win < 10) {
            level_big_font.draw(batch, Integer.toString(game.robot.level_win), (int) ((width / 2 - 185.0) * wpw), (int) ((215) * hph));
        }else{
            level_big_font.draw(batch, Integer.toString(game.robot.level_win), (int) ((width / 2 - 200.0) * wpw), (int) ((215) * hph));
        }
        level_font.draw(batch, game.robot.experience + " / " + game.robot.level_win*100, (int)((width/2-110.0)*wpw), (int)((205)*hph));
       // DrawRobotBall(drawer, (int)robot_x, robot_y, scale, rotation_hand+90, rotation_head, rotation_leg, 0 ,  test_ball);
        drawer.draw(ring, 250+(200-ring_1_xy)/2, 230+(int)((double)(200-ring_1_xy)*1.25), ring_1_xy, ring_1_xy);
        drawer.draw(ring, 250+(200-ring_2_xy)/2, 230+(int)((double)(200-ring_2_xy)*1.25), ring_2_xy, ring_2_xy);
        drawer.draw(game.robot.puck, 250+(200-box_size)/2, 385+skin_y+(200-box_size)/2, box_size, box_size);
        drawer.draw(throne, 200, 245, 300, 300);
        if(!right_touched) {
            drawer.draw(button_right, 450, 435 + skin_y / 2, 150, 150);
        }else{
            drawer.draw(button_right, 460, 435 + skin_y / 2+10, 130, 130);
        }
        if(!left_touched) {
            drawer.draw(button_left, 100, 435 + skin_y / 2, 150, 150);
        }else{
            drawer.draw(button_left, 110, 435 + skin_y / 2+10, 130, 130);
        }
        if(close_touch){
            close = white;
        }else{
            close = exit;
        }
        if(work_touch){
            workspace = white;
        }else{
            workspace = work;
        }
        if(play_touch){
            play= white;
        }else{
            play= go;
        }
        if(tutorial_touch){
            drawer.draw(white, width/2-300, 0, 300, 150);
        }else{
            drawer.draw(tutorial, width/2-300, 0, 300, 150);
        }
        if(multiplayer_touch){
            drawer.draw(white, width/2, 10, 300, 130);
        }else{
            drawer.draw(multiplayer, width/2, 10, 300, 130);
        }

        if(NeedUpdatePlanetPart){
            NeedUpdatePlanetPart = false;
            game.robot.level = planet_id;
            planet.dispose();
            grass.dispose();
            big_grass.dispose();
            planet_icon.dispose();
            meteor.dispose();
            meteor = new Texture("Location/meteor_" + game.robot.level + ".png");
            planet_icon = new Texture("Button/button_" + game.robot.level + ".png");
            big_grass = new Texture("Location/grass_" + game.robot.level + "_2.png");
            grass = new Texture("Location/grass_" + game.robot.level + ".png");
            planet = new Texture("Object/planet_" + planet_id + ".png");
        }
        if(NeedUpdatePlanet){
            NeedUpdatePlanet = false;
            camp.dispose();
            birds[0].dispose();
            birds[1].dispose();
            birds[2].dispose();
            birds[3].dispose();
            if(game.robot.level == 3 || game.robot.level == 4 ) {
                birds[0] = new Texture("Object/bird_1.png");
                birds[1] = new Texture("Object/bird_2.png");
                birds[2] = new Texture("Object/bird_3.png");
                birds[3] = new Texture("Object/bird_4.png");
            }
            if(game.robot.level == 2 ) {
                birds[0] = new Texture("Object/bird_1_2.png");
                birds[1] = new Texture("Object/bird_2_2.png");
                birds[2] = new Texture("Object/bird_3_2.png");
                birds[3] = new Texture("Object/bird_4_2.png");
            }
            if(game.robot.level == 1 ) {
                birds[0] = new Texture("Object/bird_1_3.png");
                birds[1] = new Texture("Object/bird_2_3.png");
                birds[2] = new Texture("Object/bird_3_3.png");
                birds[3] = new Texture("Object/bird_4_3.png");
            }
            camp = new Texture("Interface/camp_" + game.robot.level + ".png");
        }
        drawer.draw(close, 50, 0, 500, 250);
        drawer.draw(play, width-550, 0, 500, 250);
        drawer.draw(workspace, 620, height-200, 400, 200);
        if (game.music_play) {
            drawer.draw(music, 1020, height - 100, 100, 100);
        } else {
            drawer.draw(music_stop, 1020, height - 100, 100, 100); }
        drawer.draw(metall, 10, height-120, 120, 120);
        drawer.draw(gear, 130, height-120, 120, 120);
        drawer.draw(chip, 250, height-120, 120, 120);
        drawer.draw(bulb, 370, height-120, 120, 120);
        item_font.draw(batch, Integer.toString(game.robot.metal), (int)(25.0*wpw), (int)((height-130)*hph));
        item_font.draw(batch, Integer.toString(game.robot.gears), (int)(145.0*wpw), (int)((height-130)*hph));
        item_font.draw(batch, Integer.toString(game.robot.microchips), (int)(275.0*wpw), (int)((height-130)*hph));
        item_font.draw(batch, Integer.toString(game.robot.lamps), (int)(405.0*wpw), (int)((height-130)*hph));

        if(game.robot.level != 1 && game.robot.level != 2) {
            drawer.draw(smoke[smoke_anime], width / 2 - 125, 400, 175, 175);
        }

        if(search_planet){
            TextureRegion space_1 = new TextureRegion(space, 960, 540);
            TextureRegion space_2 = new TextureRegion(space2, 960, 540);
            drawer.draw(back_space, 0, 0, width, height);
            drawer.draw(space_1, -width/1.5f, -height/1.5f, width, height, width*1.5f, height*1.5f, 1.0f, 1.0f, -space_rotate);
            drawer.draw(space_2, -width/1.5f, -height/1.5f, width, height, width*1.5f, height*1.5f, 1.0f, 1.0f, space_rotate);
            drawer.draw(frame_green_1, 100-prob_y, height-450, 300, 300);
            drawer.draw(planet_icon, 50-prob_y, height-150, 150, 150);
            drawer.draw(grass, 125-prob_y, height-430, 100, 100);
            drawer.draw(big_grass, 275-prob_y, height-430, 100, 100);
            drawer.draw(meteor, 210-prob_y, height-325, 75, 75);
            drawer.draw(frame_green_1, 125, 50-prob_y, 150, 150 );
            drawer.draw(frame_green_2, width-275, 50-prob_y, 150, 150);
            drawer.draw(frame_green_1, 350, 50-prob_y, 150, 150);
            drawer.draw(frame_green_2, width-500, 50-prob_y, 150, 150);
            drawer.draw(chip, 50, 200-prob_y, 150, 150);
            drawer.draw(gear, width-200, 200-prob_y, 150, 150);
            drawer.draw(bulb, 275, 200-prob_y, 150, 150);
            drawer.draw(metall, width-425, 200-prob_y, 150, 150);
            item_font.draw(batch, game.robot.chip_chance[game.robot.level-1]+"%", (int)(155.0*wpw), (int)((110-prob_y)*hph));
            item_font.draw(batch, game.robot.bulb_chance[game.robot.level-1]+"%", (int)((width-275+30)*wpw), (int)((110-prob_y)*hph));
            item_font.draw(batch, game.robot.metal_chance[game.robot.level-1]+"%", (int)(380*wpw), (int)((110-prob_y)*hph));
            item_font.draw(batch, game.robot.gear_chance[game.robot.level-1]+"%", (int)((width-500+30)*wpw), (int)((110-prob_y)*hph));
        }

        if(isTv){
            TextureRegion planet_region = new TextureRegion(planet, 400, 400);
            drawer.draw(planet_region, width/2-tv_size/2, height/2-tv_size/2, tv_size/2, tv_size/2,  tv_size, tv_size,1.0f, 1.0f, planet_rotate);
        }
        if(scan){
            drawer.draw(scanner, 0, scan_y, width, scan_height);
        }
        if(!button_ship_touched) {
            drawer.draw(button_ship, width - 170, height - 120, 120, 120);
        }else{
            drawer.draw(button_ship, width - 160, height - 110, 100, 100);
        }
        if(bird_swap){
            if(game.robot.level == 3 || game.robot.level == 4 ) {
                TextureRegion bird_region = new TextureRegion(birds[bird_anime], 400, 400);
                drawer.draw(bird_region, birdx, birdy, 0, 0, 250.0f*bird_scale, 250.0f*bird_scale, 1, 1, (birdy - height / 2) / 5);
            }
        }

        if(istutorial || resize_scene){
                drawer.draw(tutorials, scene_size - width - 10, 0, width, height);
                if(which_select<9) {
                    drawer.draw(background[which_select - 1], scene_size - width - 10, height - 610, width, 610);
                }else{
                    drawer.draw(background[7], scene_size - width - 10, height - 610, width, 610);
                }
                drawer.draw(frame, scene_size - width + 50, 0, 200,200);
                drawer.draw(frame, scene_size - width + 250, 0, 200, 200);
                drawer.draw(frame, scene_size - width + 450, 0, 200, 200);
                drawer.draw(frame, scene_size - width + 650, 0, 200, 200);
                drawer.draw(frame, scene_size - width + 850, 0, 200, 200);
                drawer.draw(frame, scene_size - width + 1050, 0, 200, 200);
                drawer.draw(frame, scene_size - width + 1250, 0, 200, 200);
                drawer.draw(frame, scene_size - width + 1450, 0, 200, 200);
                drawer.draw(planet, scene_size - width + 50, 0, 200,200);
                drawer.draw(gear, scene_size - width + 250, 0, 200, 200);
                drawer.draw(aim, scene_size - width + 450, 0, 200, 200);
                drawer.draw(speed, scene_size - width + 650, 0, 200, 200);
                drawer.draw(damage, scene_size - width + 850, 0, 200, 200);
                drawer.draw(med, scene_size - width + 1050, 0, 200, 200);
                drawer.draw(head, scene_size - width + 1250, 0, 200, 200);
                drawer.draw(puck, scene_size - width + 1450, 0, 200, 200);

                drawer.draw(front_break, scene_size - width / 2, 0, width, height);
                if(which_select<9) {
                    drawer.draw(select, scene_size - width + 200 * (which_select - 1) + 50+select_x, 0, 200, 200);
                }
            if(which_select == 1) {
                tutorial_font.draw(drawer.batch, "Приветствуем!", (int)((100+scene_size - width-select_x)*wpw), (int)((height-100)*hph));
                tutorial_font.draw(drawer.batch, "Вы попали в мир, который поглотила", (int)((100+scene_size - width+select_x)*wpw), (int)((height-175)*hph));
                tutorial_font.draw(drawer.batch, "цивилизация боевых машин.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-250)*hph));
                tutorial_font.draw(drawer.batch, "Цель - выжить, улучшая собственного робота", (int)((100+scene_size - width+select_x)*wpw), (int)((height-325)*hph));
                tutorial_font.draw(drawer.batch, "за запчасти.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-400)*hph));
                tutorial_font.draw(drawer.batch, "Чтож, давайте посмотрим дальше!", (int)((100+scene_size - width+select_x)*wpw), (int)((height-475)*hph));
            }
            if(which_select == 2) {
                tutorial_font.draw(drawer.batch, "Запчасти выпадают в конце боя,", (int)((100+scene_size - width-select_x)*wpw), (int)((height-100)*hph));
                tutorial_font.draw(drawer.batch, "в случае победы.", (int)((100+scene_size - width+select_x)*wpw), (int)((height-175)*hph));
                tutorial_font.draw(drawer.batch, "Они являются неотъемлемой частью игры.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-250)*hph));
                tutorial_font.draw(drawer.batch, "Виды запчастей:", (int)((100+scene_size - width+select_x)*wpw), (int)((height-325)*hph));
                tutorial_font.draw(drawer.batch, "Шестерёнки, микросхемы, металл, лампочки.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-400)*hph));
            }
            if(which_select == 3) {
                tutorial_font.draw(drawer.batch, "В бою вам предстоит сразиться с", (int)((100+scene_size - width-select_x)*wpw), (int)((height-100)*hph));
                tutorial_font.draw(drawer.batch, "искусственным интеллектом или другом по сети.", (int)((100+scene_size - width+select_x )*wpw), (int)((height-175)*hph));
                tutorial_font.draw(drawer.batch, "Игровая локация всегда случайная.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-250)*hph));
                tutorial_font.draw(drawer.batch, "Уровень повышается при выигрыше.", (int)((100+scene_size - width+select_x)*wpw), (int)((height-325)*hph));
                tutorial_font.draw(drawer.batch, "Чем выше уровень - тем сильнее противник.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-400)*hph));
            }
            if(which_select == 4) {
                tutorial_font.draw(drawer.batch, "Передвижение осуществляется при помощи кнопок.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-100)*hph));
                tutorial_font.draw(drawer.batch, "Персонаж двигается только по диагонали.", (int)((100+scene_size - width+select_x )*wpw), (int)((height-175)*hph));
                tutorial_font.draw(drawer.batch, "В зависимости от того, куда направлен персонаж", (int)((100+scene_size - width-select_x)*wpw), (int)((height-250)*hph));
                tutorial_font.draw(drawer.batch, "осуществляется передвижение. Скорость зависит от", (int)((100+scene_size - width+select_x)*wpw), (int)((height-325)*hph));
                tutorial_font.draw(drawer.batch, "уровня ног. Уклоняйтесь от выстрелов противника", (int)((100+scene_size - width-select_x)*wpw), (int)((height-400)*hph));
                tutorial_font.draw(drawer.batch, "и неопознанных объектов!", (int)((100+scene_size - width+select_x)*wpw), (int)((height-475)*hph));
            }
            if(which_select == 5) {
                tutorial_font.draw(drawer.batch, "Ваши выстрелы повреждают только противника.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-100)*hph));
                tutorial_font.draw(drawer.batch, "Стрелять можно, нажимая кнопку справа снизу.", (int)((100+scene_size - width +select_x)*wpw), (int)((height-175)*hph));
                tutorial_font.draw(drawer.batch, "Урон зависит от уровня пушек.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-250)*hph));
                tutorial_font.draw(drawer.batch, "Скорость стрельбы (Динамика) зависит", (int)((100+scene_size - width+select_x)*wpw), (int)((height-325)*hph));
                tutorial_font.draw(drawer.batch, "от уровня туловища.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-400)*hph));
                tutorial_font.draw(drawer.batch, "Пуля летит в сторону направления робота.", (int)((100+scene_size - width+select_x)*wpw), (int)((height-475)*hph));
            }
            if(which_select == 6) {
                tutorial_font.draw(drawer.batch, "Игровые ньюансы: Подобрав аптечку,", (int)((100+scene_size - width-select_x)*wpw), (int)((height-100)*hph));
                tutorial_font.draw(drawer.batch, "можно восстановить 25% здоровья.", (int)((100+scene_size - width +select_x)*wpw), (int)((height-175)*hph));
                tutorial_font.draw(drawer.batch, "Опасайтесь метеоритов, ракет и прочих", (int)((100+scene_size - width-select_x)*wpw), (int)((height-250)*hph));
                tutorial_font.draw(drawer.batch, "предметов, выпадающих на игровое поле.", (int)((100+scene_size - width+select_x)*wpw), (int)((height-325)*hph));
                tutorial_font.draw(drawer.batch, "На разных локациях выделяют разные", (int)((100+scene_size - width-select_x)*wpw), (int)((height-400)*hph));
                tutorial_font.draw(drawer.batch, "особенности.", (int)((100+scene_size - width+select_x)*wpw), (int)((height-475)*hph));
            }
            if(which_select == 7) {
                tutorial_font.draw(drawer.batch, "Прокачивая детали, повышаются различные", (int)((100+scene_size - width-select_x)*wpw), (int)((height-100)*hph));
                tutorial_font.draw(drawer.batch, "характеристики. Например:", (int)((100+scene_size - width +select_x)*wpw), (int)((height-175)*hph));
                tutorial_font.draw(drawer.batch, "Прокачивая руки: Здоровье, урон.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-250)*hph));
                tutorial_font.draw(drawer.batch, "Прокачивая ноги: Здоровье, скорость", (int)((100+scene_size - width+select_x)*wpw), (int)((height-325)*hph));
                tutorial_font.draw(drawer.batch, "Прокачивая туловище: Здоровье, динамика", (int)((100+scene_size - width-select_x)*wpw), (int)((height-400)*hph));
                tutorial_font.draw(drawer.batch, "Прокачивая голову: Здоровье, Энергия.", (int)((100+scene_size - width+select_x)*wpw), (int)((height-475)*hph));
            }
            if(which_select == 8) {
                tutorial_font.draw(drawer.batch, "Регулярно на поле боя выпадают скины.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-100)*hph));
                tutorial_font.draw(drawer.batch, "Скины ни на что не влияют.", (int)((100+scene_size - width +select_x)*wpw), (int)((height-175)*hph));
                tutorial_font.draw(drawer.batch, "Они разукрашивают игровой процесс.", (int)((100+scene_size - width-select_x)*wpw), (int)((height-250)*hph));
                tutorial_font.draw(drawer.batch, "Успейте подобрать их быстрее, чем это", (int)((100+scene_size - width-+select_x)*wpw), (int)((height-325)*hph));
                tutorial_font.draw(drawer.batch, "Сделает противник!", (int)((100+scene_size - width-select_x)*wpw), (int)((height-400)*hph));
                tutorial_font.draw(drawer.batch, "Выбрать скин можно в главном меню.", (int)((100+scene_size - width+select_x)*wpw), (int)((height-475)*hph));
            }
        }
        CheckClose(drawer);
        CheckOpen(drawer);
        batch.end();
        if(closed){
            if(type_close == 1) {
                game.setWorkMenu();
            }
            if(type_close == 2) {
                game.setGamePlay(false, false);
            }
            if(type_close == 3) {
                game.setMultiplayerMenu();
            }
        }
    }
    public void SwapPlanet(){
        if(!swap_planet && isTv && search_planet &&!zoom_planet &&!scan){
            swap_planet = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while(prob_y < 400){
                        prob_y+=20;
                        Sleep(5);
                    }
                    prob_y = 400;
                    while(tv_size>10) {
                        planet_rotate-=0.5f;
                        if(planet_rotate<=0.0f){
                            planet_rotate=360.0f;
                        }
                        space_rotate+=0.6f;
                        if(space_rotate>360.0f){
                            space_rotate=0.0f;
                        }
                        tv_size-=5;
                        Sleep(2);
                    }

                    planet_id++;
                    if(planet_id > game.max_planet){
                        planet_id = 1;
                    }
                    NeedUpdatePlanetPart = true;
                    while(tv_size<800) {
                        planet_rotate-=0.5f;
                        if(planet_rotate<=0.0f){
                            planet_rotate=360.0f;
                        }
                        space_rotate+=0.5f;
                        if(space_rotate>360.0f){
                            space_rotate=0.0f;
                        }
                        tv_size+=5;
                        Sleep(2);
                    }
                    Scan();
                    swap_planet = false;
                    tv_size = 800;

                }
            };
            anime.start();
        }
    }
    public void ResetTv(){
        if(isTv && search_planet && !swap_planet && !zoom_planet &&!scan){
            zoom_planet = true;
            if(last_level != game.robot.level){
                NeedUpdatePlanet = true;
            }
            last_level = game.robot.level;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    Sleep(100);
                    while(tv_size<width*2){
                        tv_size+=10;
                        planet_rotate+=0.5f;
                        if(planet_rotate>=360.0f){
                            planet_rotate = 0.0f;
                        }
                        Sleep(2);
                    }
                    search_planet = false;
                    game.MusicSwap(1);
                    while(tv_size>10){
                        tv_size-=10;
                        planet_rotate+=0.5f;
                        if(planet_rotate>=360.0f){
                            planet_rotate = 0.0f;
                        }
                        space_rotate+=0.5f;
                        if(space_rotate>360.0f){
                            space_rotate=0.0f;
                        }
                        Sleep(2);
                    }
                    zoom_planet = false;
                    isTv = false;
                }
            };
            anime.start();
        }
    }
    public void SetTv(){
        if(!isTv && !search_planet && !swap_planet && !zoom_planet &&!scan){
            isTv = true;
            zoom_planet = true;
            prob_y = 400;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while(tv_size<width*2){
                        tv_size+=10;
                        planet_rotate+=0.5f;
                        if(planet_rotate>=360.0f){
                            planet_rotate = 0.0f;
                        }
                        Sleep(2);
                    }
                    search_planet = true;
                    while(tv_size>800){
                            tv_size-=10;
                            planet_rotate+=0.5f;
                        if(planet_rotate>=360.0f){
                            planet_rotate = 0.0f;
                        }
                        space_rotate+=0.1f;
                        if(space_rotate>360.0f){
                            space_rotate=0.0f;
                        }
                        Sleep(2);
                    }
                    zoom_planet = false;
                    Scan();
                    int dir_anime = 1;
                    int size = 0;
                    game.MusicSwap(5);
                    while(search_planet){
                        if(!swap_planet && !zoom_planet) {
                            if (dir_anime == 1) {
                                tv_size+=1;
                                size+=1;
                                if(size>=10){
                                    dir_anime = 0;
                                }
                            }else{
                                tv_size-=1;
                                size-=1;
                                if(size<=-10){
                                    dir_anime = 1;
                                }
                            }
                        }
                        space_rotate+=0.2f;
                        if(space_rotate>360.0f){
                            space_rotate=0.0f;
                        }
                        if(!swap_planet) {
                            planet_rotate -= 0.3f;
                            if (planet_rotate <= 0.0f) {
                                planet_rotate = 360.0f;
                            }
                        }
                        Sleep(40);
                    }

                }
            };
            anime.start();
        }
    }
    public void Scan(){
        scan = true;
        scan_height = (float)height+200;
        scan_y = 0;
        Thread anime = new Thread() {
            @Override
            public void run() {
                while(scan_y<height){
                    scan_y+=5;
                    if(scan_height>15.0f) {
                        scan_height -= 6.0f;
                    }
                    Sleep(5);
                }
                while(prob_y > 0){
                    prob_y-=5;
                    Sleep(5);
                }
                prob_y = 0;
                scan = false;
            }
        };
        anime.start();

    }
    public void NextRightSkin(){
        if(game.robot.index_skin+1 <= game.robot.opened-1 && !resize_gift) {
            Thread anime = new Thread() {
                @Override
                public void run() {
                    resize_gift = true;
                    while (box_size > 150) {
                        box_size -= 1;
                        Sleep(1);
                    }
                    while (box_size < 200) {
                        box_size += 1;
                        Sleep(1);
                    }
                    resize_gift = false;
                    box_size = 200;
                }
            };
            anime.start();
            game.robot.index_skin += 1;
            game.robot.skin = game.robot.skins_open[game.robot.index_skin];
            game.robot.UpdateSkins();
        }
    }
    public void NextLeftSkin(){
        if (game.robot.index_skin > 0 && !resize_gift) {
            Thread anime = new Thread() {
                @Override
                public void run() {
                    resize_gift = true;
                    while (box_size > 150) {
                        box_size -= 1;
                        Sleep(1);
                    }
                    while (box_size < 200) {
                        box_size += 1;
                        Sleep(1);
                    }
                    resize_gift = false;
                    box_size = 200;
                }
            };
            anime.start();
            game.robot.index_skin -= 1;
            game.robot.skin = game.robot.skins_open[game.robot.index_skin];
            game.robot.UpdateSkins();
        }
    }
    public void SceneTutorial(){
        Thread anime = new Thread(){
            @Override
            public void run(){
                if(istutorial){
                    if(which_select<8){
                        resize_scene=true;
                        select_x=0;
                        while(select_x<200){
                            select_x+=2;
                            Sleep(1);
                        }
                        resize_scene=false;
                        which_select+=1;
                        select_x=0;
                    }else{
                        resize_scene = true;
                        while(scene_size>0){
                            scene_size-=5;
                            Sleep(1);
                        }
                        resize_scene = false;
                        istutorial = false;
                        which_select=1;
                    }
                }else{
                    resize_scene = true;
                    while(scene_size<width){
                        scene_size+=5;
                        Sleep(1 );
                    }
                    resize_scene = false;
                    istutorial = true;
                }
            }
        };
        anime.start();
    }
    public void setRandomAnime(){
        Thread rand = new Thread(){
            @Override
            public void run(){
                while(true){
                    int a = game.random.nextInt( 20);
                    if (a == 1 ){
                        if(!BirdFly){
                            Bird();
                        }
                    }
                    if(a == 2){
                        BotJump();
                    }
                    if(a == 3){
                        HandSwap();
                    }
                    if(a == 4){
                        HandStab();
                    }
                    if(closed){
                        break;
                    }
                    Sleep( 1000);
                }
            }
        };
        rand.start();
    }
    public void HandStab(){
        Thread stab = new Thread(){
            @Override
            public void run(){
                while(rotation_hand<=-1.5f||rotation_hand>=1.5f){
                    if(rotation_hand>0){
                        rotation_hand-=0.5f;
                    }
                    if(rotation_hand<0){
                        rotation_hand+=0.5f;
                    }
                    Sleep( 5);
                }
            }
        };
        stab.start();
    }
    public void HandSwap(){
        Thread swap = new Thread(){
            @Override
            public void run(){
                int hand = 0;
                while(hand < 270){
                    hand+=1;
                    rotation_hand-=1.0f;
                    Sleep( 5);
                }
            }
        };
        swap.start();
    }
    public void BotJump() {
        if (!isJump) {
            Thread top = new Thread() {
                @Override
                public void run() {
                    isJump=true;
                    int rotdirect = 1;
                    while (rotdirect != 3) {
                        if (rotdirect == 1) {
                            rotation_leg += 1.0;
                            robot_y += 3;
                            if (rotation_leg >= 30.0f) {
                                rotdirect = 2;
                            }
                        } else {
                            robot_y -= 3;
                            rotation_leg -= 1.0f;
                            if (rotation_leg <= 0.0f) {
                                rotdirect = 3;
                            }
                        }
                        Sleep( 10);
                    }
                    isJump=false;
                    rotation_leg = 0.0f;
                    robot_y = 250;
                }
            };
            top.start();
        }
    }
    public void Bird(){
        Thread fly = new Thread(){
            @Override
            public void run() {
                int dir_anime = 1;
                BirdFly = true;
                bird_anime = 1;
                birdx = -250;
                birdy = height / 2 - game.random.nextInt(80);
                while (birdx < width + 250) {
                    birdx += 10;
                    birdy++;
                    if (dir_anime == 1) {
                        bird_anime++;
                        if (bird_anime > 3) {
                            bird_anime = 3;
                            dir_anime = 0;
                        }
                    } else {
                        bird_anime--;
                        if (bird_anime < 0) {
                            bird_anime = 0;
                            dir_anime = 1;
                        }
                    }
                    if (game.robot.level == 3 || game.robot.level == 4) {
                        Sleep(30);
                    }
                    if (game.robot.level == 1) {
                        Sleep(3);
                    }
                    if (game.robot.level == 2) {
                        Sleep(5);
                    }
                    if (bird_swap) {
                        break;
                    }
                }
                if (!bird_swap) {
                    BirdFly = false;
                }
            }
        };
        fly.start();
    }
    public void Hush(){
        if(BirdFly){
            Thread fly = new Thread(){
                @Override
                public void run(){
                   bird_swap = true;
                    hush[game.random.nextInt(3)].play(0.2f);
                while(bird_scale<10.0f){
                    bird_scale+=0.2f;
                    birdy-=10;
                    birdx-=5;
                    Sleep(10);
                }
                bird_scale=1.0f;
                bird_swap = false;
                BirdFly=false;

                }
            };
            fly.start();
        }
    }
    @Override
    public void dispose () {
        for(int i = 0; i<8; i++) background[i].dispose();
        button_ship.dispose();
        hush[0].dispose();
        hush[1].dispose();
        hush[2].dispose();
        tutorials.dispose();
        smoke[0].dispose();
        smoke[1].dispose();
        smoke[2].dispose();
        smoke[3].dispose();
        birds[0].dispose();
        birds[1].dispose();
        birds[2].dispose();
        birds[3].dispose();
        go.dispose();
        exit.dispose();
        close.dispose();
        white.dispose();
        birds[4].dispose();
        work.dispose();
        camp.dispose();
        door_left.dispose();
        door_right.dispose();
        play.dispose();
        workspace.dispose();
        music.dispose();
        music_stop.dispose();
        bulb.dispose();
        gear.dispose();
        metall.dispose();
        chip.dispose();
        tutorial.dispose();
        front_break.dispose();
        throne.dispose();
        ring.dispose();
        button_left.dispose();
        button_right.dispose();
        frame.dispose();
        planet.dispose();
        aim.dispose();
        speed.dispose();
        damage.dispose();
        med.dispose();
        head.dispose();
        puck.dispose();
        select.dispose();
        multiplayer.dispose();
        tv.dispose();
        space.dispose();
        space2.dispose();
        frame_green_1.dispose();
        frame_green_2.dispose();
        scanner.dispose();
        planet_icon.dispose();
        big_grass.dispose();
        meteor.dispose();
        level_circle.dispose();
        level_back.dispose();
        level_front.dispose();
        level_line.dispose();
        location_2_planet_texture.dispose();
    }
}
