package collections.transport;

import java.util.Comparator;

public class PlattenComparator implements Comparator<Platte>
{
	char kriterium;

	/**
	 * Im Konstruktor ist das Sortierkriterium zu �bergeben
	 * @param kriterium 'l': L�nge
	 * 					'b': Breite
	 * 					'g': Gewicht
	 */
	public PlattenComparator(char kriterium)
	{
		this.kriterium = kriterium;
	}

	public int compare(Platte p1, Platte p2)
	{
		switch(kriterium)
		{
		case 'l':  // zuerst nach L�nge, falls gleich -> nach Breite
			if (p1.getLaenge() != p2.getLaenge())
				return (int)(p1.getLaenge() - p2.getLaenge());
			else
				return (int)(p1.getBreite() - p2.getBreite());

		case 'b':  // zuerst nach Breite, falls gleich -> nach L�nge
			if (p1.getBreite() != p2.getBreite())
				return (int)(p1.getBreite() - p2.getBreite());
			else
				return (int)(p1.getLaenge() - p2.getLaenge());
			
		case 'g':
			return (int) (p1.berechneGewicht() - p2.berechneGewicht());
			
		default:
			return 0;
		}
	}
	
	
	
	

}
