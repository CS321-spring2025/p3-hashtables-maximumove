public class HashObject {
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

    Object object;
    Object key;
    int frequency;
    int probeCount;
    status stat;

    public HashObject(Object o, Object k) {
        object = o;
        key = k;
        frequency = 0;
        probeCount = 0;
        stat = status.DEL;
    }

    public boolean equals(Object compare) {
        if (key.equals(compare)) {
            frequency++;
            return true;
        }
        return false;
    }

    public int getStatus() {
        return stat.returnValue;
    }

    public void setStatus(status newStatus) {
        stat = newStatus;
    }

    public Object getKey() {
        return key;
    }

    public String toString() {
        String str = "";
        str += object + " key value: " + key + " duplicates: " + frequency + " probe count: " + probeCount;
        return str;
    }
}
