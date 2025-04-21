class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[nums1.length];
        int idx = 0 ;
        for (int num : nums2) {
            if(map.containsKey(num) && map.get(num) > 0){
                result[idx++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return Arrays.copyOf(result , idx);
    }
}