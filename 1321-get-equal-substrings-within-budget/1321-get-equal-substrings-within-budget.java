class Solution {
    public int equalSubstring(String s, String t, int maxCost){

        int n = s.length();

        int i = 0 , j = 0;
        int currCost = 0;
        int maxLen = 0;


        // How Many times each char is being visited
        // each character in s is visited atmost twice 
        // once by j and once by i pointer

        while(j < n){
            currCost += Math.abs((int)s.charAt(j) - (int)t.charAt(j));

            while(currCost > maxCost){
                currCost -= Math.abs((int)s.charAt(i) - (int)t.charAt(i));
                i++; // shrinking window from left to right
            }

            maxLen = Math.max(maxLen , (j-i+1));
            j++;
        }

        return maxLen;
    }
}