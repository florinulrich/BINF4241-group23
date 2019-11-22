package Commands.WasherCommands;

import Devices.Washer;
import Exceptions.TemperatureException;
import Interfaces.Command;

import java.util.Scanner;

public class SetTemperatureWasher implements Command {

    private static final String NAME = "set temperature";
    private Washer washer;

    public SetTemperatureWasher(Washer washer) { this.washer = washer; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter temperature (celsius) >> ");
        int temperature = Integer.parseInt(myObj.next().trim());

        try{
            if(temperature <= 0 ^ temperature >= 150){
                throw new TemperatureException();
            } else {
                washer.setTemperature(temperature);
            }
        }
        catch (TemperatureException exception){
            System.out.println("The temperature you entered is not available");
        }

    }

    @Override
    public String getName() { return NAME; }
}
