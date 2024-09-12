class Solution {
    public int countConsistentStrings(String allowed, String[] words){

        Map<Character,Integer> mp = new HashMap<>();

        char[] ch = allowed.toCharArray();

        for(char chrs : ch ){
            mp.putIfAbsent(chrs,1);
        }

        int ans = 0;

        for(String str : words){

            char[] chh = str.toCharArray();

            int i = 0;

            for( ;i < chh.length ; i++){
                if(!mp.containsKey(chh[i])){
                    break;
                }
            }

            if(i == chh.length){
                ans++;
            }
        }
        
        return ans;
    }
}