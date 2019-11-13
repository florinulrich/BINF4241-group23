package Commands;

import Devices.Oven;
import Interfaces.Command;

public class CheckTimerOven implements Command {

    private static final String NAME = "Check Timer";

    private Oven oven;

    public CheckTimerOven(Oven oven) {

        this.oven = oven;
    }

    @Override
    public void execute() {

        oven.checkTimer();

    }

    @Override
    public String getName() {
        return NAME;
    }
}
