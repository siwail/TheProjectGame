package com.mygdx.robotlegend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
public class Openable implements Screen{
    MainGame game;
    BitmapFont item_font;
    BitmapFont resource_font;
    BitmapFont button_font;
    BitmapFont alert_font;
    BitmapFont tutorial_font;
    BitmapFont multiplayer_font;
    BitmapFont item_green_font;
    BitmapFont level_big_font;
    BitmapFont level_font;
    Texture door_left;
    Texture door_right;

    Thread door;
    SpriteBatchRubber drawer;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Decoration/main_font.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    public static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>:";
    boolean closed = false;
    boolean willClose = false;
    boolean isOpen = false;
    boolean pause = true;
    int type_close = 0;
    int width;
    int height;
    float wpw;
    float hph;
    int open_x = 0;
    public void Start(){
        door_left =  new Texture("Interface/door_1.png");
        door_right=  new Texture("Interface/door_2.png");

        width = 1741;
        height = 810;
        open_x = width/2;
        wpw = (float)Gdx.graphics.getWidth()/(float)width;
        hph = (float)Gdx.graphics.getHeight()/(float)height;
        parameter.size = (int)(35.0*wpw);
        parameter.characters = FONT_CHARACTERS;
        alert_font = generator.generateFont(parameter);
        alert_font.setColor(Color.WHITE);
        parameter.size = (int)(55.0*wpw);
        tutorial_font = generator.generateFont(parameter);
        tutorial_font.setColor(Color.WHITE);
        parameter.size = (int)(50.0*wpw);
        item_font = generator.generateFont(parameter);
        item_font.setColor(Color.WHITE);
        item_green_font = generator.generateFont(parameter);
        item_green_font.setColor(0, 140, 255, 1);
        parameter.size = (int)(100.0*wpw);
        button_font = generator.generateFont(parameter);
        button_font.setColor(Color.WHITE);
        parameter.size = (int)(150.0*wpw);
        resource_font = generator.generateFont(parameter);
        resource_font.setColor(0, 140, 255, 1);
        parameter.size = (int)(160.0*wpw);
        multiplayer_font = generator.generateFont(parameter);
        multiplayer_font.setColor(0, 140, 255, 1);
        parameter.size = (int)(40.0*wpw);
        level_font = generator.generateFont(parameter);
        level_font.setColor(Color.WHITE);
        parameter.size = (int)(65.0*wpw);
        level_big_font = generator.generateFont(parameter);
        level_big_font.setColor(Color.WHITE);

    }
    public void DrawBullet(SpriteBatchRubber drawer, int x, int y, int type) {
        if(type == 1) {
            drawer.draw(game.robot.Bullet, x, y, 25, 20);
            drawer.draw(game.robot.Select, x-5, y-5, 35, 30);
        }else{
            drawer.draw(game.robot.EBullet, x, y, 25, 20);
            drawer.draw(game.robot.ESelect, x-5, y-5, 35, 30);
        }
    }
    public void DrawEnergy(SpriteBatchRubber drawer, int x, int y, float scale, int energy, int energy_warning) {
        Texture front = game.robot.EnergyFront;
        if(energy_warning == 1){
            front = game.robot.EnergyWarning1;
        }
        if(energy_warning == 2){
            front = game.robot.EnergyWarning2;
        }
        drawer.draw(game.robot.EnergyBack, x, y, (int)(200*scale), (int)(200*scale));
        drawer.draw(game.robot.Energy, x+(game.robot.energy-energy)/3, y, (int)(200*((float)energy/(float)game.robot.energy)*scale), (int)(200*scale));
        drawer.draw(front, x, y, (int)(200*scale), (int)(200*scale));

    }
    public void DrawSelect(SpriteBatchRubber drawer, int x, int y, float scale, float rothand, float rothead, float rotleg, float rot, int which_select) {
        TextureRegion Head;
        TextureRegion Body;
        TextureRegion LeftLeg;
        TextureRegion RightLeg;
        TextureRegion LeftHand;
        TextureRegion RightHand;
        if(which_select == 1){
            Head = new TextureRegion(game.robot.HeadSelectt, 300, 300);
            drawer.draw(Head, x, (float) (y + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rothead);
        }
        if(which_select == 2){
            Body = new TextureRegion(game.robot.BodySelectt, 300, 300);
            drawer.draw(Body, x, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rot);
        }
        if(which_select == 3){
            LeftLeg = new TextureRegion(game.robot.LeftLegSelectt, 300, 300);
            drawer.draw(LeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  -rotleg);
        }
        if(which_select == 4){
            RightLeg = new TextureRegion(game.robot.RightLegSelectt, 300, 300);
            drawer.draw(RightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rotleg);
        }
        if(which_select == 5){
            LeftHand = new TextureRegion(game.robot.LeftHandSelectt, 300, 300);
            drawer.draw(LeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand);
        }
        if(which_select == 6){
            RightHand = new TextureRegion(game.robot.RightHandSelectt, 300, 300);
            drawer.draw(RightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand);
        }
    }
    public void DrawAlert(SpriteBatchRubber drawer, int x,  int y, String text_1, String text_2, int plus_x){
        drawer.draw(game.robot.alert, width-400+x, y, 400, 200);
        alert_font.draw(drawer.batch, text_1, (int)((width-300+x+plus_x)*wpw), (int)((y+125)*hph));
        alert_font.draw(drawer.batch, text_2, (int)((width-300+x+plus_x)*wpw), (int)((y+90)*hph));
    }
    public void DrawRobotDead(SpriteBatchRubber drawer, int x, int y, float scale, float rothand, float rothead, float rotleg, float rot, int rotate, int dead_state) {
        TextureRegion Head = game.robot.H;
        TextureRegion Body = game.robot.B;
        TextureRegion LeftLeg = game.robot.LL;
        TextureRegion RightLeg = game.robot.RL;
        TextureRegion LeftHand = game.robot.LH;
        TextureRegion RightHand = game.robot.RH;
        TextureRegion SHead = game.robot.SH;
        TextureRegion SBody = game.robot.SB;
        TextureRegion SLeftLeg = game.robot.SLL;
        TextureRegion SRightLeg = game.robot.SRL;
        TextureRegion SLeftHand = game.robot.SLH;
        TextureRegion SRightHand = game.robot.SRH;
        float state;
        if(game.robot.level!=2) {
            state = dead_state * 8;
        }else{
            state = dead_state * 4;
        }
        drawer.draw(Head, x, (float) (y+state + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rothead - rotate-dead_state);
        if(game.robot.skin!=0) {
            drawer.draw(SHead, x, (float) (y+state + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rothead - rotate-dead_state);
        }
        float v = y - state + 170 * scale;
        drawer.draw(Body, x-state, (float) v, 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rot-dead_state);
        if(game.robot.skin!=0) {
            drawer.draw(SBody, x-state, (float) v, 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rot-dead_state);
        }
        drawer.draw(LeftLeg, (float) (x+state - 50 * scale), y-state, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  -rotleg+dead_state);
        if(game.robot.skin!=0) {
            drawer.draw(SLeftLeg, (float) (x+state - 50 * scale), y-state, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  -rotleg+dead_state);
        }
        drawer.draw(RightLeg, (float) (x-state + 50 * scale), y+state, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rotleg-dead_state);
        if(game.robot.skin!=0) {
            drawer.draw(SRightLeg, (float) (x-state + 50 * scale), y+state, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rotleg-dead_state);
        }
        drawer.draw(LeftHand, (float) (x-state + 90 * scale), (float) v, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand+dead_state);
        if(game.robot.skin!=0) {
            drawer.draw(SLeftHand, (float) (x-state + 90 * scale), (float) v, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand+dead_state);
        }
        drawer.draw(RightHand, (float) (x+state - 90 * scale), (float) (y+state + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand - 90 + rotate-dead_state);
        if(game.robot.skin!=0) {
            drawer.draw(SRightHand, (float) (x+state - 90 * scale), (float) (y+state + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand - 90 + rotate-dead_state);
        }}
    public void DrawRobot(SpriteBatchRubber drawer, int x, int y, float scale, float rothand, float rothead, float rotleg, float rot, boolean swap, boolean hurt, boolean dead, int rotate) {
        TextureRegion Head = game.robot.H;
        TextureRegion Body = game.robot.B;
        TextureRegion LeftLeg = game.robot.LL;
        TextureRegion RightLeg = game.robot.RL;
        TextureRegion LeftHand = game.robot.LH;
        TextureRegion RightHand = game.robot.RH;
        TextureRegion SHead = game.robot.SH;
        TextureRegion SBody = game.robot.SB;
        TextureRegion SLeftLeg = game.robot.SLL;
        TextureRegion SRightLeg = game.robot.SRL;
        TextureRegion SLeftHand = game.robot.SLH;
        TextureRegion SRightHand = game.robot.SRH;
        if(swap) {
            Head = new TextureRegion(game.robot.HeadSwapt, 300, 300);
            Body = new TextureRegion(game.robot.BodySwapt, 300, 300);
            LeftLeg = new TextureRegion(game.robot.LeftLegSwapt, 300, 300);
            RightLeg = new TextureRegion(game.robot.RightLegSwapt, 300, 300);
            LeftHand = new TextureRegion(game.robot.LeftHandSwapt, 300, 300);
            RightHand = new TextureRegion(game.robot.RightHandSwapt, 300, 300);
        }
        if(hurt) {
            Head = new TextureRegion(game.robot.HeadHurtt, 300, 300);
            Body = new TextureRegion(game.robot.BodyHurtt, 300, 300);
            LeftLeg = new TextureRegion(game.robot.LeftLegHurtt, 300, 300);
            RightLeg = new TextureRegion(game.robot.RightLegHurtt, 300, 300);
            LeftHand = new TextureRegion(game.robot.LeftHandHurtt, 300, 300);
            RightHand = new TextureRegion(game.robot.RightHandHurtt, 300, 300);
        }
        if(dead) {
            Head = new TextureRegion(game.robot.HeadDeadt, 300, 300);
            Body = new TextureRegion(game.robot.BodyDeadt, 300, 300);
            LeftLeg = new TextureRegion(game.robot.LeftLegDeadt, 300, 300);
            RightLeg = new TextureRegion(game.robot.RightLegDeadt, 300, 300);
            LeftHand = new TextureRegion(game.robot.LeftHandDeadt, 300, 300);
            RightHand = new TextureRegion(game.robot.RightHandDeadt, 300, 300);
        }
        drawer.draw(Head, x, (float) (y + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rothead);
        if(game.robot.skin!=0 && !dead) {
            drawer.draw(SHead, x, (float) (y + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, rothead);
        }
        drawer.draw(Body, x, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rot);
        if(game.robot.skin!=0 && !dead) {
            drawer.draw(SBody, x, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, rot);
        }
        drawer.draw(LeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  -rotleg);
        if(game.robot.skin!=0 && !dead) {
            drawer.draw(SLeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, -rotleg);
        }
        drawer.draw(RightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rotleg);
        if(game.robot.skin!=0 && !dead) {
            drawer.draw(SRightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rotleg);
        }
        drawer.draw(LeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand);
        if(game.robot.skin!=0 && !dead) {
            drawer.draw(SLeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rothand);
        }
        drawer.draw(RightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand - 90 + rotate);
        if(game.robot.skin!=0 && !dead) {
            drawer.draw(SRightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rothand - 90 + rotate);
        }
    }
    public void DrawRobotJetpack(SpriteBatchRubber drawer, int x, int y, float scale, float rothand, float rothead, float rotleg, float rot, int rotate, int fire_state, int jetpack_state, boolean swap, boolean hurt ) {
        TextureRegion Head = game.robot.H;
        TextureRegion Body = game.robot.B;
        TextureRegion LeftLeg = game.robot.LL;
        TextureRegion RightLeg = game.robot.RL;
        TextureRegion LeftHand = game.robot.LH;
        TextureRegion RightHand = game.robot.RH;
        TextureRegion SHead = game.robot.SH;
        TextureRegion SBody = game.robot.SB;
        TextureRegion SLeftLeg = game.robot.SLL;
        TextureRegion SRightLeg = game.robot.SRL;
        TextureRegion SLeftHand = game.robot.SLH;
        TextureRegion SRightHand = game.robot.SRH;
        TextureRegion jetpack_1;
        TextureRegion jetpack_2;
        if(swap) {
            Head = new TextureRegion(game.robot.HeadSwapt, 300, 300);
            Body = new TextureRegion(game.robot.BodySwapt, 300, 300);
            LeftLeg = new TextureRegion(game.robot.LeftLegSwapt, 300, 300);
            RightLeg = new TextureRegion(game.robot.RightLegSwapt, 300, 300);
            LeftHand = new TextureRegion(game.robot.LeftHandSwapt, 300, 300);
            RightHand = new TextureRegion(game.robot.RightHandSwapt, 300, 300);
        }
        if(hurt) {
            Head = new TextureRegion(game.robot.HeadHurtt, 300, 300);
            Body = new TextureRegion(game.robot.BodyHurtt, 300, 300);
            LeftLeg = new TextureRegion(game.robot.LeftLegHurtt, 300, 300);
            RightLeg = new TextureRegion(game.robot.RightLegHurtt, 300, 300);
            LeftHand = new TextureRegion(game.robot.LeftHandHurtt, 300, 300);
            RightHand = new TextureRegion(game.robot.RightHandHurtt, 300, 300);
        }
        if(jetpack_state>=170) {
            jetpack_1 = new TextureRegion(game.robot.jetpack_1[fire_state], 300, 300);
            jetpack_2 = new TextureRegion(game.robot.jetpack_2[fire_state], 300, 300);
        }else{
            jetpack_1 = new TextureRegion(game.robot.jetpack_1[0], 300, 300);
            jetpack_2 = new TextureRegion(game.robot.jetpack_2[0], 300, 300);
        }
        TextureRegion jetpack_3 = new TextureRegion(game.robot.jetpack_3, 300, 300);
        drawer.draw(Head, x, (float) (y + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rothead);
        if(game.robot.skin!=0) {
            drawer.draw(SHead, x, (float) (y + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, rothead);
        }
        if(game.robot.jetpack == 1) {
            drawer.draw(jetpack_1, x - (jetpack_state - 30) * scale, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, rot);
            drawer.draw(jetpack_2, x + (jetpack_state - 30) * scale, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, rot);
        }
        if(game.robot.jetpack == 2) {
            drawer.draw(jetpack_1, x - (jetpack_state*1.5f - 30) * scale, (float) (y + 170 * scale), 150, 25, (float) ((200+jetpack_state/2) * scale), (float) ((200+jetpack_state/2) * scale), 1, 1, rot);
            drawer.draw(jetpack_2, x + (jetpack_state - 30) * scale, (float) (y + 170 * scale), 150, 25, (float) ((200+jetpack_state/2) * scale), (float) ((200+jetpack_state/2) * scale), 1, 1, rot);
        }
        drawer.draw(jetpack_3, (float)(x+(200-jetpack_state)/2), (float) (y + 170 * scale), 150, 25, (float) (jetpack_state * scale ), (float) (jetpack_state * scale ), 1, 1,  rot);
        drawer.draw(Body, x, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rot);
        if(game.robot.skin!=0) {
            drawer.draw(SBody, x, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, rot);
        }
        drawer.draw(LeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  -rotleg);
        if(game.robot.skin!=0) {
            drawer.draw(SLeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, -rotleg);
        }
        drawer.draw(RightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rotleg);
        if(game.robot.skin!=0) {
            drawer.draw(SRightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rotleg);
        }
        drawer.draw(LeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand);
        if(game.robot.skin!=0) {
            drawer.draw(SLeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rothand);
        }
        drawer.draw(RightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand - 90 + rotate);
        if(game.robot.skin!=0) {
            drawer.draw(SRightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rothand - 90 + rotate);
        }
    }
    public void DrawRobotBall(SpriteBatchRubber drawer, int x, int y, float scale, float rothand, float rothead, float rotleg, float rotate, float ball) {
        TextureRegion Head = game.robot.H;
        TextureRegion Body = game.robot.B;
        TextureRegion LeftLeg = game.robot.LL;
        TextureRegion RightLeg = game.robot.RL;
        TextureRegion LeftHand = game.robot.LH;
        TextureRegion RightHand = game.robot.RH;
        if(ball>1.0f){
            ball=1.0f;
        }
        if(ball>0.3f && ball <0.4f) {
            LeftLeg = game.robot.ToBall_1[game.robot.LLid-1];
            RightLeg = game.robot.ToBall_1[game.robot.RLid-1];
            LeftHand = game.robot.ToBall_1[game.robot.LHid-1];
            RightHand = game.robot.ToBall_1[game.robot.RHid-1];
        }
        if(ball>0.4f && ball <0.6f) {
            LeftLeg = game.robot.ToBall_2[game.robot.LLid-1];
            RightLeg = game.robot.ToBall_2[game.robot.RLid-1];
            LeftHand = game.robot.ToBall_2[game.robot.LHid-1];
            RightHand = game.robot.ToBall_2[game.robot.RHid-1];
        }
        if(ball>0.6f && ball <0.9f) {
            LeftLeg = game.robot.ToBall_3[game.robot.LLid-1];
            RightLeg = game.robot.ToBall_3[game.robot.RLid-1];
            LeftHand = game.robot.ToBall_3[game.robot.LHid-1];
            RightHand = game.robot.ToBall_3[game.robot.RHid-1];
        }
        TextureRegion SHead = game.robot.SH;
        TextureRegion SBody = game.robot.SB;
        TextureRegion SLeftLeg = game.robot.SLL;
        TextureRegion SRightLeg = game.robot.SRL;
        TextureRegion SLeftHand = game.robot.SLH;
        TextureRegion SRightHand = game.robot.SRH;
                if(ball==1.0f) {
                    drawer.draw(game.robot.Ball_2, (float) (x - 50 * scale), (float) (y), (float) (150 * scale), (float) (150 * scale), (float) (300 * scale), (float) (300 * scale), 1, 1, rotate, true);
                }
                if(ball>0.6f &&  ball<1.0f) {
                    drawer.draw(game.robot.Ball_1, (float) (x - 50 * scale), (float) (y), (float) (150 * scale), (float) (150 * scale), (float) (300 * scale), (float) (300 * scale), 1, 1, rotate, true);
                }
                if(ball<=0.9f) {
                    drawer.draw(Head, x, (float) (y + (335-(int)(220*ball)-(int)(110*ball)) * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, rothead);
                    if (game.robot.skin != 0) {
                        drawer.draw(SHead, x, (float) (y + 335 * scale), 150, 25, (float) ((200 - 200 * ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, rothead);
                    }
                    drawer.draw(Body, x, (float) (y + ((170-(int)(170*ball)) * scale)), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, 0);
                    if (game.robot.skin != 0) {
                        drawer.draw(SBody, x, (float) (y + 170 * scale), 150, 25, (float) ((200 - 200 *  ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, 0);
                    }
                    drawer.draw(LeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, -rotleg - ball * 180.0f * -1);
                    if (game.robot.skin != 0) {
                        drawer.draw(SLeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) ((200 - 200 * ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, -rotleg - ball * 180.0f * -1);
                    }
                    drawer.draw(RightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rotleg + ball * 180.0f * -1);
                    if (game.robot.skin != 0) {
                        drawer.draw(SRightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) ((200 - 200 * ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, rotleg - ball * 180.0f * -1);
                    }
                    final float v = y + (170.0f - (170 * ball)) * scale;
                    drawer.draw(LeftHand, (float) (x + 90 * scale), (float) v, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rothand - ball * 180.0f * -1);
                    if (game.robot.skin != 0) {
                        drawer.draw(SLeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) ((200 - 200 * ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, rothand - ball * 180.0f * -1);
                    }
                    drawer.draw(RightHand, (float) (x - 90 * scale), (float) v, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rothand - 90 - ball * 100.0f * -1);
                    if (game.robot.skin != 0) {
                        drawer.draw(SRightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) ((200 - 200 * ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, rothand - 90 - ball * 110.0f * -1);
                    }
                }
    }
    public void DrawEnemyBall(SpriteBatchRubber drawer, int x, int y, float scale, float rothand, float rothead, float rotleg, float rotate, float ball) {
        TextureRegion Head = game.robot.EH;
        TextureRegion Body = game.robot.EB;
        TextureRegion LeftLeg = game.robot.ELL;
        TextureRegion RightLeg = game.robot.ERL;
        TextureRegion LeftHand = game.robot.ELH;
        TextureRegion RightHand = game.robot.ERH;
        if(ball>1.0f){
            ball=1.0f;
        }
        if(ball>0.3f && ball <0.4f) {
            LeftLeg = game.robot.ToBall_1[game.robot.ELLid-1];
            RightLeg = game.robot.ToBall_1[game.robot.ERLid-1];
            LeftHand = game.robot.ToBall_1[game.robot.ELHid-1];
            RightHand = game.robot.ToBall_1[game.robot.ERHid-1];
        }
        if(ball>0.4f && ball <0.6f) {
            LeftLeg = game.robot.ToBall_2[game.robot.ELLid-1];
            RightLeg = game.robot.ToBall_2[game.robot.ERLid-1];
            LeftHand = game.robot.ToBall_2[game.robot.ELHid-1];
            RightHand = game.robot.ToBall_2[game.robot.ERHid-1];
        }
        if(ball>0.6f && ball <0.9f) {
            LeftLeg = game.robot.ToBall_3[game.robot.ELLid-1];
            RightLeg = game.robot.ToBall_3[game.robot.ERLid-1];
            LeftHand = game.robot.ToBall_3[game.robot.ELHid-1];
            RightHand = game.robot.ToBall_3[game.robot.ERHid-1];
        }
        TextureRegion SHead = game.robot.ESH;
        TextureRegion SBody = game.robot.ESB;
        TextureRegion SLeftLeg = game.robot.ESLL;
        TextureRegion SRightLeg = game.robot.ESRL;
        TextureRegion SLeftHand = game.robot.ESLH;
        TextureRegion SRightHand = game.robot.ESRH;
        if(ball==1.0f) {
            drawer.draw(game.robot.Ball_2, (float) (x - 50 * scale), (float) (y), (float) (150 * scale), (float) (150 * scale), (float) (300 * scale), (float) (300 * scale), 1, 1, rotate, true);
        }
        if(ball>0.6f &&  ball<1.0f) {
            drawer.draw(game.robot.Ball_1, (float) (x - 50 * scale), (float) (y), (float) (150 * scale), (float) (150 * scale), (float) (300 * scale), (float) (300 * scale), 1, 1, rotate, true);
        }
        if(ball<=0.9f) {
            drawer.draw(Head, x, (float) (y + (335-(int)(220*ball)-(int)(110*ball)) * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, rothead);
            if (game.robot.Eskin != 0) {
                drawer.draw(SHead, x, (float) (y + 335 * scale), 150, 25, (float) ((200 - 200 * ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, rothead);
            }
            drawer.draw(Body, x, (float) (y + ((170-(int)(170*ball)) * scale)), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, 0);
            if (game.robot.Eskin != 0) {
                drawer.draw(SBody, x, (float) (y + 170 * scale), 150, 25, (float) ((200 - 200 *  ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, 0);
            }
            drawer.draw(LeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, -rotleg - ball * 180.0f * -1);
            if (game.robot.Eskin != 0) {
                drawer.draw(SLeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) ((200 - 200 * ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, -rotleg - ball * 180.0f * -1);
            }
            drawer.draw(RightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rotleg + ball * 180.0f * -1);
            if (game.robot.Eskin != 0) {
                drawer.draw(SRightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) ((200 - 200 * ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, rotleg - ball * 180.0f * -1);
            }
            final float v = y + (170.0f - (170 * ball)) * scale;
            drawer.draw(LeftHand, (float) (x + 90 * scale), (float) v, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rothand - ball * 180.0f * -1);
            if (game.robot.Eskin != 0) {
                drawer.draw(SLeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) ((200 - 200 * ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, rothand - ball * 180.0f * -1);
            }
            drawer.draw(RightHand, (float) (x - 90 * scale), (float) v, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rothand - 90 - ball * 100.0f * -1);
            if (game.robot.Eskin != 0) {
                drawer.draw(SRightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) ((200 - 200 * ball) * scale), (float) ((200 - 200 * ball) * scale), 1, 1, rothand - 90 - ball * 110.0f * -1);
            }
        }
    }
    public void DrawEnemyDead(SpriteBatchRubber drawer, int x, int y, float scale, float rothand, float rothead, float rotleg, float rot, int rotate, int dead_state) {
        TextureRegion Head = game.robot.EH;
        TextureRegion Body = game.robot.EB;
        TextureRegion LeftLeg = game.robot.ELL;
        TextureRegion RightLeg = game.robot.ERL;
        TextureRegion LeftHand = game.robot.ELH;
        TextureRegion RightHand = game.robot.ERH;
        TextureRegion SHead = game.robot.ESH;
        TextureRegion SBody = game.robot.ESB;
        TextureRegion SLeftLeg = game.robot.ESLL;
        TextureRegion SRightLeg = game.robot.ESRL;
        TextureRegion SLeftHand = game.robot.ESLH;
        TextureRegion SRightHand = game.robot.ESRH;
        float state;
        if(game.robot.level!=2) {
            state = dead_state * 8;
        }else{
            state = dead_state * 4;
        }
        drawer.draw(Head, x, (float) (y+state + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rothead - rotate-dead_state);
        if(game.robot.Eskin!=0) {
            drawer.draw(SHead, x, (float) (y+state + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rothead - rotate-dead_state);
        }
        float v = y - state + 170 * scale;
        drawer.draw(Body, x-state, (float) v, 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rot-dead_state);
        if(game.robot.Eskin!=0) {
            drawer.draw(SBody, x-state, (float) v, 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rot-dead_state);
        }
        drawer.draw(LeftLeg, (float) (x+state - 50 * scale), y-state, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  -rotleg+dead_state);
        if(game.robot.Eskin!=0) {
            drawer.draw(SLeftLeg, (float) (x+state - 50 * scale), y-state, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  -rotleg+dead_state);
        }
        drawer.draw(RightLeg, (float) (x-state + 50 * scale), y+state, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rotleg-dead_state);
        if(game.robot.Eskin!=0) {
            drawer.draw(SRightLeg, (float) (x-state + 50 * scale), y+state, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rotleg-dead_state);
        }
        drawer.draw(LeftHand, (float) (x-state + 90 * scale), (float) v, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand+dead_state);
        if(game.robot.Eskin!=0) {
            drawer.draw(SLeftHand, (float) (x-state + 90 * scale), (float) v, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand+dead_state);
        }
        drawer.draw(RightHand, (float) (x+state - 90 * scale), (float) (y+state + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand - 90 + rotate-dead_state);
        if(game.robot.Eskin!=0) {
            drawer.draw(SRightHand, (float) (x+state - 90 * scale), (float) (y+state + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand - 90 + rotate-dead_state);
        }

    }
    public void DrawEnemy(SpriteBatchRubber drawer, int x, int y, float scale, float rothand, float rothead, float rotleg, float rot, boolean swap, boolean hurt, boolean dead) {
        TextureRegion Head = game.robot.EH;
        TextureRegion Body = game.robot.EB;
        TextureRegion LeftLeg = game.robot.ELL;
        TextureRegion RightLeg = game.robot.ERL;
        TextureRegion LeftHand = game.robot.ELH;
        TextureRegion RightHand = game.robot.ERH;
        TextureRegion SHead = game.robot.ESH;
        TextureRegion SBody = game.robot.ESB;
        TextureRegion SLeftLeg = game.robot.ESLL;
        TextureRegion SRightLeg = game.robot.ESRL;
        TextureRegion SLeftHand = game.robot.ESLH;
        TextureRegion SRightHand = game.robot.ESRH;
        if(swap) {
            Head = new TextureRegion(game.robot.HeadSwapt, 300, 300);
            Body = new TextureRegion(game.robot.BodySwapt, 300, 300);
            LeftLeg = new TextureRegion(game.robot.LeftLegSwapt, 300, 300);
            RightLeg = new TextureRegion(game.robot.RightLegSwapt, 300, 300);
            LeftHand = new TextureRegion(game.robot.LeftHandSwapt, 300, 300);
            RightHand = new TextureRegion(game.robot.RightHandSwapt, 300, 300);
        }
        if(hurt) {
            Head = new TextureRegion(game.robot.HeadHurtt, 300, 300);
            Body = new TextureRegion(game.robot.BodyHurtt, 300, 300);
            LeftLeg = new TextureRegion(game.robot.LeftLegHurtt, 300, 300);
            RightLeg = new TextureRegion(game.robot.RightLegHurtt, 300, 300);
            LeftHand = new TextureRegion(game.robot.LeftHandHurtt, 300, 300);
            RightHand = new TextureRegion(game.robot.RightHandHurtt, 300, 300);
        }
        if(dead) {
            Head = new TextureRegion(game.robot.HeadDeadt, 300, 300);
            Body = new TextureRegion(game.robot.BodyDeadt, 300, 300);
            LeftLeg = new TextureRegion(game.robot.LeftLegDeadt, 300, 300);
            RightLeg = new TextureRegion(game.robot.RightLegDeadt, 300, 300);
            LeftHand = new TextureRegion(game.robot.LeftHandDeadt, 300, 300);
            RightHand = new TextureRegion(game.robot.RightHandDeadt, 300, 300);
        }
        drawer.draw(Head, x, (float) (y + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rothead);
        if(game.robot.Eskin!=0 && !dead) {
            drawer.draw(SHead, x, (float) (y + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, rothead);
        }
        drawer.draw(Body, x, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1,  rot);
        if(game.robot.Eskin!=0 && !dead) {
            drawer.draw(SBody, x, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, rot);
        }
        drawer.draw(LeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  -rotleg);
        if(game.robot.Eskin!=0 && !dead) {
            drawer.draw(SLeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, -rotleg);
        }
        drawer.draw(RightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rotleg);
        if(game.robot.Eskin!=0 && !dead) {
            drawer.draw(SRightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rotleg);
        }
        drawer.draw(LeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand);
        if(game.robot.Eskin!=0 && !dead) {
            drawer.draw(SLeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rothand);
        }
        drawer.draw(RightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1,  rothand - 90 + rot);
        if(game.robot.Eskin!=0 && !dead) {
            drawer.draw(SRightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, rothand - 90 + rot);
        }
    }
    public void DrawEnergyCircle(SpriteBatchRubber drawer, int x, int y, float scale, float rothand, float rothead, float rotleg, float rot, int size, boolean robot_circle){
        if(robot_circle) {
            TextureRegion Head = new TextureRegion(game.robot.HeadEnergyt, 300, 300);
            TextureRegion Body = new TextureRegion(game.robot.BodyEnergyt, 300, 300);
            TextureRegion LeftLeg = new TextureRegion(game.robot.LeftLegEnergyt, 300, 300);
            TextureRegion RightLeg = new TextureRegion(game.robot.RightLegEnergyt, 300, 300);
            TextureRegion LeftHand = new TextureRegion(game.robot.LeftHandEnergyt, 300, 300);
            TextureRegion RightHand = new TextureRegion(game.robot.RightHandEnergyt, 300, 300);

            drawer.draw(Head, x-size/2, (float) (y + 335 * scale)-size/2, 150+size/2, 25+size/2, (float) (200 * scale)+size, (float) (200 * scale)+size, 1, 1,  rothead);
            drawer.draw(Body, x-size/2, (float) (y + 170 * scale)-size/2, 150+size/2, 25+size/2, (float) (200 * scale)+size, (float) (200 * scale)+size, 1, 1,  rot);
            drawer.draw(LeftLeg, (float) (x - 50 * scale)-size/2, y-size/2, (float) (100 * scale)+size/2, (float) (160 * scale)+size/2, (float) (200 * scale)+size, (float) (200 * scale)+size, 1, 1,  -rotleg);
            drawer.draw(RightLeg, (float) (x + 50 * scale)-size/2, y-size/2, (float) (100 * scale)+size/2, (float) (160 * scale)+size/2, (float) (200 * scale)+size, (float) (200 * scale)+size, 1, 1,  rotleg);
            drawer.draw(LeftHand, (float) (x + 90 * scale)-size/2, (float) (y + 170 * scale)-size/2, (float) (100 * scale)+size/2, (float) (160 * scale)+size/2, (float) (200 * scale)+size, (float) (200 * scale)+size, 1, 1,  rothand);
            drawer.draw(RightHand, (float) (x - 90 * scale)-size/2, (float) (y + 170 * scale)-size/2, (float) (100 * scale)+size/2, (float) (160 * scale)+size/2, (float) (200 * scale)+size, (float) (200 * scale)+size, 1, 1,  rothand - 90 + rot);
        }
    }
    public void DrawRobotIcon(SpriteBatchRubber drawer, int x, int y, float scale, int health) {
        if(y+510*scale>=height-70*scale){
            drawer.draw(game.robot.BackHealth, x, (float) (height-45*scale), (float) (200 * scale), (float) (70 * scale));
            drawer.draw(game.robot.RobotHealth, x, (float) (height-45*scale), (float) (200 * scale * ((float)health / (float)game.robot.health)), (float) (70 * scale));
            drawer.draw(game.robot.RobotIcon, x, (float) (height-45*scale), (float) (200 * scale), (float) (70 * scale));
        }else {
            drawer.draw(game.robot.BackHealth, x, (float) (y + 510 * scale), (float) (200 * scale), (float) (70 * scale));
            drawer.draw(game.robot.RobotHealth, x, (float) (y + 510 * scale), (float) (200 * scale * ((float)health / (float)game.robot.health)), (float) (70 * scale));
            drawer.draw(game.robot.RobotIcon, x, (float) (y + 510 * scale), (float) (200 * scale), (float) (70 * scale));
        }
    }
    public void DrawEnemyIcon(SpriteBatchRubber drawer, int x, int y, float scale, int health) {
        if(y+510*scale>=height-70*scale){
            drawer.draw(game.robot.BackHealth, x, (float) (height-45*scale), (float) (200 * scale), (float) (70 * scale));
            drawer.draw(game.robot.EnemyHealth, x, (float) (height-45*scale), (float) (200 * scale * ((float)health / (float)game.robot.Ehealth)), (float) (70 * scale));
            drawer.draw(game.robot.EnemyIcon, x, (float) (height-45*scale), (float) (200 * scale), (float) (70 * scale));
        }else {
            drawer.draw(game.robot.BackHealth, x, (float) (y + 510 * scale), (float) (200 * scale), (float) (70 * scale));
            drawer.draw(game.robot.EnemyHealth, x, (float) (y + 510 * scale), (float) (200 * scale * ((float)health / (float)game.robot.Ehealth)), (float) (70 * scale));
            drawer.draw(game.robot.EnemyIcon, x, (float) (y + 510 * scale), (float) (200 * scale), (float) (70 * scale));
        }
    }
    public void DoorOpen(){
        door = new Thread(){
            @Override
            public void run(){
                game.opened.play(0.5f);
                Sleep(50);
                while(open_x < width/2) {
                    open_x += 5;
                    Sleep( 3);
                }
                isOpen = true;
            }
        };
        door.start();
    }
    public void DoorClose(int type_close){
        this.type_close = type_close;
        if(!willClose) {
            willClose = true;
            door = new Thread() {
                @Override
                public void run() {
                    Sleep(250);
                    game.closed.play(0.5f);
                    while (open_x > 0) {
                        open_x -= 5;
                        Sleep( 3);
                    }
                    Sleep(50);
                    closed = true;
                }
            };

            door.start();
        }
    }
    public void CheckOpen(SpriteBatchRubber drawer){
        if(!isOpen) {
            drawer.draw(door_right, open_x, 0, width, height);
            drawer.draw(door_left, -open_x, 0, width, height);
        }
    }
    public void CheckClose(SpriteBatchRubber drawer){
        if (willClose) {
            drawer.draw(door_left, -open_x, 0, width, height);
            drawer.draw(door_right, open_x, 0, width, height);
        }
    }

    public void DrawDefaultButton(SpriteBatchRubber drawer, Texture left_part, Texture center_part, Texture right_part, Texture back_light, Texture icon, int state, int x, int y, int size){
        int rstatex = (int)((float)size*state/100.0f);
        int rstatey = 0;
        if(state >= 70) {
             rstatey = (int) ((float)size*2.0f * (state-70) / 100.0f);
        }
        int dispose_part = 1;
        if(state==100){
            dispose_part = 0;
        }
        drawer.draw(center_part, x+rstatex/2, y+rstatey/2, (size-rstatex)*dispose_part, (size/1.5f-rstatey)*dispose_part);
        drawer.draw(left_part, x-size/5+rstatex/2, y+rstatey/2, (size/4)*dispose_part, (size/1.5f-rstatey)*dispose_part);
        drawer.draw(right_part, x+size*0.95f-rstatex/2, y+rstatey/2, (size/4)*dispose_part, (size/1.5f-rstatey)*dispose_part);
        drawer.draw(back_light, x+size/2-rstatey, y+size/3-rstatey, rstatey*2, rstatey*2);
        drawer.draw(icon, x+size/2-size/4-state/2, y-state/2+size/12, state+size/2, state+size/2);

    }
    public void Sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception ignored) { }
    }
    @Override
    public void render(float d) { }
    @Override
    public void show() { }
    @Override
    public void resize(int width, int height) { }
    @Override
    public void pause() {
        pause=true;
    }
    @Override
    public void resume() {
        pause=false;
    }
    @Override
    public void hide() { }
    @Override
    public void dispose(){

    }
}