package Devices;

import Interfaces.Command;
import Interfaces.Commandable;
import Utilities.MyTimer;

import java.util.ArrayList;

public class CleaningRobot implements Commandable {

    private int timerSeconds = 0;
    private MyTimer timer;
    private Thread cleaning = null;
    private boolean atBase = true;
    private int batteryStatus = 100;
    private int cleaningStatus = 0;
    private boolean completingCleaning = false;



    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        //Setting a timer only makes sense if the robot is not currently cleaning
        if (atBase) {
            commands.add(new SetTimerRobot(this));
        }

        //Starting the robot is only allowed with full battery, it being at the base and having a set timer
        if (atBase && batteryStatus == 100 && timerSeconds != 0) {
            commands.add(new StartCleaningRobot(this));
        }

        //Check Cleaning Status (always allowed)
        commands.add(new CheckCleaningStatusRobot(this));

        //The battery status is provided with different commands according to the robots state
        if (atBase) {

            //Check Charging Status also returns the battery status, but may have additional
            //functionality like telling user "charging" or "fully charged"
            commands.add(new CheckChargingStatusRobot(this));
        } else {

            //Check Battery Status
            commands.add(new CheckBatteryStatusRobot(this));
        }

        //Complete Outstanding cleaning: The robot will complete the cleaning and charges automatically if necessary
        //It can be told to do so at any time
        commands.add(new CompleteOutstandingCleaningRobot(this));


        //End cleaning makes only sense if the robot is currently cleaning
        commands.add(new EndCleaningRobot(this));


        return commands;
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

        //Check if battery is full

        //Check if is at charging base

        if (timerSeconds != 0 && batteryStatus == 100 && atBase) {

            CleaningThread cleaningThread = new CleaningThread();

            cleaning = new Thread(cleaningThread);

            cleaning.start();

        }
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

    private class CleaningThread implements Runnable {

        @Override
        public void run() {

            //The Space already cleaned at the start
            int initialCleaningStatus = cleaningStatus;

            startTimer();
            atBase = false;

            while (timer.isRunning() && batteryStatus > 0 && cleaningStatus < 100) {
                batteryStatus = 100 - timer.getElapsedSeconds();
                cleaningStatus = initialCleaningStatus + timer.getElapsedSeconds();
            }

            //Set Robot as returned to base
            atBase = true;

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

            //Kill remaining timer
            timer = null;

            //If the robot is in complete Outstanding cleaningMode send it to clean
            if (completingCleaning) {

                //TODO: Set up outstanding cleaning in a way that the assertion never fails!!
                assert !(timerSeconds == 0) && batteryStatus == 100 && atBase;

                startCleaning();
            }
        }
    }

}
