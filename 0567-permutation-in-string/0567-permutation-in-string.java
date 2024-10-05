class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1len=s1.length();
        if(s1.length()>s2.length())return false;
        int[] s1charmap=new int[26];
        int[] s2charmap=new int[26];
        int l=0;
        int r=0;
        for(char c:s1.toCharArray()){
            s1charmap[c-'a']++;
        }
        while(r<s2.length()){
            s2charmap[s2.charAt(r)-'a']++;
            if(Arrays.equals(s1charmap, s2charmap))return true;
            r++;
            if(r-l+1>s1len){
                s2charmap[s2.charAt(l)-'a']--;
                l++;
            }
        }
        return false;
    }
}