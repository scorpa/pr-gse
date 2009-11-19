package mitarbeiter;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI extends JFrame
{
	private MitarbeiterDAO dao;
	private JList jlMitarbeiter = new JList();
	private DefaultListModel lmMitarbeiter = new DefaultListModel();
	private JLabel lbNr = new JLabel();
	private JTextField tfVorname = new JTextField();
	private JTextField tfNachname = new JTextField();
	private JTextField tfGeburtsdatum = new JTextField();
	private JTextField tfGeschlecht = new JTextField();
	
	private Mitarbeiter current = null;
	
	public GUI(MitarbeiterDAO dao) throws HeadlessException
	{
		this.dao = dao;
		initFrame();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0)
			{
				close();
			}});
	}

	
	private void close()
	{
		try
		{
			if (current != null)
				dao.speichern(current);
			dao.close();
		} catch (PersistenzException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void initFrame()
	{
		JSplitPane split = new JSplitPane();
		add(split);
		split.add(new JScrollPane(jlMitarbeiter), JSplitPane.LEFT);
		jlMitarbeiter.setModel(lmMitarbeiter);
		jlMitarbeiter.setCellRenderer(new Renderer());
		JPanel rechts = new JPanel(new GridLayout(7,2));
		split.add(rechts, JSplitPane.RIGHT);
		rechts.add(new JLabel("Mitarbeiternummer"));
		rechts.add(lbNr);
		rechts.add(new JLabel("Vorname"));
		rechts.add(tfVorname);
		rechts.add(new JLabel("Nachname"));
		rechts.add(tfNachname);
		rechts.add(new JLabel("Geburtsdatum"));
		rechts.add(tfGeburtsdatum);
		rechts.add(new JLabel("Geschlecht"));
		rechts.add(tfGeschlecht);
		JButton neu = new JButton("NEU");
		JButton loeschen = new JButton("LÖSCHEN");
		JButton suchen = new JButton("SUCHEN");
		JButton clear = new JButton("Felder Löschen");
		rechts.add(neu);
		rechts.add(loeschen);
		rechts.add(suchen);
		rechts.add(clear);
		neu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				neu();
			}});
		loeschen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				loeschen();
			}});
		suchen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				suchen();
			}});
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				clearFields();
			}});
		
		jlMitarbeiter.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e)
			{
				select();
			}});
	}


	protected void suchen()
	{
		try
		{
			List<Mitarbeiter> liste = new ArrayList<Mitarbeiter>();
			if (tfNachname.getText().length() > 0)
			{
				liste = dao.finden(tfNachname.getText());
			}
			else
			{
				liste = dao.findeAlle();
			}
			if (liste.size() > 0)
			{
				lmMitarbeiter.clear();
				for (Mitarbeiter m : liste)
					lmMitarbeiter.addElement(m);
			}

		} catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	protected void updateFields()
	{
		if (current != null)
		{
			lbNr.setText(String.valueOf(current.getNr()));
			tfVorname.setText(current.getVorname());
			tfNachname.setText(current.getNachname());
			tfGeburtsdatum.setText(Mitarbeiter.DATE_FORMATTER.format(current.getGeburtsDatum()));
			tfGeschlecht.setText(String.valueOf(current.getGeschlecht()));
		}
	}
	
	protected void clearFields()
	{
		lbNr.setText("");
		tfVorname.setText("");
		tfNachname.setText("");
		tfGeburtsdatum.setText("");
		tfGeschlecht.setText("");
		
	}
	
	protected void updateCurrent()
	{
		if (current != null)
		{
			current.setVorname(tfVorname.getText());
			current.setNachname(tfNachname.getText());
			try
			{
				current.setGeburtsDatum(Mitarbeiter.DATE_FORMATTER.parse(tfGeburtsdatum.getText()));
			} catch (ParseException e)
			{
				throw new IllegalStateException("Format für Geburtsdatum: TT.MM.JJJJ");
			}
			if (tfGeschlecht.getText().length() == 1)
				current.setGeschlecht(tfGeschlecht.getText().charAt(0));
			else
				throw new IllegalStateException("Geschlecht muss m oder w sein");
		}
	}

	protected void select()
	{
		try
		{
			Mitarbeiter selected = (Mitarbeiter) jlMitarbeiter.getSelectedValue();
			if (selected != null)
			{
				if (current != null && current != selected)
				{
					updateCurrent();
					dao.speichern(current);
				}
				current = selected;
				updateFields();
			}
		} catch(Exception e)
		{
			if (current != null)
				jlMitarbeiter.setSelectedValue(current, true);
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}


	protected void loeschen()
	{
		try
		{
			if (current != null)
			{
				lmMitarbeiter.removeElement(current);
				if (current.getNr() != 0)
					dao.loeschen(current);
				current = null;
				clearFields();
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}


	protected void neu()
	{
		Mitarbeiter neu = new Mitarbeiter();
		lmMitarbeiter.addElement(neu);
		jlMitarbeiter.setSelectedValue(neu, true);
		select();
		clearFields();
	}
	
	
	
	private static class Renderer extends JPanel implements ListCellRenderer
	{
		private JLabel lbNr = new JLabel();
		private JLabel lbName = new JLabel();
		
		public Renderer()
		{
			lbName.setOpaque(true);
			lbNr.setOpaque(true);
			setLayout(new GridLayout(1,2));
			add(lbNr);
			add(lbName);
		}
		
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus)
		{
			Mitarbeiter ma = (Mitarbeiter) value;
			lbNr.setText(String.valueOf(ma.getNr()));
			lbName.setText(ma.getNachname() + " " + ma.getVorname());
			if (isSelected)
			{
				lbNr.setForeground(list.getSelectionForeground());
				lbName.setForeground(list.getSelectionForeground());
				lbNr.setBackground(list.getSelectionBackground());
				lbName.setBackground(list.getSelectionBackground());
			}
			else
			{
				lbNr.setForeground(list.getForeground());
				lbName.setForeground(list.getForeground());
				lbNr.setBackground(list.getBackground());
				lbName.setBackground(list.getBackground());				
			}
			return this;
		}
		
	}
	
	
	public static void main(String[] args)
	{
		MitarbeiterDAO dao = null;
		try
		{
			dao = new FileMitarbeiterDao();
			GUI gui = new GUI(dao);
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gui.setSize(800, 300);
			gui.setVisible(true);
		} catch (PersistenzException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(-1);
		}

	}
}
