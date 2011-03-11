package fachlogik;

import java.util.Date;

/**
 *
 * @author Rudolf Radlbauer
 */
public class ZeitStempel
{
    private int id;
    private boolean kommen;
    private Date timestamp;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public boolean isKommen()
    {
        return kommen;
    }

    public void setKommen(boolean kommen)
    {
        this.kommen = kommen;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    
}
