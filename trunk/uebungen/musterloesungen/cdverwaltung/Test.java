package cdverwaltung;

public class Test
{
	public void test()
	{
		CDVerwaltung cdv = new CDVerwaltung(5);
		for (int i = 0; i < 4; i++)
		{
			CD cd = new CD(i+5);
			cd.setInterpret("S�nger " + i);
			cd.setTitel("Titel " + i);
			cdv.add(cd);
		}
		CD cd = new CD(10);
		cd.setInterpret("S�nger 1");
		cd.setTitel("Titel 1");
		cdv.add(cd); // Fehler weil schon vorhanden
		cd.setInterpret("S�nger 25");
		cdv.add(cd); // ok
		
		CD cd2 = new CD(5);
		cdv.add(cd2); // Fehler weil voll
		
		cdv.liste();
		
		System.out.println("CD mit l�ngster Spieldauer: ");
		cdv.laengste().print();
	}


}
