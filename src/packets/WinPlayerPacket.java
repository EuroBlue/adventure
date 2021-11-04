package packets;

import java.io.Serializable;

public class WinPlayerPacket implements Serializable{

    public String name;
    private static final long serialVersionUID = 1L;
    public WinPlayerPacket(String n)
    {
        name=n;
    }
}
