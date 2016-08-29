package second.crackingcode.dynamicprogramming;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class QueensRecursive
{

    //Wrong. Refer to the book.
    public void placeQueens(Queen[][] chessBoard, Queen[] queens, int row, int column, int index) {

        int GRID_SIZE = 8;
        column =0;
        for(int col=0;col<GRID_SIZE;col++) {
            Queen queenTobePlaced = queens[index];

            boolean canBePlaced = queens[col].isColliding(queenTobePlaced,row,column);

            if(canBePlaced) {
                chessBoard[row][col] = queenTobePlaced;
            }

            placeQueens(chessBoard,queens,row-1,column,index+1);
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
