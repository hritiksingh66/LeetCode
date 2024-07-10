class Solution {
    public int minOperations(String[] logs){
        int depth = 0;

        for(String log : logs){
            System.out.println(log.equals("../"));
            if(log.equals("../")){
                depth = Math.max(0,depth-1);
            }else if(log.equals("./")){
                continue;
            }else{
                depth++;
            }
        }
        
        return depth;
    }
}