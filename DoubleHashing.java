/**
 * This class holds a hash table that is double hashed.
 * @author Troy Berhow
 */
public class DoubleHashing extends Hashtable {

    // Instance variables.
    int probe = 0;
    int m;
    int n;

    /**
     * Constructor of a new hash table that is double hashed.
     * @param int size of table.
     * @param int primary mod function prime.
     * @param int secondary mod function prime.
     */
    public DoubleHashing(int size, int bigPrime, int smallPrime) {
            super(size);
            m = bigPrime;
            n = smallPrime;
        }
    
    /**
     * Inserts a new hash object into the hash table.
     * @param Object[] hashTable in an array form.
     * @param int key value of the new Hash Object.
     * @param int value of the inserted Hash Object.
     * @throws HashException
     */
    @Override
    public void insert(HashObject[] hashTable, int key, Object value) throws HashException {
        HashObject stock = new HashObject(value, key);
        for(int i=0; i<hashTable.length; i++) {
            probe = ((key % m) + i * (1 + (key % (n - 2)) % n)) % m;
            if (hashTable[probe].getStatus() == 0) {
                hashTable[probe].increaseDupCount();
            }
            if (hashTable[probe].getStatus() != 0) {
                hashTable[probe] = stock;
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
    public int find(HashObject[] hashTable, int key) {
        for (int i=0; i<hashTable.length; i++) {
            probe = ((key % m) + i * (1 + (key % (n - 2)) % n)) % m;
            if (hashTable[probe].getKey().equals(key) && hashTable[probe].getStatus() == 0) {
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
    public void delete(HashObject[] hashTable, int key) {
        for (int i=0; i<hashTable.length; i++) {
            probe = ((key % m) + i * (1 + (key % (n - 2)) % n)) % m;
            if (hashTable[probe].getKey().equals(key)) {
                hashTable[probe].setStatus(HashObject.status.DEL);
            }
        }
        System.out.println("key not in table");
    }
    
}
