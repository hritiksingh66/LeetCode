class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes){
        int n = customers.length;
        
        int maxUnsatCust = 0; // in any window (consecutive) of size minutes
        
        int currUnsat = 0;
        
        for(int i = 0;i<minutes;i++){ // 0, 1, 2 minutes -1
            currUnsat += customers[i]*grumpy[i];
        }
        
        maxUnsatCust = currUnsat;
        int i = 0;
        int j = minutes;
        
        while(j<n){
            currUnsat += customers[j]*grumpy[j]; // new element in the window
            
            currUnsat -= customers[i]*grumpy[i];
            
            if(currUnsat>maxUnsatCust){
                maxUnsatCust = currUnsat;
            }
            
            i++;
            j++;   
        }
        
        i=0;      
        for(;i<n;i++){
            if(grumpy[i]==0)
            maxUnsatCust += customers[i];
        }
        
        return maxUnsatCust;
        
    }
}