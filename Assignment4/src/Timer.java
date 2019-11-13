public class Timer implements Runnable{

    //Variables
    private int remainingMinutes;
    private boolean timerIsRunning = false;
    private Thread timerThread = new Thread(this);

    //Constructor
    public Timer(int minutes) {
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

    void startTimer() {
        timerThread.start();

    }

    boolean isRunning() {
        return timerIsRunning;
    }
}
