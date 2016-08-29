package first.programminginterviewexposed;

/**
 * Created by ritesh on 10/17/15.
 */
public class TelephoneNumber {

    final static int phoneNumber[] = new int[9];
    final static char result[] = new char[9];

    public static void main(String args[]) {

        combination(0);
    }

    public static void combination(int start) {

        if(start == phoneNumber.length) {
            return;
        } else {
            for (int i = start; i < phoneNumber.length; i++) {

                //result[i] = getChar(phoneNumber[i],start);
                combination(i+1);

            }
        }
    }
}
