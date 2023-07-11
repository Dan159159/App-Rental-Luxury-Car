package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiondb {
    private Connection conn;
    //private String url = "jdbc:mysql://192.168.1.152:3306/donostiluxdrive";
    private String url = "jdbc:mysql://localhost/donostiluxdrive";

    private String user = "root";

    private String password = "";

    public void setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public java.sql.Connection getConnection() {
        return conn;
    }
}
