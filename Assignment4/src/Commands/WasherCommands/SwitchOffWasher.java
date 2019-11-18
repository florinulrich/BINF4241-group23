package Commands.WasherCommands;

import Devices.Washer;
import Interfaces.Command;

public class SwitchOffWasher implements Command {

    private static final String NAME = "switch off";
    private Washer washer;

    public SwitchOffWasher(Washer washer) { this.washer = washer; }

    @Override
    public void execute() { washer.switchOff(); }

    @Override
    public String getName() { return NAME; }
}
