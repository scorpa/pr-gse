package patients;

import java.util.ArrayList;
import java.util.Date;

public class Department
{
	private ArrayList<Patient> patients;
	private int capacity;
	private String name;
	
	public Department(String name)
	{
		this.patients = new ArrayList<>();
		this.name = name;
		capacity = 10;
	}
	
	
	public void checkin(Patient p) throws Exception
	{
		if (this.patients.size() < this.capacity)
		{
			this.patients.add(p);  // Referenz auf Patient wird in Liste eingefügt
			p.setDepartment(this);
			p.setCheckinDate(new Date());
		}
		else
		{
			Exception e = new Exception("to many patients in department");
			throw e;
		}
			
	}
	
	public void checkout(Patient p)
	{
		// Patient wird wieder aus Patientenliste entfernt
		// und es wird das Department und auch das checkinDate auf null gesetzt
		if (this.patients.contains(p))
		{
			this.patients.remove(p);
			p.setDepartment(null);
			p.setCheckinDate(null);
		}
	}
	
	public ArrayList<Patient> findPatientsByName(String begin)
	{
		ArrayList<Patient> list = new ArrayList<>();
		for (Patient p : this.patients)
		{
			if (p.getName().startsWith(begin))
			{
				list.add(p);
			}
		}
		
		return list;
	}

}






