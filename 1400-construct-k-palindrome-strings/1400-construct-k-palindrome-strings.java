class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int odds = 0;
        HashMap<Character, Integer> counts = new HashMap<>();
        for (Character c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (Character c : counts.keySet()) {
            if (counts.get(c) % 2 == 1) odds++;
        }
        if (odds > k) return false;
        return true;
    }
}