package careercupbook;

/**
 * Created by ritesh on 1/30/16.
 */
public class FindContinuousSequenceWithLargestSum {

    public static void main(String args[]) {

        int[] input = new int[]{2,-8,3,-2,4,-10};

        System.out.println(findContinuousSequenceWithLargestSum(input));

        int[] input1 = new int[]{-2, 11, -4, 13, -5, -2};

        System.out.println(findContinuousSequenceWithLargestSum(input1));

        int[] input2 = new int[]{1, -3, 4, -2, -1, 6};

        System.out.println(findContinuousSequenceWithLargestSum(input2));
    }

    public static int findContinuousSequenceWithLargestSum(final int[] input) {

        int max_ending = 0;
        int max_sofar = 0;

        for(int i = 0; i< input.length; i++) {

            max_ending = max_ending + input[i];

            if(max_ending < 0) {
                max_ending = 0;
            }else if(max_sofar < max_ending) {
                max_sofar = max_ending;
            }
        }

        return max_sofar;
    }
}
