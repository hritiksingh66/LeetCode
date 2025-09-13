class Solution {
    public int maxFreqSum(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        Set<Character> vowelSet = Set.of('a','e','i','o','u');
        int maxVow = 0 , maxCons = 0;

        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(vowelSet.contains(ch)){
                maxVow = Math.max(freq , maxVow);
            }else{
                if(freq > maxCons){
                    maxCons = freq;
                }
            }
        }

        return maxCons + maxVow;

    }
}