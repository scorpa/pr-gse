/*
 * Created on 19.12.2005
 *
 */
package bank.fachlogik;

/**
 * dient zum Durchführen einer Überweisung von einem Konto auf ein anderes.
 * <br/> Die Methode durchfuehren() tätigt die eigentliche Überweisung
 * 
 * @author Rudolf Radlbauer
 */
public class Ueberweisung
{
    private KontoVerwaltung verwaltung;

    private Konto von;

    private Konto auf;

    /**
     * @uml.property name="betrag"
     */
    private double betrag;

    public Ueberweisung(KontoVerwaltung verwaltung)
    {
        this.verwaltung = verwaltung;
    }

    public void durchfuehren() throws UeberweisungException,
            KontoVerwaltungException
    {
        if (von == null || auf == null || betrag <= 0.0)
            throw new UeberweisungException("ungültige Überweisungsdaten");
        verwaltung.beginTransaktion();
        try
        {
            // absichtlich schlechte Reihenfolge, um Transaktionen
            // auszuprobieren
            auf.einzahlen(betrag);
            verwaltung.speichern(auf);
            von.abheben(betrag);
            verwaltung.speichern(von);
            verwaltung.endTransaktion();
        } catch (UeberweisungException e)
        {
            verwaltung.cancelTransaktion();
            throw e;
        }
    }

    public void setAufKontoNummer(int aufKontoNummer)
            throws IllegalArgumentException, KontoVerwaltungException
    {
        auf = verwaltung.get(aufKontoNummer);
    }

    public void setVonKontoNummer(int vonKontoNummer)
            throws IllegalArgumentException, KontoVerwaltungException
    {
        von = verwaltung.get(vonKontoNummer);
    }

    /**
     * @param betrag
     *            The betrag to set.
     * @uml.property name="betrag"
     */
    public void setBetrag(double betrag) throws IllegalArgumentException
    {
        if (betrag < 0)
            throw new IllegalArgumentException(
                    "negative Beträge für Überweisung sind nicht erlaubt");
        this.betrag = betrag;
    }

}
