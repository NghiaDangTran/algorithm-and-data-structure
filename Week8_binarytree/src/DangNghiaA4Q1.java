import java.util.Arrays;

public class DangNghiaA4Q1 {
    public static void main(String args[]) {

        String Ex = "+ ^ firstVble 1 - * secondVble 0 * + firstVble secondVble 5";
        // Ex = "* D + E F";
        //Ex = "firstVble 1 ^ secondVble 0 * firstVble secondVble + 5 * - +";

        ExpressionTree data = new ExpressionTree();

        data.PrefixToTree(Ex);
        data.printSpecial();
        data.simlify();
        data.printInfix();
        data.printSpecial();

        //
        //        data.PostfixToTree(Ex);
        //        data.printSpecial();
        //        data.printPostfix();
        //        data.simlify();
        //        data.printInfix();
        //        data.printSpecial();
        //        ExpressionTree data = new ExpressionTree(Ex);
        //        data.printSpecial();
        //        data.simlify();
        //
        //        data.printInfix();
        //        System.out.println();
        //        data.printSpecial();
    }
}

enum NodeType {OPERATOR, VARIABLE, NUMBER}

class Node {
    NodeType data;

    char Operator;
    String Variable;
    int Number;


    public Node left;
    public Node right;


    ////////////////////// getter and setter of left and right

    public Node(NodeType value, String S, Node L, Node R) {
        data = value;
        if (value == NodeType.OPERATOR) {
            //  Operator = S.toChar;

            for (int i = 0; i < S.length(); i++)
                Operator = S.charAt(i);
        } else if (value == NodeType.VARIABLE)
            Variable = S;
        else if (value == NodeType.NUMBER)
            Number = Integer.parseInt(S);
        left = L;
        right = R;

    }


    public String value(Node data) {
        String S = "";
        if (data.data == NodeType.OPERATOR)
            return S + data.Operator;
        if (data.data == NodeType.NUMBER)
            return S + data.Number;
        if (data.data == NodeType.VARIABLE)
            return S + data.Variable;

        return S;
    }

    public boolean same(Node root2) {
        return this.data == root2.data &&
                this.value(this).equals(root2.value(root2));
    }
}

class ExpressionTree {


    Node root;

    public boolean isNumber(Node root) {
        return root.data == NodeType.NUMBER;
    }

    public boolean isOperator(Node root) {
        return root.data == NodeType.OPERATOR;
    }

    public boolean isVariable(Node root) {
        if (root == null)
            return false;
        return root.data == NodeType.VARIABLE;
    }

    public void PostfixToTree(String S) {
        root = PostfixToTree(S.split(" "));

    }

    public void PrefixToTree(String S) {
        root = PrefixToTree(S.split(" "));
    }
    // check the current String is what

    /// make new tree

    /// print it as infix

    // print it as prefix

    // print it as postfix


