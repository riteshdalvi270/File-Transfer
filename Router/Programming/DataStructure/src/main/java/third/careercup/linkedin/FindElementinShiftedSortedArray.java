package third.careercup.linkedin;

/**
 * There is rotated sorted array.Write the program to find any element in that array
 Original Array A={1,2,3,5,6,7,8}
 Rotated Array B={5,6,7,8,1,2,3}

 Write the program to find any element in array B
 * Created by ritesh on 1/14/16.
 */
public class FindElementinShiftedSortedArray {

    public static void main(String args[]) {

        int[] input2 = {5, 6, 7, 8, 1, 2, 3};

        System.out.println(findAnElement(input2, 0, input2.length-1, 3));
    }

    public static int findAnElement(int[] input2, int start, int end, int element) {

        if (end < start) {
            return -1;
        }

        int pivot = (start + end) / 2;

        if (element == input2[pivot]) {
            return pivot;
        }

        if (element < input2[pivot] && element < input2[start]) {
            return findAnElement(input2, pivot + 1, end, element);
        } else if(element < input2[pivot] && element >= input2[start]) {
            return findAnElement(input2, start, pivot - 1, element);
        } else if(element > input2[pivot] && element >= input2[start]) {
            return findAnElement(input2,pivot+1,end,element);
        }

        return -1;
    }
}
