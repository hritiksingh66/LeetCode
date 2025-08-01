class Solution {
    public int findKthPositive(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;
        while( high >= low){
            int mid = low + (high-low)/2;
            if(arr[mid] - (mid+1) >= k){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low + k;
    }
}