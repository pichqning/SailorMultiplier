package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import orm.DatabaseManager;
import orm.UserDAO;
import program.User;

import java.sql.SQLException;


public class CreateUserController {

    @FXML
    TextField usernameInput;

    @FXML
    ComboBox selectSailor;

    @FXML
    Button submitCreateButton;

    private String sailorColor = "";
    private String username = "";

    private DatabaseManager db;
    private UserDAO userDAO;

    @FXML
    private void initialize() {
        db = DatabaseManager.getInstance();
        userDAO = db.getUserDao();
        addSailorToCombobox();
    }

    public void addSailorToCombobox() {
        selectSailor.getItems().add("pink");
        selectSailor.getSelectionModel().select(0);
        handleSailorSelect();
    }

    @FXML
    public void handleSailorSelect() {
        sailorColor = selectSailor.getValue().toString();
    }

    @FXML
    public void handleSubmitCreateButton() throws SQLException {
        if(checkTextNotEmpty()) {
            username = usernameInput.getText().trim();
            sailorColor = selectSailor.getSelectionModel().getSelectedItem().toString();
            User user = new User(username, sailorColor);

            userDAO.create(user);
        }
    }

    public boolean checkTextNotEmpty() {
        return !usernameInput.getText().trim().isEmpty();
    }
}
