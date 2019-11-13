package Commands;

import Devices.Oven;
import Interfaces.Command;

import java.util.Scanner;

public class SetTemperatureOven implements Command {

    Oven oven;
    public SetTemperatureOven(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter temperature [celsius] >> ");
        int temperature = Integer.parseInt(myObj.next().trim());

        oven.setTemperature(temperature);

    }

    @Override
    public String getName() {
        return null;
    }
}
