package server;

import packets.*;
public class ServerListener {
    public void recived(Object p)
    {
        if(p instanceof AddConnectionPacket)
        {
            AddConnectionPacket packet=(AddConnectionPacket)p;
            System.out.println(packet.name+" hat beigetreten.");
        }
        else if(p instanceof RemoveConnectionPacket)
        {
            RemoveConnectionPacket packet=(RemoveConnectionPacket)p;
            System.out.println(packet.name+" hat das Spiel verlassen.");
        }
        else if(p instanceof WinPlayerPacket)
        {
            WinPlayerPacket packet=(WinPlayerPacket)p;
            for (int i = 0; i < Connection.connections.size(); i++) {
                Connection.connections.get(i).sendObject(new GameEndPacket(packet.name));
            }
        }
    }
}
