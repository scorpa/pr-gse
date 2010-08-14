/*
 * Created on 17.03.2006
 *
 */
package bank.gui;

import bank.fachlogik.Konto;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ein KontoPanel ist eine Komponente, um Kontodaten darzustellen und soweit
 * zulässig zu editieren
 * 
 * @uml.dependency supplier="fachlogik.Konto"
 */
public class KontoPanel extends JPanel implements Observer
{
    private Konto konto; // Datenmodel für die Komponente (dargestelltes

    // Konto)

    // Textfelder zum Anzeigen / Editieren
    private JTextField tfNummer = new JTextField();

    private JTextField tfSaldo = new JTextField();

    private JTextField tfBesitzer = new JTextField();

    private JTextField tfLimit = new JTextField();

    /**
     * Konstruktor: baut die Oberfläche zusammen und befüllt die Textfelder mit
     * den Werten aus dem Konto
     * 
     * @param konto
     *            Datenmodell für diese Instanz der Komponente
     * @throws IllegalArgumentException
     *             wenn null übergeben wird
     */
    public KontoPanel(Konto konto) throws IllegalArgumentException
    {
        if (konto == null)
            throw new IllegalArgumentException("ungültige Konto-Instanz: null");
        this.konto = konto;
        konto.addObserver(this);
        init();
        updateView();
    }

    /**
     * baut die Oberfläche auf
     * 
     */
    private void init()
    {
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Kontonummer"));
        add(tfNummer);
        tfNummer.setEnabled(false);
        add(new JLabel("Saldo"));
        add(tfSaldo);
        tfSaldo.setEnabled(false);
        add(new JLabel("Besitzer"));
        add(tfBesitzer);
        add(new JLabel("Überziehungsrahmen"));
        add(tfLimit);

    }

    /**
     * befüllt die Textfelder mit den Werten aus dem Datenmodell (Konto-Instanz)
     * 
     */
    public void updateView()
    {
        tfNummer.setText(String.valueOf(konto.getNummer()));
        tfLimit.setText(String.valueOf(konto.getLimit()));
        tfSaldo.setText(String.valueOf(konto.getSaldo()));
        tfBesitzer.setText(konto.getBesitzer());

    }

    /**
     * liest die Daten aus den Textfeldern aus und ruft die entsprechenden
     * set-Methoden im Datenmodell (Konto-Instanz) auf
     * 
     * @throws IllegalStateException
     *             falls ungültige Werte in Textfeldern stehen
     */
    public void updateModel() throws IllegalStateException
    {
        konto.deleteObserver(this);
        
        konto.setBesitzer(tfBesitzer.getText());
        try
        {
            System.out.println(tfLimit.getText());
            konto.setLimit(Double.parseDouble(tfLimit.getText()));
        } catch (NumberFormatException nfe)
        {
            throw new IllegalStateException("ungültiges Limit: "
                    + tfLimit.getText());
        }
        finally
        {
            konto.addObserver(this);
        }
        
    }

    /**
     * liefert Referenz auf das Datenmodell (Konto-Instanz)
     * 
     * @return Referenz auf dargestellte Konto-Instanz
     * @uml.property name="konto"
     */
    public Konto getKonto()
    {
        return konto;
    }

    public void update(Observable o, Object arg)
    {
        updateView();

    }

}
