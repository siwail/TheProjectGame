package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class FirstMenuTouch implements InputProcessor {
    MainGame game;
    com.mygdx.robotlegend.FirstMenu firstMenu;


    public FirstMenuTouch(MainGame game, FirstMenu firstMenu){
        this.game = game;
        this.firstMenu = firstMenu;
    }
    @Override
    public boolean keyDown(int keycode) { return false; }
    @Override
    public boolean keyUp(int keycode) { return false; }
    @Override
    public boolean keyTyped(char character) { return false; }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.click.play(0.5f);
        if (screenX >= SX(100) && screenX <= SX(600) && screenY >= SY(firstMenu.height/2-350) && screenY <= SY(firstMenu.height/2-100)){
            firstMenu.close_touch = true;
        }
        if (screenX >= SX(firstMenu.width/2+300) && screenX <= SX(firstMenu.width/2+800) && screenY >= SY(firstMenu.height/2-350)  && screenY <= SY(firstMenu.height/2-100)){
            firstMenu.play_touch = true;
        }
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        firstMenu.play_touch = false;
        firstMenu.close_touch = false;
        if(firstMenu.can_touch) {
            if (screenX >= SX(100) && screenX <= SX(600) && screenY >= SY(firstMenu.height / 2 - 350) && screenY <= SY(firstMenu.height / 2 - 100)) {
                firstMenu.close_touch = true;
                Gdx.app.exit();
            }
            if (screenX >= SX(firstMenu.width / 2 + 300) && screenX <= SX(firstMenu.width / 2 + 800) && screenY >= SY(firstMenu.height / 2 - 350) && screenY <= SY(firstMenu.height / 2 - 100)) {
                firstMenu.play_touch = true;
                firstMenu.DoorClose(1);
            }
            if (screenX >= SX(600) && screenX <= SX(firstMenu.width / 2 + 300) && screenY >= SY(firstMenu.height / 2 - 350) && screenY <= SY(firstMenu.height / 2 - 100)) {
                game.autoplay_enabled = !game.autoplay_enabled;
                if(game.autoplay_enabled){
                    firstMenu.check.play(1.0f);
                }else{
                    firstMenu.check.play(0.3f);
                }
            }
        }
        return false;
    }
    public int SX(int x){
        return (int)((double)x*firstMenu.wpw);
    }
    public int SY(int y){
        return (int)((double)y*firstMenu.hph);
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }
    @Override
    public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override
    public boolean scrolled(float amountX, float amountY) { return false; }
}
