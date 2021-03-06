public class Game {
    public Player user;
    public Ort ziel;
    public Ort eingang;
    public Ort restaurant;
    public Ort spielplatz;
    public Ort streichelzoo;
    public Ort kiosk;
    public Ort toiletten;
    public Ort grillplatz;
    public Ort badesee;
    public boolean zu_ende=false;
    public Game(String name)
    {
        ziel=new Ort("Parkplatz");
        eingang=new Ort("Eingang");
        restaurant=new Ort("Restaurant");
        spielplatz=new Ort("Spielplatz");
        streichelzoo=new Ort("Streichelzoo");
        kiosk=new Ort("Kiosk");
        toiletten=new Ort("Toiletten");
        grillplatz=new Ort("Grillplatz");
        badesee=new Ort("Badesee");
        connectOrt(ziel, null, null, null, eingang);
        connectOrt(eingang, restaurant, streichelzoo, ziel, null);
        connectOrt(restaurant, null, ziel.unten, restaurant, spielplatz);
        connectOrt(kiosk, spielplatz, toiletten, streichelzoo, grillplatz);
        connectOrt(grillplatz, null, badesee, kiosk, null);

        user=new Player(badesee,name);
    }
    public void connectOrt(Ort main,Ort l, Ort r, Ort u, Ort d)
    {
        main.links=l;
        if (l!=null){l.rechts=main;}

        main.rechts=r;
        if (r!=null){r.links=main;}

        main.oben=u;
        if (u!=null){u.unten=main;}

        main.unten=d;
        if (d!=null){d.oben=main;}
    }
    public boolean gewonnen()
    {
        if (user.getStandort().getname()=="Parkplatz")
        {
            return true;
        }
        return false;
    }
    public void end()
    {
        this.zu_ende=true;
    }
}
