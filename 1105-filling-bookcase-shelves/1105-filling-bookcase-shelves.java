class Solution {
    int n;
    int WIDTH;
    int t[1000][1001];
    public int solve(int[][] books ,int i , int remainW , int maxHt){

        // Base Case
        if(i >= n){
            return maxHt;
        }

        if(t[i][remainW] != -1){
            return t[i][remainW];
        }

        int bookW = books[i][0];
        int bookH = books[i][1];

        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        // keep
        if(bookW <= remainW){//Let's keep it here
            keep = solve(books , i+1, remainW - bookW , Math.max(maxHt , bookH)); 
        }

        //Skip and put in next shelf
        skip = maxHt + solve(books, i+1, WIDTH - bookW, bookH);

        return t[i][remainW] + Math.min(keep, skip);
    }

    public int minHeightShelves(int[][] books, int shelfWidth){
        memset(t, -1, sizeof(t));
        n = books.length;

        WIDTH = shelfWidth;

        return solve(books , 0 , shelfWidth , 0);
    }
}