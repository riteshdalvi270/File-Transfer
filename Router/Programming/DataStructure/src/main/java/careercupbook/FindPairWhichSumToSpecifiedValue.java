package careercupbook;

import java.util.ArrayList;
import java.util.List;

/**
 * find pair in array which sum to specified value
 * Created by ritesh on 1/30/16.
 */
public class FindPairWhichSumToSpecifiedValue {

    public static void main(String args[]) {

        int input[] = new int[]{1, 5, 6, 9, 2, 5};

        int sum = 7;

        List<Pair> pairs = findPairWhichSumUpLameApproach(input,sum);

        for(Pair pair : pairs) {
            System.out.println("{X:"+pair.x+",Y:"+pair.y+"}");
        }
    }

    public static List<Pair> findPairWhichSumUpLameApproach(int[] input, int sum) {

        List<Pair> pairs = new ArrayList<>();

        for(int i = 0 ; i< input.length; i++) {

            for(int j = i+1; j<input.length ;j++) {

                if(input[i]+input[j] == sum) {
                    Pair pair = new Pair(input[i],input[j]);

                    pairs.add(pair);
                }
            }
        }

        return pairs;
    }

    public

    static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
