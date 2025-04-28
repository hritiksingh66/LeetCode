class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Frequency array to store count of remainders (0 to k-1)
        int[] freq = new int[k];
        
        // Initially freq[0] = 1 kyunki empty subarray ka remainder 0 hota hai
        freq[0] = 1;
        
        int cumSum = 0, result = 0; // cumSum = cumulative sum, result = final answer
        
        for (int num : nums) {
            cumSum += num; // Ab tak ke elements ka cumulative sum le rahe hain
            
            int rem = cumSum % k; // Cumulative sum ka remainder nikal rahe hain
            
            // Agar remainder negative aa gaya to usko positive bana rahe hain
            if (rem < 0) rem += k;
            
            // Jo bhi remainder ab tak aaya hai, uska count add kar rahe hain result me
            result += freq[rem];
            
            // Ab current remainder ka frequency badha rahe hain
            freq[rem]++;
        }
        
        // Last me final result return karenge
        return result;
    }
}
