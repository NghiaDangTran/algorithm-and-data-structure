import java.util.Arrays;

public class Learn {
    //    public static void main(String[] args) {
    //        // Total 5 vertices in graph
    //        //        Graph graph = new Graph(4
    //        //        );
    //        //        graph.addEdge(0, 1);
    //        //        graph.addEdge(0, 2);
    //        //        graph.addEdge(1, 2);
    //        //        graph.addEdge(1, 3);
    //        //        graph.addEdge(2, 3);
    //        //        graph.addEdge(2, 1);
    //        //        graph.addEdge(3, 2);
    //        //
    //        //
    //        //        graph.printGraph();
    //        //        graph.printDepth();
    //        //        graph.DFS();
    //        //        System.out.println();
    //        //        graph.test();
    //        //        System.out.println();
    //        //        graph.bfs();
    //        //
    //        //        int[][] arr = //{{0, 1, 1, 0, 1}, {1, 0, 1, 0, 0}, {1, 1, 0, 1, 1}, {0, 0, 1, 0, 1}, {1, 0, 0, 1, 0}};
    //        //                {{0, 1, 0, 0, 0},
    //        //                        {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}, {1, 0, 0, 0, 0}};
    //        //
    //        //        int [] [] arr1={{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1},{1,0,0,0,0},{0,0,1,0,0}};//{0,1,0,0,0},{0,0,1,1,0},{1,0,0,0,1},{0,0,0,0,0},{0,1,0,1,0}};
    //        //
    //        //        // {{0, 1, 0, 0, 0},
    //        //        //                {0, 0, 1, 0, 0}, {1, 0, 0, 1, 0}, {0, 0, 0, 0, 1}, {1, 0, 1, 0, 0}};
    //        //        GraphArray graph = new GraphArray(arr);
    //        //        System.out.println(graph.isDirected());
    //        //        System.out.println(graph.countEdges());
    //        //        System.out.println(graph.getNumEdgesIn(0));
    //        //        System.out.println(graph.getNumEdgesOut(0));
    //        //        String temp = "123 8 90";
    //        //        String[] temp2 = temp.split(" ");
    //        //
    //        //        System.out.println(Integer.parseInt(temp2[2]));
    //        //
    //        int[][] array = {{0, 40, 20, 20, 30, 80, 0, 0, 0, 0, 70, 0}, {0, 0, 0, 20, 40, 0, 0, 0, 0, 0, 5, 0}, {0, 0, 0, 0, 0, 30, 0, 50, 0, 0, 30, 30}, {0, 0, 10, 0, 0, 0, 0, 0, 0, 30, 50, 0}, {0, 0, 0, 0, 0, 0, 40, 0, 0, 20, 0, 20}, {10, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 60}, {0, 0, 30, 90, 0, 60, 0, 0, 0, 0, 80, 0}
    //                , {60, 0, 0, 50, 10, 0, 70, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 40, 0, 70, 0, 10}, {10, 60, 0, 0, 0, 80, 10, 0, 0, 0, 90, 0}, {20, 60, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0}, {0, 70, 60, 0, 0, 90, 0, 0, 0, 0, 0, 0}};
    //        GraphArray data = new GraphArray(array);
    //        data.dfs(0);
    //        System.out.println();
    //        data.BFS(11);
    //    }
}

class Queue {
    int front, rear, size;
    int capacity;
    int array[];

    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    // Queue is full when size becomes
    // equal to the capacity
    boolean isFull(Queue queue) {
        return (queue.size == queue.capacity);
    }

    // Queue is empty when size is 0
    boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }

    // Method to add an item to the queue.
    // It changes rear and size
    void enqueue(int item) {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1)
                % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;

    }

    // Method to remove an item from queue.
    // It changes front and size
    int dequeue() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front = (this.front + 1)
                % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    // Method to get front of queue
    int front() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    // Method to get rear of queue
    int rear() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }
}

class Stack {
    //easy to do
    private int size;
    private int[] data;

    public Stack(int maxSize) {
        data = new int[maxSize];
        size = 0;
    }


    public boolean contain(int a) {
        for (int i = 0; i < data.length; i++)
            if (data[i] == a)
                return true;

        return false;
    }

    public void push(int value) {
        if (size >= data.length)
            throw new RuntimeException("Stack full");
        data[size] = value;
        size++;
    }


    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Stack empty");
        size--;
        return data[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int top() {
        int top = pop(); // Get the top
        push(top);       // Put it back
        return top;
    }

    public void clear() {
        // size = 0; is O(1)
        // This is O(n):
        while (!isEmpty())
            pop(); // Ignore the result
    }

    public void swap() {
        int top, second;
        top = pop();
        second = pop();
        push(top);    // Push the top first
        push(second); // The second becomes the top
    }
}

class Node {
    int data;
    Node next;
    boolean visited;

