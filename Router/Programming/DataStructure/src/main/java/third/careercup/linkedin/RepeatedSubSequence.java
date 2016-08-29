package third.careercup.linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * Find repeated subsequence.
 * Created by ritesh on 1/10/16.
 */
public class RepeatedSubSequence {

    public static void main(String args[]) {

        String repeatedSubsequence1 = "ABCACBABC";

        List<String> output1 = repeatedSubsequence(repeatedSubsequence1, 3);

        for(final String value : output1) {
            System.out.println(value);
        }

        String repeatedSubsequence2 = "ABCABCA";

        List<String> output2 = repeatedSubsequence(repeatedSubsequence2, 2);

        for(final String value : output2) {
            System.out.println(value);
        }


    }

    public static List<String> repeatedSubsequence(final String input, int repeatedLength) {

        List<String> repeatedSequence = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {

            if (i + repeatedLength > input.length()) {
                break;
            }
            String substring = input.substring(i, i + repeatedLength);

            for(int j = i+1; j< input.length(); j++) {

                if(j+repeatedLength > input.length()) {
                    break;
                }

                String sequence = input.substring(j,j+repeatedLength);

                if(substring.equals(sequence)) {

                    if(!repeatedSequence.contains(sequence)) {
                        repeatedSequence.add(sequence);
                    }
                }
            }
        }

        return repeatedSequence;
    }
}
