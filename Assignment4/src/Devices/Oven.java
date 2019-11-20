package Devices;

import Commands.OvenCommands.*;
import Interfaces.Command;
import Interfaces.Commandable;
import Utilities.MyTimer;

import java.util.ArrayList;

public class Oven implements Commandable {

    private boolean stateChanged = false;
    private boolean switchedOn = false;
    private int timerSeconds = 0;
    private MyTimer timer;
    private int temperature = 0;
    private String program = "";
    private boolean isCooking = false;

    //Constructors

    //Methods
    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        if (!isOn()) {
            commands.add(new SwitchOnOven(this));
        }

        if (isOn()) {

            if (!isCooking) {
                commands.add(new SwitchOffOven(this));
                commands.add(new SetProgramOven(this));
                commands.add(new SetTemperatureOven(this));
                commands.add(new SetTimerOven(this));
            } else {
                commands.add(new InterruptOperationOven(this));
            }

            commands.add(new CheckTimerOven(this));

            if (timerSeconds != 0 && temperature != 0 && !program.equals("") && !isCooking) {
                commands.add(new StartCookingOven(this));
            }
        }
        return commands;
    }

    @Override
    public boolean stateHasChanged() {
        if (!stateChanged) {
            return false;
        } else {
            stateChanged = false;
            return true;
        }
    }

    @Override
    public ArrayList<String> displayStatus() {

        ArrayList<String> status = new ArrayList();

        status.add("Switched on:", String.valueOf(switchedOn));
        status.add("Time Seconds:", String.valueOf(timerSeconds));
        status.add("Temperature:", String.valueOf(temperature));
        status.add("Program:", program);
        status.add("Is cooking:", String.valueOf(isCooking));

        return status;
    }


    //ON and OFF functionality
    public void switchOn() {
        switchedOn = true;
    }

    public void switchOff() {
        switchedOn = false;
        temperature = 0;
        program = "";
        isCooking = false;
        timerSeconds = 0;
    }

    private boolean isOn() {
        return switchedOn;
    }

    //Set Temperature
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    //Set Timer
    public void setTimerSeconds(int timerSeconds) { this.timerSeconds = timerSeconds; }

    private void startTimer() {
        timer = new MyTimer(timerSeconds, new InterruptOperationOven(this));
        timer.start();
    }

    //CheckTimer
    public int checkTimer() {
        if (timer != null && timer.isRunning()) {
            return timer.getRemainingSeconds();
        }
        return timerSeconds;
    }

    //Set Program
    public void setProgram(String program) { this.program = program; }

    //Start cooking
    public void startCooking() {

        startTimer();
        isCooking = true;
    }

    //Interrupt program
    public void interruptOperation() {
        isCooking = false;
        timer = null;
        stateChanged = true;
    }

}
