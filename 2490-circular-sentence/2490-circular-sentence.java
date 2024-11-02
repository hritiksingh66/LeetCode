class Solution {
    public boolean isCircularSentence(String sentence){

        String[] sent = sentence.split(" ");

        int n = sent.length;

        String firstWord = sent[0];

        if(n == 1 && firstWord.charAt(0) == firstWord.charAt(firstWord.length()-1)){
            return true;
        }
        String lastWord = sent[n-1];

        if(lastWord.charAt(lastWord.length() - 1) != firstWord.charAt(0)){
            return false;
        }
        

        for(int i = 0 ; i <= n-2 ; i++){
            String prevWord = sent[i];
            String nextWord = sent[i+1];

            if(prevWord.charAt(prevWord.length()-1) != nextWord.charAt(0)){
                return false;
            }
        }

        return true;

    }
}