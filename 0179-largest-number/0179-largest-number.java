class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++){

                String result1 = String.valueOf(nums[i]) + String.valueOf(nums[j]);
                String result2 = String.valueOf(nums[j]) + String.valueOf(nums[i]);

                if(Integer.parseInt(result2)>Integer.parseInt(result1)){

                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        String ans = "";

        for(int el : nums){

            ans = ans+String.valueOf(el);

        }

        return ans;

    }
}