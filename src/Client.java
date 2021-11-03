import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import packets.*;
public class Client implements Runnable{


    public String host;
    public int port;

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    public boolean running=false;
    private ClientListener listner;

    public Client(String host, int port)
    {
        this.host=host;
        this.port=port;
        listner=new ClientListener();
    }

    public boolean connect()
    {
        try
        {
            socket=new Socket(host,port);
            out=new ObjectOutputStream(socket.getOutputStream());
            in=new ObjectInputStream(socket.getInputStream());
            AddConnectionPacket packet=new AddConnectionPacket(MainClass.g.user.nick);
            sendObject(packet);
            new Thread().start();
        } 
        catch (ConnectException e)
        {
            return false;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void close()
    {
        try {
            running=false;
            RemoveConnectionPacket packet=new RemoveConnectionPacket(MainClass.g.user.nick);
            sendObject(packet);
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendObject(Object packet)
    {
        try
        {
            out.writeObject(packet);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try
        {
            running=true;
            while(running)
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
                catch (SocketException e)
                {
                    close();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
