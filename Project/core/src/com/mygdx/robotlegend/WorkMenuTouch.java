package com.mygdx.robotlegend;
import com.badlogic.gdx.InputProcessor;

public class WorkMenuTouch implements InputProcessor {
    com.mygdx.robotlegend.MainGame game;
    com.mygdx.robotlegend.WorkMenu workMenu;
    double x = 0;
    int y = 0;
    double scale = 0;
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
        game.click.play(0.5f);
        if(screenX >= SX(workMenu.width-500) && screenX <= SX(workMenu.width-100) && screenY >= SY(workMenu.height-175) && screenY <= SY(workMenu.height)){
            workMenu.upgrade_touch = true;
        }
        if(screenX >= SX(10) && screenX <= SX(160) && screenY <= SY(150) && screenY >= 0){
            workMenu.exit_touch = true;
        }
        if(screenX >= SX(workMenu.width-700) && screenX <= SX(workMenu.width-600) && screenY <= SY(100) && screenY >= 0){
            workMenu.exit_touch = true;
        }
        if(screenX >= SX(workMenu.width-550) && screenX <= SX(workMenu.width-430) && screenY >= SY(RY(570)) && screenY <= SY(RY(470))){
            workMenu.left_touch = true;
        }
        if(screenX >= SX(workMenu.width-150) && screenX <= SX(workMenu.width-30) && screenY >= SY(RY(570)) && screenY <= SY(RY(470))){
            workMenu.right_touch = true;
        }
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        x = workMenu.x;
        y = workMenu.y;
        scale = workMenu.scale;
        workMenu.exit_touch = false;
        workMenu.upgrade_touch = false;
        workMenu.right_touch = false;
        workMenu.left_touch = false;
        if(screenX >= SX(10) && screenX <= SX(160) && screenY <= SY(150) && screenY >= 0){
            if(workMenu.isOpen) {
                workMenu.DoorClose(1);
            }
        }
        if(workMenu.can_swap) {
            if(workMenu.which_select!=0) {
                if (screenX >= SX(workMenu.width - 700) && screenX <= SX(workMenu.width - 600) && screenY <= SY(100) && screenY >= 0) {
                    workMenu.which_select_will = 0;
                    workMenu.check_model();
                }
            }
            if(workMenu.which_select!=1) {
                if (screenX >= SX((int) x) && screenX <= SX((int) (x + 200 * scale)) && screenY >= SY(RY((int) (y + 535 * scale))) && screenY <= SY(RY((int) (y + 335 * scale)))) {
                    workMenu.which_select_will = 1;
                    workMenu.check_model();
                }
            }
            if(workMenu.which_select!=2) {
                if (screenX >= SX((int) x) && screenX <= SX((int) (x + 200 * scale)) && screenY >= SY(RY((int) (y + 370 * scale))) && screenY <= SY(RY((int) (y + 170 * scale)))) {
                    workMenu.which_select_will = 2;
                    workMenu.check_model();
                }
            }
            if(workMenu.which_select!=3) {
                if (screenX >= SX((int) (x - 50 * scale)) && screenX <= SX((int) (x + 150 * scale)) && screenY <= SY(RY(y)) && screenY >= SY(RY((int) (y + 200 * scale)))) {
                    workMenu.which_select_will = 3;
                    workMenu.check_model();
                }
            }
            if(workMenu.which_select!=4) {
                if (screenX >= SX((int) (x + 100 * scale)) && screenX <= SX((int) (x + 250 * scale)) && screenY <= SY(RY(y)) && screenY >= SY(RY((int) (y + 200 * scale)))) {
                    workMenu.which_select_will = 4;
                    workMenu.check_model();
                }
            }
            if(workMenu.which_select!=6) {
                if (screenX >= SX((int) (x - 130 * scale)) && screenX <= SX((int) (x + 50 * scale)) && screenY >= SY(RY((int) (y + 370 * scale))) && screenY <= SY(RY((int) (y + 170 * scale)))) {
                    workMenu.which_select_will = 6;
                    workMenu.check_model();
                }
            }
            if(workMenu.which_select!=5) {
                if (screenX >= SX((int) (x + 130 * scale)) && screenX <= SX((int) (x + 330 * scale)) && screenY >= SY(RY((int) (y + 370 * scale))) && screenY <= SY(RY((int) (y + 170 * scale)))) {
                    workMenu.which_select_will = 5;
                    workMenu.check_model();
                }
            }
            if (screenX >= SX(workMenu.width - 500) && screenX <= SX(workMenu.width - 100) && screenY >= SY(workMenu.height - 175) && screenY <= SY(workMenu.height)) {
                workMenu.upgrade();
            }
            if(screenX >= SX(workMenu.width-550) && screenX <= SX(workMenu.width-430) && screenY >= SY(RY(570)) && screenY <= SY(RY(470))){
                workMenu.NextLeftPart(workMenu.which_select);
            }
            if(screenX >= SX(workMenu.width-150) && screenX <= SX(workMenu.width-30) && screenY >= SY(RY(570)) && screenY <= SY(RY(470))){
                workMenu.NextRightPart(workMenu.which_select);
            }

        }
        return false;
    }
    public int SX(int x){
        return (int)((double)x*workMenu.wpw);
    }
    public int SY(int y){
        return (int)((double)y*workMenu.hph);
    }
    public int RY(int y){
        return workMenu.height-y;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }
    @Override
    public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override
    public boolean scrolled(float amountX, float amountY) { return false; }
}
