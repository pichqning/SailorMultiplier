package program;

public class Highscore {
    private int score;
    private int multiplier;

    public Highscore (int multi , int score) {
       this.multiplier = multi;
       this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getMultiplier() {
        return multiplier;
    }

    @Override
    public String toString() {
        return String.format("%d",score);
    }

    public void setScore(int a) {
        this.score = a;
    }


}
