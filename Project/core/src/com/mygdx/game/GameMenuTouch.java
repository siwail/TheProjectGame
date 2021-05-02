package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
public class GameMenuTouch implements InputProcessor {
    MainGame game;
    GameMenu gameMenu;
    public GameMenuTouch(MainGame game, GameMenu gameMenu){
        this.game = game;
        this.gameMenu = gameMenu;
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
        if (screenX >= 50 && screenX <= 550 && screenY <= Gdx.graphics.getHeight() && screenY >= Gdx.graphics.getHeight()-250){
            gameMenu.close_touch = true;
        }
        if (screenX >= 620 && screenX <= 1020 && screenY <= 200 && screenY >= 0){
            if(gameMenu.isOpen) {
                gameMenu.work_touch = true;
            }
        }
        if (screenX >= gameMenu.width-550 && screenX <= gameMenu.width-50 && screenY >= gameMenu.height-250 && screenY <= gameMenu.height){
            if(gameMenu.isOpen) {
                gameMenu.play_touch = true;
            }
        }
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        gameMenu.close_touch = false;
        gameMenu.work_touch = false;
        gameMenu.play_touch = false;
        if (screenX >= 50 && screenX <= 550 && screenY <= Gdx.graphics.getHeight() && screenY >= Gdx.graphics.getHeight()-250){
            Gdx.app.exit();
        }
        if (screenX >= 620 && screenX <= 1020 && screenY <= 200 && screenY >= 0){
            if(gameMenu.isOpen) {
                gameMenu.DoorClose(1);
            }
        }
        if (screenX >= gameMenu.width-550 && screenX <= gameMenu.width-50 && screenY >= gameMenu.height-250 && screenY <= gameMenu.height){
            if(gameMenu.isOpen) {
                gameMenu.DoorClose(2);
            }
        }
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override
    public boolean scrolled(float amountX, float amountY) { return false; }
}
