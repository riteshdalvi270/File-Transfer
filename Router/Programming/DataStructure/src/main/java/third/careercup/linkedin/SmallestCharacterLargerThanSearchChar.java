package third.careercup.linkedin;

import java.util.HashMap;

/**
 * Find smallest character larger than the search character
 * Created by ritesh on 1/10/16.
 */
public class SmallestCharacterLargerThanSearchChar {

    public static void main(String args[]) {

        final String sortedString = "cfjpv";
        final char searchChar = 'z';

        System.out.print(findNextChar(sortedString,searchChar));
    }

    public static char findNextChar(final String sortedString, final char searchChar) {

        char[] chars = sortedString.toCharArray();
        int min = 0;

        char ans = 0;
        char wrapAround = 0;

        for(final char value : chars) {

            if (Integer.valueOf(value) > Integer.valueOf(searchChar)) {
                int abs = Math.abs(searchChar - value);

                if (min == 0) {
                    min = abs;
                    ans = value;
                } else if (abs < min) {
                    min = abs;
                    ans = value;
                }
            }else {

                int abs = Math.abs(searchChar-value);

                if(min == 0) {
                    min = abs;
                    wrapAround = value;
                } else if(abs > min) {
                    min = abs;
                    wrapAround = value;
                }
            }
        }

        if(ans == 0) {
            return wrapAround;
        }

        return ans;
    }
}
