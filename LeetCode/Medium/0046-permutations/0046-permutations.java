class Solution{
    int n;
    Set<Integer> set = new HashSet<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        n = nums.length;

        List<Integer> temp = new ArrayList<>();

        solve(temp,nums);

        return ans;
    }

    void solve(List<Integer> temp, int[] nums){

        if(temp.size() == n){
            ans.add(new ArrayList<>(temp));
            return;
        }


        for(int i = 0 ; i < n ; i++){

            if(!set.contains(nums[i])){

                temp.add(nums[i]);
                set.add(nums[i]);
                solve(temp,nums);
                temp.remove(temp.size()-1);
                set.remove(nums[i]);
            }
        }
    }
}