package third.crackingcode.arraystring;

/**
 * Replace all spaces in a string with %20.
 * Created by ritesh on 12/12/15.
 */

public class ReplaceSpaces {
    public static void main(String args[]) {

        String stringWithSpaces = "Mr John Smith    ";
        int n = 13;

        System.out.println(replaceSpaces(stringWithSpaces, n));
    }

    private static char[] replaceSpaces(final String stringWithSpaces, int length) {


        int totalLength = stringWithSpaces.length();
        int count = totalLength-1;
        char[] chars = stringWithSpaces.toCharArray();

        for (int i = length-1; i >= 0; i--) {

            if (chars[i] != ' ') {
                chars[count] = chars[i];
                count--;
            } else {

                if(chars[i] == ' ') {

                    final String replaceString = "%20";

                    char[] chars1 = replaceString.toCharArray();
                    int a = chars1.length-1;

                    while(a>=0) {

                        chars[count] = chars1[a];
                        count--;
                        a--;
                    }
                }
            }
        }

        return chars;
    }
}
