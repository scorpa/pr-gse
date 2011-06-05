/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fachlogik;

import java.util.Random;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Hangman
{
    private final static String[] WORTE = {
        "PROGRAMMIEREN", "APPLIKATION", "AUFGABE"
    };
    private String wort;
    private StringBuilder anzeige;
    private Random rnd = new Random();
    private int fehlVersuche;


    public Hangman()
    {
        neuesWort();
    }

    public String getAnzeige()
    {
        StringBuilder abstand = new StringBuilder(anzeige);
        for (int i = 0; i < abstand.length(); i = i + 2)
            abstand.insert(i, ' ');
        return abstand.toString();
    }

    public boolean raten(char buchstabe)
    {
        char gross = Character.toUpperCase(buchstabe);
        boolean gefunden = false;
        int index = -1;
        do
        {
            index = wort.indexOf(gross, index+1);
            if (index >= 0)
            {
                anzeige.setCharAt(index, gross);
                gefunden = true;
            }
        } while(index >= 0);
        if (!gefunden) fehlVersuche++;
        return gefunden;
    }

    public boolean isFertig()
    {
        return anzeige.indexOf("_") < 0;
    }

    public int getFehlVersuche()
    {
        return fehlVersuche;
    }

    public void neuesWort()
    {
        fehlVersuche = 0;
        wort = WORTE[rnd.nextInt(WORTE.length)];
        anzeige = new StringBuilder();
        for (int i = 0; i < wort.length(); i++)
            anzeige.append(("_"));
    }

}
