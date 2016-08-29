package first.crackingthecode.dynamicprogramming;

/**
 * Determine magic number in an array.
 * @author Ritesh Dalvi (RD026600)
 */
public class MagicNumber
{

    public static void main(String args[]) {

        //Distinct elements.
        int a[] = {-3, -2,-1,0,5,6,6,6};

        boolean magicNumber = findMagicNumber(a, 0, a.length-1);
        System.out.println(magicNumber);

        boolean magicNumberNotDistinct = findMagicNumberNotDistinct(a,0,a.length-1);
        System.out.println(magicNumberNotDistinct);
    }

    //Distinct elements
    public static boolean findMagicNumber(int a[], int low, int high) {

        if(low>high) {
            return false;
        }

        int middle = (low+high)/2;

        // search right
        if(middle> a[middle]) {
            return findMagicNumber(a,middle+1,high);
        } else if (middle < a[middle]) {
            return findMagicNumber(a,low,middle-1);
        } else if(middle == a[middle]) {
            return true;
        }

        return false;
    }

    // Refer to cracking code example.
    public static boolean findMagicNumberNotDistinct(int a[], int low, int high) {

        if(low>high) {
            return false;
        }

        int middle = (low+high)/2;

        if(middle ==  a[middle]) {
            return true;
        }

        int leftmin = Math.min(middle,a[middle]);

        if(leftmin == middle) {
            leftmin++;
        }

        if(leftmin == a[middle]) {
            return findMagicNumberNotDistinct(a,low,leftmin - 1);
        }

        int rightmin = Math.max(middle,a[middle]);

        if(rightmin == middle) {
            rightmin++;
        }

        if(rightmin == a[rightmin]) {
            return true;
        } else {
            findMagicNumberNotDistinct(a,rightmin+1,high);
        }

        return false;
    }
}
