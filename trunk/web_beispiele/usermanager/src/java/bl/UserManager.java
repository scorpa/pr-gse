package bl;

import java.util.List;

/**
 *
 * @author Rudolf Radlbauer
 */
public interface UserManager
{
    public User login(String uname, String pwd) throws UserManagerException;
    public List<User> getUsers() throws UserManagerException;
    public User find(int id) throws UserManagerException;
    public void save(User u) throws UserManagerException;
    public void close() throws UserManagerException;
}
