class Solution {
    int[][] DIRECTION = {{1,0},{0,-1},{-1,0},{0,1}};
    public int minimumEffortPath(int[][] heights){
        int rows = heights.length;
        int cols = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.diff - b.diff);

        int[][] res = new int[rows][cols];

        for(int[] arr : res){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        pq.add(new Pair(0,new InnerPair(0,0)));
        res[0][0] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            int diff = p.diff;
            int x = p.cord.x;
            int y = p.cord.y;

            // if(x == row - 1 && y == cols -1){
            //     return res[x][y];
            // }

            for(int[] dir : DIRECTION){
                int nx = x+dir[0];
                int ny = y+dir[1];


                if(isSafe(nx,ny,rows,cols)){
                    int maxAbsDiff = Math.max(diff,Math.abs(heights[nx][ny]-heights[x][y]));
                    if(maxAbsDiff < res[nx][ny]){
                        res[nx][ny] = maxAbsDiff;
                        pq.add(new Pair(res[nx][ny],new InnerPair(nx,ny)));
                    }
                }
            }
        }

        return res[rows-1][cols-1];        
    }

    public boolean isSafe(int x, int y , int rows, int cols){
        return x >=0 && x < rows && y >= 0 && y < cols;
    }
}

class Pair{
    int diff;
    InnerPair cord;

    Pair(int diff , InnerPair cord){
        this.diff = diff;
        this.cord = cord;
    }
}

class InnerPair{
    int x;
    int y;

    InnerPair(int x, int y){
        this.x = x;
        this.y = y;
    }
}