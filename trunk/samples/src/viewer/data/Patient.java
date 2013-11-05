package viewer.data;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Patient implements Comparable<Patient>
{
	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	private Map<String, Study> studies = new HashMap<String, Study>();
	
	private String patientID;
	private String patientName;
	private Date birth;
	private char sex;
	

	public Collection<Study> getStudies()
	{
		return studies.values();
	}

	public Study add(Study study)
	{
		Study existing = studies.get(study.getStudyInstanceUID());
		if (existing == null)
		{
			existing = study;
			studies.put(study.getStudyInstanceUID(), existing);
		}
		return existing;
	}
	
	public String getPatientID()
	{
		return patientID;
	}
	
	public void setPatientID(String patientID)
	{
		this.patientID = patientID;
	}
	
	public String getPatientName()
	{
		return patientName;
	}
	
	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("ID:\t\t").append(patientID);
		str.append("\nName:\t\t").append(patientName);
		str.append("\nDate of Birth:\t").append(DATE_FORMAT.format(birth));
		str.append("\nPatient's Sex:\t").append(sex);
		str.append("\nNr. of Studies:\t").append(studies.size());
		
		return str.toString();
	}

	public Date getBirth()
	{
		return birth;
	}

	public void setBirth(Date birth)
	{
		this.birth = birth;
	}

	public char getSex()
	{
		return sex;
	}

	public void setSex(char sex)
	{
		this.sex = sex;
	}

	@Override
	public int compareTo(Patient p2)
	{
		return this.patientName.compareToIgnoreCase(p2.patientName);
	}



}
