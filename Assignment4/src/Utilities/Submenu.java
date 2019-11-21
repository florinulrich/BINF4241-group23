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
    private void updateCommands() {
        commands = device.getCommands();
    }

    private void display() {

        //Because the display is being refreshed, it takes the newest state of the device
        // therefore its state is accepted
        device.acceptState();

        //Update Commands before new display
        updateCommands();

        //Observe Commandable for Change
        ObserveCommandable observer = new ObserveCommandable();
        Thread observerThread = new Thread(observer);
        observerThread.start();

        //Print and get Input
        print();

        int command = Integer.parseInt(scanner.next().trim());

        if (command <= commands.size() && command > 0) {
            commands.get(command - 1).execute();
        } else if (command == 0) {
            observer.stop();
            return;
        } else {
            System.out.println("This is not a valid option!");
        }

        //Kill observerThread
        observer.stop();

        display();
    }

    private void print() {
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("> " + name);
        System.out.println("-------------------------");


        int i = 1;
        for (Command command: commands) {
            System.out.println("("+ i + ") " + command.getName());
            i++;
        }

        System.out.println("(enter 0 to return)");
        System.out.println("-------------------------");
        System.out.print("Enter your wish, master >> ");
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

        private boolean stop = false;

        @Override
        public void run() {
            while (!stop) {
                while (!device.stateHasChanged() && !stop) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (device.stateHasChanged()) {
                    updateCommands();
                    print();
                    device.acceptState();
                }
            }
        }

        void stop() {
            stop = true;
        }
    }

}
