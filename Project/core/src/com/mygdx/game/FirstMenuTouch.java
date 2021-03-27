package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

public class FirstMenuTouch implements InputProcessor {
    MainGame game;
    FirstMenu firstMenu;

    public FirstMenuTouch(MainGame game, FirstMenu firstMenu){
        this.game = game;
        this.firstMenu = firstMenu;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (screenX >= 100 && screenX <= 600 && screenY >= Gdx.graphics.getHeight()/2-350 && screenY <= Gdx.graphics.getHeight()/2-100){
            firstMenu.close_touch = true;
        }
        if (screenX >= Gdx.graphics.getWidth()/2+300 && screenX <= Gdx.graphics.getWidth()/2+800 && screenY >= Gdx.graphics.getHeight()/2-350 && screenY <= Gdx.graphics.getHeight()/2-100){
            firstMenu.play_touch = true;
        }


        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        firstMenu.play_touch = false;
        firstMenu.close_touch = false;
        if (screenX >= 100 && screenX <= 600 && screenY >= Gdx.graphics.getHeight()/2-350 && screenY <= Gdx.graphics.getHeight()/2-100){
            Gdx.app.exit();
        }
        if (screenX >= Gdx.graphics.getWidth()/2+300 && screenX <= Gdx.graphics.getWidth()/2+800 && screenY >= Gdx.graphics.getHeight()/2-350 && screenY <= Gdx.graphics.getHeight()/2-100){
           firstMenu.DoorClose();

        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
