package program;

import program.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create Game for Each Multiplier
 */
public class Game {
    private List<Answer> answerList;
    private List<Question> questionList;
    private List<Integer> choiceList;
    private int multiplier;
    private int score;
    private int wrong;
    private int correct ;
    private static Game instance;

    public static Game getInstance(int multiplier) {
        if (instance == null) {
            instance = new Game(multiplier);
        }
        return instance;
    }

    public Game(int multiplier) {
        this.answerList = new ArrayList<>();
        this.questionList = new ArrayList<>();
        this.choiceList = new ArrayList<>();
        this.multiplier = multiplier;
        this.score = 0;
        this.wrong = 0;
        this.correct = 0;
   }

    public int getScore() {
        return this.score;
    }

    public int getCorrect() {
        return correct;
    }

    public int getWrong() {
        return wrong;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    /**
     *
     */
    public String getQuestion () {
        String q = questionList.get(0).toString();
        System.out.println(q);
        questionList.remove(0);
        return q;
    }

    public int getAnswer () {
        int a = answerList.get(0).getAnswer();
        answerList.remove(0);
        return a;
    }
    /**
     * add question to the list for displayed in the UI
     */
    public void addQuestion () {
//        while (Timer.canPlay) {
            Question q = new Question(multiplier);
            System.out.println(q.toString());
            questionList.add(q);
            this.addAnswer(q);
//        }
//        questionList.clear();
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
        for (int i = -1 ; i < 3 ; i ++) {
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

    public void reset() {
        questionList.clear();
        answerList.clear();
        score = 0;
        correct = 0;
        wrong = 0;
    }

    public void checkAnswer (String userAns , int answer) {
        int temp = Integer.parseInt(userAns);
        if (temp == answer) {
            score += 20;
            correct += 1;
        }
        else if (score < 0) score = 0;
        else {score -= 10 ; wrong += 1 ;}
    }

    public List<Integer> getChoiceList() {
        return choiceList;
    }









}
