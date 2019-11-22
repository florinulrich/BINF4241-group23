package Commands.OvenCommands;

import Devices.Oven;
import Interfaces.Command;

import java.util.Scanner;

public class SetProgramOven implements Command {

    private static final String NAME = "set program";
    private Oven oven;

    public SetProgramOven(Oven oven) { this.oven = oven; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter program (ventilated, grill, baking) >> ");
        String program = myObj.next();
        boolean programAvailable = true;

        switch (program.toLowerCase()){
            case "ventilated":
            case "grill":
            case "baking":
                break;
            default:
                System.out.println("This program is not available");
                programAvailable = false;
                break;
        }

        if (programAvailable) {
            oven.setProgram(program);
        }
    }

    @Override
    public String getName() {return NAME; }
}
