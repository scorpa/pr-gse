/*
 * Created on 19.12.2005
 *
 */
package bank.fachlogik;


import java.io.Serializable;
import java.util.Observable;

/**
 * Konto-Objekte repräsentieren jeweils ein Konto.
 * 
 * @author Rudolf Radlbauer
 */
public class Konto extends Observable implements Serializable
{
	public static final long serialVersionUID = -8956646994496744856L;
	
	private int nummer;
    private double saldo;
    private String besitzer;
    private double limit;  // Überziehungsrahmen (positiver Wert)

    /**
     * erzeugt ein neues Konto-Objekt und vergibt eine Nummer von der
     * KontoVerwaltung
     * 
     * @throws KontoVerwaltungException
     *             bei Fehlern in der KontoVerwaltung
     * @throws IllegalStateException
     *             falls keine KontoVerwaltung verfügbar ist
     */
    public Konto(KontoVerwaltung verwaltung) throws KontoVerwaltungException, IllegalStateException
    {
        if (verwaltung == null)
            throw new IllegalStateException("keine KontoVerwaltung verfügbar");
        nummer = verwaltung.erzeugeNummer();
    }

    /**
     * Konstruktor für Konto-Objekt, welches aus der Datenbank gelesen wird.
     * 
     * @param nummer
     * @param saldo
     */
    public Konto(int nummer, double saldo)
    {
        this.nummer = nummer;
        this.saldo = saldo;
    }

    /**
     * erzeugt ein neues Konto-Objekt mit besitzer laut Parameter und vergibt
     * eine Nummer von der KontoVerwaltung
     * 
     * @param besitzer
     *            Besitzer des Kontos
     * @throws KontoVerwaltungException
     *             bei Fehlern in der KontoVerwaltung
     * @throws IllegalStateException
     *             falls keine KontoVerwaltung verfügbar ist
     * @throws IllegalArgumentException
     *             wenn ungültiger Besitzer-Name übergeben wird
     */
    public Konto(KontoVerwaltung verwaltung, String besitzer) throws KontoVerwaltungException,
            IllegalStateException, IllegalArgumentException
    {
        this(verwaltung);
        setBesitzer(besitzer);
        setLimit(0); // default: Konto darf nicht überzogen werden
    }

    /**
     * Betrag wird auf das Konto eingezahlt
     * 
     * @param betrag
     *            eingezahlter Betrag
     */
    public void einzahlen(double betrag)
    {
        saldo += betrag;
        setChanged();
        notifyObservers();
    }

    /**
     * Betrag wird vom Konto abgehoben
     * 
     * @param betrag
     *            abzuhebender Betrag
     * @throws UeberweisungException
     *             wenn der Überziehungsrahmen gesprengt wird
     */
    public void abheben(double betrag) throws UeberweisungException
    {
        if (saldo - betrag >= -limit)
        {
            saldo -= betrag;
            setChanged();
            notifyObservers();
        } else
            throw new UeberweisungException(
                    "Überziehungsrahmen nicht eingehalten: " + limit);
    }

    /**
     * liefert String mit allen Attributen des Kontos
     * 
     * @return String mit allen Attributen des Kontos
     */
    public String toString()
    {
        return "Nummer: " + nummer + "\tBesitzer: " + besitzer
                + "\tKontostand: " + saldo + "\tLimit: " + limit;
    }

    /**
     * @return Name des Konto-Besitzers
     * @uml.property name="besitzer"
     */
    public String getBesitzer()
    {
        return besitzer;
    }

    /**
     * @param besitzer
     *            Name des Konto-Besitzers
     * @throws IllegalArgumentException
     *             wenn ungültiger Besitzer-Name übergeben wird
     * @uml.property name="besitzer"
     */
    public void setBesitzer(String besitzer) throws IllegalArgumentException
    {
        if (besitzer != null && besitzer.trim().length() > 0)
        {
            if (!besitzer.equals(this.besitzer))
            {
                this.besitzer = besitzer;
                setChanged();
                notifyObservers();
            }
        } else
            throw new IllegalArgumentException("Besitzer-Name ist leer");
    }

    /**
     * gibt den Überziehungsrahmen zurück <br/> z.B.: -1000 bedeutet, dass das
     * Konto bis 1000 im Minus sein darf
     * 
     * @return Überziehungsrahmen
     * @uml.property name="limit"
     */
    public double getLimit()
    {
        return limit;
    }

    /**
     * @param limit
     *            Überziehungsrahmen
     * @throws IllegalArgumentException
     *             wenn positiver Wert übergeben wird
     * @uml.property name="limit"
     */
    public void setLimit(double limit)
    {
        if (limit >= 0)
        {
            if (limit != this.limit)
            {
                this.limit = limit;
                setChanged();
                notifyObservers();
            }
        } else
            throw new IllegalArgumentException(
                    "Überziehungsrahmen muss positiv oder 0 sein");
    }

    /**
     * @return Kontostand
     * @uml.property name="saldo"
     */
    public double getSaldo()
    {
        return saldo;
    }

    /**
     * liefert die Kontonummer
     * 
     * @return Kontonummer
     * @uml.property name="nummer"
     */
    public int getNummer()
    {
        return nummer;
    }

    /**
     * @param saldo The saldo to set.
     */
    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

}
