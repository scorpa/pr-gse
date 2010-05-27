/*
 * Created on 20.12.2008
 *
 */
package sensor;

public class Test
{

    public static void test()
    {
        Sensor s = new Sensor(5, -5);
        s.zufallsWerte(12);
        s.ausgeben();
        s.ausgebenGroesser(-1);
        s.loeschen(1);
        s.ausgeben();
        s.anzahlLoeschen(3);
        s.ausgeben();
        s.neuerWert(0);
        s.ausgeben();
        s.einfuegen(2, 0);
        s.ausgeben();
        s.vertauschen(1, 2);
        s.ausgeben();
        s.umdrehen();
        s.ausgeben();
        System.out.println("max=" + s.maximum());
        System.out.println("maxIndex=" + s.maximumIndex());
        
        
        
    }

}
