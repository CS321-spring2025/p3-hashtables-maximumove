/**
 * This class holds a hash table that is linearly probed.
 * @author Troy Berhow
 */
public class LinearProbing extends Hashtable {

    // Instance variables.
    int probe = 0;
    int m;

    /**
     * Constructor of a new hash table based on linear probing.
     * @param int size of table.
     * @param int primary mod function prime.
     */
    public LinearProbing(int size, int prime) {
        super(size);
        m = prime;
    }

     /**
     * Inserts a new hash object into the hash table.
     * @param Object[] hashTable in an array form.
     * @param int key value of the new Hash Object.
     * @param int value of the inserted Hash Object.
     * @throws HashException
     */
    @Override
    public void insert(int key, Object value) {
        HashObject stock = new HashObject(value, key);
        for(int i=0; i<table.length; i++) {
            probe = (key + i) % m;
            if (table[probe] == null) {
                table[probe] = stock;
                HashObject.status stat = HashObject.status.OCUPIED;
                table[probe].setStatus(stat);
                return;
            }
            else if (table[probe].getStatus() == 0) {
                table[probe].increaseDupCount();
                return;
            }
        }
    }

     /**
     * Determines in a hash object is in the hash table.
     * @param HashObject[] array representing hash table.
     * @param int key of the hash object to be searched.
     * @return -1 if object is not found, and index of array if it is found.
     */
    @Override
    public int find(int key) {
        for (int i=0; i<table.length; i++) {
            probe = ((key % m) + i) % m;
            if (table[probe] == null) {

            }
            else if (table[probe].getKey().equals(key) && table[probe].getStatus() == 0) {
                return probe;
            }
        }
        return -1;
    }

      /**
     * Deletes a given hash object if it is found in the table.
     * @param HashObject[] array representing the table.
     * @param int key of the hash object to be deleted.
     */
    @Override
    public void delete(int key) {
        for (int i=0; i<table.length; i++) {
            probe = ((key % m) + i) % m;
            if (table[probe] == null) {

            }
            else if (table[probe].getKey().equals(key)) {
                table[probe].setStatus(HashObject.status.DEL);
                System.out.println("Removed at index " + probe);
                return;
            }
        }
        System.out.println("key not in table");
    }

    public String toString() {
        String str = "";
        for (int i=0; i<table.length; i++) {
            if (table[i] == null) {
                
            }
            else if (table[i].getStatus() == 0) {
                str += table[i].toString() + " At table index " + i + "\n";
            }
        }
        return str;
    }
}
