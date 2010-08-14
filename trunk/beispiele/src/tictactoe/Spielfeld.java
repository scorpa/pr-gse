/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;

/**
 *
 * @author Rudi
 */
public interface Spielfeld
{

    public int getNZeilen();
    public int getNSpalten();
    /**
     * gibt die Anzahl der nötigen Steine in
     * einer Reihe für den Gewinn des Spiels ein
     * @return
     */
    public int getGewinnZahl();
    public FARBE get(int zeile, int spalte);
    public FARBE getNext();
    public FARBE getSieger();

    /**
     * 
     * @param zeile
     * @param spalte
     */
    public void set(int zeile, int spalte) throws TictactoeException;
}
