package swing;

import java.util.Calendar;
import java.util.Date;


/**
 * Datenobjekt für einen entsprechenden Eingabedialog
 * Die set-Methoden werfen eine IllegalArgument-Exception,
 * falls ein ungültiger Wert übergeben wird.
 * Die throws-Deklaration ist zwar nicht nötig,
 * weil es sich um eine RuntimeException handelt,
 * ist aber guter Stil
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Buch
{
	private String titel;
	private String autor;
	private int seiten;
	private int erscheinungsJahr;
	
	public Buch()
	{
		// mit diesen Standardwerten wird der Eingabedialog für
		// ein neues Buch vorbelegt.
		titel = "";
		autor = "";
		seiten = 0;
		erscheinungsJahr = 2000;
	}
	
	public String getTitel()
	{
		return titel;
	}
	
	public void setTitel(String titel) throws IllegalArgumentException
	{
		if (titel != null && titel.trim().length() > 0)
			this.titel = titel;
		else
			throw new IllegalArgumentException("Titel darf nicht leer sein");
	}
	
	public String getAutor()
	{
		return autor;
	}
	
	public void setAutor(String autor) throws IllegalArgumentException
	{
		if (autor != null && autor.trim().length() > 0)
			this.autor = autor;
		else
			throw new IllegalArgumentException("Autor darf nicht leer sein");
	}
	
	public int getSeiten()
	{
		return seiten;
	}
	
	public void setSeiten(int seiten) throws IllegalArgumentException
	{
		if (seiten > 0)
			this.seiten = seiten;
		else
			throw new IllegalArgumentException("Seitenanzahl muss größer als 0 sein.");
	}
	
	public int getErscheinungsJahr()
	{
		return erscheinungsJahr;
	}
	
	public void setErscheinungsJahr(int erscheinungsJahr) throws IllegalArgumentException
	{
		int jahr = Calendar.getInstance().get(Calendar.YEAR);
		if (erscheinungsJahr > 1500 && erscheinungsJahr <= jahr)
			this.erscheinungsJahr = erscheinungsJahr;
		else
			throw new IllegalArgumentException("ungültiges Erscheinungsjahr");
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder(super.toString());
		str.append("\tAutor: ").append(autor);
		str.append("\tTitel: ").append(titel);
		str.append("\tErscheinungsjahr: ").append(erscheinungsJahr);
		str.append("\tSeiten: ").append(seiten);
		return str.toString();
	}
	
	
	
	

}
