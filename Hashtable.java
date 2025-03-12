

public abstract class Hashtable {
    protected HashObject[] table;

    public Hashtable(int size) {
        table = new HashObject[size];
    }

    public abstract void insert(HashObject[] hashTable, int key, Object value) throws HashException;

    public abstract int find(HashObject[] hashTable, int key);

    public abstract void delete(HashObject[] hashTable, int key);

    public String toString() {
        String str = "";
        for (int i=0; i<table.length; i++) {
            if (table[i].getStatus() == 0) {
                str += table[i].toString() + "/n";
            }
        }
        return str;
    }
}
