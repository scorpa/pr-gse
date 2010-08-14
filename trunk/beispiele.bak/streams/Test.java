package streams;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BuchVerwaltung v0 = new BuchVerwaltung();
		
		Buch b1 = new Buch("1-2-3-4-5");
		b1.setAutor("Grimm");
		b1.setTitel("Schneewittchen");
		b1.setSeiten(25);
		b1.setVerlag("Märchenverlag");
		b1.entlehnen("Huber");
		
		Buch b2 = new Buch("5-4-3-2-1");
		b2.setAutor("Marx");
		b2.setTitel("Das Kapital");
		b2.setSeiten(250);
		b2.setVerlag("Genossenschaftsverlag");

		v0.anlegen(b1);
		v0.anlegen(b2);
		
		v0.serialisieren("Buecher.ser");
		v0.speichern("Buecher.dat");
		v0.schreiben("Buecher.txt");

		BuchVerwaltung v1 = new BuchVerwaltung();
		v1.deserialisieren("Buecher.ser");
		BuchVerwaltung v2 = new BuchVerwaltung();
		v2.laden("Buecher.dat");
		BuchVerwaltung v3 = new BuchVerwaltung();
		v3.einlesen("Buecher.txt");
		
		
		System.out.println("======== original ==========");
		System.out.println(v0);
		System.out.println("======== serialisiert ==========");
		System.out.println(v1);
		System.out.println("======== binär ==========");
		System.out.println(v2);
		System.out.println("======== text ==========");
		System.out.println(v3);
		
		
	}

}
