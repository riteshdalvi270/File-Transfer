package second.crackingcode.searchingsorting;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class FindElementInRotatedArray
{
    public static void main(String args[])
    {

        int a[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int a1[] = {7, 10, 14, 15, 16, 19, 20, 25, 1, 3, 4, 5};
        int a2[] = {1,3,4,5,7, 10, 14, 15, 16, 19, 20, 25};
        int index = findElementInSortedArray(a2, 0, a2.length, 5);
        if (index == -1)
        {
            System.out.println("Not found");
        }
        else
        {
            System.out.println("Found" + index);
        }
    }

    public static int findElementInSortedArray(int array[], int low, int high, int element)
    {

        int middle = (low + high) / 2;
        if (array[low] > element)
        {

            return binarySearch(array, middle + 1, high, element);
        }
        else
        {
            return binarySearch(array, low, middle, element);
        }
    }

    public static int binarySearch(int array[], int low, int high, int element)
    {

        if (low > high)
        {
            return -1;
        }

        int middle = (low + high) / 2;

        if (array[middle] == element)
        {
            return middle;
        }

        if (array[middle] > element)
        {
            return binarySearch(array, low, middle - 1, element);
        }
        else
        {
            return binarySearch(array, middle + 1, high, element);
        }
    }
}
