package exceptions.person;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Beispiel zum Thema Exceptions
 * @author Rudolf Radlbauer
 *
 */
public class PersonUI
{
	private Person p;
	
	public PersonUI()
	{
		try
		{
			p = new Person();
		} catch (NameException e)
		{
			// sollte eigentlich nicht auftreten --> Programm beenden
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void einlesen() throws Exception
	{
		try
		{
			String name = Input.readText("Name: ");
			p.setName(name);
			Date geburtsDatum = Input.readDate("Geburtsdatum: ");
			p.setGeburtsDatum(geburtsDatum);
			char geschlecht = Input.readChar("Geschlecht: ");
			p.setGeschlecht(geschlecht);
		} catch(DatumException e)
		{
			System.out.println("Fehler in setDatum(): " + e.getMessage());
			throw e;  // wirft die Ausnahme weiter
		} catch(NameException e)
		{
			System.out.println("Fehler in setName(): " + e.getMessage());
			throw e;
		}
		catch(GeschlechtException e)
		{
			System.out.println("Fehler in seGeschlecht(): " + e.getMessage());
			throw e;
		}
		
	}
	
	public void ausgeben()
	{
		System.out.println("Name: " + p.getName());
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println("Geburtsdatum: " 
				+ formatter.format(p.getGeburtsDatum()));
		System.out.println("Geschlecht: " + p.getGeschlecht());
	}

}
