import java.math.BigInteger;
class Solution {
    public int numDifferentIntegers(String word){
        StringBuilder sb = new StringBuilder();

        Set<BigInteger> set = new HashSet<>();

        for(char ch : word.toCharArray()){
            if(Character.isDigit(ch)){
                sb.append(ch);
            }else{
                if(sb.length() > 0){
                    set.add(new BigInteger(sb.toString()));
                    sb.setLength(0); // stringBuilder clear ho jayega is sey
                }
            }
        }

        // Last me ek baar aur check kar lenge sb me koi num hai kya
        if(sb.length() > 0){
            set.add(new BigInteger(sb.toString()));
        }
        
        return set.size();
    }
}