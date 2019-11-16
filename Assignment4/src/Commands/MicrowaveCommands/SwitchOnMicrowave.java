package Commands.MicrowaveCommands;

import Interfaces.Command;
import Devices.Microwave;

public class SwitchOnMicrowave implements Command {

    private static final String NAME = "switch on";
    private Microwave microwave;

    public SwitchOnMicrowave(Microwave microwave) { this.microwave = microwave; }

    @Override
    public void execute() { microwave.switchOn(); }

    @Override
    public String getName() { return NAME; }
}
