package Commands.MicrowaveCommands;

import Devices.Microwave;
import Exceptions.TemperatureException;
import Interfaces.Command;

import java.util.Scanner;

public class SetTemperatureMicrowave implements Command {

    private static final String NAME = "set temperature";
    private Microwave microwave;

    public SetTemperatureMicrowave(Microwave microwave) { this.microwave = microwave; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter temperature (celsius) >> ");
        int temperature = Integer.parseInt(myObj.next().trim());

        try{
            if(temperature <= 0 ^ temperature >= 300){
                throw new TemperatureException();
            } else {
                microwave.setTemperature(temperature);
            }
        }
        catch (TemperatureException exception){
            System.out.println("The temperature you entered is not available");
        }

    }

    @Override
    public String getName() { return NAME; }
}

