/*
 * Created on 21.04.2009
 *
 */
package autorennen;

public class Auto implements Comparable<Auto>
{
    private final static int DREHZAHL_GESCHWINDIGKEIT = 100;
    private final static float BESCHLEUNIGUNG = 1.5f;
    private final static int MAX_DREHZAHL = 8000;
    private final static int ANZAHL_GAENGE = 5;
    private final static int START_DREHZAHL = 2000;
    
    private String kennzeichen;
    private int drehzahl;
    private int gang;
    
    
    
    public Auto(String kennzeichen) throws AutoException
    {
        drehzahl = START_DREHZAHL;
        gang = 0;
        if (kennzeichen != null && kennzeichen.trim().length() > 0)
            this.kennzeichen = kennzeichen;
        else
            throw new AutoException("Kennzeichen darf nicht leer sein");
    }

    public int berechneGeschwindigkeit()
    {
        return drehzahl * gang / DREHZAHL_GESCHWINDIGKEIT;
    }
        
    
    public void beschleunigen() throws AutoException
    {
        if ((int)(drehzahl * BESCHLEUNIGUNG) <= MAX_DREHZAHL)
            drehzahl = (int)(drehzahl * BESCHLEUNIGUNG);
        else
        {
            drehzahl = MAX_DREHZAHL;
            throw new AutoException("Maximale Drehzahl erreicht");
        }
    }
    
    public void bremsen() throws AutoException
    {
        if ((int)(drehzahl / BESCHLEUNIGUNG) >= START_DREHZAHL)
            drehzahl = (int)(drehzahl / BESCHLEUNIGUNG);
        else
        {
            drehzahl = START_DREHZAHL;
            throw new AutoException("Minimale Drehzahl erreicht");
        }
    }
    
    public void hinaufSchalten() throws AutoException
    {
        if (gang < ANZAHL_GAENGE)
            gang++;
        else
            throw new AutoException("fahre bereits mit höchstem Gang");
    }
    
    public void hinunterSchalten() throws AutoException
    {
        if (gang > 0)
            gang--;
        else
            throw new AutoException("Gang ist bereits 0");
            
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(kennzeichen);
        str.append("\t\t").append(gang);
        str.append("\t").append(drehzahl);
        str.append("\t\t").append(berechneGeschwindigkeit());
        return str.toString();
    }

    public int compareTo(Auto o)
    {
        return o.berechneGeschwindigkeit() - this.berechneGeschwindigkeit();
    }

    public String getKennzeichen()
    {
        return kennzeichen;
    }
    
    
}
