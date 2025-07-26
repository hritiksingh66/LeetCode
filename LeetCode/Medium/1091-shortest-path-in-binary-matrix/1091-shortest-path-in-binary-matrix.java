class Solution {
    int[][] direction = {{1,1},{1,0},{0,1},{-1,0},{0,-1},{1,-1},{-1,1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(m == 0 || n == 0 || grid[0][0] != 0){
            return -1;
        }

        Queue<Pair> qu = new LinkedList<>();

        qu.add(new Pair(0,0));

        grid[0][0] = 1; // marked visit

        int count = 0;

        while(!qu.isEmpty()){
            int s = qu.size();

            while(s-- > 0){
                Pair u = qu.poll();
                int x = u.x;
                int y = u.y;

                if(x == n-1 && y == m-1){
                    return count + 1;
                }

                for(int[] dir : direction){
                    int x_next = x + dir[0];
                    int y_next = y + dir[1];

                    if(isSafe(x_next,y_next,m,n) && grid[x_next][y_next] == 0){
                        qu.add(new Pair(x_next,y_next));
                        grid[x_next][y_next] = 1;
                    }

                }

            }
            count++;
        }

        return -1;
        
    }

    public boolean isSafe(int x,int y,int m, int n){
        if(x < m && y < m && x >= 0 && y >= 0){
            return true;
        }
        return false;
    }
}

class Pair{
    int x;
    int y;
    Pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}