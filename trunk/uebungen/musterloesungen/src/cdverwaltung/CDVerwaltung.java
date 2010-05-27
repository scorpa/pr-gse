package cdverwaltung;

public class CDVerwaltung
{
	private CD[] cds;
	private int anzahl;
	
	public CDVerwaltung(int kapazitaet)
	{
		if (kapazitaet <= 0)
		{
			System.out.println("ungültige Kapazität --> 100");
			kapazitaet = 100;
		}
		cds = new CD[kapazitaet];
		anzahl = 0;
	}
	
	public void add(CD cd)
	{
		if (anzahl < cds.length)
		{
			if (finden(cd.getInterpret(), cd.getTitel()) == null)
			{
				cds[anzahl] = cd;
				anzahl++;
			}
			else
				System.out.println("CD bereits vorhanden");
		}
		else
			System.out.println("kein Platz mehr");
	}
	
	public CD finden(String interpret, String titel)
	{
		int index = 0;
		while (index < anzahl)
		{
			CD cd = cds[index];
			if (interpret.equals(cd.getInterpret()) && titel.equals(cd.getTitel()))
				return cd;
			index++;
		}
		return null;
	}
	
	public void liste()
	{
		int index = 0;
		while (index < anzahl)
		{
			CD cd = cds[index];
			System.out.println(cd.getInterpret() + ":\t" + cd.getTitel() + "\t("
					+ cd.gesamtDauer() + " min)");
			index++;
		}
	}
	
	public CD laengste()
	{
		if (anzahl > 0)
		{
			CD max = cds[0];
			int index = 1;
			while (index < anzahl)
			{
				if (cds[index].gesamtDauer() > max.gesamtDauer())
					max = cds[index];
				index++;
			}
			return max;
		}
		return null;
	}
	
}
