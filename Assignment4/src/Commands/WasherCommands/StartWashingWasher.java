package Commands.WasherCommands;

import Devices.Washer;
import Interfaces.Command;

public class StartWashingWasher implements Command {

    private static final String NAME = "start washing";

    private Washer washer;

    public StartWashingWasher(Washer washer) { this.washer = washer; }

    @Override
    public void execute() { washer.startWashing(); }

    @Override
    public String getName() { return NAME; }
}
