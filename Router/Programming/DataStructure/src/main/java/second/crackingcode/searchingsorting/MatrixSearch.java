package second.crackingcode.searchingsorting;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class MatrixSearch
{
    // made it too complicated. Use while loop.
    public boolean findElement(int[][] matrix, int element)
    {

        int row = matrix.length;
        int column = matrix[0].length;
        boolean startrow = false;
        boolean startcolumn = false;

        if(matrix[row][0] > element) {
            startcolumn = true;
        } else if(matrix[0][column] > element) {
            startcolumn =  true;
        }

        if(startrow ==  true)
        {
            int j = 0;
            for (int i = row; i > 0; i--)
            {
                if (matrix[i][j] > element)
                {
                    continue;
                }else
                {
                    if (matrix[i][j] < element)
                    {
                        for(int k = 0;k< column;k++) {
                            if(matrix[i][k] == element) {
                                return true;
                            }
                        }
                    }

                    break;
                }
            }
        } else if(startcolumn == true) {
            int i = 0;
            for (int j = column; j > 0; i--)
            {
                if (matrix[i][j] > element)
                {
                    continue;
                }else
                {
                    if (matrix[i][j] < element)
                    {
                        for(int k = 0;k<row;k++) {
                            if(matrix[k][j] == element) {
                                return true;
                            }
                        }
                    }

                    break;
                }
            }
        }

        return false;
    }
}
