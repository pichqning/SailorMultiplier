package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import orm.DatabaseManager;
import orm.HighscoreDAO;
import program.Highscore;

public class EndGameController {

    @FXML
    private Label showTotalScore, showOldHighScore, showOldUser, showResult, usernamePlayed;


    private DatabaseManager db;
    private HighscoreDAO highscoreDAO;
    private Highscore highscore;

    private int oldHighScore = 0, currentScore = 0;
    private String oldUsername = "", currentUsername = "";

    @FXML
    private void initialize() {
        db = DatabaseManager.getInstance();
        highscoreDAO = db.getHighscoreDAO();
        setUp();
    }

    private void setUp() {
        currentScore = GameController.getTotalScore();
        showTotalScore.setText(String.valueOf(currentScore));

        highscore =  highscoreDAO.getListFromColumn("multiplier", Integer.parseInt(SelectQuestionController.getId()));
        oldHighScore = highscore.getScore();
        showOldHighScore.setText(String.valueOf(oldHighScore));
        oldUsername = highscore.getUsername();
        showOldUser.setText(oldUsername);

        currentUsername = LoginController.getUser().getUsername();
        usernamePlayed.setText(currentUsername);
    }

    private void setStatus() {
    }
}
