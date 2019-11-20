package Commands.CleaningRobotCommands;

import Devices.CleaningRobot;
import Interfaces.Command;


public class SetTimerRobot implements Command {

    private CleaningRobot robot;

    public SetTimerRobot(CleaningRobot robot) {

        this.robot = robot;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return null;
    }
}
