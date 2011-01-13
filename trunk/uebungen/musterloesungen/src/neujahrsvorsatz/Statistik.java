package neujahrsvorsatz;

public class Statistik
{
    private java.util.ArrayList<Tagesaufzeichnung> tagesaufzeichnungen;

    public Statistik()
    {
       tagesaufzeichnungen = new java.util.ArrayList<Tagesaufzeichnung>();
       
       eintragHinzufuegen(1,1,1000,8.5);
       eintragHinzufuegen(1,1,2500,5.3);
       eintragHinzufuegen(3,3,2300,6.7);
       
       System.out.println("Tage ohne Training: " + anzahlTageOhneTraining());
       System.out.println("Durchschnittskilometer: " + getKiometerDurchschnitt());
    }

    public boolean existiertEintrag(int tag, int monat)
    {
        for (Tagesaufzeichnung t : tagesaufzeichnungen)
            if (t.getTag() == tag && t.getMonat() == monat) return true;
            
        return false;
    }
    
    public void eintragLoeschen(int tag, int monat)
    {
        if (existiertEintrag(tag, monat))
        {
            Tagesaufzeichnung o = null;
            for (Tagesaufzeichnung t : tagesaufzeichnungen)
                if (t.getTag() == tag && t.getMonat() == monat) o = t;
            
            if (o != null) tagesaufzeichnungen.remove(o);
        }
        else
        {
            System.out.println("Dieser Eintrag ist nicht vorhanden.");
        }
    }
    
    public void eintragHinzufuegen(int tag, int monat, double kalorien, double kilometer)
    {
        if (existiertEintrag(tag, monat))
            eintragLoeschen(tag, monat);
        
        tagesaufzeichnungen.add(new Tagesaufzeichnung(tag, monat, kalorien, kilometer));   
    }
    
    public void eintraegeAusgeben()
    {
        for (Tagesaufzeichnung t : tagesaufzeichnungen)
            System.out.println(t.getTag()+"."+t.getMonat()+".: " + t.getKalorienanzahl() + " Kalorien, " + t.getGelaufeneKilometer() + " Kilometer.");   
    }
    
    public double getKalorienDurchschnitt()
    {
        if (tagesaufzeichnungen.size() == 0)
        {
            return 0;
        }
        else 
        {
            double d = 0;
            for (Tagesaufzeichnung t : tagesaufzeichnungen)
                d += t.getKalorienanzahl();   
            return d / tagesaufzeichnungen.size();
        }
    }
    
    public Tagesaufzeichnung getKalorienMinimum()
    {
        Tagesaufzeichnung retVal = null;
        for (Tagesaufzeichnung t : tagesaufzeichnungen)
            if (t == null || t.getKalorienanzahl() > retVal.getKalorienanzahl())
                retVal = t;
        return retVal;
    }
    
    public Tagesaufzeichnung getKalorienMaximum()
    {
        Tagesaufzeichnung retVal = null;
        for (Tagesaufzeichnung t : tagesaufzeichnungen)
            if (t == null || t.getKalorienanzahl() < retVal.getKalorienanzahl())
                retVal = t;
        return retVal;
    }
    
    public int anzahlTageOhneTraining()
    {
        if (tagesaufzeichnungen.size() == 0)
            return 0;
        else
            {
            Tagesaufzeichnung t1 = tagesaufzeichnungMitFruehestemDatum();
            Tagesaufzeichnung t2 = tagesaufzeichnungMitSpaetestemDatum();
            return tageDifferenz(t1.getTag(), t1.getMonat(), t2.getTag(), t2.getMonat()) - anzahlTageMitTraining();
        }
    }
    
    public int anzahlTageMitTraining()
    {
        int retVal = 0;
        for (Tagesaufzeichnung t : tagesaufzeichnungen)
            if (t.getGelaufeneKilometer() > 0) retVal++;
        return retVal;
    }
    
    public double getKiometerDurchschnitt()
    {
        double retVal = 0;
        for (Tagesaufzeichnung t : tagesaufzeichnungen)
            retVal += t.getGelaufeneKilometer();
        return retVal / (anzahlTageMitTraining() + anzahlTageOhneTraining());
    }
    
    public Tagesaufzeichnung tagesaufzeichnungMitFruehestemDatum()
    {
        Tagesaufzeichnung retVal = null;
        for (Tagesaufzeichnung t : tagesaufzeichnungen)
            if (retVal == null || istFrueher(t.getTag(), t.getMonat(), retVal.getTag(), retVal.getMonat()))
                retVal = t;
        return retVal;
    }
    
    public Tagesaufzeichnung tagesaufzeichnungMitSpaetestemDatum()
    {
        Tagesaufzeichnung retVal = null;
        for (Tagesaufzeichnung t : tagesaufzeichnungen)
            if (retVal == null || !istFrueher(t.getTag(), t.getMonat(), retVal.getTag(), retVal.getMonat()))
                retVal = t;
        return retVal;
    }
    
    private boolean istFrueher(int tag1, int monat1, int tag2, int monat2)
    {
        if (monat1 < monat2) {
            return true;
        } else if (monat1 > monat2) {
            return false;
        } else {
            if (tag1 < tag2)
                return true;
            else
                return false;
        }
    }
    
    private int tageDifferenz(int tag1, int monat1, int tag2, int monat2)
    {
        if (istFrueher(tag2, monat2, tag1, monat1))
        {
            int temp1 = tag1;
            int temp2 = monat1;
            tag1 = tag2;
            monat1 = monat2;
            tag2 = temp1;
            monat2 = temp2;
        }
        
        if (monat1 == monat2)
            return tag2 - tag1 +1;
        else
        {
            int retVal = tag2;
            for (int i=monat1; i<monat2; i++)
            {
                if (i==1) retVal+= 31;
                if (i==2) retVal+= 28;
                if (i==3) retVal+= 31;
                if (i==4) retVal+= 30;
                if (i==5) retVal+= 31;
                if (i==6) retVal+= 30;
                if (i==7) retVal+= 31;
                if (i==8) retVal+= 31;
                if (i==9) retVal+= 30;
                if (i==10) retVal+= 31;
                if (i==11) retVal+= 30;
            }
            return retVal;
        }
    }
}
