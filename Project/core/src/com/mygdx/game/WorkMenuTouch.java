package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;

public class WorkMenuTouch implements InputProcessor {
    MainGame game;
    WorkMenu workMenu;

public WorkMenuTouch(MainGame game, WorkMenu workMenu){
    this.game = game;
    this.workMenu = workMenu;
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

        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(screenX >= 250 && screenX <= 400 && screenY <= 145 && screenY >= -5){
            if(workMenu.isOpen) {
                workMenu.DoorClose(1);
            }
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
