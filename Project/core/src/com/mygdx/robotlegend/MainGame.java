package com.mygdx.robotlegend;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;

import java.util.Random;
public class MainGame extends Game {
    Preferences safes;
    Music music;
    Music music_war;
    Music music_wave;
    Music music_main;
    Music music_rl;
    Random random;
    Sound click;
    Sound opened;
    Sound closed;
    Server server;
    Client client;
    RoboStructure robot = new RoboStructure(this);
    int music_type = 1;
    boolean music_play = true;

    int max_planet = 4;
    @Override
    public void create() {
        Gdx.graphics.setVSync(true);
        server = new Server();
        client = new Client();
        server.getKryo().register(ClientPacket.class);
        client.getKryo().register(ClientPacket.class);
        safes = Gdx.app.getPreferences("Save");
        click = Gdx.audio.newSound(Gdx.files.internal("Sound/click.wav"));
        opened = Gdx.audio.newSound(Gdx.files.internal("Sound/opened.wav"));
        closed = Gdx.audio.newSound(Gdx.files.internal("Sound/closed.wav"));
        random = new Random();
        robot.SetFirstChanges();
        robot.UpdateTextures();
        music_main = Gdx.audio.newMusic(Gdx.files.internal("Sound/wave.wav"));
        music_main.setVolume(0.3f);
        music_main.setLooping(true);
        music_rl = Gdx.audio.newMusic(Gdx.files.internal("Sound/sound.mp3"));
        music_rl.setVolume(0.3f);
        music_rl.setLooping(true);
        music_wave = Gdx.audio.newMusic(Gdx.files.internal("Sound/rl.mp3"));
        music_wave.setVolume(0.3f);
        music_wave.setLooping(true);
        if(random.nextBoolean())
        music_war = Gdx.audio.newMusic(Gdx.files.internal("Sound/music.mp3"));
        else music_war = Gdx.audio.newMusic(Gdx.files.internal("Sound/dont.mp3"));
        music_war.setVolume(0.1f);
        music_war.setLooping(true);
        music = Gdx.audio.newMusic(Gdx.files.internal("Sound/rl2.mp3"));
        music.setVolume(0.2f);
        music.setLooping(true);
        music.play();
        robot.level = random.nextInt(4)+1;
        setScreen(new FirstMenu(this));
    }
    public void MusicSwap(int type){
        if(music_type == 1) {
            music.stop();
        }
        if(music_type == 2) {
            Thread sound_thread = new Thread(){
                public void run() {
                    music_war.setVolume(0.15f);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    music_war.setVolume(0.05f);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    music_war.stop();
                    music_war.setVolume(0.1f);
                }
            };
            sound_thread.start();

        }
        if(music_type == 3) {
            Thread sound_thread = new Thread(){
                public void run() {
                    music_wave.setVolume(0.2f);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    music_wave.setVolume(0.1f);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    music_wave.stop();
                    music_wave.setVolume(0.3f);
                }
            };
            sound_thread.start();

        }
        if(music_type == 4) {
            music_main.stop();
        }
        if(music_type == 5) {
            music_rl.stop();
        }
        music_type = type;
        if(music_type == 1) {
            music.play();
        }
        if(music_type == 2) {
            Thread sound_thread = new Thread(){
                public void run() {
                    music_war.setVolume(0.05f);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    music_war.setVolume(0.08f);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    music_war.setVolume(0.1f);
                }
            };
            sound_thread.start();
            music_war.play();

        }
        if(music_type == 3) {
            Thread sound_thread = new Thread(){
                public void run() {
                    music_wave.setVolume(0.08f);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    music_wave.setVolume(0.15f);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    music_wave.setVolume(0.2f);
                }
            };
            sound_thread.start();
            music_wave.play();
        }
        if(music_type == 4) {
            music_main.play();
        }
        if(music_type == 5) {
            music_rl.play();
        }
    }
    public void MusicSet(){
        music_play = !music_play;
        if(!music_play) {
            if (music_type == 1) {
                music.pause();
            }
            if (music_type == 2) {
                music_war.pause();
            }
            if (music_type == 3) {
                music_wave.pause();
            }
            if(music_type == 4) {
                music_main.pause();
            }
            if(music_type == 5) {
                music_rl.pause();
            }
        }else{
            if (music_type == 1) {
                music.play();
            }
            if (music_type == 2) {
                music_war.play();
            }
            if (music_type == 3) {
                music_wave.play();
            }
            if(music_type == 4) {
                music_main.play();
            }
            if(music_type == 5) {
                music_rl.play();
            }
        }
    }
    public void setGamePlay(boolean online, boolean host){
        getScreen().dispose();
        setScreen(new GamePlay(this, online, host));
    }
    public void setGameMenu(){
        getScreen().dispose();

        setScreen(new GameMenu(this));
    }
    public void setWorkMenu(){
        getScreen().dispose();
        setScreen(new WorkMenu(this));
    }
    public void setMultiplayerMenu(){
        getScreen().dispose();
        setScreen(new MultiplayerMenu(this));
    }
}
