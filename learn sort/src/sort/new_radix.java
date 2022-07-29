package sort;

import java.util.Arrays;

public class new_radix {


    // A utility function to get maximum value in arr[]
    public static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp) {
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        // Build the output array

        System.out.println(Arrays.toString(count));
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.out.println(Arrays.toString(count));

        System.out.println(Arrays.toString(output));
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
            break;
        }
    }

    // A utility function to print an array
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    /*Driver Code*/
    public static void main(String[] args) {
        int arr[] = {100, 54, 545, 42, 12, 486594, 89, 264, 84, 21, 64, 61, 32, 4685, 489, 4789, 4, 89, 5641, 321, 489, 654, 32156, 456, 465, 49847, 89, 75, 89, 74, 6241, 684, 9854, 6541, 65, 165, 45684, 654, 1651, 564, 9864, 69854, 561, 6531, 89654, 6541, 654, 6859};
        int n = arr.length;

        // Function Call
        radixsort(arr, n);
        print(arr, n);
    }
}

