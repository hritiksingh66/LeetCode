class Solution {
    public double averageWaitingTime(int[][] customers){
        int n = customers.length;

        double waitingTime = 0;
        int currTime = customers[0][0];

        for(int i = 0 ; i < n ; i++){
            int cookTime = customers[i][1];
            int arrivalTime = customers[i][0];
            if(arrivalTime > currTime){
                currTime = arrivalTime;
            }
            waitingTime += ((currTime + cookTime) - arrivalTime);
            currTime += cookTime; 
        }

        double result = waitingTime/n;

        return result;
        
    }
}