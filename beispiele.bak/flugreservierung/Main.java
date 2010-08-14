/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package flugreservierung;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rudi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            DataAccess da = new DBDataAccess();
            List<Flug> fluege = da.findeFluege();
            for (Flug f : fluege)
            {
                System.out.println(f);
            }


            da.close();
        } catch (FlugReservierungsException ex)
        {
            ex.printStackTrace();
        }
    }

}
