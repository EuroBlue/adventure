import java.io.Console;
public class MainClass {
    public static void main(String[] args) throws Exception {
        Game g=new Game();
        System.out.println("Du bist beim Baden eingedöst, langsam wird es dunkel.\nBevor nachts zwielichtige Gestalten kommen,\nsolltest Du schnell zu Deinem Auto...");
        while (!g.gewonnen())
        {
            g.user.standort.printInfo();
            System.out.print("s");;
            g.user.walk(input());
            if (g.gewonnen()==true)
            {
                System.out.println("Du hast gewonnen!\nDas Spiel ist vorbei.");
            }
        }
    }
    public static String input()
    {
        Console console = System.console();
        return console.readLine();
    }
}
