public class Ort {
    public String name;
    public Ort unten;
    public Ort oben;
    public Ort rechts;
    public Ort links;

    public Ort(String n)
    {
        name=n;
    }
    public void printInfo()
    {
        System.out.print("Du bist in dem Ort "+this.name+".\nDu kanst sich nach ");
        if (unten!=null) {
            System.out.print("unten, ");
        }
        if (oben!=null) {
            System.out.print("oben, ");
        }
        if (links!=null) {
            System.out.print("links, ");
        }
        if (rechts!=null) {
            System.out.print("rechts, ");
        }
        System.out.println("bewegen.");
    }
    public String getname()
    {
        return name;
    }
}