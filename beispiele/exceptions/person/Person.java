package exceptions.person;
import java.util.Date;


public class Person
{
	private String name;
	private Date geburtsDatum;
	private char geschlecht;
	
	public Person()
	{
		name = "unbekannt";
		geburtsDatum = new Date();
	}
	
	
	public Person(String name) throws NameException
	{
		super();
		setName(name);
	}
	
	public String getName()
	{
		return name;
	}
	
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
	
	public void setGeschlecht(char geschlecht)
	{
		if (geschlecht == 'w' || geschlecht == 'm')
			this.geschlecht = geschlecht;
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
