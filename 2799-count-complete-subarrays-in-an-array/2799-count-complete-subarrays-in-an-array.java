class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int totalDistinct = set.size();

        Map<Integer, Integer> map = new HashMap<>();

        int j = 0;
        int i = 0;

        int n = nums.length;

        int ans = 0;

        while (j < n) {

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() == totalDistinct) {
                ans += (n - j);
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;

            }

            j++;
        }

        return ans;

    }
}