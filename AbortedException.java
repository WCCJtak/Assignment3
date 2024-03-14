/** 
 * @Author: Jakob Tak
 * @Date: 14.03.2024
 * @Class: CS&145
 * @Assignment: Assignment3
 */

/**
 * The AbortedException class represents an exception that is thrown when an operation is aborted.
 */
public class AbortedException extends Exception {

    /**
     * Constructs a new AbortedException with the specified detail message.
     * @param message The detail message (which is saved for later retrieval by the getMessage() method)
     */
    public AbortedException(String message) {
        super(message);
    }
}
