class Solution {
    private List<Integer> result = new ArrayList<>();

    public void solve(int n , int num,int count, int k){
        // Base Case
        if(num > n) return;

        // Execute it
        result.add(num);

        if( count == k){
            return;
        }

        solve(n , num*10 , count+1 , k);
        if(num%10 != 9){
            solve(n,num+1, count+1 , k);
        }

    }
      
    public int findKthNumber(int n, int k){

        solve(n,1,1,k);

        return result.get(k-1);
    }
}