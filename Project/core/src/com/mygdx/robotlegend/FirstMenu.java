package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class FirstMenu  extends Openable implements Screen{
	SpriteBatch batch;
	Texture[] backs = new Texture[5];
	Texture button_play;
	Texture[] head = new Texture[3];
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
	float rotate = 0;
	int a = 0;
	int dir_rotate = 0;
	int h = 1; //Анимация головы
	public FirstMenu(MainGame game){
		this.game = game;
	}
	@Override
	public void render(float delta) {
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
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
			batch.begin();
			drawer.draw(backs[a-1], 0, 0, width, height);
			drawer.draw(head[h], ((float) width - 500), 50, 500, 500);
			drawer.draw(button_exit, 100.0f, ((float) height / 2 + 100), 500, 250);
			drawer.draw(robo, -150, -150, 100, 100, 750, 750, 1, 1, rotate - 30);
			drawer.draw(button_play, ((float) width / 2 + 300), ((float) height / 2 + 100), 500, 250);
			CheckClose(drawer);
			batch.end();
			if(closed){
				game.setGameMenu();
			}
	}
	@Override
	public void show() {
		batch = new SpriteBatch();
		exit = new Texture("Button/exit.png");
		play = new Texture("Button/button2.png");
		white = new Texture("Button/button_white.png");
		robo_texture = new Texture("Object/logo_1.png");
		for(int i=0;i<5;i++){
			backs[i] = new Texture("Interface/back" + (i+1) + ".png");
		}
		head[0] = new Texture("Object/logo_2.png");
		head[1] = new Texture("Object/logo_3.png");
		head[2] = new Texture("Object/logo_4.png");
		robo = new TextureRegion(robo_texture, 500, 500);
		Gdx.input.setInputProcessor(new FirstMenuTouch(game, this));
		anime = new Thread() {
			@Override
			public void run() {
				while (true) {
					h++;
					if (h > 2) {
						h = 0;
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
				if (dir_rotate == 0) {
					rotate += 0.5f;
				} else {
					rotate -= 0.5f;
				}
				if (rotate >= 30 | rotate <= 0) {
					dir_rotate = 1 - dir_rotate;
				}
				if(closed){
					break;
				}
				Sleep( 15);
			}
		}
	};
		drawer = new SpriteBatchRubber(this, batch);
		leg.start();
		anime.start();
}
	@Override
	public void dispose () {
		batch.dispose();
		play.dispose();
		white.dispose();
		robo_texture.dispose();
		for(Texture texture: backs){ texture.dispose(); }
		for(Texture texture: head){ texture.dispose(); }
		button_play.dispose();
		button_exit.dispose();
		door_right.dispose();
		door_left.dispose();
		exit.dispose();
	}
}
