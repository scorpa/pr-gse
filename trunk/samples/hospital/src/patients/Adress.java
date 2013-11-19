package patients;

public class Adress
{
	private String street;
	private int zip;
	private String city;
	
	public String getStreet()
	{
		return street;
	}
	public void setStreet(String street)
	{
		this.street = street;
	}
	public int getZip()
	{
		return zip;
	}
	public void setZip(int zip)
	{
		this.zip = zip;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	@Override
	public String toString()
	{
		return "Adress [street=" + street + ", zip=" + zip + ", city=" + city
				+ "]";
	}
	
	
}
