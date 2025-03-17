/**
 * This class holds a hash table that is double hashed.
 * @author Troy Berhow
 */
public class DoubleHashing extends Hashtable {

    // Instance variables.
    int probe;
    int m;
    int n;
    int dupCount;
    int currentProbeCount;

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
            dupCount=0;
            probe=0;
            currentProbeCount = 0;
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
            probe =((positiveMod(key, table.length)) + i * (1 + positiveMod(key, table.length - 2) % n)) % m;
            currentProbeCount++;
            if (table[probe] == null) {
                table[probe] = stock;
                HashObject.status stat = HashObject.status.OCUPIED;
                table[probe].setStatus(stat);
                table[probe].setProbeCount(currentProbeCount);
                currentProbeCount = 0;
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
            probe = ((positiveMod(key, table.length)) + i * (1 + positiveMod(key, table.length - 2) % n)) % m;
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
            probe = ((positiveMod(key, table.length)) + i * (1 + positiveMod(key, table.length - 2) % n)) % m;
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
