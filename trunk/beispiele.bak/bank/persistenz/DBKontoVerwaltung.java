package bank.persistenz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bank.fachlogik.Konto;
import bank.fachlogik.KontoVerwaltung;
import bank.fachlogik.KontoVerwaltungException;

public class DBKontoVerwaltung implements KontoVerwaltung
{
    private Map<Integer, Konto> cache = new HashMap<Integer, Konto>();
	

	public void speichern(Konto k) throws KontoVerwaltungException, IllegalStateException, IllegalArgumentException
	{
        if (cache.containsValue(k))
        {
            try
            {
                PreparedStatement pstmt = ConnectionController.getInstance().getConnection().prepareStatement(
                        "UPDATE konten SET k_besitzer = ?, k_saldo = ?, k_limit = ? WHERE k_nummer = ?");
                pstmt.setString(1, k.getBesitzer());
                pstmt.setDouble(2, k.getSaldo());
                pstmt.setDouble(3, k.getLimit());
                pstmt.setInt(4, k.getNummer());
                if (pstmt.executeUpdate() != 1)
                    throw new IllegalArgumentException("Konto mit der Nummer " + k.getNummer() + " ist nicht vorhanden");
                pstmt.close();
            } catch (SQLException e)
            {
                throw new KontoVerwaltungException("Datenbankfehler beim Aktualisieren eines Kontos: " + e.getMessage());
            } catch (PersistenzException e)
            {
                throw new KontoVerwaltungException("Fehler beim Öffnen der Datenbankverbindung: " + e.getMessage());
            }
        }
        else
        {
            cache.put(k.getNummer(), k);
    		try
    		{
    			PreparedStatement pstmt = ConnectionController.getInstance().getConnection().prepareStatement(
    					"INSERT INTO konten " +
    					"(k_nummer, k_besitzer, k_saldo, k_limit) " +
    					"VALUES (?, ?, ?, ?)");
    			pstmt.setInt(1, k.getNummer());
    			pstmt.setString(2, k.getBesitzer());
    			pstmt.setDouble(3, k.getSaldo());
    			pstmt.setDouble(4, k.getLimit());
    			pstmt.executeUpdate();
    			pstmt.close();
    			
    			
    		} catch (SQLException e)
    		{
    			throw new KontoVerwaltungException("Datenbankfehler beim Anlegen eines neuen Kontos: " + e.getMessage());
    		} catch (PersistenzException e)
    		{
    			throw new KontoVerwaltungException("Fehler beim Öffnen der Datenbankverbindung: " + e.getMessage());
    		}
        }
	}
	
	public void entfernen(Konto k) throws KontoVerwaltungException, IllegalArgumentException
	{
        cache.remove(k.getNummer());
		try
        {
            PreparedStatement pstmt = ConnectionController.getInstance().getConnection().prepareStatement(
                    "DELETE FROM konten WHERE k_nummer = ?");
            pstmt.setInt(1, k.getNummer());
            if (pstmt.executeUpdate() != 1)
                throw new PersistenzException("Konto mit dieser Nummer existiert nicht");
            pstmt.close();
        } catch (SQLException e)
        {
            throw new KontoVerwaltungException("Datenbankfehler beim Löschen eines Kontos: " + e.getMessage());
        } catch (PersistenzException e)
        {
            throw new KontoVerwaltungException("Fehler beim Öffnen der Datenbankverbindung: " + e.getMessage());
        }
		
	}

	public List<Konto> getListe() throws KontoVerwaltungException
	{
        List<Konto> liste = new ArrayList<Konto>();
		try
        {
            PreparedStatement pstmt = ConnectionController.getInstance().getConnection().prepareStatement(
                    "SELECT k_nummer, k_besitzer, k_saldo, k_limit FROM konten ORDER BY k_nummer");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                int nummer = rs.getInt("k_nummer");
                double saldo = rs.getDouble("k_saldo");
                Konto konto = cache.get(nummer);
                if (konto == null)
                {
                    konto = new Konto(nummer, saldo);
                    cache.put(nummer, konto);
                }
                else
                    konto.setSaldo(saldo);
                konto.setBesitzer(rs.getString("k_besitzer"));
                konto.setLimit(rs.getDouble("k_limit"));
                liste.add(konto);

            }
            rs.close();
            pstmt.close();
            
        } catch (SQLException e)
        {
            throw new KontoVerwaltungException("Datenbankfehler beim Auslesen der Konten: " + e.getMessage());
        } catch (PersistenzException e)
        {
            throw new KontoVerwaltungException("Fehler beim Öffnen der Datenbankverbindung: " + e.getMessage());
        }
        
