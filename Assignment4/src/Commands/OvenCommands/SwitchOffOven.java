package Commands.OvenCommands;

import Devices.Oven;
import Interfaces.Command;

public class SwitchOffOven implements Command {

    private static final String NAME = "switch off";
    private Oven oven;

    public SwitchOffOven(Oven oven) { this.oven = oven; }

    @Override
    public void execute() { oven.switchOff(); }

    @Override
    public String getName() { return NAME; }
}
