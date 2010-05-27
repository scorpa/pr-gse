/*
 * Created on 10.03.2009
 *
 */
package rechenquiz;

import java.util.Random;

public abstract class Rechnung
{
    private int operand1;
    private int operand2;
    private int tipp;
    private int punkte;
    
    
    public Rechnung(int punkte)
    {
        super();
        this.punkte = punkte;
        Random r = new Random();
        operand1 = r.nextInt(101);
        operand2 = r.nextInt(101);
    }
    
    public void tippen(int tipp)
    {
        this.tipp = tipp;
    }
    
    public abstract int getErgebnis();
    
    public int berechnePunkte()
    {
        if (getErgebnis() == tipp)
            return punkte;
        else
            return 0;
    }

    public int getOperand1()
    {
        return operand1;
    }

    public int getOperand2()
    {
        return operand2;
    }

    public int getTipp()
    {
        return tipp;
    }
    
    

}
