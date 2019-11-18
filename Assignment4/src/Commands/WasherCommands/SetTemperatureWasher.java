package Commands.WasherCommands;

import Devices.Washer;
import Interfaces.Command;

import java.util.Scanner;

public class SetTemperatureWasher implements Command {

    private static final String NAME = "set temperature";
    Washer washer;

    public SetTemperatureWasher(Washer washer) { this.washer = washer; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter temperature [celsius] >> ");
        int temperature = Integer.parseInt(myObj.next().trim());

        washer.setTemperature(temperature);

    }

    @Override
    public String getName() { return NAME; }
}
