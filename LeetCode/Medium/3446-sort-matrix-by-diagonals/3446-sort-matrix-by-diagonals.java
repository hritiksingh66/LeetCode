class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int row = 0; row < n; row++) {
            sort(row,0,grid,true);
        }

        for(int col = 1 ; col < n ; col++){
            sort(0,col,grid,false);
        }

        return grid;

    }

    void sort(int row,int col,int[][] grid, boolean des) {
        int n = grid.length; 

        List<Integer> li = new ArrayList<>();

        int r = row, c = col;

        while (r < n && c < n) {
            li.add(grid[r][c]);
            r++;
            c++;
        }
        if(des){
            Collections.sort(li, (a, b) -> b - a);
        }else{
            Collections.sort(li);
        }

        r = row;
        c = col;
        for(int el : li){
            grid[r++][c++] = el;
        }

    }

}