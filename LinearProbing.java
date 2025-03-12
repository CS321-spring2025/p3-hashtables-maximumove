

public class LinearProbing extends Hashtable {

    int probe = 0;
    int m;

    public LinearProbing(int size, int prime) {
        super(size);
        m = prime;
    }

    @Override
    public void insert(HashObject[] hashTable, int key, Object value) {
        HashObject stock = new HashObject(value, key);
        for(int i=0; i<hashTable.length; i++) {
            probe = (key + i) % m;
            if (hashTable[probe].getStatus() == 0) {
                hashTable[probe].increaseDupCount();
            }
            if (hashTable[probe].getStatus() != 0) {
                hashTable[probe] = stock;
            }
        }
    }

    @Override
    public int find(HashObject[] hashTable, int key) {
        for (int i=0; i<hashTable.length; i++) {
            probe = (key + i) % m;
            if (hashTable[probe].getKey().equals(key)) {
                return probe;
            }
        }
        return -1;
    }

    @Override
    public void delete(HashObject[] hashTable, int key) {
        for (int i=0; i<hashTable.length; i++) {
            if (hashTable[i].getKey().equals(key)) {
                hashTable[i].setStatus(HashObject.status.DEL);
            }
        }
        System.out.println("key not in table");
    }
}
