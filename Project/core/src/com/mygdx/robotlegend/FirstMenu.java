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
	Texture[] head = new Texture[3];
	Texture robo_texture;
	Texture trailer;
	Texture planet;
	Texture space_1;
	Texture space_2;
	Texture button_left_part;
	Texture button_right_part;
	Texture button_center_part;
	Texture button_exit_icon;
	Texture button_play_icon;
	Texture back_light;
	TextureRegion robo;
	TextureRegion space_2_r;
	Thread button_anime;
	Thread anime;
	Thread leg;
	Thread anime_trailer;
	Thread anime_space;
	boolean can_touch = false;
	boolean close_touch = false;
	boolean play_touch = false;
	boolean is_trailer = true;
	boolean trailer_started = false;
	float rotate = 0;
	float trailer_scale = 1.0f;
	int button_exit_state = 0;
	int button_play_state = 0;
	int a = 0;
	int dir_rotate = 0;
	int h = 1; //Анимация головы
	int trailer_state = 5;
	int space_1_px = 0;
	int space_2_px = 0;
	int space_3_px = -height;
	int space_4_px = -height/2;
	int space_5_px = height/2;
	float space_2_rot = 0.0f;
	float space_3_rot = 0.0f;
	float space_4_rot = 0.0f;
	float space_5_rot = 0.0f;


	public FirstMenu(MainGame game){
		this.game = game;
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		batch.begin();
				try {
					drawer.draw(backs[a - 1], 0, 0, width, height);
				}catch (Exception ignored){ }
			if(h!=3) {
				drawer.draw(head[h], ((float) width - 500), 50, 500, 500);
			}


		DrawDefaultButton(drawer, button_left_part, button_center_part, button_right_part, back_light, button_exit_icon, button_exit_state, 120, height/2+80, 400);
			drawer.draw(robo, -150, -150, 100, 100, 750, 750, 1, 1, rotate - 30);
		DrawDefaultButton(drawer, button_left_part, button_center_part, button_right_part, back_light, button_play_icon, button_play_state,  width / 2 + 370, height/2+80, 400);


		if (is_trailer && trailer_state >= 9){

			drawer.draw(trailer, -((int)( (float)width * trailer_scale) - width) / 2, -((int) ((float)height * trailer_scale) - height) / 2, (int)((float)width * trailer_scale), (int)((float)height * trailer_scale));
		}
			if(is_trailer && trailer_state!=10){
				if(!trailer_started) {
					drawer.draw(space_1, -space_1_px / 2, -space_1_px / 2, width + space_1_px, height + space_1_px);
				}
				drawer.draw(space_2_r, -space_2_px/2, -space_2_px/2, width/2+space_2_px/2, height/2+space_2_px/2, width+space_2_px, height+space_2_px, 1, 1, space_2_rot);
				drawer.draw(space_2_r, -space_3_px/2, -space_3_px/2, width/2+space_3_px/2, height/2+space_3_px/2, width+space_3_px, height+space_3_px, 1, 1, space_3_rot);
				drawer.draw(space_2_r, -space_4_px/2, -space_4_px/2, width/2+space_4_px/2, height/2+space_4_px/2, width+space_4_px, height+space_4_px, 1, 1, space_4_rot);
				drawer.draw(space_2_r, -space_5_px/2, -space_5_px/2, width/2+space_5_px/2, height/2+space_5_px/2, width+space_5_px, height+space_5_px, 1, 1, space_5_rot);

			}

			CheckClose(drawer);
			batch.end();
			if(closed){
				game.setGameMenu();
			}
	}
	@Override
	public void show() {

		game.MusicSwap(3);
		batch = new SpriteBatch();
		button_left_part = new Texture("Button/button_left_part.png");
		button_right_part = new Texture("Button/button_right_part.png");
		button_center_part = new Texture("Button/button_center_part.png");
		back_light= new Texture("Interface/back_light.png");
		button_exit_icon= new Texture("Interface/icon_exit.png");
		button_play_icon= new Texture("Interface/icon_play.png");
		planet = new Texture("Object/planet_3.png");
		space_1 = new Texture("Decoration/space_1.png");
		space_2 = new Texture("Decoration/space_2.png");
		space_2_r = new TextureRegion(space_2, 960, 540);
		robo_texture = new Texture("Object/logo_1.png");
		trailer = new Texture("Decoration/trailer.png");
		for(int i=0;i<5;i++){
			backs[i] = new Texture("Interface/back" + (i+1) + ".png");
		}
		head[0] = new Texture("Object/logo_2.png");
		head[1] = new Texture("Object/logo_3.png");
		head[2] = new Texture("Object/logo_4.png");
		robo = new TextureRegion(robo_texture, 500, 500);
		Gdx.input.setInputProcessor(new FirstMenuTouch(game, this));
		button_anime = new Thread() {
			@Override
			public void run() {
				while (!closed) {
					if(close_touch && button_exit_state<100){
						button_exit_state +=1;
					}else{
						if(button_exit_state>0 && !close_touch){
							button_exit_state -=1;
						}
					}
					if(play_touch && button_play_state<100){
						button_play_state +=1;
					}else{
						if(button_play_state>0 && !play_touch){
							button_play_state -=1;
						}
					}
					Sleep( 3);
				}
			}
		};
		anime = new Thread() {
			@Override
			public void run() {
				int fire_dir = 0;
				while (true) {
					h++;
					if (h > 2) {
						h = 0;
					}
					if(fire_dir == 0){
						a++;
						if(a>=5){
							fire_dir = 1;
						}
					}else{
						a--;
						if(a<2){
							fire_dir = 0;
						}
					}
					if(closed){
						break;
					}
				Sleep( 60);
			}
		}
	};
		anime_space = new Thread() {
			@Override
			public void run() {

				space_2_px = (int)(width*0.2);
				space_3_px = (int)(width*0.4);
				space_4_px = (int)(width*0.6);
				space_5_px = (int)(width*0.8);
				while(trailer_state!=10){
					space_1_px += trailer_state/2+1;
					space_2_px += trailer_state*5+1;
					if(space_2_px > width*1.2){
						space_2_px += trailer_state*12+1;

						if(space_2_px > width*4.5) {
							if(trailer_state!=9) {
								space_2_px = -height;
							}
							trailer_state++;
						}


					}
					space_3_px += trailer_state*5+2;
					if(space_3_px > width*1.2){
						space_3_px += trailer_state*12+2;

						if(space_3_px > width*4.5 && trailer_state!=9) {
							space_3_px = -height;
						}

					}
					space_4_px += trailer_state*5+3;
					if(space_4_px > width*1.2){
						space_4_px += trailer_state*12+3;

						if(space_4_px > width*4.5 && trailer_state!=9) {
							space_4_px = -height;
						}

					}
					space_5_px += trailer_state*5+4;
					if(space_5_px > width*1.2){
						space_5_px += trailer_state*12+4;

						if(space_5_px > width*4.5 && trailer_state!=9) {
							space_5_px = -height;
						}
					}
					space_2_rot -= 0.1f;
					if(space_2_rot>360.0f){
						space_2_rot=0.0f;
					}
					space_3_rot += 0.2f;
					if(space_3_rot>360.0f){
						space_3_rot=0.0f;
					}
					space_4_rot -= 0.3f;
					if(space_4_rot>360.0f){
						space_4_rot=0.0f;
					}
					space_5_rot += 0.4f;
					if(space_5_rot>360.0f){
						space_5_rot=0.0f;
					}
					if(trailer_state == 9 && !trailer_started){
						trailer_started = true;
						anime_trailer.start();
					}
					Sleep(4);
				}

			}
		};
		anime_trailer = new Thread() {
			@Override
			public void run() {
				Sleep(1500);
				while (trailer_scale < 47.0f) {
					trailer_scale += 0.075f;
					if(trailer_scale>35.0f){
						can_touch = true;
					}
					Sleep(2);
				}
				is_trailer = false;
				trailer_scale = 1.0f;
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
		button_anime.start();
		anime_space.start();
		leg.start();
		anime.start();
}
	@Override
	public void dispose () {
		batch.dispose();
		robo_texture.dispose();
		for(Texture texture: backs){ texture.dispose(); }
		for(Texture texture: head){ texture.dispose(); }
		door_right.dispose();
		door_left.dispose();
		trailer.dispose();
		planet.dispose();
		space_1.dispose();
		space_2.dispose();
		button_left_part.dispose();
		button_right_part.dispose();
		button_center_part.dispose();
		back_light.dispose();
		button_exit_icon.dispose();
		button_play_icon.dispose();
	}
}
