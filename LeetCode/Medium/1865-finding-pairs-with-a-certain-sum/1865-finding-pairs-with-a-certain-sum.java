class FindSumPairs {
    int[] arr1;
    int[] arr2;
    Map<Integer,Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2){
        arr1 = nums1;
        arr2 = nums2;
        for(int el : arr2){
            map.put(el,map.getOrDefault(el,0)+1);
        }   
    }
    
    public void add(int index, int val){
        map.put(arr2[index],map.get(arr2[index])-1);
        arr2[index] += val;
        map.put(arr2[index],map.getOrDefault(arr2[index],0)+1);
    }
    
    public int count(int target){
        int result = 0;
        for(int num : arr1){
            if(map.containsKey(target-num)){
                result += map.get(target-num);
            }
        }
        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */