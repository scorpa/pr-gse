package fahrtenbuch.gui;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import fahrtenbuch.fachlogik.Abrechnung;
import fahrtenbuch.fachlogik.Fahrtenbuch;

public class AbrechnungsFenster extends JFrame
{
	private final static String ENDL = System.getProperty("line.separator", "\n");
	private final static SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy");
	
	private Fahrtenbuch fahrtenbuch;
	private JTextArea taHeader = new JTextArea();
	private JTable jtFahrer = new JTable();
	
	
	
	public AbrechnungsFenster(Fahrtenbuch fahrtenbuch)
	{
		this.fahrtenbuch = fahrtenbuch;
		ZeitraumDialog intervall = new ZeitraumDialog();
		if (intervall.anzeigen())
		{
			createContent(intervall.getVon(), intervall.getBis());
			initDialog();
			setSize(800, 800);
			setVisible(true);
		}
		else
			dispose();
	}
	
	private void initDialog()
	{
		setLayout(new BorderLayout());
		taHeader.setEditable(false);
		add(taHeader, BorderLayout.NORTH);
		add(new JScrollPane(jtFahrer), BorderLayout.CENTER);
		jtFahrer.setEnabled(false);
	}
	
	private void createContent(Date von, Date bis)
	{
		StringBuilder text = new StringBuilder();
		List<Abrechnung> liste = fahrtenbuch.abrechnen(von, bis);
		text.append("====== Abrechnung für den Zeitraum von ");
		text.append(FORMATTER.format(von));
		text.append(" bis ");
		text.append(FORMATTER.format(bis));
		text.append(" =====").append(ENDL);
		
		text.append("Gesamtkosten: ").append(Abrechnung.getGesamtAusgaben()).append(ENDL);
		text.append("Gesamtkilometer: ").append(Abrechnung.getGesamtKM()).append(ENDL);
		
		taHeader.setText(text.toString());
		
		if (Abrechnung.getGesamtKM() > 0)
		{
			float kmKosten = Abrechnung.getGesamtAusgaben() / Abrechnung.getGesamtKM();
			text.append("Kosten pro KM: ").append(kmKosten).append(ENDL);
		}
		Object[] header = {"Fahrer", "gefahren", "bezahlt", "Guthaben"};
		Object[][] daten = new Object[liste.size()][4];
		for (int i = 0; i < liste.size(); i++)
		{
			Abrechnung a = liste.get(i);
			daten[i][0] = a.getFahrer().getName();
			daten[i][1] = a.getKm();
			daten[i][2] = a.getBezahlt();
			daten[i][3] = a.berechneGuthaben();
		}
		jtFahrer = new JTable(daten, header);
			
			
			
	}

}
