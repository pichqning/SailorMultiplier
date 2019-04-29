package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import orm.DatabaseManager;
import orm.HighscoreDAO;
import orm.UserDAO;
import program.ChangePageManager;


import java.sql.SQLException;

public class CreateUserController {

    @FXML
    AnchorPane createUserPane;

    @FXML
    TextField usernameInput;

    @FXML
    ComboBox selectSailor;

    @FXML
    Button submitCreateButton, backButton;

    private String sailorColor = "";
    private String username = "";

    private DatabaseManager db;
    private UserDAO userDAO;
    private HighscoreDAO highscoreDAO;
    private Stage stage;

    @FXML
    private void initialize() {
        db = DatabaseManager.getInstance();
        userDAO = db.getUserDao();
        highscoreDAO = db.getHighscoreDAO();
        addSailorToCombobox();
    }

    @FXML
    private void handleBackButton() {
        setBackAction();
    }

    public void addSailorToCombobox() {
        selectSailor.getItems().add("pink");
        selectSailor.getItems().add("blue");
        selectSailor.getItems().add("green");
        selectSailor.getItems().add("yellow");
        selectSailor.getItems().add("violet");
        selectSailor.getSelectionModel().select(0);
    }

    @FXML
    public void handleSailorSelect(ActionEvent e) {
        sailorColor = selectSailor.getValue().toString();
        if(sailorColor.equals("blue")) {
            createUserPane.setStyle("-fx-background-image: url('/images/blue_sailor.jpg')");
            submitCreateButton.setStyle("-fx-background-color: linear-gradient(to top, #145374, #5588a3)");
        }else if(sailorColor.equals("yellow")){
            createUserPane.setStyle("-fx-background-image: url('/images/yellow_sailor.jpg')");
            submitCreateButton.setStyle("-fx-background-color: linear-gradient(to top, #fdd043, #ffd98e)");
        }else if(sailorColor.equals("green")) {
            createUserPane.setStyle("-fx-background-image: url('/images/green_sailor.jpg')");
            submitCreateButton.setStyle("-fx-background-color: linear-gradient(to top, #099a97, #15cda8)");
        }else if(sailorColor.equals("violet")){
            createUserPane.setStyle("-fx-background-image: url('/images/purple_sailor.jpg')");
            submitCreateButton.setStyle("-fx-background-color: linear-gradient(to top, #8d309b, #f5c7f7)");
        }else {
            createUserPane.setStyle("-fx-background-image: url('/images/pink_sailor.jpg')");
            submitCreateButton.setStyle("-fx-background-color: linear-gradient(to top, #d61d4e, #dd5599)");
        }


    }

    @FXML
    public void handleSubmitCreateButton() throws SQLException {
        if(checkTextNotEmpty()) {
            username = usernameInput.getText().trim();
            sailorColor = selectSailor.getSelectionModel().getSelectedItem().toString();
            userDAO.createUser(username, sailorColor);
            setBackAction();
        }
    }

    public void setBackAction() {
        stage = new Stage();
        ChangePageManager.setUI(this.getClass(), "/UI/LoginUI.fxml");
    }


    private boolean checkTextNotEmpty(){
        if(usernameInput.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please, enter your username");
            alert.showAndWait();
            return false;
        }
        return true;
    }

}
