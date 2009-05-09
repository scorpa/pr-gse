/*
 * Created on 04.05.2009
 * noch nicht fertig
 */
package memory;

import javax.swing.ImageIcon;

public interface Memory
{
    public int getZeilen();
    
    public int getSpalten();
    
    public boolean tipp(int zeile, int spalte);
    
    public int getStatus(int zeile, int spalte);
    
    public ImageIcon getBild(int zeile, int spalte);
    
    public boolean fertig();
    
    public int tipps();
}
