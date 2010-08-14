package bank.gui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class KontoAuswahlFenster extends JDialog
{
	private JTextField filter = new JTextField();
	private JRadioButton alle = new JRadioButton();
	private JRadioButton selektiert = new JRadioButton();


	
	public KontoAuswahlFenster(Frame parent) throws HeadlessException
	{
		super(parent, true);
		setTitle("Bitte Konten auswählen");
		initDialog();
		pack();
	}

	public String getFilter()
	{
		if (alle.isSelected()) return "";
		return filter.getText();
	}
	
	private void initDialog()
	{
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		ButtonGroup group = new ButtonGroup();
		group.add(alle);
		group.add(selektiert);
		setLayout(new GridLayout(4,2));
		add(new JLabel("alle Konten"));
		add(alle);
		add(new JLabel("ausgewähhlte Konten"));
		add(selektiert);
		add(new JLabel("Anfang des Namens"));
		add(filter);
		JButton ok = new JButton("OK");
		add(ok);
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				ok();
			}});
		
		selektiert.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent arg0)
			{
				if (selektiert.isSelected())
					filter.setEnabled(true);
				else
					filter.setEnabled(false);
			}});
		alle.setSelected(true);
		filter.setEnabled(false);
	}
	
	
	private void ok()
	{
		if (selektiert.isSelected() && filter.getText().trim().length() == 0)
			JOptionPane.showMessageDialog(this, "Bitte Beginn des Namens eingeben!");
		else
			dispose();
	}
	
	

}
