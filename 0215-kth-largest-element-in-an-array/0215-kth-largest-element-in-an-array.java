class Solution {
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //
        for(int i = 0 ; i < k; i++){  // (K log(n))
            pq.add(nums[i]);
        }
        for(int i = k ; i < nums.length ; i++){ // (n-k)O(log N)
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}