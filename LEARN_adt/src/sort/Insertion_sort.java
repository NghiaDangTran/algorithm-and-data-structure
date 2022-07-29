package sort;

import java.util.Arrays;

public class Insertion_sort {
    public static void main(String[] args) {

        int[] data = {20,60,30};
        Selection_sort(data);
        System.out.println((Arrays.toString(data)));
    }

    public static void Insertion_sort(int[] data) {
        int siftValue;
        int j;
        for (int i = 1; i < data.length; i++) {
            siftValue = data[i];

            j = i - 1;
            while (j >= 0 && data[j] > siftValue) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = siftValue;


        }
        // the worste case reuning o(n*n) usefull for small list or nearly sorted one
    }

    public static void Selection_sort(int[] data) {
        int largest, temp;
        for (int i = 0; i < data.length - 1; i++) {
            largest = 0;
            for (int j = 0; j < data.length - i; j++) {
                if (data[largest] > data[j])
                    largest=j;
            }
            temp=data[data.length-1-i];
            data[data.length-1-i]=data[largest];
            data[largest]=temp;
        }

        //worst case ins O(n*n) Note that O(n2) comparisons are done but only O(n) data moves.  Use selection over insertion if moving data is costl
    }

    public static void bubble_sort(int[] data) {
        int temp;
        for(int i=0;i<data.length-1;i++)
            for(int j=0;j< data.length-1-i;j++)
                if(data[j]<data[j+1]) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1]=temp;
                }
        //wroste case O(n^2);
    }

    public class merge_sort
    {
        public merge_sort(int [] data)
        {

        }

    }


    public static boolean innerLarge(int[] numb)
    {
        return  innerLarge(numb,0, numb.length-1, numb.length/2);
    }


    public static  boolean innerLarge(int[] numb,int start, int end, int middel)
    {boolean result=false;

int mid=numb[start]+numb[end];
        if (start==end)
            return result;
        if( numb[start+1]>=mid && numb[end-1]>=mid)
            result=true;

        else result=innerLarge( numb, start+1,  end-1, middel);
        return  result;
    }
    public static int cal(int a, int b)
    {int result=0;
    if(a==0)
       return result=b+1;
    if(b==0)
        result=cal(a-1,1);
    else result=cal(a-1,cal(a,b-1));
    return result;

    }
}
