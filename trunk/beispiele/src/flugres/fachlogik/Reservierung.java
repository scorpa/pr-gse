package flugres.fachlogik;

import java.util.Date;

public class Reservierung
{
    // Schattendaten
    private int nr;
    private Date letztesUpdate;
    private boolean changed;  // Flag, ob etwas gespeichert werden muss

    private String name;


    
    public Reservierung()
    {
        changed = true;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if (this.name == null || !this.name.equals(name))
        {
            this.name = name;
            changed = true;
        }
    }

    public int getNr()
    {
        return nr;
    }

    public void setNr(int nr)
    {
        if (this.nr != nr)
        {
            this.nr = nr;
            changed = true;
        }
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
        return "Reservierung{" + "nr=" + nr + ", name=" + name + ", letztesUpdate=" + letztesUpdate + '}';
    }
    
    
}
