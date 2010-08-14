package bank;



import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import bank.persistenz.DateiKontoVerwaltung;
import bank.fachlogik.KontoVerwaltung;
import bank.fachlogik.KontoVerwaltungException;
import bank.gui.HauptFenster;

/**
 * Applikationsklasse, enthält die main-Methode
 * @author Rudolf Radlbauer
 *
 */
public class StandaloneApplikationDatei
{

    /**
     * Start der Applikation:
     * konfiguriert die KontoVerwaltungFactory, 
     * instanziiert ein Hauptfenster und zeigt es an
     * @param args
     */
    public static void main(String[] args)
    {
        // Systemspezifisches Look & Feel
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        
        KontoVerwaltung verwaltung = null;
		try
		{
			verwaltung = new DateiKontoVerwaltung("konten.ser");
		} catch (KontoVerwaltungException e1)
		{
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Fehler beim Einlesen der Daten",
					JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
        
		// benötigen wir für anonymen WindowAdapter
		final KontoVerwaltung verwaltungForClose = verwaltung;   
		
        final HauptFenster fenster = new HauptFenster(verwaltung);
        fenster.addWindowListener(new WindowAdapter(){
        	public void windowClosed(WindowEvent w)
        	{
                try
                {
                    verwaltungForClose.close();
                } catch (KontoVerwaltungException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(fenster, "Fehler beim Schließen der Kontoverwaltung: " + e.getMessage());
                }
        		System.exit(0);
        	}
        });

        fenster.setSize(800,600);
        fenster.setVisible(true);
        

    }

}
