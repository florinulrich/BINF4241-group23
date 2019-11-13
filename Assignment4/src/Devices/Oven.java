package Devices;

import Commands.*;
import Interfaces.Command;
import Interfaces.Commandable;
import Utilities.MyTimer;

import java.util.ArrayList;

public class Oven implements Commandable {

    //Variables
    private boolean switchedOn = false;
    private int timerMinutes = 0;
    private MyTimer timer;
    private int temperature = 0;
    private String program = "";

    //Constructors

    //Methods
    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        if (!isOn()) {
            commands.add(new SwitchOnOven(this));
        }

        if (isOn()) {
            commands.add(new SetTimerOven(this));
            commands.add(new SetTemperatureOven(this));
            commands.add(new SetProgramOven(this));
            commands.add(new SwitchOffOven(this));
        }



        return commands;
    }


    //ON and OFF functionality
    public void switchOn() { switchedOn = true; }
    public void switchOff() { switchedOn = false; }

    public boolean isOn() { return switchedOn; }

    //Set Temperature
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    //Set Timer
    public void setTimerMinutes(int timerMinutes) { this.timerMinutes = timerMinutes; }

    public void startTimer() {
        timer = new MyTimer(timerMinutes);
        timer.start();

    }

    //Set Program
    public void setProgram(String program) { this.program = program; }
}
