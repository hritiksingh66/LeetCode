class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
    (a, b) -> Double.compare(b.delta, a.delta)
);

        for(int i = 0 ; i < n ; i++){
            double currPR = (double) classes[i][0] / classes[i][1];
            double newPR = (double) (classes[i][0]+1) / (classes[i][1] + 1);

            double delta = newPR - currPR;

            pq.add(new Pair(delta,i));
        }


        while(extraStudents-- > 0){
            Pair curr = pq.poll();

            double delta = curr.delta;
            int idx  = curr.idx;

            classes[idx][0]++;
            classes[idx][1]++;

            double currPR = (double) classes[idx][0] / classes[idx][1];

            double newPR = (double) (classes[idx][0]+1) / (classes[idx][1] + 1);

            double newDelta = newPR - currPR;

            pq.add(new Pair(newDelta , idx));
        }

        double res = 0.0;

        for(int i = 0 ; i <  n ; i++){
            res += (double) classes[i][0] / classes[i][1];
        }

        return res/n;
    }

    class Pair{
        double delta;
        int idx;

        Pair(double delta , int idx){
            this.delta = delta;
            this.idx = idx;
        }
    }
}