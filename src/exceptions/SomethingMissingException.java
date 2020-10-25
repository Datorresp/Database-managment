package exceptions;

public class SomethingMissingException extends Exception {

    public SomethingMissingException() {
        super("Something is missing");
    }
}
