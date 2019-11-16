package Commands.DishwasherCommands;

import Devices.Dishwasher;
import Interfaces.Command;

public class SwitchOnDishwasher implements Command {

    private static final String NAME = "switched on";
    private Dishwasher dishwasher;

    public SwitchOnDishwasher(Dishwasher Dishwasher) { this.dishwasher = dishwasher; }

    @Override
    public void execute() { dishwasher.switchOn(); }

    @Override
    public String getName() { return NAME; }
}
