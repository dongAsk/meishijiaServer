package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBURL = "jdbc:mysql://localhost:3306/meishijia?" +
            "useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
    private final String USER = "root";
    private final String PASSWORD = "123456";
    private Connection conn = null;

    public DBConn() {
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
            System.out.println("加载驱动成功!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("加载驱动失败!");
        }

    }

    public Connection getConnection() {
        return this.conn;
    }

    public void close(){
        if (this.conn != null){
            try {
                this.conn.close();
                System.out.println("数据库连接关闭");
            } catch (SQLException e) {
                System.out.println("数据库连接关闭失败");
            }
        }
    }

}
