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
        System.out.println("Connecting...");
        try
        {
            socket=new Socket(host,port);
            System.out.println("Socket connected");
            out=new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Output esteblished");
            in=new ObjectInputStream(socket.getInputStream());
            System.out.println("Input esteblished");
            AddConnectionPacket packet=new AddConnectionPacket(MainClass.g.user.nick);
            sendObject(packet);
            System.out.println("Sending handshake");
            new Thread(this).start();
        }
        catch (ConnectException e)
        {
            System.out.println("ConnectException");
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
        System.out.println("Starting");
        try
        {
            running=true;
            System.out.println("Started");
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
