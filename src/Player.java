public class Player {
    public Ort standort;
    public String nick;
    public int id;
    public Player(Ort o, String n)
    {
        nick=n;
        standort = o;
    }
    public void walk(String s)
    {
        s = s.toLowerCase();
        switch (s){
            case "links":
                if(standort.links != null)
                {
                    standort = standort.links;
                }
                else
                {
                    System.out.println("Nicht zugelassene Bewegung");
                }
                break;
            case "rechts" :
                if(standort.rechts != null){
                    standort = standort.rechts;
                }else{
                    System.out.println("Nicht zugelassene Bewegung");
                }
                break;
            case "oben" :
                if(standort.oben != null){
                    standort = standort.oben;
                }else{
                    System.out.println("Nicht zugelassene Bewegung");
                }
                break;
            case "unten" :
                if(standort.unten != null){
                    standort = standort.unten;
                }else{
                    System.out.println("Nicht zugelassene Bewegung");
                }
                break;
            default: System.out.println("Nicht zugelassene Bewegung");
        }
    }
    public Ort getStandort()
    {
        return standort;
    }
}