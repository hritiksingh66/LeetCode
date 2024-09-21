class Solution {
    public  List<Integer> ls = new ArrayList<>();
    public void lexical(int n,int num){
        // Base Case
        if(num>n){
            return;
        }

        // Execute
        ls.add(num);
        lexical(n,num*10);
        if(num%10!=9){
            lexical(n,num+1);
        }
    }
    public  List<Integer> lexicalOrder(int n){
        lexical(n,1);
        return ls;
    }
}