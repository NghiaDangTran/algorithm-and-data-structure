//==============================================================
// Lab10.java
//
// COMP 2140 SUMMER 2021
//
// PURPOSE: Print contents of a 2-3-4 tree, using an inorder traversal,
//          and search for values.
//
// NOTE: We will not cover insertion or deletion code for 2-3-4 trees, although you have 
//       all of the knowledge to write insertion.  This template builds a
//       tree directly from Nodes, and the instance members in the Node class are public.
//       This is not proper programming practice, but will make for a simpler lab. In a
//       2-3-4 tree, insertions should always be done in the leaves.
//==============================================================
import java.util.*;
import java.io.*;

public class lab10 {

    public static void main( String[] args ) {
        Scanner keyboard;
        String input;

        keyboard = new Scanner( System.in );

        //read "inorder" or a key
        input = keyboard.nextLine();

        keyboard.close();

        //build tree
        Node temp1 = new Node(5, 8, 10);
        Node temp2 = new Node(29);
        Node temp3 = new Node(35, 38, 40);
        Node temp4 = new Node(43, 44);
        Node temp5 = new Node(49, 50, 53);
        Node temp6 = new Node(58, 59);
        Node temp7 = new Node(63);
        Node temp8 = new Node(70);
        Node temp9 = new Node(74, 75, 76);
        Node temp10 = new Node(83, 88);
        Node temp11 = new Node(98);
        Node temp12 = new Node(102, 105, 108);
        Node temp13 = new Node(21, 34, temp1, temp2, temp3);
        Node temp14 = new Node(45, temp4, temp5);
        Node temp15 = new Node(60, 68, 73, temp6, temp7, temp8, temp9);
        Node temp16 = new Node(90, 100, temp10, temp11, temp12);
        Node temp17 = new Node(42, 57, 81, temp13, temp14, temp15, temp16);
        My234Tree testTree = new My234Tree(temp17);


        if (input.equals("inorder")){ //traverse tree
            testTree.inorder();
        }
        else { //search tree
            int key = Integer.parseInt(input);
            if (testTree.search(key))
                System.out.println( "The key of " + key + " was FOUND" );
            else
                System.out.println( "The key of " + key + " was NOT found" );
        }

    } // end main
}

class Node{
    public int dataLeft;
    public int dataMid;
    public int dataRight;
    public Node left;
    public Node midLeft;
    public Node midRight;
    public Node right;

    public Node(int d){
        dataLeft = d;
        dataMid = dataRight = Integer.MIN_VALUE;
        left = midLeft = midRight = right = null;
    }

    public Node(int d, Node l, Node ml){
        dataLeft = d;
        dataMid = dataRight = Integer.MIN_VALUE;
        left = l;
        midLeft = ml;
        midRight = right = null;
    }

    public Node(int d1, int d2){
        dataLeft = d1;
        dataMid = d2;
        dataRight = Integer.MIN_VALUE;
        left = midLeft = midRight = right = null;
    }

    public Node(int d1, int d2, Node l, Node ml, Node mr){
        dataLeft = d1;
        dataMid = d2;
        dataRight = Integer.MIN_VALUE;
        left = l;
        midLeft = ml;
        midRight = mr;
        right = null;
    }

    public Node(int d1, int d2, int d3){
        dataLeft = d1;
        dataMid = d2;
        dataRight = d3;
        left = midLeft = midRight = right = null;
    }

    public Node(int d1, int d2, int d3, Node l, Node ml, Node mr, Node r){
        dataLeft = d1;
        dataMid = d2;
        dataRight = d3;
        left = l;
        midLeft = ml;
        midRight = mr;
        right = r;
    }

    //NOTE: Leaf nodes could have one, two, or three items, even though all pointers are null
    public void inorder(Node root) {

        if (root != null) {

            inorder(root.left);

            System.out.print(root.dataLeft + " ");

            inorder(root.midLeft);

            if (root.dataMid != Integer.MIN_VALUE) {
                System.out.print(root.dataMid + " ");
                inorder(root.midRight);


                if (root.dataRight != Integer.MIN_VALUE) {
                    System.out.print(root.dataRight + " ");

                    inorder(root.right);
                }
            }
        }

    }

    public boolean search(Node root, int key) {
        //****Fill in this recursive helper method****

        boolean result = false;
        if (root != null) {
            if (key == root.dataLeft || key == root.dataMid || key == root.dataRight)
                return true;
            if (key < root.dataLeft)
                result = search(root.left, key);
            else if ( root.dataMid==Integer.MIN_VALUE||key < root.dataMid)
                result = search(root.midLeft, key);
            else if (root.dataRight==Integer.MIN_VALUE||key < root.dataRight)
                result = search(root.midRight, key);
            else
                result = search(root.right, key);

        }

        return result;
    }
}//end Node class

class My234Tree{
    public Node root;

    public My234Tree(){
        root = null;
    }

    public My234Tree(Node r){
        root = r;
    }

    public void inorder(){
        //****Fill in this driver method. It should call the recursive helper method on the root. Data in the tree should be printed to the console.****
        root.inorder(root);

    }

    public boolean search(int key){
        //****Fill in this driver method. It should call the recursive helper method on the root. Return whether the key was found in the tree.****
        return root.search(root,key);
    }
}