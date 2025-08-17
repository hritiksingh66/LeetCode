class Solution {
    public boolean canMakeArithmeticProgression(int[] arr){
        int n = arr.length;
        Set<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : arr){
            min = Math.min(num,min);
            max = Math.max(num,max);
            set.add(num);
        }

        int diff = max - min;
        if(diff % (n-1) != 0){
            return false;
        }

        int cd = diff / (n-1);

        int i = 0;
        while(i < n){
            int num = min + i * cd;
            if(!set.contains(num)){
                return false;
            }
            i++;
        }

        return true;
    }
}