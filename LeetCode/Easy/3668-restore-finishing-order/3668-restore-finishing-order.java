class Solution {
    public int[] recoverOrder(int[] order, int[] friends){
        // int n = order.length;
        int m = friends.length;


        Set<Integer> set = new HashSet<>();

        for(int num : friends){
            set.add(num);
        }

        int[] res = new int[m];
        int pos = 0;

        for(int ord : order){
            if(set.contains(ord)){
                res[pos++] = ord;
            }
        }

        return res;
        
    }
}