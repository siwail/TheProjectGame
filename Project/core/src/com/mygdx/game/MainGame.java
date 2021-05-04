package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import java.util.Random;
public class MainGame extends Game {
    Random random;
    RoboStructure robot = new RoboStructure(this);
    @Override
    public void create() {
        random = new Random();
        robot.SetFirstChanges();
        robot.UpdateTextures();
        Music music = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
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
