package careercupbook;

/**
 * Compute permutation of strings.
 * Created by ritesh on 1/30/16.
 */
public class PermutationOfString {

    public static void main(String args[]) {

        final String input = "ABC";

        findPermutationOfStrings(input, input.length()-1);
    }

    // Not a great approach
    public static void findPermutationOfStrings(final String input,int length) {

        if(length<0) {
            return;
        }

        swap(input,length);

        findPermutationOfStrings(input,length-1);
    }

    public static void swap(String input, int length) {

        for (int i = 0; i< input.length(); i++) {

            char[] chars = input.toCharArray();

            char first = chars[i];
            char swap = chars[length];

            char temp = swap;
            swap = first;
            first = temp;

            chars[i] = first;
            chars[length] = swap;

            System.out.println(String.valueOf(chars));
        }
    }
}
