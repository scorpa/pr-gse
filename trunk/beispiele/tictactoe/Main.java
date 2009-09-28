/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Rudi
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Spielfeld spiel = new TictactoeTestImpl();
        GUI gui = new GUI(spiel);
        gui.setVisible(true);
    }
}
