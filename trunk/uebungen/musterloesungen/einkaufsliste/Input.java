package einkaufsliste;
 

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hilfsklasse für Eingabe von Konsole
 * nur statische Methoden
 * @author Rudolf Radlbauer
 *
 */
public class Input
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    
    /**
     * liest eine Zeile aus der Eingabe.
     * (Die Zeile kann auch leer sein.)
     * @param prompt Eingabeaufforderung
     * @return die gelesene Zeile, null falls ein Fehler auftritt
     */
    public static String readText(String prompt)
    {
        String str = null;
        
        System.out.print(prompt);
        try
        {
            str = reader.readLine();
        } catch (IOException e)
        {
            System.err.println("Fehler: " + e.getMessage());
            str = null;
        }
        return str;
    }
    
    
    /**
     * liest einen Wahrheitswert (true oder false)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer true oder false eingibt.
     * @param prompt Eingabeaufforderung
     * @return gelesener Wahrheitswert
     */
    public static boolean readBoolean(String prompt)
    {
        boolean bool = false;
        boolean ok = false;
        while(!ok)
        {
            String line = readText(prompt);
            if ("true".equals(line.trim()))
            {
                bool = true;
                ok = true;
            }
            else if ("false".equals(line.trim()))
            {
                bool = false;
                ok = true;
            }
            else
                System.out.println("Bitte \"true\" oder \"false\" eingeben");
                
        }
        
        return bool;
    }
    
    /**
     * liest ein Zeichen (char)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer ein einzelnes Zeichen eingibt.
     * @param prompt Eingabeaufforderung
     * @return gelesenes Zeichen
     */
    public static char readChar(String prompt)
    {
        char zeichen = ' ';
        boolean ok = false;
        while(!ok)
        {
            String line = readText(prompt);
            if (line != null && line.length() == 1)
            {
                zeichen = line.charAt(0);
                ok = true;
            }
            else
                System.out.println("Bitte einzelnes Zeichen eingeben (dann ENTER)");
        }
        
        return zeichen;
    }
    
    
    
    
    /**
     * liest eine Ganzzahl (int)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer eine Zahl eingibt.
     * @param prompt Eingabeaufforderung
     * @return die gelesene Zahl
     */
    public static int readInt(String prompt)
    {
        int zahl = 0;
        boolean ok = false;
        while(!ok)
        {
            try
            {
                zahl = Integer.parseInt(readText(prompt));
                ok = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Bitte Ganzzahl eingeben");
            }
        }
        
        return zahl;
    }
    
    
    /**
     * liest eine Ganzzahl (long)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer eine Zahl eingibt.
     * @param prompt Eingabeaufforderung
     * @return die gelesene Zahl
     */
    public static long readLong(String prompt)
    {
        long zahl = 0;
        boolean ok = false;
        while(!ok)
        {
            try
            {
                zahl = Long.parseLong(readText(prompt));
                ok = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Bitte Ganzzahl eingeben");
            }
        }
        
        return zahl;
    }
    
    
    
    /**
     * liest eine Gleitkommazahl (float)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer eine Zahl eingibt.
     * @param prompt Eingabeaufforderung
     * @return die gelesene Zahl
     */
    public static float readFloat(String prompt)
    {
        float zahl = 0;
        boolean ok = false;
        while(!ok)
        {
            try
            {
                zahl = Float.parseFloat(readText(prompt));
                ok = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Bitte Dezimalzahl eingeben");
            }
        }
        
        return zahl;
    }
    
    
    /**
     * liest eine Gleitkommazahl (double)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer eine Zahl eingibt.
     * @param prompt Eingabeaufforderung
     * @return die gelesene Zahl
     */
    public static double readDouble(String prompt)
    {
        double zahl = 0;
        boolean ok = false;
        while(!ok)
        {
            try
            {
                zahl = Double.parseDouble(readText(prompt));
                ok = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Bitte Dezimalzahl eingeben");
            }
        }
        
        return zahl;
    }
    
    /**
     * nur zum Testen
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println(Input.readBoolean("boolean"));
        System.out.println(Input.readChar("char"));
        System.out.println(Input.readDouble("double"));
        System.out.println(Input.readFloat("float"));
        System.out.println(Input.readInt("int"));
        System.out.println(Input.readLong("long"));
        System.out.println(Input.readText("text"));
    }
 
}
