package sort;

import java.sql.Array;
import java.util.Arrays;
import java.util.List; // import just the List interface
import java.util.ArrayList; // import just the ArrayList class

public class Radic_sort_by_book {
    public static void main(String args[]) {
        int arr[] = {237,381,493,807,121,697,457,583};

        System.out.println("Given Array");
        RadixSort(arr, arr.length);


        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }


    public static void RadixSort(int[] array, int arraySize) {
        int[][] bucket = new int[10][arraySize];
        int[] bucket_count = new int[10];
        int i, j, k, r, NOP = 0, divisor = 1, lar, pass;
        lar = RadixGetMaxLength(array, arraySize);

        for (pass = 0; pass < lar; pass++) {
            for (i = 0; i < 10; i++) {
                bucket_count[i] = 0;
            }
            for (i = 0; i < arraySize; i++) {
                r = (array[i] / divisor) % 10;

                bucket[r][bucket_count[r]] = array[i];
                bucket_count[r] += 1;
            }

            i = 0;
            for (k = 0; k < 10; k++) {
                for (j = 0; j < bucket_count[k]; j++) {
                    array[i] = bucket[k][j];
                    i++;
                }


            }
            break;
        }
    }



    // Returns the maximum length, in number of digits, out of all elements in the array
    public static int RadixGetMaxLength(int[] array, int arraySize) {
        int maxDigits = 0;
        for (int i = 0; i < arraySize; i++) {
            int digitCount = RadixGetLength(array[i]);
            if (digitCount > maxDigits)
                maxDigits = digitCount;
        }
        return maxDigits;
    }

    // Returns the length, in number of digits, of value
    public static int RadixGetLength(int value) {
        if (value == 0)
            return 1;

        int digits = 0;
        while (value != 0) {
            digits = digits + 1;
            value = value / 10;
        }
        return digits;
    }





//  public static void  RadixSort(int []array, int arraySize) {
//      int[][] buckets = new int[10][];
//
//
//                // Find the max length, in number of digits
//           int     maxDigits = RadixGetMaxLength(array, arraySize);
//
//      int  pow10 = 1;
//        for (int digitIndex = 0; digitIndex < maxDigits; digitIndex++) {
//            int count=0;
//            for (int i = 0; i < arraySize; i++) {
//                int bucketIndex = GetLowestDigit(array[i] / pow10);
//                buckets[bucketIndex][count++] = array[i];
//            }
//            arrayIndex = 0
//            for (i = 0; i < 10; i++) {
//                for (j = 0; j < buckets[i].size(); j++) {
//                    array[arrayIndex] = buckets[i][j]
//                    arrayIndex = arrayIndex + 1
//                }
//            }
//            pow10 = pow10 * 10
//            Clear all buckets
//        }
//
//        negatives = all negative values from array
//        nonNegatives = all non - negative values from array
//        Reverse order of negatives
//        Concatenate negatives and nonNegatives into array
//    }


}
