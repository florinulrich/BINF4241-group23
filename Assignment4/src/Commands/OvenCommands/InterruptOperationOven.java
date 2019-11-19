package Commands.OvenCommands;

import Devices.Oven;
import Interfaces.Command;
import Utilities.MyTimer;

public class InterruptOperationOven implements Command {

    private static final String NAME = "abort program";
    private Oven oven;

    public InterruptOperationOven(Oven oven) { this.oven = oven; }

    @Override
    public void execute() { oven.interruptOperation();
    }

    @Override
    public String getName() { return NAME; }
}
