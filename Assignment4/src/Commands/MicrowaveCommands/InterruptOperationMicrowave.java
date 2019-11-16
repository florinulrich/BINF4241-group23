package Commands.MicrowaveCommands;

import Devices.Microwave;
import Interfaces.Command;

public class InterruptOperationMicrowave implements Command{

    private static final String NAME = "abort program";
    private Microwave microwave;

    public InterruptOperationMicrowave(Microwave microwave) { this.microwave = microwave; }

    @Override
    public void execute() {
        microwave.interruptOperation();
    }

    @Override
    public String getName() { return NAME; }
}