        return liste;
	}

	public List<Konto> get(String besitzerAnfang) throws KontoVerwaltungException
	{
        List<Konto> liste = new ArrayList<Konto>();
        try
        {
            PreparedStatement pstmt = ConnectionController.getInstance().getConnection().prepareStatement(
                    "SELECT k_nummer, k_besitzer, k_saldo, k_limit FROM konten WHERE LCASE(k_besitzer) like LCASE(?) " +
                    "ORDER BY k_nummer");
            pstmt.setString(1, besitzerAnfang + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                int nummer = rs.getInt("k_nummer");
                double saldo = rs.getDouble("k_saldo");
                Konto konto = cache.get(nummer);
                if (konto == null)
                {
                    konto = new Konto(nummer, saldo);
                    cache.put(nummer, konto);
                }
                else
                    konto.setSaldo(saldo);
                konto.setBesitzer(rs.getString("k_besitzer"));
                konto.setLimit(rs.getDouble("k_limit"));
                liste.add(konto);

            }
            rs.close();
            pstmt.close();
            
        } catch (SQLException e)
        {
            throw new KontoVerwaltungException("Datenbankfehler beim Auslesen der Konten: " + e.getMessage());
        } catch (PersistenzException e)
        {
            throw new KontoVerwaltungException("Fehler beim Öffnen der Datenbankverbindung: " + e.getMessage());
        }
        
        return liste;
    }

	public Konto get(int nummer) throws KontoVerwaltungException, IllegalArgumentException
	{
        Konto konto = null;
        try
        {
            PreparedStatement pstmt = ConnectionController.getInstance().getConnection().prepareStatement(
                    "SELECT k_nummer, k_besitzer, k_saldo, k_limit FROM konten WHERE k_nummer = ?");
            pstmt.setInt(1, nummer);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                double saldo = rs.getDouble("k_saldo");
                konto = cache.get(nummer);
                if (konto == null)
                {
                    konto = new Konto(nummer, saldo);
                    cache.put(nummer, konto);
                }
                else
                    konto.setSaldo(saldo);
                konto.setBesitzer(rs.getString("k_besitzer"));
                konto.setLimit(rs.getDouble("k_limit"));
            }
            rs.close();
            pstmt.close();
            
        } catch (SQLException e)
        {
            throw new KontoVerwaltungException("Datenbankfehler beim Auslesen der Konten: " + e.getMessage());
        } catch (PersistenzException e)
        {
            throw new KontoVerwaltungException("Fehler beim Öffnen der Datenbankverbindung: " + e.getMessage());
        }
        return konto;
    }

	public int erzeugeNummer() throws KontoVerwaltungException
	{
        int nummer = -1;
		try
        {
            PreparedStatement pstmt = ConnectionController.getInstance().getConnection().prepareStatement(
                    "SELECT NEXT VALUE FOR konto_nummern FROM sequence_select");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                nummer = rs.getInt(1);
            else
                throw new PersistenzException("keine Nummer von Sequenz konto_nummern");
            rs.close();
            pstmt.close();
        } catch (SQLException e)
        {
            throw new KontoVerwaltungException("Datenbankfehler Abfragen der nächsten Kontonummer: " + e.getMessage());
        } catch (PersistenzException e)
        {
            throw new KontoVerwaltungException("Fehler beim Öffnen der Datenbankverbindung: " + e.getMessage());
        }
        return nummer;
        
	}

	public void close() throws KontoVerwaltungException
	{
		try
		{
			ConnectionController.getInstance().closeConnection();
		} catch (PersistenzException e)
		{
			throw new KontoVerwaltungException("Fehler beim Schließen der Datenbankverbindung: " + e.getMessage());
		}
		
	}

	public void beginTransaktion() throws KontoVerwaltungException
	{
		try
		{
			Connection con = ConnectionController.getInstance().getConnection();
			if (con.getAutoCommit())
				con.setAutoCommit(false);
			else
				throw new PersistenzException("geschachtelte Transaktionen nicht unterstützt");
			
		} catch (SQLException e)
        {
            throw new KontoVerwaltungException("Datenbankfehler beim Begin einer Transaktion: " + e.getMessage());
        } catch (PersistenzException e)
        {
            throw new KontoVerwaltungException("Fehlerhafte Datenbankverbindung: " + e.getMessage());
        }
		
	}

	public void endTransaktion() throws KontoVerwaltungException
	{
		try
		{
			Connection con = ConnectionController.getInstance().getConnection();
			if (!con.getAutoCommit())
			{
				con.commit();
				con.setAutoCommit(true);
			}
			else
				throw new PersistenzException("keine Transaktion offen");
		} catch (SQLException e)
        {
            throw new KontoVerwaltungException("Datenbankfehler beim Abschließen einer Transaktion: " + e.getMessage());
        } catch (PersistenzException e)
        {
            throw new KontoVerwaltungException("Fehlerhafte Datenbankverbindung: " + e.getMessage());
        }
		
	}

	public void cancelTransaktion() throws KontoVerwaltungException
	{
		try
		{
			Connection con = ConnectionController.getInstance().getConnection();
			if (!con.getAutoCommit())
			{
				con.rollback();
				con.setAutoCommit(true);
			}
			else
				throw new PersistenzException("keine Transaktion offen");
		} catch (SQLException e)
        {
            throw new KontoVerwaltungException("Datenbankfehler beim Abbrechen einer Transaktion: " + e.getMessage());
        } catch (PersistenzException e)
        {
            throw new KontoVerwaltungException("Fehlerhafte Datenbankverbindung: " + e.getMessage());
        }
		
	}


}