    Node(int d) {
        data = d;
        next = null;
        visited = false;
    }
}

class LinkedList {
    int sizeL;
    Node head; // head of list

    /* Linked list Node*/


    /* function to insert a
new_node in a list. */
    void sortedInsert(Node new_node) {
        Node current;

        /* Special case for head node */
        if (head == null || head.data
                >= new_node.data) {

            new_node.next = head;
            head = new_node;
            sizeL++;
        } else {

            /* Locate the node before point of insertion. */
            current = head;

            while (current.next != null
                    && current.next.data < new_node.data)
                current = current.next;

            new_node.next = current.next;
            current.next = new_node;
            sizeL++;
        }
    }

    public int Size() {
        int result = 0;
        Node first = head;

        while (first != null) {
            result++;
            first = first.next;
        }

        return result;
    }

    /*Utility functions*/

    /* Function to create a node */
    Node newNode(int data) {
        Node x = new Node(data);
        return x;
    }

    public int[] returnAllvalue() {
        int[] array = new int[Size()];
        int count = 0;
        Node first = head;
        while (first != null) {
            array[count++] = first.data;
            first = first.next;
        }

        return array;

    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

class Graph {
    LinkedList[] arr;
    int size;

    public Graph(int num) {

        arr = new LinkedList[size = num];
        for (int j = 0; j < arr.length; j++)
            arr[j] = new LinkedList();


    }


    public void addEdge(int i, int j) {
        arr[i].sortedInsert(arr[i].newNode(j));
        //  arr[j].sortedInsert(arr[j].newNode(i));

    }


    public void printGraph() {
        for (int i = 0; i < size; i++) {
            if (arr[i].sizeL > 0) {
                System.out.print("Vertex " + i + " is connected to: ");

                System.out.print(" ");
                arr[i].printList();

                System.out.println();
            }
        }
    }


    /******
     *  DEPTH FIRST SEARCH A VALUE INT (N)
     *
     *
     */

    //    public void printDepth() {
    //        depthFirstTravel(arr[0]);
    //    }
    public void printDepth() {
        boolean[] visited = new boolean[size];
        depthFirstTravel(2, visited);
    }


    public void depthFirstTravel(int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");
/// count in deg of this number if
        Node check = arr[curr].head;


        while (check != null) {
            if (!visited[check.data]) {
                depthFirstTravel(check.data, visited);
            }
            check = check.next;

        }


    }

    public void DFS(int num) {
        System.out.print("Depth First Traversal: ");
        boolean[] visited = new boolean[size];

        Stack stack = new Stack(size);


        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()) {
                    int nodeIndex = stack.pop();
                    System.out.print(nodeIndex + " ");
                    LinkedList temp = arr[nodeIndex];
                    Node check = temp.head;
                    while (check != null) {
                        if (!visited[check.data]) {
                            stack.push(check.data);
                            visited[check.data] = true;
                        }
                        check = check.next;

                    }


                }
            }

        }


    }

    //    public  void dfsUsingStack(Node node)
    //    {
    //        Stack<Node> stack=new  Stack<Node>();
    //        stack.add(node);
    //        while (!stack.isEmpty())
    //        {
    //            Node element=stack.pop();
    //            if(!element.visited)
    //            {
    //                System.out.print(element.data + " ");
    //                element.visited=true;
    //            }
    //
    //            List<Node> neighbours=element.getNeighbours();
    //            for (int i = 0; i < neighbours.size(); i++) {
    //                Node n=neighbours.get(i);
    //                if(n!=null && !n.visited)
    //                {
    //                    stack.add(n);
    //                }
    //            }
    //        }
    //    }
    public void test(int num) {
        boolean[] visited = new boolean[size];
        Arrays.fill(visited, false);


        int[] temp = arr[num].returnAllvalue();
        Stack stack = new Stack(size);

        for (int j : temp) stack.push(j);

        visited[num] = true;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            visited[value] = true;
            System.out.println(value);
            temp = arr[value].returnAllvalue();
            for (int j : temp) {
                if (!visited[j] && !stack.contain(j))
                    stack.push(j);

            }

        }


    }

    public void bfs() {
        boolean[] visited = new boolean[size];
        int[] pre = new int[size];
        bfs(0, visited, pre);

        System.out.println(Arrays.toString(pre));
    }

    public void bfs(int s, boolean[] visited, int[] previous) {
        int curr;
        Queue dot = new Queue(size * 2);

        visited[s] = true;
        System.out.print(s + " ");
        dot.enqueue(s);
        previous[0] = 0;
        while (!dot.isEmpty(dot)) {
            curr = dot.dequeue();

            Node check = arr[curr].head;


            while (check != null) {
                if (!visited[check.data]) {
                    previous[check.data] = curr;
                    visited[check.data] = true;
                    System.out.print(check.data + " ");
                    dot.enqueue(check.data);
                }

                check = check.next;
            }


        }


    }
}

