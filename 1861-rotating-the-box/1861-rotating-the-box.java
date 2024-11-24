class Solution {
    public char[][] rotateTheBox(char[][] box){
        int m = box.length;
        int n = box[0].length;

        char[][] res = new char[n][m];

        for(int i  = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                res[j][i] = box[i][j];
            }
        }

        for(char[] ch : res){
            char temp;
            for (int i = 0; i < m / 2; i++) {
                temp = ch[i];
                ch[i] = ch[m - i - 1];
                ch[m - i - 1] = temp;
            }
        }

        for(int col = 0 ; col < m ; col++){
            int spaceBottomRow = n-1;
            for(int row = n-1 ; row >= 0 ; row--){
                if(res[row][col] == '*'){
                    spaceBottomRow = row - 1;
                    continue;
                }

                if(res[row][col] == '#'){
                    res[row][col] = '.';
                    res[spaceBottomRow][col] = '#';
                    spaceBottomRow--;
                }
            }
        }

        return res;
    }
}