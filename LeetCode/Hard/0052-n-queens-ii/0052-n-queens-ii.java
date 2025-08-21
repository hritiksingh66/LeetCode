class Solution {
    int res = 0;
    int N;
    Set<Integer> columns;
    Set<Integer> diag;
    Set<Integer> antiDiag;
    public int totalNQueens(int n){

        N = n;
        columns = new HashSet<>();
        diag = new HashSet<>();
        antiDiag = new HashSet<>();

        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        solve(board,0);

        return res;
    }


    public void solve(List<String> board, int row){
        if(row >= N){
            res++;
            return;
        }


        for(int col = 0 ; col < N ; col++){
            int diagConst = row - col;
            int antiDiagConst = row + col;
            if(columns.contains(col) || diag.contains(diagConst) || antiDiag.contains(antiDiagConst)){
                continue;
            }

            columns.add(col);
            diag.add(diagConst);
            antiDiag.add(antiDiagConst);

            StringBuilder sb = new StringBuilder(board.get(row));
            board.set(row, sb.toString());

            solve(board,row+1);

            columns.remove(col);
            diag.remove(diagConst);
            antiDiag.remove(antiDiagConst);
            sb.setCharAt(col, '.');
        }
    }
}