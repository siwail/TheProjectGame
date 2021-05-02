package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class GamePlay extends Openable implements Screen{
    SpriteBatch batch;
    Thread anime;//Анимации перса
    Thread Eanime;//Анимации Врага
    Thread EnergyAdd;
    Thread EnemyBrine;
    Thread EEnergyAdd;
    Texture floor;
    Texture background;
    Texture grass;
    Texture up;
    Texture down;
    Texture redir;
    Texture fire;
    Texture jump;
    Texture up_touched;
    Texture down_touched;
    Texture redir_touched;
    Texture fire_touched;
    Texture jump_touched;
    int[] bullets_x = new int[40];
    double[] bullets_y = new double[40];
    int[] bullets_dir = new int[40];
    int[] bullets_type = new int[40];
    int warning = 0;
    int lastnumbullet;
    int Elastnumbullet;             //Это я делал, чтобы передавать номер обрабатываемой пули в поток с анимацией этой пули. Жесткая дичь, но работает.
    int bullets = 0;
    int pos_interface = 0;
    int dir = 1;
    int y = 1;
    int x = 1;
    int health;
    int Edir = -1;
    int Ey = 1;
    int Ex = 8;
    int Ehealth;
    int grass_dir = 1;
    int energy;
    int Eenergy = 200;
    int energy_use = 0;
    double speed = 1.0;
    double anime_grass = 0;
    int[] grass_1 = new int[5];
    int[] grass_2 = new int[5];
    int[] grass_3 = new int[5];
    double scale_inteface = 1.1;
    double robot_x = 0;
    double robot_y = 0;
    double Erobot_x = 0;
    double Erobot_y = 0;
    float rothand = 0;
    float rotleg = 0;
    float rothead = 0;
    float rot = 0;
    float scale = 0.8f;
    float Erothand = 270;
    float Erotleg = 0;
    float Erothead = 0;
    float Erot = 0;
    float Escale = 0.8f;
    boolean dead = false;
    boolean Edead = false;
    boolean hurt = false;
    boolean Ehurt = false;
    boolean isEnergyWarning = false;
    boolean fire_clicked = false;
    boolean swap = false;
    boolean Eswap = false;
    boolean Efire_clicked = false;
    boolean Eredir_clicked = false;
    boolean Eup_clicked = false;
    boolean Edown_clicked = false;
    boolean Ejump_clicked = false;
    boolean redir_clicked = false;
    boolean up_clicked = false;
    boolean down_clicked = false;
    boolean jump_clicked = false;
    boolean up_touch = false;
    boolean down_touch = false;
    boolean redir_touch = false;
    boolean fire_touch = false;
    boolean jump_touch = false;
    public GamePlay(MainGame game) { this.game = game; }
    @Override
    public void show() {
        energy = game.robot.energy;
        grass = new Texture("grass_2.png");
        up = new Texture("button_up.png");
        down = new Texture("button_down.png");
        redir = new Texture("button_redir.png");
        fire = new Texture("button_fire.png");
        jump = new Texture("button_jump.png");
        up_touched = new Texture("button_up_touched.png");
        down_touched = new Texture("button_down_touched.png");
        redir_touched = new Texture("button_redir_touched.png");
        fire_touched = new Texture("button_fire_touched.png");
        jump_touched = new Texture("button_jump_touched.png");
        Gdx.input.setInputProcessor(new GamePlayTouch(game, this));
        Start();
        int i = 0;                                                 //Стандартная переменная, которая, почему-то, используется везде. Зачем я вообще написал этот комментарий?
        while(i != 5){
            grass_1[i] = game.random.nextInt(10)+1;
            i++;
        }
        i = 0;
        while(i != 5){
            grass_2[i] = game.random.nextInt(10)+1;
            i++;
        }
        i = 0;
        while(i != 5){
            grass_3[i] = game.random.nextInt(10)+1;
            i++;
        }
        health = game.robot.health;
        Ehealth = game.robot.Ehealth;
        y = game.random.nextInt(3)+1;
        Ey = game.random.nextInt(3)+1;
        background = new Texture("background.png");
        floor = new Texture("grass_alpha.png");
        open_x = 0;
        batch = new SpriteBatch();
        anime = new Thread(){
            @Override
            public void run(){
                int dir = 2;                                        //Указание направления анимации. Типо реверс.
                int time = game.random.nextInt(10)+10;
                while(true){
                    if(grass_dir == 1){
                        anime_grass+=0.5;
                        if(anime_grass>=5.0){
                            grass_dir = 0;
                        }
                    }else{
                        anime_grass-=0.5;
                        if(anime_grass<=-5.0){
                            grass_dir = 1;
                        }
                    }
                    if(dir==1){
                        robot_x+=0.1;
                        scale-=0.0008f;
                        rothead+=0.2f;
                        rothand-=0.1f;
                        if(rothead>=3.0f){
                            dir=2;
                            time = game.random.nextInt(10)+10;
                        }
                    }else{
                        robot_x-=0.1;
                        scale+=0.0008f;
                        rothead-=0.2f;
                        rothand+=0.1f;
                        if(rothead<=-3.0f){
                            dir=1;
                            time = game.random.nextInt(10)+10;
                        }
                    }
                    if(closed){
                        break;
                    }
                    Sleep(  (int)(time*speed));
                }
            }
        };
        Eanime = new Thread(){
            @Override
            public void run(){
                int Edir = 2;                                      //Переменные с обозначением "E" в начале принадлежат врагу.
                int Etime = game.random.nextInt(10)+10;
                while(true){
                    if(Edir==1){
                        Erobot_x+=0.1;
                        Escale-=0.0008f;
                        Erothead+=0.2f;
                        Erothand-=0.1f;
                        if(Erothead>=3.0f){
                            Edir=2;
                            Etime = game.random.nextInt(10)+10;
                        }
                    }else{
                        Erobot_x-=0.1;
                        Escale+=0.0008f;
                        Erothead-=0.2f;
                        Erothand+=0.1f;
                        if(Erothead<=-3.0f){
                            Edir=1;
                            Etime = game.random.nextInt(10)+10;
                        }
                    }
                    if(closed){
                        break;
                    }
                    Sleep(  (int)(Etime*speed));
                }
            }
        };
        EnergyAdd = new Thread(){
            @Override
            public void run(){
                while(true){
                    if(energy<game.robot.energy){
                        energy+=1;
                    }
                    if(closed){
                        break;
                    }
                    Sleep(  (int)(game.robot.energy_speed*speed));
                }
            }
        };
        EEnergyAdd = new Thread(){
            @Override
            public void run(){
                while(true){
                    if(Eenergy<game.robot.energy){
                        Eenergy+=1;
                    }
                    if(closed){
                        break;
                    }
                    Sleep(  (int)(game.robot.Eenergy_speed*speed));
                }
            }
        };
        EnemyBrine = new Thread(){
            @Override
            public void run(){
                while(true) {
                    int random_act = game.random.nextInt(26) + 1;
                    if (random_act < 11 && random_act > 0) {
                        if (CheckBullet()) {
                            int index = 0;
                            if (bullets > 0) {
                                while (index < 40) {
                                    if (Math.abs((double) bullets_x[index] - (double) (Ex * width / 10)) < 150) {
                                        EJump();
                                    }
                                    index++;
                                }
                            }
                            int move_dir = game.random.nextInt(2) - 1;
                            if (Ey - 1 > 0 && move_dir == -1) {
                                EDown();
                            }
                            if (Ey + 1 < 4 && move_dir == 0) {
                                EUp();
                            }

                        }
                    }
                    if (random_act < 13 && random_act > 10) {
                        if (Math.abs((Ex * width / 10 + Erobot_x) - (x * width / 10 + robot_x)) > 75 && ((Edir == -1 && (Ex * width / 10 + Erobot_x) < (x * width / 10 + robot_x)) || (Edir == 1 && (Ex * width / 10 + Erobot_x) > (x * width / 10 + robot_x)))) {
                                ERedir();
                            }
                    }
                    if (random_act < 16 && random_act > 13) {

                            int move_dir = game.random.nextInt(2) - 1;
                            if (Ey - 1 > 0 && move_dir == -1) {
                                EDown();
                            }
                            if (Ey + 1 < 4 && move_dir == 0) {
                                EUp();
                            }
                    }
                    if (random_act < 19 && random_act > 16) {
                            int move_dir = game.random.nextInt(10) + 1;
                            if (move_dir == 3) {
                                ERedir();
                            }
                            if (move_dir < 3) {
                                EFire();
                            }
                            if (move_dir == 10) {
                                EJump();
                            }
                    }
                    if (random_act > 20) {
                        if (Ey == y && ((Edir == -1 && (Ex * width / 10 + Erobot_x) > (x * width / 10 + robot_x)) || (Edir == 1 && (Ex * width / 10 + Erobot_x) < (x * width / 10 + robot_x)))) {
                            EFire();
                        }
                    }
                    if (random_act == 20) {
                        if (Math.abs((((double)Ex * (double)width / (double)10) + Erobot_x) - (((double)x * (double)width / (double)10) + robot_x)) <= 250.0) {
                            int move_dir = game.random.nextInt(3) + 1;
                            if (move_dir == 3) {
                                if (Eenergy >= 50) {
                                    EJump();
                                }
                            }
                        }
                    }
                    if(closed){
                        break;
                    }
                    Sleep((int) (50 * speed));
                }
            }
        };
        EnemyBrine.start();
        EnergyAdd.start();
        EEnergyAdd.start();
        anime.start();
        Eanime.start();
        DoorOpen();
    }
    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, width, height);
        int i = 0;
        while(i!=5){
            batch.draw(grass, grass_3[i]*(width/10), (height/5)*3-70-15*3, 150, (int)(150+anime_grass));
            i++;
        }
        batch.draw(floor, 0, height/5*2-80, width, height/5);
        i = 0;
        while(i!=5){
            batch.draw(grass, grass_2[i]*(width/10), (height/5)*2-105, 150, (int)(150+anime_grass));
            i++;
        }
        batch.draw(floor, 0, height/5-70, width, height/5);
        i = 0;
        while(i!=5){
            batch.draw(grass, grass_1[i]*(width/10), (height/5)-70-15, 150, (int)(150+anime_grass));
            i++;
        }
        batch.draw(floor, 0, -60, width, height/5);
        int index = 0;
        if(bullets>0) {
            while (index < 40) {
                if (bullets_dir[index] != 0 && Math.floor(bullets_y[index]) == 3.0) {
                    DrawBullet(batch, (int)(bullets_x[index] + 135 * bullets_dir[index]), (int)((height/5)*bullets_y[index]-15*bullets_y[index]+240*scale), bullets_type[index]);
                }
                index++;
            }
        }
        if(Ey == 3){
            DrawEnemy(batch, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale*(1.0f-0.03f*Ey), Erothand+90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
        }
        if(y == 3){
            DrawRobot(batch, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale*(1.0f-0.03f*y), rothand+90, rothead, rotleg, rot , swap, hurt, dead);
        }
        index = 0;
        if(bullets>0) {
            while (index < 40) {
                if (bullets_dir[index] != 0 && Math.floor(bullets_y[index]) == 2.0) {
                    DrawBullet(batch, (int)(bullets_x[index] + 135  * bullets_dir[index]), (int)((height/5)*bullets_y[index]-15*bullets_y[index]+240*scale), bullets_type[index]);
                }
                index++;
            }
        }
        if(Ey == 2){
            DrawEnemy(batch, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale*(1.0f-0.03f*Ey), Erothand+90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
        }
        if(y == 2){
            DrawRobot(batch, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale*(1.0f-0.03f*y), rothand+90, rothead, rotleg, rot , swap, hurt, dead);
        }
        index = 0;
        if(bullets>0) {
            while (index < 40) {
                if (bullets_dir[index] != 0 && Math.floor(bullets_y[index]) == 1.0) {
                    DrawBullet(batch, (int)(bullets_x[index] + 135 * bullets_dir[index]), (int)((height/5)*bullets_y[index]-15*bullets_y[index]+240*scale), bullets_type[index]);
                }
                index++;
            }
        }
        if(Ey == 1){
            DrawEnemy(batch, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale*(1.0f-0.03f*Ey), Erothand+90, Erothead, Erotleg, Erot, Eswap, Ehurt, Edead);
        }
        if(y == 1){
            DrawRobot(batch, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale*(1.0f-0.03f*y), rothand+90, rothead, rotleg, rot , swap, hurt, dead);
        }
        DrawEnemyIcon(batch, Ex*(width/10)+(int)Erobot_x, (height/5)*Ey-60-10*Ey+(int)Erobot_y, Escale, Ehealth);
        DrawRobotIcon(batch, x*(width/10)+(int)robot_x, (height/5)*y-60-10*y+(int)robot_y, scale, health);
        if(fire_touch) {                //Так как eval из JavaScript в Java не присутствует, и даже его более или менее адекватной замены я не встретил, приходится 7овнокодить...
            batch.draw(fire_touched, (int) (width - 275 * scale_inteface), -pos_interface, (int) (250 * scale_inteface), (int) (250 * scale_inteface));
        }else{
            batch.draw(fire, (int) (width - 275 * scale_inteface), -pos_interface, (int) (250 * scale_inteface), (int) (250 * scale_inteface));
        }
        if(up_touch) {
            batch.draw(up_touched, (int)(50*scale_inteface), (int)(125*scale_inteface-pos_interface), (int)(150*scale_inteface), (int)(150*scale_inteface));
        }else{
            batch.draw(up, (int)(50*scale_inteface), (int)(125*scale_inteface-pos_interface), (int)(150*scale_inteface), (int)(150*scale_inteface));
        }
        if(down_touch) {
            batch.draw(down_touched, (int)(50*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }else{
            batch.draw(down, (int)(50*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }
        if(redir_touch) {
            batch.draw(redir_touched, (int)(200*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }else{
            batch.draw(redir, (int)(200*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }
        if(jump_touch) {
            batch.draw(jump_touched, (int)(width-400*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }else{
            batch.draw(jump, (int)(width-400*scale_inteface), -pos_interface, (int)(150*scale_inteface), (int)(150*scale_inteface));
        }
        DrawEnergy(batch, (int)(400*(scale_inteface-0.1)), (int)(-50*(scale_inteface-0.1)), 1.3*(scale_inteface-0.1), energy, warning);
        CheckClose(batch);
        CheckOpen(batch);
        if(closed){
            if(type_close == 1) {
                game.setGameMenu();
            }
        }
        batch.end();
    }
    public boolean CheckBullet(){
        if(bullets>0) {
            int index = 0;
            while (index < 40) {
                if (bullets_dir[index] != 0 && Math.floor(bullets_y[index]) == (double)Ey && Math.abs((double)bullets_x[index] - (double)(Ex*width/10)) < 800 && (((double)(Ex*width/10)-(double)bullets_x[index] > 0 && bullets_dir[index] == 1) || ((double)bullets_x[index]-(double)(Ex*width/10)> 0 && bullets_dir[index] == -1))) {
                    return true;
                }
                index++;
            }
        }
        return false;
    }
    public void ESetBullet(int Ex, int Ey, int Edir){               //Жесткая дичь, которая добавляет пули. Работает - не трожь. Написал сам - молодец. Скопипастил - лох. Но если придерживаться логики, где вообще можно скопипастить такую хрень, а?
        if(bullets < 40){
            bullets++;
            int i = 0;
            int num = 0;
            while(i<40){
                if(bullets_dir[i] == 0){
                    num = i;
                    break;
                }
                i++;
            }
            bullets_type[num] = 2;
            bullets_x[num] = Ex;
            bullets_y[num] = Ey;
            bullets_dir[num] = Edir;
            lastnumbullet = num;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    int randomfire = game.random.nextInt(6) * (game.random.nextInt(2) - 1); //Переменная, отвечающая за кучность стрельбы.. Типо точность, или отдача
                    int num = lastnumbullet;                   //Вот, на ней все держится
                    int dir = bullets_dir[num];
                    while(true){
                        bullets_x[num]+=2*dir;
                        bullets_y[num]-=0.0001*randomfire;
                        if(bullets_x[num] > width+100 || bullets_x[num] < -100){
                            break;
                        }
                        if(bullets_x[num] >= (int)(x*width/10+robot_x) && bullets_x[num] <= (int)(x*width/10+robot_x+(290.0*scale)) && (int)Math.round(bullets_y[num]) == y){
                            DamageRobot(game.robot.damage);
                            break;
                        }
                        if(bullets == 0 || bullets_dir[num] == 0){
                            break;
                        }
                        Sleep(  (int)(5*speed));
                    }
                    bullets_type[num] = 0;
                    bullets_x[num] = 0;
                    bullets_y[num] = 0;
                    bullets_dir[num] = 0;
                    bullets--;
                }
            };
            anime.start();
        }
    }
    public void SetBullet(int x, int y, int dir){               //Жесткая дичь, которая добавляет пули. Работает - не трожь. Написал сам - молодец. Скопипастил - лох. Но если придерживаться логики, где вообще можно скопипастить такую хрень, а?
        if(bullets < 40){
            bullets++;
            int i = 0;
            int num = 0;
            while(i<40){
                if(bullets_dir[i] == 0){
                    num = i;
                    break;
                }
                i++;
            }
            bullets_type[num] = 1;
            bullets_x[num] = x;
            bullets_y[num] = y;
            bullets_dir[num] = dir;
            Elastnumbullet = num;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    int randomfire = game.random.nextInt(6) * (game.random.nextInt(2) - 1); //Переменная, отвечающая за кучность стрельбы.. Типо точность, или отдача
                    int num = Elastnumbullet;                   //Вот, на ней все держится
                    int dir = bullets_dir[num];
                    while(true){
                        bullets_x[num]+=2*dir;
                        bullets_y[num]-=0.0001*randomfire;
                        if(bullets_x[num] > width+100 || bullets_x[num] < -100){
                            break;
                        }
                        if(bullets_x[num] >= (int)(Ex*width/10+Erobot_x) && bullets_x[num] <= (int)(Ex*width/10+Erobot_x+(290.0*scale)) && (int)Math.round(bullets_y[num]) == Ey){
                            DamageEnemy(game.robot.damage);
                            break;
                        }
                        if(bullets == 0 || bullets_dir[num] == 0){
                            break;
                        }
                        Sleep(  (int)(5*speed));
                    }
                    bullets_type[num] = 0;
                    bullets_x[num] = 0;
                    bullets_y[num] = 0;
                    bullets_dir[num] = 0;
                    bullets--;
                }
            };
            anime.start();
        }
    }
    public void DamageEnemy(int damage){
        if(!Eswap) {
                if (!Ehurt) {
                    Ehealth -= damage;
                    if(Ehealth <= 0) {
                        Ehealth = 0;
                    }
                    Thread anime = new Thread() {
                        @Override
                        public void run() {
                            int anime_dir = 1;
                            Ehurt = true;
                            int anime_pos = 0;
                            while (anime_dir != 3) {
                                if (anime_dir == 1) {
                                    Escale += 0.001f;
                                    anime_pos += 1;
                                    if (anime_pos >= 40) {
                                        anime_dir = 2;
                                    }
                                } else {
                                    Escale -= 0.001f;
                                    anime_pos -= 1;
                                    if (anime_pos <= 0) {
                                        anime_dir = 3;
                                    }
                                }
                                Sleep((int) (2 * speed));
                            }
                            if(Ehealth <= 0) {
                                Ehealth = 0;
                                EDead();
                            }
                            Ehurt = false;
                            Escale = 0.8f;
                        }
                    };
                    anime.start();
                }
            }
    }
    public void DamageRobot(int damage){
        if(!swap) {
            if (!hurt) {
                health -= damage;
                if(health <= 0) {
                    health = 0;
                }
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        int anime_dir = 1;
                        hurt = true;
                        int anime_pos = 0;
                        while (anime_dir != 3) {
                            if (anime_dir == 1) {
                                scale += 0.001f;
                                anime_pos += 1;
                                if (anime_pos >= 40) {
                                    anime_dir = 2;
                                }
                            } else {
                                scale -= 0.001f;
                                anime_pos -= 1;
                                if (anime_pos <= 0) {
                                    anime_dir = 3;
                                }
                            }
                            Sleep((int) (2 * speed));
                        }
                        if(health <= 0) {
                            health = 0;
                            Dead();
                        }
                        hurt = false;
                        scale = 0.8f;
                    }
                };
                anime.start();
            }
        }
    }
    public void EDead(){
        if(!Edead){
            Edead = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    Sleep(  200);
                    while (pos_interface<500) {
                        scale_inteface-=0.0002;
                        pos_interface+=1;
                        Erobot_y-=2;
                        Escale-=0.0002f;
                        Sleep(  5);
                    }
                    Sleep(  500);
                    DoorClose(1);
                }
            };
            anime.start();
        }
    }
    public void Dead(){
        if(!dead){
            dead = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    Sleep(  200);
                    while (pos_interface<500) {
                        scale_inteface-=0.0002;
                        pos_interface+=1;
                        robot_y-=2;
                        scale-=0.0002f;
                        Sleep(  5);
                    }
                    Sleep(  500);
                    DoorClose(1);
                }
            };
            anime.start();
        }
    }
    public void EFire(){
        if(!Efire_clicked && !Eup_clicked && !Edown_clicked && !Eredir_clicked && !Ejump_clicked) {
            if (EEnergyExists(10)) {
                EEnergyUse(10);
                Efire_clicked = true;
                ESetBullet(Ex * width / 10 + (int) (90 * Escale), Ey, Edir);
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        float lastrot = Erothand;
                        double rot = 0;
                        int rotdir = 1;
                        while (true) {
                            if (rotdir == 1) {
                                rot += Edir;
                                Erothand += 1.0f * Edir;
                                if (Edir * rot > 10) {
                                    rotdir = -1;
                                }
                            }
                            if (rotdir == -1) {
                                rot -= Edir;
                                Erothand -= 1.0f * Edir;
                                if (Edir * rot < 0) {
                                    break;
                                }
                            }
                            Sleep(  (int)(game.robot.Eattack_speed*speed));
                        }
                        Efire_clicked = false;
                        Erothand = lastrot;
                    }
                };
                anime.start();
            }
        }
    }
    public void Fire(){
        if(!fire_clicked && !up_clicked && !down_clicked && !redir_clicked && !jump_clicked) {
            if (EnergyExists(10)) {
                EnergyUse(10);
                fire_clicked = true;
                SetBullet(x * width / 10 + (int) (90 * scale), y, dir);
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        float lastrot = rothand;
                        double rot = 0;
                        int rotdir = 1;
                        while (true) {
                            if (rotdir == 1) {
                                rot += dir;
                                scale_inteface-=0.003;
                                rothand += 1.0f * dir;
                                if (dir * rot > 10) {
                                    rotdir = -1;
                                }
                            }
                            if (rotdir == -1) {
                                rot -= dir;
                                scale_inteface+=0.003;
                                rothand -= 1.0f * dir;
                                if (dir * rot < 0) {
                                    break;
                                }
                            }
                            Sleep(  (int)(game.robot.attack_speed*speed));
                        }
                        scale_inteface = 1.1;
                        fire_clicked = false;
                        rothand = lastrot;
                    }
                };
                anime.start();//Огонь!
            }
        }
    }
    public void EEnergyUse(int en){
        Eenergy-=en;
    }
    public void EnergyUse(int en){
        energy_use = en;
        Thread anime = new Thread() {
            @Override
            public void run() {
                int energy_num = 0;
                while (energy_num<energy_use) {
                    energy_num+=1;
                    energy-=1;
                    if(energy<=0){
                        break;
                    }
                    Sleep((int)(5*speed));
                }
            }
        };
        anime.start();
    }
    public boolean EEnergyExists(int energy){
        return this.Eenergy >= energy;
    }
    public boolean EnergyExists(int energy){
        if(!(this.energy>=energy)){
            if(!isEnergyWarning) {
                isEnergyWarning = true;
                warning = 1;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        Sleep(  (int)(100*speed));
                        warning = 2;
                        Sleep(  (int)(100*speed));
                        warning = 0;
                        isEnergyWarning = false;
                    }
                };
                anime.start();
            }
        }
        return this.energy >= energy;
    }    public void EUp(){
        if(!Eup_clicked && !Edown_clicked && !Efire_clicked && !Edead) {
            Eup_clicked = true;
            if (Ey < 3) {
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        int dir_num = Edir;
                        int rotdir = 1;
                        boolean acess_x = false;
                        boolean acess_y = false;
                        while (true) {
                            if (Erobot_y < (height / 5)) {
                                Erobot_y += 2;
                            } else {
                                acess_y = true;
                            }
                            if (dir_num + Ex != 0 && dir_num + Ex != 9) {
                                if (dir_num * Erobot_x <= (width / 10)) {
                                    Erobot_x += dir_num * 2;
                                } else {
                                    acess_x = true;
                                }
                            } else {
                                acess_x = true;
                            }
                            if (rotdir == 1) {
                                Erotleg += 2;
                                if (Erotleg > 90) {
                                    rotdir = 0;
                                }
                            } else {
                                Erotleg -= 2;
                                if (Erotleg < 0) {
                                    rotdir = 1;
                                }
                            }
                            if (acess_x && acess_y) {
                                Ey += 1;
                                if (dir_num + Ex != 0 && dir_num + Ex != 9) {
                                    Ex += dir_num;
                                }
                                Eup_clicked = false;
                                Erotleg = 0;
                                Erobot_y = 0;
                                Erobot_x = 0;
                                break;
                            }
                            Sleep(  (int)(game.robot.Emove_speed*speed));
                        }
                    }
                };
                anime.start();
            }
        }
    }
    public void EDown(){
        if(!Eup_clicked && !Edown_clicked && !Efire_clicked && !Edead) {
            Edown_clicked = true;
            if (Ey > 1) {
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        int dir_num = Edir;
                        int rotdir = 1;
                        boolean acess_x = false;
                        boolean acess_y = false;
                        while (true) {
                            if (Erobot_y > -(height / 5)) {
                                Erobot_y -= 2;
                            } else {
                                acess_y = true;
                            }
                            if (dir_num + Ex != 0 && dir_num + Ex != 9) {
                                if (dir_num * Erobot_x <= (width / 10)) {
                                    Erobot_x += dir_num * 2;
                                } else {
                                    acess_x = true;
                                }
                            } else {
                                acess_x = true;
                            }
                            if (rotdir == 1) {
                                Erotleg += 2;
                                if (Erotleg > 90) {
                                    rotdir = 0;
                                }
                            } else {
                                Erotleg -= 2;
                                if (Erotleg < 0) {
                                    rotdir = 1;
                                }
                            }
                            if (acess_x && acess_y) {
                                Ey -= 1;
                                if (dir_num + Ex != 0 && dir_num + Ex != 9) {
                                    Ex += dir_num;
                                }
                                Edown_clicked = false;
                                Erotleg = 0;
                                Erobot_y = 0;
                                Erobot_x = 0;
                                break;
                            }
                            Sleep(  (int)(game.robot.Emove_speed*speed));
                        }
                    }
                };
                anime.start();
            }
        }
    }
    public void Up(){                                                                                        //Вира!
        if(!up_clicked && !down_clicked && !fire_clicked && !dead) {
            if (y < 3) {
                up_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        int dir_num = dir;
                        int rotdir = 1;
                        boolean acess_x = false;
                        boolean acess_y = false;
                        while (true) {
                            if (robot_y < (height / 5)) {
                                robot_y += 2;
                            }else{
                                acess_y = true;
                            }
                            if (dir_num + x != 0 && dir_num + x != 9) {
                                if (dir_num * robot_x <= (width / 10)) {
                                    robot_x += dir_num * 2;
                                }else{
                                    acess_x = true;
                                }
                            }else{
                                acess_x = true;
                            }
                            if (rotdir == 1) {
                                rotleg += 2;
                                if (rotleg > 90) {
                                    rotdir = 0;
                                }
                            } else {
                                rotleg -= 2;
                                if (rotleg < 0) {
                                    rotdir = 1;
                                }
                            }
                            if (acess_x && acess_y) {
                                y += 1;
                                if (dir_num + x != 0 && dir_num + x != 9) {
                                    x += dir_num;
                                }
                                break;
                            }
                            Sleep(  (int)(game.robot.move_speed*speed));
                        }
                        up_clicked = false;
                        rotleg = 0;
                        robot_y = 0;
                        robot_x = 0;
                    }
                };
                anime.start();
            }
        }
    }
    public void Down(){                                             //Майна!
        if(!up_clicked && !down_clicked && !fire_clicked  && !dead) {
            if (y > 1) {
                down_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        int dir_num = dir;
                        int rotdir = 1;
                        boolean acess_x = false;
                        boolean acess_y = false;
                        while (true) {
                            if (robot_y > -(height / 5)) {
                                robot_y -= 2;
                            }else{
                                acess_y = true;
                            }
                            if (dir_num + x != 0 && dir_num + x != 9) {
                                if (dir_num * robot_x <= (width / 10)) {
                                    robot_x += dir_num * 2;
                                }else{
                                    acess_x = true;
                                }
                            }else{
                                acess_x = true;
                            }
                            if (rotdir == 1) {
                                rotleg += 2;
                                if (rotleg > 90) {
                                    rotdir = 0;
                                }
                            } else {
                                rotleg -= 2;
                                if (rotleg < 0) {
                                    rotdir = 1;
                                }
                            }
                            if (acess_x && acess_y) {
                                y -= 1;
                                if (dir_num + x != 0 && dir_num + x != 9) {
                                    x += dir_num;
                                }
                                break;
                            }
                            Sleep(  (int)(game.robot.move_speed*speed));
                        }
                        down_clicked = false;
                        rotleg = 0;
                        robot_y = 0;
                        robot_x = 0;
                    }
                };
                anime.start();
            }
        }
    }
    public void ERedir() {                                                       // Поворот.
        if (!Eredir_clicked && !Efire_clicked && !Edead) {
            Eredir_clicked = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while(true) {
                        if(Edir == 1) {
                            if (Erothand < 270) {
                                Erothand += 3;
                            } else {
                                Erothand = 270;
                                break;
                            }
                        }else{
                            if (Erothand > 0) {
                                Erothand -= 3;
                            } else {
                                Erothand = 0;
                                break;
                            }
                        }
                        Sleep(  (int)(5*speed));
                    }
                    Eredir_clicked = false;
                    Edir = -Edir;
                }
            };
            anime.start();
        }
    }
    public void Redir() {                                                       // Поворот.
        if (!redir_clicked && !fire_clicked && !dead) {
            redir_clicked = true;
            Thread anime = new Thread() {
                @Override
                public void run() {
                    while(true) {
                        if(dir == 1) {
                            if (rothand < 270) {
                                rothand += 3;
                            } else {
                                rothand = 270;
                                break;
                            }
                        }else{
                            if (rothand > 0) {
                                rothand -= 3;
                            } else {
                                rothand = 0;
                                break;
                            }
                        }
                        Sleep(  (int)(5*speed));
                    }
                    redir_clicked = false;
                    dir = -dir;
                }
            };
            anime.start();
        }
    }
    public void EJump() {                                                                // На самом деле, это не прыжок, а телепорт. Не баг, а фича!
        if (!Eup_clicked && !Edown_clicked && !Ejump_clicked  && !Edead) {
            if (EEnergyExists(30)) {
                EEnergyUse(30);
                Ejump_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        Eswap = true;
                        while (true) {
                            Escale -= 0.02f;
                            Erobot_y += 5;
                            if (Escale < 0.5f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        Ex += 4 * Edir;
                        if (Ex < 1) {
                            Ex = 1;
                        }
                        if (Ex > 8) {
                            Ex = 8;
                        }
                        while (true) {
                            Escale += 0.02f;
                            Erobot_y -= 5;
                            if (Escale > 0.8f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        Eswap = false;
                        Escale = 0.8f;
                        Erobot_y = 0;
                        Erobot_x = 0;
                        Ejump_clicked = false;
                    }
                };
                anime.start();
            }
        }
    }
    public void Jump() {                                                                // На самом деле, это не прыжок, а телепорт. Не баг, а фича!
        if (!up_clicked && !down_clicked && !jump_clicked && !dead) {
            if (EnergyExists(30)) {
                EnergyUse(30);
                jump_clicked = true;
                Thread anime = new Thread() {
                    @Override
                    public void run() {
                        swap = true;
                        while (true) {
                            scale -= 0.02f;
                            scale_inteface-=0.003;
                            robot_y += 5;
                            if (scale < 0.5f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        x += 4 * dir;
                        if (x < 1) {
                            x = 1;
                        }
                        if (x > 8) {
                            x = 8;
                        }
                        while (true) {
                            scale += 0.02f;
                            scale_inteface+=0.003;
                            robot_y -= 5;
                            if (scale > 0.8f) {
                                break;
                            }
                            Sleep(  (int)(8*speed));
                        }
                        swap = false;
                        scale = 0.8f;
                        robot_y = 0;
                        robot_x = 0;
                        jump_clicked = false;
                    }
                };
                anime.start();
            }
        }
    }
    @Override
    public void dispose (){                                                        //Очистка памяти.
        batch.dispose();
        floor.dispose();
        up.dispose();
        down.dispose();
        redir.dispose();
        fire.dispose();
        jump.dispose();
        up_touched.dispose();
        down_touched.dispose();
        redir_touched.dispose();
        fire_touched.dispose();
        jump_touched.dispose();
        door_left.dispose();
        door_right.dispose();
    }
}