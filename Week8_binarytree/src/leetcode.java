import java.util.ArrayList;
import java.util.Arrays;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
public class leetcode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String unicodeMessage =
                "	♥";

        System.out.print("\u2665");
        System.out.println(3 % 11);
    }


    public static int[] goodPair(int[] arr) {
        int[] finalasd = new int[arr.length];
        int result = 0;
        int count = 0;
        if (arr.length >= 2) {
            int j = 0;
            for (int i = 0; i < arr.length - 1; i++) {

                for (j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j] && i != j)
                        result++;


                }
                finalasd[count++] = result;
                result = 0;

            }
        }


        return finalasd;

    }
}

class doit {


    public static int find(int[] arr, int target) {
        int[] finalasd = new int[2];
        boolean gotit = false;
        int count = 0;

        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] == i * i + j * j) {
                    count++;
                }


            }

        }


        return count;

    }
}


class linkedlist_hash {
    public static int maxsize;
    public static linked_list[] data;

    int currentsize;

    public linkedlist_hash(int size) {
        maxsize = size;
        data = new linked_list[maxsize];
        currentsize = 0;
    }

    public void add(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int position = arr[i] % maxsize;

            if (data[position] == null)
                data[position] = new linked_list();
            data[position].insert(arr[i]);

        }


    }


    ////////////////////////////////////////////////////////////// Given an array A[] and a number x, check for pair in A[] with sum as x/////////////////////////
    public void insertInt(int value) {

        int position = value % maxsize;

        if (data[position] == null)
            data[position] = new linked_list();
        data[position].insert(value);

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void toString1() {
        for (int i = 0; i < maxsize; i++) {
            if (data[i] != null)
                System.out.println(data[i]);
        }
    }


    public boolean insisde(int value) {
        int position = value % maxsize;
        if (data[position] == null)
            return false;
        else if (!data[position].search(value))
            return false;


        return true;

    }

    public boolean subset(int[] arr2) {


        for (int i = 0; i < arr2.length; i++) {
            int position = arr2[i] % maxsize;


            if (data[position] == null)
                return false;
            else if (!data[position].search(arr2[i]))
                return false;
        }
        return true;
    }


}

class linked_list {
    public NodeDOI top;
    public int size;

    public linked_list() {
        top = null;
        size = 0;
    }


    public NodeDOI top() {
        return top;
    }

    public int size() {
        return size;
    }

    public void insert(int newItem) {
        top = new NodeDOI(newItem, top);
        size++;
    }


    public boolean search(int key) {
        NodeDOI curr = top;
        while (curr != null) {
            if (curr.getData() == (key))
                return true;

            curr = curr.getNext();


        }

        return false;
    }


    public void union(int[] union, int i) {
        NodeDOI curr = top;
        while (curr != null) {
            if (Orcurance(curr.item) == 1)
                union[i++] = curr.item;


            curr = curr.getNext();


        }


    }

    public void intersect(int[] intersect, int i) {
        NodeDOI curr = top;
        while (curr != null) {
            if (Orcurance(curr.item) == 2)
                intersect[i++] = curr.item;


            curr = curr.getNext();


        }
    }

    public int Orcurance(int key) {
        int result = 0;
        NodeDOI curr = top;
        while (curr != null) {
            if (curr.getData() == (key))
                result++;

            curr = curr.getNext();


        }

        return result;
    }

    public String toString() {

        NodeDOI begin = top;
        String S = "";
        while (begin != null) {
            S += begin.getData() + " ";
            begin = begin.getNext();
        }
        return S;
    }

    private class NodeDOI {
        public int item;
        public NodeDOI next;

        public NodeDOI(int newitme, NodeDOI NExt) {
            item = newitme;
            next = NExt;
        }

        public int getData() {
            return item;
        }

        public NodeDOI getNext() {
            return next;
        }

        public String toString() {
            String S = "" + item;
            return S;
        }
    }

}



