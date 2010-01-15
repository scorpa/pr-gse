package usermanager;


public class User
{
	private int id = -1;
	private String name = "unbekannt";
	private String userName = "unbekannt";
	private String password = "leer";
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		if (id > 0)
			this.id = id;
		else
			throw new IllegalArgumentException("ung�ltige ID");
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		if (name != null && name.trim().length() > 0)
			this.name = name;
		else
			throw new IllegalArgumentException("Name darf nicht leer sein");
	}
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String userName)
	{
		if (userName != null && userName.trim().length() > 0)
			this.userName = userName;
		else
			throw new IllegalArgumentException("Benutzername darf nicht leer sein");
	}
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		if (password != null && password.length() > 0)
			this.password = password;
		else
			throw new IllegalArgumentException("Passwort mit L�nge 0 nicht erlaubt");
	}
	
	

}
