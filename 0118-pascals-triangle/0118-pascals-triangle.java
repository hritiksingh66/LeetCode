class Solution {
    public List<Integer> generateList(int row) {
        List<Integer> list = new ArrayList<>();
        int ans = 1;
        list.add(1);
        for (int i = 1; i < row; i++) {
            ans = ans * (row - i);
            ans = ans / i;
            list.add(ans);
        }

        return list;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= numRows; row++) {
            List<Integer> temp = generateList(row);
            ans.add(temp);
        }

        return ans;

    }
}