package com.mygdx.robotlegend;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public class SpriteBatchRubber {
    SpriteBatch batch;
    Random random = new Random();
    double wpw;
    double hph;
    float scale_shake = 1.0f;
    float shake_x = 0.0f;
    float shake_y = 0.0f;
    int boost_px = 0;
    boolean shake;
    public SpriteBatchRubber(Openable menu, SpriteBatch batch){
        this.batch = batch;
        wpw = menu.wpw;
        hph = menu.hph;
    }
    public void Shake(){
        if(!shake){
            shake = true;
            Thread anime = new Thread(){
                public void run(){
                    while(scale_shake<1.1f){
                        scale_shake+=0.02f;
                        try{
                            Thread.sleep(10);
                        }catch(Exception ignored){}
                    }
                    int will_move = 5;
                    float last_shake_x = shake_x;
                    float last_shake_y = shake_y;
                    while(will_move>0){
                        float will_x = shake_x + (float)random.nextInt(10)-5;
                        float will_y = shake_y + (float)random.nextInt(10)-5;
                        while(will_x!=shake_x && will_y!=shake_y){
                            if(will_move!=1) {
                                if (will_x > shake_x) {
                                    shake_x -= 0.02f;
                                }
                                if (will_x < shake_x) {
                                    shake_x += 0.02f;
                                }
                                if (will_y > shake_y) {
                                    shake_y -= 0.02f;
                                }
                                if (will_y < shake_y) {
                                    shake_y += 0.02f;
                                }
                            }else{
                                if(last_shake_x>shake_x){
                                    shake_x-=0.02f;
                                }
                                if(last_shake_x<shake_x){
                                    shake_x+=0.02f;
                                }
                                if(last_shake_y>shake_y){
                                    shake_y-=0.02f;
                                }
                                if(last_shake_y<shake_y){
                                    shake_y+=0.02f;
                                }
                            }
                            try{
                                Thread.sleep(50);
                            }catch(Exception ignored){}
                        }
                        will_move--;

                    }
                    while(scale_shake>1.0f){
                        scale_shake-=0.02f;
                        try{
                            Thread.sleep(10);
                        }catch(Exception ignored){}
                    }
                    shake_x = 0;
                    shake_y = 0;
                    scale_shake = 1.0f;
                    shake = false;
                }
            };
            anime.start();
        }
    }
    public void draw (Texture texture, float x, float y, float width, float height) {
        batch.draw(texture, (float)((double)x*wpw), (float)((double)y*hph), (float)((double)width*wpw), (float)((double)height*hph));
    }
    public void draw (TextureRegion region, float x, float y, float originX, float originY, float width, float height,
                      float scaleX, float scaleY, float rotation) {
        batch.draw(region, (float)((double)x*wpw), (float)((double)y*hph), (float)((double)originX*wpw), (float)((double)originY*hph), (float)((double)width*wpw), (float)((double)height*hph), scaleX, scaleY, rotation);
    }
    public void draw (TextureRegion region, float x, float y, float originX, float originY, float width, float height,
                      float scaleX, float scaleY, float rotation, boolean circle) {
        if(circle) {
            batch.draw(region, (float) ((double) x * wpw), (float) ((double) y * hph), (float) ((double) originX * hph), (float) ((double) originY * hph), (float) ((double) width * hph), (float) ((double) height * hph), scaleX, scaleY, rotation);
        }
    }
}
