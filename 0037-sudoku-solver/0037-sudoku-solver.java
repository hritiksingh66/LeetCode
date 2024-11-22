class Solution{
    private boolean solve(char[][] board,int row,int col){
        if(col==9){
            row++;
            col=0;
        }

        if(row==9){
            return true;
        }

        if(board[row][col] != '.'){
            return solve(board,row,col+1);
        }

        for(int i=1;i<=9;i++){
            char val = (char) ('0' + i);
            if(isSafe(board,row,col,val)){
                board[row][col] = val;
                
                if (solve(board, row, col + 1)) {
                    return true;
                }

                board[row][col]='.';
            }
        }
        return false;
    }
    
    public boolean isSafe(char[][] board,int row,int col,char val){
        //For Rows
        for(int i=0;i<=8;i++){
            if(board[i][col]== val)
                return false;
        }
        
        //For Columns
        for(int j=0;j<=8;j++){
            if(board[row][j] == val)
                return false;
        }
        
        row = row - row%3;
        col = col - col%3;
        
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(board[i][j] == val)
                    return false;
            }
        }

        return true;
    }
    
    public void solveSudoku(char[][] board){
        solve(board,0,0);
    }
}