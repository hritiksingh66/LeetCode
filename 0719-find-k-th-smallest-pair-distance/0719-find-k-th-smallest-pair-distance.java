import java.util.*;
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0 ; i < nums.length -1; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                maxHeap.offer(Math.abs(nums[j]-nums[i]));
                if(maxHeap.size() > k){
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek();
    }
}