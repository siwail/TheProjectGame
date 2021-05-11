package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteBatchRubber {
    SpriteBatch batch;
    double wpw;
    double hph;
    public SpriteBatchRubber(Openable menu, SpriteBatch batch){
        this.batch = batch;
        wpw = menu.wpw;
        hph = menu.hph;
    }
    public void draw (Texture texture, float x, float y, float width, float height) {
        batch.draw(texture, (float)((double)x*wpw), (float)((double)y*hph), (float)((double)width*wpw), (float)((double)height*hph));
    }
    public void draw (TextureRegion region, float x, float y, float originX, float originY, float width, float height,
                      float scaleX, float scaleY, float rotation) {
        batch.draw(region, (float)((double)x*wpw), (float)((double)y*hph), (float)((double)originX*wpw), (float)((double)originY*hph), (float)((double)width*wpw), (float)((double)height*hph), scaleX, scaleY, rotation);
    }
}
