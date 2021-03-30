package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class GameMenu extends Openable implements Screen{
    SpriteBatch batch;
    Thread anime;
    Thread door;
    Texture camp;
    Texture play;
    Texture close;
    Texture music;
    Texture workspace;
    Texture frame;
    Texture smoke;
    Texture bird;
    boolean close_touch = false;
    boolean BirdFly;
    boolean work_touch = false;
    int smoke_anime = 1;
    int birdx;
    int birdy;
    int bird_anime;
    public GameMenu(MainGame game) { this.game = game; }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(new GameMenuTouch(game, this));
        frame = new Texture("frame.png");
        play =  new Texture("button.png");
        music =  new Texture("music_1.png");
        camp = new Texture("camp_2.png");
        Start();
        open_x = 0;
        setRandomAnime();
        batch = new SpriteBatch();
        anime  = new Thread(){
            @Override
            public void run(){
                while(true){
                    smoke_anime++;
                    if (smoke_anime>=5){
                        smoke_anime=1; }
                    Sleep(this, 100);
                }
            }
        };
        anime.start();
        DoorOpen();
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        batch.begin();
        batch.draw(camp, 0, 0, width, height);
        bird = new Texture("bird_1.png");
        if (BirdFly) {
            if (bird_anime - 2 > 0) {
                bird.dispose();
                bird = new Texture("bird_" + (bird_anime - 2) + ".png");
            }
            TextureRegion bird_region = new TextureRegion(bird, 400, 400);
            batch.draw(bird_region, birdx, birdy,0, 0, 250, 250, 1, 1, (birdy-height/2)/5);
        }
        if(close_touch){
            close= new Texture("button_white.png");
        }else{
            close= new Texture("exit.png");
        }
        if(work_touch){
            workspace= new Texture("button_white.png");
        }else{
            workspace= new Texture("work.png");
        }
        smoke = new Texture("smoke" + smoke_anime + ".png");
        batch.draw(close, 50, 0, 500, 250);
        batch.draw(play, width-550, 0, 500, 250);
        batch.draw(workspace, 620, height-200, 400, 200);
        batch.draw(music, 510, height-100, 100, 100);
        batch.draw(frame, 10, height-100, 100, 100);
        batch.draw(frame, 110, height-100, 100, 100);
        batch.draw(frame, 210, height-100, 100, 100);
        batch.draw(frame, 310, height-100, 100, 100);
        batch.draw(frame, 410, height-100, 100, 100);
        batch.draw(smoke, width/2-125, 400, 175, 175);
        CheckClose(batch);
        CheckOpen(batch);
        batch.end();
        workspace.dispose();
        bird.dispose();
        close.dispose();
        smoke.dispose();
        if(closed){
            game.setWorkMenu();
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
                    Sleep(this, 1000);
                }
            }
        };
        rand.start();
    }
    public void Bird(){
        Thread fly = new Thread(){
            @Override
            public  void run(){
                BirdFly = true;
                bird_anime = 1;
                birdx = -250;
                birdy = height/2 - game.random.nextInt(50);
                while(birdx < width+250){
                    birdx+=10;
                    birdy++;
                    bird_anime++;
                    if(bird_anime > 10){
                        bird_anime = 1;
                    }
                    Sleep(this, 30);
                }
                BirdFly = false;
                bird.dispose();
            }
        };
        fly.start();
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
    public void dispose () {
        smoke.dispose();
        camp.dispose();
        batch.dispose();
        door_left.dispose();
        door_right.dispose();
        play.dispose();
        workspace.dispose();
        music.dispose();

    }
}
