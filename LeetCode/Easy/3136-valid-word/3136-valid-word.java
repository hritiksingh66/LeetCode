class Solution {
    public boolean isValid(String s) {
        if(s.length()<3) return false;
        boolean atLeastOneConsonant = false;
        boolean atLeastOneVowel = false;
        for (char c : s.toCharArray()) {
            char lower = Character.toLowerCase(c);
            if(!Character.isDigit(c) && !Character.isLetter(c)) return false;
            if(Character.isLetter(lower)){
                if ("aeiou".indexOf(lower) == -1) {
                    atLeastOneConsonant = true;
                }else{
                    atLeastOneVowel = true;
                }
            }
        }
        return atLeastOneVowel && atLeastOneConsonant;
    }
}