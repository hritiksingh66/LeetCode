// STORY POINTS 



class Solution {
    boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k){
        int n = s.length();

        int i = 0,j = 0;

        int count = 0;
        int maxV = 0;
        while(j<n){
            char ch = s.charAt(j);
            if(isVowel(ch)){
                count++;
            }

            if((j-i+1) == k){
                maxV = Math.max(maxV,count);
                if(isVowel(s.charAt(i))){
                    count--;
                }
                i++;
            }
            j++;
        }
        return maxV;
    }
}