package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import orm.DatabaseManager;
import orm.UserDAO;
import program.User;

public class SelectQuestionController {

    @FXML
    private Label usernameLabel;

    private DatabaseManager db;

    private UserDAO userDAO;

    private User user;

    @FXML
    private void initialize() {
        db = DatabaseManager.getInstance();
        userDAO = db.getUserDao();
        user = LoginController.getUser();
        usernameLabel.setText(user.getUsername());
    }


}
