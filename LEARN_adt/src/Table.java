import java.util.*;
public class Table {
    public static void main(String args[]) {

        System.out.println(hashCode1("battery",27,211));
    }

    private static int hashCode1(String key, int a, int size) {
        int result = 0;
        for (int j = 0; j < key.length(); j++) {

            int letter = key.charAt(j) - 96;
            result = (result * a + letter) % size;
        }
        return result;
    }

    private int hashCode2(String key, int constance) {
        int sumString = 0;
        for (int i = 0; i < key.length(); i++)
            sumString += key.charAt(0) - 96;


        return constance - (sumString % constance);

    }


}
///Without Horner’s method:   s(s+1)/2 multiplications and s additions


class tabletest {

    int[] data;
    int size;

    public tabletest(int sizedata) {
        size = sizedata;
        data = new int[size];

    }


    public static int hashCode(String key, int a) {
        int hashVal = 0;
        int pow = key.length();

        for (int j = 0; j < key.length(); j++) {
            int letter = (int) key.charAt(j) - 97;
            pow--;
            hashVal += letter * (int) Math.pow(a, pow);
        }
        return hashVal;
    }


///////////////////simple hasing table//////////////




    public void add(String key)
    {
        data[hashCode(key,size) % size]=hashCode(key,size);




    }


    public boolean search(int key)
    {


        return  data[key] >0;


    }

    public int Retrieve(int key){

        return data[key];
    }


    public void delete(int key)
    {
        data[key]=0;
    }







///////////////////////open addresing/////////////////////////////











}