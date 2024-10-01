class Solution {
    public boolean canArrange(int[] arr, int k) {
       if(arr.length %2 != 0) return false;
       int ans[] = new int[k];
       for(int i = 0;  i < arr.length ; i++){
            ans[(arr[i]%k +k)%k]++;
       }
       if(ans[0]%2 != 0) return false;
       for(int i = 1 ; i < k ; i++){
            if(ans[i] != ans[k-i]){
                return false;
            }
       }
       return true;
    }
}