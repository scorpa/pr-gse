package warenkorb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

/**
 * Warenkorb-Klasse wie in Aufgabenstellung spezifiziert
 * @author Rudolf Radlbauer
 *
 */
public class Warenkorb
{
	// Attribute wie in Aufgabenstellung spezifiziert
	private Connection con;
	private int id;
	private List<Artikel> liste;
	
	// Konstruktor bekommt eine Referenz auf die Datenbankverbindung und die Warenkorb-ID
	public Warenkorb(Connection con, int id)
	{
		this.con = con;
		this.id = id;
		// Liste instanziieren
		liste = new ArrayList<Artikel>();
	}
	
	// alle Artikel mit gegebener Warenkorb-ID laden
	public void laden() throws WarenkorbException
	{
		// leere die Liste zuerst
		liste.clear();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			String sql = "SELECT a_id, a_bezeichnung, a_preis, a_anzahl " +
				"FROM artikel " +
				"WHERE a_warenkorb_id = ?";  // Parametriertes Statement
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);	// setze Wert für den Parameter (?)
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				Artikel a = new Artikel();
				a.setId(rs.getInt("a_id"));
				a.setBezeichnung(rs.getString("a_bezeichnung"));
				a.setPreis(rs.getFloat("a_preis"));
				a.setAnzahl(rs.getInt("a_anzahl"));
				liste.add(a);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new WarenkorbException("Fehler bei laden der Artikel");		
		}
		finally
		{
			try
			{
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e)
			{
				// nicht wichtig
				e.printStackTrace();
			}
		}
	}
	
	public void einfuegen(Artikel a) throws WarenkorbException
	{
		// lasse nur Artikel mit id=0 einfuegen, da die ID erst bei INSERT vergeben wird
		// (auto-increment)
		if (a.getId() != 0)
			throw new WarenkorbException("ID von neuem Artikel muss 0 sein");
		liste.add(a);
	}
	
	public void speichern() throws WarenkorbException
	{
		for (Artikel a : liste)
		{
			if (a.getId() == 0)  // wenn id=0, handelt es sich um einen neuen Artikel
				insert(a);
			else
				update(a);  // andernfalls muss ich eventuelle Änderungen in die DB schreiben
		}
	}

	// Hilfsmethode fuer das DB-Update
	private void insert(Artikel a) throws WarenkorbException
	{
		String sql = "INSERT INTO artikel (a_warenkorb_id, a_bezeichnung, a_preis, a_anzahl) " +
				"VALUES(?, ?, ?, ?)";  // Parametriertes Statement
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps = con.prepareStatement(sql);
			// Parameter (?) mit Werten aus der Artikel-Instanz setzen
			ps.setInt(1, id);
			ps.setString(2, a.getBezeichnung());
			ps.setFloat(3, a.getPreis());
			ps.setInt(4, a.getAnzahl());
			if (ps.executeUpdate() != 1)
				throw new WarenkorbException("Fehler bei Anlegen eines Datensatzes");
			rs = ps.getGeneratedKeys();  // hole mir den neu generierten Primaerschluessel
			if (rs.next())
				a.setId(rs.getInt(1));  // es gibt nur 1 Wert (index=1)
			else
				throw new WarenkorbException("Datenbankfehler bei Auslesen des Primaerschluessels");
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new WarenkorbException("Fehler bei Anlegen eines Datensatzes");
		}
		finally
		{
			try
			{
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e)
			{
				// nicht wichtig
				e.printStackTrace();
			}
		}
	}
	
	// Hilfsmethode fuer das DB-Insert
	private void update(Artikel a) throws WarenkorbException
	{
		String sql = "UPDATE artikel SET a_warenkorb_id = ?, a_bezeichnung = ?, a_preis = ?, a_anzahl = ? " +
		"WHERE a_id = ?";  // Parametriertes Statement
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(sql);
			// Parameter (?) mit Werten aus der Artikel-Instanz setzen
			ps.setInt(1, id);
			ps.setString(2, a.getBezeichnung());
			ps.setFloat(3, a.getPreis());
			ps.setInt(4, a.getAnzahl());
			ps.setInt(5, a.getId());
			if (ps.executeUpdate() != 1)  // Update-Count muss 1 sein, wenn der Datensatz vorhanden ist
				throw new WarenkorbException("Aktualisieren eines nicht vorhandenen Datensatzes nicht moeglich");
//			System.out.println("Aenderungen gespeichert: " + a);
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new WarenkorbException("Datenbankfehler beim Aktualisieren eines Datensatzes");
		}
		finally
		{
			if (ps != null)
				try
				{
					ps.close();
				} catch (SQLException e)
				{
					// nicht wichtig
					e.printStackTrace();
				}
		}
		
	}
	
	
	public void loeschen(Artikel a) throws WarenkorbException
	{
		if (liste.remove(a))
		{
			PreparedStatement ps = null;
			try
			{
				ps = con.prepareStatement("DELETE FROM artikel WHERE a_id = ?");
				ps.setInt(1, a.getId());
				if (ps.executeUpdate() != 1)  // Update-Count muss 1 sein, wenn der Datensatz vorhanden war
					throw new WarenkorbException("Artikel war nicht in Datenbank vorhanden");
//				System.out.println("Artikel geloescht: " + a);
			} catch (SQLException e)
			{
				e.printStackTrace();
				throw new WarenkorbException("Fehler beim Loeschen eines Artikels");
			}
			finally
			{
				if (ps != null)
					try
					{
						ps.close();
					} catch (SQLException e)
					{
						// nicht wichtig
						e.printStackTrace();
					}
			}
		}
		else
			throw new WarenkorbException("Artikel ist nicht in Liste vorhanden");
	}
	
	public float gesamtPreis()
	{
		float preis = 0;
		for (Artikel a : liste)
			preis += a.getPreis()*a.getAnzahl();
		return preis;
	}

	public List<Artikel> getListe()
	{
		return liste;
	}
	
	
}
