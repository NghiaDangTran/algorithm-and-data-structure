package sort;

import java.util.Arrays;
import java.util.List; // import just the List interface
import java.util.ArrayList; // import just the ArrayList class
public class Radic_sort {

    public static void main(String args[]) {
        int arr[] = {100,54,545,42,12,486594,89,264,84,21,64,61,32,4685,489,4789,4,89,5641,321,489,654,32156,456,465,49847,89,75,89,74,6241,684,9854,6541,65,165,45684,654,1651,564,9864,69854,561,6531,89654,6541,654,6859};

        System.out.println("Given Array");
        radixsort1(arr);


        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }


    public static void radixsort1(int[] array) {
        sort(find_bigest(array), array);
    }

    private static int find_bigest(int[] array) {
        int a = 0;
        String test = "";
        for (int i = 0; i < array.length; i++)
            if (a < array[i]) {
                a = array[i];


            }
        test = String.valueOf(a);
        return test.length();
    }

    private static void sort(int maxstep, int[] arr) {
        for (int b = 0; b < maxstep; b++) {


            int output[] = new int[arr.length]; // output array
            int i;
            int count[] = new int[10];
            Arrays.fill(count, 0);


            // Store count of occurrences in count[]
            for (i = 0; i < arr.length; i++) {
                String test = String.valueOf(Math.abs(arr[i]));
                char check;
                if (test.length() < maxstep)
                    check = '0';
                else
                    check = test.charAt(test.length() - 1 - b);

                count[Character.getNumericValue(check)]++;

            }
            System.out.println(Arrays.toString(count));
            // Change count[i] so that count[i] now contains
            // actual position of this digit in output[]
            for (i = 1; i < 10; i++)
                count[i] += count[i - 1];

            // Build the output array
            for (i = arr.length - 1; i >= 0; i--) {
                String test = String.valueOf(Math.abs(arr[i]));

                char check;

                if (test.length() < maxstep)
                    check = '0';
                else
                    check = test.charAt(test.length() - 1 - b);


                output[count[Character.getNumericValue(check)] - 1] = arr[i];
                count[Character.getNumericValue(check)]--;
            }
            System.out.println(Arrays.toString(count));

            // Copy the output array to arr[], so that arr[] now
            // contains sorted numbers according to curent digit
            for (i = 0; i < arr.length; i++)
                arr[i] = output[i];


        }
    }
}
    /*
   public void lsdradixsort(int* a, size_t n)
    {
        // isolate integer byte by index.
        auto bmask = [](int x, size_t i)
        {
            return (static_cast<unsigned int>(x) >> i*8) & 0xFF;
        };

        // allocate temporary buffer.
        auto m = std::make_unique<int[]>(n);
        int* b = m.get();

        // for each byte in integer (assuming 4-byte int).
        for ( size_t i, j = 0; j < 4; j++ ) {
            // initialize counter to zero;
            size_t h[256] = {}, start;

            // histogram.
            // count each occurrence of indexed-byte value.
            for ( i = 0; i < n; i++ )
                h[bmask(a[i], j)]++;

            // accumulate.
            // generate positional offsets. adjust starting point
            // if most significant digit.
            start = (j != 3) ? 0 : 128;
            for ( i = 1+start; i < 256+start; i++ )
                h[i % 256] += h[(i-1) % 256];

            // distribute.
            // stable reordering of elements. backward to avoid shifting
            // the counter array.
            for ( i = n; i > 0; i-- )
                b[--h[bmask(a[i-1], j)]] = a[i-1];
            std::swap(a, b);
        }
    }


}
     */
