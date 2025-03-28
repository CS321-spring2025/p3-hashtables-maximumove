import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * This class holds a hash table that is linearly probed.
 * @author Troy Berhow
 */
public class LinearProbing extends Hashtable {

    // Instance variables.
    int probe = 0;
    int m;
    int dupCount;
    int currentDup;
    int currentProbeCount;
    int totalProbeCount;

    /**
     * Constructor of a new hash table based on linear probing.
     * @param int size of table.
     * @param int primary mod function prime.
     */
    public LinearProbing(int size, int prime) {
        super(size);
        m = prime;
        probe=0;
        dupCount=0;
        currentDup = 0;
        currentProbeCount=0;
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
            probe = ((positiveMod(key, table.length)) + i) % m;
            totalProbeCount++;
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
                dupCount++;
                table[probe].increaseDupCount();
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
            currentProbeCount++;
            totalProbeCount++;
            probe = ((positiveMod(key, table.length)) + i) % m;
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
            probe = ((positiveMod(key, table.length)) + i) % m;
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
        currentProbeCount = 0;
        System.out.println("key not in table");
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
