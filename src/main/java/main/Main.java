package main;

import javafx.application.Application;
import javafx.stage.Stage;
import orm.DatabaseManager;
import orm.HighscoreDAO;
import orm.UserDAO;
import program.ChangePageManager;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    private static DatabaseManager db;
    private static UserDAO userDAO;
    private static HighscoreDAO highscoreDAO;

    private double x,y;

    public static void main(String[] args) throws IOException, SQLException {
//        PropertyManager propertyManager = PropertyManager.getInstance();
//        System.out.println("Test username: " + propertyManager.getProperty("jdbc.user"));
//


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            ChangePageManager.changePage(Main.class, primaryStage, "/UI/LoginUI.fxml", "Login");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
