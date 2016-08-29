package first.crackingthecode.searchingAndSorting;

/**
 * Given an M*N matrix in which each row and column is sorted in ascending order, write a method to find an element.
 * @author Ritesh Dalvi (RD026600)
 */
public class MatricSearchEliminationApproach
{
    public boolean findAnElement(int[][] a,int element) {

        int row = 0;
        int column = a.length -1;

        while(row <=a.length-1 && column >= 0) {

            if(element < a[row][column]) {
                column--;
            } else if(element > a[row][column]) {
                row++;
            } else if(element ==  a[row][column]) {
                return true;
            }
        }

        return false;
    }
}
