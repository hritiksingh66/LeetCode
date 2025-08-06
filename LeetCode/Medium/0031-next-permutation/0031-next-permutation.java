class Solution {
    public void nextPermutation(int[] nums){
        int n = nums.length;
        boolean flag = false;
        int idx = -1;
        for(int i = n -1 ; i > 0 ; i--){
            if(nums[i] > nums[i-1]){
                idx = i-1;
                break;
            }
        }

        if(idx != -1){
            int swap_idx = idx;
            for(int j = n - 1; j >= idx + 1 ; j--){
                if(nums[j] > nums[idx]){
                    swap_idx = j;
                    break;
                }
            }

            int a = nums[idx];
            nums[idx] = nums[swap_idx];
            nums[swap_idx] = a;
        }

        reverse(nums,idx + 1, n-1);
    }

    void reverse(int[] nums, int start, int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }
}