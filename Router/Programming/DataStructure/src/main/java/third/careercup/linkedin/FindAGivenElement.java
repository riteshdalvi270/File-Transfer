package third.careercup.linkedin;

/**
 * Find a given element in a sorted array.
 * Created by ritesh on 1/5/16.
 */
public class FindAGivenElement {

    public static void main(String args[]) {

        int sortedArray[] = {1,2,3,4,5,6};

        System.out.println(search(sortedArray,0,sortedArray.length-1,9));

        // Followup: If the array is shifted by unknown number

        int shiftedSortedArray[] = {5,6,1,2,3,4};

        System.out.println(searchShiftedArray(shiftedSortedArray,0,shiftedSortedArray.length-1,6));

    }

    public static int search(int sortedArray[], int start, int end, int element) {

        int pivot = (start+end)/2;

        if(end < start) {
            return -1;
        }

        if(sortedArray[pivot] == element) {
            return pivot;
        }

        if(element < sortedArray[pivot]) {
            return search(sortedArray,start,pivot-1,element);
        } else if(element >  sortedArray[pivot]) {
            return  search(sortedArray,pivot+1,end,element);
        }

        return -1;
    }

    public static int searchShiftedArray(int shiftedSortedArray[], int start, int end, int element) {

        if(end > start) {
            if (shiftedSortedArray[start] == element) {
                return start;
            } else if (shiftedSortedArray[end] == element) {
                return end;
            }
        }else {
            return -1;
        }

        int pivot = (start+end)/2;

        if(shiftedSortedArray[pivot] == element) {
            return pivot;
        }

        if(element > shiftedSortedArray[pivot] && (element >= shiftedSortedArray[start])) {
            return searchShiftedArray(shiftedSortedArray,start,pivot-1,element);
        }

        if(element>shiftedSortedArray[pivot] && element < shiftedSortedArray[start]) {
            return searchShiftedArray(shiftedSortedArray,pivot+1,end,element);
        }

        if(element < shiftedSortedArray[pivot] && element < shiftedSortedArray[start]) {
            return searchShiftedArray(shiftedSortedArray,start,pivot-1,element);
        }

        return -1;
    }
}
