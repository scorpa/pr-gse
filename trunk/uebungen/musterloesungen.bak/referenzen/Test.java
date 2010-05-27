package referenzen;

/**
 * Übung zum Verständnis von Referenzen
 * 
 * @author (Rudolf Radlbauer) 
 * @version (23.11.2009)
 */
public class Test
{
    public void run()
    {
        Person p1;
        Person p2;
        int x;
        int y;
        p1 = new Person();
        p2 = p1;
        x = 1;
        y = x;
        y = 2;
        p2.setName("Hugo");
        p1.setGeschlecht('m');
        p1 = new Person();
        p1.setName("Susi");
    }
}
