package Commands.CleaningRobotCommands;

import Devices.CleaningRobot;
import Interfaces.Command;

public class EndCleaningRobot implements Command {

    private static final String NAME = "switch off";

    private CleaningRobot cleaningRobot;

    public EndCleaningRobot(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    @Override
    public void execute() {
        cleaningRobot.endCleaning();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
