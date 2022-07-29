import java.util.*;

public class test2 {
    public static void main(String[] args) {
        BST2 data = new BST2();
        int[] arr = {2, 3, 4, 72, 3, 16, 89, 61, 67, 32, 69};

        for (int i = 0; i < arr.length; i++)
            data.insert(arr[i]);


        data.print();
        data.delete(16);
        data.print();


    }
}

class BST2 {

    private class Node {
        public int item;
        public BST2.Node left;
        public BST2.Node right;

        public Node(int i) { //makes a leaf
            item = i;
            left = right = null;
        }

        //***insert BST2.Node methods here***

    }//end class BST2.Node

    private BST2.Node root;

    public BST2() {
        root = null;
    }

    public String inorderTraversal() {
        return inorderTraversal(root);

    }//end inorderTraversal

    public void  QueInto(BST2.Node curr) {

    }

    private String inorderTraversal(BST2.Node curr) {
        String S = "";

        if (curr != null) {


            S += inorderTraversal(curr.left);

            S += curr.item + " ";
            S += inorderTraversal(curr.right);


        }

        return S;
    }


    ///////////end of privcate
    public void insert(int key) {
        root = insertRec(root, key);
    }//end insert

    private BST2.Node insertRec(BST2.Node root, int key) {

        if (root == null) {
            root = new BST2.Node(key);

            return root;
        }


        if (key < root.item) {
            root.right = insertRec(root.right, key);

        } else if (key > root.item)
            root.left = insertRec(root.left, key);


        return root;
    }

    //////// ????? version right ??????./////////
    public void delete(int key) {
        BST2.Node curr = root;
        BST2.Node prev = null;
        while (curr != null && curr.item != key) {
            prev = curr;
            if (key > curr.item) curr = curr.left;
            else curr = curr.right;
        }

        if (curr != null) {
            if (curr.left == null)
                easyDelete(curr, prev, curr.right);
            else if (curr.right == null) {
                easyDelete(curr, prev, curr.left);
            } else twoChilDel(curr);
        }
    }//end delete

    private void easyDelete(BST2.Node del, BST2.Node delParent, BST2.Node delChild) {
        if (delParent != null) {
            if (del == delParent.left)
                delParent.left = delChild;
            else delParent.right = delChild;

        } else {
            root = delChild;

        }

    }


    private void twoChilDel(BST2.Node curr) {
        BST2.Node is = curr.left;
        BST2.Node isParent = curr;

        while (is.right != null) {
            isParent = is;
            is = is.right;
        }

        curr.item = is.item;
        easyDelete(is, isParent, is.left);


    }

    //***insert tree methods here***
    public void print() {
        printSpecial("", root, false);
    }

    public static void printSpecial(String prefix, BST2.Node n, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "L-- " : "R-- ") + n.item);
            printSpecial(prefix + (isLeft ? "|   " : "    "), n.left, true);
            printSpecial(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
}//end class BST

