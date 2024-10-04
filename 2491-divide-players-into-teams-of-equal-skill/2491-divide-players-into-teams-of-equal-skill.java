class Solution {
    public long dividePlayers(int[] arr) {
        Arrays.sort(arr);
        long a=arr[0]+arr[arr.length-1];
        long res=0;
        for(int i=0;i<(arr.length/2);i++){
            int b=arr[i]+arr[arr.length-i-1];
            if(b!=a){
                return -1;
            }
            res+=arr[i]*arr[arr.length-1-i];
        }
        return res;
    }
}