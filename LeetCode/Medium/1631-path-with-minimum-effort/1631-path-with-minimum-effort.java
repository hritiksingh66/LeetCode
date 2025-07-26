class Solution {
    int[][] DIRECTION = {{1,0},{0,-1},{-1,0},{0,1}};
    public int minimumEffortPath(int[][] heights){
        int rows = heights.length;
        int cols = heights[0].length;

        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> a.diff - b.diff);

        int[][] res = new int[rows][cols];

        for(int[] arr : res){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        pq.add(new Cell(0,0,0));
        res[0][0] = 0;

        while(!pq.isEmpty()){
            Cell p = pq.poll();

            if (p.x == rows - 1 && p.y == cols - 1) {
                return p.diff;
            }

            // int diff = p.diff;
            // int x = p.x;
            // int y = p.y;

            // if(x == row - 1 && y == cols -1){
            //     return res[x][y];
            // }

            for(int[] dir : DIRECTION){
                int nx = p.x+dir[0];
                int ny = p.y+dir[1];


                if(isSafe(nx,ny,rows,cols)){
                    int heightDiff = Math.abs(heights[nx][ny] - heights[p.x][p.y]);
                    int maxEffort = Math.max(p.diff, heightDiff);
                    if(maxEffort < res[nx][ny]){
                        res[nx][ny] = maxEffort;
                        pq.add(new Cell(res[nx][ny],nx,ny));
                    }
                }
            }
        }

        return res[rows-1][cols-1];        
    }

    public boolean isSafe(int x, int y , int rows, int cols){
        return x >=0 && x < rows && y >= 0 && y < cols;
    }
    private static class Cell{
        int diff;
        int x;
        int y;

        Cell(int diff , int x,int y){
            this.diff = diff;
            this.x = x;
            this.y = y;
        }
    }
}
