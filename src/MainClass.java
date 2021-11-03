import java.io.Console;

import server.Server;
public class MainClass {
    public static Game g;
    public static Client client=new Client("0",-1);
    public static Server server=new Server(0);
    public static void main(String[] args) throws Exception {
        while(true)
        {
            System.out.print("Host - h, Client - c: ");
            if(input().toLowerCase().equals("h"))
            {
                host();
            }
            else if(input().toLowerCase().equals("c"))
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
            System.out.print("Gebe den Host ein: ");
            client.host=input();
            System.out.print("Gebe das Port ein: ");
            client.port=Integer.parseInt(input());
            client.connect();
            while(client.running)
            {
                System.out.print("Wie wilst du gennant werden?: ");
                g=new Game(input());
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
                g=null;
                client.close();
            }
        }
    }
    public static void host()
    {
        while(!server.running)
        {
            System.out.println("Dein Server ist nicht gestartet!");
            System.out.print("Gebe day Port ein: ");
            server.port=Integer.parseInt(input());
            server.start();
            while(server.running)
            {
                continue;
            }
        }
    }
    public static String input()
    {
        Console console = System.console();
        return console.readLine();
    }
}
