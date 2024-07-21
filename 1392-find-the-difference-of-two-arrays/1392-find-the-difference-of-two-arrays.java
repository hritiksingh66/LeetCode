class Solution {
    List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<> (); //contains elements only in nums1
        
        Set<Integer> s2 = new HashSet<> (); //contains all elements present in nums2
        for (int num : nums2) {
            s2.add(num);    //adding elements of nums2 to s2
        }
        
        for (int num : nums1) {
            if (!s2.contains(num)) {
                s1.add(num);
            }
        }
        
        // Convert set to ArrayList.
        return new ArrayList<>(s1);
    }
    
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getElementsOnlyInFirstList(nums1, nums2),
                             getElementsOnlyInFirstList(nums2, nums1));
    }
}