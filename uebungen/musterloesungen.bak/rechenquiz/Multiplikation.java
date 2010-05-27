/*
 * Created on 10.03.2009
 *
 */
package rechenquiz;

public class Multiplikation extends Rechnung
{

    public Multiplikation()
    {
        super(3);
    }

    @Override
    public int getErgebnis()
    {
        return getOperand1() * getOperand2();
    }

    @Override
    public String toString()
    {
        return getOperand1() + " x " + getOperand2() + " = ";
    }

}
