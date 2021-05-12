package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class WorkMenuTouch implements InputProcessor {
    com.mygdx.robotlegend.MainGame game;
    com.mygdx.robotlegend.WorkMenu workMenu;
    double x = 0;
    int y = 0;
    double scale = 0;
    int height;
public WorkMenuTouch(MainGame game, WorkMenu workMenu){
    this.game = game;
    this.workMenu = workMenu;
    height = workMenu.height;
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
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        x = workMenu.x;
        y = workMenu.y;
        scale = workMenu.scale;
        if(screenX >= 10 && screenX <= 160 && screenY <= 150 && screenY >= 0){
            if(workMenu.isOpen) {
                workMenu.DoorClose(1);
            }
        }
        if(screenX >= x && screenX <= (int)(x+200*scale) && screenY >= RY((int)(y+535*scale)) && screenY <= RY((int)(y+335*scale))){
            workMenu.which_select = 1;
        }
        if(screenX >= x && screenX <= (int)(x+200*scale) && screenY >= RY((int)(y+370*scale)) && screenY <= RY((int)(y+170*scale))){
            workMenu.which_select = 2;
        }
        if(screenX >= (int)(x-50*scale) && screenX <= (int)(x+150*scale) && screenY <= RY(y) && screenY >= RY((int)(y+200*scale))){
            workMenu.which_select = 3;
        }
        if(screenX >= (int)(x+100*scale) && screenX <= (int)(x+250*scale) && screenY <= RY(y) && screenY >= RY((int)(y+200*scale))){
            workMenu.which_select = 4;
        }
        if(screenX >= (int)(x-130*scale) && screenX <= (int)(x+50*scale) && screenY >= RY((int)(y+370*scale)) && screenY <= RY((int)(y+170*scale))){
            workMenu.which_select = 6;
        }
        if(screenX >= (int)(x+130*scale) && screenX <= (int)(x+330*scale) && screenY >= RY((int)(y+370*scale)) && screenY <= RY((int)(y+170*scale))) {
            workMenu.which_select = 5;
        }
        return false;
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
