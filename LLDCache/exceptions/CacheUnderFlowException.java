package exceptions;

public class CacheUnderFlowException extends RuntimeException {
    public CacheUnderFlowException(String message) {
        super(message);
    }
}
