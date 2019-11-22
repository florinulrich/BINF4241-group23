package Commands.OvenCommands;

import Devices.Oven;
import Exceptions.TemperatureException;
import Interfaces.Command;

import java.util.Scanner;

public class SetTemperatureOven implements Command {

    private static final String NAME = "set temperature";
    private Oven oven;

    public SetTemperatureOven(Oven oven) { this.oven = oven; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter temperature (celsius) >> ");
        int temperature = Integer.parseInt(myObj.next().trim());

        try{
            if(temperature <= 0 ^ temperature >= 300){
                throw new TemperatureException();
            } else {
                oven.setTemperature(temperature);
            }
        }
        catch (TemperatureException exception){
            System.out.println("The temperature you entered is not available");
        }

    }

    @Override
    public String getName() { return NAME; }
}
