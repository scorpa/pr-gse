/*
 * Created on 28.10.2008
 *
 */
package zeichnen2;

public class Punkt
{
    private int x;
    private int y;
    
    
    
    public Punkt(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Punkt(Punkt p)
    {
        this.x = p.getX();
        this.y = p.getY();
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void horizontalVerschieben(int pix)
    {
        x += pix;
    }

    public void vertikalVerschieben(int pix)
    {
        y += pix;
    }

}
