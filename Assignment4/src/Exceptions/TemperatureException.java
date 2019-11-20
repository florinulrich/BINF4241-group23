package Exceptions;

//This error is thrown when the user tries to set a temperature that is either too high or too low

public class TemperatureException extends Exception {

    public TemperatureException(String errorMessage) {
        super("You can only set a temperature between 0 and 300");
    }
}
