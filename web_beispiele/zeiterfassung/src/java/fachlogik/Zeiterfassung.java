
package fachlogik;

import java.util.List;

/**
 *
 * @author Rudolf Radlbauer
 */
public interface Zeiterfassung
{

    // Frontend
    public boolean login(Mitarbeiter m) throws ZeiterfassungException;
    public List<ZeitStempel> aktuelleZeiten(Mitarbeiter m) throws ZeiterfassungException;
    public float zeitSaldo(Mitarbeiter m) throws ZeiterfassungException;
    public ZeitStempel letzterEintrag(Mitarbeiter m) throws ZeiterfassungException;
    public void eintrag(ZeitStempel z, Mitarbeiter m) throws ZeiterfassungException;

    // Backend
    public void speichern(Mitarbeiter m) throws ZeiterfassungException;
    public List<Mitarbeiter> mitarbeiterListe() throws ZeiterfassungException;

    // aufräumen
    public void close() throws ZeiterfassungException;
}
