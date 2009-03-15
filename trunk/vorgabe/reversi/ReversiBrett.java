/*
 * Created on 15.03.2009
 *
 */
package reversi;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class ReversiBrett extends JFrame
{
    private Reversi reversi;
    private ReversiPanel panel;
    
    public ReversiBrett(Reversi reversi) throws HeadlessException
    {
        super("Reversi");
        this.reversi = reversi;
    }
    
    

}
