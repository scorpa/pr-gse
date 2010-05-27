/*
 * Created on 19.05.2009
 *
 */
package mitglied_gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Testklasse für die zu erstellenden Dialoge
 * @author Rudolf Radlbauer
 *
 */
public class Test
{

    /**
     * Es wird eine Mitglied-Instanz erstellt und damit ein <b>modaler</b> Dialog zum 
     * Editieren des Mitglieds geöffnet. Nachdem der Dialog geschlossen wird, 
     * wird das Mitglied zu Testzwecken auf die Konsole ausgegeben.
     * @param args ignoriert
     */
    public static void main(String[] args)
    {
        Mitglied mitglied = new Mitglied();
        MitgliedFenster fenster = new MitgliedFenster(mitglied);
        fenster.setVisible(true);
        System.out.println(mitglied);
        
        JOptionPane.showMessageDialog(null, 
        		"nun sollte ein weiterer Dialog mit gleichen Daten erscheinen!");
        
        fenster = new MitgliedFenster(mitglied);
        fenster.setVisible(true);
        System.out.println(mitglied);

    }

}
