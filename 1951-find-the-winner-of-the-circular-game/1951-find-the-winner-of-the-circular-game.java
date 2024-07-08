class Solution {
    public int findTheWinner(int n, int k){
        ArrayList<Integer> arr_new = new ArrayList<Integer>();
        int p = 0;

        for(int i = 1 ; i <= n ; i++){
            arr_new.add(i);
        }

        int i = 0;
        while(arr_new.size() > 1){
            int idx = (i+k-1)%arr_new.size();

            arr_new.remove(idx) ;

            i = idx;

        }
        return arr_new.get(0);
    }
}