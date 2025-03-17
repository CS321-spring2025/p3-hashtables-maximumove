/**
 * This class holds the logic for an object that goes into the hash table.
 * @author Troy Berhow
 */
public class HashObject {
    
    /**
     * A status enum to determine in a spot in the table is occupied, deleted, or empty.
     */
    public enum status {
        OCUPIED(0), 
        DEL(1), 
        EMPTY(2);
        
        private final int returnValue;
        status(int value) {
            returnValue = value;
        }

        public int getRetVal() {
            return returnValue;
        }
    }

    // Instance variables
    Object object;
    Object key;
    int frequency;
    int probeCount;
    status stat;

    /**
     * Constructor of a new hash object.
     * @param Object value of the new hash object
     * @param Object key of the new hash object
     */
    public HashObject(Object o, Object k) {
        object = o;
        key = k;
        frequency = 0;
        probeCount = 0;
        stat = status.EMPTY;
    }

    /**
     * Compares two objects to each other, and increments frequency if they do equal.
     * @return true if the objects are the same, false if they are not.
     */
    public boolean equals(Object compare) {
        if (key.equals(compare)) {
            frequency++;
            return true;
        }
        return false;
    }

    /**
     * Returns the status enum of the hash object.
     * @return return value of the status of the hash object.
     */
    public int getStatus() {
        return stat.returnValue;
    }

    /**
     * Changes the status of the hash object.
     * @param status new status of the hash object.
     */
    public void setStatus(status newStatus) {
        stat = newStatus;
    }

    /**
     * Returns the key value of the hash object.
     * @return key object of the hash object.
     */
    public Object getKey() {
        return key;
    }

    /**
     * Increses the frequency of a given hash object.
     */
    public void increaseDupCount() {
        frequency = frequency + 1;
    }

    public int getDupCount() {
        return frequency;
    }

    public void setProbeCount(int newCount) {
        probeCount = newCount;
    }

    public int getProbeCount() {
        return probeCount;
    }

    /**
     * returns out a string representation of the given hash object.
     * @return string representing hash object
     */
    public String toString() {
        String str = "";
        str += object + " key value: " + key + " duplicates: " + frequency + " probe count: " + probeCount;
        return str;
    }
}
