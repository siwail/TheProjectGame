package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class FirstMenu  extends Openable implements Screen{
	SpriteBatch drawer;
	Texture[] backs = new Texture[5];
	Texture button_play;
	Texture head;
	Texture button_exit;
	Texture robo_texture;
	Texture white;
	Texture play;
	Texture exit;
	TextureRegion robo;
	Thread anime;
	Thread leg;
	boolean close_touch = false;
	boolean play_touch = false;
	float r = 0;
	int a = 0;
	int dir_r = 0;
	int h = 1;
	public FirstMenu(MainGame game){
		this.game = game;
	}
	@Override
	public void render(float delta) {
		if (!closed) {
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
			head = new Texture(Gdx.files.internal("logo_" + (1 + h) + ".png"));
			if(close_touch){
				button_exit = white;
			}else{
				button_exit = exit;
			}
			if(play_touch){
				button_play = white;
			}else{
				button_play = play;
			}
			drawer.begin();
			drawer.draw(backs[a-1], 0, 0, width, height);
			drawer.draw(head, ((float) Gdx.graphics.getWidth() - 500), 50, 500, 500);
			drawer.draw(button_exit, 100.0f, ((float) Gdx.graphics.getHeight() / 2 + 100), 500, 250);
			drawer.draw(robo, -150, -150, 100, 100, 750, 750, 1, 1, r - 30);
			drawer.draw(button_play, ((float) Gdx.graphics.getWidth() / 2 + 300), ((float) Gdx.graphics.getHeight() / 2 + 100), 500, 250);
			head.dispose();
			CheckClose(drawer);
			drawer.end();
			if(closed){
				game.setGameMenu();
			}
		}
	}
	@Override
	public void show() {
		drawer = new SpriteBatch();
		exit = new Texture("exit.png");
		play = new Texture("button.png");
		white = new Texture("button_white.png");
		robo_texture = new Texture("logo_1.png");
		for(int i=0;i<5;i++){
			backs[i] = new Texture("back" + (i+1) + ".png");
		}
		robo = new TextureRegion(robo_texture, 500, 500);
		Gdx.input.setInputProcessor(new FirstMenuTouch(game, this));
		anime = new Thread() {
			@Override
			public void run() {
				while (true) {
					h++;
					if (h > 3) {
						h = 1;
					}
					if(a<5){
						a++;
					}else{
						a=1;
					}
					if(closed){
						break;
					}
				Sleep( 90);
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
				if(closed){
					break;
				}
				Sleep( 15);
			}
		}
	};
		leg.start();
		anime.start();
}
	@Override
	public void dispose () {
		play.dispose();
		white.dispose();
		robo_texture.dispose();
		drawer.dispose();
		for(Texture t: backs){ t.dispose(); }
		button_play.dispose();
		button_exit.dispose();
		door_right.dispose();
		door_left.dispose();

	}
}
