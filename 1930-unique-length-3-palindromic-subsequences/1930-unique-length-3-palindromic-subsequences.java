class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int pre[][] = new int[n][26];
        int suff[][] = new int[n][26];

        pre[0][s.charAt(0)-'a']++;

        for(int i=1; i<n; i++){
            char ch = s.charAt(i);
          //  pre[i] = pre[i-1];
            for(int j=0; j<26; j++){
                pre[i][j] = pre[i-1][j];
            }
            pre[i][ch-'a'] = pre[i-1][ch-'a']+1;
        }

        suff[n-1][s.charAt(n-1)-'a']++;

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<26; j++){
                suff[i][j] = suff[i+1][j];
            }
            char ch = s.charAt(i);
            suff[i][ch-'a'] = suff[i+1][ch-'a']+1;
        }

        HashSet<String> hp = new HashSet<>();
        for(int i=1; i<n-1; i++){
            boolean leftSame = false;
            boolean rightSame = false;
            char ch = s.charAt(i);

            if(pre[i-1][ch-'a']>0) leftSame = true;
            if(suff[i+1][ch-'a']>0) rightSame = true;

            if(leftSame && rightSame) hp.add(""+ch+ch+ch);

            for(int j=0; j<26; j++){
                if(pre[i-1][j]>0 && suff[i+1][j]>0){
                    char x = (char)(j+'a');
                    hp.add(""+x+ch+x);
                }
            }
        }
        return hp.size();
    }
}