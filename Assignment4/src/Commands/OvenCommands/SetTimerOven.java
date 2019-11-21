package Commands.OvenCommands;

import Devices.Oven;
import Interfaces.Command;

import java.util.Scanner;

public class SetTimerOven implements Command {

    private static final String NAME = "set timer";

    private Oven oven;

    public SetTimerOven(Oven oven) { this.oven = oven; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter timer (sec) >> ");
        int timer = Integer.parseInt(myObj.next().trim());

        oven.setTimerSeconds(timer);

    }

    @Override
    public String getName() { return NAME; }
}