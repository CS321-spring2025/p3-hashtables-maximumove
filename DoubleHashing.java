public class DoubleHashing extends Hashtable {

    int probe = 0;
    int m;
    int n;

    public DoubleHashing(int size, int bigPrime, int smallPrime) {
            super(size);
            m = bigPrime;
            n = smallPrime;
        }
    
        @Override
    public void insert(HashObject[] hashTable, int key, Object value) throws HashException {
        HashObject stock = new HashObject(value, key);
        for(int i=0; i<hashTable.length; i++) {
            probe = ((key % m) + i * (1 + (key % (m - 2)) % m)) % m;
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
            probe = ((key % m) + i * (1 + (key % (m - 2)) % m)) % m;
            if (hashTable[probe].getKey().equals(key) && hashTable[probe].getStatus() == 0) {
                return probe;
            }
        }
        return -1;
    }

    @Override
    public void delete(HashObject[] hashTable, int key) {
        for (int i=0; i<hashTable.length; i++) {
            probe = ((key % m) + i * (1 + (key % (m - 2)) % m)) % m;
            if (hashTable[probe].getKey().equals(key)) {
                hashTable[probe].setStatus(HashObject.status.DEL);
            }
        }
        System.out.println("key not in table");
    }
    
}
