package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import javax.xml.soap.Text;

import static java.lang.Thread.sleep;

public class FirstMenu extends ApplicationAdapter {
	SpriteBatch batch;
	Texture button_play;
	Texture camp;
	double a = 1.0;
	float r = 0;
	int dir_r = 0;
	Texture robo_texture;
	TextureRegion robo;
	Texture head;
	Texture button_exit;
	InputProcessor input;
	int h = 1;
	Thread anime;
	@Override
	public void create () {
		batch = new SpriteBatch();

		button_play = new Texture("button.png");
		button_exit = new Texture("exit.png");
		Music music = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
		music.setVolume(0.2f);
		music.play();

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

	@Override
	public void render () {

		a+=0.3;
		if(a >= 6.0){
			a=1.0;
		}

		camp = new Texture(Gdx.files.internal("back" + ((int) Math.floor(a)) + ".png"));
		head = new Texture(Gdx.files.internal("logo_" + (1 + h) + ".png"));
		if(dir_r == 0){
			r+=0.5f;
		}else{
			r-=0.5f;
		}
		if(r >= 30 | r <= 0){
			dir_r = 1 - dir_r;
		}
		robo_texture = new Texture("logo_1.png");
		robo = new TextureRegion( robo_texture, 500, 500);
		batch.begin();
		batch.draw(camp, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(robo, -150, -150, 100, 100, 750, 750, 1, 1, r-30);
		batch.draw(head, ((float)Gdx.graphics.getWidth()-500), 50, 500, 500);
		batch.draw(button_play, ((float)Gdx.graphics.getWidth()/2+300), ((float)Gdx.graphics.getHeight()/2+100), 500, 250);
		batch.draw(button_exit, 100.0f, ((float)Gdx.graphics.getHeight()/2+100), 500, 250);
		batch.end();
		robo_texture.dispose();
		head.dispose();
		camp.dispose();
	}

	@Override
	public void dispose () {

		robo_texture.dispose();
		batch.dispose();
		camp.dispose();
		button_play.dispose();
		button_exit.dispose();
	}
}
