package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import orm.DatabaseManager;
import orm.HighscoreDAO;
import orm.UserDAO;


public class GameController {

    @FXML
    private Button ans1, ans2, ans3, ans4;

    @FXML
    private TextField question, multiplier;

    private DatabaseManager db;
    private UserDAO userDAO;
    private HighscoreDAO highscoreDAO;

    @FXML
    private void initialize() {
        db = DatabaseManager.getInstance();
        userDAO = db.getUserDao();

        multiplier.setText(SelectQuestionController.getId());
    }



}
