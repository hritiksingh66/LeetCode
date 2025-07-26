class Solution {
    int[][] DIRECTION = {{1,1},{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid){
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }

        int[][] result = new int[n][n];

        for(int[] res: result){
            Arrays.fill(res,Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);

        pq.add(new Pair(1,new InnerPair(0,0)));
        grid[0][0] = 1; // mark visit
        result[0][0] = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int dist = curr.dist;

            InnerPair ip = curr.cord;
            int x = ip.x;
            int y = ip.y;


            for(int[] dir : DIRECTION){
                int x_next = x + dir[0];
                int y_next = y + dir[1];

                if(isSafe(x_next,y_next, n) && grid[x_next][y_next] == 0){
                    if(dist + 1 < result[x_next][y_next]){
                        result[x_next][y_next] = dist + 1;
                        pq.add(new Pair(result[x_next][y_next],new InnerPair(x_next,y_next)));
                        grid[x_next][y_next] = 1; // mark visited as it added in pq
                    }
                }
            }
        }

        if(result[n-1][n-1] == Integer.MAX_VALUE){
            return -1;
        }

        return result[n-1][n-1];
    }

    public boolean isSafe(int x, int y, int n){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}

class Pair{
    int dist;
    InnerPair cord;

    Pair(int dist, InnerPair cord){
        this.dist = dist;
        this.cord = cord;
    }
}

class InnerPair{
    int x;
    int y;

    InnerPair(int x,int y){
        this.x = x;
        this.y = y;
    }
}