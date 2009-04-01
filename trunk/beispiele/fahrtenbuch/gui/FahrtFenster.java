package fahrtenbuch.gui;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fahrtenbuch.fachlogik.Fahrt;

public class FahrtFenster extends JFrame
{
	Fahrt fahrt;
	
	JTextField tfVon;
	JTextField tfNach;
	JTextField tfKmAbfahrt;
	JTextField tfKmAnkunft;
	JTextField tfDatumAbfahrt;
	JTextField tfDatumAnkunft;
	JTextField tfUhrzeitAbfahrt;
	JTextField tfUhrzeitAnkunft;
	JTextField tfBemerkung;
	JComboBox cbFahrer;
	JButton bnSpeichern;



	
	public FahrtFenster()
	{
		initFenster();
	}

	public FahrtFenster(Fahrt fahrt)
	{
		this.fahrt = fahrt;
		initFenster();
		updateFenster();
	}
	
	private void updateFenster()
	{
		SimpleDateFormat datumFormat = new SimpleDateFormat("dd.MM");
		SimpleDateFormat zeitFormat = new SimpleDateFormat("hh:mm");
		tfVon.setText(fahrt.getVon());
		tfNach.setText(fahrt.getNach());
		tfKmAbfahrt.setText(String.valueOf(fahrt.getKmAbfahrt()));
		tfKmAnkunft.setText(String.valueOf(fahrt.getKmAnkunft()));
		tfDatumAbfahrt.setText(datumFormat.format(fahrt.getAbfahrt()));
		tfDatumAnkunft.setText(datumFormat.format(fahrt.getAnkunft()));
		tfUhrzeitAbfahrt.setText(zeitFormat.format(fahrt.getAbfahrt()));
		tfUhrzeitAnkunft.setText(zeitFormat.format(fahrt.getAnkunft()));
		tfBemerkung.setText(fahrt.getBemerkung());
		
	}
	
	private void initFenster()
	{
		tfVon = new JTextField();
		tfNach = new JTextField();
		tfKmAbfahrt = new JTextField();
		tfKmAnkunft = new JTextField();
		tfDatumAbfahrt = new JTextField();
		tfDatumAnkunft = new JTextField();
		tfUhrzeitAbfahrt = new JTextField();
		tfUhrzeitAnkunft = new JTextField();
		tfBemerkung = new JTextField();
		cbFahrer = new JComboBox();
		bnSpeichern = new JButton("SPEICHERN");
		
		setLayout(new GridLayout(7,3)); // Zeilen Spalten
		add(new JLabel());  // leer
		add(new JLabel("von"));
		add(new JLabel("nach"));
		add(new JLabel("Ort"));
		add(tfVon);
		add(tfNach);
		add(new JLabel("KM-Stand"));
		add(tfKmAbfahrt);
		add(tfKmAnkunft);
		add(new JLabel("Datum"));
		add(tfDatumAbfahrt);
		add(tfDatumAnkunft);
		add(new JLabel("Uhrzeit"));
		add(tfUhrzeitAbfahrt);
		add(tfUhrzeitAnkunft);
		add(new JLabel("Bemerkung"));
		add(tfBemerkung);
		add(new JLabel());
		add(new JLabel("Fahrer/in"));
		add(cbFahrer);
		add(bnSpeichern);


	}
	
	public static void main(String[] args)
	{
		Fahrt f = new Fahrt();
		FahrtFenster fenster = new FahrtFenster(f);
		
		fenster.pack();
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setVisible(true);
	}

	

}
