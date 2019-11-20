package Utilities;

import Interfaces.Command;

import java.util.ArrayList;
import java.util.Scanner;

public class Smartphone {

    //Variables
    private ArrayList<Command> commands;
    private boolean quitProgram = false;

    //Constructors
    public Smartphone() {
        commands = new ArrayList<>();
    }

    //Methods
    public void display() {
        System.out.println("--------------------");
        System.out.println("My Home");
        System.out.println("--------------------");
        int i = 1;
        for (Command command: commands) {
            System.out.println(i + ". " + command.getName());
            i++;
        }

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter your wish, master >> ");
        int command = Integer.parseInt(myObj.next().trim());

        //TODO: Is this a desired feature, should it stay hidden or be removed?
        if (command == 0) {
            quitProgram = true;
        }

        if (command <= commands.size() && command > 0) {
            commands.get(command - 1).execute();
        } else {
            System.out.println("This is not a valid option!");
        }
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public boolean quitProgram() {
        return quitProgram;
    }
}
