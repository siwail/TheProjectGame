package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class MainGame extends Game {
    boolean isSound = true;
    Music music;

    @Override
    public void create() {
        setScreen(new FirstMenu(this));
        music = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
        music.setVolume(0.4f);
        music.setLooping(true);
        music.play();
    }
    public void setFirstMenu(){
        getScreen().dispose();
        setScreen(new FirstMenu(this));
    }
    public void setGameMenu(){
        getScreen().dispose();
        setScreen(new GameMenu(this));

    }
    public void Sound(){
        if(isSound == false){
            isSound = true;
            music.play();
        } else{
            isSound = false;
            music.pause();
        }
    }


}
