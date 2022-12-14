import java.util.Arrays;

public class hashtable {
    public static void main(String args[]) {
        LinearProbingHashTable anj = new LinearProbingHashTable(13);
        anj.insert("1","a");
        anj.insert("2","b");
        anj.insert("3","c");
        anj.insert("4","dasd");
        anj.insert("4asd","2");
        anj.insert("33","2");
        System.out.println(Arrays.toString(anj.keys));
        System.out.println(Arrays.toString(anj.vals));

    }
}

class LinearProbingHashTable {
    // Member variables of this class
    private int currentSize, maxSize;
    public String[] keys;
    public String[] vals;

    // Constructor of this class
    public LinearProbingHashTable(int capacity) {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    // Method 1
// Function to clear hash table
    public void makeEmpty() {
        currentSize = 0;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    // Method 2
// Function to get size of hash table
    public int getSize() {
        return currentSize;
    }

    // Method 3
// Function to check if hash table is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Method 4
// Function to check if hash table is empty
    public boolean isEmpty() {
        return getSize() == 0;
    }

    // Method 5
// Function to check if hash table contains a key
    public boolean contains(String key) {
        return get(key) != null;
    }

    // Method 6
// Function to get hash code of a given key
    private int hash(String key) {
        return key.hashCode() % maxSize;
    }

    // Method 7
// Function to insert key-value pair
    public void insert(String key, String val) {
        int tmp = hash(key);
        int i = tmp;

        // Do-while loop
        // Do part for performing actions
        do {
            if (keys[i] == null) {
                keys[i] = key;
                vals[i] = val;
                currentSize++;
                return;
            }

            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }

            i = (i + 1) % maxSize;

        }

        // Do-while loop
        // while part for condition check
        while (i != tmp);
    }

    // Method 8
// Function to get value for a given key
    public String get(String key) {
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key))
                return vals[i];
            i = (i + 1) % maxSize;
        }
        return null;
    }

    // Method 9
// Function to remove key and its value
    public void remove(String key) {
        if (!contains(key))
            return;

        // Find position key and delete
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % maxSize;
        keys[i] = vals[i] = null;

        // rehash all keys
        for (i = (i + 1) % maxSize; keys[i] != null;
             i = (i + 1) % maxSize) {
            String tmp1 = keys[i], tmp2 = vals[i];
            keys[i] = vals[i] = null;
            currentSize--;
            insert(tmp1, tmp2);
        }
        currentSize--;
    }

    // Method 10
// Function to print HashTable
    public void printHashTable() {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] + " " + vals[i]);
        System.out.println();
    }
}