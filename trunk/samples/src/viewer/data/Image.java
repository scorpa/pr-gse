package viewer.data;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Image implements Comparable<Image>
{
	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy / HH:mm:ss");
	private String sopInstanceUID;
	private File file;
	private int imageNumber;
	private int rows;
	private int columns;
	private Date acquisitionTime;

	public String getSopInstanceUID()
	{
		return sopInstanceUID;
	}

	public void setSopInstanceUID(String sopInstanceUID)
	{
		this.sopInstanceUID = sopInstanceUID;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("UID:\t\t").append(sopInstanceUID);
		str.append("\nImage Number:\t").append(imageNumber);
		if (acquisitionTime != null)
			str.append("\nAcquisition Time:\t").append(DATE_FORMAT.format(acquisitionTime));
		str.append("\nrows / columns:\t").append(rows).append(" / ").append(columns);
		return str.toString();
	}

	public File getFile()
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public int getImageNumber()
	{
		return imageNumber;
	}

	public void setImageNumber(int imageNumber)
	{
		this.imageNumber = imageNumber;
	}

	public int getRows()
	{
		return rows;
	}

	public void setRows(int rows)
	{
		this.rows = rows;
	}

	public int getColumns()
	{
		return columns;
	}

	public void setColumns(int columns)
	{
		this.columns = columns;
	}

	public Date getAcquisitionTime()
	{
		return acquisitionTime;
	}

	public void setAcquisitionTime(Date acquisitionTime)
	{
		this.acquisitionTime = acquisitionTime;
	}

	@Override
	public int compareTo(Image img2)
	{
		return this.imageNumber - img2.imageNumber;
	}
	
	

}
