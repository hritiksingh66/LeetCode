class Solution {
    public int scoreOfString(String s){
        int n = s.length();
        
        char[] ch = s.toCharArray();
        
        int ans = 0;
        for(int i=0;i<n-1;i++){
            ans+=Math.abs((int)ch[i]-(int)ch[i+1]);
        }
        return ans;
    }       
}