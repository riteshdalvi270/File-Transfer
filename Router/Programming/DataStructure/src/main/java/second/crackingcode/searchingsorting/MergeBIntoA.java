package second.crackingcode.searchingsorting;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class MergeBIntoA
{
    public void mergeSort(int a[], int b[], int length) {

        int alength = length-b.length;
        int blength = b.length;

        while(alength>0 && blength>0) {

            if(a[alength] > b[blength]) {
                a[length] = a[alength];
                alength--;
            } else {
                a[length] = b[blength];
                blength--;
            }

            length--;
        }
    }
}
