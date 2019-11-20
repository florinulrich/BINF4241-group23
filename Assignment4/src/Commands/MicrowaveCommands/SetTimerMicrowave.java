package Commands.MicrowaveCommands;

import Devices.Microwave;
import Interfaces.Command;

import java.util.Scanner;

public class SetTimerMicrowave implements Command {

    private static final String NAME = "set timer";

    private Microwave microwave;

    public SetTimerMicrowave(Microwave microwave) { this.microwave = microwave; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter timer (sec) >> ");
        int timer = Integer.parseInt(myObj.next().trim());

        microwave.setTimerSeconds(timer);

    }

    @Override
    public String getName() { return NAME; }
}
