package program;

public class Answer {
    private int answer;

    public Answer (int multiplier,int x) {
        this.answer = multiplier*x;
    }

    public int getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return String.format("%d" , answer);
    }
}
