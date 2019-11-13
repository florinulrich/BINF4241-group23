package Commands;

import Devices.Oven;
import Interfaces.Command;

public class InterruptOperationOven implements Command {

    private static final String NAME = "Abort Program";
    private Oven oven;

    public InterruptOperationOven(Oven oven) {

        this.oven = oven;
    }

    @Override
    public void execute() {
        oven.interruptOperation();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
