package Commands.OvenCommands;

import Devices.Oven;
import Interfaces.Command;

import java.util.Scanner;

public class SetTemperatureOven implements Command {

    private static final String NAME = "set temperature";
    Oven oven;

    public SetTemperatureOven(Oven oven) { this.oven = oven; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter temperature (celsius) >> ");
        int temperature = Integer.parseInt(myObj.next().trim());

        oven.setTemperature(temperature);

    }

    @Override
    public String getName() { return NAME; }
}
