class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {

        ArrayList<Integer> answer= new ArrayList<>();
        int m= matrix.length;
        int n= matrix[0].length;

        int topRow = 0; 
        int bottomRow = m - 1; 
        int leftCol = 0; 
        int rightCol =  n- 1;
        int totalElements = 0;
        while (totalElements < m*n) {

            for (int j = leftCol; j <= rightCol && totalElements < m*n ; j++) {
                answer.add(matrix[topRow][j]);
                totalElements++;
            }
            topRow++;

            for (int i = topRow; i <= bottomRow && totalElements < m*n; i++) {
                answer.add(matrix[i][rightCol]);
                totalElements++;
            }
            rightCol--;

            for (int j = rightCol; j >= leftCol && totalElements < m*n; j--) {
                answer.add(matrix[bottomRow][j]);
                totalElements++;
            }
            bottomRow--;

            for (int i = bottomRow; i >= topRow && totalElements < m*n; i--) {
                answer.add(matrix[i][leftCol]);
                totalElements++;
            }
            leftCol++;
        }
        return answer;
        
    }
}