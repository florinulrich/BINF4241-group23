package Commands.Washer;

import Devices.Washer;
import Interfaces.Command;

public class SwitchOnWasher implements Command {

    private static final String NAME = "switch on";
    private Washer washer;

    public SwitchOnWasher(Washer washer) { this.washer = washer; }

    @Override
    public void execute() { washer.switchOn(); }

    @Override
    public String getName() { return NAME; }
}
