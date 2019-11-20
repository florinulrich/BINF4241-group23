package Commands.CleaningRobotCommands;

import Devices.CleaningRobot;
import Interfaces.Command;

import java.util.Scanner;


public class SetTimerRobot implements Command {

    private static final String NAME = "set timer";

    private CleaningRobot cleaningRobot;

    public SetTimerRobot(CleaningRobot cleaningRobot) {

        this.cleaningRobot = cleaningRobot;
    }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("enter timer [sec] >> ");
        int timer = Integer.parseInt(myObj.next().trim());

        cleaningRobot.setTimerSeconds(timer);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
