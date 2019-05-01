package program;

import java.util.Random;

public class Question {
    private int x;
    private int multiplier;
    private Random rd = new Random();

    public Question (int mul) {
        this.multiplier = mul;
        this.x = rd.nextInt(22) + 2;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = rd.nextInt(x)+1;
    }

    public Answer creatAnswer () {
        Answer a = new Answer(multiplier,x);
        return a;
    }

    @Override
    public String toString() {
        return String.format("%d x %d" , multiplier,x);
    }

}
