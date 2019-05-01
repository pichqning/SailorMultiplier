package program;


import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Timer class for countdown the game
 *
 * //TODO implement observer design pattern
 */
public class Timer{
    private int second ;
    public static boolean canPlay;
    Runnable runnable = new Runnable() {

        @Override public void run() {
            canPlay = false;
            System.out.println("Hello, world!");
            // 60 second passed excute the question window and show the score.
        }
    } ;

    public Timer() {
        this.second = 60;
        this.canPlay = true;
    }

    public void start() {
        Executors.newSingleThreadScheduledExecutor().schedule(runnable,second,TimeUnit.SECONDS);
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public boolean getCanplay() {
        return canPlay;
    }

    public void reset () {
        this.canPlay = true;
    }

}

