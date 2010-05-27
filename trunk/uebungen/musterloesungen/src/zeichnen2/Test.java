/*
 * Created on 28.10.2008
 *
 */
package zeichnen2;

public class Test
{
    public void test()
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
    }
}
