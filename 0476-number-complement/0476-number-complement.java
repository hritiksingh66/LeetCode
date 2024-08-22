class Solution {
    public int findComplement(int num) {
        // Create a mask with all bits set to 1 that has the same length as num
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        
        // XOR the number with the mask to get the complement
        return num ^ mask;
    }
}
