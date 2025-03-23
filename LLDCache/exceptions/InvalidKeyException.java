package exceptions;

public class InvalidKeyException extends RuntimeException {
    public InvalidKeyException() {
        super("Invalid key: Key cannot be null.");
    }
}
