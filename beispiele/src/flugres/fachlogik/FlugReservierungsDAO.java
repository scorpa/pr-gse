package flugres.fachlogik;

import java.util.Date;
import java.util.List;

public interface FlugReservierungsDAO
{
    public void speichern(Flug f) throws ReservierungsException;
    public List<Flug> finden(Date tag) throws ReservierungsException;
    public Flug finden(int id) throws ReservierungsException;
    public List<Reservierung> finden(Flug f) throws ReservierungsException;
    public void speichern(Reservierung r, Flug f) throws ReservierungsException;
    public void close();
}
