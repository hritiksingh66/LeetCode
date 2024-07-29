class Solution {
    public int numTeams(int[] rating){
        int n = rating.length;
        int resultTeam = 0;


        for(int j = 1 ; j < n-1 ; j++){
            int countLargerLeft = 0;
            int countSmallerLeft = 0;

            for(int i = 0; i < j ; i++){

                if(rating[i] > rating[j]){
                    countLargerLeft++;
                }
                if(rating[i] < rating[j]){
                    countSmallerLeft++;
                }
            }

            int countSmallerRight = 0;    
            int countLargerRight = 0; 

            for(int k = j+1; k < n ; k++){

                if(rating[k] > rating[j]){
                    countLargerRight++;
                }
                if(rating[k] < rating[j]){
                    countSmallerRight++;
                }

            }

            resultTeam += countSmallerLeft * countLargerRight;
            resultTeam += countLargerLeft * countSmallerRight;
        }

        return resultTeam;
    }
}