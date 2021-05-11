package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;

public class FirstMenuTouch implements InputProcessor {
    MainGame game;
    FirstMenu firstMenu;


    public FirstMenuTouch(MainGame game, FirstMenu firstMenu){
        this.game = game;
        this.firstMenu = firstMenu;
    }
    @Override
    public boolean keyDown(int keycode) { return false; }
    @Override
    public boolean keyUp(int keycode) { return false; }
    @Override
    public boolean keyTyped(char character) { return false; }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.click.play(0.5f);
        if (screenX >= (int)(100.0*firstMenu.wpw) && screenX <= (int)(600*firstMenu.wpw) && screenY >= (int)((Gdx.graphics.getHeight()/2-350)*firstMenu.hph) && screenY <= (int)((Gdx.graphics.getHeight()/2-100)*firstMenu.hph)){
            firstMenu.close_touch = true;

        }
        if (screenX >= (int)((Gdx.graphics.getWidth()/2+300)*firstMenu.wpw) && screenX <= (int)((Gdx.graphics.getWidth()/2+800)*firstMenu.wpw) && screenY >= (int)((Gdx.graphics.getHeight()/2-350)*firstMenu.hph)  && screenY <= (int)((Gdx.graphics.getHeight()/2-100)*firstMenu.hph) ){
            firstMenu.play_touch = true;

        }
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        firstMenu.play_touch = false;
        firstMenu.close_touch = false;
        if (screenX >= (int)(100.0*firstMenu.wpw) && screenX <= (int)(600*firstMenu.wpw) && screenY >= (int)((Gdx.graphics.getHeight()/2-350)*firstMenu.hph) && screenY <= (int)((Gdx.graphics.getHeight()/2-100)*firstMenu.hph)){
            Gdx.app.exit();
        }
        if (screenX >= (int)((Gdx.graphics.getWidth()/2+300)*firstMenu.wpw) && screenX <= (int)((Gdx.graphics.getWidth()/2+800)*firstMenu.wpw) && screenY >= (int)((Gdx.graphics.getHeight()/2-350)*firstMenu.hph)  && screenY <= (int)((Gdx.graphics.getHeight()/2-100)*firstMenu.hph) ){
            firstMenu.DoorClose(1);
        }
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }
    @Override
    public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override
    public boolean scrolled(float amountX, float amountY) { return false; }
}
