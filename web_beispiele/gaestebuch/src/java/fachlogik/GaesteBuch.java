package fachlogik;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Rudolf Radlbauer
 */
public interface GaesteBuch
{
    public void neu(Eintrag e) throws GaesteBuchException;
    public List<Eintrag> liste() throws GaesteBuchException;
    public List<Eintrag> liste(String ersteller) throws GaesteBuchException;
    public void close();

}
