package fahrtenbuch.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;


import fahrtenbuch.fachlogik.Fahrt;
import fahrtenbuch.fachlogik.FahrtenbuchException;

public class FahrtFenster extends JDialog implements ActionListener
{
	private Fahrt fahrt;
    private Hauptfenster hauptFenster;
    private boolean ok;  
	
    private JTextField tfVon;
    private JTextField tfNach;
    private JTextField tfKmAbfahrt;
    private JTextField tfKmAnkunft;
    private SpinnerDateModel spAbfahrtsZeit;
    private SpinnerDateModel spAnkunftsZeit;
    private JTextField tfBemerkung;
    private JComboBox cbFahrer;

	
    
    
	public FahrtFenster(Hauptfenster f, Fahrt fahrt)
	{
        super(f, true);  // modaler Dialog
        ok = false;
        this.hauptFenster = f;
		this.fahrt = fahrt;
		initFenster();
		updateFenster();
        pack();
	}
	
	private void updateFenster()
	{
		tfVon.setText(fahrt.getVon());
		tfNach.setText(fahrt.getNach());
		tfKmAbfahrt.setText(String.valueOf(fahrt.getKmAbfahrt()));
		tfKmAnkunft.setText(String.valueOf(fahrt.getKmAnkunft()));
        spAbfahrtsZeit.setValue(fahrt.getAbfahrt());
        spAnkunftsZeit.setValue(fahrt.getAnkunft());
		tfBemerkung.setText(fahrt.getBemerkung());
		
	}
    
    private void updateDaten() throws FahrtenbuchException
    {
        if (fahrt == null)
            fahrt = new Fahrt();
        fahrt.setVon(tfVon.getText());
        fahrt.setNach(tfNach.getText());
        fahrt.setKmAnkunft(Integer.parseInt(tfKmAnkunft.getText()));
        fahrt.setKmAbfahrt(Integer.parseInt(tfKmAbfahrt.getText()));
        fahrt.setAbfahrt(spAbfahrtsZeit.getDate());
        fahrt.setAnkunft(spAnkunftsZeit.getDate());
        fahrt.setBemerkung(tfBemerkung.getText());
    }
    
	
	private void initFenster()
	{
		tfVon = new JTextField();
		tfNach = new JTextField();
		tfKmAbfahrt = new JTextField();
		tfKmAnkunft = new JTextField();
        spAbfahrtsZeit = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        spAnkunftsZeit = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR);
		tfBemerkung = new JTextField();
		cbFahrer = new JComboBox(hauptFenster.alleFahrer());
		JButton bnSpeichern = new JButton("SPEICHERN");
        
		
		setLayout(new GridLayout(6,3)); // Zeilen Spalten
		add(new JLabel());  // leer
		add(new JLabel("von"));
		add(new JLabel("nach"));
		add(new JLabel("Ort"));
		add(tfVon);
		add(tfNach);
		add(new JLabel("KM-Stand"));
		add(tfKmAbfahrt);
		add(tfKmAnkunft);
        add(new JLabel("Datum/Uhrzeit"));
        add(new JSpinner(spAbfahrtsZeit));
        add(new JSpinner(spAnkunftsZeit));
		add(new JLabel("Bemerkung"));
		add(tfBemerkung);
		add(new JLabel());
		add(new JLabel("Fahrer/in"));
		add(cbFahrer);
		add(bnSpeichern);

		bnSpeichern.addActionListener(this);
	}
	

    
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            updateDaten();
            ok = true;
            dispose();
        } catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(this, "bitte nur Ganzzahlen in Kilometerfeler eingeben", 
                    "Fehler", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                    "Fehler", JOptionPane.ERROR_MESSAGE);            
        }
    }
        

    
    
    
    public boolean isOk()
    {
        return ok;
    }

    /**
     * nur zum Testen
     * @param args
     */
	public static void main(String[] args)
	{
        Hauptfenster hf = new Hauptfenster();
        hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hf.setVisible(true);
		Fahrt f = new Fahrt();
		FahrtFenster fenster = new FahrtFenster(hf, f);
		
		fenster.pack();
		fenster.setVisible(true);
	}



}
