package kontobuchungen;

import java.util.ArrayList;

public class Konto
{
	private int nummer;
	private ArrayList<Buchung> buchungen;
	
	public Konto(int nummer)
	{
		buchungen = new ArrayList<Buchung>();
		if (nummer > 0)
			this.nummer = nummer;
		else
		{
			System.out.println("ungültige Nummer");
			nummer = 0;
		}
	}
	
	public int getNummer()
	{
		return nummer;
	}
	
	public void einzahlen(double betrag, String text)
	{
		if (betrag > 0)
			buchungen.add(new Buchung(betrag, text));
		else
			System.out.println("Betrag muss positiv sein");
	}

	public void auszahlen(double betrag, String text)
	{
		if (betrag > 0)
		{
			if (saldo() - betrag >= 0)
				buchungen.add(new Buchung(-betrag, text));
			else
				System.out.println("Das Konto darf nicht überzogen werden");
		}
		else
			System.out.println("Betrag muss positiv sein");
	}
	
	public double saldo()
	{
		double summe = 0;
		for (Buchung b : buchungen)
			summe += b.getBetrag();
		return summe;
	}
	
	public void auszug()
	{
		for (int i = 0; i < buchungen.size(); i++)
		{
			Buchung b = buchungen.get(i);
			System.out.println((i+1) + "\t" + b.getBetrag() + "\t" + b.getText());
		}
	}
	
	public double summeEin()
	{
		double summe = 0;
		for (Buchung b : buchungen)
		{
			if (b.getBetrag() > 0)
				summe += b.getBetrag();
		}
		return summe;
	}
	
	public Buchung maxAus()
	{
		Buchung max = null;
		if (buchungen.size() > 0)
		{
			max = buchungen.get(0);
			for (Buchung b : buchungen)
			{
				if (b.getBetrag() < max.getBetrag())
					max = b;
			}
			if (max.getBetrag() >= 0)
				max = null;
		}
		return max;
	}
	
	public void stornieren(int nr)
	{
		if (nr > 0 && nr <= buchungen.size())
			buchungen.remove(nr-1);
		else
			System.out.println("ungültige Nummer");
	}
	
	public int anzahl()
	{
		return buchungen.size();
	}
}
