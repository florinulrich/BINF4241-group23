package Commands.CleaningRobotCommands;

import Devices.CleaningRobot;
import Interfaces.Command;

public class StartCleaningRobot implements Command {

    private static final String NAME = "start cleaning";

    private CleaningRobot cleaningRobot;

    public StartCleaningRobot(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    @Override
    public void execute() {
        cleaningRobot.startCleaning();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
