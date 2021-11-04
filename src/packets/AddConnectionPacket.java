package packets;

import java.io.Serializable;

public class AddConnectionPacket implements Serializable{

    public String name;
    private static final long serialVersionUID = 1L;

    public AddConnectionPacket(String n)
    {
        name=n;
    }
}