import java.io.Console;



import server.Connection;
import packets.GameStartPacket;
import packets.WinPlayerPacket;
import server.Server;
public class MainClass {
    public static Game g;
    public static Client client=new Client("0",-1);
    public static Server server=new Server(0);
    public static boolean started=false;
    public static void main(String[] args) throws Exception {
        while(true)
        {
            System.out.print("Host - h, Client - c: ");
            String in=input();
            if(in.toLowerCase().equals("h"))
            {
                host();
            }
            else if(in.toLowerCase().equals("c"))
            {
                client();
            }
        }
    }
    public static void client()
    {
        while(!client.running)
        {
            System.out.println("Du bist nicht verbunden!");
            System.out.print("Gebe den GameCode ein: ");
            String s=GameCodeToIp.convertoInet(input());
            System.out.println(s);
            System.out.print("Gebe das Port ein: ");
            int p=Integer.parseInt(input());
            client=new Client(s,p);
            System.out.print("Wie wilst du gennant werden?: ");
            g=new Game(input());
            client.connect();
            try {
                for (int i = 1; i < 4; i++) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while(client.running)
            {
                System.out.println("Warte bis der Informatik got das spiel startet.");
                while(started)
                {
                    System.out.println("Du bist beim Baden eingedoest, langsam wird es dunkel.\nBevor nachts zwielichtige Gestalten kommen,\nsolltest Du schnell zu Deinem Auto...");
                    while (!g.gewonnen()&&!g.zu_ende)
                    {
                        g.user.standort.printInfo();
                        g.user.walk(input());
                        if (g.gewonnen())
                        {
                            System.out.println("Du hast gewonnen!\nDas Spiel ist vorbei.");
                        }
                    }
                    client.sendObject(new WinPlayerPacket(g.user.nick));
                    g=null;
                    client.close();
                }
            }
        }
    }
    public static void host()
    {
        while(!server.running)
        {
            System.out.println("Dein Server ist nicht gestartet!");
            System.out.print("Gebe day Port ein: ");
            server=new Server(Integer.parseInt(input()));
            server.boot();
            try {
                for (int i = 1; i < 4; i++) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(server.running)
            {
                System.out.println("starten? - start:");
                String s=input();
                if(s.toLowerCase().equals("start"))
                {
                    System.out.println("Spiel wird gestartet");
                    for (int i = 0; i < Connection.connections.size(); i++) {
                        Connection.connections.get(i).sendObject(new GameStartPacket());
                    }
                }
                System.out.println("Spiel leuft!!");
            }
        }
    }
    public static String input()
    {
        Console console = System.console();
        return console.readLine();
    }
}