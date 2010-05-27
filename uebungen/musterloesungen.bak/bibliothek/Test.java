/*
 * Created on 16.11.2008
 *
 */
package bibliothek;

public class Test
{

    /**
     * @param args
     */
    public void test()
    {
        Buch b;
        BuchVerwaltung verwaltung = new BuchVerwaltung();
        
        b = new Buch("12345");
        b.setAutor("Grimm");
        b.setSeiten(20);
        b.setTitel("Schneewittchen");
        b.setVerlag("Märchenverlag");
        verwaltung.anlegen(b);
        
        b = new Buch("678910");
        b.setAutor("Karl Marx");
        b.setSeiten(250);
        b.setTitel("Das Kapital");
        b.setVerlag("Geldverlag");
        verwaltung.anlegen(b);
        
        b.entlehnen("Maier");
        
        verwaltung.liste();
        verwaltung.listeEntlehnt();
        verwaltung.listeVerfuegbar();
        System.out.println(verwaltung.anzahlEntlehnt());
        

    }

}
