/*
 * Created on 10.03.2009
 *
 */
package rechenquiz;

public class Subtraktion extends Rechnung
{

    public Subtraktion()
    {
        super(2);
    }

    @Override
    public int getErgebnis()
    {
        return getOperand1() - getOperand2();
    }

    @Override
    public String toString()
    {
        return getOperand1() + " - " + getOperand2() + " = ";
    }

}
