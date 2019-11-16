package Devices;

import Commands.DishwasherCommands.*;
import Interfaces.Command;
import Interfaces.Commandable;
import Utilities.MyTimer;

import java.util.ArrayList;

public class Dishwasher implements Commandable {

    //Variables
    private boolean switchedOn = false;
    private int timerSeconds = 0;
    private MyTimer timer;
    private boolean isWashing = false;
    private String program = "";

    //Methods
    @Override
    public ArrayList<Command> getCommands() {

        ArrayList<Command> commands = new ArrayList<>();

        if (!isOn()) {
            commands.add(new SwitchOnDishwasher(this));
        }

        if (isOn()) {

            if (!isWashing) {
                commands.add(new SwitchOffDishwasher(this));
            }

            commands.add(new CheckTimerDishwasher(this));
            commands.add(new SetProgramDishwasher(this));

            if (!program.equals("")){
                commands.add(new StartWashingDishwasher(this));
            }

            if (isWashing) {
                commands.add(new InterruptOperationDishwasher(this));
            }
        }

        return commands;
    }

    //ON and OFF functionality
    public void switchOn() { switchedOn = true; }

    public void switchOff() {
        switchedOn = false;
        isWashing = false;
        timerSeconds = 0;
        program = "";
    }

    private boolean isOn() { return switchedOn; }

    //Set Timer
    public void setTimerSeconds(int timerSeconds) { this.timerSeconds = timerSeconds; }

    public void startTimer() {
        timer = new MyTimer(timerSeconds);
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
    public void setProgram(String program) { this.program = program; }

    //Start Washing
    public void startWashing() {

        startTimer();
        isWashing = true;

        //TODO: set isWashing = false if timer ends

    }

    //Interrupt program
    public void interruptOperation() {
        isWashing = false;
        timer = null;
    }

}
