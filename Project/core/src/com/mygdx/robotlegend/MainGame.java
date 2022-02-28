package com.mygdx.robotlegend;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;

import java.util.Random;
public class MainGame extends Game {
    Preferences safes;
    Music music;
    Random random;
    Sound click;
    Sound opened;
    Sound closed;
    Server server;
    Client client;
    FreeTypeFontGenerator generator;
    RoboStructure robot = new RoboStructure(this);
    boolean autoplay_enabled = false;
    int max_planet = 4;
    @Override
    public void create() {
        generator = new FreeTypeFontGenerator(Gdx.files.internal("Decoration/main_font.ttf"));
        Gdx.graphics.setVSync(true);
        server = new Server();
        client = new Client();
        server.getKryo().register(ClientPacket.class);
        client.getKryo().register(ClientPacket.class);
        safes = Gdx.app.getPreferences("Save");
        click = Gdx.audio.newSound(Gdx.files.internal("Sound/click.wav"));
        opened = Gdx.audio.newSound(Gdx.files.internal("Sound/took_1.wav"));
        closed = Gdx.audio.newSound(Gdx.files.internal("Sound/took_3.wav"));
        random = new Random();
        robot.SetFirstChanges();
        robot.UpdateTextures();
        robot.level = random.nextInt(4)+1;
        setScreen(new FirstMenu(this));
    }
    public void MusicSwap(int type){
        if(type != 1) {
        if(music.isPlaying()){
            music.stop();
        }
            music.dispose();
        }
        music = Gdx.audio.newMusic(Gdx.files.internal("Sound/music_" + type + ".mp3"));
        music.setVolume(0.3f);
        music.setLooping(true);
        music.play();
    }
    public void MusicSet(){
        if(music.isPlaying()){
            music.pause();
        }else{
            music.play();
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
