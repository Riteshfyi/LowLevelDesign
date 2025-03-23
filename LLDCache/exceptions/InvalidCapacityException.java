// InvalidCapacityException.java
package exceptions;

public class InvalidCapacityException extends RuntimeException {
    public InvalidCapacityException() {
        super("Invalid capacity: Capacity must be non-negative.");
    }
}
