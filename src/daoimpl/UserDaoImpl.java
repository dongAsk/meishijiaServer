package daoimpl;

import bean.User;
import dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    private Connection conn;
    private PreparedStatement pstmt = null;

    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int adduser(User user) throws Exception {
        String sql="insert into users(username,password,email) values(?,?,?)";
        int result = 0;
        pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        pstmt.setString(3,user.getEmail());
        result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }

    @Override
    public int editInfo(int uid, String username, String email) throws Exception {
        String sql="update users set username=?,email=? where uid=?";
        int result = 0;
        pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, email);
        pstmt.setInt(3, uid);
        result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }

    @Override
    public int editPassword(int uid, String password) throws Exception {
        String sql="update users set password=? where uid=?";
        int result = 0;
        pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, password);
        pstmt.setInt(2, uid);
        result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }

    @Override
    public User queryByName(String username) throws Exception {
        String sql="select * from users where username=?";
        User user = new User();
        pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1,username);
        ResultSet resultSet= pstmt.executeQuery();
        while (resultSet.next()){
            user.setUid(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
        }
        pstmt.close();
        return user;
    }

    @Override
    public int queryUid(String username) throws Exception {
        int uid = 0;
        String sql="select uid from users where username=?";
        pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1,username);
        ResultSet resultSet= pstmt.executeQuery();
        while (resultSet.next()){
            uid = resultSet.getInt(1);
        }
        pstmt.close();
        return uid;
    }

    @Override
    public User queryByEmail(String emial) throws Exception {
        String sql="select * from users where email=?";
        User user = new User();
        pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1,emial);
        ResultSet resultSet= pstmt.executeQuery();
        while (resultSet.next()){
            user.setUid(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
        }
        pstmt.close();
        return user;
    }
}