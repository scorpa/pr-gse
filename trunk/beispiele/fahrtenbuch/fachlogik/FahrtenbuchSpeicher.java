/*
 * Created on 09.04.2009
 *
 */
package fahrtenbuch.fachlogik;

public interface FahrtenbuchSpeicher
{
    public Fahrtenbuch getFahrtenbuch();
    public void speichern() throws FahrtenbuchException;

}
