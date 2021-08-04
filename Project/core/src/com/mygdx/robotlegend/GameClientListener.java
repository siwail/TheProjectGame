package com.mygdx.robotlegend;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;
public class GameClientListener extends Listener {
    GamePlay play;
    ClientPacket packet;
    Connection connection_client;
    int packets = 0;
    public GameClientListener(GamePlay play) {
        packet = new ClientPacket();
        this.play = play;
    }
    public void connect_send(Connection connection) {
        this.connection_client = connection;
        Log.info("Клиаент вроде полкючен");
        play.connected = true;
        Thread connect = new Thread() {
            public void run() {
                while (!play.closed) {
                    updatePacket();
                    Log.info("Пакет отправлен от клиента к серверу");
                    connection_client.sendUDP(packet);
                    try {
                        Thread.sleep(100);
                    } catch (Exception ignored) {
                    }
                }
            }
        };
        connect.start();
    }
    public void updatePacket() {
        packet.turnedUp = play.turnedUp;
        packet.turnedDown = play.turnedDown;
        packet.turnedFire = play.turnedFire;
        packet.turnedRedir = play.turnedRedir;
        packet.turnedBall = play.turnedBall;
        packet.turnedJump = play.turnedJump;
        packet.skin = play.game.robot.skin;
        packet.Hid = play.game.robot.Hid;
        packet.Bid = play.game.robot.Bid;
        packet.RHid = play.game.robot.RHid;
        packet.LHid = play.game.robot.LHid;
        packet.RLid = play.game.robot.RLid;
        packet.LLid = play.game.robot.LLid;
    }
    public void received(Connection connection, Object packet_send) {
        if(!play.connected){
            connect_send(connection);
        }
        play.connected = true;
        if (packet_send instanceof ClientPacket) {
            packets++;
            ClientPacket packet = (ClientPacket) packet_send;
            Log.info("Пакет получен от сервера к клиенту");
            play.MEturnedBall = packet.turnedBall;
            play.MEturnedUp = packet.turnedUp;
            play.MEturnedDown = packet.turnedDown;
            play.MEturnedFire = packet.turnedFire;
            play.MEturnedJump = packet.turnedJump;
            play.MEturnedRedir = packet.turnedRedir;
            play.MEturnedMeteor = packet.turnedMeteor;
            play.MEturnedBoom = packet.turnedBoom;


            play.game.robot.level = packet.level;
            play.game.robot.Eskin = packet.skin;
            play.game.robot.EHid = packet.Hid;
            play.game.robot.EBid = packet.Bid;
            play.game.robot.ERHid = packet.RHid;
            play.game.robot.ELHid = packet.LHid;
            play.game.robot.ERLid = packet.RLid;
            play.game.robot.ELLid = packet.LLid;
        }
        if(packets == 1){
            play.needOnlineChanges = true;
        }
    }
}
