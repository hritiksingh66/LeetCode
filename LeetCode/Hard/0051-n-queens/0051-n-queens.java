class Solution {
    List<List<String>> result;
    int N;
    Set<Integer> columns;
    Set<Integer> diag;
    Set<Integer> antiDiag;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        N = n;

        columns = new HashSet<>(); 
        diag = new HashSet<>(); 
        antiDiag = new HashSet<>(); 

        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        solve(0, board);
        return result;
    }

    private void solve(int row, List<String> board) {
        if (row == N) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < N; col++) {
            int diagConst = row - col;
            int antiDiagConst = row + col;
            if(columns.contains(col) || diag.contains(diagConst) || antiDiag.contains(antiDiagConst)){
                continue;
            }

            columns.add(col);
            diag.add(diagConst);
            antiDiag.add(antiDiagConst);
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());

            solve(row + 1, board);

            columns.remove(col);
            diag.remove(diagConst);
            antiDiag.remove(antiDiagConst);
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }
    }
}
