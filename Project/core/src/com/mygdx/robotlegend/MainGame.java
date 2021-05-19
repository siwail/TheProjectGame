package com.mygdx.robotlegend;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.Random;
public class MainGame extends Game {
    Preferences safes;
    Music music;
    Music music_war;
    Random random;
    Sound click;
    Sound opened;
    Sound closed;
    RoboStructure robot = new RoboStructure(this);
    boolean war = false;
    boolean music_play = true;
    @Override
    public void create() {
        safes = Gdx.app.getPreferences("Save");
        click = Gdx.audio.newSound(Gdx.files.internal("Sound/click.wav"));
        opened = Gdx.audio.newSound(Gdx.files.internal("Sound/opened.wav"));
        closed = Gdx.audio.newSound(Gdx.files.internal("Sound/closed.wav"));
        random = new Random();
        robot.SetFirstChanges();
        robot.UpdateTextures();
        music_war = Gdx.audio.newMusic(Gdx.files.internal("Sound/music.mp3"));
        music_war.setVolume(0.1f);
        music_war.setLooping(true);
        music = Gdx.audio.newMusic(Gdx.files.internal("Sound/sound.mp3"));
        music.setVolume(0.2f);
        music.setLooping(true);
        music.play();
        setScreen(new FirstMenu(this));
    }
    public void MusicSwap(){
        if(!war){
            war = true;
            if(music_play) {
                music.stop();
                music_war.play();
            }
        }else{
            war = false;
            if(music_play) {
                music_war.stop();
                music.play();
            }
        }
    }
    public void MusicSet(){
        if(music_play){
            music_play = false;
            music.pause();
        }else{
            music_play = true;
            music.play();
        }
    }
    public void setGamePlay(){
        getScreen().dispose();
        robot.level = random.nextInt(4)+1;
        setScreen(new GamePlay(this));
    }
    public void setGameMenu(){
        getScreen().dispose();
        setScreen(new GameMenu(this));
    }
    public void setWorkMenu(){
        getScreen().dispose();
        setScreen(new WorkMenu(this));
    }
}
