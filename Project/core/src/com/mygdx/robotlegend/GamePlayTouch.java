package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.esotericsoftware.minlog.Log;

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
        /*if(screenX >= SX(50*gamePlay.scale_inteface) && screenX <= SX(200*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-275*gamePlay.scale_inteface) && screenY < SY(gamePlay.height-125)){
            gamePlay.up_touch = true;
        }
        if(screenX >= SX(50*gamePlay.scale_inteface) && screenX <= SX(200*gamePlay.scale_inteface) && screenY > SY(gamePlay.height-125*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            gamePlay.down_touch = true;
        }
        if(screenX >= SX(200*gamePlay.scale_inteface) && screenX <= SX(350*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-150*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            gamePlay.redir_touch = true;
        }*/





        if(screenX >= SX(gamePlay.width-400*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-250*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-150*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)){
            if(game.robot.power_small == 1) {
                gamePlay.saw_touch = true;
            }
            if(game.robot.power_small == 2) {
                gamePlay.jump_touch = true;
            }
            if(game.robot.power_small == 3) {
                gamePlay.jump_touch = true;
            }
            if(game.robot.power_small == 4) {
                gamePlay.pull_touch = true;
            }
            if(game.robot.power_small == 5) {
                gamePlay.plasma_touch = true;
            }

        }
        if(screenX >= SX(gamePlay.width-400*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-250*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-300*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height-150*gamePlay.scale_inteface)){
            if(game.robot.power_large == 1) {
                gamePlay.ball_touch = true;
            }
            if(game.robot.power_large == 2) {
                gamePlay.jetpack_touch = true;
            }
            if(game.robot.power_large == 3) {
                gamePlay.jetpack_touch = true;
            }
            if(game.robot.power_large == 4) {
                gamePlay.circle_touch = true;
            }
            if(game.robot.power_large == 5) {
                gamePlay.ball_touch = true;
            }


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
        gamePlay.plasma_touch = false;
        gamePlay.ball_touch = false;
        gamePlay.jetpack_touch = false;
        gamePlay.saw_touch = false;
        gamePlay.pull_touch = false;
        gamePlay.circle_touch = false;
        if(screenX >= SX(0*gamePlay.scale_inteface) && screenX <= SX(500*gamePlay.scale_inteface) && screenY > SY(gamePlay.height-500*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height-0*gamePlay.scale_inteface)){
            gamePlay.needMove = true;
        }
        if (!gamePlay.robotboom && gamePlay.win != 1){
            if (screenX >= SX(gamePlay.width - 275 * gamePlay.scale_inteface) && screenX <= SX(gamePlay.width - 25 * gamePlay.scale_inteface) && screenY >= SY(gamePlay.height - 250 * gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)) {
                gamePlay.Fire();
            }
       /* if (screenX >= SX(50 * gamePlay.scale_inteface) && screenX <= SX(200 * gamePlay.scale_inteface) && screenY >= SY(gamePlay.height - 275 * gamePlay.scale_inteface) && screenY < SY(gamePlay.height - 125)) {
            gamePlay.Up();
        }
        if (screenX >= SX(50 * gamePlay.scale_inteface) && screenX <= SX(200 * gamePlay.scale_inteface) && screenY > SY(gamePlay.height - 125 * gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)) {
            gamePlay.Down();
        }
        if (screenX >= SX(200 * gamePlay.scale_inteface) && screenX <= SX(350 * gamePlay.scale_inteface) && screenY >= SY(gamePlay.height - 150 * gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)) {
            gamePlay.Redir();
        }*/
        if (screenX >= SX(gamePlay.width - 400 * gamePlay.scale_inteface) && screenX <= SX(gamePlay.width - 250 * gamePlay.scale_inteface) && screenY >= SY(gamePlay.height - 150 * gamePlay.scale_inteface) && screenY <= SY(gamePlay.height)) {
            gamePlay.SmallPower();
        }
        if(screenX >= SX(gamePlay.width-400*gamePlay.scale_inteface) && screenX <= SX(gamePlay.width-250*gamePlay.scale_inteface) && screenY >= SY(gamePlay.height-300*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height-150*gamePlay.scale_inteface)){
            gamePlay.LargePower();
        }
        gamePlay.move_control = true;
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
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if(screenX >= SX(0*gamePlay.scale_inteface) && screenX <= SX(470*gamePlay.scale_inteface) && screenY > SY(gamePlay.height-470*gamePlay.scale_inteface) && screenY <= SY(gamePlay.height-0*gamePlay.scale_inteface)){
            gamePlay.move_control = false;
            gamePlay.control_pos_y = (int)((gamePlay.height-(int)(screenY/gamePlay.hph))/gamePlay.scale_inteface);
            gamePlay.control_pos_x = (int)(screenX/gamePlay.wpw/gamePlay.scale_inteface);
        }
        return false; }
    @Override
    public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override
    public boolean scrolled(float amountX, float amountY) {



        return false; }
}
