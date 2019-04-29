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
    private Button h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, logoutButton;

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
        setHighScoreToButton();
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

    private void setHighScoreToButton() {
        h2.setText(setTextButton(2));
        h3.setText(setTextButton(3));
        h4.setText(setTextButton(4));
        h5.setText(setTextButton(5));
        h6.setText(setTextButton(6));
        h7.setText(setTextButton(7));
        h8.setText(setTextButton(8));
        h9.setText(setTextButton(9));
        h10.setText(setTextButton(10));
        h11.setText(setTextButton(11));
        h12.setText(setTextButton(12));
    }

    private String setTextButton(int id) {
        return String.format("%s \n High Score: %d", highscoreDAO.getListFromColumn("multiplier", id).get(0).getUsername(),
                highscoreDAO.getListFromColumn("multiplier", id).get(0).getScore());
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
