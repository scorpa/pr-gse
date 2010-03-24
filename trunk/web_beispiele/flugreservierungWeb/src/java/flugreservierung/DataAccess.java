package flugreservierung;

import java.util.List;

public interface DataAccess {
    public List<Flug> findeFluege() throws FlugReservierungsException;
    public void speichern(Reservierung r) throws FlugReservierungsException;
    public void close() throws FlugReservierungsException;
}
