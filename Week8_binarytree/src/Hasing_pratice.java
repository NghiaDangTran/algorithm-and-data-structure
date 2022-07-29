import java.util.Arrays;

public class Hasing_pratice {

    public static void main(String[] args) {
        int[] data1 = {10, 15, 4, 20};
        int[] data2 = {8, 4, 2, 10};

        Union_Intersection.countOccurance(data1, data2);


    }
}

class Union_Intersection {//https://www.geeksforgeeks.org/union-intersection-two-linked-lists-set-3-hashing/
    static linkedlist_hash datafinal;

    public static void countOccurance(int[] arr1, int[] arr2) {
        datafinal = new linkedlist_hash(arr1.length + arr2.length);


        datafinal.add(arr1);


        int[] union = new int[arr1.length + arr2.length];
        int uSize = 0;

        int[] intersec = new int[arr1.length + arr2.length];
        int Isize = 0;

        for (int i = 0; i < arr1.length; i++) {
            union[uSize++] = arr1[i];

        }
        for (int i = 0; i < arr2.length; i++) {
            if (datafinal.insisde(arr2[i]))
                intersec[Isize++] = arr2[i];
            else union[uSize++] = arr2[i];


        }

        Arrays.sort(union);
        Arrays.sort(intersec);
        System.out.println(Arrays.toString(union));
        System.out.println(Arrays.toString(intersec));

    }

}
