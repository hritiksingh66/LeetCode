class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int n = nums.size();

        int slot[] = new int[n]; // all index point to 0

        int res[] = {-1000000,1000000};

        while(true){//m

            int minEle = Integer.MAX_VALUE;

            int maxEle = Integer.MIN_VALUE;

            int minLatestIdx = 0;

            for(int i = 0 ; i < n ; i++){//traverse all list and find the smalest and largest element
            
                int List_idx = i;//store curr_list index

                int ele_idx = slot[i];//list index's element index

                int ele = nums.get(List_idx).get(ele_idx);

                if(ele < minEle){// that element is smalest element

                    minEle = ele;

                    minLatestIdx = List_idx;
                    
                }

                maxEle = Math.max(maxEle,ele);

            }

            //update res
            if(maxEle - minEle < res[1] - res[0]){

                res[0] = minEle; res[1] = maxEle;
            }

            //update nextele 

            int next_idx = slot[minLatestIdx] + 1;

            if(next_idx >= nums.get(minLatestIdx).size()){

                break;

            }

            slot[minLatestIdx] = next_idx;
        }

        return res;
    }
}