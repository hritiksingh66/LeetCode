import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min-heap to store projects based on capital requirements
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Max-heap to store projects based on profit (negative profit for max-heap)
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        // Populate the min-heap with all projects
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }
        
        // Process up to k projects
        for (int i = 0; i < k; i++) {
            // Move all projects that can be started with current capital to the max-heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                int[] project = minCapitalHeap.poll();
                maxProfitHeap.offer(project);
            }
            
            // If no project can be started, break out of the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            
            // Select the most profitable project and add its profit to the current capital
            w += maxProfitHeap.poll()[1];
        }
        
        return w;
    }
}
