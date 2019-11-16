package Commands.Washer;

import Devices.Washer;
import Interfaces.Command;

import java.util.Scanner;

public class SetProgramWasher implements Command {

    private static final String NAME = "set program";

    private Washer washer;

    public SetProgramWasher(Washer washer) { this.washer = washer; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter program (double, rinse, intense, quick or spin) >> ");
        String program = myObj.next();

        int timer = 0;
        switch (program.toLowerCase()) {
            case "double":
                timer = 100;
                break;
            case "rinse":
                timer = 50;
                break;
            case "intense":
                timer = 200;
                break;
            case "quick":
                timer = 25;
                break;
            case "spin":
                timer = 75;
                break;
            default:
                break;
        }

        washer.setTimerSeconds(timer);
        washer.setProgram(program);

    }

    @Override
    public String getName() { return NAME; }
}
