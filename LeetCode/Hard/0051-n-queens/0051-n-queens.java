class Solution {
    List<List<String>> result;
    int N;

    private boolean isSafe(List<String> board, int row, int col) {
        
        // Check column (upward)
        for (int r = 0; r < row; r++) {
            if (board.get(r).charAt(col) == 'Q') {
                return false;
            }
        }

        // Check left diagonal
        int r = row - 1, c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        // Check right diagonal
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < N) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        N = n;

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
            if (isSafe(board, row, col)) {
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                solve(row + 1, board);

                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }
}
