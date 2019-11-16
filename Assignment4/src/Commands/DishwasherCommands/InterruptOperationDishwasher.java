package Commands.DishwasherCommands;

import Devices.Dishwasher;
import Interfaces.Command;

public class InterruptOperationDishwasher implements Command{

    private static final String NAME = "abort program";
    private Dishwasher dishwasher;

    public InterruptOperationDishwasher(Dishwasher dishwasher) { this.dishwasher = dishwasher; }

    @Override
    public void execute() {
        dishwasher.interruptOperation();
    }

    @Override
    public String getName() { return NAME; }
}
