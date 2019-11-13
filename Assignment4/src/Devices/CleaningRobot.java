package Devices;

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
    private int chargingStatus = 100;



    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        commands.add(new setTimerRobot(this));

        if (atBase && batteryStatus == 100) {
            commands.add(new startRobot(this));
        }

        //Check Cleaning Status
        commands.add(new checkCleaningStatusRobot(this));

        //Check Battery Status
        commands.add(new checkBatteryStatusRobot(this));

        //Check Charging status
        if (atBase) {
            commands.add(new CheckChargingStatusRobots(this));
        }

        //End cleaning


        return commands;
    }

    //Set Timer
    public void setTimer(int seconds) {
        timerSeconds = seconds;
    }

    private void startTimer(int seconds) {
        timer = new MyTimer(seconds);
        timer.start();

    }

    //Start
    public void start() {
        startTimer(timerSeconds);
        atBase = false;

    }

    //Cleaning Status
    public int checkCleaningStatus() {
        cleaningStatus = (timerSeconds - timer.getRemainingSeconds())/2;
        return cleaningStatus;
    }

    //Battery Status
    public int checkBatteryStatus(){
        batteryStatus = (timerSeconds - timer.getRemainingSeconds()/4);
        return batteryStatus;
    }

    //Charging Status
    public int checkChargingStatus(){
        chargingStatus =
    }

}
