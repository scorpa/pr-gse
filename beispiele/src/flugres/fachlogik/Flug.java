package flugres.fachlogik;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flug
{
    // Schattendaten
    private int id;    // Primärschlüssel = Flugnummer
    private Date letztesUpdate;
    private boolean changed;  // Flag, ob Änderungen zu speichern sind

    private String von;
    private String nach;
    private Date tag;
    private List<Reservierung> reservierungen = new ArrayList<Reservierung>();
    
    public Flug()
    {
        changed = true; // neuer Flug muss auf jeden Fall gespeichert werden
    }
    
    public void neueReservierung(Reservierung r)
    {
        reservierungen.add(r);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        // wenn die id anders ist als die alte, ist das eine Änderung
        if (id != this.id)
        {
            this.id = id;
            changed = true;
        }        
    }

    public String getNach()
    {
        return nach;
    }

    public void setNach(String nach)
    {
        if (this.nach ==  null || !this.nach.equals(nach))
        {
            this.nach = nach;
            changed = true;
        }
    }

    public Date getTag()
    {
        return tag;
    }

    public void setTag(Date tag)
    {
        if (this.tag == null || !this.tag.equals(tag))
        {
            this.tag = tag;
            changed = true;
        }
    }

    public String getVon()
    {
        return von;
    }

    public void setVon(String von)
    {
        if (this.von == null || !this.von.equals(von))
        {
            this.von = von;
            changed = true;
        }
    }

    public List<Reservierung> getReservierungen()
    {
        return reservierungen;
    }

    public Date getLetztesUpdate()
    {
        return letztesUpdate;
    }

    public void setLetztesUpdate(Date letztesUpdate)
    {
        this.letztesUpdate = letztesUpdate;
    }

    public boolean isChanged()
    {
        return changed;
    }
    
    public void setChanged(boolean changed)
    {
        this.changed = changed;
    }

    @Override
    public String toString()
    {
        return "Flug{" + "id=" + id + ", von=" + von + ", nach=" 
                + nach + ", tag=" + tag + ", letztesUpdate=" + letztesUpdate + '}';
    }
    
    
}
