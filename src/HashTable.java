public class HashTable {
    private int size; // number of buckets
    private LinkedList[] T; // array of buckets

    // Constructor
    public HashTable(int tableSize) {
        T = new LinkedList[tableSize];
        for (int i = 0; i < T.length; i++)
            T[i] = new LinkedList();
        size = tableSize;
    }

    // Hashes the key - does hash need to be public as I'm only using this locally?
    public int hash(Object key) {
        return Math.abs(key.hashCode()) % size;
    }

    // Delete TableEntry with the given key
    public void delete(Object key) {
        if (!T[hash(key)].isEmpty())
            T[hash(key)].delete(key);
    }

    // Insert TableEntry with data and associated key into HashTable
    public void insert(String key, DataType data) {
        /*boolean sameObj = false;
        // Iterates through the bucket that key is in
        for (int i = 0; i < T[hash(key)].size() && !sameObj; i++) {
            if ()
        }*/

        T[hash(key)].addAtBack(new TableEntry(key, data));
    }

    // Print contents of HashTable
    public void printTable() {
        for (int i = 0; i < T.length; i++) {
            System.out.print("T[" + i + "]: ");
            T[i].print();
        }
    }
}
