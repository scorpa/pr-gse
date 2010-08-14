package collections.transport;

public class Kunde
{
    private String name;
    private String adresse;
    
    
    public Kunde(String name)
    {
        setName(name);
    }


    public String getAdresse()
    {
        return adresse;
    }


    public void setAdresse(String adresse)
    {
        if (adresse != null && adresse.length() > 0)
            this.adresse = adresse;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        if (name != null && name.length() > 0)
            this.name = name;
    }


	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder(super.toString());
		str.append(" Name=").append(name);
		str.append(" Adresse=").append(adresse);
		return str.toString();
	}
    
    
    
    

}
