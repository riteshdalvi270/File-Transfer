package first.programminginterviewexposed;

import java.util.ArrayList;
import java.util.List;

//Does not work.
/**
 * Recursive approach for permuation of string.
 * Created by ritesh on 10/4/15.
 */
public class PermutationofString {

    public static void main(String args[]) {

        final String s = "hat";

        final List<String> permutations = new ArrayList<String>();

        permutationofString(s, permutations);
    }

    public static List<String> permutationofString(String s, List<String> permutations) {

        if (s == null) {
            return null;
        }

        if (s.isEmpty()) {
            permutations.add("");
            return permutations;
        }

        char firstChar = s.charAt(0);
        String remaining = s.substring(1);

        List<String> perm = permutationofString(remaining, permutations);


        for (String value : perm) {

            for (int i = 0; i <= value.length(); i++) {

                permutations.add(combine(value, firstChar, i));
            }
        }

        if(permutations.isEmpty()) {
            permutations.add(String.valueOf(firstChar));
        }

        return permutations;
    }

    public static String combine(final String value, final char firstChar, int  i) {
        String firstsubstring = value.substring(0, i);
        String secondsubstring = value.substring(i);

        final StringBuffer stringBuffer = new StringBuffer();

       return stringBuffer.append(firstsubstring).append(firstChar).append(secondsubstring).toString();
    }
}
