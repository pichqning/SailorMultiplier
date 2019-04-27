package program;


public class Timer{
    private int second ;
    private boolean canPlay;

    public Timer() {
        this.second = 60;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void start() throws InterruptedException {
        for (int i = second ; i >= 0 ; i-- ){
            Thread.sleep(1000);
        }

    }
}

