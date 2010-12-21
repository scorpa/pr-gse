package theater;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            Date datum = new SimpleDateFormat("d.M.y").parse("20.3.2010");
            ReservierungsTool tool = new ReservierungsToolImpl();
            List<Vorstellung> vorstellungen = tool.vorstellungsListe(datum);

            for (Vorstellung v : vorstellungen)
                System.out.println(v);

            Reservierung r = new Reservierung(vorstellungen.get(0));
            r.setSitzplatz(5);
            r.setName("Meier");
            if(tool.speichern(r))
                System.out.println("Reservierung gespeichert: " + r);
            else
                System.out.println("Sitzplatz schon vergeben");

            List<Reservierung> reservierungen = tool.reservierungsListe(vorstellungen.get(0));
            for (Reservierung r1 : reservierungen)
                System.out.println(r1);

            System.out.println(tool.freiePlaetze(vorstellungen.get(0)) + " freie Plätze");

        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
