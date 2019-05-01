package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import orm.DatabaseManager;
import orm.HighscoreDAO;
import orm.UserDAO;
import program.User;


public class GameController {

    @FXML
    private Button ans1, ans2, ans3, ans4;


    @FXML
    private Label usernameGame, scoreGame, timerGame, question;

    private DatabaseManager db;
    private UserDAO userDAO;
    private HighscoreDAO highscoreDAO;
    private User user;

    @FXML
    private void initialize() {
        db = DatabaseManager.getInstance();
        userDAO = db.getUserDao();
        highscoreDAO = db.getHighscoreDAO();
        user = LoginController.getUser();
        usernameGame.setText(user.getUsername());

    }



}
