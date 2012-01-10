package kontobuchungen;

public class Buchung
{
	private double betrag;
	private String text;
	
	
	public Buchung(double betrag, String text)
	{
		this.betrag = betrag;
		if (text != null && text.length() > 0)
			this.text = text;
		else
		{
			System.out.println("Buchungstext darf nicht leer sein");
			this.text = "unbekannt";
		}
	}


	public double getBetrag()
	{
		return betrag;
	}


	public String getText()
	{
		return text;
	}
	
	

}
