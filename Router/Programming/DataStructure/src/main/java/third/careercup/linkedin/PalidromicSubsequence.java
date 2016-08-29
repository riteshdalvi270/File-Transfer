package third.careercup.linkedin;

import java.util.HashMap;
import java.util.Map;

/**
 * Maximum length palidrome
 * Created by ritesh on 1/6/16.
 */
public class PalidromicSubsequence {

    public static void main(String args[]) {

        int a[] = {4,1,2,3,4,5,6,4,6,5,4,4,4,4,4,4};

        System.out.println(maxLengthPalidromicSubsequence(a));

        final String palidromicSequence = "AABCDEBAZ";

        System.out.println(dplps(palidromicSequence.toCharArray(),0,palidromicSequence.length()-1,0));
    }

    // This is not palidrome subsequence. Subsequence of palidrome is achieved by removing elements. This is entirely wrong.
    public static int maxLengthPalidromicSubsequence(final int[] sequence) {

        HashMap<Integer,Integer> sequenceByLength = new HashMap<>();

        for(int i = 0 ; i< sequence.length; i++) {

            int value = sequence[i];

            if(sequenceByLength.get(value) == null)
            {
                sequenceByLength.put(value,1);
            }else {
                Integer counter = sequenceByLength.get(value);
                counter++;
                sequenceByLength.put(value,counter);
            }
        }

        int max = 0;
        for(final Map.Entry<Integer,Integer> entry : sequenceByLength.entrySet()) {

            Integer value = entry.getValue();

            if(value > max) {
                max = value;
            }
        }

        return max;
    }

    // Not sure if this solution is right.
    public static int dplps(final char[] sequence, int start, int end, int sequenceLength) {

        if(end < start) {
            return sequenceLength;
        }

        if(sequence[start] == sequence[end]) {
            sequenceLength = 2+dplps(sequence,start+1,end-1,sequenceLength);
            return sequenceLength;
        }

        return Math.max(dplps(sequence,start+1,end,sequenceLength) ,dplps(sequence,start,end-1,sequenceLength));
    }
}
