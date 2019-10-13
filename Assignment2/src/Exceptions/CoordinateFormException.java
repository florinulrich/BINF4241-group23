package Exceptions;

public class CoordinateFormException extends Exception {

    public CoordinateFormException() {
        super("Could not initialize Coordinate, input invalid!");
    }
}
