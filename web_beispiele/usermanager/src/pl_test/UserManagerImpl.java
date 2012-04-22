package pl_test;

import bl.User;
import bl.UserManager;
import bl.UserManagerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rudolf Radlbauer
 */
public class UserManagerImpl implements UserManager
{
    private Map<Integer, User> userMap = new HashMap<Integer, User>();
    
    public UserManagerImpl() throws UserManagerException
    {
        User admin = new User();
        admin.setId(0);
        admin.setName("Administrator");
        admin.setUname("admin");
        admin.setPwd("admin");
        admin.setAdmin(true);
        save(admin);

        User guest = new User();
        guest.setId(0);
        guest.setName("Guest");
        guest.setUname("guest");
        guest.setPwd("guest");
        guest.setAdmin(false);
        save(guest);
    }
    

    @Override
    public User login(String uname, String pwd) throws UserManagerException
    {
        for (User u : userMap.values())
        {
            if (uname.equals(u.getUname()) && pwd.equals(u.getPwd()))
                return u;
        }
        return null;
    }

    @Override
    public List<User> getUsers() throws UserManagerException
    {
        return new ArrayList<User>(userMap.values());
    }

    @Override
    public void save(User u) throws UserManagerException
    {
    	int max = 0;
		for (User u1 : userMap.values())
		{
			if (u != u1 && u1.getUname().equals(u.getUname()))
				throw new UserManagerException("a user with this user name already exists");
			if (max < u1.getId())
				max = u1.getId();
		}
		
    	User original = userMap.get(u.getId());
    	if (original != null)
    	{
    		original.setName(u.getName());
    		original.setUname(u.getUname());
    		original.setAdmin(u.isAdmin());
    		original.setPwd(u.getPwd());
    	}
    	else
    	{
    		u.setId(max+1);
    		userMap.put(u.getId(), u);
    	}
    }

    @Override
    public void close() throws UserManagerException
    {
        // nothing to do
    }

    @Override
    public User find(int id) throws UserManagerException
    {
        return userMap.get(id);
    }

}
