package Devices;

import Interfaces.Command;
import Interfaces.Commandable;
import Utilities.MyTimer;

import java.util.ArrayList;

public class CleaningRobot implements Commandable {

    private int timerSeconds = 0;
    private MyTimer timer;



    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        //Set Timer

        // Start

        //Check Cleaning Status

        //Check Battery Status

        //Check Charging status

        //End cleaning


        return commands;
    }

    public void setTimer(int seconds) {
        timerSeconds = seconds;
    }
}
