package anrufe;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Oberfläche wie in Aufgabenstellung beschrieben
 * 
 * @author Rudolf Radlbauer
 *
 */
public class AnrufAnzeige extends JFrame
{
	// Referenz auf die Anrufliste
	private List<Anruf> anrufe;
	
	// Index des aktuell angezeigten Anrufes
	private int index = 0;
	
	// Ein-/Ausgabe-Felder
	private JTextField tfNummer = new JTextField();
	private JTextField tfZeit = new JTextField();
	private JTextField tfDauer = new JTextField();

	/**
	 * Konstruktor übernimmt die Liste der Anrufe
	 * @param anrufe Anrufliste
	 */
	public AnrufAnzeige(List<Anruf> anrufe)
	{
		this.anrufe = anrufe;  // Referenz merken
		initFrame();  // Aufbau der GUI
		updateFelder();  // aktuellen Anruf anzeigen
	}

	/**
	 * Aufbau der Oberfläche
	 */
	private void initFrame()
	{
		setLayout(new GridLayout(0, 2));
		add(new JLabel("Nummer"));
		add(tfNummer);
		add(new JLabel("Zeit"));
		add(tfZeit);
		add(new JLabel("Dauer"));
		add(tfDauer);
		JButton zurueck = new JButton("<--");
		JButton vorwaerts = new JButton("-->");
		add(zurueck);
		add(vorwaerts);
		zurueck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				zurueck();
			}});
		vorwaerts.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				vorwaerts();
			}});
		
	}

	/**
	 * nächsten Anruf anzeigen
	 */
	protected void vorwaerts()
	{
		// geht natürlich nur, wenn nicht bereits der letzte angezeigt wird
		if (index < anrufe.size()-1)
		{
			index++;  // weiterschalten
			updateFelder();  // aktuellen Anruf anzeigen
		}
	}

	/**
	 * zeigt den aktuellen Anruf (durch index definiert) an
	 */
	private void updateFelder()
	{
		if (anrufe.size() > 0)
		{
			Anruf anruf = anrufe.get(index);
			tfNummer.setText(anruf.getNr());
			tfZeit.setText(DateiAnbindung.DATUMSFORMAT.format(anruf.getZeit()));
			tfDauer.setText(String.valueOf(anruf.getDauer()));
		}
		
	}

	/**
	 * voherhigen Anruf anzeigen
	 */
	protected void zurueck()
	{  // siehe vorwaerts()
		if (index > 0)
		{
			index--;
			updateFelder();
		}
	}
	
	
	public static void main(String[] args)
	{
		try
		{
			DateiAnbindung io = new DateiImplementierung();
			AnrufAnzeige anzeige = new AnrufAnzeige(io.lesen("anrufe/anrufe.csv"));
			anzeige.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			anzeige.pack();
			anzeige.setVisible(true);
		} catch (HeadlessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
