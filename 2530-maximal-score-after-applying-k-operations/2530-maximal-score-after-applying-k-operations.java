class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums){
            maxHeap.add(num);
        }

        while(k-- > 0){
            int maxEl = maxHeap.peek();

            maxHeap.poll();

            sum += maxEl;

            maxEl =(int) Math.ceil(maxEl/3.0);

            maxHeap.add(maxEl);
        }

        return sum;
    }
}