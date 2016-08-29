package second.crackingcode.dynamicprogramming;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class MagicNumber
{
    public static void main(String args[])
    {
        int a[] = {-2, -1, 0, 1, 2, 5, 9, 10};
        int a1[] = {-2,1,4,5,6,7,8,9};
        int index = findMagicNumber(a1,0,a1.length);

        System.out.print(index);
    }



    public static int findMagicNumber(int a[], int low, int high) {

        if(low>high) {
            return -1;
        }
        int middle = (low+high)/2;

        if(a[middle] == middle) {
            return middle;
        }

        if(middle > a[middle]) {
            return findMagicNumber(a,middle+1,high);
        } else if(middle < a[middle]) {
            return findMagicNumber(a,low,middle-1);
        }

        return -1;
    }
}
