/*
 * Created on 08.04.2009
 *
 */
package fahrtenbuch.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import fahrtenbuch.fachlogik.Fahrer;
import fahrtenbuch.fachlogik.FahrtenbuchException;
import fahrtenbuch.fachlogik.Kostenpunkt;
import fahrtenbuch.fachlogik.Tankstop;

/**
 * Projekt Fahrtenbuch
 * 
 * 
 * @author Rudolf Radlbauer
 *
 */
public class KostenpunktFenster extends JDialog implements ActionListener
{
    protected Kostenpunkt kostenPunkt;
    protected Hauptfenster hauptFenster;
    private boolean ok;   
    
    protected SpinnerDateModel spDatum;
    protected JTextField tfKM;
    protected JTextField tfEuro;
    protected JTextField tfBemerkung;
    protected JComboBox cbFahrer;
    protected JButton bnSpeichern;
    
    
    public KostenpunktFenster(Hauptfenster f, Kostenpunkt kp)
    {
        super(f, true);  // modaler Dialog
        ok = false;
        this.hauptFenster = f;
        this.kostenPunkt  = kp;
        initFenster();
        updateFenster();
        pack();
    }

    protected void initFenster()
    {
        spDatum = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        tfKM = new JTextField();
        tfEuro = new JTextField();
        tfBemerkung = new JTextField();
        cbFahrer = new JComboBox(hauptFenster.alleFahrer());

        bnSpeichern = new JButton("SPEICHERN");
        bnSpeichern.addActionListener(this);
        
    }



    protected void updateFenster()
    {
        spDatum.setValue(kostenPunkt.getDatum());
        tfKM.setText(String.valueOf(kostenPunkt.getKm()));
        tfEuro.setText(String.valueOf(kostenPunkt.getBetrag()));
        tfBemerkung.setText(kostenPunkt.getBemerkung());
        cbFahrer.setSelectedItem(kostenPunkt.getFahrer());
    }
    
    protected void updateDaten() throws FahrtenbuchException
    {
        kostenPunkt.setDatum(spDatum.getDate());
        try
        {
            kostenPunkt.setKm(Integer.parseInt(tfKM.getText()));
        } catch(NumberFormatException e)
        {
            throw new FahrtenbuchException("bitte bei KM eine Ganzzahl eingeben");
        }
        try
        {
            kostenPunkt.setBetrag(Float.parseFloat(tfEuro.getText()));
        } catch(NumberFormatException e)
        {
            throw new FahrtenbuchException("bitte bei Betrag eine Zahl eingeben");
        }
        kostenPunkt.setBemerkung(tfBemerkung.getText());
        kostenPunkt.setFahrer((Fahrer) cbFahrer.getSelectedItem());

    }
    
    

    public boolean isOk()
    {
        return ok;
    }

    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            updateDaten();
            ok = true;
            dispose();
        } catch (FahrtenbuchException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Eingabe überprüfen", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }



}
