/*
 * Created on 08.04.2009
 *
 */
package fahrtenbuch.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import fahrtenbuch.fachlogik.FahrtenbuchException;
import fahrtenbuch.fachlogik.Tankstop;

public class TankstopFenster extends KostenpunktFenster
{
    private JTextField tfLiter;
    
    
    public TankstopFenster(Hauptfenster f, Tankstop t)
    {
        super(f, t);  
    }

    @Override
    protected void initFenster()
    {
        super.initFenster();
        
        tfLiter = new JTextField();
        
        setLayout(new GridLayout(7,2));
        add(new JLabel("Datum"));
        add(new JSpinner(spDatum));
        add(new JLabel("KM-Stand"));
        add(tfKM);
        add(new JLabel("Liter"));
        add(tfLiter);
        add(new JLabel("Betrag (€)"));
        add(tfEuro);
        add(new JLabel("Bemerkung"));
        add(tfBemerkung);
        add(new JLabel("Fahrer/in"));
        add(cbFahrer);
        add(new JLabel());
        
        add(bnSpeichern);
    }


    @Override
    protected void updateFenster()
    {
        super.updateFenster();
        Tankstop tankStop = (Tankstop)kostenPunkt;
        tfLiter.setText(String.valueOf(tankStop.getLiter()));
    }
    
    @Override
    protected void updateDaten() throws FahrtenbuchException
    {
        super.updateDaten();
        Tankstop tankStop = (Tankstop)kostenPunkt;
        try
        {
            tankStop.setLiter(Float.parseFloat(tfLiter.getText()));
        } catch(NumberFormatException e)
        {
            throw new FahrtenbuchException("bitte bei Liter eine Zahl eingeben");
        }
    }
    
    


}
