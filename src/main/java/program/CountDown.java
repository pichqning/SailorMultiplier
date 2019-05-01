package program;

import java.util.Timer;
import java.util.TimerTask;

public class CountDown {

    private int interval;
    private Timer timer;
    private int timeCountDown;

    public void setTimeCountDown(int secs) {
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = secs;
        System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                setInterval();
            }
        }, delay, period);
    }

    private int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }

    public int getInterval() {
        return interval;
    }

    public void main(String[] args) {
        setTimeCountDown(60);
    }
}
