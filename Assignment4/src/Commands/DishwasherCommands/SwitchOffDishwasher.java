package Commands.DishwasherCommands;

import Devices.Dishwasher;
import Interfaces.Command;

public class SwitchOffDishwasher implements Command {

    private static final String NAME = "switch off";
    private Dishwasher dishwasher;

    public SwitchOffDishwasher(Dishwasher dishwasher) { this.dishwasher = dishwasher; }

    @Override
    public void execute() { dishwasher.switchOff(); }

    @Override
    public String getName() { return NAME; }
}
