package vererbung.zeichnen;

public class Test
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Bild b = new Bild();
        
        Kreis k1 = new Kreis(5);
        Kreis k2 = new Kreis(6);
        Rechteck r = new Rechteck(5, 3);
        
        b.einfuegen(k1);
        b.einfuegen(k2);
        b.einfuegen(r);
        
        System.out.println(b.berechneGesamtFlaeche());
        
        System.out.println(b);


    }

}
