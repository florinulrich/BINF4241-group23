package Commands.OvenCommands;

import Devices.Oven;
import Interfaces.Command;

public class CheckTimerOven implements Command {

    private static final String NAME = "check timer";

    private Oven oven;

    public CheckTimerOven(Oven oven) {

        this.oven = oven;
    }

    @Override
    public void execute() {

        System.out.println("The timer is currently at: " + oven.checkTimer() + " seconds");

    }

    @Override
    public String getName() { return NAME; }
}
