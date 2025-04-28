class Solution {
    public int countSubarrays(int[] nums) {
        int result = 0;

        int j = 3;

        int first = nums[0];
        int second = nums[1];
        int third = nums[2];

        if ((first + third) * 2==second)
            result++;

        while (j < nums.length) {
            first = second;
            second = third;
            third = nums[j++];
            if ((first + third)*2==second)
                result++;
        }

        return result;

    }
}