package konto;
/**
 * Musterlösung für Aufgabe http://code.google.com/p/pr-gse/wiki/uebung_objekte_und_klassen_konto
 * 
 * @author (Rudolf Radlbauer)
 */
public class Konto
{
    private int nummer;
    private String besitzer;
    private int saldo;
    private int limit;
    private int zinssatz;

    // ------------Konstruktor--------------------------------------

    public Konto(int knr)
    {
        if (knr > 0 && (knr >= 100000 && knr <= 999999))
        {
            nummer = knr;
        } else
        {
            nummer = 111111;
        }
        besitzer = "unbekannt";
        saldo = 0;
        limit = 0;
        zinssatz = 3;
    }

    // ------------get-Methoden --------------------------------------

    public int getNummer()
    {
        return nummer;
    }

    public String getBesitzer()
    {
        return besitzer;
    }

    public int getSaldo()
    {
        return saldo;
    }

    public int getLimit()
    {
        return limit;
    }

    public int getZinssatz()
    {
        return zinssatz;
    }

    // ------------set-Methoden--------------------------------------


    public void setBesitzer(String bes)
    {
        if (bes != null && bes.length() > 0)
        {
            besitzer = bes;
        } 
    }

    public void setLimit(int lim)
    {
        if (lim <= 0)
        {
            limit = lim;
        }
    }

    public void setZinssatz(int zs)
    {
        if (zs >= 0)
        {
            zinssatz = zs;
        } 
    }

    // ------------------------- weitere Methoden -----------------------------

    public void einzahlen(int betrag)
    {
        if (betrag >= 0)
        {
            saldo = saldo + betrag;
        } 
    }

    public void auszahlen(int betrag)
    {
        if (betrag >= 0 && saldo - betrag >= limit)
        {
            saldo = saldo - betrag;
        } 
    }



    public void berechneZinsen()
    {
        saldo = saldo + saldo / 100 * zinssatz;
    }


}
