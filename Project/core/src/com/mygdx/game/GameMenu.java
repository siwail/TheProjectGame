package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class GameMenu extends Openable implements Screen{
    SpriteBatch batch;
    Thread anime_smoke;
    Thread anime_hand;
    Thread anime_grass;
    Texture camp;
    Texture play;
    Texture close;
    Texture music;
    Texture workspace;
    Texture frame;
    Texture grass;
    Texture gear;
    Texture chip;
    Texture metall;
    Texture bulb;
    Texture white;
    Texture exit;
    Texture work;
    Texture go;
    Texture[] smoke = new Texture[4];
    Texture[] birds = new Texture[4];
    float rotation_hand = 0.0f;
    float scale = 1.05f;
    float rotation_head = 0.0f;
    float rotation_leg = 0.0f;
    boolean close_touch = false;
    boolean play_touch = false;
    boolean BirdFly;
    boolean work_touch = false;
    boolean isJump = false;
    double robot_x;
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
        smoke[0] = new Texture("Object/smoke1.png");
        smoke[1] = new Texture("Object/smoke2.png");
        smoke[2] = new Texture("Object/smoke3.png");
        smoke[3] = new Texture("Object/smoke4.png");
        birds[0] = new Texture("Object/bird_1.png");
        birds[1] = new Texture("Object/bird_2.png");
        birds[2] = new Texture("Object/bird_3.png");
        birds[3] = new Texture("Object/bird_4.png");
        work = new Texture("Button/work.png");
        exit = new Texture("Button/exit.png");
        go = new Texture("Button/button.png");
        white = new Texture("Button/button_white.png");
        grass = new Texture("Location/grass_1.png");
        metall = new Texture("Item/metall.png");
        chip = new Texture("Item/chip.png");
        bulb = new Texture("Item/bulb.png");
        gear = new Texture("Item/gear.png");
        Gdx.input.setInputProcessor(new GameMenuTouch(game, this));
        frame = new Texture("Interface/frame.png");
        music =  new Texture("Button/music_1.png");
        camp = new Texture("Interface/camp_2.png");
        Start();
        robot_x = width-400;
        open_x = 0;
        setRandomAnime();
        batch = new SpriteBatch();
        anime_grass = new Thread(){
            @Override
            public void run(){
                while(true){
                    if(grass_dir_1 == 1){
                        anime_grass_1+=1;
                        if(anime_grass_1>=50){
                            grass_dir_1 = 0;
                        }
                    }else{
                        anime_grass_1-=1;
                        if(anime_grass_1<=-10){
                            grass_dir_1 = 1;
                        }
                    }
                    if(grass_dir_2 == 1){
                        anime_grass_2+=1;
                        if(anime_grass_2>=50){
                            grass_dir_2 = 0;
                        }
                    }else{
                        anime_grass_2-=1;
                        if(anime_grass_2<=-10){
                            grass_dir_2 = 1;
                        }
                    }
                    if(closed){
                        break;
                    }
                    Sleep(15);
                }
            }
        };
        anime_smoke = new Thread(){
            @Override
            public void run(){
                while(true){
                    smoke_anime++;
                    if (smoke_anime>=3){
                        smoke_anime=0;
                    }
                    if(closed){
                        break;
                    }
                    Sleep( 100);
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
        drawer = new SpriteBatchRubber(this, batch);
        anime_grass.start();
        anime_hand.start();
        anime_smoke.start();
        DoorOpen();
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        batch.begin();
        drawer.draw(camp, 0, 0, width, height);
        drawer.draw(grass, width-200, 230, 250, 250+anime_grass_1);
        drawer.draw(grass, -70, 230, 250, 250+anime_grass_2);
        DrawRobot(drawer, (int)robot_x, robot_y, scale, rotation_hand+90, rotation_head, rotation_leg, 0 , false, false, false, 0);
        if (BirdFly) {
            TextureRegion bird_region = new TextureRegion(birds[bird_anime], 400, 400);
            batch.draw(bird_region, birdx, birdy,0, 0, 250, 250, 1, 1, (birdy-height/2)/5);
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
        drawer.draw(close, 50, 0, 500, 250);
        drawer.draw(play, width-550, 0, 500, 250);
        drawer.draw(workspace, 620, height-200, 400, 200);
        drawer.draw(music, 1020, height-100, 100, 100);
        drawer.draw(frame, 10, height-120, 120, 120);
        drawer.draw(frame, 130, height-120, 120, 120);
        drawer.draw(frame, 250, height-120, 120, 120);
        drawer.draw(frame, 370, height-120, 120, 120);
        drawer.draw(metall, 10, height-120, 120, 120);
        drawer.draw(gear, 130, height-120, 120, 120);
        drawer.draw(chip, 250, height-120, 120, 120);
        drawer.draw(bulb, 370, height-120, 120, 120);
        item_font.draw(batch, Integer.toString(Gdx.graphics.getWidth()), (int)(20.0*wpw), (int)((height-80)*hph));
        item_font.draw(batch, Integer.toString(Gdx.graphics.getHeight()), (int)(140.0*wpw), (int)((height-80)*hph));
        item_font.draw(batch, Integer.toString(game.robot.microchips), (int)(260.0*wpw), (int)((height-80)*hph));
        item_font.draw(batch, Integer.toString(game.robot.lamps), (int)(380.0*wpw), (int)((height-80)*hph));
        drawer.draw(smoke[smoke_anime], width/2-125, 400, 175, 175);
        CheckClose(drawer);
        CheckOpen(drawer);
        batch.end();
        if(closed){
            if(type_close == 1) {
                game.setWorkMenu();
            }
            if(type_close == 2) {
                game.setGamePlay();
            }
        }
    }
    public void setRandomAnime(){
        Thread rand = new Thread(){
            @Override
            public void run(){
                while(true){
                    int a = game.random.nextInt( 20);
                    if (a == 1){
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
            public void run(){
                int dir_anime = 1;
                BirdFly = true;
                bird_anime = 1;
                birdx = -250;
                birdy = height/2 - game.random.nextInt(80);
                while(birdx < width+250){
                    birdx+=10;
                    birdy++;
                    if(dir_anime == 1) {
                        bird_anime++;
                        if(bird_anime > 3){
                            bird_anime = 3;
                            dir_anime = 0;
                        }
                    }else{
                        bird_anime--;
                        if(bird_anime < 0){
                            bird_anime = 0;
                            dir_anime = 1;
                        }
                    }
                    Sleep( 30);
                }
                BirdFly = false;
            }
        };
        fly.start();
    }
    @Override
    public void dispose () {
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
        work.dispose();
        camp.dispose();
        door_left.dispose();
        door_right.dispose();
        play.dispose();
        workspace.dispose();
        music.dispose();
    }
}
