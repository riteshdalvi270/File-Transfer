package first.crackingthecode.searchingAndSorting;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array. You may assume the
 * array of originally sorted in increasing order.
 * @author Ritesh Dalvi (RD026600)
 */
public class RotatedSortedArray
{

    public static void main(String args[])
    {

        int[] rotatedArray = {4, 5,7, 10, 14,15, 16, 19, 20, 25, 1, 3};
        int searchValue = 5;


        long start= System.nanoTime();
        int index = searchAnElement(rotatedArray, searchValue);
        long end = System.nanoTime();

        System.out.println("Time Taken:"+(end - start));

        if (index == -1)
        {
            System.out.print("Not found");
        }
        else
        {
            System.out.print("found:" + index);
        }
    }

    public static int searchAnElement(int[] rotatedArray, int searchValue)
    {
        int low = 0;
        int high = rotatedArray.length;

        int middle = (low + high) / 2;

        // search left subarray
        if (rotatedArray[low] < searchValue)
        {
            return binarySearch(rotatedArray, low, middle, searchValue);
        }
        else if (rotatedArray[low] == searchValue)
        {
            return low;

        }
        else
        {
            return binarySearch(rotatedArray, middle + 1, high, searchValue);
        }

    }

    public static int binarySearch(int[] rotatedArray, int low, int high, int searchValue)
    {

        if (low > high)
        {
            return -1;
        }

        int middle = (low + high) / 2;

        if (searchValue < rotatedArray[middle])
        {
           return binarySearch(rotatedArray, low, middle - 1, searchValue);
        }
        else if (rotatedArray[middle] == searchValue)
        {
            return middle;
        }
        else if(searchValue > rotatedArray[middle])
        {
           return binarySearch(rotatedArray, middle + 1, high, searchValue);
        }

        return  -1;
    }
}
