package Utilities;

public class MyTimer implements Runnable{

    //Variables
    private int remainingSeconds;
    private boolean timerIsRunning = false;
    private Thread timerThread = new Thread(this);

    //Constructor
    public MyTimer(int seconds) {
        remainingSeconds = seconds;
    }

    //Methods
    @Override
    public void run() {
        timerIsRunning = true;
        while (remainingSeconds > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            remainingSeconds--;
        }

        timerIsRunning = false;

    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public void start() {
        timerThread.start();

    }

    public boolean isRunning() {
        return timerIsRunning;
    }
}
