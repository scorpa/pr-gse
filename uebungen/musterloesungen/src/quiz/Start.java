package quiz;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Start
{
    public static void main(String[] args)
    {
        DateiAnbindung da = new DateiAnbindung("fragen.csv");
        try
        {
            HauptFenster fenster = new HauptFenster(da.lesen());
            fenster.pack();
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenster.setVisible(true);
        } catch (IOException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "kann Fragendatei nicht laden");
            System.exit(-1);
        }
    }
}
