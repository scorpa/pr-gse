package flugres.fachlogik;

public class ReservierungsException extends Exception
{

    public ReservierungsException(Throwable cause)
    {
        super(cause);
    }

    public ReservierungsException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ReservierungsException(String message)
    {
        super(message);
    }

    public ReservierungsException()
    {
    }
    
}
