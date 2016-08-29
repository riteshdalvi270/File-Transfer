package careercupbook;

/**
 * Created by ritesh on 1/30/16.
 */
public class ImplementArrayMerge {

    public static void main(String args[]) {

        int input1[] = {3,5,7,9};
        int input2[] = {1,2,4,6};

        int output[] = mergeTwoArrays(input1,input2);

        for(int i = 0; i< output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public static int[] mergeTwoArrays(int[] input1, int[] input2) {

        int i =0;
        int j =0;

        int[] output = new int[input1.length+input2.length];

        int a = 0;
        while(i<input1.length && j < input2.length) {

            output[a] = input1[i];
            a++;
            output[a] = input2[j];

            a++;
            i++;
            j++;
        }

        return output;
    }
}
