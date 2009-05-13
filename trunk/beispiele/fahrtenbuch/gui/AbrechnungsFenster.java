package fahrtenbuch.gui;

import java.awt.TextArea;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import fahrtenbuch.fachlogik.Abrechnung;
import fahrtenbuch.fachlogik.Fahrtenbuch;

public class AbrechnungsFenster extends JFrame
{
	public AbrechnungsFenster(Fahrtenbuch fahrtenbuch)
	{
    	String endl = System.getProperty("line.separator");
    	SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		ZeitraumDialog intervall = new ZeitraumDialog();
		if (intervall.anzeigen())
		{
			List<Abrechnung> liste = fahrtenbuch.abrechnen(intervall.getVon(), intervall.getBis());
			StringBuilder text = new StringBuilder();
			text.append("====== Abrechnung für den Zeitraum von ");
			text.append(formatter.format(intervall.getVon()));
			text.append(" bis ");
			text.append(formatter.format(intervall.getBis()));
			text.append(" =====").append(endl);
			
			text.append("Gesamtkosten: ").append(Abrechnung.getGesamtAusgaben()).append(endl);
			text.append("Gesamtkilometer: ").append(Abrechnung.getGesamtKM()).append(endl);
			
			add(new JScrollPane(new TextArea(text.toString())));
			setSize(800, 800);
		}
		else
			dispose();
		
		
		
	}

}
