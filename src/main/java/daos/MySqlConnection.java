package daos;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import models.Car;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    public static final String URL = "jdbc:mysql://localhost:3306/Cars";
    public static final String USER = "fmintar1";
    public static final String PASS = "password";

    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            System.out.println("Connection successful");
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
    /**
     * Test Connection
     */
    public static void main(String[] args) {
        DaoC daoc = new DaoC();
        System.out.println(daoc.findById(1).getModel());
    }
}
