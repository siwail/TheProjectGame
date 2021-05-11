package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class RoboStructure {
    MainGame game;
    public RoboStructure(MainGame game){ this.game = game; }
    int level = 0;
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
    Texture Cross;
    Texture EnergyBack;
    Texture Energy;
    Texture EnergyFront;
    Texture EnergyWarning1;
    Texture EnergyWarning2;
    Texture Bullet;
    Texture EBullet;
    Texture ESelect;
    Texture Select;
    Texture Hidet;
    Texture HeadDeadt;
    Texture BodyDeadt;
    Texture LeftLegDeadt;
    Texture RightLegDeadt;
    Texture LeftHandDeadt;
    Texture RightHandDeadt;
    Texture HeadSelectt;
    Texture BodySelectt;
    Texture LeftLegSelectt;
    Texture RightLegSelectt;
    Texture LeftHandSelectt;
    Texture RightHandSelectt;
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
   /* public void DisposeRobotTextures(){
        RHt.dispose();
        LHt.dispose();
        LHt.dispose();
        RLt.dispose();
        LLt.dispose();
        Ht.dispose();
        Bt.dispose();
    }*/
    public void SetWorkMenuTextures(){
        Hidet = new Texture("Interface/hide.png");
        HeadSelectt = new Texture("Robot/head_select.png");
        BodySelectt = new Texture("Robot/body_select.png");
        LeftLegSelectt = new Texture("Robot/leg_select.png");
        RightLegSelectt = new Texture("Robot/leg_select.png");
        LeftHandSelectt = new Texture("Robot/hand_select.png");
        RightHandSelectt = new Texture("Robot/hand_select.png");
        Hide =  new TextureRegion(Hidet, 300, 300);
    }
    public void DisposeWorkMenuTextures(){
        Hidet.dispose();
        HeadSelectt.dispose();
        BodySelectt.dispose();
        LeftLegSelectt.dispose();
        RightLegSelectt.dispose();
        LeftHandSelectt.dispose();
        RightHandSelectt.dispose();
    }
    public void SetGamePlayTextures(){
        Cross = new Texture("Object/aim.png");
        Energy = new Texture("Interface/energy.png");
        EnergyBack = new Texture("Interface/back_energy.png");
        EnergyFront = new Texture("Interface/front_energy.png");
        EnergyWarning1 = new Texture("Interface/front_energy_w1.png");
        EnergyWarning2 = new Texture("Interface/front_energy_w2.png");
        EBullet = new Texture("Object/bullet.png");
        Bullet = new Texture("Object/bullet2.png");
        ESelect = new Texture("Interface/select.png");
        Select = new Texture("Interface/select2.png");
        BackHealth = new Texture("Interface/back_health.png");
        RobotIcon = new Texture("Interface/friend.png");
        EnemyIcon = new Texture("Interface/enemy.png");
        RobotHealth = new Texture("Interface/friend_health.png");
        EnemyHealth = new Texture("Interface/enemy_health.png");
        RobotDetect = new Texture("Interface/friend_detect.png");
        EnemyDetect = new Texture("Interface/enemy_detect.png");
        HeadSwapt = new Texture("Robot/head_swap.png");
        BodySwapt = new Texture("Robot/body_swap.png");
        LeftLegSwapt = new Texture("Robot/leg_swap.png");
        RightLegSwapt = new Texture("Robot/leg_swap.png");
        LeftHandSwapt = new Texture("Robot/hand_swap.png");
        RightHandSwapt = new Texture("Robot/hand_swap.png");
        HeadHurtt = new Texture("Robot/head_hurt.png");
        BodyHurtt = new Texture("Robot/body_hurt.png");
        LeftLegHurtt = new Texture("Robot/leg_hurt.png");
        RightLegHurtt = new Texture("Robot/leg_hurt.png");
        LeftHandHurtt = new Texture("Robot/hand_hurt.png");
        RightHandHurtt = new Texture("Robot/hand_hurt.png");
        HeadDeadt = new Texture("Robot/head_dead.png");
        BodyDeadt = new Texture("Robot/body_dead.png");
        LeftLegDeadt = new Texture("Robot/leg_dead.png");
        RightLegDeadt = new Texture("Robot/leg_dead.png");
        LeftHandDeadt = new Texture("Robot/hand_dead.png");
        RightHandDeadt = new Texture("Robot/hand_dead.png");
    }
    public void DisposeGamePlayTextures(){
        Cross.dispose();
        Energy.dispose();
        EnergyBack.dispose();
        EnergyFront.dispose();
        EnergyWarning1.dispose();
        EnergyWarning2.dispose();
        EBullet.dispose();
        Bullet.dispose();
        ESelect.dispose();
        Select.dispose();
        BackHealth.dispose();
        RobotIcon.dispose();
        EnemyIcon.dispose();
        RobotHealth.dispose();
        EnemyHealth.dispose();
        RobotDetect.dispose();
        EnemyDetect.dispose();
        HeadSwapt.dispose();
        BodySwapt.dispose();
        LeftLegSwapt.dispose();
        RightLegSwapt.dispose();
        LeftHandSwapt.dispose();
        RightHandSwapt.dispose();
        HeadHurtt.dispose();
        BodyHurtt.dispose();
        LeftLegHurtt.dispose();
        RightLegHurtt.dispose();
        LeftHandHurtt.dispose();
        RightHandHurtt.dispose();
        HeadDeadt.dispose();
        BodyDeadt.dispose();
        LeftLegDeadt.dispose();
        RightLegDeadt.dispose();
        LeftHandDeadt.dispose();
        RightHandDeadt.dispose();
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
        level = game.random.nextInt(4)+1;
    }
    public void UpdateTextures(){
        RHt =  new Texture("Robot/hand_" + RHid + ".png");
        LHt = new Texture("Robot/hand_" + LHid + ".png");
        RLt = new Texture("Robot/leg_" + RLid + ".png");
        LLt = new Texture("Robot/leg_" + LLid + ".png");
        Ht = new Texture("Robot/head_" + Hid + ".png");
        Bt = new Texture("Robot/body_" + Bid + ".png");
        RH =  new TextureRegion(RHt, 300, 300);
        LH =  new TextureRegion(LHt, 300, 300);
        RL =  new TextureRegion(RLt, 300, 300);
        LL =  new TextureRegion(LLt, 300, 300);
        H =  new TextureRegion(Ht, 300, 300);
        B =  new TextureRegion(Bt, 300, 300);
        ERHt =  new Texture("Robot/hand_" + ERHid + ".png");
        ELHt = new Texture("Robot/hand_" + ELHid + ".png");
        ERLt = new Texture("Robot/leg_" + ERLid + ".png");
        ELLt = new Texture("Robot/leg_" + ELLid + ".png");
        EHt = new Texture("Robot/head_" + EHid + ".png");
        EBt = new Texture("Robot/body_" + EBid + ".png");
        ERH =  new TextureRegion(ERHt, 300, 300);
        ELH =  new TextureRegion(ELHt, 300, 300);
        ERL =  new TextureRegion(ERLt, 300, 300);
        ELL =  new TextureRegion(ELLt, 300, 300);
        EH =  new TextureRegion(EHt, 300, 300);
        EB =  new TextureRegion(EBt, 300, 300);
    }
}
