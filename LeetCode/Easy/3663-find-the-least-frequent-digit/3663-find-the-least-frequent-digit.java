class Solution {
    public int getLeastFrequentDigit(int n) {
        Map<Integer, Integer> mp = new HashMap<>();

        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            mp.put(digit, mp.getOrDefault(digit, 0) + 1);
            temp /= 10;
        }

        // Initialize ans with the first digit in the map
        int ans = -1;
        for (int key : mp.keySet()) {
            ans = key;
            break;
        }

        for (int key : mp.keySet()) {
            if (mp.get(key) < mp.get(ans)) {
                ans = key;
            } else if (mp.get(key).equals(mp.get(ans))) {
                ans = Math.min(ans, key);
            }
        }

        return ans;
    }

    // public static void main(String[] args) {
    //     Solution s = new Solution();
    //     System.out.println(s.getLeastFrequentDigit(122333)); // ➝ 1
    //     System.out.println(s.getLeastFrequentDigit(9876677)); // ➝ 8
    //     System.out.println(s.getLeastFrequentDigit(1002003)); // ➝ 1
    // }
}
