import java.util.ArrayList;

public class HashClass {

    public static void main(String[] args) {

        //        String[] words = {"Hello", "Alaska", "Dad", "Peace", "assadasdafa", "zcxcz"};
        //        solutionKeyboard.solutionKeyboard(words);

        String[] words={"catt","bt","hat","tree"};
        String chars = "atach";

        System.out.println(solutionCOuntChars(words, chars));

    }

    /********
     * Maximum distance between two occurrences of same element in array
     *
     */

    public static int SolutionAMAXDIs(int[] array) {
        HashMap table = new HashMap();
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (table.get(array[i]) == -1)
                table.add(array[i], i);
            else max = Math.max(max, i - table.get(array[i]));


        }
        return max;
    }


    /********
     * . Keyboard Row
     *
     */
    static class solutionKeyboard {
        static HashMap map = new HashMap();

        public static void solutionKeyboard(String[] words) {
            setLevel("qwertyuiop", 1);
            setLevel("asdfghjkl", 2);
            setLevel("zxcvbnm", 3);
            ArrayList<String> result = new ArrayList<String>();
            for (int i = 0; i < words.length; i++) {
                if (CheckInoneRow(words[i]))
                    result.add(words[i]);


            }
            for (int j = 0; j < result.size(); j++) {
                System.out.print(result.get(j) + "  ");
            }

        }


        public static void setLevel(String S, int level) {

            for (int i = 0; i < S.length(); i++) {
                map.add(S.charAt(i), level);

            }


        }


        public static boolean CheckInoneRow(String word) {
            word = word.toLowerCase();
            int firstWord = map.get(word.charAt(0));


            for (int i = 1; i < word.length(); i++) {
                if (map.get(word.charAt(i)) != firstWord)
                    return false;

            }

            return true;

        }

    }

    /***********************************
     *
     * 1160. Find Words That Can Be Formed by Characters
     ************************************** */
    public static int solutionCOuntChars(String[] word, String chars) {
        int result = 0;
        HashMap map = new HashMap();

        for (int i = 0; i < chars.length(); i++) {
            if (map.get(chars.charAt(i)) == -1)
                map.add(chars.charAt(i), chars.charAt(i));

        }


        for (int i = 0; i < word.length; i++) {

            if (CheckCharin_Map(map, word[i])) {
                System.out.println(word[i]);
                result += word[i].length();
            }
        }
        return result;
    }

    public static boolean CheckCharin_Map(HashMap map, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (map.get(word.charAt(i)) == -1)
                return false;

        }


        return true;

    }
}


/**************+*****
 * class for hash
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
class HashEntry {

    private int key;
    private int value;


    public HashEntry(int key, int vbalue) {
        this.key = key;
        this.value = vbalue;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

class HashMap {

    private final static int SIZE = 128;

    HashEntry[] table;

    public HashMap() {
        table = new HashEntry[SIZE];


        for (int i = 0; i < SIZE; i++)
            table[i] = null;


    }

    //    public int countNumberof()

    public int get(int key) {
        int hash = key % SIZE;

        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % SIZE;


        if (table[hash] == null)
            return -1;
        else return table[hash].getValue();
    }


    public void add(int key, int value) {

        int hash = key % SIZE;

        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % SIZE;
        table[hash] = new HashEntry(key, value);
    }

    public void delete(int key) {
        int hash = key % SIZE;

        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % SIZE;
        table[hash] = null;
    }

}


