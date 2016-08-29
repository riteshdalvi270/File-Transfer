package first.careercup.microsoft;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class ConvertStringToInteger
{
    // eg "1234" to 1234

    public static void main(String args[]) {

        final String value = "1234";

        int number = 0;

        for(int i = 0; i< value.length(); i++) {
            number = number * 10 + value.charAt(i) - '0';
        }

        System.out.println(number);
    }
}
