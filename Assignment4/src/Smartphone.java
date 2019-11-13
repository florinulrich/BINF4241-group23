import Interfaces.Command;

import java.util.ArrayList;

public class Smartphone {

    //Variables
    private ArrayList<Command> commands;

    //Constructors
    public Smartphone() {
        commands = new ArrayList<>();
    }

    //Methods
    void display() {
        System.out.println("--------------------");
        System.out.println("My Home");
        System.out.println("--------------------");
        int i = 1;
        for (Command command: commands) {
            System.out.println(i + ". " + command.getName());
            i++;
        }

        //TODO: Get User input now
    }

    void addSubmenu(Submenu submenu) {
        commands.add(submenu);
    }
}
