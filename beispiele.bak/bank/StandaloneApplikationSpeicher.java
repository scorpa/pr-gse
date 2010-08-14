package bank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import bank.fachlogik.KontoVerwaltung;
import bank.fachlogik.KontoVerwaltungException;
import bank.fachlogik.SpeicherKontoVerwaltung;
import bank.gui.HauptFenster;

/**
 * Applikationsklasse, enth�lt die main-Methode
 * @author Rudolf Radlbauer
 *
 */
public class StandaloneApplikationSpeicher
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
        
        final KontoVerwaltung verwaltung = new SpeicherKontoVerwaltung();
        
        
        final HauptFenster fenster = new HauptFenster(verwaltung);
        fenster.addWindowListener(new WindowAdapter(){
        	public void windowClosed(WindowEvent w)
        	{
                try
                {
                    verwaltung.close();
                } catch (KontoVerwaltungException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(fenster, "Fehler beim Schlie�en der Kontoverwaltung: " + e.getMessage());
                }
        		System.exit(0);
        	}
        });

        fenster.setSize(800,600);
        fenster.setVisible(true);
        

    }

}
