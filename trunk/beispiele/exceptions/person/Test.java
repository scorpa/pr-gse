package exceptions.person;

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
		} catch(Exception e)
		{
			System.out.println("irgendein Fehler");
		}
	}

}
