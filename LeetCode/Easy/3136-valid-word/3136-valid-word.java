class Solution {
    public boolean isValid(String s) {
        boolean atLeastOneConsonant = false;

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if ("aeiou".indexOf(lower) == -1) {
                    atLeastOneConsonant = true;
                    break;
                }
            }
        }

        boolean atLeastOneVowel = false;

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if ("aeiou".indexOf(lower) != -1) {
                    atLeastOneVowel = true;
                    break;
                }
            }
        }

        return atLeastOneConsonant && atLeastOneVowel && (s.length() > 2) && s.matches("[0-9a-zA-Z]+");

    }
}