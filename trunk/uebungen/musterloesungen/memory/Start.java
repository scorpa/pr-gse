/*
 * Created on 09.05.2009
 *
 */
package memory;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Start
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            Memory m = new MemoryImpl(4,5);
            MemoryGUI gui = new MemoryGUI(m);
            gui.setVisible(true);
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        

    }

}
