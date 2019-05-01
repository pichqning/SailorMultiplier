package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import orm.DatabaseManager;
import orm.HighscoreDAO;
import program.ChangePageManager;
import program.Highscore;
import program.User;

public class SelectQuestionController {

    @FXML
    private Button b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, logoutButton;

    @FXML
    private Label u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12;

    @FXML
    private AnchorPane selectQuesPane;

    @FXML
    private AnchorPane imgSailorContainer;

    @FXML
    private Label usernameLogin;

    @FXML
    private VBox vboxHighScore;

    private DatabaseManager db;
    private HighscoreDAO highscoreDAO;
    private User user;
    private Stage stage;

    private static String id;

    @FXML
    private void initialize() {
        db = DatabaseManager.getInstance();
        highscoreDAO = db.getHighscoreDAO();
        user = LoginController.getUser();
        usernameLogin.setText(user.getUsername());
        setImgSailor();
        setTextLabel();
    }

    @FXML
    private void handleHighScoreButton(ActionEvent e) {
        Button buttonClick = (Button) e.getSource();
        buttonClick.setText("Start");
        id = splitButtonName(buttonClick.getId());
        stage = new Stage();
        ChangePageManager.setUI(this.getClass(), "/UI/GameUI.fxml");
    }

    @FXML
    private void handleLogoutButton() {
        stage = new Stage();
        ChangePageManager.setUI(this.getClass(), "/UI/LoginUI.fxml");
    }

    private void setTextLabel() {
        u2.setText(getUsernameFromHighScoreTable(2));
        u3.setText(getUsernameFromHighScoreTable(3));
        u4.setText(getUsernameFromHighScoreTable(4));
        u5.setText(getUsernameFromHighScoreTable(5));
        u6.setText(getUsernameFromHighScoreTable(6));
        u7.setText(getUsernameFromHighScoreTable(7));
        u8.setText(getUsernameFromHighScoreTable(8));
        u9.setText(getUsernameFromHighScoreTable(9));
        u10.setText(getUsernameFromHighScoreTable(10));
        u11.setText(getUsernameFromHighScoreTable(11));
        u12.setText(getUsernameFromHighScoreTable(12));

        h2.setText(getHighScoreFromHighScoreTable(2));
        h3.setText(getHighScoreFromHighScoreTable(3));
        h4.setText(getHighScoreFromHighScoreTable(4));
        h5.setText(getHighScoreFromHighScoreTable(5));
        h6.setText(getHighScoreFromHighScoreTable(6));
        h7.setText(getHighScoreFromHighScoreTable(7));
        h8.setText(getHighScoreFromHighScoreTable(8));
        h9.setText(getHighScoreFromHighScoreTable(9));
        h10.setText(getHighScoreFromHighScoreTable(10));
        h11.setText(getHighScoreFromHighScoreTable(11));
        h12.setText(getHighScoreFromHighScoreTable(12));

    }

    private String getUsernameFromHighScoreTable(int id) {
        return highscoreDAO.getListFromColumn("multiplier", id).get(0).getUsername();
    }

    private String getHighScoreFromHighScoreTable(int id) {
        return String.valueOf(highscoreDAO.getListFromColumn("multiplier", id).get(0).getScore());
    }

    private String splitButtonName(String id) {
        return id.substring(1);
    }

    public static String getId() {
        return id;
    }

    public void setImgSailor() {
        if(user.getSailor_character().equals("yellow")) {
            imgSailorContainer.setStyle("-fx-background-image: url('/images/yellow_sailor_login.png'); -fx-background-size: 323 460; -fx-background-repeat: no-repeat;");
        }else if(user.getSailor_character().equals("blue")) {
            imgSailorContainer.setStyle("-fx-background-image: url('/images/blue_sailor_login.png'); -fx-background-size: 330 470; -fx-background-repeat: no-repeat;");
        }else if(user.getSailor_character().equals("violet")) {
            imgSailorContainer.setStyle("-fx-background-image: url('/images/purple_sailor_login.png'); -fx-background-size: 250 450; -fx-background-repeat: no-repeat;");
        }else if(user.getSailor_character().equals("green")) {
            imgSailorContainer.setStyle("-fx-background-image: url('/images/green_sailor_login.png'); -fx-background-size: 276 460; -fx-background-repeat: no-repeat;");
        }else {
            imgSailorContainer.setStyle("-fx-background-image: url('/images/pink_sailor_login.png'); -fx-background-size: 262 460; -fx-background-repeat: no-repeat;");
        }
    }
}
