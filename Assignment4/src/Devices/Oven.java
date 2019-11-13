package Devices;

import Commands.*;
import Interfaces.Command;
import Interfaces.Commandable;

import java.util.ArrayList;

public class Oven implements Commandable {

    //Variables
    private boolean switchedOn = false;
    private int timer = 0;
    private int temperature = 0;
    private String program = "";

    //Constructors

    //Methods
    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        commands.add(new SwitchOnOvenCommand(this));

        if (isOn()) {
            commands.add(new SetTimerCommand(this));
            commands.add(new SetTemperatureCommand(this));
            commands.add(new SetProgramCommand(this));
        }

        commands.add(new SwitchOffOvenCommand(this));

        return commands;
    }


    //ON and OFF functionality
    public void switchOn() {
        switchedOn = true;
    }
    public void switchOff() { switchedOn = false; }

    public boolean isOn() {
        return switchedOn;
    }

    //Set Temperature
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    //Set Timer
    public void setTimer(int timer) { this.timer = timer; }

    //Set Program
    public void setProgram(String program) { this.program = program; }
}
