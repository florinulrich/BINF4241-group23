package Utilities;

public class MyTimer implements Runnable{

    //Variables
    private int remainingMinutes;
    private boolean timerIsRunning = false;
    private Thread timerThread = new Thread(this);

    //Constructor
    public MyTimer(int minutes) {
        remainingMinutes = minutes;
    }

    //Methods
    @Override
    public void run() {
        timerIsRunning = true;
        while (remainingMinutes > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            remainingMinutes--;
        }

        timerIsRunning = false;

    }

    public int getRemainingMinutes() {
        return remainingMinutes;
    }

    public void start() {
        timerThread.start();

    }

    public boolean isRunning() {
        return timerIsRunning;
    }
}
