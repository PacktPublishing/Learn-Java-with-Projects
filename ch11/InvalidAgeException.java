package ch11;

public class InvalidAgeException extends Exception {
    public InvalidAgeException() {
        super();
    }

    public InvalidAgeException(String message) {
        super(message);
    }

    public InvalidAgeException(Exception e) {
        super(e);
    }
}
