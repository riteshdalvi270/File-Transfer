package third.geekforgeeks;

/**
 * Find longest repeating subsequence.
 * Created by ritesh on 1/23/16.
 */
public class LongestRepeatingSubSequence {

    public static void main(String args[]) {

        final String input = "axxxbbbbbbabbbacccccccc";
        int d[] = new int[input.length()];
        int counter = 0;

        int[] output = findLongestRepeatingSubSequence(input, d, input.length() - 1, counter);

        int max = 0;

        for (int i = 0; i < output.length; i++) {

            if (d[i] > max) {
                max = d[i];
            }
        }

        System.out.println(max);

        System.out.println(findLongestRepeatingSubsequenceDynamic(input));

        System.out.println("End of program");

    }

    //Recursive
    public static int[] findLongestRepeatingSubSequence(final String input, int d[], int length, int counter) {

        if (length < 0) {
            return d;
        }

        if (length != 0 && input.charAt(length) == input.charAt(length - 1)) {
            counter++;
        } else {
            d[length] = counter;
            counter = 0;
        }

        return findLongestRepeatingSubSequence(input, d, length - 1, counter);
    }

    //Dynamic programming
    public static int findLongestRepeatingSubsequenceDynamic(final String input) {

        int d[][] = new int[input.length()][input.length()];

        for (int i = 0; i < input.length(); i++) {

            d[i][i] = 0;
        }

        int max = 0;
        int value = 0;

        for (int i = 0; i < input.length(); i++) {

            for (int j = i + 1; j < input.length(); j++) {

                if (input.charAt(i) == input.charAt(j)) {

                    d[i][i] = d[i][i] + 1;
                } else {

                    break;
                }

                value = j;
            }

            if (i != 0) {
                max = Math.max(d[i][i], d[i - 1][i - 1]);
            }

            i = value;
        }

        return max;
    }
}
