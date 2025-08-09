class Solution {
    int n;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        solve(0, list);

        return ans;
    }

    void solve(int idx, List<Integer> list) {
        if (idx == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < n; i++) {
            Collections.swap(list,i,idx);
            solve(idx+1,list);
            Collections.swap(list,idx,i);
        }
    }
}