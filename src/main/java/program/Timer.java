package program;


public class Timer{
    private int second ;
    private boolean canPlay;

    public Timer() {
        this.second = 60;
        this.canPlay = true;
    }


    public void start()   {
        for (int i = second ; i >= 0 ; i-- ){
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        canPlay = false;
    }

    public int getSecond() {
        return second;
    }

    public boolean getCanplay() {
        return canPlay;
    }
    public void reset () {
        this.canPlay = true;
    }
}