    // simplyfied it infix
    boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*'
                || c == '^') {
            return true;
        }
        return false;
    }

    boolean isNumber(String c) {
        try {
            Integer.parseInt(c);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void printInfix() {
        inorder(root);
    }

    public void printPostfix() {
        postorder(root);

    }

    public void printPrefix() {
        preorder(root);

    }


    public boolean CompareTo(Node root1, Node root2) {
        //base case :both are empty
        if (root1 == null && root2 == null)
            return true;

        if (root1.same(root2)) {
            //subtrees
            boolean left = CompareTo(root1.left, root2.left);
            boolean right = CompareTo(root1.right, root2.right);
            return (left && right);
        }//end if
        else {
            return false;
        }
    }

    public boolean OnlyLorR(Node root) {
        if (isOperator(root) && root.Operator == '-') {
            if (root.left != null && root.right != null)
                return false;
            else if (root.left == null && root.right == null)
                return false;


        }
        return true;
    }

    public void inorder(Node t) {
        if (t != null) {


            if (t.data == NodeType.OPERATOR)
                System.out.print("(");

            inorder(t.left);

            if (t.data == NodeType.OPERATOR)
                System.out.print(t.Operator);
            else if (t.data == NodeType.VARIABLE)
                System.out.print(t.Variable);
            else
                System.out.print(t.Number);

            inorder(t.right);
            if (t.data == NodeType.OPERATOR)
                System.out.print(")");
        }
    }

    public void postorder(Node t) {
        if (t != null) {
            if (t.data == NodeType.OPERATOR)
                System.out.print(t.Operator + " ");
            else if (t.data == NodeType.VARIABLE)
                System.out.print(t.Variable + " ");
            else
                System.out.print(t.Number + " ");
            postorder(t.left);

            postorder(t.right);
        }
    }

    public void preorder(Node t) {
        if (t != null) {

            preorder(t.left);

            preorder(t.right);

            if (t.data == NodeType.OPERATOR)
                System.out.print(t.Operator + " ");
            else if (t.data == NodeType.VARIABLE)
                System.out.print(t.Variable + " ");
            else
                System.out.print(t.Number + " ");
        }
    }


    public boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public Node process(Node root, Node x, Node y) {
        /// if both x and y int return value

        ///if 1 trong 2 la variable
        // check the orther 1 so truong hop dat biet


        int value = 0;

        if (isOperator(root)) {

            if (root.Operator == '+') {

                if (isOperator(x) && x.Operator == '-' && (y != null)) {

                    if (OnlyLorR(x)) {
                        Node next = null;
                        if (x.left != null)
                            next = x.left;
                        else next = x.right;
                        return new Node(NodeType.OPERATOR, "-", next, y);


                    }
                }

                if (isOperator(y) && y.Operator == '-' && (x != null)) {

                    if (OnlyLorR(y)) {
                        Node next = null;
                        if (y.left != null)
                            next = y.left;
                        else next = y.right;
                        return new Node(NodeType.OPERATOR, "-", x, next);


                    }
                }


                if (isOperator(x) && x.Operator == '-' && isOperator(x) && x.Operator == '-') {
                    if (OnlyLorR(x) && OnlyLorR(y)) {
                        Node nextL = null;
                        if (x.left != null)
                            nextL = x.left;
                        else nextL = x.right;


                        Node nextR = null;
                        if (y.left != null)
                            nextR = y.left;
                        else nextR = y.right;
                        return new Node(NodeType.OPERATOR, "+", nextL, nextR);


                    }
                }


                if ((isVariable(y) || isOperator(y)) && isNumber(x) && x.Number == 0) {
                    return y;
                }
                if ((isVariable(x) || isOperator(x)) && isNumber(y) && y.Number == 0) {
                    return x;
                }


                if (isVariable(x) && isVariable(y) && (("-" + x.Variable).equals(y.Variable) || ("-" + y.Variable).equals(x.Variable))) {

                    return new Node(NodeType.NUMBER, Integer.toString(0), null, null);
                }
                if ((isVariable(y) && isNumber(x)) || (isVariable(y) && isNumber(x)) ||
                        (isVariable(x) && isVariable(y)) || (isVariable(x) && isOperator(y))) {

                    return root;
                }
                if (x.data == y.data && x.data == NodeType.NUMBER) {
                    value = x.Number + y.Number;
                    return new Node(NodeType.NUMBER, Integer.toString(value), null, null);
                }

            }
            if (root.Operator == '-') {

                if (isOperator(x) && isOperator(y) && CompareTo(x, y)) {

                    return new Node(NodeType.NUMBER, Integer.toString(0), null, null);
                }
                if (isNumber(x) && x.Number == 0 && isOperator(y)) {////thjing to do tmr need do asfast as posible

                    Node data = new Node(NodeType.OPERATOR, "" + root.Operator, null, y);
                    return data;
                }

                if ((isVariable(y)) && isNumber(x) && x.Number == 0) {
                    return new Node(NodeType.VARIABLE, "-" + y.Variable, null, null);
                }

                if ((isOperator(x) || isVariable(x)) && isNumber(y) && y.Number == 0) {

                    return x;
                }

                if (isVariable(x) && isVariable(y) && (x.Variable).equals(y.Variable)) {
                    return new Node(NodeType.NUMBER, Integer.toString(0), null, null);
                }

                if ((isVariable(y) && isNumber(x)) || (isVariable(y) && isNumber(x)) ||
                        (isVariable(x) && isVariable(y))) {
                    return root;
                }
                if (x.data == y.data && x.data == NodeType.NUMBER) {
                    value = x.Number - y.Number;
                    return new Node(NodeType.NUMBER, Integer.toString(value), null, null);
                }

            }
            if (root.Operator == '*') {


                if (isVariable(x) && isNumber(y) && y.Number == 0) {
                    return new Node(NodeType.NUMBER, Integer.toString(0), null, null);
                }
                if (isVariable(y) && isNumber(x) && x.Number == 0) {
                    return new Node(NodeType.NUMBER, Integer.toString(0), null, null);
                }

                if ((isVariable(y) || isOperator(y)) && isNumber(x) && x.Number == 1) {
                    return y;
                }
                if ((isVariable(x) || isOperator(x)) && isNumber(y) && y.Number == 1) {
                    return x;
                }

                if (isVariable(y) && isNumber(x) && x.Number == 0) {
                    return new Node(NodeType.VARIABLE, "-" + y.Variable, null, null);
                }

                if (isVariable(y) && isNumber(x) && x.Number == -1) {
                    return new Node(NodeType.VARIABLE, "-" + y.Variable, null, null);
                }
                if (isVariable(x) && isNumber(y) && y.Number == -1) {
                    return new Node(NodeType.VARIABLE, "-" + x.Variable, null, null);
                }


                if ((isVariable(y) && isNumber(x)) || (isVariable(y) && isNumber(x)) ||
                        (isVariable(x) && isVariable(y))) {
                    return root;
                }

                if (x.data == y.data && x.data == NodeType.NUMBER) {
                    value = x.Number * y.Number;
                    return new Node(NodeType.NUMBER, Integer.toString(value), null, null);
                }
            }
            if (root.Operator == '^') {

                if ((isVariable(x) || isOperator(x)) && isNumber(y) && y.Number == 0)
                    return new Node(NodeType.NUMBER, Integer.toString(1), null, null);


                if ((isVariable(x) || isOperator(x)) && isNumber(y) && y.Number == 1)
                    return x;

                if (isNumber(x) && x.Number == 0 && (isNumber(y) || isVariable(y) || isOperator(y)))
                    return new Node(NodeType.NUMBER, Integer.toString(0), null, null);

                if (isNumber(x) && x.Number == 1 && (isNumber(y) || isVariable(y) || isOperator(y)))
                    return new Node(NodeType.NUMBER, Integer.toString(1), null, null);

                if (isVariable(y) && isVariable(x))
                    return root;
                if (x.data == y.data && x.data == NodeType.NUMBER) {
                    value = (int) Math.pow(x.Number, y.Number);
                    return new Node(NodeType.NUMBER, Integer.toString((value)), null, null);
                }
            }
        }
        return root;
    }

    //    public Node processVAR(Node root, String x, String y) {
    //
    //        if (root.data == NodeType.OPERATOR) {
    //            if (root.Operator == '+') {
    //                return new Node(NodeType.NUMBER, Integer.toString(x + y), null, null);
    //            }
    //            if (root.Operator == '-') {
    //                return new Node(NodeType.NUMBER, Integer.toString(x + y), null, null);
    //            }
    //            if (root.Operator == '*') {
    //                return new Node(NodeType.NUMBER, Integer.toString(x + y), null, null);
    //            }
    //            if (root.Operator == '^') {
    //                return new Node(NodeType.NUMBER, Integer.toString(x + y), null, null);
    //            }
    //        }
    //        return null;
    //    }

    public void printSpecial() {
        printSpecial("", root, false);
    }

    public static void printSpecial(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "L-- " : "R-- ") + n.value(n));
            printSpecial(prefix + (isLeft ? "|   " : "    "), n.left, true);
            printSpecial(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    ////////////addd rescursive
    ///////// add some of the special type
    //// finish it
    public void simlify() {
        root = simlify(root);
        if (!CompareTo(simlify(root), root))
            root = simlify(root);
        //        root.left = simlify(root.left);
        //
        //        root.right = simlify(root.right);
        //        root.right.left = simlify(root.right.left);
        //        root.right.right = simlify(root.right.right);
        //


    }


    //    public Node simlifyFinale(Node root) {
    //        //        Node result =
    //        //        if (root == null)
    //        //            return;
    //        //        ;
    //        //        root = simlify(root);
    //        //        simlifyFinale(root.left);
    //        //        root = simlify(root);
    //        //        simlifyFinale(root.left);
    //        //        root = simlify(root);
    //
    //    }

    public Node simlify(Node root) {


        if (root == null)
            return root;


        root.left = simlify(root.left);
        root.right = simlify(root.right);


        //if((x.data==NodeType.NUMBER && y.data)&& )

        return process(root, root.left, root.right);
    }


    Node PostfixToTree(String[] S) {
        Stack data = new Stack(100);
        Node t, t1, t2;
        for (int i = 0; i < S.length; i++) {
            if (S[i].length() > 1 || !isOperator(S[i].charAt(0))) {
                try {

                    t = new Node(NodeType.NUMBER, S[i], null, null);

                } catch (Exception e) {
                    t = new Node(NodeType.VARIABLE, S[i], null, null);

                }

                data.push(t);
            } else {
                t = new Node(NodeType.OPERATOR, S[i], null, null);
                t1 = data.pop();      // Remove top
                t2 = data.pop();
                t.right = t1;
                t.left = t2;

                data.push(t);
            }


        }


        t = data.top();
        data.pop();
        return t;

    }

    public boolean isleaf(Node root) {
        return root.right == null && root.left == null;
    }

    Node PrefixToTree(String[] S) {
        Queue data = new Queue(S.length * 4);
        for (int i = 0; i < S.length; i++)
            if (isOperator(S[i].charAt(0)))
                data.enqueue(new Node(NodeType.OPERATOR, S[i], null, null));
            else if (isNumber(S[i]))
                data.enqueue(new Node(NodeType.NUMBER, S[i], null, null));
            else data.enqueue(new Node(NodeType.VARIABLE, S[i], null, null));


        Node temp, next1, next2;

        while (!data.onlyone()) {

            temp = data.dequeue();
            if (isVariable(temp) || isNumber(temp))
                data.enqueue(temp);

            if ((isOperator(temp) || isVariable(temp) || isNumber(temp)) && (temp.left != null || temp.right != null))
                data.enqueue(temp);




            if (isOperator(temp) && isLeaf(temp)) {
                next1 = data.peek();
                next2 = data.peek2();

                if (
                        ((isNumber(next1) || isVariable(next1)) && (isNumber(next2) || isVariable(next2)))

                                || ((isNumber(next1) || isVariable(next1)) && isOperator(next2) && !isleaf(next2))
                                || ((isNumber(next2) || isVariable(next2)) && isOperator(next1) && !isleaf(next1))
                                || ((isOperator(next1) && !isleaf(next1)) && (isOperator(next2) && !isleaf(next2)))

                ) {
                    temp.left = data.dequeue();
                    temp.right = data.dequeue();

                    data.enqueue(temp);

                }


                if ((isOperator(next1) && isOperator(next2) && isLeaf(next1) && isLeaf(next2))
                        || (isOperator(next1) && isleaf(next1))
                        || (isOperator(next2) && isleaf(next2))
                ) {
                    data.enqueue(temp);

                }

            }


        }

        //  data.toPrint();
        return data.dequeue();

    }

}


class Queue {

    private Node[] queueArray;
    private int front; // Position of top item in the stack.
    private int rear, size;
    int capacity;

    // Create a new empty stack
    public Queue(int stackSize) {
        queueArray = new Node[stackSize * 9];
        rear = -1;
        front = 0;
    } // end Stack constructor

    public boolean isEmpty() {
        return size == 0;
    } // isEmpty

    public boolean onlyone() {return rear == front;}

    public void enqueue(Node newItem) {

        queueArray[++rear] = newItem;
        size++;

    } // end push

    public Node dequeue() {
        Node result = null;

        if (!isEmpty()) {
            result = queueArray[front];
            front++;
            size--;
        }

        return result;
    } // end pop

    public Node peek() {
        Node result = null;

        if (!isEmpty()) {
            result = queueArray[front];
        }

        return result;
    } // end top

    public Node peek2() {
        Node result = null;

        if (!isEmpty()) {
            result = queueArray[front + 1];
        }

        return result;

    }

    public void toPrint() {

        for (int i = front; i <= rear; i++)
            System.out.print(queueArray[i].value(queueArray[i]) + " ");
        System.out.println();
    }
    // end top

}

class Stack {

    private Node[] stackArray;
    private int top; // Position of top item in the stack.
    // top is -1 if the stack is empty.

    // Create a new empty stack
    public Stack(int stackSize) {
        stackArray = new Node[stackSize];
        top = -1;
    } // end Stack constructor

    public boolean isEmpty() {
        return top == -1;
    } // isEmpty

    public boolean isFull() {
        return top == stackArray.length - 1;
    } // end isFull

    public boolean push(Node newItem) {
        if (!isFull()) {
            top++;
            stackArray[top] = newItem;
            return true;
        }
        return false;
    } // end push

    public Node pop() {
        Node result = null;

        if (!isEmpty()) {
            result = stackArray[top];
            top--;
        } else {
            System.out.println("***ERROR in Stack pop(): stack is empty");
        }

        return result;
    } // end pop

    public Node top() {
        Node result = null;

        if (!isEmpty()) {
            result = stackArray[top];
        }

        return result;
    } // end top


}