package Commands;

import Devices.Oven;
import Interfaces.Command;

public class SwitchOffOvenCommand implements Command {

    private static final String NAME = "Switch off";
    private Oven oven;

    public SwitchOffOvenCommand(Oven oven) {

        this.oven = oven;
    }

    @Override
    public void execute() {

        oven.switchOff();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
