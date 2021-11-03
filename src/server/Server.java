package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
            System.out.println(toGameCode.conversion(serverSocket.getInetAddress()));
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
        while(running)
        {
            try
            {
                Socket socket=serverSocket.accept();
                InitSocket(socket);
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
