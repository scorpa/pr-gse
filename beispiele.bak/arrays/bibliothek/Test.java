package arrays.bibliothek;


public class Test
{
    public static void test()
    {
        BuchVerwaltung verwaltung = new BuchVerwaltung(8);

        Buch b1 = new Buch();
        b1.setAutor("Grimm");
        b1.setTitel("Rotkäppchen");
        b1.setSeiten(5);
        verwaltung.aufnehmen(b1);
        
        Buch b2 = new Buch();
        b2.setAutor("Grimm");
        b2.setTitel("Schneewittchen");
        b2.setSeiten(6);
        verwaltung.aufnehmen(b2);
        
        Buch b3 = new Buch();
        b3.setAutor("Grimm");
        b3.setTitel("Frau Holle");
        b3.setSeiten(4);
        verwaltung.aufnehmen(b3);
        
        Buch b4 = new Buch();
        b4.setAutor("Walt Disney");
        b4.setTitel("Bambi");
        b4.setSeiten(20);
        verwaltung.aufnehmen(b4);
        
        Buch b5 = new Buch();
        b5.setAutor("Walt Disney");
        b5.setTitel("Micky Maus");
        b5.setSeiten(30);
        verwaltung.aufnehmen(b5);
        

        verwaltung.liste();
        verwaltung.ausmustern(b2);
        verwaltung.liste();
        System.out.println(verwaltung.mehrSeiten(10) + " Bücher mit mehr als 10 Seiten");
        
    }

}
