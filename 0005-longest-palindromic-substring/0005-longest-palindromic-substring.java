class Solution{
    private static boolean isPalidrome(String str){
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(str.charAt(left)==str.charAt(right)){
                left++;
                right--;
                continue;
            }
            else{
           

                return false;
            }
           
        
        } 
        return true;
    }
    public String longestPalindrome(String s){
        String longest_palidrome = "";
        for(int i=0;i<s.length();i++)
        for(int j=i+1;j<=s.length();j++){
            String str1= s.substring(i,j);
            if(isPalidrome(str1) && str1.length()>longest_palidrome.length()){
                longest_palidrome = new String(str1);
            }

        }
        return longest_palidrome;
        
    }
}