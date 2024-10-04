class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[][] dup = new int[arr.length][2];

        for(int i = 0; i < arr.length; i++) {
            dup[i][0] = arr[i];
            dup[i][1] = i;
        }

        Arrays.sort(dup, (a, b) -> a[0] - b[0]);

        int[] ans = new int[arr.length];

        int rank = 0;

        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                ans[dup[0][1]] = ++rank;
                continue;
            }

            if(dup[i][0] == dup[i - 1][0]) ans[dup[i][1]] = rank;
            else ans[dup[i][1]] = ++rank;
        }

        return ans;
    }
}