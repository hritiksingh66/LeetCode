class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets){
        boolean[] used = new boolean[baskets.length];

        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;
                    break;
                }
            }
        }

        int res = 0;
        for (boolean f : used) {
            if (!f) res++;
        }

        return res;
    }
}
