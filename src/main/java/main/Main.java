package main;

import javafx.application.Application;
import javafx.stage.Stage;
import orm.DatabaseManager;
import orm.HighscoreDAO;
import orm.UserDAO;
import program.ChangePageManager;

public class Main extends Application {

    private static DatabaseManager db;
    private static UserDAO userDAO;
    private static HighscoreDAO highscoreDAO;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            ChangePageManager.changePage(Main.class, primaryStage, "/UI/LoginUI.fxml");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
