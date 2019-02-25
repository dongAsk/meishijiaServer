import dao.UserDao;
import dbConnection.DBConn;
import factory.DaoFactory;

public class Main {
    public static void main(String[] args) {
        DBConn dbConn = new DBConn();
        try {
            UserDao userDao = DaoFactory.getUserDAOInstance();
            int uid = userDao.queryUid("admin");
            System.out.println(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
