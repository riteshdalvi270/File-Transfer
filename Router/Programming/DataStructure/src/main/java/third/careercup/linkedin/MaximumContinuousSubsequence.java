package third.careercup.linkedin;

import assistant.Stack;

/**
 * Created by ritesh on 1/12/16.
 */
public class MaximumContinuousSubsequence {

    public static void main(String args[]) {

        int[] input1 = new int[]{-2, 11, -4, 13, -5, -2};

        System.out.println(findMaxSubSequence(input1));

        int[] input2 = new int[]{1, -3, 4, -2, -1, 6};

        System.out.println(findMaxSubSequence(input2));
    }

    //This is a better approach than this .. kundane algorithm
    public static int findMaxSubSequence(final int[] input) {

        int sum = 0;
        final java.util.Stack<Integer> stack1 = new java.util.Stack<>();

        int temporaryHold = 0;

        for (int i = 0; i < input.length; i++) {

            for (int j = i + 1; j < input.length; j++) {

                if (sum == 0) {

                    sum = input[i] + input[j];
                } else {
                    int temp = 0;
                    temp = temporaryHold == 0 ? sum + input[j] : temporaryHold + input[j];
                    if (temp > sum) {
                        sum = temp;
                        stack1.push(sum);
                    } else {
                        temporaryHold = temp;
                    }
                }

                if (!stack1.isEmpty() && temporaryHold > stack1.peek()) {
                    stack1.push(temporaryHold);
                }
            }

            sum = 0;
            temporaryHold = 0;
        }

        int max = 0;
        while (!stack1.isEmpty()) {

            try {
                int element = stack1.pop();

                if (max == 0) {
                    max = element;
                } else if (max < element) {
                    max = element;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return max;
    }
}
