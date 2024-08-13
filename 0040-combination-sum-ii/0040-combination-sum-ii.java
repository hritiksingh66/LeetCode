class Solution {
    public void print(int[] nums,int target,int idx,List<Integer> ls,List<List<Integer>> ans){
        if(target<0) return;
        if(target==0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=idx;i<nums.length;i++){

            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            ls.add(nums[i]);
            print(nums,target-nums[i],i+1,ls,ans);
            ls.remove(ls.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        print(candidates,target,0,ls,ans);
        return ans;

    }
}