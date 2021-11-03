package server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Connection implements Runnable{

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private ServerListener listner;

    public static ArrayList<Connection> connections=new ArrayList<Connection>();

    public Connection(Socket socket)
    {
        this.socket=socket;
        try {
            out=new ObjectOutputStream(socket.getOutputStream());
            in=new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        connections.add(this);
    }


    @Override
    public void run()
    {
        try
        {
            while(socket.isConnected())
            {
                try
                {
                    Object data=in.readObject();
                    listner.recived(data);
                }
                catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void close()
    {
        try
        {
            in.close();
            out.close();
            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void sendObject(Object packet)
    {
        try
        {
            out.writeObject(packet);
            out.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
