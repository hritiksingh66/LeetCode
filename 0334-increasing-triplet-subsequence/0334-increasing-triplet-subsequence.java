class Solution {
    public boolean increasingTriplet(int[] nums){

        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        for(int num3 : nums){
            if(num3 <= num1){
                num1 = num3;
                continue;
            }else if(num3 <= num2){
                num2 = num3;
                continue;
            }else{
                return true;
            }
        }
        return false;
    }
}