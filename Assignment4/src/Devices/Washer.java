package Devices;


import Commands.WasherCommands.*;
import Interfaces.Command;
import Interfaces.Commandable;
import Utilities.MyTimer;

import java.util.ArrayList;

public class Washer implements Commandable {

    private boolean switchedOn = false;
    private int timerSeconds = 0;
    private MyTimer timer;
    private boolean isWashing = false;
    private String program = "";
    private int temperature = 0;
    private boolean stateChanged = false;

    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        if (!isOn()) {
            commands.add(new SwitchOnWasher(this));
        }

        if (isOn()) {

            if (!isWashing) {
                commands.add(new SwitchOffWasher(this));
                commands.add(new SetTemperatureWasher(this));
                commands.add(new SetProgramWasher(this));
            }

            commands.add(new CheckTimerWasher(this));

            if (timerSeconds != 0 && temperature != 0 && !program.equals("") && !isWashing) {
                commands.add(new StartWashingWasher(this));
            }
        }

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


    //ON and OFF functionality
    public void switchOn() {
        switchedOn = true;
    }

    public void switchOff() {
        switchedOn = false;
        isWashing = false;
        timerSeconds = 0;
        program = "";
    }

    private boolean isOn() {
        return switchedOn;
    }

    //Set Timer
    public void setTimerSeconds(int timerSeconds) {
        this.timerSeconds = timerSeconds;
    }

    private void startTimer() {
        timer = new MyTimer(timerSeconds, new EndProgramWasher(this));
        timer.start();
    }

    //Check Timer
    public int checkTimer() {
        if (timer != null && timer.isRunning()) {
            return timer.getRemainingSeconds();
        }

        return timerSeconds;
    }

    //Set Program
    public void setProgram(String program) {
        this.program = program;
    }

    //Set Temperature
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    //Start Washing
    public void startWashing() {

        startTimer();
        isWashing = true;

        //Timer gets interruptOperation as Timer ends command above

    }

    public void endProgram() {
        isWashing = false;
        timer = null;
        stateChanged = true;
    }

}