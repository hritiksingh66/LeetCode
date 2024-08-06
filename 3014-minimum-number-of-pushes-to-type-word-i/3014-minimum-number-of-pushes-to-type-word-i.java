class Solution {
    public int minimumPushes(String word){
        int result = 0;

        Map<Integer , Integer> mp = new HashMap<>();
        int assignKey = 2;

        for(int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            if(assignKey > 9){
                assignKey = 2;
            }


            if(mp.containsKey(assignKey)){
                mp.put(assignKey,mp.get(assignKey)+1);
            }else{
                mp.put(assignKey , 1);
            }

            result += mp.get(assignKey);

            assignKey++;
        }

        return result;
    }
}