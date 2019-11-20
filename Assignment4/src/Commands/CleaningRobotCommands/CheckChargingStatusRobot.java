package Commands.CleaningRobotCommands;

import Devices.CleaningRobot;
import Interfaces.Command;

public class CheckChargingStatusRobot implements Command {

    private static final String NAME = "check charging status";

    private CleaningRobot cleaningRobot;

    public CheckChargingStatusRobot(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    @Override
    public void execute() {
        System.out.println("charging status: " + cleaningRobot.checkChargingStatus() + "%");
    }

    @Override
    public String getName() {

        return NAME;
    }
}
