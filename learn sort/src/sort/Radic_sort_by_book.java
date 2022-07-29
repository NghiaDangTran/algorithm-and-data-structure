//package sort;
//
//import java.sql.Array;
//import java.util.Arrays;
//import java.util.List; // import just the List interface
//import java.util.ArrayList; // import just the ArrayList class
//
//public class Radic_sort_by_book {
//    public static void main(String args[]) {
//        int arr[] = {100, 54, 545, 42, 12, 486594, 89, 264, 84, 21, 64, 61, 3};
//
//        System.out.println("Given Array");
//        RadixSort(arr, arr.length);
//
//
//        for (int i = 0; i < arr.length; i++)
//            System.out.print(arr[i] + " ");
//    }
//
//
//    public static void RadixSort(int[] array, int arraySize) {
//        int[][] buckets = new int[10][100];
//        // Find the max length, in number of digits
//        int maxDigits = RadixGetMaxLength(array, arraySize);
//
//        // Start with the least significant digit
//        int pow10 = 10;
//
//        for (int digitIndex = 0; digitIndex < maxDigits; digitIndex++) {
//
//            for (int i = 0; i < arraySize; i++) {
//                int bucketIndex = Math.abs(array[i] / pow10) % 10;
//                for (int j = 0; j < buckets[bucketIndex].length; j++)
//                    if (buckets[bucketIndex][j] == 0)
//                        buckets[bucketIndex][j] = array[i];
//            }
//
//
//            int arrayIndex = 0;
//            for (int i = 0; i < 10; i++) {
//                for (int j = 0; j < count_smallest(buckets, i); j++)
//                    if(arrayIndex<array.length)
//                    array[arrayIndex++] = buckets[i][j];
//            }
//
//            pow10 = 10 * pow10;
//            buckets = new int[10][100];
//        }
//    }
//
//    public static int find_nextEmtpy(int[][] array, int positoon) {
//        int count = 0;
//        for (int i = 0; i < array[positoon].length - 1; i++) {
//            if (array[positoon][i] == 0)
//                return i;
//        }
//        return 0;
//        Queue a = new Queue(4);
//        a.enqueue(1);
//        a.enqueue(3);
//        a.enqueue(5);
//        a.enqueue(7);
//        Queue b = new Queue(5);
//        b.enqueue(0);
//        b.enqueue(2);
//        b.enqueue(4);
//        b.enqueue(6);
//        b.enqueue(8);
//
//        Queue c = Double(b, a);
//        a.print();
//
//
//        System.out.println(areEqual(a, b));
//
//        int[] data = {73, 74, 75, 71, 69, 72, 76, 73};
//
//        System.out.println(Arrays.toString(dataWeatrher(data)));
//        //  c.print();
//
//    }
//
//    // Returns the maximum length, in number of digits, out of all elements in the array
//    public static int RadixGetMaxLength(int[] array, int arraySize) {
//        int maxDigits = 0;
//        for (int i = 0; i < arraySize; i++) {
//            int digitCount = RadixGetLength(array[i]);
//            if (digitCount > maxDigits)
//                maxDigits = digitCount;
//        }
//        return maxDigits;
//    }
//
//    // Returns the length, in number of digits, of value
//    public static int RadixGetLength(int value) {
//        if (value == 0)
//            return 1;
//
//        int digits = 0;
//        while (value != 0) {
//            digits = digits + 1;
//            value = value / 10;
//        }
//        return digits;
//    }
//
//
//    public static int count_smallest(int[][] array, int position) {
//        int count = 0;
//        for (int i = 0; i < array[position].length; i++) {
//            if (array[position][i] != 0)
//                count++;
//
//        }
//
//
//        return count;
//
//    }
//
//
////  public static void  RadixSort(int []array, int arraySize) {
////      int[][] buckets = new int[10][];
////
////
////                // Find the max length, in number of digits
////           int     maxDigits = RadixGetMaxLength(array, arraySize);
////
////      int  pow10 = 1;
////        for (int digitIndex = 0; digitIndex < maxDigits; digitIndex++) {
////            int count=0;
////            for (int i = 0; i < arraySize; i++) {
////                int bucketIndex = GetLowestDigit(array[i] / pow10);
////                buckets[bucketIndex][count++] = array[i];
////            }
////            arrayIndex = 0
////            for (i = 0; i < 10; i++) {
////                for (j = 0; j < buckets[i].size(); j++) {
////                    array[arrayIndex] = buckets[i][j]
////                    arrayIndex = arrayIndex + 1
////                }
////            }
////            pow10 = pow10 * 10
////            Clear all buckets
////        }
////
////        negatives = all negative values from array
////        nonNegatives = all non - negative values from array
////        Reverse order of negatives
////        Concatenate negatives and nonNegatives into array
////    }
//
//
//}
