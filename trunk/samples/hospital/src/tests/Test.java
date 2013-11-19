package tests;

import java.util.ArrayList;
import java.util.Date;

import patients.Adress;
import patients.Department;
import patients.Patient;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Patient p1 = new Patient(12345);
		p1.setName("Huber");
		p1.setFemale(true);
		
		Adress a1 = new Adress();
		a1.setCity("Wien");
		a1.setStreet("K‰rntnerstraﬂe 123");
		a1.setZip(1010);
		
		p1.setAdress(a1);
		p1.setBirth(new Date());
		
		Department dpt = new Department("Surgery");
		try
		{
			dpt.checkin(p1);
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		
		//dpt.checkout(p1);
		
		System.out.println(p1);
		
		
		System.out.println("alle Patienten, die mit Hu beginnen");
		ArrayList<Patient> l = dpt.findPatientsByName("Hu");
		System.out.println("Anzahl gefunden: " + l.size());
		
		for (Patient patient : l)
		{
			System.out.println(patient);
		}
		

	}

}
