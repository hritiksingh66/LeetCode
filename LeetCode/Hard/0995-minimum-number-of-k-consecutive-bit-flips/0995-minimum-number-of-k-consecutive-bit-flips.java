class Solution {
    public int minKBitFlips(int[] nums, int k){
        int n = nums.length;

        int flips = 0;

        int flipCount = 0;

        Set<Integer> isFlipped = new HashSet<>();

        for(int i = 0 ; i < n ; i++){

            if(i >= k && isFlipped.contains(i-k)){
                flipCount--;
            }

            if(flipCount % 2 == nums[i]){ // flip
                if(i+k > n) return -1;
                flipCount++;
                flips += 1;
                isFlipped.add(i);
            }

        }

        return flips;
    }
}