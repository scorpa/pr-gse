package collections.transport;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Container cont = new Container(10, 4);
		cont.setMaximalesLadegewicht(30000);
		Kunde k = new Kunde("Mustermann");
		k.setAdresse("Hauptstraﬂe 1");
		cont.setKunde(k);
		cont.aufladen(new Platte(5,3));
		cont.aufladen(new Platte(6,1));
		cont.aufladen(new Platte(4,4));
		cont.aufladen(new Platte(1,1));
		
		System.out.println("----------------- unsortiert ------------");
		System.out.println(cont);
		System.out.println("----------------- nach L‰nge ------------");
		cont.sortiereNachLaenge();
		System.out.println(cont);
		System.out.println("----------------- nach Breite ------------");
		cont.sortiereNachBreite();
		System.out.println(cont);
		System.out.println("----------------- nach Gewicht ------------");
		cont.sortiereNachGewicht();
		System.out.println(cont);

	}

}
