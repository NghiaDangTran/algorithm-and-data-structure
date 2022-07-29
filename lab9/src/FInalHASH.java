import java.util.Arrays;

public class FInalHASH {
    public static void main(String[] args) {
//        HashMap data = new HashMap(9);
//
//        int[] data1 = {1, 3, 8, 0};
//
//        for (int i = 0; i < data1.length; i++) {
//            data.add(data1[i], data1[i]);
//        }
//
//        data.print();

        //  System.out.print(Solution.isIsogram("anhl"));
//                HashMapDouble data = new HashMapDouble(13);
//                int[] data1 = {8,39,12,21,26,9,17,5,23,32};
//
//                for (int i = 0; i < data1.length; i++) {
//                    data.insert(data1[i]);
//                }
//
//           data.print();
    }
}


class HashEntry {

    private int key;
    private int value;


    public HashEntry(int key, int vbalue) {
        this.key = key;
        this.value = vbalue;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

class HashMapDouble {
    private int SIZE;
    int[] table;

    public HashMapDouble(int max) {
        SIZE = max;

        table = new int[SIZE];


        for (int i = 0; i < SIZE; i++)
            table[i] = -1;


    }


    private int hashCode1(int key) {
        //        int result = ke;

        return key % SIZE;
    }

    private int hashCode2(int key) {
        return  (key % 5);
    }


    public void insert(int key) {
        int hash1value = hashCode1(key);

        int hash2value = hashCode2(key);

        while (table[hash1value] != -1) {
            hash1value += hash2value;
            hash1value %= SIZE;
        }

        table[hash1value] = key;

    }

    public void print() {
        for (int i = 0; i < SIZE; i++)
            System.out.print(table[i] + " ");

    }
}

class HashMap {

    private int SIZE;

    HashEntry[] table;

    public HashMap(int max) {
        SIZE = max;

        table = new HashEntry[SIZE];


        for (int i = 0; i < SIZE; i++)
            table[i] = null;


    }

    //    public int countNumberof()

    public boolean contains(int key) {
        int hash = key % SIZE;

        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % SIZE;

        if (table[hash] == null)
            return false;

        return true;

    }

    public int get(int key) {
        int hash = key % SIZE;

        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % SIZE;


        if (table[hash] == null)
            return -1;
        else return table[hash].getValue();
    }


    public void add(int key, int value) {

        int hash = key % SIZE;

        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % SIZE;
        table[hash] = new HashEntry(key, value);
    }

    public void delete(int key) {
        int hash = key % SIZE;

        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % SIZE;
        //hash = (7*hash + 3) % SIZE;
        table[hash] = null;
    }

    public void print() {
        String S = "";
        for (int i = 0; i < SIZE; i++)
            if (table[i] == null)
                S += "null ";
            else S += table[i].getKey() + " ";

            System.out.println(S);
    }
}


class HashMap_speparte {

    private class linked_list {
        private Node top;
        private int size;

        public linked_list() {
            top = null;
            size = 0;
        }


        public Node top() {
            return top;
        }

        public int size() {
            return size;
        }

        public void insert(String newItem) {
            top = new Node(newItem, top);
            size++;
        }


        public boolean search(String key) {
            Node curr = top;
            while (curr != null) {
                if (curr.getData().equalsIgnoreCase(key))
                    return true;

                curr = curr.getNext();


            }

            return false;
        }

        public String toString() {

            Node begin = top;
            String S = "";
            for (int i = 0; i < size; i++) {
                S += begin.getData() + " ";
                begin = begin.getNext();
            }
            return S;
        }
    }

    private class Node {
        private String item;
        private Node next;

        public Node(String newitme, Node NExt) {
            item = newitme;
            next = NExt;
        }

        public String getData() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public String toString() {
            String S = "" + item;
            return S;
        }

    }


    private int currentSize;
    private int maxSize;
    private linked_list[] data;

    public HashMap_speparte(int size) {
        maxSize = (size);
        data = new linked_list[maxSize];
        currentSize = 0;
    }


    public void insert(String newWord) {
        if (newWord.compareToIgnoreCase(" ") != -1) {
            newWord = newWord.toLowerCase();


            if (!search(newWord)) {
                // if the new word is not in the array calculate the hash value
                int hashvalue = hashCode(newWord, 27, maxSize);

                if (data[hashvalue] == null)
                    // if the array is null at that value
                    // make a linkedlist
                    data[hashvalue] = new linked_list();
                data[hashvalue].insert(newWord);
                // and insert of the linkedlist
                currentSize++;

                // update the total size
            }
        }

    }

    public boolean search(String newWord) {
        newWord = newWord.toLowerCase();
        int hashvalue = hashCode(newWord, 27, maxSize);
        if (data[hashvalue] == null)
            return false;
        return data[hashvalue].search(newWord);
    }

    private int hashCode(String key, int a, int size) {
        int result = 0;
        for (int j = 0; j < key.length(); j++) {

            int letter = key.charAt(j) - 96;
            result = (result * a + letter) % size;
        }
        return result;


        /// hash code for int is just that value % size
    }

    //////////////////////////////////test 3////////////////////


}
