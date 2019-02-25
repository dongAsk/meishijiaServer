package proxy;

import bean.User;
import dao.UserDao;
import daoimpl.UserDaoImpl;
import dbConnection.DBConn;

public class UserProxy implements UserDao {

    private DBConn conn = null;
    private UserDao userDaoImpl = null;

    private static UserProxy instance = new UserProxy();
    public static UserProxy getInstance(){
        return instance;
    }

    public UserProxy() {
        this.conn = new DBConn();
        this.userDaoImpl = new UserDaoImpl(this.conn.getConnection());
    }

    @Override
    public int adduser(User user) throws Exception {
        int result = 0;
        result = userDaoImpl.adduser(user);
        return result;
    }

    @Override
    public int editInfo(int uid, String username, String email) throws Exception {
        int result = 0;
        result = userDaoImpl.editInfo(uid, username, email);
        return result;
    }

    @Override
    public int editPassword(int uid, String password) throws Exception {
        int result = 0;
        result = userDaoImpl.editPassword(uid,password);
        return result;
    }

    @Override
    public User queryByName(String username) throws Exception {
        User user;
        user = userDaoImpl.queryByName(username);
        return user;
    }

    @Override
    public int queryUid(String username) throws Exception {
        int result = -1;
        result = userDaoImpl.queryUid(username);
        return result;
    }

    @Override
    public User queryByEmail(String emial) throws Exception {
        User user;
        user = userDaoImpl.queryByEmail(emial);
        return user;
    }
}
