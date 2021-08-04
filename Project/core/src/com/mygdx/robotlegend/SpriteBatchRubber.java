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

                    while(boost_px<10){
                        boost_px+=1;
                        try {
                            Thread.sleep(5);
                        } catch (Exception ignored) { }
                    }
                    while(boost_px>0){
                        boost_px-=1;
                        try {
                            Thread.sleep(5);
                        } catch (Exception ignored) { }
                    }
                    shake = false;
                }
            };
            anime.start();
        }
    }
    public void draw (Texture texture, float x, float y, float width, float height) {
        batch.draw(texture, (float)((double)x*wpw)+shake_x-boost_px/2, (float)((double)y*hph)+shake_y-boost_px/2, (float)((double)width*wpw)+boost_px, (float)((double)height*hph)+boost_px);
    }
    public void draw (TextureRegion region, float x, float y, float originX, float originY, float width, float height,
                      float scaleX, float scaleY, float rotation) {
        batch.draw(region, (float)((double)x*wpw)+shake_x-boost_px/2, (float)((double)y*hph)+shake_y-boost_px/2, (float)((double)originX*wpw)+boost_px/2, (float)((double)originY*hph)+boost_px/2, (float)((double)width*wpw)+boost_px, (float)((double)height*hph)+boost_px, scaleX, scaleY, rotation);
    }
    public void draw (TextureRegion region, float x, float y, float originX, float originY, float width, float height,
                      float scaleX, float scaleY, float rotation, boolean circle) {
        if(circle) {
            batch.draw(region, (float) ((double) x * wpw)+shake_x-boost_px/2, (float) ((double) y * hph)+shake_y-boost_px/2, (float) ((double) originX * hph)+boost_px/2, (float) ((double) originY * hph)+boost_px/2, (float) ((double) width * hph)+boost_px, (float) ((double) height * hph)+boost_px, scaleX, scaleY, rotation);
        }
    }
}
