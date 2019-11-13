package Commands;

import Devices.Oven;
import Interfaces.Command;

public class StartCookingOven implements Command {

    private static final String NAME = "Start Cooking";
    private Oven oven;

    public StartCookingOven(Oven oven) {

        this.oven = oven;
    }

    @Override
    public void execute() {

        oven.startCooking();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
