package factory;

import dao.UserDao;
import proxy.UserProxy;

public class DaoFactory {
    public static UserDao getUserDAOInstance() throws Exception{
        return UserProxy.getInstance();
    }
}
