package third.careercup.linkedin;

/**
 * Check if string is a number.
 * Created by ritesh on 1/16/16.
 */
public class CheckStringIsNumber {

    public static void main(String args[]) {

        final String input1 = "12(9+/";
        final String input2 = "$1(9+/";
        final String input3 = "<12(9+/>";
        final String input4 = "129";

        final String[] inputs = new String[]{input1,input2,input3,input4};

        final String outcome = isANumber(inputs);

        if(outcome == null) {
            System.out.println("Not a number");
        }else {
            System.out.print("Its a number:"+outcome);
        }
    }

    public static String isANumber(final String[] inputs) {

        for(final String input : inputs) {

            final char[] charInputs = input.toCharArray();

            boolean isNumber = false;
            for(final char charInput : charInputs) {

                int number = Integer.valueOf(charInput);

                if(number >=48 & number<=57) {
                    isNumber = true;
                }else {
                    isNumber = false;
                    break;
                }
            }

            if(isNumber == true) {
                return input;
            }
        }

        return null;
    }
}
