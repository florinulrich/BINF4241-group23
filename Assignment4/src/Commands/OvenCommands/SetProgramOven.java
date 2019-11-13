package Commands.OvenCommands;

import Devices.Oven;
import Interfaces.Command;

import java.util.Scanner;

public class SetProgramOven implements Command {

    private static final String NAME = "set program";
    Oven oven;

    public SetProgramOven(Oven oven) { this.oven = oven; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter program [ventilated, grill, etc.] >> ");
        String program = myObj.next();

        oven.setProgram(program);

    }

    @Override
    public String getName() {return NAME; }
}
