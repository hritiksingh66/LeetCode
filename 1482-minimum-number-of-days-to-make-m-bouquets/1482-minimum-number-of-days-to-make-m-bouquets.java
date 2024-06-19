class Solution {
    
    public int canMakeMBouq(int[] bloomDay,int mid, int k){
        int bouqCount = 0;
        int consecutive_count = 0;
        for(int i = 0; i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                consecutive_count++;
            }else{
                consecutive_count=0;
            }
            
            if(consecutive_count == k){
                bouqCount++;
                consecutive_count=0;
            }
        }
        
        return bouqCount;
    }
    
    public int minDays(int[] bloomDay, int m, int k){
        int n = bloomDay.length;
        
        int start_day = 0;
        int end_day = bloomDay[0];
        for(int i=0; i<bloomDay.length; i++){
            if(end_day < bloomDay[i])
                end_day = bloomDay[i];
        }
        
        int minDays = -1;
        
        while(start_day<=end_day){
            int mid = start_day + (end_day - start_day)/2;
            
            if(canMakeMBouq(bloomDay,mid,k) >= m){
                minDays = mid;
                end_day = mid-1;
            }else{
                start_day =mid+1;
            }
        }
        
        return minDays;
    }
}