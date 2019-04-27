package program;

import program.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Create Game for Each Multiplier
 */
public class Game {
    private List<Answer> answerList;
    private List<Question> questionList;
    private List<Integer> choiceList;
    private int multiplier;

    public Game(int multiplier) {
        this.answerList = new ArrayList<>();
        this.questionList = new ArrayList<>();
        this.choiceList = new ArrayList<>();
        this.multiplier = multiplier;
   }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public List<Integer> getChoiceList() {
        return choiceList;
    }

    public int getMultiplier() {
        return multiplier;
    }

    /**
     * add question to the list for displayed in the UI
     */
    public void addQuestion () {
        Question q = new Question(multiplier);
        questionList.add(q);
        this.addAnswer(q);
    }

    /**
     * add answer for checking.
     * */
    public void addAnswer (Question q) {
        Answer a = q.creatAnswer();
        answerList.add(a);
        this.addChoice(a);
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
