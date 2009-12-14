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
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	private JDesktopPane desktop = new JDesktopPane();
	
	public GUI(MitarbeiterDAO dao) throws HeadlessException
	{
		this.dao = dao;
		initFrame();
		initMenu();
		load();
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
			dao.close();
		} catch (PersistenzException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void initMenu()
	{
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		JMenu file = new JMenu("Mitarbeiter");
		mbar.add(file);
		JMenuItem neu = new JMenuItem("neu");
		file.add(neu);
		neu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				neu();
			}});
		JMenuItem speichern = new JMenuItem("speichern");
		file.add(speichern);
		speichern.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				speichern();
			}});
		JMenuItem anzeigen = new JMenuItem("anzeigen");
		file.add(anzeigen);
		anzeigen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				anzeigen();
			}});
	}
	
	private void anzeigen()
	{
		Mitarbeiter m = (Mitarbeiter) jlMitarbeiter.getSelectedValue();
		if (m != null)
		{
			MitarbeiterFenster fenster = new MitarbeiterFenster(m);
			desktop.add(fenster);
			fenster.setVisible(true);
		}
	}
	
	private void load()
	{
		lmMitarbeiter.clear();
		try
		{
			for (Mitarbeiter m : dao.findeAlle())
				lmMitarbeiter.addElement(m);
		} catch (PersistenzException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void speichern()
	{
		try
		{
			MitarbeiterFenster fenster = (MitarbeiterFenster) desktop.getSelectedFrame();
			if (fenster != null)
			{
				Mitarbeiter m = fenster.getMitarbeiter();
				dao.speichern(m);
				fenster.updateFenster();
				if (!lmMitarbeiter.contains(m))
					lmMitarbeiter.addElement(m);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void neu()
	{
		try
		{
			MitarbeiterFenster fenster = new MitarbeiterFenster();
			desktop.add(fenster);
			fenster.setVisible(true);
		} catch(Exception e)
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
		split.add(desktop, JSplitPane.RIGHT);
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
