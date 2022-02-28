package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
public class GamePlayTouch implements InputProcessor {
    com.mygdx.robotlegend.MainGame game;
    com.mygdx.robotlegend.GamePlay gamePlay;
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
        game.click.play(0.1f);
        if(screenX >= SX(gamePlay.width-275*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-25*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-250*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            gamePlay.fire_touch = true;
        }
        if(screenX >= SX(50*gamePlay.scale_inteface) && screenX <= SX(200*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-275*gamePlay.scale_inteface) && screenY < SY(gamePlay.height-125)){
            gamePlay.up_touch = true;
        }
        if(screenX >= SX(50*gamePlay.scale_inteface) && screenX <= SX(200*gamePlay.scale_inteface) && screenY > SY(gamePlay.height-125*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            gamePlay.down_touch = true;
        }
        if(screenX >= SX(200*gamePlay.scale_inteface) && screenX <= SX(350*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-150*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            gamePlay.redir_touch = true;
        }
        if(screenX >= SX(gamePlay.width-400*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-250*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-150*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            gamePlay.jump_touch = true;
        }
        if(screenX >= SX(gamePlay.width-600*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-450*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-300*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height-150*gamePlay.scale_inteface)){
            gamePlay.saw_touch = true;
        }
        if(screenX >= SX(gamePlay.width-600*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-450*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-150*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            gamePlay.jetpack_touch = true;
        }
        if(screenX >= SX(gamePlay.width-800*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-650*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-150*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            gamePlay.circle_touch = true;
        }
        if(screenX >= SX(gamePlay.width-400*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-250*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-300*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height-150*gamePlay.scale_inteface)){
            gamePlay.ball_touch = true;
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
        gamePlay.ball_touch = false;
        gamePlay.jetpack_touch = false;
        gamePlay.saw_touch = false;
        gamePlay.circle_touch = false;
        if (!gamePlay.robotboom && gamePlay.win != 1){
            if (screenX >= SX(gamePlay.width - 275 * gamePlay.scale_inteface) && screenX <= SX(gamePlay.width - 25 * gamePlay.scale_inteface) && screenY >= SY(gamePlay.height - 250 * gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)) {
                gamePlay.Fire();
            }
        if (screenX >= SX(50 * gamePlay.scale_inteface) && screenX <= SX(200 * gamePlay.scale_inteface) && screenY >= SY(gamePlay.height - 275 * gamePlay.scale_inteface) && screenY < SY(gamePlay.height - 125)) {
            gamePlay.Up();
        }
        if (screenX >= SX(50 * gamePlay.scale_inteface) && screenX <= SX(200 * gamePlay.scale_inteface) && screenY > SY(gamePlay.height - 125 * gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)) {
            gamePlay.Down();
        }
        if (screenX >= SX(200 * gamePlay.scale_inteface) && screenX <= SX(350 * gamePlay.scale_inteface) && screenY >= SY(gamePlay.height - 150 * gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)) {
            gamePlay.Redir();
        }
        if (screenX >= SX(gamePlay.width - 400 * gamePlay.scale_inteface) && screenX <= SX(gamePlay.width - 250 * gamePlay.scale_inteface) && screenY >= SY(gamePlay.height - 150 * gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)) {
            gamePlay.Jump();
        }
        if(screenX >= SX(gamePlay.width-600*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-450*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-300*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height-150*gamePlay.scale_inteface)){
            gamePlay.Saw();
        }
        if(screenX >= SX(gamePlay.width-600*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-450*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-150*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            gamePlay.Jetpack();
        }
        if(screenX >= SX(gamePlay.width-800*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-650*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-150*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            gamePlay.Circle();
        }

        if(screenX >= SX(gamePlay.width-400*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-250*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-300*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height-150*gamePlay.scale_inteface)){
            gamePlay.Ball();
        }
    }
        return false;
    }
    public int SX(double x){
        return (int)(x*gamePlay.wpw);
    }
    public int SY(double y){
        return (int)(y*gamePlay.hph);
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }
    @Override
    public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override
    public boolean scrolled(float amountX, float amountY) { return false; }
}
