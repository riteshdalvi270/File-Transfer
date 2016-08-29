package second.crackingcode.dynamicprogramming;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class QueensNotRecursive
{

    //May be right.
    public void placeQueens(Queen[][] chessBoard, int row, int column, Queen[] queen)
    {

        // Placed first queen on 8*8
        chessBoard[row][column] = queen[0];
        queen[0].setPosition(row,column);

        int queensRemainingToBePlaced = 1;
        for (int i = row-1; i > 0; i--)
        {
            for (int j = column-1; j > 0; j++)
            {
                boolean canBePlaced = false;

                for(int q = 0;q<queensRemainingToBePlaced;q++)
                {
                    Queen alreadybeenPlaced = queen[q];
                    canBePlaced = alreadybeenPlaced.isColliding(queen[queensRemainingToBePlaced], i, j);

                }

                if (canBePlaced)
                {
                    chessBoard[i][j] = queen[queensRemainingToBePlaced];
                    queen[queensRemainingToBePlaced].setPosition(i, j);
                    queensRemainingToBePlaced++;
                    break;
                }
            }

        }
    }

    public class Queen
    {

        int queen;
        int row;
        int column;

        public Queen(int queen)
        {
            this.queen = queen;
        }

        public void setPosition(int row, int column)
        {
            this.row = row;
            this.column = column;
        }

        public int getRow()
        {
            return this.row;
        }

        public int getColumn()
        {
            return this.column;
        }

        public boolean isColliding(Queen queen, int row, int column)
        {
            int alreadyUsedcolumn = this.getColumn();
            int alreadyUsedRow = this.getRow();

            if(alreadyUsedcolumn == column) {
                return false;
            }

            if(alreadyUsedRow == row) {
                return false;
            }

            //Distance between the columns
            if(column - alreadyUsedcolumn <= 0) {
                return false;
            }

            return true;
        }
    }
}
