package Exceptions;

public class IllegalMoveException extends Exception{

    public IllegalMoveException() {
        super("Interfaces.Piece can not perform this move");
    }
}
