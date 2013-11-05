package viewer.data;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

public class Series implements Comparable<Series>
{
	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy / HH:mm");
	private Map<String, Image> images = new HashMap<String, Image>();
	
	private String seriesInstanceUID;
	private int seriesNumber;
	private Date seriesBegin;
	
	
	public Collection<Image> getImages()
	{
		return images.values();
	}
	
	public Image add(Image image)
	{
		Image existing = images.get(image.getSopInstanceUID());
		if (existing == null)
		{
			existing = image;
			images.put(image.getSopInstanceUID(), existing);
		}
		return existing;
	}

	public String getSeriesInstanceUID()
	{
		return seriesInstanceUID;
	}

	public void setSeriesInstanceUID(String seriesInstanceUID)
	{
		this.seriesInstanceUID = seriesInstanceUID;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("UID:\t\t").append(seriesInstanceUID);
		str.append("\nSeries Number:\t").append(seriesNumber);
		str.append("\nSeries Begin:\t").append(DATE_FORMAT.format(seriesBegin));
		str.append("\nNr. of Images:\t").append(images.size());
		
		return str.toString();
	}

	public int getSeriesNumber()
	{
		return seriesNumber;
	}

	public void setSeriesNumber(int seriesNumber)
	{
		this.seriesNumber = seriesNumber;
	}

	public Date getSeriesBegin()
	{
		return seriesBegin;
	}

	public void setSeriesBegin(Date seriesBegin)
	{
		this.seriesBegin = seriesBegin;
	}

	@Override
	public int compareTo(Series ser2)
	{
		return this.seriesNumber - ser2.seriesNumber;
	}
	
	

}
