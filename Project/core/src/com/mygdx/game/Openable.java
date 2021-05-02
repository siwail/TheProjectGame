package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
public class Openable implements Screen{
    MainGame game;
    BitmapFont item_font;
    Texture door_left;
    Texture door_right;
    Thread door;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("main_font.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    public static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
    boolean closed = false;
    boolean willClose = false;
    boolean isOpen = false;
    int type_close = 0;
    int width;
    int height;
    int open_x = 0;
    public void Start(){
        parameter.size = 35;
        parameter.characters = FONT_CHARACTERS;
        item_font = generator.generateFont(parameter);
        generator.dispose();
        item_font.setColor(Color.WHITE);
        door_left =  new Texture("door_1.png");
        door_right=  new Texture("door_2.png");
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        open_x = width/2;
    }
    public void DrawBullet(SpriteBatch drawer, int x, int y, int type) {
        if(type == 1) {
            drawer.draw(game.robot.Bullet, x, y, 25, 20);
            drawer.draw(game.robot.Select, x, y, 25, 20);
        }else{
            drawer.draw(game.robot.EBullet, x, y, 25, 20);
            drawer.draw(game.robot.ESelect, x, y, 25, 20);
        }
    }
    public void DrawEnergy(SpriteBatch drawer, int x, int y, double scale, int energy, int energy_warning) {
        Texture front = game.robot.EnergyFront;
        if(energy_warning == 1){
            front = game.robot.EnergyWarning1;
        }
        if(energy_warning == 2){
            front = game.robot.EnergyWarning2;
        }
        drawer.draw(game.robot.EnergyBack, x, y, (int)(200*scale), (int)(200*scale));
        drawer.draw(game.robot.Energy, x+(game.robot.energy-energy)/3, y, (int)(200*((double)energy/(double)game.robot.energy)*scale), (int)(200*scale));
        drawer.draw(front, x, y, (int)(200*scale), (int)(200*scale));
    }
    public void DrawRobot(SpriteBatch drawer, int x, int y, double scale, float rothand, float rothead, float rotleg, float rot, boolean swap, boolean hurt, boolean dead) {
        TextureRegion Head = game.robot.H;
        TextureRegion Body = game.robot.B;
        TextureRegion LeftLeg = game.robot.LL;
        TextureRegion RightLeg = game.robot.RL;
        TextureRegion LeftHand = game.robot.LH;
        TextureRegion RightHand = game.robot.RH;
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
        drawer.draw(Head, x, (float) (y + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, (float) rothead);
        drawer.draw(Body, x, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, (float) rot);
        drawer.draw(LeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, (float) -rotleg);
        drawer.draw(RightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, (float) rotleg);
        drawer.draw(LeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, (float) rothand);
        drawer.draw(RightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, (float) rothand - 90);

    }
    public void DrawEnemy(SpriteBatch drawer, int x, int y, double scale, float rothand, float rothead, float rotleg, float rot, boolean swap, boolean hurt, boolean dead) {
        TextureRegion Head = game.robot.EH;
        TextureRegion Body = game.robot.EB;
        TextureRegion LeftLeg = game.robot.ELL;
        TextureRegion RightLeg = game.robot.ERL;
        TextureRegion LeftHand = game.robot.ELH;
        TextureRegion RightHand = game.robot.ERH;
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
        drawer.draw(Head, x, (float) (y + 335 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, (float) rothead);
        drawer.draw(Body, x, (float) (y + 170 * scale), 150, 25, (float) (200 * scale), (float) (200 * scale), 1, 1, (float) rot);
        drawer.draw(LeftLeg, (float) (x - 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, (float) -rotleg);
        drawer.draw(RightLeg, (float) (x + 50 * scale), y, (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, (float) rotleg);
        drawer.draw(LeftHand, (float) (x + 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, (float) rothand);
        drawer.draw(RightHand, (float) (x - 90 * scale), (float) (y + 170 * scale), (float) (100 * scale), (float) (160 * scale), (float) (200 * scale), (float) (200 * scale), 1, 1, (float) rothand - 90);
    }
    public void DrawRobotIcon(SpriteBatch drawer, int x, int y, double scale, int health) {
        if(y+510*scale>=height-70*scale){
            drawer.draw(game.robot.BackHealth, x, (float) (height-45*scale), (float) (200 * scale), (float) (70 * scale));
            drawer.draw(game.robot.RobotHealth, x, (float) (height-45*scale), (float) (200 * scale * ((double)health / (double)game.robot.health)), (float) (70 * scale));
            drawer.draw(game.robot.RobotIcon, x, (float) (height-45*scale), (float) (200 * scale), (float) (70 * scale));
        }else {
            drawer.draw(game.robot.BackHealth, x, (float) (y + 510 * scale), (float) (200 * scale), (float) (70 * scale));
            drawer.draw(game.robot.RobotHealth, x, (float) (y + 510 * scale), (float) (200 * scale * ((double)health / (double)game.robot.health)), (float) (70 * scale));
            drawer.draw(game.robot.RobotIcon, x, (float) (y + 510 * scale), (float) (200 * scale), (float) (70 * scale));
        }
    }
    public void DrawEnemyIcon(SpriteBatch drawer, int x, int y, double scale, int health) {
        if(y+510*scale>=height-70*scale){
            drawer.draw(game.robot.BackHealth, x, (float) (height-45*scale), (float) (200 * scale), (float) (70 * scale));
            drawer.draw(game.robot.EnemyHealth, x, (float) (height-45*scale), (float) (200 * scale * ((double)health / (double)game.robot.Ehealth)), (float) (70 * scale));
            drawer.draw(game.robot.EnemyIcon, x, (float) (height-45*scale), (float) (200 * scale), (float) (70 * scale));
        }else {
            drawer.draw(game.robot.BackHealth, x, (float) (y + 510 * scale), (float) (200 * scale), (float) (70 * scale));
            drawer.draw(game.robot.EnemyHealth, x, (float) (y + 510 * scale), (float) (200 * scale * ((double)health / (double)game.robot.Ehealth)), (float) (70 * scale));
            drawer.draw(game.robot.EnemyIcon, x, (float) (y + 510 * scale), (float) (200 * scale), (float) (70 * scale));
        }
    }
    public void DoorOpen(){
        door = new Thread(){
            @Override
            public void run(){
                Sleep( 1000);
                while(open_x < width/2) {
                    open_x += 5;
                    Sleep( 5);
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
                    while (open_x > 0) {
                        open_x -= 5;
                        Sleep( 5);
                    }
                    Sleep( 100);
                    closed = true;
                }
            };
            door.start();
        }
    }
    public void CheckOpen(SpriteBatch drawer){
        if(!isOpen) {
            drawer.draw(door_right, open_x, 0, width, height);
            drawer.draw(door_left, -open_x, 0, width, height);
        }
    }
    public void CheckClose(SpriteBatch drawer){
        if (willClose) {
            drawer.draw(door_left, -open_x, 0, width, height);
            drawer.draw(door_right, open_x, 0, width, height);
        }
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
    public void pause() { }
    @Override
    public void resume() { }
    @Override
    public void hide() { }
    @Override
    public void dispose(){ }
}
