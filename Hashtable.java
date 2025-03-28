import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * This is an abstract class that holds the structure and methods for a hash table.
 * @author Troy Berhow
 */
public abstract class Hashtable {
    //instance variables
    protected HashObject[] table;

    /**
     * constructor of a new Hastable with a given size
     * @param int size of the table
     */
    public Hashtable(int size) {
        table = new HashObject[size];
    }

    /**
     * Inserts a new hash object into the hash table.
     * @param Object[] hashTable in an array form.
     * @param int key value of the new Hash Object.
     * @param int value of the inserted Hash Object.
     * @throws HashException
     */
    public abstract void insert(int key, Object value) throws HashException;

    /**
     * Determines in a hash object is in the hash table.
     * @param HashObject[] array representing hash table.
     * @param int key of the hash object to be searched.
     * @return -1 if object is not found, and index of array if it is found.
     */
    public abstract int find(int key);

    /**
     * Deletes a given hash object if it is found in the table.
     * @param HashObject[] array representing the table.
     * @param int key of the hash object to be deleted.
     */
    public abstract void delete(int key);

    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0) {
            quotient += divisor;
        }
        return quotient;
    }

    public abstract void dumpToFile(String fileName);
        

    /**
     * Returns a string representation of the Hash Table.
     * @return string representing the table.
     */
    public abstract String toString();
    // public String toString() {
    //     String str = "";
    //     for (int i=0; i<table.length; i++) {
    //         if (table[i] == null) {
                
    //         }
    //         else if (table[i].getStatus() == 0) {
    //             str += table[i].toString() + "/n";
    //         }
    //     }
    //     return str;
    // }
}
