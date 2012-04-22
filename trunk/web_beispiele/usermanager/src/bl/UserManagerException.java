package bl;

/**
 *
 * @author Rudolf Radlbauer
 */
public class UserManagerException extends Exception
{



    public UserManagerException(Throwable cause)
    {
        super(cause);
    }

    public UserManagerException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UserManagerException(String message)
    {
        super(message);
    }

}
