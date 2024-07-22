class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        HashMap<Integer , String> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.put(heights[i] , names[i]);
        }

        ArrayList<Integer> alheight = new ArrayList<>(map.keySet());
        alheight.sort(Collections.reverseOrder());

        String[] result = new String[n];
        for(int j = 0 ; j < n ; j++){
            result[j] = map.get(alheight.get(j));
        }

        return result;
    }
}