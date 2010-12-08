package warenkorb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main
{

	/**
	 * zum Testen
	 * @param args
	 */
	public static void main(String[] args)
	{
		Connection con = null;
		try
		{
			// DB-Verbindung oeffnen
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/warenkorb", "pr", "pr");
			
			// Warenkorb-Instanz; bekommt im Konstruktor eine Referenz auf DB-Verbindung
			Warenkorb wk = new Warenkorb(con, 1);
			wk.laden();
			
			// eine Artikel-Instanz (ID nicht verändern)
			Artikel a = new Artikel();
			a.setBezeichnung("Semmel");
			a.setPreis(0.50f);
			a.setAnzahl(20);
			// Artikel in Warenkorb einfügen
			wk.einfuegen(a);
			// Warenkorb abspeichern --> Datenbank
			wk.speichern();
			
			// zeige Alle Artikel aus dem Warenkorb an
			for (Artikel a1 : wk.getListe())
				System.out.println(a1);
			System.out.println("Gesamtpreis: " + wk.gesamtPreis());
			
			// Zweite Warenkorb-Instanz mit gleicher ID ==> sollte die gleichen Artikel enthalten.
			Warenkorb wk2 = new Warenkorb(con, 1);
			// Artikel aus der Datenbank laden
			wk2.laden();
			// lösche den ersten Artikel aus der Liste
			List<Artikel> liste = wk2.getListe();
			if (liste.size() > 0)
			{
				Artikel a2 = liste.get(0);
				System.out.println("loesche Artikel: " + a2);
				wk2.loeschen(a2);
			}
			
			// Alle verbliebenen Artikel anzeigen
			for (Artikel a1 : wk2.getListe())
				System.out.println(a1);
			System.out.println("Gesamtpreis: " + wk2.gesamtPreis());
			
			
			
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			// zum Schluss schliessen wir die Datenbankverbindung
			if (con != null)
				try
				{
					con.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
