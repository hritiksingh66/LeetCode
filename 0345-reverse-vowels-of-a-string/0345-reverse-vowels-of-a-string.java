class Solution {
    public String reverseVowels(String s){
        
        int n = s.length();
        
        char[] chr = s.toCharArray();
        
        int i = 0;
        int j = n-1;
        
        while(i<j){
            if((chr[i]=='a' || chr[i]=='e' || chr[i]=='i' ||chr[i]=='o'|| chr[i]=='u' || chr[i]=='A' || chr[i]=='E' || chr[i]=='I' ||chr[i]=='O'|| chr[i]=='U') && (chr[j]=='a' || chr[j]=='e' || chr[j]=='i' ||chr[j]=='o'|| chr[j]=='u' || chr[j]=='A' || chr[j]=='E' || chr[j]=='I' ||chr[j]=='O'|| chr[j]=='U')) {
                char ch = chr[i];
                chr[i]=chr[j];
                chr[j] = ch;
                i++;
                j--;
                continue;
            }
            else if(!(chr[j]=='a' || chr[j]=='e' || chr[j]=='i' ||chr[j]=='o'|| chr[j]=='u' || chr[j]=='A' || chr[j]=='E' || chr[j]=='I' ||chr[j]=='O'|| chr[j]=='U')){
                j--;
                continue;
            }
            else if(!(chr[i]=='a' || chr[i]=='e' || chr[i]=='i' ||chr[i]=='o'|| chr[i]=='u' || chr[i]=='A' || chr[i]=='E' || chr[i]=='I' ||chr[i]=='O'|| chr[i]=='U')){
                i++;
                continue;
            }
            else{
                i++;
                j--;
                continue;
            }
        }
        
        return new String(chr);
        
    }
}