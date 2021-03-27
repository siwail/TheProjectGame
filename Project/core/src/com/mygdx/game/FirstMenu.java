package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class FirstMenu  extends Openable implements Screen{
	SpriteBatch drawer;
	Texture button_play;
	Texture camp;
	Texture head;
	Texture button_exit;
	Texture robo_texture;
	TextureRegion robo;
	Thread anime;
	Thread leg;
	boolean close_touch = false;
	boolean play_touch = false;
	float r = 0;
	double a = 1.0;
	int dir_r = 0;
	int h = 1;
	public FirstMenu(MainGame game){
		this.game = game;
	}
	@Override
	public void render(float delta) {
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		if (!closed) {
			camp = new Texture(Gdx.files.internal("back" + ((int) Math.floor(a)) + ".png"));
			head = new Texture(Gdx.files.internal("logo_" + (1 + h) + ".png"));
			if(close_touch){
				button_exit = new Texture("button_white.png");
			}else{
				button_exit = new Texture("exit.png");
			}
			if(play_touch){
				button_play = new Texture("button_white.png");
			}else{
				button_play = new Texture("button.png");
			}
			drawer.begin();
			drawer.draw(camp, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			drawer.draw(head, ((float) Gdx.graphics.getWidth() - 500), 50, 500, 500);
			drawer.draw(button_exit, 100.0f, ((float) Gdx.graphics.getHeight() / 2 + 100), 500, 250);
			drawer.draw(robo, -150, -150, 100, 100, 750, 750, 1, 1, r - 30);
			drawer.draw(button_play, ((float) Gdx.graphics.getWidth() / 2 + 300), ((float) Gdx.graphics.getHeight() / 2 + 100), 500, 250);
			head.dispose();
			camp.dispose();
			CheckClose(drawer);
			drawer.end();
			if(closed){
				game.setGameMenu();
			}
			button_play.dispose();
			button_exit.dispose();
		}
	}
	@Override
	public void show() {
		drawer = new SpriteBatch();
		robo_texture = new Texture("logo_1.png");
		robo = new TextureRegion(robo_texture, 500, 500);
		Gdx.input.setInputProcessor(new FirstMenuTouch(game, this));
		anime = new Thread(){
			@Override
			public void run(){
				while(true){
					h++;
					if (h>3){
						h=1;
					}
					a += 1.0;
					if (a >= 6.0) {
						a = 1.0;
					}
					Sleep(this, 90);
				}
			}
		};
		Start();
		leg = new Thread(){
			@Override
			public void run(){
				while(true){
					if (dir_r == 0) {
						r += 0.5f;
					} else {
						r -= 0.5f;
					}
					if (r >= 30 | r <= 0) {
						dir_r = 1 - dir_r;
					}
					Sleep(this, 15);
				}
			}
		};
		leg.start();
		anime.start();
	}
	@Override
	public void resize(int width, int height) { }
	@Override
	public void pause() { }
	@Override
	public void resume() { }
	@Override
	public void hide() { }
	@Override
	public void dispose () {
		robo_texture.dispose();
		drawer.dispose();
		camp.dispose();
		button_play.dispose();
		button_exit.dispose();
		door_right.dispose();
		door_left.dispose();
	}
}
