package third.crackingcode.arraystring;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * Created by ritesh on 12/12/15.
 */
public class UniqueCharacters {

    public static void main(String args[]) {
        String s = "abcdfg";

        boolean value = uniqueString(s);

        System.out.println(value);
    }

    public static boolean uniqueString(final String s) {

        boolean[] unique = new boolean[256];

        char[] chars = s.toCharArray();

        for(final char ch : chars) {

            if(unique[ch] == true) {
                return false;
            }

            unique[ch] = true;
        }

        return true;
    }
}
