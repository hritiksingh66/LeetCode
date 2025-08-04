class Solution {
    public int romanToInt(String s){
        Map<Character,Integer> mp = new HashMap<>();

        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);

        int result = 0;
        int n = s.length();

        for(int i = 0 ; i < n - 1; i++){
            char ch_i = s.charAt(i); 
            char ch_next = s.charAt(i+1); 
            if(mp.get(ch_i) < mp.get(ch_next)){
                result -= mp.get(ch_i);
            }else{
                result += mp.get(ch_i);
            }
        }

        result += mp.get(s.charAt(n-1));

        return result;
    }
}