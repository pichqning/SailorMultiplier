import java.awt.*;
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

    public Game(int multiplier) {
        this.answerList = new ArrayList<>();
        this.questionList = new ArrayList<>();
        this.highScoreList = new ArrayList<>();
        this.choiceList = new ArrayList<>();
        this.multiplier = multiplier;
    }

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


}
