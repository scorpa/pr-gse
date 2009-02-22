/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;

public class Arbeiter extends Mitarbeiter
{
    private final static double BASISLOHN = 40;
    private final static double JAHRESSTEIGERUNG = 1.03; // +3%
    
    private int stunden;

    public Arbeiter(int nr)
    {
        super(nr);
    }

    public int getStunden()
    {
        return stunden;
    }

    public void setStunden(int stunden)
    {
        if (stunden >= 0)
            this.stunden = stunden;
        else
            System.out.println("ungültige Stundenanzahl");
    }

    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Aktuelle Stunden:\t" + stunden);
    }

    @Override
    public double berechneLohn()
    {
        double lohn = stunden * BASISLOHN;
        lohn *= Math.pow(JAHRESSTEIGERUNG, aktuellesJahr() - getEintritt());
        return lohn;
    }

    @Override
    public void einlesen()
    {
        super.einlesen();
        int stunden;
        do
        {
            stunden = Input.readInt("aktuelle Stunden: ");
            setStunden(stunden);
        } while (this.stunden != stunden);  // von set-Methode übernommen?
        
    }

    
}
