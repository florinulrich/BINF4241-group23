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
    private Scanner scanner = new Scanner(System.in);

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

        //Update Commands before new display
        updateCommands();

        //Observe Commandable for Change
        ObserveCommandable observer = new ObserveCommandable();
        Thread observerThread = new Thread(observer);
        observerThread.start();

        //Print and get Input
        System.out.println("-------------------------");
        System.out.println("> " + name);
        System.out.println("-------------------------");


        int i = 1;
        for (Command command: commands) {
            System.out.println("("+ i + ") " + command.getName());
            i++;
        }
        System.out.println("(enter 0 to return)");

        System.out.print("Enter your wish, master >> ");
        int command = Integer.parseInt(scanner.next().trim());

        if (command <= commands.size() && command > 0) {
            commands.get(command - 1).execute();
        }
        else if (command == 0) {
            return;
        }
        else {
            System.out.println("This is not a valid option!");
        }

        //Kill observerThread
        observerThread.interrupt();

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

    private class ObserveCommandable implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (device.stateHasChanged()) {
                    break;
                }
            }
            updateCommands();
            //TODO: Exit scanner safely
        }
    }

}
