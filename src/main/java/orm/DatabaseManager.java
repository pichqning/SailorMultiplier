package orm;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import program.PropertyManager;
import program.User;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseManager {

    private static DatabaseManager instance;

    private ConnectionSource connection;

    private UserDAO userDAO;

    public DatabaseManager() {
        PropertyManager propertyManager = null;
        try {
            propertyManager = PropertyManager.getInstance();
        } catch (IOException e) {

        }
        String url = propertyManager.getProperty("jdbc.url");

        try {
            connection = new JdbcConnectionSource(url);
            System.out.println("Connection to SQLite has been established.");

            System.out.println(connection.getDatabaseType());

        } catch (SQLException se){
            System.out.println("Cannot connect to database");
            System.out.println(se.getMessage());
        }
    }

    public static DatabaseManager getInstance(){
        if(instance == null) instance = new DatabaseManager();
        return instance;
    }

//    public UserDAO getUserDao() {
//        if(userDAO == null) {
//            try {
//                userDAO = new UserDAO(connection);
//            } catch (SQLException se){
//                System.out.println("Cannot connect to ItemDao.");
//            }
//        }
//        return userDAO;
//    }
//                TableUtils.createTable(connection, User.class);
//            User u1 = new User("test1", "pink");
//            userDAO = new UserDAO(connection);
//            userDAO.create(u1);
}
