package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import orm.DatabaseManager;
import orm.HighscoreDAO;
import orm.UserDAO;
import program.*;

import java.util.*;
import java.util.Timer;


public class GameController {

    @FXML
    private AnchorPane gamePane, questionPane, answerContainer;

    @FXML
    private Button ans1, ans2, ans3, ans4;

    @FXML
    private Label usernameGame, scoreGame, timeGame, question;

    private DatabaseManager db;
    private UserDAO userDAO;
    private HighscoreDAO highscoreDAO;
    private User user;
    private Timer timer;

    private int multiplier;
    private static Game game;
    private int ansExcept = 0;
    private int interval;



    @FXML
    private void initialize() {
        db = DatabaseManager.getInstance();
        userDAO = db.getUserDao();
        highscoreDAO = db.getHighscoreDAO();
        user = LoginController.getUser();
        usernameGame.setText(user.getUsername());
        setBackground(user);
        multiplier = Integer.parseInt(SelectQuestionController.getId());
        game = Game.getInstance(multiplier);
        setUp();
        start();
    }

    @FXML
    private void handleAnswerButton(ActionEvent e) {
        Button ansButton = (Button) e.getSource();
        String ansUser = ansButton.getText();
        game.checkAnswer(ansUser, ansExcept);
        scoreGame.setText(String.valueOf(game.getScore()));
        setUp();
    }

    private void setBackground(User u){
        if(u.getSailor_character().equals("blue")) {
            gamePane.setStyle("-fx-background-image: url('/images/blue_fight.jpg'); -fx-background-size: 1080 640; -fx-background-position: center center;");
            questionPane.setStyle("-fx-background-color: rgba(74, 108, 232, 0.50)");
        }else if(u.getSailor_character().equals("yellow")) {
            gamePane.setStyle("-fx-background-image: url('/images/yellow_fight1.png'); -fx-background-size: 1080 640; -fx-background-position: center center;");
            questionPane.setStyle("-fx-background-color: rgba(202, 204, 102, 0.50)");
        }else if(u.getSailor_character().equals("violet")) {
            gamePane.setStyle("-fx-background-image: url('/images/purple_fight1.jpg'); -fx-background-size: 1080 640; -fx-background-position: center center;");
            questionPane.setStyle("-fx-background-color: rgba(161, 102, 204, 0.50)");
        }else if(u.getSailor_character().equals("green")) {
            gamePane.setStyle("-fx-background-image: url('/images/green_fight1.jpg'); -fx-background-size: 1080 640; -fx-background-position: center center;");
            questionPane.setStyle("-fx-background-color: rgba(133, 214, 134, 0.50)");
        }else  {
            gamePane.setStyle("-fx-background-image: url('/images/pink_fight.png'); -fx-background-size: 1080 640; -fx-background-position: center center;");
            questionPane.setStyle("-fx-background-color: rgba(213, 133, 176, 0.50)");
        }
    }


    private void start() {
        int secs = 10;

        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = secs;
        System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() ->{
                    timeGame.setText(String.valueOf(interval));
                    if(interval < 1){
                        ChangePageManager.setUI(this.getClass(), "/UI/EndGame.fxml");
                    }
                });
                System.out.println(setInterval());
            }
        }, delay, period);
    }


    private final int setInterval() {
        if (interval == 1) {
            timer.cancel();
        }
        return --interval;
    }

    private void setUp() {
        game.addQuestion();
        String q = game.getQuestion();
        question.setText(q);

        List<Integer> choiceList = game.getChoiceList();
        List<Integer> randomList = new ArrayList<>();

        Random r = new Random();

        //get answer but not remove from list
        ansExcept = game.getAnswer();

        int index = r.nextInt(4);
        int in = r.nextInt(4)+ansExcept-index;
        randomList.clear();
        for (int i = 0; i < 4 ; i++) {
            while (randomList.contains(in)){
                in = r.nextInt(4)+ansExcept-index;
            }
            randomList.add(in);
        }

        ans1.setText(String.valueOf((randomList.get(0))));
        ans2.setText(String.valueOf((randomList.get(1))));
        ans3.setText(String.valueOf((randomList.get(2))));
        ans4.setText(String.valueOf((randomList.get(3))));
    }

    public static int getTotalScore() {
        return game.getScore();
    }

}



