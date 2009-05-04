/*
 * Created on 04.05.2009
 * noch nicht fertig
 */
package memory;

import java.net.URL;

import javax.swing.ImageIcon;

public class Feld
{
    private int status;  // 0: origina, 1: aufgedeckt, 2: erraten
    private ImageIcon icon;
    
    public Feld(String bild) throws MemoryException
    {
        URL url = getClass().getResource(bild);
        if (url != null)
            icon = new ImageIcon(url);
        else
            throw new MemoryException("kann Bild nicht laden: " + bild);
    }
    
    public int getStatus()
    {
        return status;
    }
    public void setStatus(int status)
    {
        this.status = status;
    }
    public ImageIcon getIcon()
    {
        return icon;
    }
    
    
}
