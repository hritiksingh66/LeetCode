class Solution {
    public boolean canBeEqual(int[] target, int[] arr){

        Map<Integer,Integer> mp = new HashMap<>();

        for(int ele : target){
            if(mp.containsKey(ele)){
                mp.put(ele,mp.get(ele)+1);
            }else{
                mp.put(ele , 1);
            }
        }

        for(int ele : arr){
            if(!mp.containsKey(ele)){
                return false;
            }else{
                mp.put(ele , mp.get(ele) - 1);
            }
        }
        return true;
    }
}