class Solution {
    public int[] recoverOrder(int[] order, int[] friends){
        int m = friends.length;
        int[] res = new int[m];

        Set<Integer> set = new HashSet<>();

        for(int num : friends){
            set.add(num);
        }

        int pos = 0;

        for(int ord : order){
            if(set.contains(ord)){
                res[pos++] = ord;
            }
        }

        return res; 
    }
}