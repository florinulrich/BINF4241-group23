package Commands.DishwasherCommands;

import Devices.Dishwasher;
import Interfaces.Command;

public class SwitchOnDishwasher implements Command {

    private static final String NAME = "switch on";
    private Dishwasher dishwasher;

    public SwitchOnDishwasher(Dishwasher dishwasher) { this.dishwasher = dishwasher; }

    @Override
    public void execute() { dishwasher.switchOn(); }

    @Override
    public String getName() { return NAME; }
}
