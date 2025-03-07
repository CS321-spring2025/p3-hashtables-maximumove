public abstract class Hashtable {
    protected HashObject[] table;

    // public Enum status {
    //     Ocupided, Del, 
    // }

    public Hashtable(int size) {
        table = new HashObject[size];
    }

    public abstract void insert();

    public abstract int find();

    public abstract void delete();

    // public String toString() {
    //     for (int i=0; i<table.length; i++) {
    //         if (table[i])
    //     }
    // }
}
