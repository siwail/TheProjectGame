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
        if (screenX >= SX(50) && screenX <= SX(550) && screenY <= SY(gameMenu.height) && screenY >= SY(gameMenu.height-250) && !gameMenu.box_dark_back){
            gameMenu.close_touch = true;
        }
        if (screenX >= SX(620) && screenX <= SX(1020) && screenY <= SY(200) && screenY >= SY(0) && !gameMenu.box_dark_back){
            if(gameMenu.isOpen) {
                gameMenu.work_touch = true;
            }
        }
        if (screenX >= SX(gameMenu.width-550) && screenX <= SX(gameMenu.width-50) && screenY >= SY(gameMenu.height-250) && screenY <= SY(gameMenu.height) && !gameMenu.box_dark_back){
            if(gameMenu.isOpen) {
                gameMenu.play_touch = true;
            }
        }
        if (screenX >= SX(gameMenu.width / 2 - 300) && screenX <= SX(gameMenu.width / 2) && screenY >= SY(gameMenu.height - 150) && screenY <= SY(gameMenu.height) && !gameMenu.box_dark_back) {
            if(gameMenu.isOpen) {
                gameMenu.tutorial_touch = true;
            }
        }
        if (screenX >= SX(gameMenu.width/2) && screenX <= SX(gameMenu.width/2+300) && screenY >= SY(gameMenu.height-160) && screenY <= SY(gameMenu.height-10) && !gameMenu.istutorial && !gameMenu.box_dark_back){
            if(gameMenu.isOpen) {
                gameMenu.multiplayer_touch = true;
            }
        }
        if(gameMenu.istutorial && gameMenu.tutorial_scene<=gameMenu.max_tutorial_scene && !gameMenu.resize_scene && !gameMenu.box_dark_back){
            if(screenX >= SX(50) && screenX <= SX(450) && screenY >= SY(gameMenu.height-650) && screenY <= SY(gameMenu.height-150)){
                gameMenu.icon_1_touch = true;
            }
            if(screenX >= SX(450) && screenX <= SX(850) && screenY >= SY(gameMenu.height-650) && screenY <= SY(gameMenu.height-150)){
                gameMenu.icon_2_touch = true;
            }
            if(screenX >= SX(850) && screenX <= SX(1250) && screenY >= SY(gameMenu.height-650) && screenY <= SY(gameMenu.height-150)){
                gameMenu.icon_3_touch = true;
            }
            if(screenX >= SX(1250) && screenX <= SX(1650) && screenY >= SY(gameMenu.height-650) && screenY <= SY(gameMenu.height-150)){
                gameMenu.icon_4_touch = true;
            }
        }

        if (screenX >= SX(450) && screenX <= SX(600) && screenY <= SY(gameMenu.height-435) && screenY >= SY(gameMenu.height-635) && !gameMenu.istutorial && !gameMenu.box_dark_back) {
            gameMenu.right_touched = true;
        }
        if (screenX >= SX(100) && screenX <= SX(250) && screenY <= SY(gameMenu.height-435) && screenY >= SY(gameMenu.height-635) && !gameMenu.istutorial && !gameMenu.box_dark_back) {
            gameMenu.left_touched = true;
        }
        if (screenX >= SX(gameMenu.width-160) && screenX <= SX(gameMenu.width-50) && screenY <= SY(120) && screenY >= SY(0) && !gameMenu.istutorial && !gameMenu.box_dark_back) {
            gameMenu.button_ship_touched = true;
        }
        if(game.robot.level == 3 || game.robot.level == 4 && !gameMenu.search_planet) {
            if (screenX >= SX(gameMenu.birdx) && screenX <= SX(gameMenu.birdx+250) && screenY >= SY(gameMenu.height-gameMenu.birdy-250) && screenY <= SY(gameMenu.height-gameMenu.birdy) && !gameMenu.istutorial && !gameMenu.box_dark_back) {
                gameMenu.Hush();
            }
        }
        if(!gameMenu.istutorial && !gameMenu.resize_scene && !gameMenu.search_planet && !gameMenu.isTv && !gameMenu.box_dark_back) {
            if(screenX >= SX(gameMenu.width-625) && screenX <= SX(gameMenu.width-415) && screenY <= SY(gameMenu.height-200) && screenY >= SY(gameMenu.height-440)){
                gameMenu.box_min_state = 0.1f;
            }
        }
            return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        gameMenu.button_ship_touched = false;
        gameMenu.right_touched = false;
        gameMenu.left_touched = false;
        gameMenu.close_touch = false;
        gameMenu.work_touch = false;
        gameMenu.play_touch = false;
        gameMenu.tutorial_touch = false;
        gameMenu.multiplayer_touch = false;
        gameMenu.box_min_state = 1.0f;
        if(!gameMenu.box_dark_back) {
            if (!gameMenu.istutorial && !gameMenu.resize_scene && !gameMenu.search_planet && !gameMenu.isTv) {
                if (screenX >= SX(50) && screenX <= SX(550) && screenY <= SY(gameMenu.height) && screenY >= SY(gameMenu.height - 250)) {
                    gameMenu.close_touch = true;
                    Gdx.app.exit();
                }
                if (screenX >= SX(620) && screenX <= SX(1020) && screenY <= SY(200) && screenY >= SY(0)) {
                    if (gameMenu.isOpen) {
                        gameMenu.work_touch = true;
                        gameMenu.DoorClose(1);
                    }
                }
                if (screenX >= SX(gameMenu.width - 550) && screenX <= SX(gameMenu.width - 50) && screenY >= SY(gameMenu.height - 250) && screenY <= SY(gameMenu.height)) {
                    if (gameMenu.isOpen) {
                        gameMenu.play_touch = true;
                        gameMenu.DoorClose(2);
                    }
                }
                if (screenX >= SX(1020) && screenX <= SX(1120) && screenY >= SY(0) && screenY <= SY(100)) {
                    game.MusicSet();
                }
                if (screenX >= SX(gameMenu.width / 2 - 300) && screenX <= SX(gameMenu.width / 2) && screenY >= SY(gameMenu.height - 150) && screenY <= SY(gameMenu.height)) {
                    if (gameMenu.isOpen) {
                        gameMenu.tutorial_touch = true;
                        gameMenu.SceneTutorial();
                    }
                }
                if (screenX >= SX(gameMenu.width - 160) && screenX <= SX(gameMenu.width - 50) && screenY <= SY(120) && screenY >= SY(0) && !gameMenu.istutorial) {
                    gameMenu.SetTv();
                }
                if (screenX >= SX(gameMenu.width / 2) && screenX <= SX(gameMenu.width / 2 + 300) && screenY >= SY(gameMenu.height - 150) && screenY <= SY(gameMenu.height) && !gameMenu.istutorial) {
                  /*  if (gameMenu.isOpen) {
                        gameMenu.multiplayer_touch = true;
                        gameMenu.DoorClose(3);
                    }*/
                }
            } else {
                if (gameMenu.search_planet) {
                    if (screenX >= SX(gameMenu.width - 160) && screenX <= SX(gameMenu.width - 50) && screenY <= SY(120) && screenY >= SY(0) && !gameMenu.istutorial) {
                        gameMenu.ResetTv();
                    } else {
                        gameMenu.SwapPlanet();
                    }
                }
            }
            if (screenX >= SX(450) && screenX <= SX(600) && screenY <= SY(gameMenu.height - 435) && screenY >= SY(gameMenu.height - 635) && !gameMenu.istutorial && !gameMenu.search_planet) {
                gameMenu.NextRightSkin();
            }
            if (screenX >= SX(100) && screenX <= SX(250) && screenY <= SY(gameMenu.height - 435) && screenY >= SY(gameMenu.height - 635) && !gameMenu.istutorial && !gameMenu.search_planet) {
                gameMenu.NextLeftSkin();
            }
            if (gameMenu.istutorial && gameMenu.tutorial_scene <= gameMenu.max_tutorial_scene && !gameMenu.resize_scene && !gameMenu.search_planet) {
                if (!gameMenu.icon_1_touch && !gameMenu.icon_2_touch && !gameMenu.icon_3_touch && !gameMenu.icon_4_touch) {
                    if (gameMenu.icon_num_1 == 0) {
                        gameMenu.SceneTutorial();
                    } else {
                        gameMenu.SetTutorial(0, true);
                    }
                }
                if (screenX >= SX(50) && screenX <= SX(450) && screenY >= SY(gameMenu.height - 650) && screenY <= SY(gameMenu.height - 150) && gameMenu.tutorial_icon_1_resize >= 100) {
                    gameMenu.SetTutorial(1, false);
                }
                if (screenX >= SX(450) && screenX <= SX(850) && screenY >= SY(gameMenu.height - 650) && screenY <= SY(gameMenu.height - 150) && gameMenu.tutorial_icon_2_resize >= 100) {
                    gameMenu.SetTutorial(2, false);
                }
                if (screenX >= SX(850) && screenX <= SX(1250) && screenY >= SY(gameMenu.height - 650) && screenY <= SY(gameMenu.height - 150) && gameMenu.tutorial_icon_3_resize >= 100) {
                    gameMenu.SetTutorial(3, false);
                }
                if (screenX >= SX(1250) && screenX <= SX(1650) && screenY >= SY(gameMenu.height - 650) && screenY <= SY(gameMenu.height - 150) && gameMenu.tutorial_icon_4_resize >= 100) {
                    gameMenu.SetTutorial(4, false);
                }
            }
            if (!gameMenu.istutorial && !gameMenu.resize_scene && !gameMenu.search_planet && !gameMenu.isTv) {
                if (screenX >= SX(gameMenu.width - 625) && screenX <= SX(gameMenu.width - 415) && screenY <= SY(gameMenu.height - 200) && screenY >= SY(gameMenu.height - 440) && game.robot.box_empty) {
                    gameMenu.box_min_state = 0.1f;
                    gameMenu.BoxOpen();
                }
            }
        }else{
            gameMenu.BoxClick();
        }
        gameMenu.icon_1_touch = false;
        gameMenu.icon_2_touch = false;
        gameMenu.icon_3_touch = false;
        gameMenu.icon_4_touch = false;
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
