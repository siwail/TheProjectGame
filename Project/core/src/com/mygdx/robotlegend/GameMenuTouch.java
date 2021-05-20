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
        if (screenX >= SX(gameMenu.width/2-150) && screenX <= SX(gameMenu.width/2+150) && screenY >= SY(gameMenu.height-150) && screenY <= SY(gameMenu.height) && !gameMenu.istutorial){

            if(gameMenu.isOpen) {
                gameMenu.tutorial_touch = true;
            }
        }
        if(gameMenu.istutorial && gameMenu.tutorial_scene<=gameMenu.max_tutorial_scene && !gameMenu.resize_scene){
            gameMenu.plus_height = 20;
            gameMenu.plus_width = 20;
        }
        if (screenX >= SX(450) && screenX <= SX(600) && screenY <= SY(gameMenu.height-435) && screenY >= SY(gameMenu.height-635) && !gameMenu.istutorial) {
            gameMenu.right_touched = true;
        }
        if (screenX >= SX(100) && screenX <= SX(250) && screenY <= SY(gameMenu.height-435) && screenY >= SY(gameMenu.height-635) && !gameMenu.istutorial) {
            gameMenu.left_touched = true;
        }
            return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        gameMenu.right_touched = false;
        gameMenu.left_touched = false;
        gameMenu.close_touch = false;
        gameMenu.work_touch = false;
        gameMenu.play_touch = false;
        gameMenu.tutorial_touch = false;
        if(!gameMenu.istutorial) {
            if (screenX >= SX(50) && screenX <= SX(550) && screenY <= SY(gameMenu.height) && screenY >= SY(gameMenu.height - 250)) {
                Gdx.app.exit();
            }
            if (screenX >= SX(620) && screenX <= SX(1020) && screenY <= SY(200) && screenY >= SY(0)) {
                if (gameMenu.isOpen) {
                    gameMenu.DoorClose(1);
                }
            }
            if (screenX >= SX(gameMenu.width - 550) && screenX <= SX(gameMenu.width - 50) && screenY >= SY(gameMenu.height - 250) && screenY <= SY(gameMenu.height)) {
                if (gameMenu.isOpen) {
                    gameMenu.DoorClose(2);
                }
            }
            if (screenX >= SX(1020) && screenX <= SX(1120) && screenY >= SY(0) && screenY <= SY(100)) {
                game.MusicSet();
            }
            if (screenX >= SX(gameMenu.width / 2 - 150) && screenX <= SX(gameMenu.width / 2 + 150) && screenY >= SY(gameMenu.height - 150) && screenY <= SY(gameMenu.height)) {
                if (gameMenu.isOpen) {
                    gameMenu.SceneTutorial();
                }
            }
        }
        if (screenX >= SX(450) && screenX <= SX(600) && screenY <= SY(gameMenu.height-435) && screenY >= SY(gameMenu.height-635) && !gameMenu.istutorial) {
            gameMenu.NextRightSkin();
        }
        if (screenX >= SX(100) && screenX <= SX(250) && screenY <= SY(gameMenu.height-435) && screenY >= SY(gameMenu.height-635) && !gameMenu.istutorial) {
            gameMenu.NextLeftSkin();
        }
        if(gameMenu.istutorial && gameMenu.tutorial_scene<=gameMenu.max_tutorial_scene && !gameMenu.resize_scene){
            gameMenu.SceneTutorial();
            gameMenu.plus_height = 0;
            gameMenu.plus_width = 0;
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
