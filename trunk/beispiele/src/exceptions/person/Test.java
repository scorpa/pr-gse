package exceptions.person;

/**
 * Beispiel zum Thema Exceptions
 * @author Rudolf Radlbauer
 *
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			PersonUI ui = new PersonUI();
	
			ui.einlesen();
	
			ui.ausgeben();
		} catch(Exception e)  // fängt alle Exceptions
		{
			System.out.println("irgendein Fehler");
		}
	}

}
