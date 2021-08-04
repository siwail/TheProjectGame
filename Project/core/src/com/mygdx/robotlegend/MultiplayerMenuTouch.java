package com.mygdx.robotlegend;
import com.badlogic.gdx.InputProcessor;

public class MultiplayerMenuTouch implements InputProcessor {
    com.mygdx.robotlegend.MainGame game;
    com.mygdx.robotlegend.MultiplayerMenu MultiplayerMenu;
    public MultiplayerMenuTouch(MainGame game, MultiplayerMenu MultiplayerMenu){
        this.game = game;
        this.MultiplayerMenu = MultiplayerMenu;
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
        if (screenX >= SX(850) && screenX <= SX(1050) && screenY >= SY(MultiplayerMenu.height/2-100) && screenY <= SY(MultiplayerMenu.height/2+100)) {
            MultiplayerMenu.right_touch = true;
        }
        if (screenX >= SX(150) && screenX <= SX(350) && screenY >= SY(MultiplayerMenu.height/2-100) && screenY <= SY(MultiplayerMenu.height/2+100)) {
            MultiplayerMenu.left_touch = true;
        }
        if (screenX >= SX(0) && screenX <= SX(200) && screenY >= SY(0) && screenY <= SY(200)) {
            MultiplayerMenu.close_touch = true;
        }
        if (screenX >= SX(MultiplayerMenu.width-600) && screenX <= SX(MultiplayerMenu.width-200) && screenY >= SY(MultiplayerMenu.height-300) && screenY <= SY(MultiplayerMenu.height-100)) {
            MultiplayerMenu.create_touch = true;
        }
        if (screenX >= SX(MultiplayerMenu.width-600) && screenX <= SX(MultiplayerMenu.width-200) && screenY >= SY(100) && screenY <= SY(300)) {
            MultiplayerMenu.connected_touch = true;
        }
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        MultiplayerMenu.right_touch = false;
        MultiplayerMenu.left_touch = false;
        MultiplayerMenu.close_touch = false;
        MultiplayerMenu.create_touch = false;
        MultiplayerMenu.connected_touch = false;
        if (screenX >= SX(850) && screenX <= SX(1050) && screenY >= SY(MultiplayerMenu.height/2-100) && screenY <= SY(MultiplayerMenu.height/2+100)) {
            MultiplayerMenu.NextRight();
        }
        if (screenX >= SX(150) && screenX <= SX(350) && screenY >= SY(MultiplayerMenu.height/2-100) && screenY <= SY(MultiplayerMenu.height/2+100)) {
            MultiplayerMenu.NextLeft();
        }
        if (screenX >= SX(0) && screenX <= SX(200) && screenY >= SY(0) && screenY <= SY(200)) {
            MultiplayerMenu.DoorClose(1);
        }
        if (screenX >= SX(MultiplayerMenu.width-600) && screenX <= SX(MultiplayerMenu.width-200) && screenY >= SY(MultiplayerMenu.height-300) && screenY <= SY(MultiplayerMenu.height-100)) {
            MultiplayerMenu.DoorClose(2);
        }
        if (screenX >= SX(MultiplayerMenu.width-600) && screenX <= SX(MultiplayerMenu.width-200) && screenY >= SY(100) && screenY <= SY(300)) {
            MultiplayerMenu.DoorClose(3);
        }
        return false;
    }
    public int SX(int x){
        return (int)((double)x*MultiplayerMenu.wpw);
    }
    public int SY(int y){
        return (int)((double)y*MultiplayerMenu.hph);
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
