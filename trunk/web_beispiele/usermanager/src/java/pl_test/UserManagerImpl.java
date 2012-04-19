package pl_test;

import bl.User;
import bl.UserManager;
import bl.UserManagerException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rudolf Radlbauer
 */
public class UserManagerImpl implements UserManager
{
    private List<User> list = new ArrayList<User>();
    
    public UserManagerImpl()
    {
        User admin = new User();
        admin.setId(0);
        admin.setName("Administrator");
        admin.setUname("admin");
        admin.setPwd("admin");
        admin.setAdmin(true);
        list.add(admin);
    }
    

    @Override
    public User login(String uname, String pwd) throws UserManagerException
    {
        for (User u : list)
        {
            if (uname.equals(u.getUname()) && pwd.equals(u.getPwd()))
                return u;
        }
        return null;
    }

    @Override
    public List<User> getUsers() throws UserManagerException
    {
        return list;
    }

    @Override
    public void save(User u) throws UserManagerException
    {
        int maxid = 0;
        if (!list.contains(u))
        {
            for (User u1 : list)
            {
                if (u.getUname().equals(u1.getUname()))
                    throw new UserManagerException("there is already a user with this user name");
                if (u1.getId() > maxid)
                    maxid = u1.getId();
            }
            u.setId(maxid + 1);
            list.add(u);
        }
    }

    @Override
    public void close() throws UserManagerException
    {
        
    }

    @Override
    public User find(int id) throws UserManagerException
    {
        for (User u : list)
            if (u.getId() == id)
                return u;
        return null;
    }

}
