package buchungen;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Buchung
{
	private int id;
	private Date datum;
	private String text;
	private float betrag;
	
	
	public Buchung(int id)
	{
		setId(id);
		datum = new Date();
		text = "";
		betrag = 0;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		if (id > 0)
			this.id = id;
		else
			throw new IllegalArgumentException("ungültige ID");
	}


	public Date getDatum()
	{
		return datum;
	}


	public void setDatum(Date datum)
	{
		this.datum = datum;
	}


	public String getText()
	{
		return text;
	}


	public void setText(String text)
	{
		this.text = text;
	}


	public float getBetrag()
	{
		return betrag;
	}


	public void setBetrag(float betrag)
	{
		this.betrag = betrag;
	}



	public String toString()
	{
		StringBuilder str = new StringBuilder(super.toString());
		str.append(" id=").append(id);
		str.append(" datum=").append(SimpleDateFormat.getInstance().format(datum));
		str.append(" text=").append(text);
		str.append(" betrag=").append(betrag);
		
		return str.toString();
	}
	
	

}
