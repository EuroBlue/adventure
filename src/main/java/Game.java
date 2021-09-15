public class Game {
    public Player user;
    public Ort ziel;
    public Game()
    {
        ziel=new Ort("Parkplatz");
        connectOrt(ziel, null, null, null, new Ort("Eingang"));
        connectOrt(ziel.unten, new Ort("Restaurant"), new Ort("Streichelzoo"), null, null);
        connectOrt(ziel.unten.links, null, ziel.unten, null, new Ort("Spielplatz"));
        connectOrt(new Ort("Kiosk"), ziel.unten.links.unten, new Ort("Toiletten"), ziel.unten.rechts, new Ort("Grillplatz"));
        connectOrt(ziel.unten.rechts.unten.unten, null, new Ort("Badesee"), ziel.unten.rechts.unten, null);

        user=new Player(ziel);
    }
    public void play()
    {
        
    }
    public void connectOrt(Ort main,Ort l, Ort r, Ort u, Ort d)
    {
        main.links=l;
        l.rechts=main;

        main.rechts=r;
        r.links=main;

        main.oben=u;
        u.unten=main;

        main.unten=d;
        d.oben=main;
    }
}
