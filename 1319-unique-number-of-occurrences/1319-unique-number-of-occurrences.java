class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
       
        for (int num : arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // Check if the number of occurrences is unique
        Set<Integer> uniqueCounts = new HashSet<>(occurrences.values());
        return occurrences.size() == uniqueCounts.size();
    }
}