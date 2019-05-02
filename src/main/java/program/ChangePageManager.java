package program;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Main;

import java.io.IOException;
import java.net.URL;

public class ChangePageManager {


    public static void setUI(Class c, String path) {
        try{
            Parent root = (Parent) FXMLLoader.load(c.getClass().getResource(path));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("css/style.css");
            Font.loadFont(c.getClass().getResource("/font/ElsieSwashCaps.ttf").toExternalForm(), 10);
            Main.getStage().setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeUI(String fxmlPath, Pane pane) {
        try {
            URL url = ChangePageManager.class.getClassLoader().getResource(fxmlPath);
            AnchorPane anotherPane = (AnchorPane) FXMLLoader.load(url);
            pane.getChildren().setAll(anotherPane);
        }catch (IOException | NullPointerException e){
            e.printStackTrace();
        }
    }




}
