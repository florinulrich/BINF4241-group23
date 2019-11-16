package Commands.DishwasherCommands;

import Devices.Dishwasher;
import Interfaces.Command;

import java.util.Scanner;

public class StartWashingDishwasher implements Command {

    private static final String NAME = "start baking";

    private Dishwasher dishwasher;

    public StartWashingDishwasher(Dishwasher dishwasher) { this.dishwasher = dishwasher; }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter program (glasses [t=100], plates [t=50], pans [t=25] or mixed [t=125]) >> ");
        String program = myObj.next();

        int timer = 0;
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
                System.out.println("invalid program!");
        }

        dishwasher.setTimerSeconds(timer);

        dishwasher.startWashing();

    }

    @Override
    public String getName() { return NAME; }
}
