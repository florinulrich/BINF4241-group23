package Commands.MicrowaveCommands;

import Devices.Microwave;
import Interfaces.Command;

public class StartBakingMicrowave implements Command {

    private static final String NAME = "start baking";

    private Microwave microwave;

    public StartBakingMicrowave(Microwave microwave) { this.microwave = microwave; }

    @Override
    public void execute() { microwave.startBaking(); }

    @Override
    public String getName() { return NAME; }
}
