package Utilities;

import Interfaces.Command;

public class MyTimer implements Runnable{

    //Variables
    private int remainingSeconds;
    private int elapsedSeconds = 0;
    private boolean timerIsRunning = false;
    private Thread timerThread = new Thread(this);
    private Command endCommand = null;

    //Constructors
    public MyTimer(int seconds) {
        remainingSeconds = seconds;
    }

    public MyTimer(int seconds, Command endCommand) {
        remainingSeconds = seconds;
        this.endCommand = endCommand;
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
            elapsedSeconds++;
        }

        timerIsRunning = false;

        if (endCommand != null) {
            endCommand.execute();
        }

    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public int getElapsedSeconds() {
        return elapsedSeconds;
    }

    public void start() {
        timerThread.start();

    }

    public boolean isRunning() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return timerIsRunning;
    }


}
