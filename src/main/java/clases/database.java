package clases;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connectDb(){
        try{
            //Connection connect = DriverManager.setConnection("jdbc:mysql://192.168.1.152:3306/donostiluxdrive", "root", "");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/donostiluxdrive", "root", "");
            return connect;
        }catch(Exception e){
            System.out.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
