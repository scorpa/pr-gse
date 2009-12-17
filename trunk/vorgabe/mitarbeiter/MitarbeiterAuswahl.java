package mitarbeiter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class MitarbeiterAuswahl extends JDialog
{
	private MitarbeiterDAO dao;
	private List<Mitarbeiter> liste;
	
	private JRadioButton rbAlle = new JRadioButton("alle Mitarbeiter");
	private JRadioButton rbNr = new JRadioButton("Mitarbeiternummer");
	private JRadioButton rbName = new JRadioButton("Nachname beginnend mit");
	private JRadioButton rbDatum = new JRadioButton("Geburtsdatum von - bis");
	private JTextField tfNr = new JTextField();
	private JTextField tfName = new JTextField();
	private SpinnerDateModel sdmVon = new SpinnerDateModel();
	private SpinnerDateModel sdmBis = new SpinnerDateModel();
	
	public MitarbeiterAuswahl(MitarbeiterDAO dao)
	{
		this.dao = dao;
		initDialog();
		setTitle("Mitarbeiter auswählen");
		pack();
	}
	
	private void initDialog()
	{
		setLayout(new GridLayout(5, 3));
		add(rbAlle);
		add(new JLabel());
		add(rbNr);
		add(tfNr);
		add(rbName);
		add(tfName);
		add(rbDatum);
		JPanel datePanel = new JPanel(new GridLayout(1,2));
		add(datePanel);
		datePanel.add(new JSpinner(sdmVon));
		datePanel.add(new JSpinner(sdmBis));
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbAlle);
		bg.add(rbNr);
		bg.add(rbName);
		bg.add(rbDatum);
		rbAlle.setSelected(true);
		JButton ok = new JButton("OK");
		add(ok);
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				auswahl();
			}});
		JButton cancel = new JButton("Abbrechen");
		add(cancel);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				liste = null;
				dispose();
			}});
		
	}
	
	private void auswahl()
	{
		try
		{
			if (rbAlle.isSelected())
			{
				liste = dao.findeAlle();
			}
			else if (rbNr.isSelected())
			{
				try
				{
					int nr = Integer.parseInt(tfNr.getText());
					Mitarbeiter m = dao.finden(nr);
					if (m != null)
					{
						liste = new ArrayList<Mitarbeiter>();
						liste.add(m);
					}
					else
						throw new Exception("kein Mitarbeiter mit dieser Nummer");
				} catch(NumberFormatException nfe)
				{
					throw new Exception("Bitte eine Zahl eingeben");
				}
			}
			else if (rbName.isSelected())
			{
				String name = tfName.getText().trim();
				if (name != null)
					liste = dao.finden(name);
				else
					throw new Exception("bitte Name eingeben");
			}
			else if (rbDatum.isSelected())
			{
				liste = dao.finden(sdmVon.getDate(), sdmBis.getDate());
			}
			else
				throw new Exception("noch nicht implementiert");
			dispose();
		} catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	public List<Mitarbeiter> anzeigen()
	{
		setModal(true);
		setVisible(true);
		return liste;
	}
	

}
