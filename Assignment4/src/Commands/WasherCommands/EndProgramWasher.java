package Commands.WasherCommands;

//This Command is never given to the User, but will be called at the end of the program,
// as it is done in the other devices

import Devices.Washer;
import Interfaces.Command;

public class EndProgramWasher implements Command {

    private static final String NAME = "Interruption Command: For internal Use only!";
    private Washer washer;

    public EndProgramWasher(Washer washer) {
        this.washer = washer;
    }

    @Override
    public void execute() {
        washer.endProgram();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
