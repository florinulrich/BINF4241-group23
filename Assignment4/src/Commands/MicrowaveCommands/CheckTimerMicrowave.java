package Commands.MicrowaveCommands;

import Devices.Microwave;
import Interfaces.Command;

public class CheckTimerMicrowave implements Command {

    private static final String NAME = "check timer";

    private Microwave microwave;

    public CheckTimerMicrowave(Microwave microwave) { this.microwave = microwave; }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("The timer is currently at: " + microwave.checkTimer() + " seconds");

    }

    @Override
    public String getName() { return NAME; }
}
