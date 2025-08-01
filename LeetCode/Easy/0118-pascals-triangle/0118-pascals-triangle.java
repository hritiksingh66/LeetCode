class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(List.of(1)));
        if(numRows == 1) return ans;

        for(int i = 1 ; i < numRows ; i++){
            List<Integer> list = new ArrayList<>();

            for(int j = 0  ; j < i+1 ; j++){
                if(j == 0 ||j == i){
                    list.add(1);
                }else{
                    int a = ans.get(i-1).get(j-1);
                    int b = ans.get(i-1).get(j);
                    int num = a + b;
                    list.add(num);
                }
            }

            ans.add(list);
        }

        return ans;
    }
}