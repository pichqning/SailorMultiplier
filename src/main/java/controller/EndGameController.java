package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import orm.DatabaseManager;
import orm.HighscoreDAO;
import program.ChangePageManager;
import program.Highscore;
import program.User;

public class EndGameController {

    @FXML
    private AnchorPane endGamePane;

    @FXML
    private Label showTotalScore, showOldHighScore, showOldUser, showResult, usernamePlayed, showDetailResult;

    @FXML
    private Button newGameEndButton, logoutEndButton;

    private DatabaseManager db;
    private HighscoreDAO highscoreDAO;
    private Highscore highscore;
    private User currentUser;

    private int oldHighScore = 0, currentScore = 0, multiplier = 0;
    private String oldUsername = "", currentUsername = "";


    @FXML
    private void initialize() {
        db = DatabaseManager.getInstance();
        highscoreDAO = db.getHighscoreDAO();
        setUp();
        setStatus();
    }

    @FXML
    private void handleLogoutButton() {
        ChangePageManager.setUI(this.getClass(), "/UI/LoginUI.fxml");
    }

    @FXML
    private void handleNewGameButton() {
        ChangePageManager.setUI(this.getClass(), "/UI/SelectQuestionUI.fxml");
    }

    private void setUp() {
        currentScore = GameController.getTotalScore();
        showTotalScore.setText(String.valueOf(currentScore));

        multiplier = Integer.parseInt(SelectQuestionController.getId());

        highscore =  highscoreDAO.getListFromColumn("multiplier", multiplier);
        oldHighScore = highscore.getScore();
        showOldHighScore.setText(String.valueOf(oldHighScore));

        oldUsername = highscore.getUsername();
        showOldUser.setText(oldUsername);

        currentUser = LoginController.getUser();
        currentUsername = currentUser.getUsername();
        usernamePlayed.setText(currentUsername);
    }

    private void setStatus() {
        if(oldHighScore < currentScore) {
            showResult.setText("You win!");
            endGamePane.setStyle("-fx-background-image: url('/images/win_background.png'); -fx-background-size: 1080 640; -fx-background-position: center center;");
            showDetailResult.setText(String.format("NEW High Score of %d multiplication table is %s", multiplier, currentUsername));
            highscoreDAO.updateHighScore(multiplier, currentUser, currentScore);
        } else {
            showResult.setText("You lose!");
            endGamePane.setStyle("-fx-background-image: url('/images/lose_background.png'); -fx-background-size: 1080 640; -fx-background-position: center center;");
            showDetailResult.setText(String.format("You can't BEAT %s in %d multiplication table.", oldUsername, multiplier));
        }
    }
}
