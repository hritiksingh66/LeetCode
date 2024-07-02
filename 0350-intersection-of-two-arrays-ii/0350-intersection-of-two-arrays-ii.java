class Solution {
    public int[] intersect(int[] nums1, int[] nums2){

        Map<Integer , Integer> mp = new HashMap<>();

        for(int i : nums1){
            if(mp.containsKey(i)){
                mp.put(i,mp.get(i)+1);
            }else{
                mp.put(i,1);
            }
        }

        ArrayList<Integer> ls = new ArrayList<>();

        for(int val : nums2){
            if(mp.containsKey(val) && mp.get(val)>0){
                ls.add(val);
                mp.put(val,mp.get(val)-1);
            }
            continue;
        }

        int[] ans = new int[ls.size()];

        for(int i = 0 ; i < ls.size() ; i++){
            ans[i] = ls.get(i);
        }

        return ans;
        
    }
}