import java.util.Locale;

public class Player {
    public Ort standort;

    public Player(Ort o)
    {
        standort = o;//this just creates the person at a certing starting point
    }
    public void walk(String s)
    {
        s = s.toLowerCase();
        switch (s){
            case "links":
                if(standort.links != null){
                    standort = standort.links;
                    System.out.println("du bis nun am Standort: "+  standort);
                }else{
                    System.out.println("Nicht zulaessige Bewegung");
                }
                break;
            case "rechts" :
                if(standort.rechts != null){
                    standort = standort.links;
                    System.out.println("du bis nun am Standort: "+  standort);
                }else{
                    System.out.println("Nicht zulaessige Bewegung");
                }
                break;
            case "oben" :
                if(standort.oben != null){
                    standort = standort.links;
                    System.out.println("du bis nun am Standort: "+  standort);
                }else{
                    System.out.println("Nicht zulaessige Bewegung");
                }
                break;
            case "unten" :
                if(standort.unten != null){
                    standort = standort.links;
                    System.out.println("du bis nun am Standort: "+  standort);
                }else{
                    System.out.println("Nicht zulaessige Bewegung");
                }
                break;
            default: System.out.println("Nicht zulaessige Bewegung");
        }
    }
}