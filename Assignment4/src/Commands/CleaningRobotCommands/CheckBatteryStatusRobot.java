package Commands.CleaningRobotCommands;

import Devices.CleaningRobot;
import Interfaces.Command;

public class CheckBatteryStatusRobot implements Command {

    private static final String NAME = "check battery status";

    private CleaningRobot cleaningRobot;

    public CheckBatteryStatusRobot(CleaningRobot cleaningRobot) {
        this.cleaningRobot = cleaningRobot;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("battery status: " + cleaningRobot.checkBatteryStatus() + "%");
    }

    @Override
    public String getName() {
        return NAME;
    }
}
