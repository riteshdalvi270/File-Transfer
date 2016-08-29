package first.careercuptop50.mathematics;

/**
 * Created by ritesh on 12/2/15.
 */
public class FibonacciNumbersIterative {

    public static void main(String args[]) {

        int a = 0;
        int b = 1;
        int sum = 0;

        int n = 10;

        System.out.println(a);
        System.out.println(b);

        while(n > 0) {

            sum = a + b;
            System.out.println(sum);
            a = b;
            b = sum;
            n--;
        }
    }
}
