package patients;

import java.util.Date;

public class Patient
{
	private int svnr;
	private String name;
	private Date birth;
	private boolean female;
	private Adress adress;
	private Department department;  // in which department was the patient checked in
	private Date checkinDate;  // when was the patient checked in
	
	
	
	public Patient(int svnr)
	{
		this.svnr = svnr;
		this.adress = new Adress();
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public Date getBirth()
	{
		return birth;
	}


	public void setBirth(Date birth)
	{
		this.birth = birth;
	}


	public boolean isFemale()
	{
		return female;
	}


	public void setFemale(boolean female)
	{
		this.female = female;
	}


	public Adress getAdress()
	{
		return adress;
	}


	public void setAdress(Adress adress)
	{
		this.adress = adress;
	}


	public int getSvnr()
	{
		return svnr;
	}
	
	public Date getCheckinDate()
	{
		return checkinDate;
	}
	
	public void setCheckinDate(Date checkinDate)
	{
		this.checkinDate = checkinDate;
	}


	@Override
	public String toString()
	{
		return name;
	}


	public Department getDepartment()
	{
		return department;
	}


	public void setDepartment(Department department)
	{
		this.department = department;
	}
	

	
}
