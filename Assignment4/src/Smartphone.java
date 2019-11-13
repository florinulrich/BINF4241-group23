import Interfaces.Command;

import java.util.ArrayList;
import java.util.Scanner;

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

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter your wish, master >> ");
        int command = Integer.parseInt(myObj.next().trim());

        if (command <= commands.size() && command > 0) {
            commands.get(command - 1).execute();
        }
        else {
            System.out.println("This is not a valid option!");
            display();
        }


    }

    void addCommand(Command command) {
        commands.add(command);
    }
}
