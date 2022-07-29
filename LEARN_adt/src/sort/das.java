package sort;

import java.util.Arrays;

   public class das
    {
        private  static int[] a;

        public static void sort(int[] arr)
        {
            a=arr;

            oddEvenMergeSort(0, arr.length);
        }

        /** sorts a piece of length n of the array
         *  starting at position lo
         */
        private static void oddEvenMergeSort(int lo, int n)
        {
            if (n>1)
            {
                int m=n/2;
                oddEvenMergeSort(lo, m);
                oddEvenMergeSort(lo+m, m);
                oddEvenMerge(lo, n, 1);
            }
        }

        /** lo is the starting position and
         *  n is the length of the piece to be merged,
         *  r is the distance of the elements to be compared
         */
        private static void oddEvenMerge(int lo, int n, int r)
        {
            int m=r*2;
            if (m<n)
            {
                oddEvenMerge(lo, n, m);      // even subsequence
               // oddEvenMerge(lo+r, n, m);    // odd subsequence
                for (int i=lo+r; i+r<lo+n; i+=m)
                    compare(i, i+r);
            }
            else
                compare(lo, lo+r);
        }

        private static void compare(int i, int j)
        {
            if (a[i]>a[j])
                exchange(i, j);
        }

        private static void exchange(int i, int j)
        {
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
        }
        public static void main(String args[]) {
            int[] myNums= { 12, 1, 5, 9, 31, 2, 18, 91 };
            sort(myNums);

            System.out.println(Arrays.toString(myNums));
        }
    }

    // end cl

