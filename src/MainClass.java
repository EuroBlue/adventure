import java.io.Console;
public class MainClass {
    public static void main(String[] args) throws Exception {
        Game g=new Game();
        Console c=System.console();
        System.out.println("Du bist beim Baden eingedöst, langsam wird es dunkel.\nBevor nachts zwielichtige Gestalten kommen,\nsolltest Du schnell zu Deinem Auto...");
        while (g.gewonnen()!=true||g.user.getStandort()==null)
        {
            g.info();
            g.user.walk(c.readLine());
            if (g.gewonnen()==true)
            {
                System.out.println("Du hast gewonnen!\nDas Spiel ist vorbei.");
            }
            else if (g.user.getStandort()==null)
            {
                System.out.println("Du hast verloren!\nDu wurdest im Wald von einem Bären gefressen.");
            }
        }
    }
}
