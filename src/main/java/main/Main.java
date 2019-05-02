package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import orm.DatabaseManager;
import orm.HighscoreDAO;
import orm.UserDAO;
import program.ChangePageManager;

import java.io.File;

public class Main extends Application {

    private static Stage uiStage;

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return uiStage;
    }


    @Override
    public void start(Stage primaryStage) {
        uiStage = primaryStage;
        try {
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("/UI/WelcomeUI.fxml"));
            Scene scene = new Scene(root);

//            File f = new File("style.css");
//            scene.getStylesheets().clear();
//            scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

            scene.getStylesheets().add("css/style.css");
            Font.loadFont(getClass().getResourceAsStream("/font/ElsieSwashCaps.ttf"), 16);
            uiStage.setScene(scene);
            uiStage.setResizable(false);
            uiStage.setTitle("Sailor Multiplier");
            uiStage.sizeToScene();
            uiStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
