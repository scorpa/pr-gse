package referenzen;

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
