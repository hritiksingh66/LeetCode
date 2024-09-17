class Solution {
    public String[] findRelativeRanks(int[] score){
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i = 0 ; i < score.length ; i++){
            mp.put(score[i],i);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2) {
                return n2 - n1;
            }
        });

        for(int el : score){
            priorityQueue.add(el);
        }

        int i = 1;

        String[] ans = new String[score.length];

        while(!priorityQueue.isEmpty()){
            int idx = mp.get(priorityQueue.poll());
            
            if(i==1){
                ans[idx] = "Gold Medal";
                i++;
            }else if(i==2){
                ans[idx] = "Silver Medal"; 
                i++;
            }else if(i==3){
                ans[idx] = "Bronze Medal"; 
                i++;
            }else{
                ans[idx] = Integer.toString(i);
                i++;
            }
        }

        return ans;
 
    }
}