package careercupbook;

/**
 * Created by ritesh on 1/30/16.
 */
public class RemoveDuplicateCharactersFromString {

    public static void main(String args[]) {

        final String input = "FOLLOWUP";

        System.out.println(removeDuplicateCharactersFromStringAdditionalBuffer(input));

        System.out.println(removeDuplicateCharactersFromString(input));
    }

    //with additional buffer
    public static String removeDuplicateCharactersFromStringAdditionalBuffer(final String input) {

        StringBuffer output = new StringBuffer();

        boolean ascii[] = new boolean[256];

        for(int i = 0; i< input.length(); i++) {

            if(ascii[input.charAt(i)] == false)
            {
                ascii[input.charAt(i)] = true;
                output.append(input.charAt(i));
            }
        }

        return output.toString();
    }

    public static String removeDuplicateCharactersFromString(final String input) {

        StringBuffer output = new StringBuffer();
        boolean isDuplicate = false;

        for(int i=0; i<input.length(); i++) {

            for(int j=i+1; j<input.length(); j++) {

                if(input.charAt(i) ==  input.charAt(j)) {
                    isDuplicate = true;
                }
            }

            if(isDuplicate == false) {
                output.append(input.charAt(i));
            }

            isDuplicate = false;
        }

        return output.toString();
    }
}
