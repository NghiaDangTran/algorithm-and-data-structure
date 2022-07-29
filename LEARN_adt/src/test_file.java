public class test_file extends LINKED_List {

    public static void main(String[] args) {
        LINKED_List as = new LINKED_List();
        as.insertUnordered(1);
        as.insertUnordered(2);
        as.insertUnordered(3);
        as.insertUnordered(4
        );
        as.insertUnordered(5);
        as.insertLast(9);
        System.out.print(as);
    }


    public static int countOdd(int[] nums) {
        return countOdd(nums, 0);
    }

    public static int countOdd(int[] arr, int positons) {
        int result = 0;
        if (arr[positons] % 2 == 1)
            result += 1;
        if (positons == arr.length - 1)
            return result;


        return result + countOdd(arr, positons + 1);
    }
    /////////////////////////////////////// factorial


    public static int bunnyEars2(int nums) {
        int result = 0;
        if (nums % 2 == 0)
            result = 3;
        else result = 2;

        if (nums == 0)
            result = 0;
        else return result + bunnyEars2(nums - 1);
        return result;

    }


    public static void printline(char a, int nums) {
        if (nums == 0)
            return;
        else
            printline(a, nums - 1);
        System.out.print(a);


    }


}
