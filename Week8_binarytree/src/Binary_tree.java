import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


public class Binary_tree {
    public static void main(String[] args) {
        String a = "a";
        int b = 0;
        try {
            Integer.parseInt(a);
            System.out.println(1);
        } catch (Exception e) {
            System.out.println(2);
        }


        //        Binary_tree tree = new Binary_tree();
        //        tree.insert2(20);
        //        tree.insert2(4);
        //        tree.insert2(7);
        //        tree.insert2(19);
        //        tree.insert2(47);
        //        tree.insert2(44);
        //        tree.insert2(21);
        //        tree.insert2(73);
        //
        //        System.out.println(tree.printpostorder());

        //        Node root = null;
        //
        //        root = new Node(4);
        //        root.left = new Node(20);
        //        root.left.right = new Node(19);
        //        root.left.right.right = new Node(7);
        //
        //        root.right = new Node(73);
        //        root.right.right = new Node(47);
        //        root.right.left = new Node(44);
        //        root.right.left.left = new Node(21);
        //
        //
        //        System.out.println(toPrint(root));
        //        int[] arrary = new int[treeToBST.countARR(root)];
        //
        //        treeToBST.makearray(root, arrary);
        //        Arrays.sort(arrary);
        //        treeToBST.count = 0;
        //        treeToBST.ArraytoBST(root, arrary);
        //        System.out.println(toPrint(root));

        //        BST.Node root = new BST.Node(45);
        //
        //        root.right = new BST.Node(88);
        //        root.right.left = new BST.Node(53);
        //        root.right.right = new BST.Node(92);
        //        root.right.left.right = new BST.Node(75);
        //        root.right.left.right.left = new BST.Node(68);
        //        root.right.left.right.right = new BST.Node(80);
        //
        //        BST.printSpecial("", root, false);
        //        BST.delete(75,root);
        //       // root = BST.remove(root, 45);
        //        BST.printSpecial("", root, false);
        //       Node data=  Solution. increasingBST(root);
        //        printSpecial("", data, false);
        //        MAkeNEwTree(root);
        //        printSpecial("", root, false);
        BST.Node root = new BST.Node(100);

        root.right = new BST.Node(4);
        root.left = new BST.Node(3);
        root.right.left = new BST.Node(8);
        root.right.right = new BST.Node(10);
        root.left.right = new BST.Node(6);
        root.left.left = new BST.Node(5);
        BST.printSpecial("", root, false);
        BST.inorder(root);
        System.out.println(BST.isHeap(root));
        //        BST.delete(3, root);
        //        BST.printSpecial("", root, false);
        //        BST.delete(4, root);
        //        BST.printSpecial("", root, false);   BST.delete(3, root);
        //        BST.delete(5, root);
        //        BST.printSpecial("", root, false);
        //       Node data=  Solution. increasingBST(root);
        //
    }

}

class BST {
    public static boolean isHeap(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isNullSeen = false;

        while (!queue.isEmpty()) {
            // process front node in the queue
            Node curr = queue.poll();

            // left child is non-empty
            if (curr.left != null) {
                // if either heap property is violated
                if (isNullSeen || curr.left.item <= curr.item) {
                    return false;
                }

                // enqueue left child
                queue.add(curr.left);
            }
            // left child is empty
            else {
                isNullSeen = true;
            }

            // right child is non-empty
            if (curr.right != null) {
                // if either heap property is violated
                if (isNullSeen || curr.right.item <= curr.item) {
                    return false;
                }

                // enqueue left child
                queue.add(curr.right);
            }
            // right child is empty
            else {
                isNullSeen = true;
            }
        }

        // we reach here only when the given binary tree is a min-heap
        return true;
    }

    public static void inorder(Node t) {
        if (t != null) {
            System.out.print(t.getItem() + " ");

            inorder(t.left);

            inorder(t.right);

        }
    }


    static class treeToBST {

        static int count;

        /********************************
         this will take an array then ( ordered array)
         then make it into a BST
         ********************************************/
        public void ArraytoBST(Node root, int[] arr1) {
            if (root == null)
                return;

            ArraytoBST(root.left, arr1);
            root.item = arr1[count++];
            ArraytoBST(root.right, arr1);
        }

        /********************************
         from Node root and empty array make array of all the Node
         ********************************************/


        public static void makearray(Node root, int[] arr1) {
            if (root == null)
                return;


            makearray(root.left, arr1);
            arr1[count++] = root.item;

            makearray(root.right, arr1);

        }

