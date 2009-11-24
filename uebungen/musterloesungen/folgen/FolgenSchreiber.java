package folgen;

/**
 * Der Folgenschreiber gibt mit den verschiedenen Methoden
 * jeweils eine Folge von Zahlen auf die Konsole aus.
 * @author Rudolf Radlbauer
 *
 */
public class FolgenSchreiber
{
	private int anzahl;  // Anzahl der Folgenglieder, welche geschrieben werden
	
	/**
	 * Standardkonstruktor setzt die Anzahl der auszugebenden Folgenglieder auf 10
	 */
	public FolgenSchreiber()
	{
		anzahl = 10;
	}
	
	/**
	 * Diesem Konstruktor wird die Anzahl der auszugebenden Folgenglieder 
	 * als Parameter übergeben
	 * @param anzahl
	 */
	public FolgenSchreiber(int anzahl)
	{
		this();
		setAnzahl(anzahl);
	}

	/**
	 * 
	 * @return die Anzahl der auszugebenden Folgenglieder
	 */
	public int getAnzahl()
	{
		return anzahl;
	}

	/**
	 * setzt die Anzahl der auszugebenden Folgenglieder
	 * @param anzahl
	 */
	public void setAnzahl(int anzahl)
	{
		if (anzahl > 0)
			this.anzahl = anzahl;
		else
			System.out.println("Die Anzahl muss positiv sein");
	}
	
	/**
	 * gibt die Zahlen von eins bis "anzahl" aus
	 */
	public void einfach()
	{
		int zaehler = 1;  // Zählervariable oder Laufvariable beginnt bei 1
		while (zaehler <= anzahl)
		{
			System.out.print(zaehler + " ");
			zaehler++;  // Laufvariable um 1 erhöhen
		}
		System.out.println();  // Zeilenumbruch
	}
	
	/**
	 * gibt die Zahlen von "anzahl" bis 1 aus
	 */
	public void umgekehrt()
	{
		int zaehler = anzahl;  // die Laufvariable beginnt diesmal bei anzahl
		while (zaehler >= 1)
		{
			System.out.print(zaehler + " ");
			zaehler--; // Laufvariable um 1 reduzieren
		}
		System.out.println();
	}
	
	/**
	 * bildet die Summe der Zahlen von 1 bis "anzahl"; 
	 * dabei wird jede Zwischensumme ausgegeben
	 */
	public void summe()
	{
		int zaehler = 1;  // Zählervariable oder Laufvariable beginnt bei 1
		int summe = 0;  // Variable, in welcher die Summe gebildet wird
		while(zaehler <= anzahl)
		{
			summe += zaehler;  //  Wert der Laufvariable zur Summe zählen
			System.out.print(summe + " ");
			zaehler++;  // Laufvariable erhöhen
		}
		System.out.println();
	}

	/**
	 * bildet das Produkt der Zahlen von 1 bis "anzahl";
	 * dabei wird jedes Zwischenprodukt ausgegeben
	 */
	public void faktorielle()
	{
		int zaehler = 1;  // Zählervariable oder Laufvariable beginnt bei 1
		long produkt = 1; // Variable, in welcher das Produkt gebildet wird
		while (zaehler <= anzahl)
		{
			produkt *= zaehler;  // produkt mit Wert der Laufvariable multiplizieren
			System.out.print(produkt + " ");
			zaehler++; // Laufvariable um 1 erhöhen
		}
		System.out.println();
	}
	
	/**
	 * gibt die ersten "anzahl" Glieder der Fibonacci-Folge aus
	 * (siehe http://de.wikipedia.org/wiki/Fibonacci-Folge)
	 */
	public void fibonacci()
	{
		int vorletztes = 0;  // vorletztes Glied der Folge (bei Beginn 0)
		int letztes = 1;     // letztes Glied der Folge (bei Beginn 1)
		int zaehler = 0; // Laufvariable
		while (zaehler < anzahl)
		{
			System.out.print(vorletztes + " ");  // gib vorletzes Glied (bei Beginn erstes) der Folge aus
			int neues = vorletztes + letztes;  // neues ergibt sich aus dem Bildungsgesetz
			// Zahlen werden verschoben: neues -> letztes, letztes -> vorletztes
			vorletztes = letztes; 
			letztes = neues;
			zaehler++;  // Laufvariable erhöhen
		}
		System.out.println(); // Zeilenumbruch		
	}
	
	/**
	 * gibt die ersten "anzahl" Primzahlen aus
	 */
	public void primzahlen()
	{
		int aktuell = 1;  // aktuelle Primzahl (bei Beginn 1)
		int zaehler = 0;  // Laufvariable
		while (zaehler < anzahl)
		{
			System.out.print(aktuell + " ");  // gib aktuell berechnete Primzahl aus
			// berechne nun die nächste Primzahl
			boolean gefunden = false;  // Hilfsvariable, welche angibt, ob die nächste Primzahl schon gefunden wurde
			while (!gefunden)  // mach weiter, solange die nächste Primzahl nicht gefunden wurde
			{
				aktuell++; // untersuche die nächste Zahl
				boolean primzahl = true; // Hilfsvariable, welche angibt, ob noch angenommen werden kann, dass aktuell eine Primzahl ist
				int teiler = 2; // mit dem Teiler wird getestet, ob aktuelle Zahl teilbar ist
				while (primzahl && teiler < aktuell)
				{
					if (aktuell % teiler == 0)
						primzahl = false;  // aktuell ist teilbar und daher keine Primzahl
					teiler++; // teste mit nächstem Teiler
				}
				if (primzahl)
					gefunden = true;
			}
			zaehler++; // Laufvariable erhöhen
		}
		System.out.println();
	}

	/**
	 * gibt alle Folgen aus (ruft die anderen Methoden auf)
	 */
	public void alleFolgen()
	{
		System.out.print("Zahlen von 1 bis " + anzahl + ": ");
		einfach();
		System.out.print("Zahlen von " + anzahl + " bis 1: ");
		umgekehrt();
		System.out.print("Summen von 1 bis " + anzahl + ": ");
		summe();
		System.out.print("Produkte von 1 bis " + anzahl + ": ");
		faktorielle();
		System.out.print("Die ersten " + anzahl + " Fibonacci-Zahlen: ");
		fibonacci();
		System.out.print("Die ersten " + anzahl + " Primzahlen: ");
		primzahlen();
	}
	
	public static void main(String[] args)
	{
		new FolgenSchreiber().alleFolgen();
	}

}
