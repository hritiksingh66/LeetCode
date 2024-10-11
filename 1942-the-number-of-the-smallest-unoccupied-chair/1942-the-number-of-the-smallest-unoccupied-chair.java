class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int chairs = 0;
        int target = times[targetFriend][0];
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> available = new PriorityQueue<>();
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < times.length; i++) {
            int[] curr = times[i];
            while (!occupied.isEmpty() && occupied.peek()[0] <= curr[0]) {
                available.add(occupied.peek()[1]);
                occupied.poll();
            }
            
            int getChair = !available.isEmpty() ? available.poll() : chairs++;
            if (curr[0] == target)
                return getChair;
            occupied.add(new int[] { curr[1], getChair });
        }
        return -1;
    }
}