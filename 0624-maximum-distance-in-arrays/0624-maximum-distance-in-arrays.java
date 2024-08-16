class Solution {
    public int maxDistance(List<List<Integer>> arrays) {

        int minEle = arrays.get(0).get(0);
        int maxEle = arrays.get(0).get(arrays.get(0).size() - 1);

        int result = 0;

        for (int i = 1; i < arrays.size(); i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);

            result = Math.max(result, Math.max(Math.abs(currMin - maxEle), Math.abs(currMax - minEle)));

            // Update maxEle and minEle correctly
            maxEle = Math.max(maxEle, currMax);
            minEle = Math.min(minEle, currMin);  // Corrected here
        }

        return result;
    }
}
