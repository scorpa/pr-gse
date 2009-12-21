package plattenverwaltung;

public class PlattenVerwaltung
{
	private Platte[] platten;
	private int anzahl;
	
	public PlattenVerwaltung(int max)
	{
		if (max > 0)
			platten = new Platte[max];
		else
		{
			platten = new Platte[100];
			System.out.println("Maximale Plattenanzahl: 100");
		}
		anzahl = 0;
	}
	
	public void aufnehmen(Platte p)
	{
		if (anzahl < platten.length)
		{
			if (finden(p.getNummer()) >= 0)
				System.out.println("Platte ist schon vorhanden");
			else
			{
				platten[anzahl] = p;
				anzahl++;
			}
		}
		else
			System.out.println("Verwaltung ist schon voll");
	}
	
	public void ausgeben()
	{
		int index = 0;
		System.out.println("Nummer\tLänge\tBreite\tFläche\tUmfang");
		while (index < anzahl)
		{
			Platte p = platten[index];
			System.out.println(p.getNummer() + "\t" 
					+ p.getLaenge() + "\t" 
					+ p.getBreite() + "\t"
					+ p.berechneFlaeche() + "\t"
					+ p.berechneUmfang());
			index++;
		}
	}
	
	public Platte get(int index)
	{
		if (index >= 0 && index < anzahl)
			return platten[index];
		else
			return null;
	}
	
	public double gesamtFlaeche()
	{
		double summe = 0;
		int index = 0;
		while (index < anzahl)
		{
			summe += platten[index].berechneFlaeche();
			index++;
		}
		return summe;
	}
	
	public Platte groesste()
	{
		if (anzahl > 0)
		{
			int max = 0;
			int index = 1;
			while(index < anzahl)
			{
				if (platten[index].berechneFlaeche() > platten[max].berechneFlaeche())
					max = index;
				index++;
			}
			return platten[max];
		}
		else
			return null;
	}
	
	public void sortieren()
	{
		int index1 = 0;
		while (index1 < anzahl-1)
		{
			int index2 = index1 + 1;
			while (index2 < anzahl)
			{
				if (platten[index2].getNummer() < platten[index1].getNummer())
				{
					Platte p = platten[index1];
					platten[index1] = platten[index2];
					platten[index2] = p;
				}
				index2++;
			}
			index1++;
		}
	}
	
	public int finden(int nummer)
	{
		int index = 0;
		while (index < anzahl)
		{
			if (platten[index].getNummer() == nummer)
				return index;
			index++;
		}
		return -1;
	}

}
