package Devices;

import Commands.MicrowaveCommands.*;
import Interfaces.Command;
import Interfaces.Commandable;
import Utilities.MyTimer;

import java.util.ArrayList;

public class Microwave implements Commandable {

    //Variables
    private boolean switchedOn = false;
    private int timerSeconds = 0;
    private MyTimer timer;
    private int temperature = 0;
    private boolean isBaking = false;
    private boolean stateChanged = false;

    //Methods
    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        if (!isOn()) {
            commands.add(new SwitchOnMicrowave(this));
        }

        if (isOn()) {

            if (!isBaking) {
                commands.add(new SwitchOffMicrowave(this));
                commands.add(new SetTemperatureMicrowave(this));
                commands.add(new SetTimerMicrowave(this));
            } else {
                commands.add(new InterruptOperationMicrowave(this));
            }

            commands.add(new CheckTimerMicrowave(this));

            if (timerSeconds != 0 && temperature != 0 && !isBaking) {
                commands.add(new StartBakingMicrowave(this));
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
    public void switchOn() { switchedOn = true; }

    public void switchOff() {
        switchedOn = false;
        temperature = 0;
        isBaking = false;
        timerSeconds = 0;
    }

    private boolean isOn() { return switchedOn; }

    //Set Temperature
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    //Set Timer
    public void setTimerSeconds(int timerSeconds) { this.timerSeconds = timerSeconds; }

    private void startTimer() {
        timer = new MyTimer(timerSeconds, new InterruptOperationMicrowave(this));
        timer.start();
    }
    
    //CheckTimer
    public int checkTimer() {
        if (timer != null && timer.isRunning()) {
            return timer.getRemainingSeconds();
        }
        return timerSeconds;
    }

    //Start Baking
    public void startBaking() {

        startTimer();
        isBaking = true;

        //Timer gets interruptOperation as Timer ends command above

    }

    //Interrupt program
    public void interruptOperation() {
        isBaking = false;
        timer = null;
        stateChanged = true;
    }

}
