import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
    int totalProbeCount;

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
            totalProbeCount = 0;
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
            totalProbeCount++;
            if (table[probe] == null) {
                table[probe] = stock;
                HashObject.status stat = HashObject.status.OCUPIED;
                table[probe].setStatus(stat);
                table[probe].setProbeCount(currentProbeCount);
                currentProbeCount = 0;
                return;
            }
            else if (table[probe].getStatus() == 0) {
                dupCount++;
                return;
            }
        }
        currentProbeCount = 0;
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
            currentProbeCount++;
            totalProbeCount++;
            if (table[probe] == null) {

            }
            else if (table[probe].getKey().equals(key) && table[probe].getStatus() == 0) {
                currentProbeCount = 0;
                return probe;
            }
        }
        currentProbeCount = 0;
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
            currentProbeCount++;
            totalProbeCount++;
            if (table[probe] == null) {

            }
            else if (table[probe].getKey().equals(key)) {
                table[probe].setStatus(HashObject.status.DEL);
                System.out.println("Removed at index " + probe);
                currentProbeCount = 0;
                return;
            }
        }
        System.out.println("key not in table");
        currentProbeCount = 0;
    }

    /**
     * Returns the number of duplicates in the hashtable
     * @return number of duplicates
     */
    public int getDupCount() {
        return dupCount;
    }

    /**
     * Returns the number of probes preformed on the hashtable.
     * @return number of probes
     */
    public int getProbeCount() {
        return totalProbeCount;
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

    public void dumpToFile(String fileName) {
        PrintWriter out;
        try {
            out = new PrintWriter(fileName);
            for (int i=0; i < table.length; i++) {
                if (table[i] == null) {

                }
                else if (table[i].getStatus() == 0) {
                    out.write(table[i].toString() + "\n");
                }
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Print Writer failed");
        }
    }
}
