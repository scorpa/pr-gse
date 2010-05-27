package plattenverwaltung;

public class Test
{

	public void test()
	{
		PlattenVerwaltung pv = new PlattenVerwaltung(5);
		Platte p1 = new Platte(1);
		Platte p2 = new Platte(2);
		Platte p3 = new Platte(3);
		Platte p4 = new Platte(4);
		Platte p5 = new Platte(5);
		Platte p6 = new Platte(6);
		Platte p7 = new Platte(1);
		
		p1.setLaenge(5); p1.setBreite(3);
		p2.setLaenge(3); p2.setBreite(3);
		p3.setLaenge(1); p3.setBreite(3);
		p4.setLaenge(2); p4.setBreite(3);
		p5.setLaenge(10); p5.setBreite(3);
		p6.setLaenge(4); p6.setBreite(3);
		p7.setLaenge(6); p7.setBreite(3);
		
		pv.aufnehmen(p3);
		pv.aufnehmen(p1);
		pv.aufnehmen(p7);   // Fehler weil gleiche Nummer
		pv.aufnehmen(p2);
		pv.aufnehmen(p6);
		pv.aufnehmen(p5);
		pv.aufnehmen(p4);    // Fehler weil voll
		
		pv.ausgeben();
		System.out.println("Beim Index 2 befindet sich die Platte mit der Nummer " 
				+ pv.get(2).getNummer());
		
		
		System.out.println("Gesamtfläche: " + pv.gesamtFlaeche());
		
		System.out.println("Die größte Platte hat die Nummer " + pv.groesste().getNummer());
		
		pv.sortieren();
		
		pv.ausgeben();
		
	}
}
