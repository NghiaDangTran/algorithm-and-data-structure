public class LINKED_List {
    public static void main(String args[]) {
        LINKED_List as = new LINKED_List();

        System.out.print(as.top==null);
    }

    private Node top;
    private int size;

    public LINKED_List() {
        top = null;
        size = 0;
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


    public boolean isEmpty() {
        return top == null;

    }

    public void insertLast(int newIndex) {
        Node temp = top;
        Node curr=new Node(newIndex,null);
        while (temp != null) {
            if (temp.next == null) {
                temp.setNext(curr);
            }

            temp = temp.getNext ();
        }
    }

    public void insertUnordered(int newItem) {
        top = new Node(newItem, top);
        size++;
    }

    public void insertOrdered(int newItem) {
        size++;

        Node prev = null;
        Node curr = top;

        while (curr != null && curr.item < newItem) {
            prev = curr;
            curr = curr.next;
        }
        Node newNode = new Node(newItem, curr);
        if (prev != null)
            prev.next = newNode;
        else
            top = newNode;


    }

    private Node find(int key) {
        Node curr = top;
        while (curr != null && curr.item != key)
            curr = curr.next;
        if (curr != null && curr.getData() != key)
            curr = null;
        return curr;
    }

    public void delete_first() {
        top = top.next;
        size--;

    }

    public void delete(int key) {

        Node prev = null;
        Node curr = top;
        while ((curr != null) && (curr.item != key)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            if (prev != null) {
                prev.next = curr.next;
                size--;
            } else {
                top = curr.next;
                size--;
            }
        }
    }

    public void copy(LINKED_List newList) {
        Node curr = this.top;
        for (int i = 0; i < size; i++) {
            newList.insertUnordered(curr.getData());
            curr.getNext();


        }

    }
// and other method


    private class Node {
        public int item;
        public Node next;

        public Node(int newitme, Node NExt) {
            item = newitme;
            next = NExt;
        }

        public int getData() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextI)
        {
            next = nextI;
        }
        public String toString() {
            String S = "" + item;
            return S;
        }
    }
}


///////////////////////////////////
class LinkedList1 {
    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data) {
        /* 1. Check if the given Node is null */
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        /* 2 & 3: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;

        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }

    /* Appends a new node at the end.  This method is
       defined inside LinkedList class shown above */
    public void append(int new_data) {
        /* 1. Allocate the Node &
           2. Put in the data
           3. Set next as null */
        Node new_node = new Node(new_data);

        /* 4. If the Linked List is empty, then make the
              new node as head */
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        /* 4. This new node is going to be the last node, so
              make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }

    /* This function prints contents of linked list starting from
        the given node */
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }
}
