package fahrtenbuch.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class ZeitraumDialog extends JDialog
{
	private SpinnerDateModel von;
	private SpinnerDateModel bis;
	private boolean ok;
	
	public ZeitraumDialog()
	{
		setTitle("Bitte Zeitraum auswählen!");
		ok = false;
        von = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        bis = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
		initDialog();
	}
	
	public boolean anzeigen()
	{
		setModal(true);
		setVisible(true);
		return ok;
	}
	
	public Date getVon()
	{
		return von.getDate();
	}
	
	public Date getBis()
	{
		return bis.getDate();
	}
	
	private void initDialog()
	{
		setLayout(new GridLayout(3,2));
		add(new JLabel("von"));
		add(new JSpinner(von));
		add(new JLabel("bis"));
		add(new JSpinner(bis));
		JButton abbrechen = new JButton("Abbrechen");
		add(abbrechen);
		JButton weiter = new JButton("OK");
		add(weiter);
		
		
		weiter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ok = true;
				dispose();
			}});
		
		abbrechen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ok = false;
				dispose();
			}});
	}

}
