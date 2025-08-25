class Solution {
    public int[] findDiagonalOrder(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        LinkedHashMap<Integer,List<Integer>> mp = new LinkedHashMap<>();

        for(int i = 0 ; i < m+n-1; i++){
            mp.put(i , new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                mp.get(i+j).add(mat[i][j]);
            }
        }


        boolean flag = false;
        int pos = 0;
        int[] ans = new int[m*n];

        for(List<Integer> li : mp.values()){
            System.out.println(li);
            if(!flag){
                for(int el : li){
                    ans[pos++] = el;
                }
                flag = !flag; 
            }else{
                Collections.reverse(li);
                for(int el : li){
                    ans[pos++] = el;
                }
                flag = !flag; 
            }
        }


        return ans;
        
    }
}