// Approach-3 (Optimal - Heap + Math)
// T.C : O(nlogN + klogK +n* logk) - This is worst case when no one got eliminated 
// S.C : O(n+k)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] min_wage, int k) {
        int n = quality.length;

        double result = Double.MAX_VALUE; // maximum representable finite floating-point (double) number

        // Calculate the wage-to-quality ratio for each worker and store in a pair
        double[][] worker_ratio = new double[n][2];
        for (int worker = 0; worker < n; worker++) {
            worker_ratio[worker][0] = (double) min_wage[worker] / quality[worker];
            worker_ratio[worker][1] = quality[worker];
        }

        Arrays.sort(worker_ratio, (a, b) -> Double.compare(a[0], b[0]));  // O(nlogN)

        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        int quality_sum = 0;


        for(int i = 0 ; i < k; i++){ // O(klogK)
            pq.add(worker_ratio[i][1]);
            quality_sum += worker_ratio[i][1];

        }

        double managerRatio = worker_ratio[k-1][0];
        result = managerRatio * quality_sum;


        for (int manager = k ; manager < n; manager++){ // O(n * logK)

            managerRatio = worker_ratio[manager][0];

            pq.add(worker_ratio[manager][1]);
            quality_sum += worker_ratio[manager][1];

            if(pq.size() > k){ // O(logK)
                quality_sum -= pq.poll();
            }

            result = Math.min(result, managerRatio * quality_sum);
        }

        return result;
    }
}