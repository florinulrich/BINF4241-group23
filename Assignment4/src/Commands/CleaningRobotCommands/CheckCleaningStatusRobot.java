package Commands.CleaningRobotCommands;

import Devices.CleaningRobot;
import Interfaces.Command;

public class CheckCleaningStatusRobot implements Command {

    private static final String NAME = "check cleaning status";

    private CleaningRobot cleaningRobot;

    public CheckCleaningStatusRobot(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("cleaning status: " + cleaningRobot.checkCleaningStatus() + "%");
    }

    @Override
    public String getName() {

        return NAME;
    }
}
