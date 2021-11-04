package packets;

import java.io.Serializable;

public class GameEndPacket implements Serializable{

    public String name;
    private static final long serialVersionUID = 1L;
    public GameEndPacket(String n)
    {
        name=n;
    }
}
