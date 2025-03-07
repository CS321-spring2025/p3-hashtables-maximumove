public class HashObject {
    Object object;
    Object key;
    int frequency;
    int probeCount;

    public HashObject(Object o, Object k) {
        object = o;
        key = k;
        frequency = 0;
        probeCount = 0;
    }

    public boolean equals(Object compare) {
        if (key.equals(compare)) {
            frequency++;
            return true;
        }
        return false;
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
