package Exceptions;

//This error is thrown when a Checkmate occurs. Game class must catch it and terminate the program.

public class CheckmateException extends Exception {

    public CheckmateException() {
        super("One of the players has been checkmated");
    }
}
