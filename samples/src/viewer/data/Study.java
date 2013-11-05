package viewer.data;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Study implements Comparable<Study>
{
	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy/HH:mm");
	private Map<String, Series> seriesList = new HashMap<String, Series>();
	
	private String studyInstanceUID;
	private Date studyBegin;
	
	
	public Collection<Series> getSeries()
	{
		return seriesList.values();
	}
	
	public Series add(Series s)
	{
		Series existing = seriesList.get(s.getSeriesInstanceUID());
		if (existing == null)
		{
			existing = s;
			seriesList.put(s.getSeriesInstanceUID(), existing);
		}
		return existing;
	}
	
	

	public String getStudyInstanceUID()
	{
		return studyInstanceUID;
	}

	public void setStudyInstanceUID(String studyInstanceUID)
	{
		this.studyInstanceUID = studyInstanceUID;
	}



	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("UID:\t\t").append(studyInstanceUID);
		str.append("\nStudy Begin;\t").append(DATE_FORMAT.format(studyBegin));
		str.append("\nNr. of Series:\t").append(seriesList.size());
		
		return str.toString();
	}

	public Date getStudyBegin()
	{
		return studyBegin;
	}

	public void setStudyBegin(Date studyBegin)
	{
		this.studyBegin = studyBegin;
	}

	@Override
	public int compareTo(Study s2)
	{
		return this.studyBegin.compareTo(s2.studyBegin);
	}
	
	
}
