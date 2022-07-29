//import java.util.Arrays;
//
//class MaxHeapclass {
//
//    private int[] heap;
//    private int heapSize; // number of items currently in the heap
//int maxItems;
//    public MaxHeapclass( int maxSize ) {
//        maxItems=maxSize;
//        heap = new int[ maxSize ];
//        heapSize = 0;
//    } // end constructor
//
//
//    public boolean isEmpty() {
//        return heapSize == 0;
//    } // end isEmpty
//
//
//    public boolean isFull() {
//        return heapSize >= heap.length;
//    } // end isFull
//
//
//    /************************************************************
//     * parent
//     *
//     * PURPOSE:
//     *    Returns the index of the parent of the item at index i
//     *    (doesn't check if there is a parent).
//     *
//     ************************************************************/
//    public static int parent( int i ) {
//        return (i-1)/2;
//    } // end parent
//
//
//    /************************************************************
//     * rightChild
//     *
//     * PURPOSE:
//     *    Returns the index of the right child of the
//     *    item at index i (doesn't check if there is a
//     *    right child).
//     ************************************************************/
//    public static int rightChild( int i ) {
//        return 2 * i + 2;
//    } // end rightChild
//
//
//    /************************************************************
//     * leftChild
//     *
//     * PURPOSE:
//     *    Returns the index of the left child of the
//     *    item at index i (doesn't check if there is a
//     *    left child).
//     ************************************************************/
//    public static int leftChild( int i ) {
//        return 2 * i + 1;
//    } // end leftChild
//
//
//    /*************************************************************
//     *
//     * insert
//     *
//     * PURPOSE: Add a new item to the heap.
//     *
//     ******************************************************************/
//    public void insert( int priority ) {
//
//        if ( ! isFull() ) {
//            heap[ heapSize ] = priority;
//            heapSize++;
//            siftUp( heapSize-1 );
//        } // end if
//
//    } // end insert
//
//    /*************************************************************
//     *
//     * siftUp
//     *
//     * PURPOSE:
//     *    The item at heap[index] may have higher priority
//     *    than its parent, but no other problems exist in the heap.
//     *    Restore heap order by repeatedly moving its parent down
//     *    until either:
//     *    (1) the root was moved down, or
//     *    (2) its parent's priority is >= its priority.
//     *    Put the item into the "hole" created by the item last
//     *    moved down.
//     *
//     ******************************************************************/
//    private void siftUp( int index ) {
//        int toSift = heap[index]; // make a "hole" in the heap
//        int i = index;
//        int iParent = parent( index );
//
//        while ( i > 0 && heap[iParent] < toSift ) {
//            heap[i] = heap[iParent]; // move the "hole" up to the parent
//            i = iParent;
//            iParent = parent( i );
//        } // end while
//        heap[i] = toSift; // put the sifted item into the correct position
//
//    } // end siftUp
//
//    private boolean isLeaf(int pos) {
//        if (pos > (heapSize / 2) && pos <= heapSize) {
//            return true;
//        }
//        return false;
//    }
//
//    private void swap(int fpos, int spos) {
//        int tmp;
//        tmp = heap[fpos];
//        heap[fpos] = heap[spos];
//        heap[spos] = tmp;
//    }
//
//    // A recursive function to max heapify the given
//    // subtree. This function assumes that the left and
//    // right subtrees are already heapified, we only need
//    // to fix the root.
//    private void siftDown(int pos) {
//        int largest=pos;
//        int l=leftChild(pos);
//        int r=rightChild(pos);
//        if (l < heapSize && heap[l] > heap[largest])
//            largest = l;
//        if (r < heapSize && heap[r] > heap[largest])
//            largest = r;
//        if (largest != pos) {
//            int swap = heap[pos];
//            heap[pos] = heap[largest];
//            heap[largest] = swap;
//
//            // Recursively heapify the affected sub-tree
//            siftDown( largest);
//        }
//    }
//
//
//    public int deleteMax() {
//       int result = heap[0];
//       if(!isEmpty())
//       {heap[0]=heap[heapSize-1];
//           heapSize--;
//           siftDown(0);
//       }
//
//       else return Integer.MIN_VALUE;
//
//       return result;
//
//    }
//
//    public void Printarr() {
//        System.out.println(Arrays.toString(heap));
//
//    }
//
//    public void print() {
//       // System.out.println(heapSize);
//
//        for (int i = 0; i < heapSize / 2; i++) {
//            System.out.print(
//                    " PARENT : " + heap[i]
//                            + " LEFT CHILD : " + heap[2 * i +1]
//                            + " RIGHT CHILD :" + heap[2 * i +2]);
//            System.out.println();
//        }
//    }
//    public static void K_largest_ele(MaxHeapclass heap,int n)
//    {
//        for(int i=0;i<n;i++)
//            System.out.print(heap.deleteMax()+" ");
//
//
//
//
//    }
//
//
//    public static void main(String[] arg) {
//        System.out.println("The Max Heap is ");
//        //        MaxHeapclass maxHeap = new MaxHeapclass(15);
//        //        maxHeap.insert(74);
//        //        maxHeap.insert(5);
//        //        maxHeap.insert(26);
//        //        maxHeap.insert(43);
//        //        maxHeap.insert(89);
//        //        maxHeap.insert(52);
//        //        maxHeap.insert(68);
//        //        System.out.println(maxHeap.deleteMax());
//        //        System.out.println(maxHeap.deleteMax());
//        //        System.out.println(maxHeap.deleteMax());  System.out.println(maxHeap.deleteMax());
//        //        System.out.println(maxHeap.deleteMax());
//        //        System.out.println(maxHeap.deleteMax());System.out.println(maxHeap.deleteMax());System.out.println(maxHeap.deleteMax());
//        //        maxHeap.insert(66);
//        //        maxHeap.insert(67);
//        //        System.out.println(maxHeap.deleteMax());
//        //        System.out.println(maxHeap.deleteMax());
//        //        System.out.println(maxHeap.deleteMax());  System.out.println(maxHeap.deleteMax());
//        //        maxHeap.print();
//        //        maxHeap.Printarr();
//
//        int [] arr= {12,5,787,1,23};
//        MaxHeapclass maxHeap = new MaxHeapclass(arr.length*3);
//        for(int i=0;i<arr.length;i++)
//            maxHeap.insert(arr[i]);
//       // K_largest_ele(maxHeap,2);
//        ///////////k largest elements///////////
//
//
//
//
//
//    }
//} // end class MaxHeap