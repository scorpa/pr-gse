/*
 * Created on 22.12.2005
 *
 */
package bank.fachlogik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementierung von KontoVerwaltung, wo die Daten einfach nur im Speicher gehalten werden
 * @author  Rudolf Radlbauer
 */
public class SpeicherKontoVerwaltung implements KontoVerwaltung
{
    private Map<Integer, Konto> konten;
    
    private int naechsteNummer;  // wird einfach hochgezählt
    
    
    public SpeicherKontoVerwaltung()
    {
        konten = new HashMap<Integer, Konto>();
        naechsteNummer=1001;
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#speichern(fachlogik.Konto)
     */
    public void speichern(Konto k) throws KontoVerwaltungException, IllegalStateException, IllegalArgumentException
    {
        if (k == null)
            throw new IllegalArgumentException("ungültiges Konto");
        Konto k1 = konten.get(k.getNummer());
        if (k1 == null)
            konten.put(k.getNummer(), k);
        else if (k1 != k)
            throw new KontoVerwaltungException("ein Konto mit dieser Nummer existiert bereits: " + k.getNummer());
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#entfernen(fachlogik.Konto)
     */
    public void entfernen(Konto k) throws KontoVerwaltungException, IllegalArgumentException
    {
        if (k == null)
            throw new IllegalArgumentException("ungültiges Konto");
        konten.remove(k.getNummer());
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#getListe()
     */
    public List<Konto> getListe() throws KontoVerwaltungException
    {
        return new ArrayList<Konto>(konten.values());
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#get(java.lang.String)
     */
    public List<Konto> get(String besitzerAnfang) throws KontoVerwaltungException
    {
        List<Konto> liste = new ArrayList<Konto>();
        for (Konto k : konten.values())
        {
            if (k.getBesitzer().toLowerCase().startsWith(besitzerAnfang.toLowerCase()))
                liste.add(k);
        }
        return liste;
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#get(int)
     */
    public Konto get(int nummer) throws KontoVerwaltungException, IllegalArgumentException
    {
        Konto k = konten.get(nummer);
        if (k != null)
            return k;
        else
            throw new IllegalArgumentException("kein Konto zu dieser Nummer: " + nummer);
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#erzeugeNummer()
     */
    public int erzeugeNummer() throws KontoVerwaltungException
    {
        naechsteNummer++;
        return naechsteNummer-1;
    }
    

	public void close() throws KontoVerwaltungException
	{
		// nichs zu tun
		
	}

	public void beginTransaktion() throws KontoVerwaltungException
	{
		// nichts zu tun
		
	}

	public void endTransaktion() throws KontoVerwaltungException
	{
		// nichts zu tun
		
	}

	public void cancelTransaktion() throws KontoVerwaltungException
	{
		throw new KontoVerwaltungException("Transaktionen nicht unterstützt");
		
	}

}
