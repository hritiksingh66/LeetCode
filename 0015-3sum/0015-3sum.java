class Solution{
    static List<List<Integer>> ans = new ArrayList<>();
    void twoSum(int[] nums, int target, int i, int j){
        while(i<j){
            if(nums[i]+nums[j]>target){
                j--;
            }
            else if(nums[i]+nums[j]<target){
                i++;
            }else{
                //First we will remove duplicates from either end(i, j)
                while(i<j && nums[i]==nums[i+1]) i++;
                
                while(i<j && nums[j]==nums[j-1]) j--;
                
                ans.add(new ArrayList<>(List.of(-target, nums[i] , nums[j])));
                
                i++;
                j--;
            }
        }
        return;
    }
    
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        
        if(n<3){
            return new ArrayList<>();
        }
        
        ans.clear();
        
        Arrays.sort(nums);
        
        // fixing one element n1 as target 
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int n1 = nums[i];
            int target = -n1;
            twoSum(nums,target,i+1,n-1); // It will find n2 and n3 : {n1, n2, n3}
        }
        return ans;  
    }
}