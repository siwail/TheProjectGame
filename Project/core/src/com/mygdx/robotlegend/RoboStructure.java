package com.mygdx.robotlegend;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class RoboStructure {
    com.mygdx.robotlegend.MainGame game;
    public RoboStructure(MainGame game){ this.game = game; }
    int level = 0;
    int level_win = 1;
    int gears = 0;
    int microchips = 0;
    int lamps = 0;
    int metal = 0;
    int energy = 100;
    int Bhealth = 0;
    int Bdamage = 0;
    int Bmove_speed = 0;
    int Battack_speed = 0;
    int Benergy_speed = 0;
    int EBhealth = 0;
    int EBdamage = 0;
    int EBmove_speed = 0;
    int EBattack_speed = 0;
    int EBenergy_speed = 0;
    int jetpack = 1;
    int Hid = 1;
    int Bid = 1;
    int RHid = 1; //Правая рука
    int LHid = 1; //Левая рука
    int RLid = 1; //Правая нога
    int LLid = 1; //Левая нога
    int Hl = 1;
    int Bl = 4;
    int RHl = 1; //Правая рука
    int LHl = 1; //Левая рука
    int RLl = 1; //Правая нога
    int LLl = 1; //Левая нога
    int[] BBody = new int[5], BHead = new int[5], BHand = new int[5], BLeg = new int[5];
    int health = 0;
    int damage = 2;
    int attack_speed;
    int move_speed;
    int energy_speed;
    int experience = 0;
    int Ecolor = 2;
    int color = 2;
    int fire_damage = 2;
    boolean exp_process = false;
    boolean box_empty = true;
    int[] metal_chance = new int[4];
    int[] chip_chance = new int[4];
    int[] gear_chance = new int[4];
    int[] bulb_chance = new int[4];
    Texture alert;
    Texture[] ToBall_1t = new Texture[5];
    Texture[] ToBall_2t = new Texture[5];
    Texture[] ToBall_3t = new Texture[5];
    TextureRegion[] ToBall_1 = new TextureRegion[5];
    TextureRegion[] ToBall_2 = new TextureRegion[5];
    TextureRegion[] ToBall_3 = new TextureRegion[5];
    Texture[] jetpack_1 = new Texture[4];
    Texture[] jetpack_2 = new Texture[4];
    Texture jetpack_3;
    Texture Ball_1t;
    Texture Ball_2t;
    Texture contrast;
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
    Texture HeadDeadt;
    Texture BodyDeadt;
    Texture LeftLegDeadt;
    Texture RightLegDeadt;
    Texture LeftHandDeadt;
    Texture RightHandDeadt;
    Texture HeadEnergyt;
    Texture BodyEnergyt;
    Texture LeftLegEnergyt;
    Texture RightLegEnergyt;
    Texture LeftHandEnergyt;
    Texture RightHandEnergyt;
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

    Texture RobotHealth;
    Texture EnemyHealth;
    Texture puck;
    Texture RHt;
    Texture LHt;
    Texture RLt;
    Texture LLt;
    Texture Ht;
    Texture Bt;
    Texture ESRHt;
    Texture ESLHt;
    Texture ESRLt;
    Texture ESLLt;
    Texture ESHt;
    Texture ESBt;
    Texture SRHt;
    Texture SLHt;
    Texture SRLt;
    Texture SLLt;
    Texture SHt;
    Texture SBt;
    TextureRegion Ball_1;
    TextureRegion Ball_2;
    TextureRegion RH;
    TextureRegion LH;                                                                                               
    TextureRegion RL;
    TextureRegion LL;
    TextureRegion H;
    TextureRegion B;
    TextureRegion ESRH;
    TextureRegion ESLH;
    TextureRegion ESRL;
    TextureRegion ESLL;
    TextureRegion ESH;
    TextureRegion ESB;
    TextureRegion SRH;
    TextureRegion SLH;
    TextureRegion SRL;
    TextureRegion SLL;
    TextureRegion SH;
    TextureRegion SB;
    int Eskin = 0;
    int EHid = 1;
    int EBid = 1;
    int ERHid = 1;
    int ELHid = 1;
    int ERLid = 1;
    int ELLid = 1;
    int EHl = 1;
    int EBl = 1;
    int ERHl = 1;
    int ELHl = 1;
    int ERLl = 1;
    int ELLl = 1;
    int skin = 0;
    int Ehealth = 100;
    int Edamage;
    int Eattack_speed;
    int Emove_speed;
    int Eenergy_speed = 80-EBid*7;
    int max_skin = 9;
    int[] skins_open = new int[max_skin];
    int index_skin = 0;
    int opened = 6;
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
    public void ClearSafe(){
        gears = 1;
        microchips = 1;
        lamps = 1;
        metal = 1;
        level_win = 1;
        Hid = 1;
        Bid = 1;
        LHid = 1;
        RHid = 1;
        LLid = 1;
        RLid = 1;
        opened = 1;
        experience = 0;
        int i = 0;
        while(i!=opened){
            skins_open[i] = TakeSafe("skin_"+i, 0);
            i++;
        }
        Safe();
    }
    public void AddDetail(int detail, int model) {
        if (detail == 1) {
            BHead[model - 1] = 0;
        }
        if (detail == 2) {
            BBody[model - 1] = 0;
        }
        if (detail == 3) {
            BLeg[model - 1] = 0;
        }
        if (detail == 4) {
            BHand[model - 1] = 0;
        }
    }
    public boolean AllDetailsExist(){
       int d = 0;
       int m = 0;
       while(d<4){
           d++;
           while(m<4){
               m++;
                if(!DetailExist(d, m)){
                    return false;
                }
           }
       }
        return true;
    }
    public boolean DetailExist(int detail, int model){
        if(detail == 1){
            if(BHead[model - 1] != -1) {
                return true;
            }
        }
        if(detail == 2){
            if(BBody[model - 1] != -1) {
                return true;
            }
        }
        if(detail == 3){
            if(BLeg[model - 1] != -1) {
                return true;
            }
        }
        if(detail == 4){
            if(BHand[model - 1] != -1) {
                return true;
            }
        }
        return false;
    }
    public void AddBox(){
        box_empty = true;
    }
    public void UpdateParameters(){
        EClearSkinBust();
        ClearSkinBust();
        energy_speed = 90-(int)TR(1, Hid, Hl, 3);
        Eenergy_speed = 90-(int)TR(1, EHid, EHl, 3);
        attack_speed = 8-(int)TR(2, Bid, Bl, 4);
        Eattack_speed = 8-(int)TR(2, EBid, EBl, 4);
        move_speed = 11-((int)TR(3, LLid, LLl, 5)+(int)TR(3, RLid, RLl, 5));
        Emove_speed =11-((int)TR(3, ELLid, ELLl, 5)+(int)TR(3, ERLid, ERLl, 5));
        damage = (int)TR(4, LHid, LHl, 2)+(int)TR(3, RHid, RHl, 2);
        Edamage = (int)TR(4, ELHid, ELHl, 2)+(int)TR(3, ERHid, ERHl, 2);
        health = (int)TR(1, Hid, Hl, 1)+(int)TR(2, Bid, Bl, 1)+(int)TR(3, LLid, LLl, 1)+(int)TR(1, RLid, RLl, 1)+(int)TR(1, LHid, LHl, 1)+ (int)TR(1, RHid, RHl, 1);
        Ehealth = (int)TR(1, EHid, EHl, 1)+(int)TR(2, EBid, EBl, 1)+(int)TR(3, ELLid, ELLl, 1)+(int)TR(1, ERLid, ERLl, 1)+(int)TR(1, ELHid, ELHl, 1)+ (int)TR(1, ERHid, ERHl, 1);



        /*energy_speed = 90-Hid*10;
        Eenergy_speed = 90-EHid*10;
        attack_speed = 8-Bid;
        Eattack_speed = 8-EBid;
        move_speed = 11-RLid-LLid;
        Emove_speed = 11-ERLid-ELLid;
        damage = RHid*2+LHid*2;
        Edamage = ERHid*2+ELHid*2;
        health = Hid*10+Bid*15+RHid*5+LHid*5+RLid*5+LLid*5;
        Ehealth = EHid*10+EBid*15+ERHid*5+ELHid*5+ERLid*5+ELLid*5;*/

        ChangeSkinBust();
        EChangeSkinBust();
    }
    //TYPES: 1 - health; 2 - damage; 3 - energy; 4 - attack_speed; 5 - move_speed
    float TR(int part, int model, int level, int type){ //TakeRatio
        float lvl = level;
        float result = 0;
        if(part == 1){//head
            if(model == 1){
                if(type == 1){
                    result = 12.5f*lvl;
                }
                if(type == 3){
                    result = 8f*lvl;
                }
            }
            if(model == 2){
                if(type == 1){
                    result = 13.5f*lvl;
                }
                if(type == 3){
                    result = 8.5f*lvl;
                }
            }
            if(model == 3){
                if(type == 1){
                    result = 14.5f*lvl;
                }
                if(type == 3){
                    result = 9f*lvl;
                }
            }
            if(model == 4){
                if(type == 1){
                    result = 15.0f*lvl;
                }
                if(type == 3){
                    result = 9.5f*lvl;
                }
            }
            if(model == 5){
                if(type == 1){
                    result = 16.0f*lvl;
                }
                if(type == 3){
                    result = 10.0f*lvl;
                }
            }
        }
        if(part == 2){//body
            if(model == 1){
                if(type == 1){
                    result = 29.0f*lvl;
                }
                if(type == 4){
                    result = 1.0f*lvl;
                }
            }
            if(model == 2){
                if(type == 1){
                    result = 31.0f*lvl;
                }
                if(type == 4){
                    result = 1.2f*lvl;
                }
            }
            if(model == 3){
                if(type == 1){
                    result = 33.0f*lvl;
                }
                if(type == 4){
                    result = 1.35f*lvl;
                }
            }
            if(model == 4){
                if(type == 1){
                    result = 36.0f*lvl;
                }
                if(type == 4){
                    result = 1.4f*lvl;
                }
            }
            if(model == 5){
                if(type == 1){
                    result = 40.0f*lvl;
                }
                if(type == 4){
                    result = 1.5f*lvl;
                }
            }
        }
        if(part == 3){//leg
            if(model == 1){
                if(type == 1){
                    result = 13.0f*lvl;
                }
                if(type == 5){
                    result = 1.0f*lvl;
                }
            }
            if(model == 2){
                if(type == 1){
                    result = 15.0f*lvl;
                }
                if(type == 5){
                    result = 1.2f*lvl;
                }
            }
            if(model == 3){
                if(type == 1){
                    result = 16.0f*lvl;
                }
                if(type == 5){
                    result = 1.25f*lvl;
                }
            }
            if(model == 4){
                if(type == 1){
                    result = 19.0f*lvl;
                }
                if(type == 5){
                    result = 1.35f*lvl;
                }
            }
            if(model == 5){
                if(type == 1){
                    result = 22.0f*lvl;
                }
                if(type == 5){
                    result = 1.5f*lvl;
                }
            }
        }
        if(part == 4){//hand
            if(model == 1){
                if(type == 1){
                    result = 11.0f*lvl;
                }
                if(type == 2){
                    result = 3.6f*lvl;
                }
            }
            if(model == 2){
                if(type == 1){
                    result = 13.0f*lvl;
                }
                if(type == 2){
                    result = 4.0f*lvl;
                }
            }
            if(model == 3){
                if(type == 1){
                    result = 16.5f*lvl;
                }
                if(type == 2){
                    result = 4.5f*lvl;
                }
            }
            if(model == 4){
                if(type == 1){
                    result = 20.0f*lvl;
                }
                if(type == 2){
                    result = 4.9f*lvl;
                }
            }
            if(model == 5){
                if(type == 1){
                    result = 22.5f*lvl;
                }
                if(type == 2){
                    result = 5.5f*lvl;
                }
            }
        }
        return result;
    }
    public void SetWorkMenuTextures(){
        HeadSelectt = new Texture("Robot/head_select.png");
        BodySelectt = new Texture("Robot/body_select.png");
        LeftLegSelectt = new Texture("Robot/leg_select.png");
        RightLegSelectt = new Texture("Robot/leg_select.png");
        LeftHandSelectt = new Texture("Robot/hand_select.png");
        RightHandSelectt = new Texture("Robot/hand_select.png");
    }
    public void ChangeSkinBust(){
        if(skin == 0){
            color = 2;
        }
        if(skin == 1){
            color = 5;
            Bhealth = 40;
            Battack_speed = -1;
        }
        if(skin == 2){
            color = 1;
            Bmove_speed = -1;
            Battack_speed = -1;
        }
        if(skin == 3){
            color = 2;
            Bhealth = 30;
            Benergy_speed = -10;
        }
        if(skin == 4){
            color = 2;
            Bdamage = 2;
            Battack_speed = -1;
        }
        if(skin == 5){
            color = 1;
            Bdamage = 4;
            Benergy_speed = -20;
        }
        if(skin == 6){
            color = 3;
            Bhealth = 50;
            Benergy_speed = -5;
        }
        if(skin == 7){
            color = 3;
            Bhealth = 20;
            Bdamage = 4;
        }
        if(skin == 8){
            color = 5;
            Bhealth = 30;
            Bdamage = 6;
        }
        health+=Bhealth;
        damage+=Bdamage;
        move_speed+=Bmove_speed;
        attack_speed+=Battack_speed;
        energy_speed+=Benergy_speed;
    }
    public void EChangeSkinBust(){
        if(Eskin == 0){
            Ecolor = 2;
        }
        if(Eskin == 1){
            Ecolor = 5;
            EBhealth = 40;
            EBattack_speed = -1;
        }
        if(Eskin == 2){
            Ecolor = 1;
            EBmove_speed = -1;
            EBattack_speed = -1;
        }
        if(Eskin == 3){
            Ecolor = 2;
            EBhealth = 30;
            EBenergy_speed = -10;
        }
        if(Eskin == 4){
            Ecolor = 2;
            EBdamage = 2;
            EBattack_speed = -1;
        }
        if(Eskin == 5){
            Ecolor = 1;
            EBdamage = 4;
            EBenergy_speed = -20;
        }
        if(Eskin == 6){
            Ecolor = 3;
            EBhealth = 50;
            EBenergy_speed = -5;
        }
        if(Eskin == 7){
            Ecolor = 3;
            EBhealth = 20;
            EBdamage = 4;
        }
        if(Eskin == 8){
            Ecolor = 5;
            EBhealth = 30;
            EBdamage = 6;
        }
        Ehealth+=EBhealth;
        Edamage+=EBdamage;
        Emove_speed+=EBmove_speed;
        Eattack_speed+=EBattack_speed;
        Eenergy_speed+=EBenergy_speed;
    }
    public void ClearSkinBust(){
         health -= Bhealth;
         damage -= Bdamage;
         move_speed -= Bmove_speed;
         attack_speed -= Battack_speed;
         energy_speed -= Benergy_speed;
         Bhealth = 0;
         Bdamage = 0;
         Bmove_speed = 0;
         Battack_speed = 0;
         Benergy_speed = 0;
    }
    public void EClearSkinBust(){
        Ehealth -= EBhealth;
        Edamage -= EBdamage;
        Emove_speed -= EBmove_speed;
        Eattack_speed -= EBattack_speed;
        Eenergy_speed -= EBenergy_speed;
        EBhealth = 0;
        EBdamage = 0;
        EBmove_speed = 0;
        EBattack_speed = 0;
        EBenergy_speed = 0;
    }
    public void UpdateRobotTexture(int which_select){
        int Hlx = Hl, Blx = Bl, RHlx = RHl, LHlx = LHl, RLlx = RLl, LLlx = LLl;
        if(Hlx < 1){
            Hlx = 1;
        }
        if(Blx < 1){
            Blx = 1;
        }
        if(RHlx < 1){
            RHlx = 1;
        }
        if(LHlx < 1){
            LHlx = 1;
        }
        if(RLlx < 1){
            RLlx = 1;
        }
        if(LLlx < 1){
            LLlx = 1;
        }
        if(which_select == 1){
            Ht.dispose();
            Ht = new Texture("Robot/head_" + Hid + "_" + Hlx + ".png");
            H =  new TextureRegion(Ht, 300, 300);
        }
        if(which_select == 2){
            Bt.dispose();
            Bt = new Texture("Robot/body_" + Bid + "_" + Blx + ".png");
            B =  new TextureRegion(Bt, 300, 300);
        }
        if(which_select == 6){
            RHt.dispose();
            RHt = new Texture("Robot/hand_" + RHid + "_" + RHlx + ".png");
            RH =  new TextureRegion(RHt, 300, 300);
        }
        if(which_select == 5){
            LHt.dispose();
            LHt = new Texture("Robot/hand_" + LHid + "_" + LHlx + ".png");
            LH =  new TextureRegion(LHt, 300, 300);
        }
        if(which_select == 4){
            RLt.dispose();
            RLt = new Texture("Robot/leg_" + RLid + "_" + RLlx + ".png");
            RL =  new TextureRegion(RLt, 300, 300);
        }
        if(which_select == 3){
            LLt.dispose();
            LLt = new Texture("Robot/leg_" + LLid + "_" + LLlx + ".png");
            LL =  new TextureRegion(LLt, 300, 300);
        }
        UpdateParameters();
    }
    public void DisposeWorkMenuTextures(){
        HeadSelectt.dispose();
        BodySelectt.dispose();
        LeftLegSelectt.dispose();
        RightLegSelectt.dispose();
        LeftHandSelectt.dispose();
        RightHandSelectt.dispose();
    }
    public void SetGamePlayTextures(){
        for(int i=1;i<6; i++){ ToBall_1t[i-1] = new Texture("Robot/ball_1_" + i + ".png");  ToBall_1[i-1] = new TextureRegion(ToBall_1t[i-1], 200, 200);}
        for(int i=1;i<6; i++){ ToBall_2t[i-1] = new Texture("Robot/ball_2_" + i + ".png");  ToBall_2[i-1] = new TextureRegion(ToBall_2t[i-1], 200, 200);}
        for(int i=1;i<6; i++){ ToBall_3t[i-1] = new Texture("Robot/ball_3_" + i + ".png");  ToBall_3[i-1] = new TextureRegion(ToBall_3t[i-1], 200, 200);}
        Ball_2t = new Texture("Robot/ball_2.png");
        Ball_1t = new Texture("Robot/ball_1.png");
        Ball_1 = new TextureRegion(Ball_1t, 300, 300);
        Ball_2 = new TextureRegion(Ball_2t, 300, 300);
        Cross = new Texture("Object/aim.png");
        EBullet.dispose();
        Bullet.dispose();
        EBullet = new Texture("Object/bullet" + Ecolor + ".png");
        Bullet = new Texture("Object/bullet" + color + ".png");
        Energy = new Texture("Interface/energy.png");
        EnergyBack = new Texture("Interface/back_energy.png");
        EnergyFront = new Texture("Interface/front_energy.png");
        EnergyWarning1 = new Texture("Interface/front_energy_w1.png");
        EnergyWarning2 = new Texture("Interface/front_energy_w2.png");
        ESelect = new Texture("Interface/select.png");
        Select = new Texture("Interface/select2.png");
        BackHealth = new Texture("Interface/back_health.png");
        RobotIcon = new Texture("Interface/friend.png");
        EnemyIcon = new Texture("Interface/enemy.png");
        RobotHealth = new Texture("Interface/friend_health.png");
        EnemyHealth = new Texture("Interface/enemy_health.png");
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
        HeadEnergyt = new Texture("Robot/head_energy.png");
        BodyEnergyt = new Texture("Robot/body_energy.png");
        LeftLegEnergyt = new Texture("Robot/leg_energy.png");
        RightLegEnergyt = new Texture("Robot/leg_energy.png");
        LeftHandEnergyt = new Texture("Robot/hand_energy.png");
        RightHandEnergyt = new Texture("Robot/hand_energy.png");

        jetpack_1[0] = new Texture("Robot/jetpack_" + jetpack + "_left.png");
        jetpack_1[1] = new Texture("Robot/jetpack_" + jetpack + "_left_1.png");
        jetpack_1[2] = new Texture("Robot/jetpack_" + jetpack + "_left_2.png");
        jetpack_1[3] = new Texture("Robot/jetpack_" + jetpack + "_left_3.png");
        jetpack_2[0] = new Texture("Robot/jetpack_" + jetpack + "_right.png");
        jetpack_2[1] = new Texture("Robot/jetpack_" + jetpack + "_right_1.png");
        jetpack_2[2] = new Texture("Robot/jetpack_" + jetpack + "_right_2.png");
        jetpack_2[3] = new Texture("Robot/jetpack_" + jetpack + "_right_3.png");
        jetpack_3 = new Texture("Robot/jetpack_" + jetpack + ".png");
    }
    public void UpdatePuck() {
        puck.dispose();
        puck = new Texture("Object/gift_" + skin + ".png");
    }
    public void EUpdateSkin() {
        if (Eskin != 0) {
            ESRHt.dispose();
            ESLHt.dispose();
            ESRLt.dispose();
            ESLLt.dispose();
            ESHt.dispose();
            ESBt.dispose();
            ESRHt = new Texture("Robot/skin_hand_" + Eskin + ".png");
            ESLHt = new Texture("Robot/skin_hand_" + Eskin + ".png");
            ESRLt = new Texture("Robot/skin_leg_" + Eskin + ".png");
            ESLLt = new Texture("Robot/skin_leg_" + Eskin + ".png");
            ESHt = new Texture("Robot/skin_head_" + Eskin + ".png");
            ESBt = new Texture("Robot/skin_body_" + Eskin + ".png");
            ESRH = new TextureRegion(ESRHt, 300, 300);
            ESLH = new TextureRegion(ESLHt, 300, 300);
            ESRL = new TextureRegion(ESRLt, 300, 300);
            ESLL = new TextureRegion(ESLLt, 300, 300);
            ESH = new TextureRegion(ESHt, 300, 300);
            ESB = new TextureRegion(ESBt, 300, 300);


            UpdateParameters();
        }else{
            Ecolor = 2;
        }
        EBullet.dispose();
        EBullet = new Texture("Object/bullet" + Ecolor + ".png");

    }
    public void UpdateSkin(){
        if(skin != 0) {
            SRHt.dispose();
            SLHt.dispose();
            SRLt.dispose();
            SLLt.dispose();
            SHt.dispose();
            SBt.dispose();
            SRHt = new Texture("Robot/skin_hand_" + skin + ".png");
            SLHt = new Texture("Robot/skin_hand_" + skin + ".png");
            SRLt = new Texture("Robot/skin_leg_" + skin + ".png");
            SLLt = new Texture("Robot/skin_leg_" + skin + ".png");
            SHt = new Texture("Robot/skin_head_" + skin + ".png");
            SBt = new Texture("Robot/skin_body_" + skin + ".png");
            SRH = new TextureRegion(SRHt, 300, 300);
            SLH = new TextureRegion(SLHt, 300, 300);
            SRL = new TextureRegion(SRLt, 300, 300);
            SLL = new TextureRegion(SLLt, 300, 300);
            SH = new TextureRegion(SHt, 300, 300);
            SB = new TextureRegion(SBt, 300, 300);

            UpdateParameters();
        }else{
            color = 2;
        }
        Bullet.dispose();
        Bullet = new Texture("Object/bullet" + color + ".png");
    }
    public void UpdateSkins(){
        UpdatePuck();
        UpdateSkin();
    }
    public void Safe(){
        game.safes.clear();
        game.safes.putInteger("Hl", game.robot.Hl);
        game.safes.putInteger("Bl", game.robot.Bl);
        game.safes.putInteger("RHl", game.robot.RHl);
        game.safes.putInteger("LHl", game.robot.LHl);
        game.safes.putInteger("LLl", game.robot.LLl);
        game.safes.putInteger("RLl", game.robot.RLl);

        game.safes.putInteger("H", game.robot.Hid);
        game.safes.putInteger("B", game.robot.Bid);
        game.safes.putInteger("RH", game.robot.RHid);
        game.safes.putInteger("LH", game.robot.LHid);
        game.safes.putInteger("LL", game.robot.LLid);
        game.safes.putInteger("RL", game.robot.RLid);
        game.safes.putInteger("level", game.robot.level_win);
        game.safes.putInteger("gears", game.robot.gears);
        game.safes.putInteger("lamps", game.robot.lamps);
        game.safes.putInteger("microchips", game.robot.microchips);
        game.safes.putInteger("metal", game.robot.metal);
        game.safes.putInteger("opened", opened);
        game.safes.putInteger("experience", experience);
        int i = 0;
        while(i!=5){
            game.safes.putInteger("BBody_"+(i+1), game.robot.BBody[i]);
            game.safes.putInteger("BHead_"+(i+1), game.robot.BHead[i]);
            game.safes.putInteger("BHand_"+(i+1), game.robot.BHand[i]);
            game.safes.putInteger("BLeg_"+(i+1), game.robot.BLeg[i]);
            i++;
        }
        i = 0;
        while(i!=opened){
            game.safes.putInteger("skin_" + i, skins_open[i]);
            i++;
        }
        game.safes.flush();
    }
    public void DisposeGamePlayTextures(){
        for(int i=1;i<6; i++) ToBall_1t[i-1].dispose();
        for(int i=1;i<6; i++) ToBall_2t[i-1].dispose();
        for(int i=1;i<6; i++) ToBall_3t[i-1].dispose();
        Ball_1t.dispose();
        Ball_2t.dispose();
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
        HeadEnergyt.dispose();
        BodyEnergyt.dispose();
        LeftLegEnergyt.dispose();
        RightLegEnergyt.dispose();
        LeftHandEnergyt.dispose();
        RightHandEnergyt.dispose();
        jetpack_1[0].dispose();
        jetpack_1[1].dispose();
        jetpack_1[2].dispose();
        jetpack_1[3].dispose();
        jetpack_2[0].dispose();
        jetpack_2[1].dispose();
        jetpack_2[2].dispose();
        jetpack_2[3].dispose();
        jetpack_3.dispose();
    }
    public void SetFirstChanges(){
        metal_chance[0] = 60;
        metal_chance[1] = 20;
        metal_chance[2] = 10;
        metal_chance[3] = 10;

        chip_chance[0] = 10;
        chip_chance[1] = 60;
        chip_chance[2] = 20;
        chip_chance[3] = 10;

        gear_chance[0] = 20;
        gear_chance[1] = 10;
        gear_chance[2] = 20;
        gear_chance[3] = 50;

        bulb_chance[0] = 10;
        bulb_chance[1] = 10;
        bulb_chance[2] = 50;
        bulb_chance[3] = 30;

        EBullet = new Texture("Object/bullet" + Ecolor + ".png");
        Bullet = new Texture("Object/bullet" + color + ".png");
        alert = new Texture("Interface/alert.png");
        contrast = new Texture("Interface/contrast.png");
        level_win = TakeSafe("level");
        gears = TakeSafe("gears");
        microchips = TakeSafe("microchips");
        lamps = TakeSafe("lamps");
        metal = TakeSafe("metal");
        Hid = TakeSafe("H");
        Bid = TakeSafe("B");
        RHid = TakeSafe("RH");
        LHid = TakeSafe("LH");
        RLid = TakeSafe("RL");
        LLid = TakeSafe("LL");
        Hl = TakeSafe("Hl");
        Bl = TakeSafe("Bl");
        RHl = TakeSafe("RHl");
        LHl = TakeSafe("LHl");
        RLl = TakeSafe("RLl");
        LLl = TakeSafe("LLl");
        opened = TakeSafe("opened");
        experience = TakeSafe("experience");
        int i = 0;
        while(i!=opened){
            skins_open[i] = TakeSafe("skin_"+i);
            i++;
        }
        i = 0;
        while(i!=5){
            BBody[i] = TakeSafe("BBody_"+(i+1), 1);
            BHead[i] = TakeSafe("BHead_"+(i+1), 1);
            BHand[i] = TakeSafe("BHand_"+(i+1), 1);
            BLeg[i] = TakeSafe("BLeg_"+(i+1), 1);
            i++;
        }
        skins_open[0] = 0;
        skin = 0;
        index_skin = 0;
        UpdateParameters();
        level = game.random.nextInt(4)+1;
    }
    public void AddExperience(int num){
        int added = 0;
        exp_process = true;
            while (true) {
                if(added<num){
                    experience += 1;
                    added += 1;
                }else{
                    break;
                }
                if(experience>=level_win*100){
                    level_win+=1;
                    experience=0;
                }
                try {
                    Thread.sleep(10);
                } catch (Exception ignored) {
                }

            }
        exp_process = false;

    }
    public void AddSkin(int index){
        if(opened!=max_skin) {
            boolean accept = true;
                    int i = 0;
                    while(i<opened){
                        if (skins_open[i] == index) {
                            accept = false;
                            break;
                        }
                    i++;
                    }
            if(accept) {
                if(opened<max_skin) {
                    index_skin = i-1;
                    opened++;
                    skins_open[opened-1] = index;
                }
            }
        }
    }
    public int TakeSafe(String name){
        if(game.safes.contains(name)) {
            return game.safes.getInteger(name);
        }else{
            return 1;
        }
    }
    public int TakeSafe(String name, int def){
        if(game.safes.contains(name)) {
            return game.safes.getInteger(name);
        }else{
            return def;
        }
    }
    public void RandomEnemy(){
        int level_arm = level_win;
        if(level_win>48){
            level_arm = 48;
        }
        while(EHid+EBid+ERHid+ERLid+ELLid+ELHid!=level_arm+6&&EHl+EBl+ERHl+ERLl+ELLl+ELHl!=level_arm+6) {


            EHid = game.random.nextInt(5) + 1;
            EBid = game.random.nextInt(5) + 1;
            ERHid = game.random.nextInt(5) + 1; //Правая рука
            ELHid = game.random.nextInt(5) + 1; //Левая рука
            ERLid = game.random.nextInt(5) + 1; //Правая нога
            ELLid = game.random.nextInt(5) + 1; //Левая нога

            EHl = game.random.nextInt(5) + 1;
            EBl = game.random.nextInt(5) + 1;
            ERHl = game.random.nextInt(5) + 1; //Правая рука
            ELHl = game.random.nextInt(5) + 1; //Левая рука
            ERLl = game.random.nextInt(5) + 1; //Правая нога
            ELLl = game.random.nextInt(5) + 1; //Левая нога
        }
        ERHt.dispose();
        ELHt.dispose();
        ERLt.dispose();
        ELLt.dispose();
        EHt.dispose();
        EBt.dispose();
        ERHt =  new Texture("Robot/hand_" + ERHid + "_" + ERHl + ".png");
        ELHt = new Texture("Robot/hand_" + ELHid + "_" + ELHl + ".png");
        ERLt = new Texture("Robot/leg_" + ERLid + "_" + ERLl + ".png");
        ELLt = new Texture("Robot/leg_" + ELLid + "_" + ELLl + ".png");
        EHt = new Texture("Robot/head_" + EHid + "_" + EHl + ".png");
        EBt = new Texture("Robot/body_" + EBid + "_" + EBl + ".png");
        ERH =  new TextureRegion(ERHt, 300, 300);
        ELH =  new TextureRegion(ELHt, 300, 300);
        ERL =  new TextureRegion(ERLt, 300, 300);
        ELL =  new TextureRegion(ELLt, 300, 300);
        EH =  new TextureRegion(EHt, 300, 300);
        EB =  new TextureRegion(EBt, 300, 300);
        UpdateParameters();
    }
    public void UpdateTextures(){
        puck = new Texture("Object/gift_0.png");
        RHt =  new Texture("Robot/hand_" + RHid + "_" + RHl + ".png");
        LHt = new Texture("Robot/hand_" + LHid + "_" + LHl + ".png");
        RLt = new Texture("Robot/leg_" + RLid + "_" + RLl + ".png");
        LLt = new Texture("Robot/leg_" + LLid + "_" + LLl + ".png");
        Ht = new Texture("Robot/head_" + Hid + "_" + Hl + ".png");
        Bt = new Texture("Robot/body_" + Bid + "_" + Bl + ".png");
        RH =  new TextureRegion(RHt, 300, 300);
        LH =  new TextureRegion(LHt, 300, 300);
        RL =  new TextureRegion(RLt, 300, 300);
        LL =  new TextureRegion(LLt, 300, 300);
        H =  new TextureRegion(Ht, 300, 300);
        B =  new TextureRegion(Bt, 300, 300);
        ERHt =  new Texture("Robot/hand_" + ERHid + "_" + ERHl + ".png");
        ELHt = new Texture("Robot/hand_" + ELHid + "_" + ELHl + ".png");
        ERLt = new Texture("Robot/leg_" + ERLid + "_" + ERLl + ".png");
        ELLt = new Texture("Robot/leg_" + ELLid + "_" + ELLl + ".png");
        EHt = new Texture("Robot/head_" + EHid + "_" + EHl + ".png");
        EBt = new Texture("Robot/body_" + EBid + "_" + EBl + ".png");
        ERH =  new TextureRegion(ERHt, 300, 300);
        ELH =  new TextureRegion(ELHt, 300, 300);
        ERL =  new TextureRegion(ERLt, 300, 300);
        ELL =  new TextureRegion(ELLt, 300, 300);
        EH =  new TextureRegion(EHt, 300, 300);
        EB =  new TextureRegion(EBt, 300, 300);
        SRHt =  new Texture("Robot/skin_hand_1.png");
        SLHt = new Texture("Robot/skin_hand_1.png");
        SRLt = new Texture("Robot/skin_leg_1.png");
        SLLt = new Texture("Robot/skin_leg_1.png");
        SHt = new Texture("Robot/skin_head_1.png");
        SBt = new Texture("Robot/skin_body_1.png");
        SRH =  new TextureRegion(SRHt, 300, 300);
        SLH =  new TextureRegion(SLHt, 300, 300);
        SRL =  new TextureRegion(SRLt, 300, 300);
        SLL =  new TextureRegion(SLLt, 300, 300);
        SH =  new TextureRegion(SHt, 300, 300);
        SB =  new TextureRegion(SBt, 300, 300);
        ESRHt =  new Texture("Robot/skin_hand_1.png");
        ESLHt = new Texture("Robot/skin_hand_1.png");
        ESRLt = new Texture("Robot/skin_leg_1.png");
        ESLLt = new Texture("Robot/skin_leg_1.png");
        ESHt = new Texture("Robot/skin_head_1.png");
        ESBt = new Texture("Robot/skin_body_1.png");
        ESRH =  new TextureRegion(ESRHt, 300, 300);
        ESLH =  new TextureRegion(ESLHt, 300, 300);
        ESRL =  new TextureRegion(ESRLt, 300, 300);
        ESLL =  new TextureRegion(ESLLt, 300, 300);
        ESH =  new TextureRegion(ESHt, 300, 300);
        ESB =  new TextureRegion(ESBt, 300, 300);
    }
}
