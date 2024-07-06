class Solution {
    public int passThePillow(int n, int time){
        int fullRounds = time / (n-1);
        int timeLeft = time % (n-1);

        if(fullRounds%2!=0){
            return n-timeLeft;
        }
        return timeLeft+1; 
    }
}