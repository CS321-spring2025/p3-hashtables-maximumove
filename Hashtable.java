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
    public abstract void insert(HashObject[] hashTable, int key, Object value) throws HashException;

    /**
     * Determines in a hash object is in the hash table.
     * @param HashObject[] array representing hash table.
     * @param int key of the hash object to be searched.
     * @return -1 if object is not found, and index of array if it is found.
     */
    public abstract int find(HashObject[] hashTable, int key);

    /**
     * Deletes a given hash object if it is found in the table.
     * @param HashObject[] array representing the table.
     * @param int key of the hash object to be deleted.
     */
    public abstract void delete(HashObject[] hashTable, int key);

    /**
     * Returns a string representation of the Hash Table.
     * @return string representing the table.
     */
    public String toString() {
        String str = "";
        for (int i=0; i<table.length; i++) {
            if (table[i].getStatus() == 0) {
                str += table[i].toString() + "/n";
            }
        }
        return str;
    }
}
