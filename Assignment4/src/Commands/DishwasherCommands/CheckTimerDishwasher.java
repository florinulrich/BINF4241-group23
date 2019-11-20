package Commands.DishwasherCommands;

import Devices.Dishwasher;
import Interfaces.Command;

public class CheckTimerDishwasher implements Command {

    private static final String NAME = "check timer";

    private Dishwasher dishwasher;

    public CheckTimerDishwasher(Dishwasher dishwasher) { this.dishwasher = dishwasher; }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("The timer is currently at: " + dishwasher.checkTimer() + " seconds");

    }

    @Override
    public String getName() { return NAME; }
}
