package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class GameMenuTouch implements InputProcessor {
    com.mygdx.robotlegend.MainGame game;
    com.mygdx.robotlegend.GameMenu gameMenu;
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
        game.click.play(0.5f);
        if (screenX >= SX(50) && screenX <= SX(550) && screenY <= SY(gameMenu.height) && screenY >= SY(gameMenu.height-250)){
            gameMenu.close_touch = true;
        }
        if (screenX >= SX(620) && screenX <= SX(1020) && screenY <= SY(200) && screenY >= SY(0)){
            if(gameMenu.isOpen) {
                gameMenu.work_touch = true;
            }
        }
        if (screenX >= SX(gameMenu.width-550) && screenX <= SX(gameMenu.width-50) && screenY >= SY(gameMenu.height-250) && screenY <= SY(gameMenu.height)){
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
        if (screenX >= SX(50) && screenX <= SX(550) && screenY <= SY(gameMenu.height) && screenY >= SY(gameMenu.height-250)){
            Gdx.app.exit();
        }
        if (screenX >= SX(620) && screenX <= SX(1020) && screenY <= SY(200) && screenY >= SY(0)){
            if(gameMenu.isOpen) {
                gameMenu.DoorClose(1);
            }
        }
        if (screenX >= SX(gameMenu.width-550) && screenX <= SX(gameMenu.width-50) && screenY >= SY(gameMenu.height-250) && screenY <= SY(gameMenu.height)){
            if(gameMenu.isOpen) {
                gameMenu.DoorClose(2);
            }
        }
        return false;
    }
    public int SX(int x){
        return (int)((double)x*gameMenu.wpw);
    }
    public int SY(int y){
        return (int)((double)y*gameMenu.hph);
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
