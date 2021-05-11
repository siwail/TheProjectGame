package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.Random;
public class MainGame extends Game {
    Random random;
    Sound click;
    Sound opened;
    Sound closed;
    RoboStructure robot = new RoboStructure(this);
    @Override
    public void create() {
        click = Gdx.audio.newSound(Gdx.files.internal("Sound/click.wav"));
        opened = Gdx.audio.newSound(Gdx.files.internal("Sound/opened.wav"));
        closed = Gdx.audio.newSound(Gdx.files.internal("Sound/closed.wav"));
        random = new Random();
        robot.SetFirstChanges();
        robot.UpdateTextures();
        Music music = Gdx.audio.newMusic(Gdx.files.internal("Sound/sound.mp3"));
        music.setVolume(0.2f);
        music.setLooping(true);
        music.play();
        setScreen(new FirstMenu(this));
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
