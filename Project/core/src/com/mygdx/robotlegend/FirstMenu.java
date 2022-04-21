package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class FirstMenu  extends Openable implements Screen{
	SpriteBatch batch;
	Sound check;
	Texture[] head = new Texture[3];
	Texture robo_texture;
	Texture space_1;
	Texture space_2;
	Texture button_left_part;
	Texture button_right_part;
	Texture button_center_part;
	Texture button_exit_icon;
	Texture button_play_icon;
	Texture back_light;
	Texture[] objects_texture = new Texture[4];
	TextureRegion robo;
	TextureRegion space_2_r;
	TextureRegion[] objects = new TextureRegion[4];
	Thread Objects_surf;
	Thread button_anime;
	Thread anime;
	Thread leg;
	Thread anime_space;
	boolean object_show = false;
	boolean close_touch = false;
	boolean play_touch = false;
	boolean trailer_dispose_need = false;
	float rotate = 0;
	float object_scale = 0.0f;
	float object_x = 0;
	float object_y = 0;
	float object_rotate = 0;
	float object_dir_x = 0;
	float object_dir_y = 0;
	float object_dir_rotate = 0;
	int object_type = 0;
	int button_exit_state = 0;
	int button_play_state = 0;
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
		drawer.draw(space_1, -space_1_px / 2, -space_1_px / 2, width + space_1_px, height + space_1_px);
		drawer.draw(space_2_r, -space_2_px / 2, -space_2_px / 2, width / 2 + space_2_px / 2, height / 2 + space_2_px / 2, width + space_2_px, height + space_2_px, 1, 1, space_2_rot);
		drawer.draw(space_2_r, -space_3_px / 2, -space_3_px / 2, width / 2 + space_3_px / 2, height / 2 + space_3_px / 2, width + space_3_px, height + space_3_px, 1, 1, space_3_rot);
		drawer.draw(space_2_r, -space_4_px / 2, -space_4_px / 2, width / 2 + space_4_px / 2, height / 2 + space_4_px / 2, width + space_4_px, height + space_4_px, 1, 1, space_4_rot);
		drawer.draw(space_2_r, -space_5_px / 2, -space_5_px / 2, width / 2 + space_5_px / 2, height / 2 + space_5_px / 2, width + space_5_px, height + space_5_px, 1, 1, space_5_rot);
		drawer.draw(objects[object_type], object_x, object_y, object_scale*150, object_scale*150, object_scale*300, object_scale*300, 1, 1, object_rotate);
			if(h!=3) {
				if(!game.autoplay_enabled) {
					drawer.draw(head[h], width / 2 + 325, -90, 525, 525);
				}else{
					drawer.draw(head[2], width / 2 + 325-h*3, -90, 525+h*6, 525+h*6);
				}
			}
			DrawDefaultButton(drawer, button_left_part, button_center_part, button_right_part, back_light, button_exit_icon, button_exit_state, width / 2-200, height/2-260, 400);
			drawer.draw(robo, -150, -150, 100, 100, 750, 750, 1, 1, rotate - 30);
			DrawDefaultButton(drawer, button_left_part, button_center_part, button_right_part, back_light, button_play_icon, button_play_state,  width / 2-200, height/2-40, 400);
				if(trailer_dispose_need){
					trailer_dispose_need = false;
					space_1.dispose();
					space_2.dispose();
				}
			CheckDoor(drawer);
			batch.end();
			if(closed){
				game.setGameMenu();
			}
	}
	@Override
	public void show() {
		game.MusicSwap(1);
		batch = new SpriteBatch();
		check = Gdx.audio.newSound(Gdx.files.internal("Sound/took_1.wav"));
		button_left_part = new Texture("Button/button_left_part.png");
		button_right_part = new Texture("Button/button_right_part.png");
		button_center_part = new Texture("Button/button_center_part.png");
		back_light= new Texture("Interface/back_light.png");
		button_exit_icon= new Texture("Interface/icon_exit.png");
		button_play_icon= new Texture("Interface/icon_play.png");
		space_1 = new Texture("Location/background_2.png");
		space_2 = new Texture("Location/background_2_front.png");
		space_2_r = new TextureRegion(space_2, 1280, 720);
		robo_texture = new Texture("Object/logo_1.png");
		objects_texture[0] = new Texture("Object/planet_1.png");
		objects_texture[1] = new Texture("Object/planet_2.png");
		objects_texture[2] = new Texture("Object/planet_3.png");
		objects_texture[3] = new Texture("Object/planet_4.png");
		objects[0] = new TextureRegion(objects_texture[0], 400, 400);
		objects[1] = new TextureRegion(objects_texture[1], 400, 400);
		objects[2] = new TextureRegion(objects_texture[2], 400, 400);
		objects[3] = new TextureRegion(objects_texture[3], 400, 400);
		head[0] = new Texture("Object/logo_2.png");
		head[1] = new Texture("Object/logo_3.png");
		head[2] = new Texture("Object/logo_4.png");
		robo = new TextureRegion(robo_texture, 500, 500);
		Gdx.input.setInputProcessor(new FirstMenuTouch(game, this));
		Objects_surf = new Thread() {
			@Override
			public void run() {
				object_type = game.random.nextInt(4);
				while (!closed) {
					Sleep((game.random.nextInt(3)+1)*100);
					object_scale = 0.0f;
					object_x = width/2;
					object_y = height/2;
					object_rotate = 0.0f;
					object_type +=1;
					if(object_type>=4){
						object_type =0;
					}
					int random_dir = game.random.nextInt(2);
					if(random_dir == 0) {
						object_dir_x = (game.random.nextInt(8) + 8);
					}else{
						object_dir_x = -(game.random.nextInt(8) + 8);
					}
					random_dir = game.random.nextInt(2);
					if(random_dir == 0) {
						object_dir_y = (game.random.nextInt(8) + 8);
					}else{
						object_dir_y = -(game.random.nextInt(8) + 8);
					}
					random_dir = game.random.nextInt(2);
					if(random_dir == 0) {
						object_dir_rotate = (game.random.nextInt(6) + 1);
					}else{
						object_dir_rotate = -(game.random.nextInt(6) + 1);
					}
					object_show = true;
					while(object_scale<3.5f){
						object_scale += 0.015f;
						object_x += object_dir_x;
						object_y += object_dir_y;
						object_rotate += object_dir_rotate;
						Sleep(10);
					}
					object_show = false;
				}
			}
		};
		Objects_surf.start();
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
				while (true) {
					h++;
					if (h > 2) {
						h = 0;
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
				int trailer_dir = 1;
				space_2_px = (int)(width*0.2);
				space_3_px = (int)(width*0.4);
				space_4_px = (int)(width*0.6);
				space_5_px = (int)(width*0.8);
				while(!closed){
					space_1_px += trailer_dir*trailer_state/2;
					space_2_px += trailer_state*5+1;
					if(space_2_px > width*1.2){
						space_2_px += trailer_state*12+1;

						if(space_2_px > width*3.0) {
							if(trailer_state!=9) {
								space_2_px = -height;
							}

							trailer_state+=trailer_dir;
							if(trailer_state>=8){
								trailer_dir = 0;
							}
							if(trailer_state<=2){
								trailer_dir = 1;
							}
						}


					}
					space_3_px += trailer_state*5+2;
					if(space_3_px > width*1.2){
						space_3_px += trailer_state*12+2;

						if(space_3_px > width*3.0f && trailer_state!=9) {
							space_3_px = -height;
						}

					}
					space_4_px += trailer_state*5+3;
					if(space_4_px > width*1.2){
						space_4_px += trailer_state*12+3;

						if(space_4_px > width*3.0f && trailer_state!=9) {
							space_4_px = -height;
						}

					}
					space_5_px += trailer_state*5+4;
					if(space_5_px > width*1.2){
						space_5_px += trailer_state*12+4;

						if(space_5_px > width*3.0f && trailer_state!=9) {
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
					Sleep(10);
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
		button_anime.start();
		anime_space.start();
		leg.start();
		anime.start();
}
	@Override
	public void dispose () {
		check.dispose();
		machine_4.dispose();
		machine_2.dispose();
		machine_3.dispose();
		batch.dispose();
		robo_texture.dispose();

		for(Texture texture: head){ texture.dispose(); }
		for(Texture texture: objects_texture){ texture.dispose(); }
		button_left_part.dispose();
		button_right_part.dispose();
		button_center_part.dispose();
		back_light.dispose();
		button_exit_icon.dispose();
		button_play_icon.dispose();
	}
}
