package Commands.MicrowaveCommands;

import Interfaces.Command;
import Devices.Microwave;

public class SwitchOffMicrowave implements Command {

    private static final String NAME = "switch off";
    private Microwave microwave;

    public SwitchOffMicrowave(Microwave microwave) { this.microwave = microwave; }

    @Override
    public void execute() { microwave.switchOff(); }

    @Override
    public String getName() { return NAME; }
}
