class Solution {
    public boolean threeConsecutiveOdds(int[] arr){

        int n = arr.length;

        int count = 0;
        int i = 0;

        while(i<n){
            if(arr[i]%2!=0){
                count++;
            }else{
                count=0;
            }
            if(count==3){
                return true;
            }
            i++;
        }
        return count==3;
    }
}