import packets.*;
public class ClientListener {
    public void recived(Object p)
    {
        if(p instanceof GameEndPacket)
        {
            GameEndPacket packet=(GameEndPacket)p;
            System.out.println(packet.name+" hat gewonnnen.");
            MainClass.g.end();
        }
        else if (p instanceof GameStartPacket)
        {
            MainClass.started=true;
        }
    }
}
