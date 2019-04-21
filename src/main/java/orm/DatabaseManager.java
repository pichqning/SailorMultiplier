package orm;

import program.PropertyManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static DatabaseManager instance;

    private Connection connection;

    public DatabaseManager() {
        PropertyManager propertyManager = null;
        try {
            propertyManager = PropertyManager.getInstance();
        } catch (IOException e) {

        }
        String username = propertyManager.getProperty("jdbc.user");
        String password = propertyManager.getProperty("jdbc.password");
        String url = propertyManager.getProperty("jdbc.url");

        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException se){
            System.out.println("Cannot connect to database");
            System.out.println(se.getMessage());
        }
    }
}
