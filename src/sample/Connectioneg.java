package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectioneg {
    public Connection connection;
    String dbName = "bismillahstore";
    String dbUserName ="root";
    String dbPassword ="";
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, dbUserName, dbPassword);
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
