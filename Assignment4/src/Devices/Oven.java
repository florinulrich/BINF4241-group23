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
            }
            commands.add(new SetTimerOven(this));
            commands.add(new SetTemperatureOven(this));
            commands.add(new SetProgramOven(this));
            commands.add(new CheckTimerOven(this));

            if (timerMinutes != 0 && temperature != 0 && !program.equals("") && !isCooking) {
                commands.add(new StartCookingOven(this));
            }

            if (isCooking) {
                commands.add(new InterruptOperationOven(this));
            }
        }

        return commands;
    }


    //ON and OFF functionality
    public void switchOn() { switchedOn = true; }

    public void switchOff() {
        switchedOn = false;
        temperature = 0;
        program = "";
        isCooking = false;
        timerMinutes = 0;
    }

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

    //CheckTimer
    public int checkTimer() {
        if (timer != null && timer.isRunning()) {
            return timer.getRemainingMinutes();
        }
        return timerMinutes;
    }

    //Set Program
    public void setProgram(String program) { this.program = program; }

    //Start cooking
    public void startCooking() {

        startTimer();
        isCooking = true;

        //TODO: What happens to isCooking when timer ends
    }

    //Interrupt the program
    public void interruptOperation() {
        isCooking = false;
        timer = null;
    }

}
