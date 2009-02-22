/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;

public class Vertreter extends Mitarbeiter
{
    private final static double UMSATZBETEILIGUNG = 0.03;
    
    private double grundgehalt;
    private double umsatz;

    public Vertreter(int nr)
    {
        super(nr);
    }

    public double getGrundgehalt()
    {
        return grundgehalt;
    }

    public void setGrundgehalt(double grundgehalt)
    {
        if (grundgehalt > 0)
            this.grundgehalt = grundgehalt;
        else
            System.out.println("ungültiges Grundgehalt");
    }

    public double getUmsatz()
    {
        return umsatz;
    }

    public void setUmsatz(double umsatz)
    {
        if (umsatz > 0)
            this.umsatz = umsatz;
        else
            System.out.println("ungültiger Umsatz");
    }

    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Grundgehalt:\t" + grundgehalt);
        System.out.println("Umsatz:\t" + umsatz);
    }

    @Override
    public double berechneLohn()
    {
        return grundgehalt + umsatz * UMSATZBETEILIGUNG;
    }

    @Override
    public void einlesen()
    {
        super.einlesen();
        double grundgehalt;
        double umsatz;
        do
        {
            grundgehalt = Input.readDouble("Grundgehalt: ");
            setGrundgehalt(grundgehalt);
        } while (this.grundgehalt != grundgehalt); // bei set-Methode übernommen?
        
        do
        {
            umsatz = Input.readDouble("Umsatz: ");
            setUmsatz(umsatz);
        } while (this.umsatz != umsatz); // bei set-Methode übernommen?
        
    }
    
    

}
