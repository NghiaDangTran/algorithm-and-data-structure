package sort;

import java.util.Arrays;

public class mergesort_book {

    static void merge(int[] a, int start, int mid, int end, int[] temp) {
        int currL = start;
        int currR = mid;
        int currT;
        int count = 0;

        for (currT = start; currT < end; currT++) {
            if (currL < mid && (currR >= end || a[currL] < a[currR])) {

                temp[currT] = a[currL];
                currL++;
            } else {//copy from right half

                temp[currT] = a[currR];
                currR++;
            }
        }
        for (currT = start; currT < end; currT++)

            a[currT] = temp[currT];
    }

    static int mergeEven(int[] arr, int start, int mid, int end, int[] temp) {
        int currL = start;
        int currR = mid;

        int count = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            if (currL < mid && (currR >= end || arr[currL] < arr[currR])) {
                if (arr[currL] % 2 == 0){

                    temp[  count++ ] = arr[currL];

                }
                currL++;
            } else {//copy from right half
                if (arr[currR] % 2 == 0) {

                    temp[count ++] = arr[currR];
                }
                currR++;
            }
        }


        return count;

    }

    static void mergeSort(int[] arr, int start, int end, int[] temp) {
        int mid;
        if (1 < end - start) {
            mid = start + (end - start) / 2;
            mergeSort(arr, start, mid, temp);
            mergeSort(arr, mid, end, temp);
           merge(arr, start, mid, end, temp);
// if the first recrusive run only mean left from start to mid is sorted
            // orthter wise both
        }
    }

    static void mergeSort(int[] arr, int start, int end)
    {

        mergeSort(arr,start,end,new int[arr.length]);
    }
    public static void main(String args[]) {
        int[] myNums = {10,3,1,13,6,12,17,24};
        mergeSort(myNums, 0, myNums.length);
System.out.println(Arrays.toString(myNums));
       //System.out.println(mergeEven(myNums,0,myNums.length/2, myNums.length, new int[ myNums.length]));
    }
}