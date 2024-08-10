class Solution {

    boolean isMagicGrid(int[][] grid ,int r ,int c){
        //unique 1-9 hona chahiye aur saare distinct hone chahiye
        Map<Integer , Integer> mp = new HashMap<>();
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                int num = grid[r+i][c+j];
                if(num < 1 || num > 9 || mp.containsKey(num)){
                    return false;
                }else{
                    mp.put(num, mp.getOrDefault(num, 0) + 1);
                }
            }
        }


        //Sum Check Karenge ab
        int SUM = grid[r][c] + grid[r][c+1] + grid[r][c+2];

        for(int i = 0 ; i < 3 ; i++){
            //RowSum check karte hain
            if(grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2] != SUM){
                return false;
            }

            //ColSum check karte hain
            if(grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i] != SUM){
                return false;
            }

            //MainDiagSum check karte hain
            if(grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != SUM){
                return false;
            }

            //AntiDiagSum check karte hain
            if(grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != SUM){
                return false;
            }
        }

        return true;
    }
    public int numMagicSquaresInside(int[][] grid){
        int rows = grid.length;
        int cols = grid.length;

        int count = 0;

        for(int i = 0 ; i <= rows-3; i++){
            for(int j = 0 ; j <= cols-3 ; j++){
                if(isMagicGrid(grid , i , j)){
                    count++;
                }
            }
        }
        return count;
    }
}