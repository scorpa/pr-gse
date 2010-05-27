package buchungen;

import java.util.Date;
import java.util.List;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			BuchungDAO dao = new BuchungDAOImpl();
			System.out.println("Verbindung zur Datenbank hergestellt");
			
			List<Buchung> liste = dao.load();
			
			System.out.println("Orginale Buchungen: ");
			for (Buchung b : liste)
				System.out.println(b);
			
			for (int i = 2; i < liste.size(); i++)
				liste.get(i).setText("Text" + i);
			Buchung neu = new Buchung(999);
			neu.setText("neue Buchung");
			neu.setDatum(new Date());
			neu.setBetrag(111.11f);
			liste.add(neu);
			List<Buchung> aktualisiert = dao.update(liste);
			
			System.out.println("aktualisierte Buchungen:");
			for (Buchung b : aktualisiert)
				System.out.println(b);
			
			
			
			
			dao.close();
			System.out.println("Verbindung geschlossen");
		} catch (DBException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
