package first.crackingthecode.searchingAndSorting;

/**
 * Given two sorted arrays. A has large enough buffer at the end to hold B. Merge B into A in sorted order.
 * @author Ritesh Dalvi (RD026600)
 */
public class MergeArrayBIntoA
{
    // My logic is similar to the cracking code interview. Approach seems to differ. have a look once (seems to avoid second while loop).
    public void mergeArrays(int[] A, int[] B, int Alow, int Ahigh,int Aelement, int Blow, int Bhigh) {


        while(Alow < Ahigh) {

            if(A[Aelement] > B[Bhigh]) {
                A[Ahigh] = A[Aelement];
                Aelement--;
            } else {
                A[Ahigh] = B[Bhigh];
                Bhigh--;
            }

            Ahigh--;
        }

        // copy over remaining elements
        while(Blow < Bhigh) {

            A[Ahigh] = B[Bhigh];
            Bhigh--;
            Ahigh--;
        }
    }
}
