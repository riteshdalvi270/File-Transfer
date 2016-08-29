package third.geekforgeeks;

/**
 * Find square root of a number
 * Created by ritesh on 1/22/16.
 */
public class SquareRootOfANumber {

    public static void main(String args[]) {

        final int number = 15;

        System.out.println(squareRootOfANumber(number));

        System.out.println(binarySearchSquareRoot(number,0,number));
    }

    public static int squareRootOfANumber(final int number) {

        int positiveNumber = 1;

        while(positiveNumber*positiveNumber < number) {
            positiveNumber++;
        }

        return positiveNumber-1;
    }

    public static int binarySearchSquareRoot(final int number,int start, int end) {

        int mid = (start+end)/2;

        if(mid*mid < number) {
            mid = mid+1;

            while(mid*mid < number) {
                mid = mid+1;
            }
            return mid-1;
        }
        return binarySearchSquareRoot(number,start,mid-1);
    }
}
