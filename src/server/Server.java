package server;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
public class Server implements Runnable{
    public int port;
    private ServerSocket serverSocket;
    public boolean running=false;


    public Server(int port)
    {
        this.port=port;
        try
        {
            serverSocket=new ServerSocket(port);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start()
    {
        new Thread(this).start();
    }


    @Override
    public void run()
    {
        running=true;
        try {
            toGameCode.conversion(serverSocket.getInetAddress().getLocalHost());
            System.out.println(InetAddress.getLocalHost().toString());
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
        while(running)
        {
            try
            {
                System.out.println("versuch");
                Socket socket=serverSocket.accept();
                InitSocket(socket);
                System.out.println("Es leuft");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void InitSocket(Socket socket)
    {
        Connection connection=new Connection(socket);
        new Thread(connection).start();
    }

    public void ShutDown()
    {
        running=false;
        try
        {
            serverSocket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
