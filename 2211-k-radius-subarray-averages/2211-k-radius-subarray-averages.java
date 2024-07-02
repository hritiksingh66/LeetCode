class Solution {
    public int[] getAverages(int[] nums, int k){
        int n = nums.length;

        if(k==0){
            return nums;
        }

        int[] result = new int[n];
        Arrays.fill(result , -1);

        if(n < 2*k+1){
            return result;
        }

        long windowSum = 0;
        int left = 0;
        int right = 2*k;
        int i = k;

        for(int j = left; j <= right; j++){
            windowSum += nums[j];

        }

        int count = 2*k+1;
        result[i] = (int)(windowSum/(count));
        i++;

        right++;

        while(right < n){
            int out_of_window = nums[left];
            int came_to_window = nums[right];

            windowSum = windowSum + came_to_window - out_of_window;

            result[i] = (int)(windowSum/(count));

            i++;
            right++;
            left++;
        }

        return result;
    }
}