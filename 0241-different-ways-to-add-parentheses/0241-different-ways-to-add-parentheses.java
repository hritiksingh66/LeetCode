class Solution {

    public List<Integer> solve(String s) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '+' || currentChar == '-' || currentChar == '*') {
                List<Integer> left_res = solve(s.substring(0, i));
                List<Integer> right_res = solve(s.substring(i + 1));

                for (int x : left_res) {
                    for (int y : right_res) {
                        if (currentChar == '+') {
                            result.add(x + y);
                        } else if (currentChar == '-') {
                            result.add(x - y);
                        } else if (currentChar == '*') {
                            result.add(x * y);
                        }
                    }
                }
            }
        }

        // Base case: if no operators are found, it's just a number
        if (result.size() == 0) {
            result.add(Integer.parseInt(s)); // Fixed typo
        }

        return result;
    }

    public List<Integer> diffWaysToCompute(String s) {
        return solve(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "2*3-4*5";
        List<Integer> result = solution.diffWaysToCompute(input);
        System.out.println(result);
    }
}
