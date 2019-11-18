package Commands.WasherCommands;

import Devices.Washer;
import Interfaces.Command;

public class CheckTimerWasher implements Command {

    private static final String NAME = "check timer";

    private Washer washer;

    public CheckTimerWasher(Washer washer) { this.washer = washer; }

    @Override
    public void execute() {

        System.out.println("The timer is currently at: " + washer.checkTimer() + " seconds");

    }

    @Override
    public String getName() { return NAME; }
}
