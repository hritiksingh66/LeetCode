class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int m, int k){
        int n = nums.size();

        for(int i = 0 ; i<n;i++){
            if(nums.get(i) % m == k){
                nums.set(i,1);
            }else{
                nums.set(i,0);
            }
        }

        Map<Integer , Long> map = new HashMap<>();
        int cumSum = 0; // cumSum will be qual to count of those elements % m == k

        long result = 0;

        map.put(0,1l);

        for(int i = 0 ; i < n ; i++){
            cumSum += nums.get(i);

            int r1 = cumSum % m;

            int r2 = (r1 - k + m) % m;
            if(map.containsKey(r2)){
                result += map.get(r2);
            }


            map.put(r1,map.getOrDefault(r1,0l)+1l);
        }

        return result;
    }
}