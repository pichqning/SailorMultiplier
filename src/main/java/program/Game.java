package program;

import program.Question;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Answer> answerList;
    private List<Question> questionList;
    private List<Integer> highScoreList;
    private List<Integer> choiceList;
    private int multiplier;
    int correct = 0;
    int wrong = 0;
    private HighscorePool highscorePool;

    public Game(int multiplier) {
        this.answerList = new ArrayList<>();
        this.questionList = new ArrayList<>();
        this.highScoreList = new ArrayList<>();
        this.choiceList = new ArrayList<>();
        this.multiplier = multiplier;
//        this.highscorePool = HighscorePool.getInstance();
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public List<Integer> getHighScoreList() {
        return highScoreList;
    }

    public List<Integer> getChoiceList() {
        return choiceList;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public int getCorrect() {
        return correct;
    }

    public int getWrong() {
        return wrong;
    }

    /**
     * add question to the list for displayed in the UI
     */
    public void addQuestion () {
        Question q = new Question(multiplier);
        questionList.add(q);
        addAnswer(q);
    }

    /**
     * add answer for checking.
     * */
    public void addAnswer (Question q) {
        answerList.add(q.creatAnswer());
    }

    /**
     * add choices for show in the game
     * */
    public void addChoice (Answer a) {
        for (int i = 0 ; i < 4 ; i ++) {
            int choice = a.getAnswer() + i ;
            choiceList.add(choice);
        }
    }

    /**
     * clear choice list for the next question.
     * */
    public void clearChoice () {
        choiceList.clear();
    }

    /**
     * Get highscore from database
     * */
    public void addHighscore() {
        for (int i = 2 ; i <= 12 ; i++) {
            int sc = highscorePool.getHighscoreIndiv(i).getScore();
            highScoreList.add(sc);
        }
    }






}
