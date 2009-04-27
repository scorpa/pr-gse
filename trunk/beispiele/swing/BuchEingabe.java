package swing;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Eingabedialog f�r ein Buch.
 * Der Dialog fungiert selbst als ActionListener 
 * und als WindowListener
 * 
 * @author Rudolf Radlbauer
 *
 */
public class BuchEingabe extends JDialog implements ActionListener, WindowListener
{
	// Referenz auf das bearbeitete Buch
	private Buch buch;
	
	private boolean ok = false;
	
	// Die Eingabe-Elemente, auf die man aus mehreren Methoden
	// Zugriff ben�tigt, m�ssen als Attribute gehalten werden.
	private JTextField tfTitel;
	private JTextField tfAutor;
	private JTextField tfSeiten;
	private JTextField tfErscheinungsJahr;
	private JButton bnOK;
	private JButton bnCancel;
	
	
	public BuchEingabe(Buch buch)
	{
		this.buch = buch;
		initDialog(); // Dialog aufbauen
		updateDialog(); // Textfelder bef�llen
		setModal(true);  // blockiert, solange Dialog angezeigt wird
		pack(); // vern�nftige Gr��e einstellen
	}
	
	/**
	 * zeigt den Dialog an.
	 * @return true - falls der Benutzer ok geklickt hat und alles richtig 
	 *                eingegeben wurde.
	 *         false - sonst
	 */
	public boolean anzeigen()
	{
		setVisible(true);
		return ok;
	}
	

	
	/**
	 * Aufbau des Dialogs
	 */
	private void initDialog()
	{
		// �berschrift des Dialogs
		setTitle("Bucheingabe");
		
		// die Felder m�ssen nat�rlich auch instanziiert werden.
		tfTitel = new JTextField();
		tfAutor = new JTextField();
		tfSeiten = new JTextField();
		tfErscheinungsJahr = new JTextField();
		bnOK = new JButton("OK");
		bnCancel = new JButton("ABBRECHEN");
		
		setLayout(new GridLayout(5,2));   // 5 Zeilen, 2 Spalten
		
		// Einf�gen der Elemente
		// auf die Label ben�tigen wir sp�ter keinen Zugriff mehr ==> keine Attribute
		add(new JLabel("Titel"));
		add(tfTitel);
		add(new JLabel("Autor"));
		add(tfAutor);
		add(new JLabel("Erscheinungsjahr"));
		add(tfErscheinungsJahr);
		add(new JLabel("Seiten"));
		add(tfSeiten);
		add(bnOK);
		bnOK.addActionListener(this);  // Dialog ist selbst ein Actionlistener
		add(bnCancel);
		bnCancel.addActionListener(this);  
		
	}
	
	/**
	 * bef�llt die Dialogelemente mit den Daten aus der Instanz buch
	 */
	private void updateDialog()
	{
		if (buch != null)
		{
			tfTitel.setText(buch.getTitel());
			tfAutor.setText(buch.getAutor());
			tfSeiten.setText(String.valueOf(buch.getSeiten()));
			tfErscheinungsJahr.setText(String.valueOf(buch.getErscheinungsJahr()));
		}
	}
	
	/**
	 * holt die Daten aus den Eingabefeldern und schreibt sie in die
	 * Buch-Instanz
	 */
	private void updateDaten() throws IllegalArgumentException, NumberFormatException
	{
		if (buch == null)
			buch = new Buch();  // Instanz anlegen falls n�tig
		buch.setTitel(tfTitel.getText());
		buch.setAutor(tfAutor.getText());
		// falls keine Zahl eingegeben wurde, tritt hier eine NumberFormatException auf
		buch.setSeiten(Integer.parseInt(tfSeiten.getText())); 
		buch.setErscheinungsJahr(Integer.parseInt(tfErscheinungsJahr.getText()));
	}
	


	/**
	 * Event-Handler-Methode vom Interface ActionListener
	 * wird aufgerufen, wenn Button geklickt wird
	 */
	public void actionPerformed(ActionEvent event)
	{
		ok = false;
		Object source = event.getSource();   // von diesem Objekt (Button) kam der Event
		if (source == bnOK)
		{
			try
			{
				updateDaten();
				ok = true;
				dispose(); // schlie�en und Resourcen freigeben
			} catch(NumberFormatException nfe)
			{
				JOptionPane.showMessageDialog(this, 
						"Bitte bei Seiten und Erscheinungsjahr eine Zahl eingeben",
						"Bucheingabe", JOptionPane.ERROR_MESSAGE);
			} catch(Exception e)  // andere Ausnahmen
			{
				JOptionPane.showMessageDialog(this, 
						e.getMessage(), "Bucheingabe", JOptionPane.ERROR_MESSAGE);				
			}
		}
		else if (source == bnCancel)
		{
			dispose(); // schlie�en und Resourcen freigeben			
		}
		
	}
	

	// hier kommen die Event-Handler-Methoden vom Interface WindowListener
	// wir ben�tigen nur die Methode windowClosing()
	
	public void windowActivated(WindowEvent event)
	{
		// nichts zu tun
	}

	public void windowClosed(WindowEvent event)
	{
		// nichts zu tun		
	}

	public void windowClosing(WindowEvent event)
	{
		dispose(); // schlie�en und Resourcen freigeben
	}

	public void windowDeactivated(WindowEvent event)
	{
		// nichts zu tun
	}

	public void windowDeiconified(WindowEvent event)
	{
		// nichts zu tun
	}

	public void windowIconified(WindowEvent event)
	{
		// nichts zu tun
	}

	public void windowOpened(WindowEvent event)
	{
		// nichts zu tun
	}
	
	/**
	 * nur zum Testen
	 * @param args
	 */
	public static void main(String[] args)
	{
		Buch buch = new Buch();
		BuchEingabe eingabe = new BuchEingabe(buch);
		if (eingabe.anzeigen())
			System.out.println(buch);
		else
			System.out.println("Abbruch durch Benutzer");
		System.exit(0);  // Programm beenden
	}
}
