package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;

import java.util.Random;
public class MainGame extends Game {
    Random random = new Random();
    RoboStructure robot = new RoboStructure();
    @Override
    public void create() {
        robot.UpdateTextures();
        Music music = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
        music.setVolume(0.2f);
        music.setLooping(true);
        music.play();
        setScreen(new FirstMenu(this));
    }
    public void setFirstMenu(){
        getScreen().dispose();
        setScreen(new FirstMenu(this));
    }
    public void setGamePlay(){
        getScreen().dispose();
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
