package sort;

public class merge_sort {
    void merge1(int arr[], int l, int m, int r)
     {
        // Find sizes of two subarrays to be merged

//        int [] left=new int[m - l + 1];
//        int [] right= new int[r - m];
//
//            int countL=0;
//            int countR=0;
//        int counttemp=0;
//
//for (int i=0;i<m - l + 1;i++)
//    if (arr[i]%2==0)
//        left[countL++]= arr[i];
//
//         for (int i=0;i<r - m;i++)
//             if (arr[i]%2==0)
//                 right[countR++]= arr[i];
//
//
//
//
//for ( int i=0;i<left.length;i++)
//    for (int j=0;j<right.length;j++)
//        if()






        /* Create temp arrays */
        int L[] = new int[m - l + 1];
        int R[] = new int[r - m];
        int countL = 0;
        int countR = 0;
        /*Copy data to temp arrays*/
        for (int i = 0; i < m - l + 1; ++i)

                L[countL++] = arr[l + i];
        for (int j = 0; j < r - m; ++j)

                R[countR++] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < countL && j < countR) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            // the thing in here imagin the array has 2 pointer
            // the first pointer stay of the left of the first array
            // the second pointer stay on ther right of the second array
            // we will check if left>right copy right into array increasr right pointer to 1
            // if right >left copy left into array
        }

        /* Copy remaining elements of L[] if any */
        while (i < m - l + 1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < r - m) {
            arr[k] = R[j];
            j++;
            k++;
        }


    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, m + 1, r );

            sort(arr, l, m);

            // Merge the sorted halves
            merge1(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        int[] arr = {17, 35, 3, 6, 9, 0, 21, 1};
        int[] temp = {};
        System.out.println("Given Array");
        printArray(arr);

        merge_sort ob = new merge_sort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
        // wrotse case o(nlogn)
    }
}
