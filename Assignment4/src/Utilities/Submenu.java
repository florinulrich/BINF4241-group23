package Utilities;

import Interfaces.Command;
import Interfaces.Commandable;

import java.util.ArrayList;
import java.util.Scanner;

public class Submenu implements Command {

    //Variables
    private String name;
    private Commandable device;
    private ArrayList<Command> commands;

    //Constructor
    public Submenu(String name, Commandable device) {
        this.name = name;
        commands = new ArrayList<>();
        this.device = device;
        updateCommands();
    }

    //Methods
    void updateCommands() {
        commands = device.getCommands();
    }

    void display() {
        System.out.println("--------------------");
        System.out.println(name);
        System.out.println("--------------------");

        System.out.println("0. return");
        int i = 1;
        for (Command command: commands) {
            System.out.println(i + ". " + command.getName());
            i++;
        }

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter your wish, master >> ");
        int command = Integer.parseInt(myObj.next().trim());

        if (command <= commands.size() && command > 0) {
            commands.get(command - 1).execute();
            updateCommands();
        }
        else if (command == 0) {
            return;
        }
        else {
            System.out.println("This is not a valid option!");
        }

        display();

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
