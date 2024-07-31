class Solution {
    int n;
    int WIDTH;
    int[][] t;

    public int solve(int[][] books, int i, int remainW, int maxHt) {
        // Base Case
        if (i >= n) {
            return maxHt;
        }

        if (t[i][remainW] != -1) {
            return t[i][remainW];
        }

        int bookW = books[i][0];
        int bookH = books[i][1];

        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        // keep
        if (bookW <= remainW) { // Let's keep it here
            keep = solve(books, i + 1, remainW - bookW, Math.max(maxHt, bookH));
        }

        // Skip and put in next shelf
        skip = maxHt + solve(books, i + 1, WIDTH - bookW, bookH);

        t[i][remainW] = Math.min(keep, skip);
        return t[i][remainW];
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        WIDTH = shelfWidth;
        t = new int[n][shelfWidth + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= shelfWidth; j++) {
                t[i][j] = -1;
            }
        }

        return solve(books, 0, shelfWidth, 0);
    }
}
