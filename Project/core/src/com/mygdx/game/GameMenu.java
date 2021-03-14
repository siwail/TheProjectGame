package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

import javax.xml.soap.Text;
public class GameMenu implements Screen{

    //Объявление всех объектов и переменных
    MainGame game;
    SpriteBatch batch;
    Thread anime;
    Thread door;
    Texture camp;
    Texture door_left;
    Texture door_right;
    Texture play;
    Texture close;
    Texture music;
    Texture workspace;
    Texture frame;
    Texture smoke;
    Texture bird;
    boolean close_touch = false;
    boolean BirdFly;
    boolean isOpen = false;
    int smoke_anime = 1;
    int open_x;
    int width;
    int birdx;
    int birdy;
    int bird_anime;
    int height;

    //Конструктор, принимающий основу приложения (MainGame)
    public GameMenu(MainGame game) { this.game = game; }

    //При установке экрана активируется метод show:
    @Override
    public void show() {

        //Установка InputProcessor
        Gdx.input.setInputProcessor(new GameMenuTouch(game, this));

        //Выделение памяти для текстур и игровых элементов
        frame = new Texture("frame.png");
        play =  new Texture("button.png");
        music =  new Texture("music_1.png");
        workspace =  new Texture("work.png");
        door_left =  new Texture("door_1.png");
        door_right=  new Texture("door_2.png");

        camp = new Texture("camp_2.png");

        //Объявление переменных, содержащих ширину и длину экрана
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        //Запуск интересной функции. Она не имеет никакого отношения к аниме, а лишь запускает случайный порядок различных анимаций на фоне
        setRandomAnime();


        //Выделение места для объекта типа SpriteBatch, который вроде бы осуществляет прорисовку текстур на экране
        batch = new SpriteBatch();

        //Описание потока anime, который осуществляет некоторые анимации
        anime  = new Thread(){
            @Override
            public void run(){
                while(true){

                    //Анимация легкого дымка, веящего из костра
                    smoke_anime++;
                    if (smoke_anime>=5){
                        smoke_anime=1;
                    }

                    //Безопасная установка тактов смены анимации
                    try {
                        sleep(100);
                    } catch (Exception ignored) {

                    }
                }

            }
        };

        //Запуск потока anime
        anime.start();

        //Описание потока door, осуществляющего анимацию открытия металлической двери при переходе на данный экран
        door = new Thread(){
            @Override
            public void run(){
                try {
                    //Задержка анимации
                    sleep(1000);
                } catch (Exception ignored) {

                }
                while(open_x < width) {
                    open_x += 5;

                    try {
                        sleep(5);
                    } catch (Exception ignored) {

                    }
                }
                //Уничтожение двери и установка предупреждения, что дверь открыта.
                isOpen = true;
                door_left.dispose();
                door_right.dispose();

            }

        };
        door.start();
    }

    //Описание класса render, в котором происходит все самое интересное. В том числе, прорисовка
    @Override
    public void render(float delta) {

        //Очищение памяти экрана (Вроде бы)
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        //Открытие SpriteBatch и прорисовка всех объектов.
        batch.begin();
        batch.draw(camp, 0, 0, width, height);

        //Выбор текстуры и прорисовка птицы
        bird = new Texture("bird_1.png");
        if (BirdFly) {

            if (bird_anime - 2 > 0) {
                bird.dispose();
                bird = new Texture("bird_" + (bird_anime - 2) + ".png");
            }

            TextureRegion bird_region = new TextureRegion(bird, 1000, 1000);
            batch.draw(bird_region, birdx, birdy,0, 0, 250, 250, 1, 1, (birdy-height/2)/5);
        }
        if(close_touch){
            close= new Texture("button_white.png");
        }else{
            close= new Texture("exit.png");
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

        if(!isOpen) {
            batch.draw(door_right, open_x, 0, width, height);
            batch.draw(door_left, -open_x, 0, width, height);
        }

        //Закрытие SpriteBatch, удаление переменных объектов, которые больше не пригодятся
        batch.end();

            bird.dispose();
        close.dispose();
        smoke.dispose();
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
                    try {
                        sleep(1000);
                    } catch (Exception ignored) {

                    }
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
                    try {
                        sleep(30);
                    } catch (Exception ignored) {

                    }
                }
                BirdFly = false;
                bird.dispose();
            }
        };
        fly.start();
    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose () {
        smoke.dispose();
        camp.dispose();
        batch.dispose();
    }

}
