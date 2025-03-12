/**
 * Holds an exception for if one is encountered in the hash table.
 * @author Troy Berhow
 */
public class HashException extends Exception {
    /**
     * Makes an error with a displayed message as needed.
     * @param String message to display in case of an error
     */
    public HashException(String s) {
        super(s);
    }
}
