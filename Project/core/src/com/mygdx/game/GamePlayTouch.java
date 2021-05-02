package com.mygdx.game;
import com.badlogic.gdx.InputProcessor;
public class GamePlayTouch implements InputProcessor {
    MainGame game;
    GamePlay gamePlay;
    public GamePlayTouch(MainGame game, GamePlay gamePlay){
        this.game = game;
        this.gamePlay = gamePlay;
    }
    @Override
    public boolean keyDown(int keycode) { return false; }
    @Override
    public boolean keyUp(int keycode) { return false; }
    @Override
    public boolean keyTyped(char character) { return false; }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(screenX >= gamePlay.width-275*gamePlay.scale_inteface && screenX <= gamePlay.width-25*gamePlay.scale_inteface && screenY >= gamePlay.height-250*gamePlay.scale_inteface && screenY <= gamePlay.height){
            gamePlay.fire_touch = true;
        }
        if(screenX >= 50*gamePlay.scale_inteface && screenX <= 200*gamePlay.scale_inteface && screenY >= gamePlay.height-275*gamePlay.scale_inteface && screenY < gamePlay.height-125){
            gamePlay.up_touch = true;
        }
        if(screenX >= 50*gamePlay.scale_inteface && screenX <= 200*gamePlay.scale_inteface && screenY > gamePlay.height-125*gamePlay.scale_inteface && screenY <= gamePlay.height){
            gamePlay.down_touch = true;
        }
        if(screenX >= 200*gamePlay.scale_inteface && screenX <= 350*gamePlay.scale_inteface && screenY >= gamePlay.height-150*gamePlay.scale_inteface && screenY <= gamePlay.height){
            gamePlay.redir_touch = true;
        }
        if(screenX >= gamePlay.width-400*gamePlay.scale_inteface && screenX <= gamePlay.width-250*gamePlay.scale_inteface && screenY >= gamePlay.height-150*gamePlay.scale_inteface && screenY <= gamePlay.height){
            gamePlay.jump_touch = true;
        }
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        gamePlay.up_touch = false;
        gamePlay.down_touch = false;
        gamePlay.redir_touch = false;
        gamePlay.fire_touch = false;
        gamePlay.jump_touch = false;
        if(screenX >= gamePlay.width-275*gamePlay.scale_inteface && screenX <= gamePlay.width-25*gamePlay.scale_inteface && screenY >= gamePlay.height-250*gamePlay.scale_inteface && screenY <= gamePlay.height){
            gamePlay.Fire();
        }
        if(screenX >= 50*gamePlay.scale_inteface && screenX <= 200*gamePlay.scale_inteface && screenY >= gamePlay.height-275*gamePlay.scale_inteface && screenY < gamePlay.height-125){
            gamePlay.Up();
        }
        if(screenX >= 50*gamePlay.scale_inteface && screenX <= 200*gamePlay.scale_inteface && screenY > gamePlay.height-125*gamePlay.scale_inteface && screenY <= gamePlay.height){
            gamePlay.Down();
        }
        if(screenX >= 200*gamePlay.scale_inteface && screenX <= 350*gamePlay.scale_inteface && screenY >= gamePlay.height-150*gamePlay.scale_inteface && screenY <= gamePlay.height){
            gamePlay.Redir();
        }
        if(screenX >= gamePlay.width-400*gamePlay.scale_inteface && screenX <= gamePlay.width-250*gamePlay.scale_inteface && screenY >= gamePlay.height-150*gamePlay.scale_inteface && screenY <= gamePlay.height){
            gamePlay.Jump();
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
