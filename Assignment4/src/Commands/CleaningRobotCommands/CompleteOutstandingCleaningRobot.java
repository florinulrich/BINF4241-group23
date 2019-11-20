package Commands.CleaningRobotCommands;

import Devices.CleaningRobot;
import Interfaces.Command;

public class CompleteOutstandingCleaningRobot implements Command {

    public static final String NAME = "complete outstanding cleaning";
    private CleaningRobot cleaningRobot;

    public CompleteOutstandingCleaningRobot(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    @Override
    public void execute() {
        cleaningRobot.completeOutstandingCleaning();
    }

    @Override
    public String getName() {

        return NAME;
    }
}
