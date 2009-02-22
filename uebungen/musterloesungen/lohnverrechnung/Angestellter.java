/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;

public class Angestellter extends Mitarbeiter
{
    private int gehaltsStufe;
    
    private final static double BASISGEHALT = 1500;
    private final static double GEHALTSSPRUNG = 1.1;  // +10%
    private final static double JAHRESSTEIGERUNG = 30;
    
    public Angestellter(int nr)
    {
        super(nr);
        gehaltsStufe = 1;
    }

    public int getGehaltsStufe()
    {
        return gehaltsStufe;
    }

    public void setGehaltsStufe(int gehaltsStufe)
    {
        if (gehaltsStufe >= 1 && gehaltsStufe <= 5)
            this.gehaltsStufe = gehaltsStufe;
        else
            System.out.println("ungültige Gehaltsstufe");
    }

    @Override
    public void einlesen()
    {
        super.einlesen();
        int stufe;
        do
        {
            stufe = Input.readInt("Gehaltsstufe: ");
            setGehaltsStufe(stufe);
        } while (stufe != gehaltsStufe);  // wurde bei set-Methode übernommen?
    }

    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Gehaltsstufe:\t" + gehaltsStufe);
    }

    @Override
    public double berechneLohn()
    {
        double gehalt = BASISGEHALT;
        gehalt *= Math.pow(GEHALTSSPRUNG, gehaltsStufe-1);
        gehalt += (aktuellesJahr()- getEintritt()) * JAHRESSTEIGERUNG;
        return gehalt;
    }

    
    

}
