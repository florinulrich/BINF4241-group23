package Commands.DishwasherCommands;

import Devices.Dishwasher;
import Interfaces.Command;

public class StartWashingDishwasher implements Command {

    private static final String NAME = "start washing";

    private Dishwasher dishwasher;

    public StartWashingDishwasher(Dishwasher dishwasher) { this.dishwasher = dishwasher; }

    @Override
    public void execute() { dishwasher.startWashing(); }

    @Override
    public String getName() { return NAME; }
}
