class Solution {
    public long minimumDifference(int[] nums){
        int n = nums.length;
        int k = n/3;

        long[] leftMinSum = new long[n];
        PriorityQueue<Integer> leftPq = new PriorityQueue<>((a,b) -> b-a);
        
        leftMinSum[0] = nums[0];
        leftPq.add(nums[0]);

        for(int i = 1 ; i < k ; i++){
            leftMinSum[i] = nums[i]+leftMinSum[i-1];
            leftPq.add(nums[i]);
        }

        for(int i = k ; i < 2*k ; i++){
            leftPq.add(nums[i]);
            if(leftPq.size() > k){
                leftMinSum[i] = leftMinSum[i-1] + nums[i] - leftPq.poll();
            }
        }

        System.out.println(Arrays.toString(leftMinSum));

        long[] rightMaxSum = new long[n];
        PriorityQueue<Integer> rightPq = new PriorityQueue<>();

        rightMaxSum[n-1] = nums[n-1];
        rightPq.add(nums[n-1]);

        for(int i = n-2 ; i >= n-k ; i--){
            rightMaxSum[i] = nums[i] + rightMaxSum[i+1];
            rightPq.add(nums[i]);
        }

        for(int i = n-k-1 ; i >= k ; i--){
            rightPq.add(nums[i]);
            if(rightPq.size() > k){
                rightMaxSum[i] = rightMaxSum[i+1] + nums[i] - rightPq.poll();
            }
        }
        System.out.println(Arrays.toString(rightMaxSum));

        long ans = Long.MAX_VALUE;

        for(int i = k-1 ; i < 2*k ; i++){
            long diff = (leftMinSum[i] - rightMaxSum[i+1]);
            ans = Math.min(diff,ans);
        }

        return ans;
        
    }
}