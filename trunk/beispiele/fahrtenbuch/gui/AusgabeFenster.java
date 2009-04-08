/*
 * Created on 08.04.2009
 *
 */
package fahrtenbuch.gui;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import fahrtenbuch.fachlogik.Ausgabe;
import fahrtenbuch.fachlogik.FahrtenbuchException;

public class AusgabeFenster extends KostenpunktFenster
{
   
    private JTextField tfBezeichnung;
    private JRadioButton rbFix;
    private JRadioButton rbVariabel;

    public AusgabeFenster(Hauptfenster f, Ausgabe ausgabe)
    {
        super(f, ausgabe);
    }

    @Override
    protected void initFenster()
    {
        super.initFenster();
        tfBezeichnung = new JTextField();
        rbFix = new JRadioButton();
        rbFix.setText("Fixkosten");
        rbVariabel = new JRadioButton();
        rbVariabel.setText("Variable Kosten");
        
        setLayout(new GridLayout(7,2));
        add(new JLabel("Datum"));
        add(new JSpinner(spDatum));
        add(new JLabel("KM-Stand"));
        add(tfKM);
        add(new JLabel("Bezeichnung"));
        add(tfBezeichnung);
        add(new JLabel("Betrag (€)"));
        add(tfEuro);
        add(new JLabel("Bemerkung"));
        add(tfBemerkung);
        add(new JLabel("Fahrer/in"));
        add(cbFahrer);
        JPanel radio = new JPanel();
        add(radio);
        radio.add(rbFix);
        radio.add(rbVariabel);
        ButtonGroup group = new ButtonGroup();
        group.add(rbFix);
        group.add(rbVariabel);
        add(bnSpeichern);
        
    }

    @Override
    protected void updateDaten() throws FahrtenbuchException
    {
        super.updateDaten();
        Ausgabe ausgabe = (Ausgabe)kostenPunkt;
        ausgabe.setBezeichnung(tfBezeichnung.getText());
        ausgabe.setFixkosten(rbFix.isSelected());
    }

    @Override
    protected void updateFenster()
    {
        super.updateFenster();
        Ausgabe ausgabe = (Ausgabe)kostenPunkt;
        tfBezeichnung.setText(ausgabe.getBezeichnung());
        rbFix.setSelected(ausgabe.isFixkosten());
        rbVariabel.setSelected(!ausgabe.isFixkosten());
    }

    
}
