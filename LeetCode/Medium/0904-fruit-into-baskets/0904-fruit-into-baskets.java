class Solution {
    public int totalFruit(int[] fruits) {
        int result = 0;
        int n = fruits.length;

        int i = 0;
        int j = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        while (j < n) {
            mp.put(fruits[j], mp.getOrDefault(fruits[j], 0) + 1);

            while(mp.size() > 2){
                mp.put(fruits[i], mp.get(fruits[i])-1);
                if (mp.get(fruits[i]) == 0) {
                    mp.remove(fruits[i]);
                }
                i++;
            }

            result = Math.max(j - i + 1, result);

            j++;
        }

        return result;

    }
}