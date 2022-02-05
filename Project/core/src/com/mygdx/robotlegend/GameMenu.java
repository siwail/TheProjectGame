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
    Thread TutorialAnime;
    Thread TutorialIconAnime;
    Thread button_anime;
    Thread box_anime;
    Sound[] hush = new Sound[3];
    Texture button_left_part;
    Texture button_right_part;
    Texture button_center_part;
    Texture button_exit_icon;
    Texture button_fight_icon;
    Texture button_online_icon;
    Texture button_workshop_icon;
    Texture button_tutorial_icon;
    Texture back_light;
    Texture camp;
    Texture music;
    Texture music_stop;
    Texture grass;
    Texture gear;
    Texture chip;
    Texture metall;
    Texture bulb;
    Texture front_break;
    Texture ring;
    Texture throne;
    Texture button_right;
    Texture button_left;
    Texture tutorials;
    Texture frame;
    Texture planet;
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
    Texture level_circle;
    Texture level_back;
    Texture level_front;
    Texture level_line;
    Texture location_2_planet_texture;
    Texture tutorial_circlet;
    Texture dark;
    Texture bluefire;
    Texture box_item_1;
    Texture box_item_2;
    Texture[] box = new Texture[9];
    Texture[] tutorial_icon = new Texture[4];
    Texture[] tutorial_frame_color = new Texture[12];
    Texture[] smoke = new Texture[4];
    Texture[] birds = new Texture[5];
    TextureRegion tutorial_circle;
    TextureRegion location_2_planet;
    TextureRegion location_2_space;
    TextureRegion location_2_space_2;

    int button_exit_state = 0;
    int button_fight_state = 0;
    int button_tutorial_state = 0;
    int button_online_state = 0;
    int button_workshop_state = 0;
    int icon_num_1 = 0;
    int icon_num_2 = 0;
    int tutorial_icon_1_resize = 0;
    int tutorial_icon_2_resize = 0;
    int tutorial_icon_3_resize = 0;
    int tutorial_icon_4_resize = 0;
    int tutorial_anime = 0;
    int last_level;
    int tv_size = 10;
    int prob_y = 400;
    int planet_id = 1;
    float scan_height = 0.0f;
    int scan_y = 0;
    int box_size = 200;
    int ring_1_xy = 0;
    int ring_2_xy = 100;
    int skin_y = 0;
    int last_touched = 0;
    int icon_color_1 = 1;
    int icon_color_2 = 2;
    int icon_color_3 = 3;
    int icon_color_4 = 4;
    int tutorial_circle_size = 0;
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
    float tutorial_circle_rotate = 0.0f;
    boolean box_is_showing_items = false;
    boolean box_bluefire = false;
    boolean box_is_opening = false;
    boolean box_dark_back = false;
    boolean last_back = false;
    boolean need_to_update_icons = false;
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
    float robot_x;
    float box_min_state = 1.0f;
    boolean tutorial_touch = false;
    boolean istutorial = false;
    boolean resize_scene = false;
    boolean bird_swap = false;
    boolean swap_planet = false;
    boolean scan = false;
    boolean icon_1_touch = false;
    boolean icon_2_touch = false;
    boolean icon_3_touch = false;
    boolean icon_4_touch = false;
    boolean box_taked = false;
    boolean box_can_click = true;
    boolean need_to_update_box_item = false;

    int tutorial_scene_size;
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
    int box_item_type = 0;
    int box_item_model;
    int box_item_detail;
    float box_item_scale_1 = 1.0f;
    float box_item_scale_2 = 1.0f;
    float box_bluefire_scale = 0.01f;
    float box_state = 2.0f;
    float box_back_rotate = 0.0f;
    float box_back_scale = 0.01f;
    int box_x = 0;
    int box_y = 215;
    float box_scale = 0.7f;
    public GameMenu(MainGame game) { this.game = game; }
    @Override
    public void show() {
        game.MusicSwap(2);
        game.robot.Safe();
        game.robot.RandomEnemy();
        dark = new Texture("Interface/dark2.png");
        bluefire = new Texture("Object/bluefire.png");
        for(int i = 0; i<9; i++) box[i] = new Texture("Object/box_"+(i+1)+".png");
        tutorial_circlet = new Texture("Tutorial/back_0.png");
        tutorial_circle = new TextureRegion(tutorial_circlet, 400, 400);
        tutorial_icon[0] = new Texture("Tutorial/icon_1_0_0.png");
        tutorial_icon[1] = new Texture("Tutorial/icon_2_0_0.png");
        tutorial_icon[2] = new Texture("Tutorial/icon_3_0_0.png");
        tutorial_icon[3] = new Texture("Tutorial/icon_4_0_0.png");
        tutorial_frame_color[0] = new Texture("Tutorial/frame_touch_1_1.png");
        tutorial_frame_color[1] = new Texture("Tutorial/frame_touch_1_2.png");
        tutorial_frame_color[2] = new Texture("Tutorial/frame_touch_1_3.png");
        tutorial_frame_color[3] = new Texture("Tutorial/frame_touch_2_1.png");
        tutorial_frame_color[4] = new Texture("Tutorial/frame_touch_2_2.png");
        tutorial_frame_color[5] = new Texture("Tutorial/frame_touch_2_3.png");
        tutorial_frame_color[6] = new Texture("Tutorial/frame_touch_3_1.png");
        tutorial_frame_color[7] = new Texture("Tutorial/frame_touch_3_2.png");
        tutorial_frame_color[8] = new Texture("Tutorial/frame_touch_3_3.png");
        tutorial_frame_color[9] = new Texture("Tutorial/frame_touch_4_1.png");
        tutorial_frame_color[10] = new Texture("Tutorial/frame_touch_4_2.png");
        tutorial_frame_color[11] = new Texture("Tutorial/frame_touch_4_3.png");
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
        button_ship = new Texture("Button/button_ship.png");
        tutorials = new Texture("Interface/back.png");
        ring = new Texture("Object/ring" + game.robot.color + ".png");
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
        button_left_part = new Texture("Button/button_left_part.png");
        button_right_part = new Texture("Button/button_right_part.png");
        button_center_part = new Texture("Button/button_center_part.png");
        back_light= new Texture("Interface/back_light.png");
        button_exit_icon= new Texture("Interface/icon_exit.png");
        button_workshop_icon= new Texture("Interface/icon_workshop.png");
        button_fight_icon= new Texture("Interface/icon_fight.png");
        button_online_icon= new Texture("Interface/icon_online.png");
        button_tutorial_icon= new Texture("Interface/icon_tutorial.png");
        location_2_planet_texture = new Texture("Object/planet_3.png");
        front_break = new Texture("Interface/break.png");
        grass = new Texture("Location/grass_" + game.robot.level + ".png");
        metall = new Texture("Item/metall.png");
        chip = new Texture("Item/chip.png");
        bulb = new Texture("Item/bulb.png");
        gear = new Texture("Item/gear.png");
        frame= new Texture("Interface/frame.png");
        planet_id = game.robot.level;
        location_2_planet = new TextureRegion(location_2_planet_texture, 400, 400);
        planet = new Texture("Object/planet_" + planet_id + ".png");
        Gdx.input.setInputProcessor(new GameMenuTouch(game, this));
        button_right =  new Texture("Button/button_right.png");
        button_left =  new Texture("Button/button_left.png");
        music =  new Texture("Button/music_1.png");
        music_stop =  new Texture("Button/music_2.png");
        camp = new Texture("Interface/camp_" + game.robot.level + ".png");
        Start();
        box_x = width-625;
        robot_x = width-400;
        setRandomAnime();
        game.robot.UpdateSkins();
        batch = new SpriteBatch();
       TutorialAnime = new Thread(){
            @Override
            public void run(){
                while(!closed){
                        tutorial_anime++;
                        if(tutorial_anime >= 3){
                            tutorial_anime = 0;
                        }

                    Sleep(70);
                    }

                }
        };
        box_anime = new Thread(){
            @Override
            public void run(){
                int dir = 1;
                while(!closed && !box_taked){
                    if(!box_dark_back) {
                        if (dir == 1) {
                            box_state += 0.01f;
                            if (box_state >= 2.0f) {
                                dir = 0;
                            }
                        } else {
                            box_state -= 0.01f;
                            if (box_state <= 2.0f - 0.3f * box_min_state) {
                                dir = 1;
                            }
                        }
                    }
                    Sleep(3);

                }


            }
        };
        box_anime.start();
        button_anime = new Thread(){
            @Override
            public void run(){
                while(!closed){
                    if(close_touch && button_exit_state<100){
                        button_exit_state +=1;
                    }else{
                        if(button_exit_state>0 && !close_touch){
                            button_exit_state -=1;
                        }
                    }
                    if(play_touch && button_fight_state<100){
                        button_fight_state +=1;
                    }else{
                        if(button_fight_state>0 && !play_touch){
                            button_fight_state -=1;
                        }
                    }
                    if(tutorial_touch && button_tutorial_state<100){
                        button_tutorial_state +=1;
                    }else{
                        if(button_tutorial_state>0 && !tutorial_touch){
                            button_tutorial_state -=1;
                        }
                    }
                    if(multiplayer_touch && button_online_state<100){
                        button_online_state +=1;
                    }else{
                        if(button_online_state>0 && !multiplayer_touch){
                            button_online_state -=1;
                        }
                    }
                    if(work_touch && button_workshop_state<100){
                        button_workshop_state +=1;
                    }else{
                        if(button_workshop_state>0 && !work_touch){
                            button_workshop_state -=1;
                        }
                    }
                    Sleep(3);
                }

            }
        };
        TutorialIconAnime = new Thread(){
            @Override
            public void run(){
                while(!closed){
                    if(icon_1_touch && tutorial_icon_1_resize < 100){
                        tutorial_icon_1_resize += 5;

                    }
                    if(icon_2_touch && tutorial_icon_2_resize < 100){
                        tutorial_icon_2_resize += 5;

                    }
                    if(icon_3_touch && tutorial_icon_3_resize < 100){
                        tutorial_icon_3_resize += 5;

                    }
                    if(icon_4_touch && tutorial_icon_4_resize < 100){
                        tutorial_icon_4_resize += 5;

                    }

                    if(!icon_1_touch && tutorial_icon_1_resize > 0){
                        tutorial_icon_1_resize -= 5;

                    }
                    if(!icon_2_touch && tutorial_icon_2_resize > 0){
                        tutorial_icon_2_resize -= 5;

                    }
                    if(!icon_3_touch && tutorial_icon_3_resize > 0){
                        tutorial_icon_3_resize -= 5;

                    }
                    if(!icon_4_touch && tutorial_icon_4_resize > 0){
                        tutorial_icon_4_resize -= 5;

                    }
                    tutorial_circle_rotate-=0.15f;
                    if(tutorial_circle_rotate < 0.0f){
                        tutorial_circle_rotate = 360.0f;
                    }
                    Sleep(5);
                }

            }
        };
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
                        robot_x+=0.1f;
                        scale-=0.0008f;
                        rotation_head+=0.2f;
                        rotation_hand-=0.1f;
                        if(rotation_head>=4.0f){
                            dir=2;
                            time = game.random.nextInt(10)+6;
                        }
                    }else{
                        robot_x-=0.1f;
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
        TutorialAnime.start();
        TutorialIconAnime.start();
            anime_grass.start();
            anime_smoke.start();
            space_anime.start();
        anime_hand.start();
        button_anime.start();
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

        if(game.robot.box_empty && !box_dark_back) {
            DrawBox(drawer, this, box_x, box_y, box_scale, box_state);
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

        DrawDefaultButton(drawer, button_left_part, button_center_part, button_right_part, back_light, button_tutorial_icon, button_tutorial_state, width/2-250, 25, 200);
        DrawDefaultButton(drawer, button_left_part, button_center_part, button_right_part, back_light, button_online_icon, button_online_state, width/2+50, 25, 200);

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
        DrawDefaultButton(drawer, button_left_part, button_center_part, button_right_part, back_light, button_exit_icon, button_exit_state, 100, -20, 400);

        DrawDefaultButton(drawer, button_left_part, button_center_part, button_right_part, back_light, button_fight_icon, button_fight_state, width-500, -20, 400);

        DrawDefaultButton(drawer, button_left_part, button_center_part, button_right_part, back_light, button_workshop_icon, button_workshop_state, 670, height-185, 300);

        if (game.music.isPlaying()) {
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
            item_font.draw(batch, game.robot.gear_chance[game.robot.level-1]+"%", (int)((width-275+30)*wpw), (int)((110-prob_y)*hph));
            item_font.draw(batch, game.robot.bulb_chance[game.robot.level-1]+"%", (int)(380*wpw), (int)((110-prob_y)*hph));
            item_font.draw(batch, game.robot.metal_chance[game.robot.level-1]+"%", (int)((width-500+30)*wpw), (int)((110-prob_y)*hph));
        }

        if(isTv){
            TextureRegion planet_region = new TextureRegion(planet, 400, 400);
            drawer.draw(planet_region, width/2-tv_size/2, height/2-tv_size/2, tv_size/2, tv_size/2,  tv_size, tv_size,1.0f, 1.0f, planet_rotate, true);
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
                drawer.draw(tutorials, tutorial_scene_size - width - 10, 0, width+10, height);
                if(tutorial_circle_size>=5) {
                    drawer.draw(tutorial_circle, width / 2 - tutorial_circle_size / 2 + tutorial_scene_size - width - 10, height / 2 - tutorial_circle_size / 2, tutorial_circle_size / 2, tutorial_circle_size / 2, tutorial_circle_size, tutorial_circle_size, 1, 1, tutorial_circle_rotate);
                }
                drawer.draw(tutorial_frame_color[tutorial_anime+(icon_color_1-1)*3], width-scene_size, 150+width-scene_size, 500, 500);
                drawer.draw(tutorial_frame_color[tutorial_anime+(icon_color_2-1)*3], 400-width+scene_size, 150-width+scene_size, 500, 500);
                drawer.draw(tutorial_frame_color[tutorial_anime+(icon_color_3-1)*3], 800+width-scene_size, 150+width-scene_size, 500, 500);
                drawer.draw(tutorial_frame_color[tutorial_anime+(icon_color_4-1)*3], 1200-width+scene_size, 150-width+scene_size, 500, 500);

                drawer.draw(tutorial_icon[0], tutorial_icon_1_resize/2+width-scene_size, 150+tutorial_icon_1_resize/2+width-scene_size, 500-tutorial_icon_1_resize, 500-tutorial_icon_1_resize);
                drawer.draw(tutorial_icon[1], 400+tutorial_icon_2_resize/2-width+scene_size, 150+tutorial_icon_2_resize/2-width+scene_size, 500-tutorial_icon_2_resize, 500-tutorial_icon_2_resize);
                drawer.draw(tutorial_icon[2], 800+tutorial_icon_3_resize/2+width-scene_size, 150+tutorial_icon_3_resize/2+width-scene_size, 500-tutorial_icon_3_resize, 500-tutorial_icon_3_resize);
                drawer.draw(tutorial_icon[3], 1200+tutorial_icon_4_resize/2-width+scene_size, 150+tutorial_icon_4_resize/2-width+scene_size, 500-tutorial_icon_4_resize, 500-tutorial_icon_4_resize);

                if(need_to_update_icons){
                    need_to_update_icons = false;

                        tutorial_circlet.dispose();
                        tutorial_circlet = new Texture("Tutorial/back_" + icon_num_1 + ".png");
                        tutorial_circle = new TextureRegion(tutorial_circlet, 400, 400);

                    for(int i = 0; i<4; i++){
                        tutorial_icon[i].dispose();
                        tutorial_icon[i] = new Texture("Tutorial/icon_" + (i+1) + "_" + icon_num_1 + "_" + icon_num_2 + ".png");
                    }
                }
        }
        if(box_dark_back) {
            drawer.draw(dark, 0, 0, width, height);
            drawer.draw(tutorial_circle, box_x-(box_back_scale*1.5f*width-box_scale*300)/2, box_y-(box_back_scale*1.5f*width-box_scale*300)/2, width/2*1.5f * box_back_scale, width/2*1.5f * box_back_scale,  (1.5f*width * box_back_scale),  (1.5f*width * box_back_scale), 1, 1,  box_back_rotate);
            if(!box_is_showing_items) {
                DrawBox(drawer, this, box_x, box_y, box_scale, box_state);
            }else{
                drawer.draw(box_item_1, box_x+(300*box_scale-300*box_scale*box_item_scale_1)/2, box_y+(300*box_scale-300*box_scale*box_item_scale_1)/2, 300*box_scale*box_item_scale_1, 300*box_scale*box_item_scale_1);
                drawer.draw(box_item_2, box_x+(300*box_scale-300*box_scale*box_item_scale_2)/2, box_y+(300*box_scale-300*box_scale*box_item_scale_2)/2, 300*box_scale*box_item_scale_2, 300*box_scale*box_item_scale_2);
            }            if(box_bluefire) {
                drawer.draw(bluefire, box_x - (box_bluefire_scale * width - box_scale * 300) / 2, box_y - (box_bluefire_scale * width - box_scale * 300) / 2, width * box_bluefire_scale, width * box_bluefire_scale);
            }
        }
        CheckDoor(drawer);
        batch.end();
        if(need_to_update_box_item) {
            if (box_item_type == 1) {
                box_item_1 = new Texture("Object/workpage_2_circle.png");
                if (box_item_detail == 1) {
                    box_item_2 = new Texture("Robot/head_" + box_item_model + "_1.png");
                }
                if (box_item_detail == 2) {
                    box_item_2 = new Texture("Robot/body_" + box_item_model + "_1.png");
                }
                if (box_item_detail == 3) {
                    box_item_2 = new Texture("Robot/leg_" + box_item_model + "_1.png");
                }
                if (box_item_detail == 4) {
                    box_item_2 = new Texture("Robot/hand_" + box_item_model + "_1.png");
                }

            }
            if (box_item_type == 2) {

            }
                need_to_update_box_item = false;

        }
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
    public void BoxClick() {
        if(box_can_click) {
            if (box_dark_back && !box_is_opening) {
                box_is_opening = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        box_can_click = false;
                        while (box_scale > 2.0f) {
                            box_x = (int) (width / 2 - 330.0f) + (int) (2.2f * 300 - box_scale * 300) / 2;
                            box_y = 130 + (int) (2.2f * 300 - box_scale * 300) / 2;
                            box_scale -= 0.01f;
                            Sleep(10);
                        }
                        while (box_state > 1.75f) {
                            box_state -= 0.01f;

                            Sleep(10);
                        }
                        Sleep(100);
                        while (box_state > 1.25f) {
                            box_state -= 0.02f;
                            box_back_scale += 0.003f;
                            Sleep(5);
                        }
                        Sleep(50);
                        while (box_state > 1.00f) {
                            box_state -= 0.02f;
                            box_back_scale += 0.002f;
                            Sleep(5);
                        }
                        Sleep(50);
                        while (box_state > 0.25f) {
                            box_state -= 0.02f;
                            box_back_scale -= 0.002f;
                            Sleep(5);
                        }
                        while (box_state > 0.0f) {
                            box_state -= 0.01f;
                            box_back_scale -= 0.002f;
                            Sleep(5);
                        }
                        box_bluefire = true;
                        while (box_bluefire_scale < 1.5f) {
                            if (box_state > 1.0f) {
                                box_state -= 0.05f;
                            }
                            box_bluefire_scale += 0.03f;
                            Sleep(5);
                        }
                        //box_item_type = game.random.nextInt(3)+1;
                        box_item_type = 1;
                        if (box_item_type == 1) {
                            box_item_detail = 1;
                            box_item_model = 1;
                            if(!game.robot.AllDetailsExist()) {
                                while (game.robot.DetailExist(box_item_detail, box_item_model)) {
                                    box_item_detail = game.random.nextInt(4) + 1;
                                    box_item_model = game.random.nextInt(5) + 1;

                                }
                            }else{
                                box_item_detail = game.random.nextInt(4) + 1;
                                box_item_model = game.random.nextInt(5) + 1;
                            }
                            game.robot.AddDetail(box_item_detail, box_item_model);
                            need_to_update_box_item = true;
                            while (need_to_update_box_item) {
                                Sleep(10);
                            }
                        }
                        box_item_scale_1 = 0.4f;
                        box_item_scale_2 = 0.1f;
                        box_is_showing_items = true;


                        Sleep(100);
                        while (box_bluefire_scale > 0.01f) {

                            box_bluefire_scale -= 0.03f;
                            Sleep(5);
                        }

                        box_bluefire = false;


                        while (box_item_scale_1 < 1.0f) {
                            box_item_scale_1 += 0.02f;
                            box_item_scale_2 += 0.02f;
                            Sleep(20);
                        }
                        box_can_click = true;
                        int dir_scale = 1;
                        while (box_is_showing_items) {
                            if (dir_scale == 1) {
                                box_item_scale_1 -= 0.005f;
                                box_item_scale_2 -= 0.01f;
                                if (box_item_scale_1 <= 0.9f) {
                                    dir_scale = 0;
                                }
                            } else {
                                box_item_scale_1 += 0.005f;
                                box_item_scale_2 += 0.01f;
                                if (box_item_scale_1 >= 1.1f) {
                                    dir_scale = 1;
                                }
                            }
                            Sleep(50);
                        }
                    }
                };
                anime.start();
            } else {
                if (box_is_showing_items) {
                    Thread anime = new Thread() {
                        @Override
                        public void run() {

                            box_can_click = false;
                            while (box_back_scale > 0.005f || box_item_scale_1 > 0.0f || box_item_scale_2 > 0.0f) {
                                if (box_back_scale > 0.005f) {
                                    box_back_scale -= 0.005f;
                                }
                                if (box_item_scale_1 > 0.0f) {
                                    box_item_scale_1 -= 0.0075f;
                                }
                                if (box_item_scale_2 > 0.0f) {
                                    box_item_scale_2 -= 0.0075f;
                                }
                                Sleep(5);
                            }
                            box_can_click = true;
                            box_is_opening = false;
                            box_dark_back = false;
                            box_is_showing_items = false;
                            box_scale = 0;
                            box_state = 2.0f;
                            box_scale = 0.7f;
                            box_x = width - 625;
                            box_y = 215;
                            box_back_scale = 0.0f;
                            box_min_state = 1.0f;
                            box_back_rotate = 0.0f;
                            box_item_scale_1 = 0.1f;
                            box_item_scale_2 = 0.1f;
                            box_item_type = 1;
                            box_item_1.dispose();
                            box_item_2.dispose();

                        }

                    };
                    anime.start();

                }
            }
        }
    }
    public void BoxOpen() {
        box_dark_back = true;
        tutorial_circlet.dispose();
        tutorial_circlet = new Texture("Tutorial/back_2.png");
        tutorial_circle = new TextureRegion(tutorial_circlet, 400, 400);
        Thread anime = new Thread() {
            @Override
            public void run() {
                box_can_click = false;
                while (box_x > width / 2 - 150 * 2.2f || box_y > 130 || box_scale<2.2f) {
                    if (box_x > width / 2 - 150 * 2.2f) {
                        box_x -= 10;
                    }
                    if (box_y > 130) {
                        box_y -= 5;
                    }
                    if (box_scale < 2.2f) {

                        box_scale += 0.02f;
                    }
                    Sleep(10);
                }
                box_can_click = true;
                    int dir_scale = 1;
                    while (box_dark_back) {
                        if(!box_is_opening) {
                            if (dir_scale == 1) {
                                box_x = (int) (width / 2 - 330.0f) + (int) (2.2f * 300 - box_scale * 300) / 2;
                                box_y = 130 + (int) (2.2f * 300 - box_scale * 300) / 2;
                                box_scale += 0.005f;

                                if (box_scale >= 2.2f) {
                                    dir_scale = 0;
                                }
                            } else {
                                box_x = (int) (width / 2 - 330.0f) + (int) (2.2f * 300 - box_scale * 300) / 2;
                                box_y = 130 + (int) (2.2f * 300 - box_scale * 300) / 2;
                                box_scale -= 0.005f;

                                if (box_scale <= 2.0f) {
                                    dir_scale = 1;
                                }
                            }
                        }
                        Sleep(10);
                    }

                }

        };
        anime.start();
        Thread anime2 = new Thread() {
            @Override
            public void run() {

                while (box_dark_back) {
                    box_back_rotate+=0.5f;
                    if (box_back_rotate>360.0f){
                        box_back_rotate=0.0f;
                    }

                    if(box_back_scale<1.0f && !box_is_opening){
                        box_back_scale+=0.02f;
                    }
                    Sleep(10);
                }

            }

        };
        anime2.start();
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
                    game.MusicSwap(2);
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
                    game.MusicSwap(3);
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
            SetRing();
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
            SetRing();

        }
    }
    public void SetRing(){
        ring.dispose();
        ring = new Texture("Object/ring" + game.robot.color + ".png");
    }
    public void SetTutorial(int touched, boolean back) {
        if (istutorial && !resize_scene) {
            resize_scene = true;
            last_touched = touched;
            last_back = back;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while (scene_size < width*1.5) {
                        if(icon_num_1==0 || last_back) {
                            if (tutorial_circle_size < width * 1.75) {
                                tutorial_circle_size += 13;
                            }
                        }
                        scene_size += 5;
                        Sleep(2);
                    }

                    if(!last_back) {
                        if (icon_num_1 == 0) {
                            icon_num_1 = last_touched;
                        } else {
                            icon_num_2 = last_touched;
                        }

                        icon_color_1 = icon_num_1;
                        icon_color_2 = icon_num_1;
                        icon_color_3 = icon_num_1;
                        icon_color_4 = icon_num_1;
                    }else{
                        icon_color_1 = 1;
                        icon_color_2 = 2;
                        icon_color_3 = 3;
                        icon_color_4 = 4;
                        if (icon_num_2 != 0) {
                            icon_num_2 = 0;
                        } else {
                            icon_num_1 = 0;
                        }
                    }
                    scene_size = (int)(width*0.5);
                    need_to_update_icons = true;
                    while (scene_size < width) {
                        if(last_back){
                            if(tutorial_circle_size>0){
                                tutorial_circle_size-=20;
                            }
                        }
                        scene_size += 5;
                        Sleep(2);
                    }
                    resize_scene = false;
                }
            };
            anime.start();

        }
    }
    public void SceneTutorial(){
        Thread anime = new Thread(){
            @Override
            public void run() {
                if (!resize_scene) {
                    if (istutorial) {
                            resize_scene = true;
                            while (tutorial_scene_size > 0) {
                                scene_size -= 5;
                                tutorial_scene_size -= 5;
                                Sleep(2);
                            }
                            resize_scene = false;
                            istutorial = false;
                   }  else {
                        resize_scene = true;
                        while (tutorial_scene_size < width) {
                            if(tutorial_circle_size>0){
                                tutorial_circle_size-=10;
                            }
                            scene_size += 5;
                            tutorial_scene_size += 5;
                            Sleep(2);
                        }
                        resize_scene = false;
                        istutorial = true;
                    }
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

        machine_4.dispose();
        machine_2.dispose();
        machine_3.dispose();
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
        birds[4].dispose();
        camp.dispose();
        music.dispose();
        music_stop.dispose();
        bulb.dispose();
        gear.dispose();
        metall.dispose();
        chip.dispose();
        front_break.dispose();
        throne.dispose();
        ring.dispose();
        button_left.dispose();
        button_right.dispose();
        frame.dispose();
        planet.dispose();
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
        tutorial_circlet.dispose();
        location_2_planet_texture.dispose();
        button_left_part.dispose();
        button_right_part.dispose();
        button_center_part.dispose();
        back_light.dispose();
        button_exit_icon.dispose();
        button_workshop_icon.dispose();
        button_fight_icon.dispose();
        button_online_icon.dispose();
        button_tutorial_icon.dispose();
        dark.dispose();
        bluefire.dispose();

        for(int i = 0; i<9; i++) box[i].dispose();
        for(int i = 0; i<11; i++) tutorial_frame_color[i].dispose();
        for(int i = 0; i<4; i++) tutorial_icon[i].dispose();
    }
}
