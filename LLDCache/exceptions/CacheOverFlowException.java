// CacheOverFlowException.java
package exceptions;

public class CacheOverFlowException extends RuntimeException {
    public CacheOverFlowException() {
        super("Cache is full: Cannot add more items.");
    }
}
