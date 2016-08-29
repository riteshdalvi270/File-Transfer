package third.geekforgeeks;

/**
 * Find longest common subsequence.
 * Created by ritesh on 1/23/16.
 */
public class LongestCommonSubsequence {

    public static void main(String args[]) {

        final String input1 = "ABCDGH";
        final String input2 = "AEDFHR";

        System.out.println(findCommonSubsequenceRecursion(input1, input2, input1.length() - 1, input2.length() - 1));

        System.out.println(findCommonSubSequenceLameApproach(input1, input2));

        System.out.println(findCommonSubsequenceDynamicProgramming(input1, input2));


        final String input3 = "AGGTABCD";
        final String input4 = "GXTXAYBED";

        System.out.println(findCommonSubsequenceRecursion(input3, input4, input3.length() - 1, input4.length() - 1));

        System.out.println(findCommonSubSequenceLameApproach(input3, input4));
    }

    public static int findCommonSubSequenceLameApproach(final String input1, final String input2) {

        int max = 0;
        int counter = 0;
        for (int i = 0; i < input1.length(); i++) {

            int a = i;
            int j = 0;
            while (a < input1.length() && j < input2.length()) {
                if (input1.charAt(a) == input2.charAt(j)) {
                    a++;
                    j++;
                    counter++;
                } else {
                    j++;
                }

                if (j == input2.length()) {
                    j = a;
                    a++;
                }
            }

            if (counter > max) {
                max = counter;
            }
            counter = 0;
        }

        return max;
    }

    public static int findCommonSubsequenceRecursion(final String input1, final String input2, int length1, int length2) {

        if (length1 < 0 || length2 < 0) {
            return 0;
        }

        if (input1.charAt(length1) == input2.charAt(length2)) {
            return 1 + findCommonSubsequenceRecursion(input1, input2, length1 - 1, length2 - 1);
        } else {

            return Math.max(findCommonSubsequenceRecursion(input1, input2, length1 - 1, length2), findCommonSubsequenceRecursion(input1, input2, length1, length2 - 1));
        }
    }

    public static int findCommonSubsequenceDynamicProgramming(final String input1, final String input2) {

        int[][] dp = new int[input1.length()][input2.length()];

        for (int i = 0; i < input1.length(); i++) {
            for (int j = 0; j < input2.length(); j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 0; i <= input1.length()-1; i++) {

            for (int j = 0; j <= input2.length()-1; j++) {

                if ((i == 0 || j == 0)) {
                    dp[i][j] = 0;
                    continue;
                }

                if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[input1.length() - 1][input2.length() - 1];
    }
}
