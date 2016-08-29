package third.careercup.linkedin;

/**
 * Created by ritesh on 1/14/16.
 */
public class ReverseStringRecursive {

    public static void main(String args[]) {

        final String input1 = "This is a test";

        StringBuffer output1 = reverseAString(input1.toCharArray(), 0, new StringBuffer());

        System.out.println(output1.toString());


        final String input2 = "Say Hello";

        StringBuffer output2 = reverseAString(input2.toCharArray(), 0, new StringBuffer());

        System.out.println(output2.toString());
    }

    public static StringBuffer reverseAString(final char[] input1, int length, StringBuffer output) {

        if (length == input1.length - 1) {
            return output.append(input1[length]);
        }

        output = reverseAString(input1, length + 1, output);

        output.append(input1[length]);

        return output;
    }
}
