package Interfaces;

import java.util.ArrayList;

public interface Commandable {


    ArrayList<Command> getCommands();

    boolean stateHasChanged();

}
