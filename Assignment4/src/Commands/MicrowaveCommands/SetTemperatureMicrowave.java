package Commands.MicrowaveCommands;

import Devices.Microwave;
import Interfaces.Command;

import java.util.Scanner;

public class SetTemperatureMicrowave implements Command {

    private static final String NAME = "set temperature";
    Microwave microwave;

    public SetTemperatureMicrowave(Microwave microwave) { this.microwave = microwave; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter temperature (celsius) >> ");
        int temperature = Integer.parseInt(myObj.next().trim());

        microwave.setTemperature(temperature);

    }

    @Override
    public String getName() { return NAME; }
}

