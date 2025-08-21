class Solution {
    public boolean isSafe(char[][] board, int row, int col, char val) {
        //For Rows
        for (int i = 0; i <= 8; i++) {
            if(board[i][col] == val && i!=row)
                return false;
        }

        //For Columns
        for (int j = 0; j <= 8; j++) {
            if (board[row][j] == val && j != col)
                return false;
        }

        int newRow = row - row % 3;
        int newCol = col - col % 3;

        // for 3*3 grid
        for (int i = newRow; i < newRow + 3; i++) {
            for (int j = newCol; j < newCol + 3; j++) {
                if (board[i][j] == val && i!=row && j!=col){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char val = board[row][col];
                if (val != '.') {

                    if(!isSafe(board, row, col, val)){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}