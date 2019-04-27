package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import orm.DatabaseManager;
import orm.UserDAO;
import program.ChangePageManager;
import program.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main extends Application {

    private static DatabaseManager db;
    private static UserDAO userDAO;

    private double x,y;

    public static void main(String[] args) throws IOException, SQLException {
//        PropertyManager propertyManager = PropertyManager.getInstance();
//        System.out.println("Test username: " + propertyManager.getProperty("jdbc.user"));
//
//        db = DatabaseManager.getInstance();
//        userDAO = db.getUserDao();
//
//        List<User> users = userDAO.getColumnList("username");
//        for(User u: users) {
//            System.out.println(u);
//        }

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
