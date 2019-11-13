package Commands;

import Devices.Oven;
import Interfaces.Command;

public class StartCookingOven implements Command {

    public StartCookingOven(Oven oven) {
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return "Start Cooking";
    }
}
