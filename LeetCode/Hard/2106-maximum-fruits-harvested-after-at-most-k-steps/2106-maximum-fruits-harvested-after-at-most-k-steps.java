class Solution {
    int[] pos;
    public int maxTotalFruits(int[][] fruits, int startPos, int k){
        int n = fruits.length;

        int[] preSum = new int[n];
        pos = new int[n];

        for(int i = 0 ; i < n ; i++){
            preSum[i] = fruits[i][1] + (i > 0 ? preSum[i-1] : 0);
            pos[i] = fruits[i][0];
        }

        int maxFruits = 0;


        for(int d = 0 ; d <= k/2 ; d++){
            // case 1 :- left then right
            int remain = k - 2*d;
            int i = startPos - d;
            int j = startPos + remain;

            int left = lowerBound(i);
            int right = upperBound(j)-1;

            if(left <= right){
                int total = preSum[right] - (left > 0 ? preSum[left-1] : 0);
                maxFruits = Math.max(maxFruits,total);
            }

            // case 2 :- Move right 'd' steps then pick 'remain' steps

            remain = k - 2*d;
            i = startPos - remain;
            j = startPos + d;

            left = lowerBound(i);
            right = upperBound(j)-1;

            if(left <= right){
                int total = preSum[right] - (left > 0 ? preSum[left-1] : 0);
                maxFruits = Math.max(maxFruits,total);
            }
            
        }

        return maxFruits;
        
    }

    int lowerBound(int target){
        int left = 0 , right = pos.length;

        while(left < right){
            int mid = left + (right - left)/2;

            if(pos[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }

    int upperBound(int target){
        int left = 0 , right = pos.length;

        while(left < right){
            int mid = left + (right - left)/2;

            if(pos[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}