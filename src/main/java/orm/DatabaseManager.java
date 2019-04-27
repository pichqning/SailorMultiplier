package orm;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import program.Highscore;
import program.PropertyManager;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseManager {

    private static DatabaseManager instance;

    private ConnectionSource connection;

    private UserDAO userDAO;

    private HighscoreDAO highscoreDAO;

    public DatabaseManager() {
        PropertyManager propertyManager = null;
        try {
            propertyManager = PropertyManager.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
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

    public UserDAO getUserDao() {
        if(userDAO == null) {
            try {
                userDAO = new UserDAO(connection);
            } catch (SQLException se){
                System.out.println("Cannot connect to UserDao.");
            }
        }
        return userDAO;
    }

    public HighscoreDAO getHighscoreDAO() {
        if(highscoreDAO == null) {
            try {
                highscoreDAO = new HighscoreDAO(connection);
            } catch (SQLException se) {
                System.out.println("Cannot connect to HighscoreDao.");
            }
        }
        return highscoreDAO;
    }

}
