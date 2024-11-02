class Solution {
    public boolean isCircularSentence(String sentence){

        String[] sent = sentence.split(" ");

        int n = sent.length;

        String firstWord = sent[0];

        String lastWord = sent[n-1];

        if(lastWord.charAt(lastWord.length() - 1) != firstWord.charAt(0)){
            return false;
        }
        
        for(int i = 0 ; i <= n-2 ; i++){
            if(sent[i].charAt(sent[i].length()-1) != sent[i+1].charAt(0))
                return false;
        }

        return true;

    }
}