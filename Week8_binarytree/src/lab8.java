////==============================================================
//// Lab8.java
////
//// COMP 2140 SUMMER 2021
////
//// PURPOSE: Print contents of a tree, using inorder, preorder, and postorder traversals.
////
//// NOTE: We haven't covered insertion & deletion in trees yet.  This template builds a
////       tree directly from Nodes, and the instance members in the Node class are public.
////       This is not proper programming practice, but will make for a simpler lab.
////==============================================================
//import java.util.*;
//import java.io.*;
//
//public class lab8 {
//
//    public static void main( String[] args ) {
//        Scanner keyboard;
//        String input;
//
//        keyboard = new Scanner( System.in );
//
//        //read type of traversal
//        input = keyboard.nextLine();
//
//        keyboard.close();
//
//        //build tree
//        Node temp1 = new Node('A', new Node('E'), new Node('H'));
//        Node temp2 = new Node('F', new Node('G'), temp1);
//        Node temp3 = new Node('B', null, new Node('J'));
//        Node temp4 = new Node('C', temp3, null);
//        Node root = new Node('D', temp2, temp4);
//
//        //traverse and print tree
//        if (input.equals("preorder")){
//            root.preorder();
//        }
//        else if (input.equals("postorder")){
//            root.postorder();
//        }
//        else if (input.equals("inorder")){
//            root.inorder();
//        }
//        else {
//            System.out.println( "Invalid input" );
//        }
//
//    } // end main
//
//}//end class Lab8
//
//class Node{
//    public char data;
//    public Node left;
//    public Node right;
//
//    public Node(char d){
//        data = d;
//        left = null;
//        right = null;
//    }
//
//    public Node(char d, Node l, Node r){
//        data = d;
//        left = l;
//        right = r;
//    }
//
//    //****Add your traversal methods here****
//    public void preorder() {
//        System.out.println(preorder(this));
//    }
//
//
//    public String preorder(Node curr) {
//        String S = "";
//
//        if (curr != null) {
//            S += curr.data + " ";
//
//            S += preorder(curr.left);
//
//
//            S += preorder(curr.right);
//
//
//        }
//
//        return S;
//    }
//
//
//
//    public void postorder() {
//        System.out.println(postorder(this));
//    }
//
//
//    public String postorder(Node curr) {
//        String S = "";
//
//        if (curr != null) {
//
//
//            S += postorder(curr.left);
//
//
//            S += postorder(curr.right);
//            S += curr.data + " ";
//
//        }
//
//        return S;
//    }
//
//    public void inorder() {
//        System.out.println(inorder(this));
//    }
//
//
//    public String inorder(Node curr) {
//        String S = "";
//
//        if (curr != null) {
//
//
//            S += inorder(curr.left);
//
//            S += curr.data + " ";
//            S += inorder(curr.right);
//
//
//        }
//
//        return S;
//    }
//
//}//end Node class