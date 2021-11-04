package packets;

import java.io.Serializable;

public class RemoveConnectionPacket implements Serializable{

    public String name;
    private static final long serialVersionUID = 1L;
    public RemoveConnectionPacket(String n)
    {
        name=n;
    }
}
