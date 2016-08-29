package first.programminginterviewexposed;

//Does not work.
/**
 * Created by ritesh on 10/17/15.
 */
public class CombinationOfStrings {

    public static void main(String args[]) {

        final String s = "wxyz";
        combinationOfStrings(s);
    }

    public static void combinationOfStrings(final String input) {

        StringBuffer temp = new StringBuffer(input.length()*4);

        final StringBuffer output = new StringBuffer(input.length()*4);
        for(int i = input.length() -1; i>=0; i--) {

            for(int j = 0; j<temp.length();j++) {

                output.append(String.valueOf(input.charAt(i)).concat(String.valueOf(temp.charAt(j))));
                System.out.println(output.toString());
            }

            output.append(input.charAt(i));
            temp = new StringBuffer(output);
        }

        System.out.println(output.toString());
    }
}
