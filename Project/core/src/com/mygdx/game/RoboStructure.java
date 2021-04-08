package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RoboStructure {
    int gears = 0;
    int microchips = 0;
    int lamps = 0;
    int metal = 0;
    int energy = 100;

    int Hid = 1;
    int Bid = 1;
    int RHid = 1; //Правая рука
    int LHid = 1; //Левая рука
    int RLid = 1; //Правая нога
    int LLid = 1; //Левая нога


    int health = 300;
    int damage = 50;
    int attack_speed = 30;
    int move_speed = 50;
    int rocket_fuel = 20;


    Texture RHt =  new Texture("hand_" + RHid + ".png");
    Texture LHt = new Texture("hand_" + LHid + ".png");
    Texture RLt = new Texture("leg_" + RLid + ".png");
    Texture LLt = new Texture("leg_" + LLid + ".png");
    Texture Ht = new Texture("head_" + Hid + ".png");
    Texture Bt = new Texture("body_" + Bid + ".png");

    TextureRegion RH;
    TextureRegion LH;
    TextureRegion RL;
    TextureRegion LL;
    TextureRegion H;
    TextureRegion B;

    public void UpdateTextures(){
        RHt.dispose();
        LHt.dispose();
        LHt.dispose();
        RLt.dispose();
        LLt.dispose();
        Ht.dispose();
        Bt.dispose();
        RHt =  new Texture("hand_" + RHid + ".png");
        LHt = new Texture("hand_" + LHid + ".png");
        RLt = new Texture("leg_" + RLid + ".png");
        LLt = new Texture("leg_" + LLid + ".png");
        Ht = new Texture("head_" + Hid + ".png");
        Bt = new Texture("body_" + Bid + ".png");
        RH =  new TextureRegion(RHt, 300, 300);
        LH =  new TextureRegion(LHt, 300, 300);
        RL =  new TextureRegion(RLt, 300, 300);
        LL =  new TextureRegion(LLt, 300, 300);
        H =  new TextureRegion(Ht, 300, 300);
        B =  new TextureRegion(Bt, 300, 300);
    }
}
