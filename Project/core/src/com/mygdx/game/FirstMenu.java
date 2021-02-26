package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FirstMenu extends ApplicationAdapter {
	SpriteBatch batch;
	Texture button_play;
	Texture background_image;
	Thread anime;
	int a = 1;
	@Override
	public void create () {
		batch = new SpriteBatch();
		button_play = new Texture("button.png");
		Music music = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
		music.setLooping(true);
		music.setVolume(0.2f);
		music.play();
		anime = new Thread(){
			@Override
			public void run() {
				try{
				while (true) {
						a++;
						if(a >= 12){
							a=1;
						}
						sleep(150);

				}
				}catch (Exception ignored){

				}
			}

		};
		anime.start();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		background_image = new Texture("back" + a + ".png");
		batch.begin();
		batch.draw(background_image, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(button_play, ((float)Gdx.graphics.getWidth()/2-200), ((float)Gdx.graphics.getHeight()/2-300), 500, 250);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		button_play.dispose();
		background_image.dispose();
	}
}
