package sort;

import java.util.Arrays;
import java.util.Arrays;


public class Quick_sort {

    public static void main(String args[]) {
        int arr[] = {5,9,7,0,3,1,2,8};

        System.out.println("Given Array");
        quickSort(arr);


        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }


    public static void quickSort(int a[]) {
        quickSort(a, 0, a.length);
    }

    public static void quickSort(int[] a, int start, int end) {


        int pivotPosn;
        if (2 == end - start) {
            if (a[start + 1] < a[start])
                swap(a, start, start + 1);
        } else if (2 < end - start) {
            choosePivot(a, start, end);
            pivotPosn = partition(a, start, end);
            // quick sort stop before the first recrusive
            // work with code
           quickSort(a, start, pivotPosn);

         quickSort(a, pivotPosn + 1, end);
        }


    }


    public static void swap(int[] a, int at, int to) {
        int temp = a[at];
        a[at] = a[to];
        a[to] = temp;
    }

    public static void choosePivot(int[] a, int start, int end) {
        int num1 = a[start];
        int num2 = a[(end + start) / 2];
        int num3 = a[end-1];
   int median=0;
if(num1>num2 &&num1<num3||num1<num2&&num1>num3)
    median=num1;
        if(num2>num1&&num2<num3||num2<num1&&num2>num3)
            median=num2;
        if(num3>num1&&num3<num2||num3<num1&&num3>num2)
            median=num3;


        for (int i = 0; i < a.length; i++) {
            if (a[i] == median)
                swap(a, 0, i);
            break;
        }
    }

    public static int partition(int[] a, int start, int end) {
        int bigStart = start + 1;
        int pivot = a[start];
        for (int curr = start + 1; curr < end; curr++) {
            if (a[curr] < pivot) { //belongs in smalls
                swap(a, bigStart, curr);
                bigStart++;
            }
//do nothing if it belongs in the bigs
        }//end for
        swap(a, start, bigStart - 1); //put pivot in place
        return bigStart - 1; //return pivot’s position

    }
}


