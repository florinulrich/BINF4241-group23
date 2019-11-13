import Interfaces.Command;
import Interfaces.Commandable;

import java.util.ArrayList;

class Submenu implements Command {

    //Variables
    private String name;
    private Commandable device;
    private ArrayList<Command> commands;

    //Constructor
    Submenu(String name) {
        this.name = name;
    }

    //Methods
    void updateCommands() {
        commands = device.getCommands();
    }

    void display() {
        System.out.println("--------------------");
        System.out.println(name);
        System.out.println("--------------------");

        int i = 1;
        for (Command command: commands) {
            System.out.println(i + ". " + command.getName());
            i++;
        }

        //TODO: Get User Input now
        //TODO: Return to main menu
    }

    @Override
    public void execute() {
        display();
    }

    @Override
    public String getName() {
        return name;
    }

    void setDevice(Commandable device) {
        this.device = device;
        updateCommands();
    }

}
