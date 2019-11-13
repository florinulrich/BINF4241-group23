package Commands;

import Devices.Oven;
import Interfaces.Command;

public class SetTemperatureCommand implements Command {

    Oven oven;
    public SetTemperatureCommand(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {
        //TODO: Get Input
        int temp = 129;

        oven.setTemperature(temp);

    }

    @Override
    public String getName() {
        return null;
    }
}
