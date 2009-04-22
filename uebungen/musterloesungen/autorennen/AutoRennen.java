/*
 * Created on 21.04.2009
 *
 */
package autorennen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AutoRennen
{
    private List<Auto> autos;
    
    public AutoRennen()
    {
        autos = new ArrayList<Auto>();
    }
    
    public void add(Auto auto)
    {
        autos.add(auto);
    }

    @Override
    public String toString()
    {
        Collections.sort(autos);
        StringBuilder str = new StringBuilder("\nKennzeichen\tGang\tDrehzahl\tGeschwindigkeit");
        str.append("\n=======================================================");
        for (Auto a : autos)
            str.append("\n").append(a);
        return str.toString();
    }
    
    public void runde(int manoever)
    {
        Random random = new Random();
        for (int i = 0; i < manoever; i++)
        {
            if (autos.size() > 0)
            {
                Auto auto = autos.get(random.nextInt(autos.size()));
                try
                {
                    switch(random.nextInt(4))
                    {
                    case 0:
                        auto.beschleunigen();
                        break;
                        
                    case 1:
                        auto.bremsen();
                        break;
                        
                    case 2:
                        auto.hinaufSchalten();
                        break;
                        
                    case 3:
                        auto.hinunterSchalten();
                        break;
                    }
                }
                catch(AutoException ae)
                {
                    System.out.println("Auto " + auto.getKennzeichen() + " scheidet aus:");
                    System.out.println(ae.getMessage());
                    autos.remove(auto);
                }
            }
        }
    }
    
    
    public static void main(String[] args)
    {
        try
        {
            AutoRennen rennen = new AutoRennen();
            for (int i = 0; i < 10; i++)
                rennen.add(new Auto("Auto" + i));
            for (int i = 0; i < 10; i++)
            {
                rennen.runde(5);
                System.out.println(rennen);
            }
            
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

}
