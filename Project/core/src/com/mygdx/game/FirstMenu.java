package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import javax.xml.soap.Text;

import static java.lang.Thread.sleep;

public class FirstMenu implements Screen{
	SpriteBatch drawer;
	boolean closed = false;
	Texture button_play;
	Texture camp;
	MainGame game;
	double a = 1.0;
	float r = 0;
	Texture door_left;
	Texture door_right;
	Texture setting;
	int open_x;
	boolean willClose = false;
	int width;
	int height;
	int dir_r = 0;
	FirstMenu firstMenu = this;
	Texture robo_texture;
	TextureRegion robo;
	Texture head;
	Texture button_exit;
	int h = 1;
	Thread anime;
	Thread door;

	public FirstMenu(MainGame game){
		this.game = game;
	}

	@Override
	public void render(float delta) {
		if (!closed) {
			Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
			a += 0.3;
			if (a >= 6.0) {
				a = 1.0;
			}

			camp = new Texture(Gdx.files.internal("back" + ((int) Math.floor(a)) + ".png"));
			head = new Texture(Gdx.files.internal("logo_" + (1 + h) + ".png"));
			if (dir_r == 0) {
				r += 0.5f;
			} else {
				r -= 0.5f;
			}
			if (r >= 30 | r <= 0) {
				dir_r = 1 - dir_r;
			}

			robo_texture = new Texture("logo_1.png");
			robo = new TextureRegion(robo_texture, 500, 500);
			drawer.begin();
			drawer.draw(camp, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			drawer.draw(robo, -150, -150, 100, 100, 750, 750, 1, 1, r - 30);
			drawer.draw(head, ((float) Gdx.graphics.getWidth() - 500), 50, 500, 500);
			drawer.draw(button_play, ((float) Gdx.graphics.getWidth() / 2 + 300), ((float) Gdx.graphics.getHeight() / 2 + 100), 500, 250);
			drawer.draw(button_exit, 100.0f, ((float) Gdx.graphics.getHeight() / 2 + 100), 500, 250);
			drawer.draw(setting, 100.0f, 300.0f, 150, 200);
			robo_texture.dispose();
			head.dispose();
			camp.dispose();

			if (willClose) {
				drawer.draw(door_left, -open_x, 0, width, height);
				drawer.draw(door_right, open_x, 0, width, height);
			}
			drawer.end();
			if(closed){
				game.setGameMenu();
			}


		}
	}

	@Override
	public void show() {
		setting = new Texture("settings.png");
		door_left =  new Texture("door_1.png");
		door_right=  new Texture("door_2.png");
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		open_x = width/2;
		drawer = new SpriteBatch();
		button_play = new Texture("button.png");
		button_exit = new Texture("exit.png");

		Gdx.input.setInputProcessor(new FirstMenuTouch(game, this));
		anime = new Thread(){
			@Override
			public void run(){
				while(true){
					h++;
					if (h>3){
						h=1;
					}
					try{
						sleep(100);
					}catch (Exception ignored){

					}

				}
			}
		};
		anime.start();
	}
	public void DoorClose(){
		if(!willClose) {
			willClose = true;
			door = new Thread() {
				@Override
				public void run() {
					while (open_x > 0) {
						open_x -= 5;

						try {
							sleep(5);
						} catch (Exception ignored) {

						}

					}

					closed = true;


				}
			};
			door.start();
		}
	}
	@Override
	public void resize(int width, int height) {
	}
	@Override
	public void pause() {
	}
	@Override
	public void resume() {
	}
	@Override
	public void hide() {
	}
	@Override
	public void dispose () {
		setting.dispose();
		robo_texture.dispose();
		drawer.dispose();
		camp.dispose();
		button_play.dispose();
		button_exit.dispose();
		door_right.dispose();
		door_left.dispose();

	}
}
