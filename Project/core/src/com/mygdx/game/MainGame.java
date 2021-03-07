package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MainGame extends Game {
    @Override
    public void create() {
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
    public void setGameMenu(){
        getScreen().dispose();
        setScreen(new GameMenu(this));

    }

}
