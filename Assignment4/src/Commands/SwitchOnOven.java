package Commands;

import Devices.Oven;
import Interfaces.Command;

public class SwitchOnOven implements Command {

    private static final String NAME = "Switch on";
    private Oven oven;

    public SwitchOnOven(Oven oven) {

        this.oven = oven;
    }

    @Override
    public void execute() {

        oven.switchOn();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
