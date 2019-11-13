package Devices;

import Commands.SetTemperatureCommand;
import Commands.SwitchOnOvenCommand;
import Interfaces.Command;
import Interfaces.Commandable;

import java.util.ArrayList;

public class Oven implements Commandable {

    //Variables
    private boolean switchedOn = false;
    private int temperature = 0;

    //Constructors

    //Methods
    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        commands.add(new SwitchOnOvenCommand(this));
        commands.add(new SetTemperatureCommand(this));

        return commands;
    }


    //ON and OFF functionality
    public void switchOn() {
        switchedOn = true;
    }

    public boolean isOn() {
        return switchedOn;
    }

    //Set Temperature
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
