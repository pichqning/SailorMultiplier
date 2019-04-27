package program;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangePageManager {

    public static void changePage(Class c, Stage stage, String path) {
        try {
            Parent root = (Parent) FXMLLoader.load(c.getClass().getResource(path));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("css/style.css");
            stage.setScene(scene);
            stage.setTitle("Sailor Multiplier");
            stage.sizeToScene();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
