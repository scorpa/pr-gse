
package einkaufsliste.ui;

import einkaufsliste.fachlogik.ProduktVerwaltung;
import einkaufsliste.fachlogik.ProduktVerwaltungImpl;

/**
 *
 * @author Rudi
 */
public class Start
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ProduktVerwaltung verwaltung = new ProduktVerwaltungImpl();
        ProduktVerwaltungsUI ui = new ProduktVerwaltungsUI(verwaltung);
        ui.run();
    }

}
