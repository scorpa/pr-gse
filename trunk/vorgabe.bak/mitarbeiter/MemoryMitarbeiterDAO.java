package mitarbeiter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMitarbeiterDAO implements MitarbeiterDAO
{
	protected Map<Integer, Mitarbeiter> repository = new HashMap<Integer, Mitarbeiter>();
	protected int maxNr = 0;

	public Mitarbeiter finden(int nr) throws PersistenzException
	{
		return repository.get(nr);
	}

	
	public List<Mitarbeiter> findeAlle() throws PersistenzException
	{
		List<Mitarbeiter> liste = new ArrayList<Mitarbeiter>();
		for (Mitarbeiter ma : repository.values())
		{
			liste.add(ma);
		}
		return liste;
	}


	public List<Mitarbeiter> finden(String nachname) throws PersistenzException
	{
		List<Mitarbeiter> liste = new ArrayList<Mitarbeiter>();
		for (Mitarbeiter ma : repository.values())
		{
			if (ma.getNachname().startsWith(nachname))
				liste.add(ma);
		}
		return liste;
	}


	public List<Mitarbeiter> finden(Date von, Date bis)
			throws PersistenzException
	{
		List<Mitarbeiter> liste = new ArrayList<Mitarbeiter>();
		for (Mitarbeiter ma : repository.values())
		{
			if (ma.getGeburtsDatum().compareTo(von) >= 0 && ma.getGeburtsDatum().compareTo(bis) <= 0)
				liste.add(ma);
		}
		return liste;
	}


	public void loeschen(Mitarbeiter ma) throws PersistenzException
	{
		if (ma == null || repository.remove(ma.getNr()) == null)
			throw new PersistenzException("dieser Mitarbeiter existit nicht");
	}


	public void speichern(Mitarbeiter ma) throws PersistenzException, IllegalArgumentException
	{
		if (ma == null)
			throw new IllegalArgumentException("Parameter darf nicht null sein");
		int nr = ma.getNr();
		if (nr == 0)
		{
			maxNr++;
			ma.setNr(maxNr);
			repository.put(maxNr, ma);
		}
		else
		{
			Mitarbeiter alt = repository.get(nr);
			if (alt == null || alt != ma) // sollte eigentlich nicht passieren
				throw new PersistenzException("Repository inkonsistent");
		}		
	}



	public void close() throws PersistenzException
	{
		// nichts zu tun
		
	}



}
