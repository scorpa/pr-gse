/*
 * Created on 17.03.2006
 *
 */
package bank.gui;

import bank.fachlogik.Konto;
import bank.fachlogik.KontoVerwaltung;
import bank.fachlogik.KontoVerwaltungException;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * Inneres Fenster für das Erstellen oder Bearbeiten eines Kontos. Bei Erstellen
 * eines neuen Kontos wird dieses durch Betätigen der Schaltfläche "SPEICHERN"
 * in die Kontoverwaltung aufgenommen
 * 
 * @author Rudolf Radlbauer
 */
public class KontoFenster extends JInternalFrame
{
    /**
     * @uml.property name="panel"
     * @uml.associationEnd inverse="kontoFenster1:gui.KontoPanel"
     */
    private KontoPanel panel; // Referenz auf eingebautes KontoPanel

    private KontoVerwaltung verwaltung; // Referenz auf verwendete
    									// KontoVerwaltung

    /**
     * Konstruktor für Bearbeitung eines bereits bestehenden Kontos. Baut die
     * Oberfläche auf und befüllt die Textfelder
     * 
     * @param konto
     *            zu bearbeitendes Konto
     * @param verwaltung
     *            verwendete KontoVerwaltung
     */
    public KontoFenster(Konto konto, KontoVerwaltung verwaltung)
    {
        this.verwaltung = verwaltung;
        panel = new KontoPanel(konto);
        initFrame();
    }

    /**
     * Konstruktor für Erstellen eines neuen Kontos. Baut die Oberfläche auf und
     * befüllt Textfelder mit Standardwerten
     * 
     * @param verwaltung
     *            verwendete KontoVerwaltung
     * @throws IllegalStateException
     *             kann bei Erstellen der neuen Konto-Instanz auftreten
     * @throws KontoVerwaltungException
     *             kann bei Erstellen der neuen Konto-Instanz auftreten
     */
    public KontoFenster(KontoVerwaltung verwaltung)
            throws IllegalStateException, KontoVerwaltungException
    {
        this.verwaltung = verwaltung;
        panel = new KontoPanel(new Konto(verwaltung));
        initFrame();
    }

    /**
     * baut die Oberfläche zusammen
     * 
     */
    private void initFrame()
    {
        setTitle("Kto Nr. " + panel.getKonto().getNummer());
        getContentPane().add(panel, BorderLayout.CENTER); // KontoPanel
        setVisible(true);
        setClosable(true);
        setIconifiable(true);

        JPanel buttons = new JPanel(); // Button-Panel im Südbereich
        JButton speichern = new JButton("SPEICHERN");
        speichern.addActionListener(new ActionListener() { // anonyme innere
                    // Klasse
                    public void actionPerformed(ActionEvent e)
                    {
                        speichern();
                    }
                });

        JButton abbrechen = new JButton("ABBRECHEN");
        abbrechen.addActionListener(new ActionListener() { // anonyme innere
                    // Klasse
                    public void actionPerformed(ActionEvent e)
                    {
                        schliessen();
                    }
                });

        buttons.add(speichern);
        buttons.add(abbrechen);
        getContentPane().add(buttons, BorderLayout.SOUTH);
        pack();
        setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE); // ein
        // Listener
        // behandelt
        // diesen
        // Event
        // ->
        // schliessen()

        addInternalFrameListener(new InternalFrameAdapter() {
            public void internalFrameClosing(InternalFrameEvent e)
            {
                schliessen();
            }
        });
    }

    /**
     * wird bei aktivieren der Schaltfläche "SPEICHERN" aufgerufen
     * 
     */
    public void speichern()
    {
        try
        {
            panel.updateModel(); // Werte aus Textfeldern -> Konto-Instanz
            verwaltung.speichern(panel.getKonto());
            dispose();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Fehler beim Speichern", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * aufgerufen, wenn Fenster ohne speichern geschlossen wird Dialog, ob Daten
     * gespeichert werden sollen
     * 
     */
    public void schliessen()
    {
        int option = JOptionPane.showConfirmDialog(this,
                "Änderungen speichern?");
        switch (option)
        {
        case JOptionPane.OK_OPTION:
            speichern();
            break;

        case JOptionPane.CANCEL_OPTION:
            break; // Benutzer hat sichs anders überlegt -> nichts tun

        case JOptionPane.NO_OPTION:
            dispose();
            break;
        }

    }

    /**
     * liefert Referenz auf das im Konto-Panel dargestellte Konto
     * 
     * @return Referenz auf dargestelltes Konto
     */
    public Konto getKonto()
    {
        return panel.getKonto();
    }

}
