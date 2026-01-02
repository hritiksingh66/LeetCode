class Solution {
    public int repeatedNTimes(int[] nums){
        Set<Integer> unique = new HashSet<>();
        for(int num : nums){
            if(unique.contains(num)){
                return num;
            }else{
                unique.add(num);
            }
        }
        return 0;
    }
}