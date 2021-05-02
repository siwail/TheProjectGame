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
    int energy = 100;
    int Hid = 1;
    int Bid = 1;
    int RHid = 1; //Правая рука
    int LHid = 1; //Левая рука
    int RLid = 1; //Правая нога
    int LLid = 1; //Левая нога
    int health = 100;
    int damage = 2;
    int attack_speed;
    int move_speed;
    int energy_speed;
    Texture EnergyBack;
    Texture Energy;
    Texture EnergyFront;
    Texture EnergyWarning1;
    Texture EnergyWarning2;
    Texture Bullet;
    Texture EBullet;
    Texture ESelect;
    Texture Select;
    Texture SelectRobott;
    Texture Hidet;

    Texture HeadDeadt;
    Texture BodyDeadt;
    Texture LeftLegDeadt;
    Texture RightLegDeadt;
    Texture LeftHandDeadt;
    Texture RightHandDeadt;

    Texture HeadHurtt;
    Texture BodyHurtt;
    Texture LeftLegHurtt;
    Texture RightLegHurtt;
    Texture LeftHandHurtt;
    Texture RightHandHurtt;
    Texture HeadSwapt;
    Texture BodySwapt;
    Texture LeftLegSwapt;
    Texture RightLegSwapt;
    Texture LeftHandSwapt;
    Texture RightHandSwapt;
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
    TextureRegion SelectRobot;
    TextureRegion Hide;
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
    int Ehealth = 100;
    int Edamage;
    int Eattack_speed;
    int Emove_speed;
    int Eenergy_speed = 80-EBid*7;
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
        Hid = game.random.nextInt(4)+1;
        Bid = game.random.nextInt(4)+1;
        RHid = game.random.nextInt(4)+1; //Правая рука
        LHid = game.random.nextInt(4)+1; //Левая рука
        RLid = game.random.nextInt(4)+1; //Правая нога
        LLid = game.random.nextInt(4)+1; //Левая нога


        EHid = game.random.nextInt(4)+1;
        EBid = game.random.nextInt(4)+1;
        ERHid = game.random.nextInt(4)+1; //Правая рука
        ELHid = game.random.nextInt(4)+1; //Левая рука
        ERLid = game.random.nextInt(4)+1; //Правая нога
        ELLid = game.random.nextInt(4)+1; //Левая нога

        energy_speed = 90-Bid*7;
        Eenergy_speed = 90-EBid*7;
        attack_speed = (int)(8.0-((double)RHid/2.0+(double)LHid/2.0));
        move_speed = (int)(7.0-((double)RLid/2.0+(double)LLid/2.0));
        Eattack_speed = (int)(8.0-((double)ERHid/2.0+(double)ELHid/2.0));
        Emove_speed = (int)(7.0-((double)ERLid/2.0+(double)ELLid/2.0));
        Edamage =(int)((double)ERHid/2.0+(double)ELHid/2.0)*2;
        damage =(int)((double)RHid/2.0+(double)LHid/2.0)*2;

        SelectRobott = new Texture("select3.png");
        Hidet = new Texture("hide.png");
        Energy = new Texture("energy.png");
        EnergyBack = new Texture("back_energy.png");
        EnergyFront = new Texture("front_energy.png");
        EnergyWarning1 = new Texture("front_energy_w1.png");
        EnergyWarning2 = new Texture("front_energy_w2.png");
        EBullet = new Texture("bullet.png");
        Bullet = new Texture("bullet2.png");
        ESelect = new Texture("select.png");
        Select = new Texture("select2.png");
        BackHealth = new Texture("back_health.png");
        RobotIcon = new Texture("friend.png");
        EnemyIcon = new Texture("enemy.png");
        RobotHealth = new Texture("friend_health.png");
        EnemyHealth = new Texture("enemy_health.png");
        RobotDetect = new Texture("friend_detect.png");
        EnemyDetect = new Texture("enemy_detect.png");

        HeadSwapt = new Texture("head_swap.png");
        BodySwapt = new Texture("body_swap.png");
        LeftLegSwapt = new Texture("leg_swap.png");
        RightLegSwapt = new Texture("leg_swap.png");
        LeftHandSwapt = new Texture("hand_swap.png");
        RightHandSwapt = new Texture("hand_swap.png");

        HeadHurtt = new Texture("head_hurt.png");
        BodyHurtt = new Texture("body_hurt.png");
        LeftLegHurtt = new Texture("leg_hurt.png");
        RightLegHurtt = new Texture("leg_hurt.png");
        LeftHandHurtt = new Texture("hand_hurt.png");
        RightHandHurtt = new Texture("hand_hurt.png");

        HeadDeadt = new Texture("head_dead.png");
        BodyDeadt = new Texture("body_dead.png");
        LeftLegDeadt = new Texture("leg_dead.png");
        RightLegDeadt = new Texture("leg_dead.png");
        LeftHandDeadt = new Texture("hand_dead.png");
        RightHandDeadt = new Texture("hand_dead.png");

        SelectRobot =  new TextureRegion(SelectRobott, 300, 300);
        Hide =  new TextureRegion(Hidet, 300, 300);
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
