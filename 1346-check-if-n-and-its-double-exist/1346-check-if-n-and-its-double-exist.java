class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0; i<n; i++) hash.put(arr[i]*2,i);
        for(int i=0; i<n; i++){
            if(hash.containsKey(arr[i]) && i!=hash.get(arr[i])) 
                return true;
        }
        return false;
    }
}