class Solution {
    public String pushDominoes(String str){
        int n = str.length();

        int[] LeftClosestR = new int[n];

        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if(ch == 'R'){
                LeftClosestR[i] = i;
            }else if(ch == '.'){
                LeftClosestR[i] = i > 0 ? LeftClosestR[i-1] : -1;
            }else {
                LeftClosestR[i] = -1;
            }
        }

        int[] RightClosestL = new int[n];

        for(int i = n-1; i >= 0; i--){
            char ch = str.charAt(i);
            if(ch == 'L'){
                RightClosestL[i] = i;
            }else if(ch == '.'){
                RightClosestL[i] = i < n-1 ? RightClosestL[i+1] : -1;
            }else {
                RightClosestL[i] = -1;
            }
        }

        String result = "";

        for(int i = 0 ; i < n ; i++){
            int distLeftR = Math.abs(i - LeftClosestR[i]);
            int distRightL = Math.abs(i - RightClosestL[i]);

            if(LeftClosestR[i] == RightClosestL[i]){
                result += ".";
            }else if(LeftClosestR[i] == -1){
                result += "L";
            }else if(RightClosestL[i] == -1){
                result += "R";
            }else if(distLeftR == distRightL){
                result += ".";
            }else{
                result += (distLeftR < distRightL) ? "R" : "L";
            }
        }
        
        return result;
    }
}