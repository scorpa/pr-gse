/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;

/**
 *
 * @author Rudi
 */
public class TictactoeTestImpl implements Spielfeld
{

    public int getNZeilen()
    {
        return 3;
    }

    public int getNSpalten()
    {
        return 4;
    }

    public int getGewinnZahl()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public FARBE get(int zeile, int spalte)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public FARBE getNext()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public FARBE getSieger()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void set(int zeile, int spalte) throws TictactoeException
    {
        throw new TictactoeException("Not supported yet.");
    }

}
