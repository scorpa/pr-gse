package exceptions.person;
import java.util.Date;

/**
 * Beispiel zum Thema Exceptions
 * @author Rudolf Radlbauer
 *
 */
public class Person
{
	private String name;
	private Date geburtsDatum;
	private char geschlecht;
	
	/**
	 * 
	 * @throws NameException kann von Person(name) kommen - sollte eigentlich nicht auftreten
	 */
	public Person() throws NameException
	{
			this("unbekannt");
	}
	
	/**
	 * 
	 * @param name Name der Person
	 * @throws NameException kann von setName(name) kommen
	 */
	public Person(String name) throws NameException
	{
		super();
		setName(name);
		geburtsDatum = new Date();
		geschlecht = '?';
	}
	
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @param name Name der Person
	 * @throws NameException falls name null oder ein Leerstring ist
	 */
	public void setName(String name) throws NameException
	{
		if (name != null && name.length() > 0)
			this.name = name;
		else
			throw new NameException("ungültiger Name");
	}
	
	public Date getGeburtsDatum()
	{
		return geburtsDatum;
	}
	
	/**
	 * 
	 * @param geburtsDatum Geburtsdatum der Person
	 * @throws DatumException falls das Geburtsdatum in der Zukunft liegt
	 */
	public void setGeburtsDatum(Date geburtsDatum)
		throws DatumException
	{
		Date heute = new Date();
		// Geburtsdatum muss in Vergangenheit liegen
		if (heute.compareTo(geburtsDatum) >= 0)
		{
			this.geburtsDatum = geburtsDatum;
		}
		else
		{
			DatumException e = new DatumException
				("Geburtdatum in der Vergangenheit");
			throw e;
		}
			
	}
	
	public char getGeschlecht()
	{
		return geschlecht;
	}
	
	/**
	 * 
	 * @param geschlecht Geschlecht der Person
	 * @throws GeschlechtException falls das Geschlecht nicht 'm' oder 'w' ist
	 */
	public void setGeschlecht(char geschlecht) throws GeschlechtException
	{
		if (geschlecht == 'w' || geschlecht == 'm')
			this.geschlecht = geschlecht;
		else
			throw new GeschlechtException("ungültiges Geschlecht");
	}


	@Override
	public String toString()
	{
		StringBuilder str =new StringBuilder( super.toString());
		str.append(" Name=").append(name);
		str.append(" Geburtsdatum=").append(geburtsDatum);
		str.append(" Geschlecht=").append(geschlecht);
		
		return str.toString();
	}
	
	
	
	

}
