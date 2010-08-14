package tictactoe;

public class Logik implements Spielfeld
{
	private FARBE[][] feld;
	private int gewinnZahl;
	private FARBE next;
	private FARBE sieger;

	public Logik(int zeilen, int spalten, int gewinnZahl)
	{
		feld = new FARBE[zeilen][spalten];
		this.gewinnZahl = gewinnZahl;
		next = FARBE.ROT; // rot beginnt
		sieger = FARBE.LEER;

		for (int z = 0; z < feld.length; z++)
			for (int s = 0; s < feld[0].length; s++)
				feld[z][s] = FARBE.LEER;
	}

	public FARBE get(int zeile, int spalte)
	{
		return feld[zeile][spalte];
	}

	public int getGewinnZahl()
	{
		return gewinnZahl;
	}

	public int getNSpalten()
	{
		return feld[0].length;
	}

	public int getNZeilen()
	{
		return feld.length;
	}

	public FARBE getNext()
	{
		return next;
	}

	public FARBE getSieger()
	{
		return sieger;
	}

	public void set(int zeile, int spalte) throws TictactoeException
	{
		if (sieger != FARBE.LEER)
			throw new TictactoeException("Spiel ist bereits beendet");

		if (feld[zeile][spalte] == FARBE.LEER)
		{
			feld[zeile][spalte] = next;
			if (next == FARBE.ROT)
				next = FARBE.GRUEN;
			else
				next = FARBE.ROT;

			check();
		} else
			throw new TictactoeException("Feld ist bereits besetzt");

	}

	// überprüft, ob eine Farbe gewonnen hat
	private void check()
	{
		if (sieger == FARBE.LEER)
		{
			for (int z = 0; z < feld.length; z++)
				for (int s = 0; s < feld[0].length; s++)
				{
					FARBE aktuell = feld[z][s];
					if (aktuell == FARBE.LEER) continue;
					int i = 0;
					// prüfe vertikal
					for (i = 0; i < gewinnZahl && z + i < feld.length; i++)
					{
						if (feld[z + i][s] != aktuell)
							break;
					}
					if (i == gewinnZahl)
					{
						sieger = aktuell;
						return;
					}
					// prüfe horizontal
					for (i = 0; i < gewinnZahl && s + i < feld[0].length; i++)
					{
						if (feld[z][s + i] != aktuell)
							break;
					}
					if (i == gewinnZahl)
					{
						sieger = aktuell;
						return;
					}
					// prüfe schräg nach unten
					for (i = 0; i < gewinnZahl && z+i < feld.length && s + i < feld[0].length; i++)
					{
						if (feld[z + i][s + i] != aktuell)
							break;
					}
					if (i == gewinnZahl)
					{
						sieger = aktuell;
						return;
					}
					// prüfe schräg nach oben
					for (i = 0; i < gewinnZahl && z-i >= 0 && s + i < feld[0].length; i++)
					{
						if (feld[z - i][s + i] != aktuell)
							break;
					}
					if (i == gewinnZahl)
					{
						sieger = aktuell;
						return;
					}
				}
		}
	}

}