class GraphArray {

    private int[][] adjMatrix;

    public GraphArray(int[][] am) {
        adjMatrix = am;
    } // end constructor

    public boolean isDirected() {


        for (int i = 0; i < adjMatrix.length; i++)
            for (int j = 0; j < adjMatrix[i].length; j++) {

                if ((adjMatrix[i][j] == 0 && adjMatrix[j][i] > 0) || (adjMatrix[i][j] > 0 && adjMatrix[j][i] == 0))
                    return true;
            }
        return false;


    }

    public int countEdges() {

        int symetric = 0;
        int norm = 0;

        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] > 0)
                    symetric++;


            }


        }
        if (isDirected()) {
            return symetric;
        }

        return (symetric / 2);

    }

    public int getNumEdgesIn(int vertex) {
        int result = 0;
        for (int i = 0; i < adjMatrix[vertex].length; i++)
            if (adjMatrix[i][vertex] > 0)
                result++;


        return result;

    }

    //
    public int getNumEdgesOut(int vertex) {
        int result = 0;
        for (int i = 0; i < adjMatrix[vertex].length; i++)
            if (adjMatrix[vertex][i] > 0)
                result++;


        return result;


    }

    public void dfs(int at) {
        boolean[] visited = new boolean[adjMatrix.length];
        dfs(at, visited, adjMatrix);
    }

    public void dfs(int at, boolean[] visited, int[][] matrix) {
        visited[at] = true;
        System.out.print(at + " ");

        for (int i = 0; i < matrix[at].length; i++) {

            if (matrix[at][i] > 0 && !visited[i])
                dfs(i, visited, matrix);
        }
    }

    public void BFS(int at) {
        boolean[] visited = new boolean[adjMatrix.length];
        bfs(at, visited, adjMatrix);
    }

    public void bfs(int at, boolean[] visited, int[][] matrix) {
        int curr;
        Queue dot = new Queue(adjMatrix.length * 2);

        visited[at] = true;
        System.out.print(at + " ");
        dot.enqueue(at);
        // previous[0] = 0;
        while (!dot.isEmpty(dot)) {
            curr = dot.dequeue();
            //            if(curr==end)
            //                System.out.print(true);
            for (int i = 0; i < adjMatrix[curr].length; i++) {
                if (!visited[i]) {
                    //    previous[i] = curr;
                    visited[i] = true;
                    System.out.print(i + " ");
                    dot.enqueue(i);
                }


            }

        }
    }
    /**
     * Find the path between given vertices in a directed graph
     * https://www.techiedelight.com/find-path-between-vertices-directed-graph/
     */


    public void bfs(int a,int b) {
        boolean[] visited = new boolean[adjMatrix.length];
        int[] pre = new int[adjMatrix.length];
        bfs(a,b, visited, pre);

        System.out.println(Arrays.toString(pre));
    }

    public void bfs(int s,int end, boolean[] visited, int[] previous) {
        int curr;
        Queue dot = new Queue(adjMatrix.length * 2);

        visited[s] = true;
        System.out.print(s + " ");
        dot.enqueue(s);
       // previous[0] = 0;
        while (!dot.isEmpty(dot)) {
            curr = dot.dequeue();
            if(curr==end)
                System.out.print(true);
            for(int i=0;i<adjMatrix[curr].length;i++)
            {
                if(!visited[i])
                {
                //    previous[i] = curr;
                    visited[i] = true;
                    System.out.print(i+ " ");
                    dot.enqueue(i);
                }


            }



        }


    }
}

class pratice {
    //////////////////////// graph find a path from a to b /////////////////////////
    public static void main(String[] args) {
        int[][] array = {{0, 40, 20, 20, 30, 80, 0, 0, 0, 0, 70, 0}, {0, 0, 0, 20, 40, 0, 0, 0, 0, 0, 5, 0}, {0, 0, 0, 0, 0, 30, 0, 50, 0, 0, 30, 30}, {0, 0, 10, 0, 0, 0, 0, 0, 0, 30, 50, 0}, {0, 0, 0, 0, 0, 0, 40, 0, 0, 20, 0, 20}, {10, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 60}, {0, 0, 30, 90, 0, 60, 0, 0, 0, 0, 80, 0}
                , {60, 0, 0, 50, 10, 0, 70, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 40, 0, 70, 0, 10}, {10, 60, 0, 0, 0, 80, 10, 0, 0, 0, 90, 0}, {20, 60, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0}, {0, 70, 60, 0, 0, 90, 0, 0, 0, 0, 0, 0}};
        GraphArray data = new GraphArray(array);
//
data.bfs(7,8);
    }

}
