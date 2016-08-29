package first.programminginterviewexposed;

/**
 * Created by ritesh on 10/17/15.
 */
public class ConbinationOfStringsRecursive {

    final static String input = "wxyz";
    final static StringBuffer output = new StringBuffer();

    public static void main(String args[]) {


        combinationOfStrings(0);
    }

    public static void combinationOfStrings(final int start) {

        for(int i = start; i<input.length(); i++) {
            output.append(input.charAt(i));

            System.out.println(output);

            if(i<input.length()) {
                combinationOfStrings(i+1);
            }

            output.setLength(output.length()-1);
        }
    }
}
