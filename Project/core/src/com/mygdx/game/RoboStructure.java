package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class RoboStructure {
    MainGame game;
    public RoboStructure(MainGame game){ this.game = game; }
    int gears = 0;
    int microchips = 0;
    int lamps = 0;
    int metal = 0;
    int energy = 0;
    int Hid = 3;
    int Bid = 3;
    int RHid = 3; //Правая рука
    int LHid = 3; //Левая рука
    int RLid = 3; //Правая нога
    int LLid = 3; //Левая нога
    int health = 300;
    int damage = 50;
    int attack_speed = 30;
    int move_speed = 50;
    int rocket_fuel = 20;
    Texture BackHealth;
    Texture RobotIcon;
    Texture EnemyIcon;
    Texture EnemyDetect;
    Texture RobotDetect;
    Texture RobotHealth;
    Texture EnemyHealth;
    Texture RHt;
    Texture LHt;
    Texture RLt;
    Texture LLt;
    Texture Ht;
    Texture Bt;
    TextureRegion RH;
    TextureRegion LH;                                                                                               
    TextureRegion RL;
    TextureRegion LL;
    TextureRegion H;
    TextureRegion B;
    int EHid;
    int EBid;
    int ERHid;
    int ELHid;
    int ERLid;
    int ELLid;
    int Ehealth = 300;
    int Edamage = 50;
    int Eattack_speed = 30;
    int Emove_speed = 50;
    int Erocket_fuel = 20;
    Texture ERHt;
    Texture ELHt;
    Texture ERLt;
    Texture ELLt;
    Texture EHt;
    Texture EBt;
    TextureRegion ERH;
    TextureRegion ELH;
    TextureRegion ERL;
    TextureRegion ELL;
    TextureRegion EH;
    TextureRegion EB;
    public void DisposeTextures(){
        RHt.dispose();
        LHt.dispose();
        LHt.dispose();
        RLt.dispose();
        LLt.dispose();
        Ht.dispose();
        Bt.dispose();
    }
    public void SetFirstChanges(){
        BackHealth = new Texture("back_health.png");
        RobotIcon = new Texture("friend.png");
        EnemyIcon = new Texture("enemy.png");
        RobotHealth = new Texture("friend_health.png");
        EnemyHealth = new Texture("enemy_health.png");
        RobotDetect = new Texture("friend_detect.png");
        EnemyDetect = new Texture("enemy_detect.png");
    }
    public void UpdateTextures(){
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
        EHid = game.random.nextInt(4)+1;
        EBid = game.random.nextInt(4)+1;
        ERHid = game.random.nextInt(4)+1; //Правая рука
        ELHid = game.random.nextInt(4)+1; //Левая рука
        ERLid = game.random.nextInt(4)+1; //Правая нога
        ELLid = game.random.nextInt(4)+1; //Левая нога
        ERHt =  new Texture("hand_" + ERHid + ".png");
        ELHt = new Texture("hand_" + ELHid + ".png");
        ERLt = new Texture("leg_" + ERLid + ".png");
        ELLt = new Texture("leg_" + ELLid + ".png");
        EHt = new Texture("head_" + EHid + ".png");
        EBt = new Texture("body_" + EBid + ".png");
        ERH =  new TextureRegion(ERHt, 300, 300);
        ELH =  new TextureRegion(ELHt, 300, 300);
        ERL =  new TextureRegion(ERLt, 300, 300);
        ELL =  new TextureRegion(ELLt, 300, 300);
        EH =  new TextureRegion(EHt, 300, 300);
        EB =  new TextureRegion(EBt, 300, 300);
    }
}
