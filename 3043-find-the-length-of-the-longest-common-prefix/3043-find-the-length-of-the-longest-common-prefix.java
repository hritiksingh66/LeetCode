import java.util.*;
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for(int elem : arr1){
            while(!set.contains(elem) && elem > 0){
                set.add(elem);
                elem /= 10;
            }
        }
        int result  = 0;
        for(int val : arr2){
            while(!set.contains(val) && val > 0){
                val /= 10;
            }
            if(val > 0){
                result = Math.max(result, (int)(Math.log10(val) + 1));
            }
        }
        return result;
    }
}