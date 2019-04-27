package main.java.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import orm.DatabaseManager;
import orm.UserDAO;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    private static DatabaseManager db;
    private static UserDAO userDAO;

    private double x,y;

    public static void main(String[] args) throws IOException, SQLException {
//        PropertyManager propertyManager = PropertyManager.getInstance();
//        System.out.println("Test username: " + propertyManager.getProperty("jdbc.user"));
//
//        db = DatabaseManager.getInstance();

        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("UI/CreateUserUI.fxml"));

            Scene scene = new Scene(root);

//            root.setOnMousePressed(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    x = event.getSceneX();
//                    y = event.getSceneY();
//                }
//            });
//
//            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    primaryStage.setX(event.getSceneX() - x);
//                    primaryStage.setY(event.getSceneY() - y);
//                }
//            });

            primaryStage.setTitle("Create Test");
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
