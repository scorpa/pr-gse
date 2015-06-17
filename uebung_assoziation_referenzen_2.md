# Referenzen (2) #

Was wird bei einem Aufruf der Methode `test()` der folgenden Klasse `Test` auf die Konsole ausgegeben?
(Es wird dabei die Klasse [Punkt](http://code.google.com/p/pr-gse/source/browse/trunk/uebungen/musterloesungen/src/zeichnen2/Punkt.java) von Aufgabe [Rechteck (B)](http://code.google.com/p/pr-gse/wiki/uebung_assoziation_rechteck_B) als gegeben angenommen.)

```

public class Test
{
    public static void main(String[] args)
    {
        Punkt p1 = new Punkt(200,100);
        Punkt p2 = new Punkt(p1);
        Punkt p3 = p2;
        p3.horizontalVerschieben(p2.getY());
        int x1 = p1.getX();
        int x2 = p2.getX();
        int x3 = p3.getX();
        System.out.println(x1 + "," + x2 + "," + x3);
        p3 = new Punkt(p1);
        p3.horizontalVerschieben(p2.getX());
        x1 = p1.getX();
        x2 = p2.getX();
        x3 = p3.getX();
        System.out.println(x1 + "," + x2 + "," + x3); 
        if (p1 == p2)
            System.out.println("p1 gleich p2");
        if (p2 == p3)
            System.out.println("p2 gleich p3");
       
    }
}

```