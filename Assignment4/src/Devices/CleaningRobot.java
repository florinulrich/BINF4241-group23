package Devices;

import Commands.CleaningRobotCommands.*;
import Interfaces.Command;
import Interfaces.Commandable;
import Utilities.MyTimer;

import java.util.ArrayList;

public class CleaningRobot implements Commandable {

    private int timerSeconds = 0;
    private MyTimer timer;
    private boolean atBase = true;
    private int batteryStatus = 100;
    private int cleaningStatus = 0;
    private boolean completingCleaning = false;
    private boolean stateChanged = false;


    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        if (atBase) {
            commands.add(new SetTimerRobot(this));
            commands.add(new CheckChargingStatusRobot(this));
            if (batteryStatus >= 100 && timerSeconds != 0) {
                commands.add(new StartCleaningRobot(this));
            }
        } else {
            commands.add(new CheckBatteryStatusRobot(this));
        }

        commands.add(new CheckCleaningStatusRobot(this));
        if (!completingCleaning) {commands.add(new CompleteOutstandingCleaningRobot(this)); }
        commands.add(new EndCleaningRobot(this));

        return commands;
    }

    @Override
    public boolean stateHasChanged() {
        return stateChanged;
    }

    @Override
    public void acceptState() {
        stateChanged = false;
    }

    //Set Timer
    public void setTimer(int timerSeconds) { this.timerSeconds = timerSeconds; }

    private void startTimer() {
        timer = new MyTimer(timerSeconds);
        timer.start();
    }

    //Start Cleaning
    public void startCleaning() {

        //Check if timer is set
        if (completingCleaning) {
            timerSeconds = 100;
        }


        atBase = false;

        CleaningThread cleaningThread = new CleaningThread();
        Thread cleaning = new Thread(cleaningThread);
        cleaning.start();

    }

    //End Cleaning
    public void endCleaning() {
        atBase = true;
        timer = null;

        ChargingThread chargingThread = new ChargingThread();
        Thread charging = new Thread(chargingThread);
        charging.start();

    }

    //Complete Cleaning
    public void completeOutstandingCleaning(){
        completingCleaning = true;
        endCleaning();
    }

    //Cleaning Status
    public int checkCleaningStatus() {
        return cleaningStatus;
    }

    //Battery Status
    public int checkBatteryStatus(){
        return batteryStatus;
    }

    //Charging Status
    public int checkChargingStatus(){
        return batteryStatus;
    }

    public void setTimerSeconds(int timerSeconds) {
        this.timerSeconds = timerSeconds;
    }

    private class CleaningThread implements Runnable {

        @Override
        public void run() {

            //The Space already cleaned at the start
            int initialCleaningStatus = cleaningStatus;

            startTimer();

            while (timer.isRunning() && batteryStatus > 0 && cleaningStatus < 100) {
                batteryStatus = 100 - timer.getElapsedSeconds();
                cleaningStatus = initialCleaningStatus + timer.getElapsedSeconds();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //Set Robot as returned to base
            atBase = true;

            //Tell that state has changed
            stateChanged = true;

            //If everything is clean, cleaning status back to 0,
            // if robot is in completeOutstandingCleaningMode set completingCleaning to false
            if (cleaningStatus > 99) {
                cleaningStatus = 0;
                completingCleaning = false;
            }

            //Set timer to null to safely kill the thread
            timer = null;

            //StartCharging the Robot again
            ChargingThread chargingThread = new ChargingThread();
            Thread charging = new Thread(chargingThread);
            charging.start();
        }
    }

    private class ChargingThread implements Runnable {

        @Override
        public void run() {
            int initialBatteryStatus = batteryStatus;

            timer = new MyTimer(100);
            timer.start();

            while (timer.isRunning() && batteryStatus < 100) {
                batteryStatus = initialBatteryStatus + timer.getElapsedSeconds();
            }

            //Tell that state has changed
            stateChanged = true;

            //Kill remaining timer
            timer = null;

            //If the robot is in complete Outstanding cleaningMode send it to clean
            if (completingCleaning) {
                startCleaning();

            }
        }
    }

}
