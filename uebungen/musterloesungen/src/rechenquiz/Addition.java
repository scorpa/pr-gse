/*
 * Created on 10.03.2009
 *
 */
package rechenquiz;

public class Addition extends Rechnung
{

    public Addition()
    {
        super(1);
    }

    @Override
    public int getErgebnis()
    {
        return getOperand1() + getOperand2();
    }

    @Override
    public String toString()
    {
        return getOperand1() + " + " + getOperand2() + " = ";
    }

}