        /********************************
         count total node in the tree
         ********************************************/
        public static int countARR(Node root) {
            int result = 1;
            if (root == null)
                return 0;


            result += countARR(root.left);


            result += countARR(root.right);

            return result;
        }


    }

    static class Node {
        public int item;
        public Node left;
        public Node right;
        public int depth;

        public Node(int i) {
            item = i;
            left = right = null;
        }

        public Node(int i, Node left1, Node right1) {
            item = i;
            left = left1;
            right = right1;
        }

        public int getItem() {
            return item;
        }

        public void computeDepths(int parentdepth) {
            depth = parentdepth + 1;
            if (left != null)
                left.computeDepths(depth);
            if (right != null)
                right.computeDepths(depth);
        }


    }

    public static Node root;

    public BST() {
        root = null;
    }

    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node prev = null;
        Node temp = root;
        while (temp != null) {
            if (temp.item >= key) {
                prev = temp;
                temp = temp.left;
            } else if (temp.item <= key) {
                prev = temp;
                temp = temp.right;
            }
        }
        if (prev.item > key)
            prev.left = node;
        else prev.right = node;
    }


    public void insert2(int key) {

        root = insertRec(root, key);
        // System.out.println(root.item);
    }

    public Node insertRec(Node root, int key) {

        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new Node(key);

            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.getItem()) {
            root.left = insertRec(root.left, key);
            //  root.left.depth=root.depth+1;
        } else if (key > root.getItem())
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }


    public Node search(Node root, int key) {
        // Base Cases: root is null
        // or key is present at root
        if (root == null ||
                root.item == key)
            return root;

        // Key is greater than root's key
        if (root.item < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

    /********************************
     BST remove
     ***********************************/
    public static BST.Node remove(BST.Node root, int value) {

        Node prev = null;
        Node curr = root;


        while (curr != null) {
            if (curr.item == value) {
                if (curr.left == null && curr.right == null) {
                    if (prev == null) {
                        Node temp = root.right;
                        return temp;
                    } else if (prev.left == curr)
                        prev.left = null;
                    else prev.right = null;
                } else if (curr.right == null) {
                    if (prev == null)
                        root = curr.left;
                    else if (prev.left == curr)
                        prev.left = curr.left;
                    else prev.right = curr.left;
                    ;
                } else if (curr.left == null) {
                    if (prev == null) {

                        Node temp = curr.right;
                        return temp;

                        //                        System.out.println("ASd");
                        //                        root.item = curr.right.item;


                    } else if (prev.left == curr)
                        prev.left = curr.right;
                    else prev.right = curr.right;
                    ;
                } else {
                    Node suc = curr.left;
                    while (suc.left != null)
                        suc = suc.left;
                    int save = suc.item;
                    remove(root, suc.item);
                    curr.item = save;

                }
                return null;
            } else if (curr.item < value) {
                prev = curr;
                curr = curr.right;
            } else {
                prev = curr;
                curr = curr.left;
            }
        }
        return curr;
    }

    /********************************
     BST remove V2
     *DO LIKE BOOK
     * *
     * *
     * *
     * **
     * *
     * *
     * *
     * *
     * **
     *
     *
     *
     *
     ***********************************/
    public static void removeV2(Node root, int value) {

    }

    // easyDelete(curr,prev,curr.right);
    private static void easyDelete(Node del, Node delParent, Node delChild, Node root) {
        if (delParent != null) {
            if (del == delParent.left)
                delParent.left = delChild;
            else delParent.right = delChild;

        } else {
            root = delChild;

        }

    }

    private static void twoChilDel(Node curr) {
        Node is = curr.right;
        Node isParent = curr;

        while (is.left != null) {
            isParent = is;
            is = is.left;
        }

        curr.item = is.item;
        easyDelete(is, isParent, is.right, root);


    }

    public static void delete(int key, Node root) {
        Node curr = root;
        Node prev = null;
        while (curr != null && curr.item != key) {
            prev = curr;
            if (key < curr.item) curr = curr.left;
            else curr = curr.right;
        }

        if (curr != null) {
            if (curr.left == null)
                easyDelete(curr, prev, curr.right, root);
            else if (curr.right == null) {
                easyDelete(curr, prev, curr.left, root);
            } else twoChilDel(curr);
        }
    }
    ////////////////////////preorder print///////////////////////////////

    /********************************
     Use a preorder traversal when the tasks performed at the
     children of a node depend on the results of the task
     performed at the node itself (their parent).
     */

    public void computeDepths() {
        if (root != null)
            root.computeDepths(-1);
    }

    /********************************
     this will print the tree in perfet one
     */
    public static void printSpecial(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "L-- " : "R-- ") + n.item);
            printSpecial(prefix + (isLeft ? "|   " : "    "), n.left, true);
            printSpecial(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    public String printPreorder() {
        return toPrintPreorder(root);
    }


    public static String toPrintPreorder(Node curr) {
        String S = "";

        if (curr != null) {
            S += curr.item + " ";

            S += toPrintPreorder(curr.left);


            S += toPrintPreorder(curr.right);


        }

        return S;
    }


    ////////////////////////////// inorder traversal/////////////////////
    public String printInorder() {
        return toPrintinorder(root);
    }


    public String toPrintinorder(Node curr) {
        String S = "";

        if (curr != null) {

            S += toPrintinorder(curr.left);


            S += curr.item + " ";

            S += toPrintinorder(curr.right);

        }


        return S;
    }


    public String printPostorder() {
        return printpostorder(root);
    }

    //use a postordertraversal when the task you are
    //performing at a node depends on the results of the task

    public String printpostorder(Node curr) {
        String S = "";

        if (curr != null) {

            S += printpostorder(curr.left);


            S += printpostorder(curr.right);
            S += curr.item + " ";
        }


        return S;
    }

    /**********************************
     Sorted Linked List to Balanced BST
     https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
     **********************************/


    public static Node solution_sortedArrau(int[] array) {
        Node root = recMiddle(array, 0, array.length - 1);

        System.out.println(toPrintPreorder(root));

        return root;

    }

    public static Node recMiddle(int[] array, int from, int to) {

        if (from > to)
            return null;
        int middle = (from + to) / 2;


        Node root = new Node(array[middle]);
        root.left = recMiddle(array, from, middle - 1);
        root.right = recMiddle(array, middle + 1, to);


        return root;


    }


    /**********************************
     Transform a BST to greater sum tree
     https://www.geeksforgeeks.org/transform-bst-sum-tree/
     **********************************/
    public void solution_sumtree(Node root) {
        printSpecial("", root, false);
        int[] data = new int[treeToBST.countARR(root)];
        treeToBST.makearray(root, data);

        Arrays.sort(data);
        recSUm(root, data);


        printSpecial("", root, false);
    }


    public int sumBigerr(int[] arr, int value) {
        int result = 0;
        int pos = 0;

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == value) {
                pos = i;

                break;
            }


        for (int j = pos + 1; j < arr.length; j++) {
            result += arr[j];


        }
        return result;
    }

    public void recSUm(Node root, int[] arr) {

        if (root == null)
            return;
        root.item = (sumBigerr(arr, root.item));
        recSUm(root.left, arr);
        recSUm(root.right, arr);


    }


    /**********************************
     Range Sum of BST
     https://leetcode.com/problems/range-sum-of-bst/
     **********************************/
    public static int rangeSumBST(Node root, int low, int high) {

        int result = 0;

        if (root == null)
            return result;


        if (root.item >= low && root.item <= high)
            result += root.item;


        result += rangeSumBST(root.left, low, high);
        result += rangeSumBST(root.right, low, high);


        return result;

    }

    /**********************************
     897. Increasing Order Search Tree
     **********************************/
    public static void MAkeNEwTree(Node root) {


        int[] data = new int[treeToBST.countARR(root)];
        treeToBST.makearray(root, data);
        Arrays.sort(data);
        root = new Node(data[0]);
        NodeTo_1degtree(root, data, 1);
        printSpecial(" ", root, false);
    }


    public static void NodeTo_1degtree(Node root, int[] arr, int count) {

        if (count == arr.length)
            return;
        root.right = new Node(arr[count]);
        NodeTo_1degtree(root.right, arr, count + 1);
    }


}

class Solution {
    //declare global tree - res
    static BST.Node res;

    public static BST.Node increasingBST(BST.Node root) {
        if (root == null)
            return null;
        BST.Node curr = new BST.Node(0);
        //res is initialized
        res = curr;
        //here curr will work as a pointer to the root node later
        recur(root);
        return curr.right;
    }

    public static void recur(BST.Node root) {
        if (root == null)
            return;
        recur(root.left);
        res.right = new BST.Node(root.item);
        res = res.right;
        recur(root.right);
    }
}

