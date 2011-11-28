package flugres;


import flugres.fachlogik.Flug;
import flugres.fachlogik.FlugReservierungsDAO;
import flugres.fachlogik.Reservierung;
import flugres.fachlogik.ReservierungsException;
import flugres.persistenz.DBFlugReservierungsDAO;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Rudi
 */
public class Test
{
    public static void main(String[] args)
    {
        FlugReservierungsDAO dao = new DBFlugReservierungsDAO();
        
        try
        {
            Flug f = new Flug();
            f.setVon("Wien");
            f.setNach("London");
            f.setTag(new Date());
            Reservierung r = new Reservierung();
            r.setName("Huber");
            f.neueReservierung(r);
            
            dao.speichern(f);
            
            
            
            for (Flug f1 : dao.finden(new Date()))
            {
                System.out.println(f1);
                for (Reservierung r1 : f1.getReservierungen())
                    System.out.println(r1);
                Reservierung r2 = new Reservierung();
                r2.setName("Meier");
                f1.neueReservierung(r2);
                dao.speichern(f1);
                
            }
            
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            dao.close();
        }
        
        
        
        
    }
}
