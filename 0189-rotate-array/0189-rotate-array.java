class Solution {
    private void solve(int[] nums,int low,int high){
        while(low <= high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[] nums, int k){
        int n = nums.length;
        k = k%n;
        // if(n==1) return;
        solve(nums,0,n-k-1);
        solve(nums,n-k,n-1);
        solve(nums,0,n-1);
    }
}