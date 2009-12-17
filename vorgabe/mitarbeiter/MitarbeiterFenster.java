package mitarbeiter;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class MitarbeiterFenster extends JInternalFrame implements Observer
{
	private JTextField tfNr = new JTextField();
	private JTextField tfVorname = new JTextField();
	private JTextField tfNachname = new JTextField();
	private SpinnerDateModel smGeburtsdatum = new SpinnerDateModel();
	private JRadioButton rbWeiblich = new JRadioButton("w");
	private JRadioButton rbMaennlich = new JRadioButton("m");

	private Mitarbeiter mitarbeiter;
	
	public MitarbeiterFenster()
	{
		this.mitarbeiter = new Mitarbeiter();
		this.mitarbeiter.addObserver(this);
		initFrame();
		pack();
	}
	
	public MitarbeiterFenster(Mitarbeiter mitarbeiter)
	{
		this.mitarbeiter = mitarbeiter;
		this.mitarbeiter.addObserver(this);
		initFrame();
		updateFenster();
		pack();
	}
	
	private void initFrame()
	{
		setLayout(new GridLayout(5,2));
		add(new JLabel("Mitarbeiternummer"));
		add(tfNr);
		tfNr.setEditable(false);
		add(new JLabel("Vorname"));
		add(tfVorname);
		add(new JLabel("Nachname"));
		add(tfNachname);
		add(new JLabel("Geburtsdatum"));
		add(new JSpinner(smGeburtsdatum));
		add(new JLabel("Geschlecht"));
		JPanel jp = new JPanel(new FlowLayout());
		add(jp);
		jp.add(rbWeiblich);
		jp.add(rbMaennlich);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbWeiblich);
		bg.add(rbMaennlich);
		rbWeiblich.setSelected(true);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
	}
	
	private void updateDaten()
	{
		mitarbeiter.deleteObserver(this);
		mitarbeiter.setGeburtsDatum(smGeburtsdatum.getDate());
		mitarbeiter.setVorname(tfVorname.getText());
		mitarbeiter.setNachname(tfNachname.getText());
		if (rbWeiblich.isSelected()) mitarbeiter.setGeschlecht('w');
		if (rbMaennlich.isSelected()) mitarbeiter.setGeschlecht('m');
		mitarbeiter.addObserver(this);
	}
	
	public void updateFenster()
	{
		tfNr.setText(String.valueOf(mitarbeiter.getNr()));
		tfVorname.setText(mitarbeiter.getVorname());
		tfNachname.setText(mitarbeiter.getNachname());
		smGeburtsdatum.setValue(mitarbeiter.getGeburtsDatum());
		switch (mitarbeiter.getGeschlecht())
		{
		case 'w': rbWeiblich.setSelected(true); break;
		case 'm': rbMaennlich.setSelected(true); break;
		}
	}

	public Mitarbeiter getMitarbeiter()
	{
		updateDaten();
		return mitarbeiter;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateFenster();
		
	}

	
	
}
