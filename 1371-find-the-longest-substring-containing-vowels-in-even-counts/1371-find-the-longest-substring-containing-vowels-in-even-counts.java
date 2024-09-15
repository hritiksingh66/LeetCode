class Solution {
    public int findTheLongestSubstring(String s){

        Map<Integer,Integer> mp = new HashMap<>();

        int result = 0;
        int mask = 0;

        mp.put(mask,-1);

        for(int i = 0 ; i < s.length() ; i++){

            if(s.charAt(i)=='a'){
                mask = mask ^ (1<<0);
            }else if(s.charAt(i)=='e'){
                mask = mask ^ (1<<1);
            }else if(s.charAt(i)=='i'){
                mask = mask ^ (1<<2);
            }else if(s.charAt(i)=='o'){
                mask = mask ^ (1<<3);
            }else if(s.charAt(i)=='u'){
                mask = mask ^ (1<<4);
            }


            if(mp.containsKey(mask)){
                result = Math.max(result,i-mp.get(mask));
            }else{
                mp.put(mask,i);
            }
        }

        return result;
    }
}