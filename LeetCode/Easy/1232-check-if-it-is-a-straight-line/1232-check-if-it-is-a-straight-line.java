class Solution {
    public boolean checkStraightLine(int[][] coordinates){
        int n = coordinates.length;

        int delX = coordinates[1][0] - coordinates[0][0];
        int delY = coordinates[1][1] - coordinates[0][1];


        for(int i = 2 ; i < n ; i++){
            int currDelx = coordinates[i][0] - coordinates[0][0];
            int currDely = coordinates[i][1] - coordinates[0][1];

            if(delY * currDelx != delX*currDely){
                return false;
            }
        }

        return true;
    }
}