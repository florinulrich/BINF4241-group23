package Commands.DishwasherCommands;

import Devices.Dishwasher;
import Interfaces.Command;

import java.util.Scanner;

public class SetProgramDishwasher implements Command {

    private static final String NAME = "set program";

    private Dishwasher dishwasher;

    public SetProgramDishwasher(Dishwasher dishwasher) { this.dishwasher = dishwasher; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter program (glasses [t=100], plates [t=50], pans [t=25] or mixed [t=125]) >> ");
        String program = myObj.next();

        int timer = 0;
        boolean programAvailable = true;
        switch (program.toLowerCase()) {
            case "glasses":
                timer = 100;
                break;
            case "plates":
                timer = 50;
                break;
            case "pans":
                timer = 25;
                break;
            case "mixed":
                timer = 125;
                break;
            default:
                System.out.println("This program is not available");
                programAvailable = false;
                break;
        }

        dishwasher.setTimerSeconds(timer);
        if (programAvailable) {
            dishwasher.setProgram(program);
        }

    }

    @Override
    public String getName() { return NAME; }
}
